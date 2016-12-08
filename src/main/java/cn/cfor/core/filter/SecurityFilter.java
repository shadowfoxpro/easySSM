package cn.cfor.core.filter;

import cn.cfor.core.util.*;
import cn.cfor.core.vo.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by cuiyingjia on 2016/12/8.
 */
public class SecurityFilter extends OncePerRequestFilter {
    private static final Logger LOG = LoggerFactory.getLogger(SecurityFilter.class);
    private String REQUEST_URL_STREING_INCLUDE = "admin";
    public static final String[] REQUEST_URL_STREING_EXCLUDE = { "admin/login",
            "plugin", "resource", "static", "uploads", "errors","favicon.ico","favicon" };

    public static final String[] EXCLUSIVE_RQ_URI = {};//需要登录才能访问的web资源

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession();
        // 初始化SessionUtil
        SessionUtil.init(request);
        //网站升级,不能拦截静态资源
//        if ("1".equals(PublicCode.systemMap.get("con_upgrading")) && !includeExclusiveRQURL(requestURI, REQUEST_URL_STREING_EXCLUDE)
//                && requestURI.indexOf(REQUEST_URL_STREING_INCLUDE) == -1 && requestURI.indexOf("imagecode") == -1) {
//            if (SessionUtil.isAjaxRequest(request)) {
//                JsonResult jsonResult = new JsonResult();
//                jsonResult.setResultCode(Constants.RESULT_SESSION_OUT);
//                jsonResult.setReturnMsg(request.getContextPath() + "/upgrade");
//                jsonResult.writeJSON(response.getWriter());
//            } else {
//                request.getRequestDispatcher("/upgrade").forward(request, response);
//            }
//            return;
//        }

        if (requestURI.indexOf(REQUEST_URL_STREING_INCLUDE) != -1
                && !includeExclusiveRQURL(requestURI,
                REQUEST_URL_STREING_EXCLUDE)
                && session.getAttribute("employeeName") == null) {
            if (SessionUtil.isAjaxRequest(request)) {
                JsonResult jsonResult = new JsonResult();
                jsonResult.setResultCode(Constants.RESULT_SESSION_OUT);
                jsonResult.setReturnMsg(request.getContextPath() + "/admin/login");
                response.setContentType("application/json");
                jsonResult.writeJSON(response.getWriter());
            } else {
                response.sendRedirect(request.getContextPath() + "/admin/login");
            }
            return;
        }
        request.setAttribute("ctx", request.getContextPath());
        request.setAttribute("fullPath", RequestUtil.getBasePath(request));
        filterChain.doFilter(request, response);
    }

    private boolean includeExclusiveRQURL(String currentURI, String[] urls) {
        for (String uri : urls) {
            if (currentURI.indexOf(uri) != -1) {
                return true;
            }
        }
        return false;
    }
}
