package com.huyun.web.schedule.util;

import com.huyun.web.schedule.job.GoodAddTimer;
import com.huyun.web.schedule.job.GoodSecKillRemindTimer;
import com.huyun.web.schedule.job.GoodStockCheckTimer;
import org.quartz.*;

import java.util.Date;
import java.util.UUID;

public class ScheduleUtil {
    /**
     * 创建定时任务
     * SpringBoot整合quartz定时任务框架，完成了分布式单节点任务持久化
     * @param scheduler
     * @throws Exception
     */
    /**
     * 注入任务调度器
     */
    public static void buildCreateGoodTimer(Scheduler scheduler) throws Exception {
        //设置开始时间为1分钟后
        long startAtTime = System.currentTimeMillis() + 1000 * 60;
        //任务名称
        String name = UUID.randomUUID().toString();
        //任务所属分组
        String group = GoodAddTimer.class.getName();
        //创建任务
        //通过JobDetail来构建一个任务实例设置 GoodAddTimer 为目标对象
        //当定时任务触发时调用 定时任务中的 executeInternal()
        JobDetail jobDetail = JobBuilder.newJob(GoodAddTimer.class).withIdentity(name,group).build();
        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name,group).startAt(new Date(startAtTime)).build();
        //将触发器与任务绑定到调度器内
        scheduler.scheduleJob(jobDetail, trigger);
    }


    public static void buildGoodStockTimer(Scheduler scheduler) throws Exception {
        //任务名称
        String name = UUID.randomUUID().toString();
        //任务所属分组
        String group = GoodStockCheckTimer.class.getName();
        // 用cron 表达式 设置 每隔30s执行
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/30 * * * * ?");
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(GoodStockCheckTimer.class).withIdentity(name,group).build();
        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name,group).withSchedule(scheduleBuilder).build();
        //将触发器与任务绑定到调度器内
        scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 向定时任务中传递参数
     * @param goodId
     * @throws Exception
     */
    public static void buildGoodSecKillRemindTimer(Scheduler scheduler,Long goodId) throws Exception {
        //任务名称
        String name = UUID.randomUUID().toString();
        //任务所属分组
        String group = GoodSecKillRemindTimer.class.getName();
        //秒杀开始时间
        long startTime = System.currentTimeMillis() + 1000 * 5 * 60;
        JobDetail jobDetail = JobBuilder
                .newJob(GoodSecKillRemindTimer.class)
                .withIdentity(name,group)
                .build();

        //设置任务传递商品编号参数
        jobDetail.getJobDataMap().put("goodId",goodId);

        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name,group).startAt(new Date(startTime)).build();
        //将触发器与任务绑定到调度器内
        scheduler.scheduleJob(jobDetail,trigger);
    }

}
