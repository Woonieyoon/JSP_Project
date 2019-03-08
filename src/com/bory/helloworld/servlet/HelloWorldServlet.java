package com.bory.helloworld.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bory.helloworld.file.CounterFileIncrementer;

public class HelloWorldServlet extends HttpServlet {

	//Source -> implement/override Methods -> doget생성
	//HttpServletRequest -> http 요청(혹은 응답)을 객체화한것, url, head등의 정보를 가지고 있음
	//입력,출력 처리만 하면 된다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CounterFileIncrementer incrementer = new CounterFileIncrementer();
		int value = incrementer.incrementAndGet();
		
		StringBuilder responseMessage = new StringBuilder();
		responseMessage.append("<!DOCTYPE html>" + 
				"<html>" + 
				"<head>" + 
				"<meta charset='UTF-8'>" + 
				"<title>Index Page</title>" + 
				"</head>" + 
				"<body>" + 
				"	<h2>Hello World!!</h2><br>" + 
				"<h3>visiter Count : </h3>" + value+
				"</body>" + 
				"</html>");
		//response에 String으로 전송
		resp.getWriter().write(responseMessage.toString());
		//서블릿이 등록되었다는것을 서버는 모른다.
		//2가지 방법이 있다.
		//1. web.xml (WebContent)
	}
	
	
	private static final long serialVersionUID = 5917954878132593654L;
	
	

}
