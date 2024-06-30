package com.llf.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.llf.po.MerchantAcctPo;
import com.llf.po.UserAcctPo;

@Mapper
public interface PayMapper {
	
	void updUserAcct(UserAcctPo userAcctPo);
	
	void updMerchanrAcct(MerchantAcctPo merchantAcctPo);
	
	UserAcctPo qryUserAcct(UserAcctPo userAcctPo);
	
	MerchantAcctPo qryMerchantAcct(MerchantAcctPo merchantAcctPo);

}
