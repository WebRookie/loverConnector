package com.rookie.loverconnector.user.service.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.rookie.loverconnector.common.utils.RestTemplateUtil;
import com.rookie.loverconnector.user.service.UserService;
import com.rookie.loverconnector.vo.MsgResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;



/**
 * @author WebRookie
 * @date 2023/7/19 16:44
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Value("${myService.wx.appid}")
    private String appId;

    @Value("${myService.wx.secret}")
    private String appsecret;


    @Override
    public MsgResponse login(String jsCode) {
        JSONObject wxLoginCode = JSONUtil.parseObj(getWxLoginCode(jsCode));
        System.out.println(wxLoginCode);
        String openId = wxLoginCode.getStr("openid");
        if(StringUtils.hasText(openId)) {
            log.info("用户有openId", openId);

        }else {
            log.error("openId过期或者不存在");
            return MsgResponse.fail("请检查code或者响应是否有效");
        }
        return null;
    }


    public String getWxLoginCode(String jsCode) {
        System.out.println(jsCode);
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("appid", appId);
        paramMap.put("secret", appsecret);
        paramMap.put("js_code", jsCode);
        paramMap.put("grant_type", "authorization_code");
        String wxRequestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        String resultStr = RestTemplateUtil.get(restTemplate,wxRequestUrl, null, paramMap);
        return resultStr;
    }


}
