package kr.co.test.rest.cookie.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.LogDeclare;
import common.spring.resolver.ParamCollector;
import common.util.sessioncookie.CookieUtilVer2;

@Controller
@RequestMapping("/cookie")
public class CookieController extends LogDeclare {
	
	private static final String TEST_COOKIE_KEY = "hello_cookie";

	@ResponseBody
	@RequestMapping("/set")
	public String set(HttpServletResponse response) {
		CookieUtilVer2.addCookie(response, TEST_COOKIE_KEY, "test", (60*5), true);
		
		return "Cookie Set Test";
	}
	
	@ResponseBody
	@RequestMapping("/get")
	public String get(ParamCollector paramCollector) {
		String msg = CookieUtilVer2.getCookie(paramCollector.getRequest(), TEST_COOKIE_KEY);
		
		return msg;
	}
	
	@ResponseBody
	@RequestMapping("/get_anno")
	public String getAnno(@CookieValue(TEST_COOKIE_KEY) String cookieKey) {
		return cookieKey;
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public String remove(ParamCollector paramCollector, HttpServletResponse response) {
		CookieUtilVer2.removeCookie(paramCollector.getRequest(), response, TEST_COOKIE_KEY);
		
		return "Cookie Remove Test";
	}
	
}
