package com.llf.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;

public class GenerateStrUtil {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	
	public static String generateMercahntId() {
	
		return String.valueOf(RandomUtils.nextInt(new Random(), 99999));
		
	}
	
	public static String generateOrderId() {
		
		return "order"+sdf.format(new Date());
		
	}
	
	public static void main(String[] args) {
		System.out.println(sdf.format(new Date()));
	}

}
