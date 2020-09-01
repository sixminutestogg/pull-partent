package com.cn.zhang.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter  extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public String filterType() {
        logger.info("请求路由前调用");
        return "pre";
    }

    @Override
    public int filterOrder() {
        logger.info("int 来定义过滤器的执行顺序，数值越小  执行的优先级越高");
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        logger.info("该过滤是否执行  true为执行，false为不执行");
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        logger.info("过滤器的业务行为");
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //获取请求的token
        String token = request.getParameter("token");
        if(token == null){
            logger.warn("此操作需要进行登陆操作-----------");
            currentContext.setSendZuulResponse(false);  //拒绝访问
            currentContext.setResponseStatusCode(200);  //设置响应的状态
            try {
                //响应结果
                currentContext.getResponse().getWriter().write("token is empty");
            }catch (Exception e){
                e.printStackTrace();
            }
            logger.info("error");
            return  null;
        }
        logger.info("ok");
        return null;
    }
}
