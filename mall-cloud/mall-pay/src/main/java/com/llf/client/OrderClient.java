package com.llf.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.llf.client.dto.OrderInfoUpdDto;
import com.llf.utils.ResultPackage;

@FeignClient("order")
public interface OrderClient {
	
	@RequestMapping("/order/updOrderInfo")
	public ResultPackage<?> upd(OrderInfoUpdDto orderInfoUpdDto);
}
