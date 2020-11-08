package net.dreamlu.common.filter;

import com.common.bean.AllowOriginDto;
import com.common.bean.exception.LogicBusinessException;
import com.common.dict.Const;
import com.common.util.PropsReadUtil;
import com.file.hw.props.GenericReadPropsUtil;
import com.string.widget.util.ValueWidget;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/***
 * 支持ajax 跨域访问 <br />
 * 配置文件:/Users/hanjun/Documents/mygit/demo/stub_test/src/main/resources/config/custom_cors.properties
 * @author huangweii
 * 2015年6月7日
 */
public class SimpleCORSFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(SimpleCORSFilter.class);
    private AllowOriginDto allowOriginDto;
    private static String configPath = "config/custom_cors.properties";

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        String path = request.getServletPath();
        if (path.endsWith("/cors/update/json")
                || path.endsWith("/cors/application/add.json")
                || path.endsWith("/cors/application/remove.json")
                || path.endsWith("/cors/application/get.json")) {
            chain.doFilter(req, res);
            return;
        }
        //优先级 request > header
        String allOrigin = ObjectUtils.firstNonNull(request.getParameter("allowOrigin"), request.getHeader("Origin"), this.allowOriginDto.getAccessControlAllowOrigin());
        String message = "############## allOrigin :" + allOrigin;
        log.warn(message);
        System.out.println(message);
        /*if (ValueWidget.isNullOrEmpty(allOrigin)) {
            allOrigin = ;
            if (ValueWidget.isNullOrEmpty(allOrigin)) {
                allOrigin = this.allowOriginDto.getAccessControlAllowOrigin();
            }
        }*/

        Properties properties = GenericReadPropsUtil.getProperties(true, configPath);
        String extraAllowHeaders = null;
        if (null != properties) {
            extraAllowHeaders = properties.getProperty("cors.allowedheader");
        }

        response.setHeader("Access-Control-Allow-Origin", allOrigin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", ("Content-Type,x-requested-with,eagleeye-sessionid,eagleeye-pappname," +
                "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,Authorization,SessionToken,JSESSIONID,token," +
                (ValueWidget.isNullOrEmpty(extraAllowHeaders) ? "" : extraAllowHeaders)).replace(", ,", ",").replace(",,", ","));

        String allCookie = request.getParameter("allowCookie");
        if (!ValueWidget.isNullOrEmpty(allCookie) && "true".equalsIgnoreCase(allCookie)) {//允许客户端带cookie
            response.setHeader("Access-Control-Allow-Credentials", "true");
        }

        try {
            chain.doFilter(req, res);
        } catch (Exception e) {
            e.printStackTrace();
            LogicBusinessException.throwException(e.getMessage(), e);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SimpleCORSFilter init:");
        this.allowOriginDto = new AllowOriginDto();
        filterConfig.getServletContext().setAttribute(Const.ATTRIBUTE_ALLOW_ORIGIN_DTO, this.allowOriginDto);
    }

}
