package com.controler;



import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.duo.resgistrationjdbc;
import com.model.login;
import com.model.registration;
import com.sun.prism.paint.Color;

/**
 * Servlet implementation class PaymentServlet
 */
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	/*	login l= new login();
		// JFrame frame = new JFrame("Bill");
		registration r = new registration(l);
		
	String username=r.getUsername();
		
		System.out.println(r.getUsername());
		PrintWriter out = response.getWriter();
	
		List<registration> lst = new ArrayList<registration>();
		lst.add(r);*/
		resgistrationjdbc rj = new resgistrationjdbc();
		HttpSession session = request.getSession(false);
		String name = (String)session.getAttribute("user");
		System.out.println(name);
		Boolean b = rj.Payment(name);
	if(b==true) {
		
		request.setAttribute("message", "payment successfull)" );
	String message = (String) request.getAttribute("message");
			
		response.setContentType("text/html");
		
//		out.println("<h3>thankyou "+username+ "</h3>"+"for enrolling ");
//		out.println("<br><h3>"+message);
//		out.print(rj.billHTML());
		
	}
	else {
		request.setAttribute("message", "not enough balance");
		
		
	}
		
	   /* frame.getContentPane().setLayout(new FlowLayout());
	    JLabel jlabel = new JLabel(rj.billHTML());
	    frame.add(jlabel);
	    frame.setVisible(true);
	*/  
/*		String str = rj.billHTML();
		RequestDispatcher dispatcher = request.getRequestDispatcher("output.jsp");
		request.setAttribute("bill", str);
		dispatcher.forward(request, response);
*/	
	
//		out.print(rj.billHTML());
	
		
		
//		out.println("<br><br>Contact us at 1800-000-000");
	}

	

}
