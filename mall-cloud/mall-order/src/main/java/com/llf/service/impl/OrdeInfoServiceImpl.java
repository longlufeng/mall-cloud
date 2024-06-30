package com.llf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.llf.dto.OrderInfoAddDto;
import com.llf.dto.OrderInfoQryDto;
import com.llf.dto.OrderInfoUpdDto;
import com.llf.enums.OrderStatus;
import com.llf.mapper.OrderInfoMapper;
import com.llf.po.OrderInfoPo;
import com.llf.service.OrderInfoService;
import com.llf.utils.DateUtil;
import com.llf.utils.GenerateStrUtil;
import com.llf.vo.OrderInfoVo;

@Service("OrderInfoService")
public class OrdeInfoServiceImpl implements OrderInfoService{
	
	@Autowired
	OrderInfoMapper orderInfoMapper;
	
	public void add(OrderInfoAddDto orderInfoAddDto) {
		
		OrderInfoPo orderInfoPo = new OrderInfoPo();
		
		orderInfoPo.setOrderId(GenerateStrUtil.generateOrderId());
		
		orderInfoPo.setUserId(orderInfoAddDto.getUserId());
		orderInfoPo.setCommodityId(orderInfoAddDto.getCommodityId());
		orderInfoPo.setCommodityName(orderInfoAddDto.getCommodityName());
		orderInfoPo.setMerchantId(orderInfoAddDto.getMerchantId());
		orderInfoPo.setMerchantName(orderInfoAddDto.getMerchantName());
		orderInfoPo.setNumber(orderInfoAddDto.getNumber() == null ? "1" : orderInfoAddDto.getNumber());
		orderInfoPo.setPrice(orderInfoAddDto.getPrice());
		orderInfoPo.setCreateDate(DateUtil.getCurDate());
		orderInfoPo.setCreateTime(DateUtil.getCurDateTime());
		
		orderInfoMapper.add(orderInfoPo);
		
	}

	public void upd(OrderInfoUpdDto orderInfoUpdDto) {
		
		OrderInfoPo orderInfoPo = new OrderInfoPo();
		orderInfoPo.setOrderId(orderInfoUpdDto.getOrderId());
		orderInfoPo.setStatus(orderInfoUpdDto.getStatus());
		orderInfoPo.setUpdateDate(DateUtil.getCurDate());
		orderInfoPo.setUpdateTime(DateUtil.getCurDateTime());
		
		orderInfoMapper.upd(orderInfoPo);
		
	}

	public OrderInfoVo qryById(OrderInfoQryDto orderInfoQryDto) {
		
		OrderInfoPo orderInfoPo = orderInfoMapper.qryById(orderInfoQryDto.getOrderId());
		if(orderInfoPo == null) {
			return null;
		}
		
		OrderInfoVo orderInfoVo = new OrderInfoVo();
		BeanUtils.copyProperties(orderInfoPo, orderInfoVo);
		
		return orderInfoVo;
	}

	public List<OrderInfoVo> qryList(OrderInfoQryDto orderInfoQryDto) {
		
		List<OrderInfoPo> poList = orderInfoMapper.qryList(orderInfoQryDto);
		if(poList == null || poList.size() == 0) {
			return new ArrayList<OrderInfoVo>();
		}
		
		List<OrderInfoVo> voList = new ArrayList<OrderInfoVo>();
		for(OrderInfoPo po : poList) {
			OrderInfoVo vo = new OrderInfoVo();
			BeanUtils.copyProperties(po, vo);
			vo.setStatusDesc(OrderStatus.getStatusByCode(vo.getStatus()).getMsg());
			voList.add(vo);
		}
		
		return voList;
	}

	

}
