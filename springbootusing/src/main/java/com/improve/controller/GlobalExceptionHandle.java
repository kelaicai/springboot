package com.improve.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice
//public class GlobalExceptionHandle {
//	@ExceptionHandler(RuntimeException.class)
//	@ResponseBody
//	public Map<String, Object> reusltError() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("errorCode", "500");
//		map.put("errorMsg", "ϵ�y����!");
//		return map;
//	}
//
//	
//
//}
