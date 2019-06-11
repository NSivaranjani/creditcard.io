package com.cts.creditcardmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.creditcard.Bo.MemberFormBo;
import com.cts.creditcard.Bo.MemberStatusBo;
import com.cts.creditcard.model.MemberForm;
import com.cts.creditcard.model.MemberStatus;

/**
 * Servlet implementation class EditAllServlet
 */
@WebServlet("/EditAllServlet")
public class EditAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String contactnumber=request.getParameter("cnum");
		String uid=request.getParameter("uid");
		System.out.println(uid);
		String password=request.getParameter("psw");
		System.out.println(password);
		String applicationid=request.getParameter("appid");
		String applicationdate=request.getParameter("dos");
		String status=request.getParameter("status");
		//MemberForm mf=new MemberForm(firstname,lastname,age)
		boolean b=true;
				MemberForm mf=new MemberForm(fname,lname,age,gender,contactnumber,b,uid,password);
		MemberFormBo mfb=new MemberFormBo();
		MemberStatus ms=new MemberStatus(uid,applicationid,applicationdate,status);
		MemberStatusBo msb=new MemberStatusBo();
		int b1=0,b2 = 0;
		
			try {
				 b1=mfb.updateMemberForm(mf);
				 
				//System.out.println(b1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  try {
			b2=msb.updateMemberStatus(ms);
			//System.out.println(b2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b1>0 && b2>0) {
			request.setAttribute("value", "Data updated sucessfully");
			 RequestDispatcher rd = getServletContext().getRequestDispatcher("/sucess1.jsp");
  			rd.forward(request, response);
		}
		else {
			
			request.setAttribute("value", "Data updated sucessfully");
			 RequestDispatcher rd = getServletContext().getRequestDispatcher("/sucess1.jsp");
   			rd.forward(request, response);
		}
		
		
		
		
		
		
		
	}

}
