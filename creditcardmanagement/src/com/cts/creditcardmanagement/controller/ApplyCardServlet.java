package com.cts.creditcardmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.creditcard.Bo.MemberStatusBo;
import com.cts.creditcard.model.MemberStatus;

/**
 * Servlet implementation class ApplyCardServlet
 */
@WebServlet("/ApplyCardServlet")
public class ApplyCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyCardServlet() {
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
		//doGet(request, response);
		String uid=request.getParameter("uid");
		String appid=request.getParameter("appid");
		String appdate=request.getParameter("doa");
		String status=request.getParameter("status");
		status="Submitted";
		MemberStatus ms=new MemberStatus(uid,appid,appdate,status);
		MemberStatusBo msb=new MemberStatusBo();
		boolean b1=false;
		try {
			b1=msb.insertMemberStatus(ms);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		if(b1==false) {
			request.setAttribute("value", "Data Inserted sucessfully");
			 RequestDispatcher rd = getServletContext().getRequestDispatcher("/sucess2.jsp");
    			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		
	}

}
