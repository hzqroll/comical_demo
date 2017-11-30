package com.roll.comical.console.business.decorator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Date: 2017/11/4
 *
 * @author zongqiang.hao
 */
public class ComicalRequest extends HttpServletRequestWrapper {
	/**
	 * Constructs a request object wrapping the given request.
	 *
	 * @param request
	 * @throws IllegalArgumentException if the request is null
	 */
	public ComicalRequest(HttpServletRequest request) {
		super(request);
	}

}
