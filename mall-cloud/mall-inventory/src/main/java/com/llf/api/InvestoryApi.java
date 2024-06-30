package com.llf.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llf.dto.InventoryDto;
import com.llf.service.InventoryService;
import com.llf.vo.InventoryVo;

@RestController
@RequestMapping("/api/inventory")
public class InvestoryApi {
	
	@Autowired
	InventoryService inventoryService;
	
	
	@RequestMapping("/qryInventory")
	public InventoryVo qryInventory(@RequestBody InventoryDto inventoryDto){
		
		return inventoryService.qryInventory(inventoryDto);
	}
	
	
}
