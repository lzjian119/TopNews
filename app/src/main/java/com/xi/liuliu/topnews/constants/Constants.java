package com.xi.liuliu.topnews.constants;

/**
 * Created by liuliu on 2017/6/13.
 */

public interface Constants {
    String[] CHANNELS = new String[]{"头条", "社会", "国内", "娱乐", "体育", "军事", "科技", "财经", "时尚"};
    String[] CHANNELS_PARAM = new String[]{"toutiao", "shehui", "guonei", "yule", "tiyu", "junshi", "keji", "caijing", "shishang"};
    String HOST = "http://v.juhe.cn/toutiao/index";
    String JU_HE_APP_KEY = "6a0f8f312dfdc046f4132d0a6761ecc8";
    String[] FAVOURITE_HISTORY = new String[]{"我的收藏", "阅读历史"};
    String LOGIN_SP_KEY = "isUserLoggedIn";
    String USER_PHONE_NUMBER_SP_KEY = "phoneNumber";
    String LOGIN_SMS_CODE_HOST = "https://api.leancloud.cn/1.1/requestSmsCode";
    String VERIFY_SMS_CODE = "https://api.leancloud.cn/1.1/verifySmsCode";
    String LEAN_CLOUND_APP_KEY = "LSe5Tdf9RP0kHbBsp0FYWrwL";
    String LEAN_CLOUND_APP_ID = "J9jGoaYEbyYl1iB4Nu3W0swr-gzGzoHsz";

}
