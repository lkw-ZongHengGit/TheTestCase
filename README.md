# TheTestCase


gmall-user :ÓÃ»§·þÎñ,¶Ë¿Ú8080

分支：test

测试,增加job1


package com.tax.base.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

public class HttpPostSend {

    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private RequestConfig requestConfig;

    Logger logger = LoggerFactory.getLogger(HttpPostSend.class);

    public String sendPost(String url, String postData,String token)
            throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {

        String result = null;
        HttpPost httpPost = new HttpPost(url);

        httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
        httpPost.addHeader("Connection", "");
        httpPost.addHeader("Authorization", token);

        logger.info("POST的数据：{}" , postData);

        StringEntity postEntity = new StringEntity(postData, "UTF-8");
        httpPost.setEntity(postEntity);
        requestConfig = RequestConfig.custom().setSocketTimeout(180000).setConnectTimeout(10000).build();
        httpPost.setConfig(requestConfig);

        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
            logger.info("POST发送的数据:{},POST返回的数据：{}", postData, result);
        } finally {
            httpPost.abort();
        }

        return result;
    }

    public String sendPostNoToken(String url, String postData)
            throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {

        String result = null;
        HttpPost httpPost = new HttpPost(url);

        httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
        httpPost.addHeader("Connection", "");
        logger.info("POST的数据：{}" , postData);

        StringEntity postEntity = new StringEntity(postData, "UTF-8");
        httpPost.setEntity(postEntity);
        requestConfig = RequestConfig.custom().setSocketTimeout(180000).setConnectTimeout(10000).build();
        httpPost.setConfig(requestConfig);

        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
            logger.info("POST发送的数据:{},POST返回的数据：{}", postData, result);
        } finally {
            httpPost.abort();
        }

        return result;
    }
}
