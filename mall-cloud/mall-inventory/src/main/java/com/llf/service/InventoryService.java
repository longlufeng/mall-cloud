package com.llf.service;

import com.llf.dto.InventoryDto;
import com.llf.vo.InventoryVo;

public interface InventoryService {
	
	/**
	 * 添加库存记录
	 * @param inventoryDto
	 */
	void addInventory(InventoryDto inventoryDto);
	
	/**
	 * 修改库存记录
	 * @param inventoryDto
	 */
	void updInventory(InventoryDto inventoryDto);
	
	/**
	 * 添加库存记录
	 * @param inventoryDto
	 */
	InventoryVo qryInventory(InventoryDto inventoryDto);

}
