package net.dreamlu.common.filter.request;

import com.kunlunsoft.rewriterequest.web.filter.request.dto.HttpPutFormContentRequestWrapper;
import com.kunlunsoft.rewriterequest.web.filter.request.responsibility.IRequestFilter;
import com.kunlunsoft.rewriterequest.web.filter.request.responsibility.RequestFilterChain;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReqJsonToFormRequestFilter implements IRequestFilter {
	@Override
	public void doFilter(HttpPutFormContentRequestWrapper request, HttpServletResponse response, RequestFilterChain filterChain) throws IOException, ServletException {
		request.parseJsonParameter();
		filterChain.doFilter(request, response);
	}
}
