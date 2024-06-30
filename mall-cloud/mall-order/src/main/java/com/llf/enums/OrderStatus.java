package com.llf.enums;

public enum OrderStatus {
	CREATE("0", "下单"),
	PAYED("1", "已支付"),
	CANCE("2", "取消"),
	FINISH("3", "完成");
	
	private String code;
	private String msg;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	private OrderStatus(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public static OrderStatus getStatusByCode(String code) {
		OrderStatus[] values = OrderStatus.values();
        for (OrderStatus value : values) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        return null;
    }
}
