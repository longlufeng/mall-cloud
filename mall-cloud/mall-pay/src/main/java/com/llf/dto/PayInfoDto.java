package com.llf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayInfoDto {
	
	private String userId;
	private String orderId;
	private String status;
	private String userAcct;
	private String merchantId;
	private String merchantAcct;
	private String number;
	private String price;

}
