package com.xxy.module_debug.feature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by xiongxiaoyu
 * Data:2019/6/18
 * Time:15:47
 */


@Component
public class ScheduledTest {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTest.class);

	@Scheduled(cron="0/5 * 6-23 * * ?")
	public void executeFileDownLoadTask() {

		Thread current = Thread.currentThread();
		System.out.println("定时任务1:"+current.getId());
		logger.info("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName());
	}

}
