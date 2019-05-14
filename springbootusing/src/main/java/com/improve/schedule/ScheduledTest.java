package com.improve.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling //启用定时任务
public class ScheduledTest {
	
	private final Logger logger=LoggerFactory.getLogger(getClass());
	
	@Scheduled(cron="0/5 * * * * ? ")
	public void timeTest()
	{
//		logger.error("当前时间"+System.currentTimeMillis());
	}
}