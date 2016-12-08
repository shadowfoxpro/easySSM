package cn.cfor.core.util;

/**
 * Created by cuiyingjia on 2016/12/8.
 */
public interface Constants {
    String BUCKET_HEAD_IMG= "szb-head";
    String BUCKET_APPLY_LIVE = "szb-identity";

    /**
     * 第三方登录接口参数
     *
     */
    /**第三方登录回调地址生产环境和测试环境*/
    String QQ_REDICRECT_URL = "http://www.shangzhibo.net/platform/qqreturn";//QQ互联 生产环境 FIXME move to properties
    /**
     * websocket地址
     */
    String WEB_SOCKET_URL = "www.shangzhibo.net";//FIXME move to properties


    /**QQ登录*/
    String QQ_QUERY_AUTH_URL = "https://graph.qq.com/oauth2.0/authorize";
    String QQ_QUERY_TOKEN_URL = "https://graph.qq.com/oauth2.0/token";
    String QQ_QUERY_OPEN_ID_URL = "https://graph.qq.com/oauth2.0/me";
    String QQ_QUERY_USER_INFO_URL = "https://graph.qq.com/user/get_user_info";
    String QQ_APP_ID ="101348495";
    String QQ_APP_KEY ="d6fa2f9ad46735efa4eaaa64bb46a1c8";
    String QQ_STATE ="wallawNNB10137";//FIXME 自定义随机状态值，防止CSRF攻击


    /**微信*/
    String WX_QUERY_CONNECT_URL = "https://open.weixin.qq.com/connect/qrconnect";
    String WX_QUERY_REDIRECT_URI = "http://www.shangzhibo.net/platform/wxreturn";//FIXME Customerized.getValue
    String WX_QUERY_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
    String WX_QUERY_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo";
    String WX_QUERY_SCOPE = "snsapi_login";
    String WX_APP_ID ="wxa2915ae447b9c882";
    String WX_APP_KEY ="1ab1b245870ca97153882dcab8d415aa";
    /**
     * 用于保持请求和回调的状态，授权请求后原样带回给第三方
     * 该参数可用于防止csrf攻击（跨站请求伪造攻击）
     * 可设置为简单的随机数加session进行校验
     */
    String WX_STATE ="wallawNNB10139";//FIXME 自定义随机状态值，防止CSRF攻击


    /**微博*/
    String WB_QUERY_AUTH_URL = "https://api.weibo.com/oauth2/authorize";
    String WB_QUERY_REDIRECT_URI = "http://www.shangzhibo.net/platform/wbreturn";//FIXME Customerized.getValue
    String WB_QUERY_TOKEN_URL = "https://api.weibo.com/oauth2/access_token";
    String WB_QUERY_USER_INFO_URL = "https://api.weibo.com/2/users/show.json";
    String WB_QUERY_SCOPE = "all";
    String WB_APP_KEY ="1089962094";
    String WB_APP_SECRET ="b0fbf2203eb971b9eaa8ed8fcf839efd";



    String SPLITTER_COMMA = ",";

    String SPLITTER_UNDERSCORE = "_";

    String SPLITTER_COL = ", ";
    //系统管理员角色
    String ROLES_ADMIN = "admin";

    /**
     * 风行短信接口 常量
     * 执行状态 SUCCESS:YES
     */
    String MSG_FX_SUCCESS_YES = "00";
    /** */
    String APPLICATION_PROPERTY = "application.properties";

    String RESULT_SUCCESS = "1";

    String RESULT_FAIURE = "0";
    /** session 过期 */
    String RESULT_SESSION_OUT = "-2";

    String CONSTANT_1 = "1";

    String COOKIE_TOKEN = "_RQ_TOKEN_SESSION";

}
