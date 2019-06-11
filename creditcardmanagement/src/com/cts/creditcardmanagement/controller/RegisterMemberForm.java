package com.cts.creditcardmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.creditcard.Bo.MemberFormBo;
import com.cts.creditcard.model.MemberForm;

/**
 * Servlet implementation class RegisterMemberForm
 */
@WebServlet("/RegisterMemberForm")
public class RegisterMemberForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterMemberForm() {
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
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		int age=Integer.parseInt(request.getParameter("age"));
		String gender=request.getParameter("gender");
		String contact=request.getParameter("cnumber");
		String uid=request.getParameter("unumber");
		String password=request.getParameter("password");
		System.out.println(fname+" "+lname+" "+uid);
		boolean b=false;
		MemberForm mf=new MemberForm(fname,lname,age,gender,contact,b,uid,password);
		MemberFormBo mfb=new MemberFormBo();
		//boolean b1;
		try {
			b=mfb.insertMemberForm(mf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			b=true;
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		if(b==false) {
			request.setAttribute("value", "Data Inserted sucessfully");
			 RequestDispatcher rd = getServletContext().getRequestDispatcher("/sucess.jsp");
    			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		
	}

}
