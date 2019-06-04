package com.example.demo.common;

import lombok.Data;

@Data
public class HttpResp {
	
	
	
	
	private String code;  // 状态码 100200错误   100300正确
	
	
	private String msg;  // 相应的提示信息
	
	
	private Object content;  // 内容
	
	
	
	

}
