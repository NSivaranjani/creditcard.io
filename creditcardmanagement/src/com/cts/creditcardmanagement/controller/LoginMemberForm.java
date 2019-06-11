package com.cts.creditcardmanagement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.creditcard.Bo.MemberFormBo;
import com.cts.creditcard.model.MemberForm;

/**
 * Servlet implementation class LoginMemberForm
 */
@WebServlet("/LoginMemberForm")
public class LoginMemberForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMemberForm() {
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
		String uid=request.getParameter("uname");
		System.out.println(uid);
		String pass=request.getParameter("psw");
		MemberFormBo mfb=new MemberFormBo();
		List<MemberForm> li=new ArrayList<MemberForm>();
		try {
			 li=mfb.getAllMembers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name=null;

		HttpSession session=request.getSession();
		
		int flag=0;
		if((uid.equals("Admin"))&&(pass.equals("admin123"))) {
			name="Administrator";
			flag=1;
			
		}
	
		
		else {
			

		for(MemberForm mf:li) {
			if(uid.equals(mf.getUid())&&pass.equals(mf.getPassword())) {
				name=mf.getFirstName()+" "+mf.getLastName();
				System.out.println(name);
				flag=1;
				break;
		}
		
		}
		
		}
		
		
		
		if(flag==1) {
			
			if(uid.equals("Admin"))
			{
				session.setAttribute("uid", uid);
				request.setAttribute("user", name);
				session.setAttribute("user", name);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/adminHome.jsp");
				rd.forward(request, response);
			
			}
			else {
			session.setAttribute("id", uid);
			request.setAttribute("user",name);
			session.setAttribute("user", name);
			//session.setAttribute("user", name);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/userHome.jsp");
			rd.forward(request, response);
			}
		}
		else
		{
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
			}
		}
		
	

}
