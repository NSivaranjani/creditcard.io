package com.cts.creditcard.Bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.creditcard.configure.MyConfigure;
import com.cts.creditcard.model.MemberForm;

public class MemberFormBo {
	public boolean insertMemberForm(MemberForm m) throws Exception {
		Connection c=MyConfigure.getConnection();
		//Statement s=c.createStatement();
		PreparedStatement ps=c.prepareStatement("insert into memberform values(?,?,?,?,?,?,?,?)");
		ps.setString(1, m.getFirstName());
		ps.setString(2, m.getLastName());
		ps.setInt(3, m.getAge());
		ps.setString(4, m.getGender());
		ps.setString(5, m.getContactNumber());
		ps.setBoolean(6, m.isVerified());
		ps.setString(7, m.getUid());
		ps.setString(8, m.getPassword());
		
		
		
		boolean b=ps.execute();
		System.out.println("Sucess inserted"+b);
		return b;
	}
	public MemberForm getMemberForm(String uid) throws Exception {
		MemberForm mf=null;
		
		
		//Statement s=c.createStatement();
		//PreparedStatement ps=c.prepareStatement("select * from memberform where uid=?");
		List<MemberForm> al=getAllMembers();
		for(MemberForm mf1:al) {
			if(uid.equals(mf1.getUid())) {
				mf=mf1;
			}
		}
		
		return mf;
	}
	public List<MemberForm> getAllMembers() throws Exception{
		List<MemberForm> al=new ArrayList<MemberForm>();
		Connection c=MyConfigure.getConnection();
		PreparedStatement ps=c.prepareStatement("select * from memberform");
		ResultSet rs=ps.executeQuery();
		MemberForm mf=null;
		while(rs.next()) {
			mf=new MemberForm(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getString(4) , rs.getString(5), false,
					rs.getString(7), rs.getString(8));
			al.add(mf);
		}
		
		return al;
	}
	public int updateMemberForm(MemberForm mf) throws Exception {
		
		Connection c=MyConfigure.getConnection();
		PreparedStatement ps=c.prepareStatement("Update memberform set firstname=?,lastname=?,age=?, gender=?,contactnumber=?,verified=?,password=? where uid=?");
		ps.setString(1, mf.getFirstName());
		ps.setString(2, mf.getLastName());
		ps.setInt(3,mf.getAge());
		ps.setString(4, mf.getGender());
		ps.setString(5, mf.getContactNumber());
		ps.setBoolean(6, mf.isVerified());
		//ps.setString(7, mf.getUid());
		ps.setString(7, mf.getPassword());
		ps.setString(8, mf.getUid());
		int b=ps.executeUpdate();
		System.out.println("Updated Successfully"+b);
		if(b>0)
			return b;
		else 
			return 0;
	
	}

}
