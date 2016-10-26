package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class customerclass {
	public JSONObject addCustomers( String name, String address, String phoneNumber ) throws JSONException{
		JSONObject result=new JSONObject();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "root");
	        Statement statement = connection.createStatement();
	        
			String query= "insert into customer(name,address,phoneNumber)values('"+ name +"', '"+ address +"','"+ phoneNumber +"')";
	        statement.execute(query);
	        result.put("Status","Success");
		} catch (Exception e1) {
			JSONObject error=new JSONObject();
			error.put("Failure", e1.getMessage());
			return error;
			
		}
		return result;   
		}
		public JSONObject updateCustomers(String name, String address, String phoneNumber) throws JSONException{
			JSONObject result=new JSONObject();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "root");
		        Statement statement = connection.createStatement();
		        String query= "update customer set  name='"+name+"', address='"+ address  +"' where phoneNumber='"+ phoneNumber+" '";
		        statement.execute(query);
		        result.put("Status","Success");
			}catch (Exception e){
			JSONObject error=new JSONObject();
			error.put("Failure", e.getMessage());
			return error;
				
			}
		return result;

	}

	public JSONObject deleteCustomers(String phoneNumber)throws JSONException{
		JSONObject result=new JSONObject();
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "root");
			        Statement statement = connection.createStatement();
			        
					String query="delete from customer where  phoneNumber='"+ phoneNumber+"'";
			        statement.execute(query);
			        result.put("Status","Success");
				
				}catch (Exception e){
					JSONObject error=new JSONObject();
					error.put("Failure", e.getMessage());
					return error;
					
					
				}
		return result;
	  
	     }
	public JSONObject getCustomerDetails(String phoneNumber)throws JSONException{
		JSONObject result=new JSONObject();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "root");
	        Statement statement = connection.createStatement();
	        String query="select * from customer where phoneNumber='"+ phoneNumber+"'";
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	        	result.put("customerId", rs.getInt("customerId"));
	        	result.put("name", rs.getString("name"));
	        	result.put("address", rs.getString("address"));
	        	result.put("phoneNumber", rs.getString("phoneNumber"));
	        	 }
		}catch (Exception e){
			JSONObject error=new JSONObject();
			error.put("Failure", e.getMessage());
			return error;
			
		}
		return result;
	}
	public JSONArray getAllCustomers()throws JSONException{
		JSONArray result=new JSONArray();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "root");
	        Statement statement = connection.createStatement();
	        String query="select * from customer";
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	        	JSONObject employee = new JSONObject();
	        	employee.put("customerId", rs.getInt("customerId"));
	        	employee.put("name", rs.getString("name"));
	        	employee.put("address",rs.getString("address"));
	        	employee.put("phoneNumber",rs.getString("phoneNumber"));
	        	
	        	result.put(employee);
	        }
		}catch (Exception e){
			JSONArray error=new JSONArray();
			error.put("Failure");
			return error;
			
		}
		return result;
	}


	
	}

