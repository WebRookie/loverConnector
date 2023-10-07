package com.rookie.loverconnector.common.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author WebRookie
 * @description 封装http请求
 * @date 2023/7/20 11:58
 **/
public class RestTemplateUtil {

    private static final String EMPTY_STR = "";

    /**
     * get请求
     *
     * @param restTemplate
     * @param url
     * @param headerMap
     * @param paramMap
     * @return 响应体
     */
    public static String get(RestTemplate restTemplate, String url, Map<String, String> headerMap, Map<String, String> paramMap) {
        HttpHeaders headers = new HttpHeaders();
        if (!CollectionUtils.isEmpty(headerMap)) {
            headerMap.forEach(headers::set);
        }

        StringBuffer paramStr = new StringBuffer(EMPTY_STR);
        if (!CollectionUtils.isEmpty(paramMap)) {
            paramMap.forEach((k, v) -> {
//                遍历拼接请求参数
                if (paramStr.toString().equals(EMPTY_STR)) {
                    paramStr.append("?").append(k).append("=").append(v);
                } else {
                    paramStr.append("&").append(k).append("=").append(v);
                }
            });
        }
        HttpEntity<String> httpEntity = restTemplate.
                exchange(url + paramStr.toString(),
                        HttpMethod.GET,
                        CollectionUtils.isEmpty(headerMap) ? null : new HttpEntity<>(headers),
                        String.class);
        return httpEntity.getBody();
    }

    /**
     * post JSON
     *
     * @param restTemplate
     * @param url
     * @param headerMap
     * @param paramObjectStr
     * @return 字符串
     */
    public static String postJson(RestTemplate restTemplate, String url, Map<String, String> headerMap, String paramObjectStr) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (!CollectionUtils.isEmpty(headerMap)) {
            headerMap.forEach(headers::set);
        }
        String resultStr = restTemplate.postForObject(url,
                new HttpEntity<>(paramObjectStr, headers),
                String.class);
        return resultStr;
    }

    /**
     * post form
     * @param restTemplate
     * @param url
     * @param headerMap
     * @param paramMap
     * @return
     */
    public static String postForm(RestTemplate restTemplate, String url, Map<String, String> headerMap, MultiValueMap<String, Object> paramMap) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        if (!CollectionUtils.isEmpty(headerMap)) {
            headerMap.forEach(headers::set);
        }
        String resultStr = restTemplate.postForObject(url,
                new HttpEntity<>(paramMap, headers),
                String.class);
        return resultStr;

    }
}
