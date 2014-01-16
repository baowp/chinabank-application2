/**
 * Project: biz.base
 *
 * File Created at Jul 31, 2013
 * $Id$Corporation
 *
 * Copyright 2013-2015 Colomob.com Corporation Limited.
 * All rights reserved.
 */
package cn.com.chinabank.app2.http.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author baowp
 */
public class ClientSupport {
    private static final Logger logger = LoggerFactory.getLogger(NormalHttpClient.class);

    static StringBuilder getPrimaryResult(HttpResponse response) {
        HttpEntity entity = response.getEntity();
        try {
            InputStream instream = entity.getContent();
            InputStreamReader reader = new InputStreamReader(instream);
            StringBuilder sb = new StringBuilder();
            int c;
            try {
                while ((c = reader.read()) > -1)
                    sb.append((char) c);
            } finally {
                reader.close();
            }
            if (sb.length() == 0 || sb.charAt(0) != '{' && sb.charAt(0) != '[') {
                if (logger.isInfoEnabled()) {
                    logger.info("response is not json: " + sb);
                }
            }
            return sb;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    static HttpResponse clientExecute(HttpClient httpclient,
                                      HttpUriRequest httpUriRequest) {
        HttpResponse response = null;
        byte retry = 1;
        do {
            try {
                response = httpclient.execute(httpUriRequest);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e1) {
                    logger.error(e1.getMessage(), e1);
                }
            }
        } while (response == null && retry-- > 0);
        return response;
    }
}
