package com.earth66.quickstart;

import java.util.Properties;
import java.util.concurrent.Executor;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

public class ConfigExample {

    public static void main(String[] args) throws NacosException, InterruptedException {
        String serverAddr = "localhost";
        String dataId = "white_user_list";
        String group = "user";
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
        //properties.put(PropertyKeyConst.NAMESPACE, "baidu");
        ConfigService configService = NacosFactory.createConfigService(properties);

//        boolean isPublishOk = configService.publishConfig(dataId, group, "1001,1002");
//        System.out.println(isPublishOk);


        String content = configService.getConfig(dataId, group, 5000);
        System.out.println("white_user_list:" + content);
        configService.addListener(dataId, group, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println("recieve:" + configInfo);
            }

            @Override
            public Executor getExecutor() {
                return null;
            }
        });
//
//
//
//        Thread.sleep(3000);
//        content = configService.getConfig(dataId, group, 5000);
//        System.out.println(content);
//
//        boolean isRemoveOk = configService.removeConfig(dataId, group);
//        System.out.println(isRemoveOk);
//        Thread.sleep(3000);
//
//        content = configService.getConfig(dataId, group, 5000);
//        System.out.println(content);
        Thread.sleep(3000000);

    }
}
