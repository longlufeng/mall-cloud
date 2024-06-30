package com.llf.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llf.date.DateUtil;
import com.llf.dto.InventoryDto;
import com.llf.mapper.InventoryMapper;
import com.llf.po.InventoryPo;
import com.llf.service.InventoryService;
import com.llf.vo.InventoryVo;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	InventoryMapper inventoryMapper;
	
	@Override
	public void addInventory(InventoryDto inventoryDto) {
		
		InventoryPo inventoryPo = new InventoryPo();
		inventoryPo.setMerchantId(inventoryDto.getMerchantId());
		inventoryPo.setComodityId(inventoryDto.getComodityId());
		inventoryPo.setNumber(inventoryDto.getNumber());
		inventoryPo.setCreateDate(DateUtil.getCurDate());
		inventoryPo.setCreateTime(DateUtil.getCurDateTime());
		
		inventoryMapper.add(inventoryPo);

	}

	@Override
	public void updInventory(InventoryDto inventoryDto) {
		
		InventoryPo inventoryPo = new InventoryPo();
		inventoryPo.setMerchantId(inventoryDto.getMerchantId());
		inventoryPo.setComodityId(inventoryDto.getComodityId());
		inventoryPo.setNumber(inventoryDto.getNumber());
		inventoryPo.setUpdateDate(DateUtil.getCurDate());
		inventoryPo.setUpdateTime(DateUtil.getCurDateTime());
		
		inventoryMapper.upd(inventoryPo);

	}

	@Override
	public InventoryVo qryInventory(InventoryDto inventoryDto) {
		
		InventoryPo inventoryPo = new InventoryPo();
		inventoryPo.setMerchantId(inventoryDto.getMerchantId());
		inventoryPo.setComodityId(inventoryDto.getComodityId());
		InventoryPo resInventoryPo = inventoryMapper.qry(inventoryPo);
		if(resInventoryPo == null) {
			return null;
		}
		
		InventoryVo inventoryVo = new InventoryVo();
		BeanUtils.copyProperties(resInventoryPo, inventoryVo);
		
		return inventoryVo;
	}

}
