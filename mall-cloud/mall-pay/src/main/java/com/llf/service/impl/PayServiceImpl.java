package com.llf.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.llf.client.OrderClient;
import com.llf.client.dto.OrderInfoUpdDto;
import com.llf.dto.PayInfoDto;
import com.llf.mapper.PayMapper;
import com.llf.po.MerchantAcctPo;
import com.llf.po.UserAcctPo;
import com.llf.service.PayService;

@Service("payService")
public class PayServiceImpl implements PayService{
	
	@Autowired
	PayMapper payMapper;
	
	@Autowired
	OrderClient orderClient;
	
	@Transactional(rollbackFor = {RuntimeException.class,Exception.class})
	public void transfer(PayInfoDto payInfoDto) {
		
		// 转出
		transferOut(payInfoDto);
		
		// 转入
		transferIn(payInfoDto);
		
		// 更新订单状态
		OrderInfoUpdDto orderInfoUpdDto = new OrderInfoUpdDto();
		orderInfoUpdDto.setOrderId(payInfoDto.getOrderId());
		orderInfoUpdDto.setStatus(payInfoDto.getStatus());
		orderClient.upd(orderInfoUpdDto);
		
	}
	
	@Transactional(rollbackFor = {RuntimeException.class,Exception.class})
	private void transferOut(PayInfoDto payInfoDto) {
		UserAcctPo userAcctPo = new UserAcctPo();
		String userId = payInfoDto.getUserId();
		userAcctPo.setUserId(userId);
		
		UserAcctPo userQry = payMapper.qryUserAcct(userAcctPo);
		userAcctPo.setAcctNo(userQry.getAcctNo());
		String userQryBal = userQry.getBal();
		BigDecimal tranAmt = new BigDecimal(payInfoDto.getNumber()).multiply(new BigDecimal(payInfoDto.getPrice())); 
		String userBal = String.valueOf(new BigDecimal(userQryBal).subtract(tranAmt));
		userAcctPo.setBal(userBal);
		payMapper.updUserAcct(userAcctPo);
	}
	
	@Transactional(rollbackFor = {RuntimeException.class,Exception.class})
	private void transferIn(PayInfoDto payInfoDto) {
		MerchantAcctPo merchantAcctPo = new MerchantAcctPo();
		merchantAcctPo.setMerchantId(payInfoDto.getMerchantId());
		MerchantAcctPo merchantQry = payMapper.qryMerchantAcct(merchantAcctPo);
		merchantAcctPo.setAcctNo(merchantQry.getAcctNo());
		String merchantQryBal = merchantQry.getBal();
		BigDecimal tranAmt = new BigDecimal(payInfoDto.getNumber()).multiply(new BigDecimal(payInfoDto.getPrice())); 
		String mercahntBal = String.valueOf(new BigDecimal(merchantQryBal).add(tranAmt));
		merchantAcctPo.setBal(mercahntBal);
		
		payMapper.updMerchanrAcct(merchantAcctPo);
	}

}
