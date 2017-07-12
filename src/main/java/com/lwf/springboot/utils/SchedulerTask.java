package com.lwf.springboot.utils;

import com.lwf.springboot.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lwf on 2017/3/6.
 */
@Component
public class SchedulerTask {
/*
    CRON表达式    含义
    "0 0 12 * * ?"         每天中午十二点触发
    "0 15 10 ? * *"        每天早上10：15触发
    "0 15 10 * * ?"        每天早上10：15触发
    "0 15 10 * * ? *"      每天早上10：15触发
    "0 15 10 * * ? 2005"   2005年的每天早上10：15触发
    "0 * 14 * * ?"         每天从下午2点开始到2点59分每分钟一次触发
    "0 0/5 14 * * ?"       每天从下午2点开始到2：55分结束每5分钟一次触发
    "0 0/5 14,18 * * ?"    每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发
    "0 0-5 14 * * ?"       每天14:00至14:05每分钟一次触发
    "0 10,44 14 ? 3 WED"   三月的每周三的14：10和14：44触发
    "0 15 10 ? * MON-FRI"  每个周一、周二、周三、周四、周五的10：15触发
*/

    private Logger logger = LoggerFactory.getLogger(SchedulerTask.class);
    private int count=0;

//    @Scheduled(cron="*/6 * * * * ?")
//    private void process(){
//        logger.info("运行中...... "+(count++));
//    }

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        logger.info("现在时间：" + dateFormat.format(new Date()));
    }
}
