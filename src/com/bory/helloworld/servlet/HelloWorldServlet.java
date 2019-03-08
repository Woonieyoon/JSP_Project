package com.bory.helloworld.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bory.helloworld.file.CounterFileIncrementer;

public class HelloWorldServlet extends HttpServlet {

	//Source -> implement/override Methods -> doget����
	//HttpServletRequest -> http ��û(Ȥ�� ����)�� ��üȭ�Ѱ�, url, head���� ������ ������ ����
	//�Է�,��� ó���� �ϸ� �ȴ�.
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
		//response�� String���� ����
		resp.getWriter().write(responseMessage.toString());
		//������ ��ϵǾ��ٴ°��� ������ �𸥴�.
		//2���� ����� �ִ�.
		//1. web.xml (WebContent)
	}
	
	
	private static final long serialVersionUID = 5917954878132593654L;
	
	

}
