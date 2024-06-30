package com.llf.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoVo {
	
	private String orderId;
	private String commodityId;
	private String commodityName;
	private String merchantId;
	private String merchantName;
	private String number;
	private String price;
	private String status;
	private String statusDesc;
	private String deleteFlag;
	private String createDate;
	private String createTime;
	private String updateDate;
	private String updateTime;
	
}
