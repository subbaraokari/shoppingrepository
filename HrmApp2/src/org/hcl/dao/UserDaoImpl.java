package org.hcl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

import org.hcl.model.DataSource;
import org.hcl.model.User;
import org.hcl.util.DbUtil;

public class UserDaoImpl implements UserDao {
	DataSource dataSource=DbUtil.getDataSource();
	@Override
	public boolean insert(User user) {
		Connection con=null;
		PreparedStatement pst=null;
		int i;
		boolean b=false;
		try {
			con=DbUtil.getConnection(dataSource.getDriver(), dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
			if(con!=null)
			{
				pst=con.prepareStatement("insert into user(userid,username,password,gender,designation) values(?,?,?,?,?)");
				pst.setInt(1, user.getUserId());
				pst.setString(2, user.getUserName());
				pst.setString(3, user.getPassword());
				pst.setString(4, user.getGender());
				pst.setString(5, user.getDesignation());
				i=pst.executeUpdate();
				if(i>0)
					b=true;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean validate(User user) {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		boolean b=false;
		try {
			con=DbUtil.getConnection(dataSource.getDriver(), dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
			if(con!=null)
			{
				pst=con.prepareStatement("select * from user where username=? and password=?");
				pst.setString(1, user.getUserName());
				pst.setString(2, user.getPassword());
				rs=pst.executeQuery();
				b=rs.next();
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public Optional<User> getUserByUserName(String userName) {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Optional<User> userOptional=null;
		boolean b=false;
		try {
			con=DbUtil.getConnection(dataSource.getDriver(), dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
			if(con!=null)
			{
				pst=con.prepareStatement("select * from user where username=?");
				pst.setString(1, userName);
				rs=pst.executeQuery();
				rs.next();
				User user=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				userOptional=Optional.ofNullable(user);
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userOptional;
	}

}
