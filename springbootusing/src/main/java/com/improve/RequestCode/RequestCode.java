package com.improve.RequestCode;

import java.util.HashMap;
import java.util.Map;


public class RequestCode {
	
	private Map<String,Object> map;
	
	
	public Map<String,Object> getRequestCode()
	{
		map=new HashMap<String,Object>();
		map.put("200", "ok");
		map.put("10011","passwd error");
		map.put("10012","passwd right");
		return map;
	}
	
}
