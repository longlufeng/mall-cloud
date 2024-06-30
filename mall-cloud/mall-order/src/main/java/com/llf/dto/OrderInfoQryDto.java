package com.llf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoQryDto {
	
	private String userId;
	private String orderId;
	private String commodityId;
	private String merchantId;
	private String status;
	private String startDate;
	private String endDate;

}
