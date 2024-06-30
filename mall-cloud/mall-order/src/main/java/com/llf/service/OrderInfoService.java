package com.llf.service;

import java.util.List;

import com.llf.dto.OrderInfoAddDto;
import com.llf.dto.OrderInfoQryDto;
import com.llf.dto.OrderInfoUpdDto;
import com.llf.vo.OrderInfoVo;

public interface OrderInfoService {
	
	void add(OrderInfoAddDto orderInfoAddDto);
	
	void upd(OrderInfoUpdDto orderInfoUpdDto);
	
	OrderInfoVo qryById(OrderInfoQryDto orderInfoQryDto);
	
	List<OrderInfoVo> qryList(OrderInfoQryDto orderInfoQryDto);

}
