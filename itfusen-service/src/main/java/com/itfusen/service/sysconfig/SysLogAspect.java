package com.itfusen.service.sysconfig;


import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itfusen.comm.util.HttpContextUtils;
import com.itfusen.comm.util.IPUtils;
import com.itfusen.comm.util.LogHelper;
import com.itfusen.domain.sysconfig.SysLogEntity;
import com.itfusen.service.comm.shiro.util.ShiroUtils;


/**
 * 系统日志，切面处理类
 *
 * qing.wei
 */
@Aspect
@Component
public class SysLogAspect {
	private static final Logger logger_mdm_sync = LogHelper.mdm_sync_logger;
	private static final Logger logger_oapi = LogHelper.oapi_logger;
	
	@Pointcut("@annotation(com.itfusen.service.sysconfig.SysLog)")
	public void logPointCut() { 
		
	}
//	@Before("logPointCut()  && args(..,request)")
//	public void doBefore(JoinPoint joinPoint, HttpServletRequest request) {
//		if(request.getRequestURI().indexOf("/store/mdmSynchronize") != -1) {
//			logger_mdm_sync.debug("============== BEGIN ===============");
//			if (joinPoint.getArgs().length > 0) {
//				for (Object o : joinPoint.getArgs()) {
//					if (o instanceof HttpServletRequest || o instanceof HttpServletResponse) {
//						continue;
//					}
//					logger_mdm_sync.info("请求参数 : " + JSON.toJSONString(o));
//				}
//			}
//		}
//	}
	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		if(request.getRequestURI()!=null) {
			logger_mdm_sync.info("============== BEGIN ===============");
			logger_oapi.info("API:"+request.getRequestURI());
			if (point.getArgs().length > 0) {
				for (Object o : point.getArgs()) {
					if (o instanceof HttpServletRequest || o instanceof HttpServletResponse) {
						continue;
					}
					logger_mdm_sync.info("Request Parameters: " + JSON.toJSONString(o));
				}
			}
		}else if(request.getRequestURI().indexOf("/oapi") != -1)
		{
			logger_oapi.info("============== BEGIN ===============");
			logger_oapi.info("API:"+request.getRequestURI());
			if (point.getArgs().length > 0) {
				for (Object o : point.getArgs()) {
					if (o instanceof HttpServletRequest || o instanceof HttpServletResponse) {
						continue;
					}
					logger_oapi.info("Request Parameters:" + JSON.toJSONString(o));
				}
			}
		}

		long beginTime = System.currentTimeMillis();
		//执行方法
		Object result = point.proceed();
		//执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;

		//保存日志
		//saveSysLog(point, time);



		return result;
	}

	@SuppressWarnings("unused")
	private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		SysLogEntity sysLog = new SysLogEntity();
		SysLog syslog = method.getAnnotation(SysLog.class);
		if(syslog != null){
			//注解上的描述
			sysLog.setOperation(syslog.value());
		}

		//请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");

		//请求的参数
		Object[] args = joinPoint.getArgs();
		try{
			String params = new ObjectMapper().writeValueAsString(args[0]);
			sysLog.setParameters(params);
		}catch (Exception e){

		}

		//获取request
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		//设置IP地址
		sysLog.setIp(IPUtils.getIpAddr(request));

		//用户名
		String username = ShiroUtils.getUserEntity().getLoginName();
		sysLog.setUserName(username);

		sysLog.setTime(time);
		sysLog.setCreateDate(new Date());
		//保存系统日志
		//sysLogService.insert(sysLog);
	}
}
