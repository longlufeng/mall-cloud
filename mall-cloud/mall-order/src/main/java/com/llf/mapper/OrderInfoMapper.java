package com.llf.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.llf.dto.OrderInfoQryDto;
import com.llf.po.OrderInfoPo;

@Mapper
public interface OrderInfoMapper {
	
	void add(OrderInfoPo orderInfoPo);
	
	void upd(OrderInfoPo orderInfoPo);
	
	OrderInfoPo qryById(@Param("orderId") String orderId);
	
	List<OrderInfoPo> qryList(OrderInfoQryDto orderInfoQryDto);

}
