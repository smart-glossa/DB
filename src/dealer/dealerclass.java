package dealer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dealerclass {
	public JSONObject addDealers( String name,String company, String address, String phoneNumber ) throws JSONException{
		JSONObject result=new JSONObject();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "root");
	        Statement statement = connection.createStatement();
	        
			String query= "insert into dealer(name,company,address,phoneNumber)values('"+ name +"','"+ company +"','"+ address +"','"+ phoneNumber +"')";
	        statement.execute(query);
	        result.put("Status","Success");
		} catch (Exception e1) {
			JSONObject error=new JSONObject();
			error.put("Failure", e1.getMessage());
			return error;
			
		}
		return result;  
		}
		public JSONObject updateDealers(String name,String company, String address, String phoneNumber) throws JSONException{
			JSONObject result=new JSONObject();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "root");
		        Statement statement = connection.createStatement();
		        String query= "update dealer set name='"+name+"', address='"+ address +"',phoneNumber='"+ phoneNumber +"' where company='"+company+"'";
		        statement.execute(query);
		        result.put("Status","Success");
			}catch (Exception e){
			JSONObject error=new JSONObject();
			error.put("Failure", e.getMessage());
			return error;
				
			}
		return result;

	}

	public JSONObject deleteDealers(String name)throws JSONException{
		JSONObject result=new JSONObject();
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "root");
			        Statement statement = connection.createStatement();
			       
					String query="delete from dealer where name='"+ name+"'";
			        statement.execute(query);
			        result.put("Status","Success");
				
				}catch (Exception e){
					JSONObject error=new JSONObject();
					error.put("Failure", e.getMessage());
					return error;
					
					
				}
		return result;
	  
	     }
	public JSONObject getDealerDetails(String company)throws JSONException{
		JSONObject result=new JSONObject();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "root");
	        Statement statement = connection.createStatement();
	        String query="select * from dealer where company='"+ company+"'";
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	        	result.put("dealerId", rs.getInt("dealerId"));
	        	result.put("name", rs.getString("name"));
	        	result.put("company", rs.getString("company"));
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
	public JSONObject getPhoneNumber(String phoneNumber)throws JSONException{
		JSONObject result=new JSONObject();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "root");
	        Statement statement = connection.createStatement();
	        String query="select * from dealer where phoneNumber='"+ phoneNumber+"' ";
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	        	result.put("dealerId", rs.getInt("dealerId"));
	        	result.put("name", rs.getString("name"));
	        	result.put("company", rs.getString("company"));
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
	public JSONArray getAllDealers()throws JSONException{
		JSONArray result=new JSONArray();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "root");
	        Statement statement = connection.createStatement();
	        String query="select * from dealer";
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	        	JSONObject employee = new JSONObject();
	        	employee.put("dealerId", rs.getInt("dealerId"));
	        	employee.put("name", rs.getString("name"));
	        	employee.put("company", rs.getString("company"));
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



