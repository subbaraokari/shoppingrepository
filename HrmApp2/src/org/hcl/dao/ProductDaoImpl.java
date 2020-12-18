package org.hcl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hcl.model.DataSource;
import org.hcl.model.Product;
import org.hcl.util.DbUtil;

public class ProductDaoImpl implements ProductDao {
	DataSource dataSource=DbUtil.getDataSource();
	@Override
	public List<Product> getAll() {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		List<Product> products=new ArrayList<>();
		try {
			con=DbUtil.getConnection(dataSource.getDriver(), dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
			if(con!=null)
			{
				st=con.createStatement();
				rs=st.executeQuery("select * from product");
				while(rs.next())
				{
					products.add(new Product(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getInt(5)));
				}
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return products;
	}
	@Override
	public boolean add(Product product) {
		Connection con=null;
		PreparedStatement pst=null;
		boolean b=false;
		try {
			con=DbUtil.getConnection(dataSource.getDriver(), dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
			if(con!=null)
			{
				pst=con.prepareStatement("insert into product values(?,?,?,?,?)");
				pst.setInt(1, product.getPid());
				pst.setString(2, product.getProductName());
				pst.setString(3, product.getImageUrl());
				pst.setString(4, product.getDescription());
				pst.setInt(5, product.getPrice());
				int i=pst.executeUpdate();
				if(i>0)
					b=true;
				con.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}

}
