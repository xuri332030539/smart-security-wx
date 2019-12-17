//package com.st.smartsecurity.util;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.st.smartsecurity.pojo.dto.SysUserDTO;
//import com.st.smartsecurity.pojo.po.SysUser;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Date;
//
///*
//* @author leijs
//* @date 2019/10/21
//* @version 1.1
//*/
//@Component
//public class TokenUtil {
//	/**
//	 * 下发Token
//	 * @param user
//	 * @return
//	 */
//	public String getToken(SysUserDTO user) {
//		Date start = new Date();
//		long currentTime = System.currentTimeMillis() + 60 * 60 * 1000 * 2;//一小时有效时间
//		Date end = new Date(currentTime);
//		String token = "";
//		token = JWT.create().withAudience(user.getId()).withIssuedAt(start).withExpiresAt(end)
//				.sign(Algorithm.HMAC256(user.getPassword()));
//		return token;
//	}
//
//
//	public static String getTokenUserId() {
//		String token = getRequest().getHeader("Authorization");// 从 http 请求头中取出 token
//		System.out.println(token);
//		String userId = JWT.decode(token).getAudience().get(0);
//		return userId;
//	}
//
//	/**
//	 * 获取request
//	 *
//	 * @return
//	 */
//	public static HttpServletRequest getRequest() {
//		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
//				.getRequestAttributes();
//		return requestAttributes == null ? null : requestAttributes.getRequest();
//	}
//}
