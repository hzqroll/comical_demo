package com.roll.comical.console.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取ip接口
 *
 * @author micah.shi
 */
public final class IpUtil {
	/**
	 * 根据请求,获取用户真实ip, 如果请求包涵了ipv6的,该方法不能使用
	 *
	 * @param request 请求
	 * @return 用户真实ip
	 */
	public static String getRemoteIp(HttpServletRequest request) {

		String ipAddress = request.getHeader("X-Real-IP");
		if (ipAddress == null || ipAddress.isEmpty()) {
			ipAddress = request.getHeader("X-Cluster-Client-Ip");
		}
		if (ipAddress == null || ipAddress.isEmpty()) {
			ipAddress = request.getHeader("X-Forwarded-For");
		}
		if (ipAddress == null || ipAddress.isEmpty()) {
			ipAddress = request.getRemoteAddr();
		}
		if (ipAddress != null && !ipAddress.isEmpty()) {
			int index = ipAddress.indexOf(":");
			if (index > 0) {
				ipAddress = ipAddress.substring(0, index);
			}
		}
		return ipAddress;
	}
}
