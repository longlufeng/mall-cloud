package com.llf.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.llf.po.InventoryPo;

@Mapper
public interface InventoryMapper {
	
	void add(InventoryPo inventoryPo);
	
	void upd(InventoryPo inventoryPo);
	
	InventoryPo qry(InventoryPo inventoryPo);

}
