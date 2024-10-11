package com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDao implements AutoCloseable {
	private Connection con;
	
	public CustomerDao() throws Exception {
		con = DbUtil.getConnection();
	}
	
	@Override
	public void close() throws Exception {
		if(con != null)
			con.close();
	}
	
	public Customer findByEmail(String email) throws Exception {
		String sql = "SELECT * FROM customers WHERE email = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, email);s
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String mobile = rs.getString("mobile");
					String address = rs.getString("address");
					String password = rs.getString("password");
					email = rs.getString("email");
					Date birth = rs.getDate("birth");
					Customer c = new Customer(id, name, password, email, address, mobile, birth);
					return c;
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}
	
	public int save(Customer c) throws Exception {
		String sql = "INSERT INTO customers (name, address, mobile, email, password, birth) VALUES (?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getAddress());
			stmt.setString(3, c.getMobile());
			stmt.setString(4, c.getEmail());
			stmt.setString(5, c.getPassword());
			stmt.setDate(6, c.getBirth());
			int count = stmt.executeUpdate();
			return count;
		} // stmt.close();
	}
}
