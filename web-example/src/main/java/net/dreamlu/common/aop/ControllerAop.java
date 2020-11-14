package net.dreamlu.common.aop;

import com.common.util.SystemHWUtil;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAop {
	private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

	/*@Autowired
	private AfterListResponseFilter afterListResponseFilter;

	@AfterReturning(returning = "rvt", pointcut = "execution(public * com.alibaba.aecp.logic.web.controller.AutoController.list(..))")
	public ActionResult afterList(JoinPoint point, ActionResult rvt) {
		try {
			Object[] args = point.getArgs();
			if (null == args || args.length == 0) {
				return rvt;
			}
			String voCode = (String) args[0];
			List<ConditionNode> conditionNodeList = (List<ConditionNode>) args[4];
			if (rvt != null && rvt.isSuccess() && rvt.getContent() == null) {
				rvt.setContent(new ArrayList<>());
			}
			if (GenericTenantConfigAop.willPrintSqlLog) {
				if (null != point)
					System.out.println("AutoControllerAop :" + JSON.toJSONString(point.getArgs()));
			}
			return afterListResponseFilter.after(voCode, conditionNodeList, rvt);
		} catch (Exception e) {
			if (!e.getClass().getSimpleName().equalsIgnoreCase("NoSuchBeanDefinitionException")) {
				e.printStackTrace();
				logger.error("afterListResponseFilter.after:" + e.getMessage(), e);
			}
//            logger.error("AutoControllerAop.afterList error,args:" + JSON.toJSONString(point.getArgs()));
			return rvt;
		}
	}*/

	@Around("!within(org.jooq.impl..*) && execution(public * net.dreamlu.convention.web.*.*(..))")
	public Object onException(ProceedingJoinPoint jp) throws Throwable {
		try {
			return jp.proceed();
		} catch (Throwable throwable) {
			String exceptionDetail = ExceptionUtils.getFullStackTrace(throwable);
			throw new RuntimeException("未知异常!" + throwable.getMessage() + "," + SystemHWUtil.CRLF + exceptionDetail, throwable);
		}
	}
}
