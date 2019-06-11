package com.cts.creditcard.Bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.creditcard.configure.MyConfigure;
import com.cts.creditcard.model.MemberForm;
import com.cts.creditcard.model.MemberStatus;

public class MemberStatusBo {
	public boolean insertMemberStatus(MemberStatus ms) throws Exception {
		Connection c=MyConfigure.getConnection();
		//Statement s=c.createStatement();
		PreparedStatement ps=c.prepareStatement("insert into memberstatus values(?,?,?,?)");
		ps.setString(1, ms.getUid());
		ps.setString(2, ms.getApplicationId());
		ps.setString(3, ms.getApplicationDate());
		ps.setString(4, ms.getStatus());
		
		
		
		boolean b=ps.execute();
		System.out.println("Sucess inserted"+b);
		return b;
	}
	public List<MemberStatus> getAllMembersStatus()throws Exception{
		List<MemberStatus> al=new ArrayList<MemberStatus>();
		Connection c=MyConfigure.getConnection();
		PreparedStatement ps=c.prepareStatement("select * from memberstatus");
		ResultSet rs=ps.executeQuery();
		MemberStatus ms=null;
		while(rs.next()) {
			ms=new MemberStatus(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			al.add(ms);
			
		}
		
		return al;
	}
	public MemberStatus getMemberStatus(String uid) throws Exception{
		MemberStatus ms1=null;
		List<MemberStatus> list=getAllMembersStatus();
		for(MemberStatus ms:list) {
			if(uid.equals(ms.getUid())) {
				ms1=ms;
			}
		}
		
		
		return ms1;
		
	}
	public int updateMemberStatus(MemberStatus ms) throws Exception {
		
		Connection c=MyConfigure.getConnection();
		PreparedStatement ps=c.prepareStatement("Update memberstatus set applicationid=?,applicationdate=?,status=? where uidnumber=?");
		//ps.setString(1, ms.getUid());
		ps.setString(1, ms.getApplicationId());
		ps.setString(2, ms.getApplicationDate());
		ps.setString(3, ms.getStatus());
		ps.setString(4, ms.getUid());
        int b=ps.executeUpdate();
		System.out.println("Sucess Updated"+b);
		if(b>0)
		return b;
		else
			return 0;
		
		
		
	}
}
