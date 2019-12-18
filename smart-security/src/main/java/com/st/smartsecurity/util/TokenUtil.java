package com.st.smartsecurity.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.st.smartsecurity.pojo.dto.QdUserDTO;
import com.st.smartsecurity.pojo.po.QdUser;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/*
* @author xuri
* @date 2019/12/18
*/
@Component
public class TokenUtil {
	/**
	 * 下发Token
	 * @param qdUserDTO
	 * @return
	 */
	public String getToken(QdUserDTO qdUserDTO) {
		Date start = new Date();
		long currentTime = System.currentTimeMillis() + 60 * 60 * 1000 * 3;//3小时有效时间
		Date end = new Date(currentTime);
		String token = "";
//		System.out.println(qdUserDTO.getId());
		token = JWT.create().withAudience(String.valueOf(qdUserDTO.getId())).withIssuedAt(start).withExpiresAt(end)
				.sign(Algorithm.HMAC256(qdUserDTO.getWorkNumber()));
//		System.out.println(JWT.decode(token).getAudience().get(0));
		return token;
	}


//	public static String getTokenUserId() {
//		String token = getRequest().getHeader("Authorization");// 从 http 请求头中取出 token
//		System.out.println(token);
//		String userId = JWT.decode(token).getAudience().get(0);
//		return userId;
//	}

	/**
	 * 获取request
	 *
	 * @return
	 */
//	public static HttpServletRequest getRequest() {
//		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
//				.getRequestAttributes();
//		return requestAttributes == null ? null : requestAttributes.getRequest();
//	}
}
