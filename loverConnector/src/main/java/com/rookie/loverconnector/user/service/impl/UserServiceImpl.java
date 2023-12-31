package com.rookie.loverconnector.user.service.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.rookie.loverconnector.common.constants.CodeEnum;
import com.rookie.loverconnector.common.utils.RestTemplateUtil;
import com.rookie.loverconnector.user.dao.UserDao;
import com.rookie.loverconnector.user.service.UserService;
import com.rookie.loverconnector.user.vo.UserVO;
import com.rookie.loverconnector.user.vo.request.UserInfo;
import com.rookie.loverconnector.vo.MsgResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Resource
    private UserDao userDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsgResponse login(String jsCode) {
        JSONObject wxLoginCode = JSONUtil.parseObj(getWxLoginCode(jsCode));
        String openId = wxLoginCode.getStr("openid");
        UserVO userVo = null;
        if (StringUtils.hasText(openId)) {
            log.info("openId有效");
            userVo = userDao.getUserByOpenId(openId);
            // 新用户创建用户
            if (userVo == null) {
                // 创建用户
                Integer userId = userDao.createUserByOpenId(openId);
                log.info("用户Id：" + userId);
                log.info("openId:" + openId);
                userVo = userDao.getUserByUserId(userId);
            }
        } else {
            log.error("openId过期或者不存在");
            return MsgResponse.fail("请检查code或者响应是否有效");
        }
        return MsgResponse.success(userVo);
    }

    @Override
    public MsgResponse<UserVO> getUserInfo(int userId) {
        System.out.println(userId);
        UserVO userVO = userDao.getUserByUserId(userId);
        log.info("用户查询如下:{}", userVO);;
        if(userVO == null){
            log.info("用户不存在");
            return MsgResponse.fail(CodeEnum.USER_NOT_EXIST);
        }

        return MsgResponse.success(userVO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsgResponse updateUserInfo(UserInfo userInfo) {
        UserVO userVO = userDao.getUserByUserId(userInfo.getUserId());
        if(userVO == null) {
            System.out.println("用户不存在");
            return MsgResponse.fail(CodeEnum.USER_NOT_EXIST);
        }
        userDao.updateUserInfo(userInfo);
        return MsgResponse.success();
    }


    public String getWxLoginCode(String jsCode) {
//        System.out.println(jsCode);
        log.info("请求的jsCode", jsCode);
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> paramMap = new HashMap<>(16);
        paramMap.put("appid", appId);
        paramMap.put("secret", appsecret);
        paramMap.put("js_code", jsCode);
        paramMap.put("grant_type", "authorization_code");
        String wxRequestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        String resultStr = RestTemplateUtil.get(restTemplate, wxRequestUrl, null, paramMap);
        log.info("请求结果", resultStr);
        return resultStr;
    }


}
