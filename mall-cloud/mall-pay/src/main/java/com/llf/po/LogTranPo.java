package com.llf.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogTranPo {
	
	private String merchantId;
	private String acctNo;
	private String bal;

}
