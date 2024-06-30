package com.llf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llf.dto.InventoryDto;
import com.llf.service.InventoryService;
import com.llf.utils.Result;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	@RequestMapping("/addInventory")
	public Result<?> addInventory(@RequestBody InventoryDto inventoryDto) {
		
		inventoryService.addInventory(inventoryDto);
		
		return Result.success();
		
	}
	
	@RequestMapping("/updInventory")
	public Result<?> updInventory(@RequestBody InventoryDto inventoryDto) {
		
		inventoryService.updInventory(inventoryDto);
		
		return Result.success();
		
	}
	
	@RequestMapping("/qryInventory")
	public Result<?> qryInventory(@RequestBody InventoryDto inventoryDto) {
		
		return Result.success(inventoryService.qryInventory(inventoryDto));
		
	}

}
