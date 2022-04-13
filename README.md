# TheTestCase


gmall-user :ÓÃ»§·þÎñ,¶Ë¿Ú8080

分支：test

测试,增加job1



7.2 报文定义
接口请求地址（测试)：
POST： 
测试环境：https://192.168.91.19/anta/contract/constructUrl
生产环境：https://192.168.66.71/anta/contract/constructUrl




package com.example.cn.demo.test;

import com.example.cn.demo.dao.UpMapper;
import com.example.cn.demo.entity.FileContent;
import com.example.cn.demo.upload.FastDFSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class AppRunnerNew {

    @Autowired
    private UpMapper upMapper;
    @Autowired
    FastDFSService fastDFSService;


    private Queue<FileContent> queue = new ConcurrentLinkedQueue();
    private Queue<String> insertQueue = new ConcurrentLinkedQueue();
    private Queue<FileContent> lastQueue = new ConcurrentLinkedQueue();
    private Integer in = 0;


    public void startRun() {
        // 查询数据 + 添加至队列
        queryData();
        // 初始化线程 + 处理数据
        initThread(10);
    }

    public void initThread(int num) {
        for (int i = 1; i <= num; i++) {
            int finalI = i;
            Thread thread = null;
            try {
                thread = new Thread(() -> {
                    int k = 0;
                    System.out.println("线程[" + finalI + "]启动");
                    while (!queue.isEmpty()) {
                        k++;
                        startGame();
                    }
                });
                thread.start();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            } finally {
                thread.interrupt();
            }
        }
    }

    public void queryData() {
        List<FileContent> fileContents = upMapper.selectFiles();
        if(!CollectionUtils.isEmpty(fileContents)&&fileContents.size()>1000){
            queue.addAll(fileContents);
        }else if(!CollectionUtils.isEmpty(fileContents)&&fileContents.size()<=1000&&in<=1){
            //查询数据小于1000，最后抽出一条线程将他们统一处理
            lastQueue.addAll(fileContents);
            Thread thread = null;
            try {
                thread = new Thread(() -> {
                    while (!lastQueue.isEmpty()) {
                        lastGame();
                    }
                });
                thread.start();
                in++;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public void startGame() {
        FileContent fileContent = queue.poll();
        try {
            if (fileContent != null) {
                fastDFSService.downloadFile(fileContent.getFileGroup(),fileContent.getFilePath());
                insertQueue.add(fileContent.getId());
            }
            if(insertQueue.size()>=500){
                updateFileSize();
            }
        } catch (Exception e) {
         //   queue.add(fileContent);
            fileContent.setExtStringFive(e.getMessage());
            upMapper.updateByFile(fileContent);
        }finally {
            //上锁的方法
          if(queue.size() < 1000){
              addFileSize();
          }
        }
    }



    public void lastGame() {
        FileContent fileContent = lastQueue.poll();
        try {
            if (fileContent != null) {
                fastDFSService.downloadFile(fileContent.getFileGroup(),fileContent.getFilePath());
                upMapper.updateBatchByOneId(fileContent.getId());
            }
        } catch (Exception e) {
            fileContent.setExtStringFive(e.getMessage());
            upMapper.updateByFile(fileContent);
        }finally {
            if(lastQueue.size()==1){
                queryData();
            }
        }
    }

    public synchronized void addFileSize() {
        if (queue.size() < 1000&&in==0) {
            queryData();
        }
    }

    public synchronized void updateFileSize() {
        if(insertQueue.size()>=500){
            List<String> entity = new ArrayList(insertQueue);
            upMapper.updateBatchById(entity);
            insertQueue.clear();
        }
    }
}



65.102:8   openjdk version "1.8.0_272"
65.103:8   openjdk version "1.8.0_272"
65.104:4  openjdk version "1.8.0_232"
65.105:4  openjdk version "1.8.0_232"
65.106:4  openjdk version "1.8.0_232"
65.107:4  openjdk version "1.8.0_232"
65.108:4  openjdk version "1.8.0_131"
65.114:8  openjdk version "1.8.0_131"
65.115:8  openjdk version "1.8.0_131"
65.116:8  openjdk version "1.8.0_131"


