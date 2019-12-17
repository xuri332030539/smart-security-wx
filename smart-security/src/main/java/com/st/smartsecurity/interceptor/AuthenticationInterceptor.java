package com.st.smartsecurity.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.st.smartsecurity.annotation.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拦截器
 *
 * @author leijs
 * @date 2019/10/21
 */
public class AuthenticationInterceptor implements HandlerInterceptor {



	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {

//		httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://212.64.22.136");
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:9528");
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, GET");
		httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
		httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");


//		String token = httpServletRequest.getHeader("Authorization");// 从 http 请求头中取出 token
//		System.out.println("token：" + token);
		// 如果不是映射到方法直接通过httpServletResponse
		if (!(object instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) object;
		Method method = handlerMethod.getMethod();
		//检查是否有passtoken注释，有则跳过认证
		if (method.isAnnotationPresent(PassToken.class)) {
			PassToken passToken = method.getAnnotation(PassToken.class);
			if (passToken.required()) {
				return true;
			}
		}
		return false;
		//检查有没有需要用户权限的注解
//		if (method.isAnnotationPresent(UserLoginToken.class)) {
//			System.out.println("有需要用户权限的注解");
//			UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
//			if (userLoginToken.required()) {
		// 执行认证
//		if (token == null) {
//			JSONObject jsonObj = new JSONObject();
//			jsonObj.put("code", "401");
//			jsonObj.put("msg", "请先登录再进行操作");
//			throw new RuntimeException(jsonObj.toJSONString());
//		}
//		// 获取 token 中的 user id
//		String userId;
//		try {
//			userId = JWT.decode(token).getAudience().get(0);
//		} catch (JWTDecodeException j) {
//
//			JSONObject jsonObj = new JSONObject();
//			jsonObj.put("code", "402");
//			jsonObj.put("msg", "用户信息与Token不匹配，请重新登录");
//			throw new RuntimeException(jsonObj.toJSONString());
//		}
//		SysUserDTO dto = managementService.getSysUserById(userId);
//		if (dto.getId() == null) {
//			JSONObject jsonObj = new JSONObject();
//			jsonObj.put("code", "403");
//			jsonObj.put("msg", "用户不存在，请重新登录");
//			throw new RuntimeException(jsonObj.toJSONString());
//		}
//		// 验证 token
//		JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(dto.getPassword())).build();
//		try {
//			jwtVerifier.verify(token);
//		} catch (JWTVerificationException e) {
//			JSONObject jsonObj = new JSONObject();
//			jsonObj.put("code", "404");
//			jsonObj.put("msg", "Token过期或不匹配，请重新登录");
//			throw new RuntimeException(jsonObj.toJSONString());
//		}
//		return true;
//
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}
}