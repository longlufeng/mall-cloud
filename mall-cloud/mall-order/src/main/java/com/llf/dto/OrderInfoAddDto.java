package com.llf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoAddDto {
	
	private String userId;
	private String commodityId;
	private String commodityName;
	private String merchantId;
	private String merchantName;
	private String number;
	private String price;

}
