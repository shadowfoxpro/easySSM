package cn.cfor.core.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cuiyingjia on 2016/12/8.
 */
public class RequestUtil {
    /**
     * 获取项目basePath
     * @param request
     * @return 例如：http://51roadshow.com/
     */
    public static String getBasePath(HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();
        sb.append(request.getScheme()).append("://").append(request.getServerName());
        if (!requestIsOnStandardPort(request)) {
            sb.append(":").append(request.getServerPort());
        }
        sb.append(request.getContextPath());
        if (!sb.toString().endsWith("/")) {
            sb.append("/");
        }
        return sb.toString();
    }

    private static boolean requestIsOnStandardPort(final HttpServletRequest request) {
        final int serverPort = request.getServerPort();
        return serverPort == 80 || serverPort == 443;
    }
}
