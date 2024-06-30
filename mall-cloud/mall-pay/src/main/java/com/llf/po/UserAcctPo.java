package com.llf.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAcctPo {
	
	private String userId;
	private String acctNo;
	private String pwd;
	private String bal;

}
