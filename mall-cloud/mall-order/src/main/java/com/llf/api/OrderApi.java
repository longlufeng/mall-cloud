package com.llf.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llf.dto.OrderInfoUpdDto;
import com.llf.service.OrderInfoService;
import com.llf.utils.ResultPackage;

@RestController
@RequestMapping("/order")
public class OrderApi {
	
	@Autowired
	OrderInfoService orderInfoService;
	
	@RequestMapping("/updOrderInfo")
	public ResultPackage<?> upd(@RequestBody OrderInfoUpdDto orderInfoUpdDto){
		
		orderInfoService.upd(orderInfoUpdDto);
		
		return ResultPackage.success();
	}

}
