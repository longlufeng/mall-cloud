package com.llf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llf.dto.OrderInfoAddDto;
import com.llf.dto.OrderInfoQryDto;
import com.llf.dto.OrderInfoUpdDto;
import com.llf.service.OrderInfoService;
import com.llf.utils.ResultPackage;
import com.llf.vo.OrderInfoVo;


@RestController
@RequestMapping("/order")
public class OrderInfoController {
	
	@Autowired
	OrderInfoService orderInfoService;
	
	@RequestMapping("/add")
	public ResultPackage<Object> add(@RequestBody OrderInfoAddDto orderInfoAddDto,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		orderInfoAddDto.setUserId(session.getAttribute("userId").toString());
		
		orderInfoService.add(orderInfoAddDto);
		
		return ResultPackage.success();
	}
	
	@RequestMapping("/upd")
	public ResultPackage<Object> upd(@RequestBody OrderInfoUpdDto orderInfoUpdDto){
		
		orderInfoService.upd(orderInfoUpdDto);
		
		return ResultPackage.success();
	}
	
	@RequestMapping("/qryById")
	public ResultPackage<?> qryById(@RequestBody OrderInfoQryDto orderInfoQryDto){
		
		OrderInfoVo orderInfoVo = orderInfoService.qryById(orderInfoQryDto);
		
		return ResultPackage.success(orderInfoVo);
	}
	
	@RequestMapping("/qryList")
	public ResultPackage<?> qryList(@RequestBody OrderInfoQryDto orderInfoQryDto,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		orderInfoQryDto.setUserId(session.getAttribute("userId").toString());
		List<OrderInfoVo> resList = orderInfoService.qryList(orderInfoQryDto);
		
		return ResultPackage.success(resList);
	}
	
}
