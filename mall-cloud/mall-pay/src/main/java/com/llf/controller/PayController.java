package com.llf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llf.dto.PayInfoDto;
import com.llf.service.PayService;
import com.llf.utils.ResultPackage;

@RestController
@RequestMapping("/pay")
public class PayController {
	
	@Autowired
	PayService payService;
	
	@RequestMapping("/transfer")
	public ResultPackage<?> transfer(@RequestBody PayInfoDto payInfoDto,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		payInfoDto.setUserId(session.getAttribute("userId").toString());
		
		payService.transfer(payInfoDto);
		
		return ResultPackage.success();
		
	}

}
