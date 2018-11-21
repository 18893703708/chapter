package com.huyun.web.schedule.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;


public class GoodAddTimer extends QuartzJobBean {

    static Logger logger = LoggerFactory.getLogger(GoodAddTimer.class);

    /**
     * 定时任务逻辑实现方法
     * 每当触发器触发时会执行该方法逻辑
     * @param context
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("商品添加完成后执行任务，任务时间：{}",new Date());
    }
}
