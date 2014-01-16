/**
 * Project: biz.base
 *
 * File Created at Sep 3, 2013
 * $Id$Corporation
 *
 * Copyright 2013-2015 Colomob.com Corporation Limited.
 * All rights reserved.
 */
package cn.com.chinabank.app2.http.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author baowp
 */
public class NormalHttpClient {

    private static final Logger logger = LoggerFactory.getLogger(NormalHttpClient.class);

    public String get(URI uri) {
        HttpClient httpclient = newHttpClientInstance();
        HttpGet httpget = new HttpGet(uri);
        try {
            HttpResponse response = ClientSupport.clientExecute(httpclient,
                    httpget);
            return ClientSupport.getPrimaryResult(response).toString();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
    }

    public String post(String url, Map<String, Object> param) {
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            if (entry.getValue() != null) {
                String key = entry.getKey();
                String value = entry.getValue().toString();
                formparams.add(new BasicNameValuePair(key, value));
            }
        }
        UrlEncodedFormEntity form = null;
        try {
            form = new UrlEncodedFormEntity(formparams, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        }
        return post(url, form);
    }

    public String post(String url, HttpEntity httpEntity) {
        HttpClient httpclient = newHttpClientInstance();

        HttpPost httppost = new HttpPost(url);
        try {
            httppost.setEntity(httpEntity);

            HttpResponse response = ClientSupport.clientExecute(httpclient,
                    httppost);
            return ClientSupport.getPrimaryResult(response).toString();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
        return null;
    }

    protected HttpClient newHttpClientInstance() {
        return new DefaultHttpClient();
    }

}
