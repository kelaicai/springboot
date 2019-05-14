package com.improve.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/*")
public class SystemController {
    // 第二种方式
    @Autowired // 注入到容器中
    private Environment environment;


    // 以整数的形式获取到配置文件里面的配置信息
//    @Value("${local.port}")
//    private Integer localPort_2;

    // 以默认值的形式赋予值
    // @Value默认必须要有配置项，配置项可以为空，但是必须要有，如果没有配置项，则可以给默认值
//    @Value("${tomcat.port:9090}")
//    private Integer tomcatPort;

    /**
     * 获取到配置文件的配置
     */
    public void getIp() {
        System.out.println("local.ip = " + environment.getProperty("local.ip"));
    }
    
    @GetMapping("/info")
    public Map<String,Object> info()
    {
    	Map<String,Object> info=new HashMap<String,Object>();
    	info.put("ip",environment.getProperty("local.ip"));
    	info.put("port",environment.getProperty("local.port", Integer.class));
    	info.put("SpringBoot",environment.getProperty("springBoot"));
    	info.put("SpringBoot",environment.getProperty("Application.springBoot"));
		return info;
    	
    	
    }
    
    @GetMapping("/backup")
    public Map<String,Object> backup()
    {
    	Map<String,Object> result=new HashMap<String,Object>();
    		String filePath="E:\\device_data_backup";
    		String dbName = "device_manage";
    		String command="cmd  /c  mysqldump -u root -psdf136749 "+dbName+" > "+filePath+"/"+dbName+new java.util.Date().getTime()+".sql";
    		try
    		{
    			Process process=Runtime.getRuntime().exec(command);
    			result.put("status", "success");
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    			result.put("status", "failed");
    		}
    	return result;
    }



    /**
     * 以整数的形式获取到配置文件里面的配置信息
     */
//    public void getPort_2() {
//        System.out.println("local.port = " + environment.getProperty("local.port", Integer.class));
//        System.out.println("local.port = " + localPort_2);
//    }

    /**
     * 获取到配置文件里面引用配置文件里面的配置信息 配置文件里面变量的引用操作
     */
    public void getSpringBootName() {
        System.out.println("Spring is " + environment.getProperty("springBoot"));
        System.out.println("SpringBoot " + environment.getProperty("Application.springBoot"));
    }

    /**
     * 以默认值的形式赋予配置文件的值
     */
//    public void getTomcatPort() {
//        System.out.println("tomcat port is " + tomcatPort);
//    }
}
