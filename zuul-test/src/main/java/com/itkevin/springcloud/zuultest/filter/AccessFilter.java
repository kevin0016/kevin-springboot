package com.itkevin.springcloud.zuultest.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.istack.internal.logging.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: kevin-springboot
 * @Package: com.itkevin.springcloud.zuultest.filter
 * @ClassName: AccessFilter
 * @Description:
 * @Author: Kevin
 * @CreateDate: 18/11/7 下午3:06
 * @UpdateUser:
 * @UpdateDate: 18/11/7 下午3:06
 * @UpdateRemark:
 * @Version: 1.0
 */
public class AccessFilter extends ZuulFilter {

    private final Logger logger = com.sun.istack.internal.logging.Logger.getLogger(getClass());
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        logger.info("send "+request.getMethod()+" request to "+request.getRequestURL().toString());
        String accessToken = request.getParameter("accessToken");
        if(accessToken==null){
            logger.warning("access token is empty");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            return null;
        }
        logger.info("access token ok");
        return null;
    }
}
