package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pizza/order")
public class PizzaOrderServlet extends HttpServlet{

	// a태그 요청 == GET 방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/* 별도 처리 없이 바로 JSP로 요청 위임 */
	
		// RequestDispatcher : 요청 발송자
		// -> 지정된 JSP로 
		// Servlet이 받은 요청 정보(req), 응답 정보(resp)를
		// 전달(발송)하는 역할
		
//		RequestDispatcher dispatcher 
//			= req.getRequestDispatcher("JSP경로");
		
		RequestDispatcher dispatcher 
		= req.getRequestDispatcher("/WEB-INF/views/pizza_order.jsp");
		
		
		/* ******** */
		/* forward */
		/* ******** */
		
		/* 뜻 : 전송하다, 전달하다, 보내다, 발송하다
		 * 
		 * JSP로 요청, 응답을 보내는 기능
		 * 
		 * 특징
		 * 
		 * - 브라우저 주소창은 요청 주소(/pizza/order)로 변함
		 * 	-> Servlet을 요청
		 * 
		 * - 브라우저 화면은 요청 위임된 JSP로 변함 
		 * 
		 * - 실제 페이지 이동은 1회 진행
		 * 
		 * 클라이언트 요청 -> [Servlet이 요청 처리 + JSP가 응답 화면만 만듦]
		 * */
		
		dispatcher.forward(req, resp);
		
	}
}



