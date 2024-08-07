package com.llf.utils;


import com.llf.enums.ResultCodeEnum;

import lombok.Data;

/**
* 全局统一返回结果类
*/
@Data
public class Result<T> {

   private Integer code;

   private String msg;

   private T data;

   public Result(){}

   protected static <T> Result<T> build(T data) {
       Result<T> result = new Result<T>();
       if (data != null)
           result.setData(data);
       return result;
   }

   public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum) {
       Result<T> result = build(body);
       result.setCode(resultCodeEnum.getCode());
       result.setMsg(resultCodeEnum.getMessage());
       return result;
   }

   public static <T> Result<T> build(Integer code, String message) {
       Result<T> result = build(null);
       result.setCode(code);
       result.setMsg(message);
       return result;
   }

   public static<T> Result<T> ok(){
       return Result.ok(null);
   }

   /**
    * 操作成功
    * @param data
    * @param <T>
    * @return
    */
   public static<T> Result<T> ok(T data){
       return build(data, ResultCodeEnum.SUCCESS);
   }

   public static<T> Result<T> fail(){
       return Result.fail(null);
   }

   /**
    * 操作失败
    * @param data
    * @param <T>
    * @return
    */
   public static<T> Result<T> fail(T data){
       return build(data, ResultCodeEnum.FAIL);
   }

	public Result<T> message(String msg) {
		this.setMsg(msg);
		return this;
	}

   public Result<T> code(Integer code){
       this.setCode(code);
       return this;
   }

   public boolean isOk() {
       if(this.getCode().intValue() == ResultCodeEnum.SUCCESS.getCode().intValue()) {
           return true;
       }
       return false;
   }
}
 
