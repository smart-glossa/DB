

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class detailsclass {
	public JSONObject addDetails(int sNo, String name,String gender, String fathersName,String mothersName, String address, String dOfBirth, String work, String mobileNumber, String emailId, String whatsappNumber, String facebookId ) throws JSONException{
		JSONObject result=new JSONObject();
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Have to changes this.
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ndetails", "root", "root");
	        Statement statement = connection.createStatement();
	        
			String query= "insert into list(sNo,name,gender,fathersName,mothersName,address,dOfBirth,work,mobileNumber,emailId,whatsappNumber,facebookId)values("+ sNo +",'"+ name +"','"+ gender +"','"+ fathersName +"','"+ mothersName +"','"+ address +"','"+ dOfBirth +"','"+ work +"','"+ mobileNumber +"','"+ emailId +"','"+ whatsappNumber +"','"+ facebookId +"')";
	        statement.execute(query);
	        result.put("Status","Success");
		} catch (Exception e1) {
			JSONObject error=new JSONObject();
			error.put("Failure", e1.getMessage());
			return error;
			
		}
		return result;
		
	}
	public JSONObject updateDetails(int sNo, String name,String gender, String fathersName,String mothersName, String address, String dOfBirth, String work, String mobileNumber, String emailId, String whatsappNumber, String facebookId) throws JSONException{
		JSONObject result=new JSONObject();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ndetails", "root", "root");
	        Statement statement = connection.createStatement();
	        String query= "update list set name='"+name+"', gender='"+ gender +"',fathersName='"+ fathersName +"',mothersName='"+ mothersName +"',address='"+ address +"',dOfBirth='"+ dOfBirth +"',work='"+ work +"',mobileNumber='"+ mobileNumber +"',emailId='"+ emailId +"',whatsappNumber='"+ whatsappNumber +"',facebookId='"+ facebookId +"' where sNo="+ sNo +" ";
	        statement.execute(query);
	        result.put("Status","Success");
		}catch (Exception e){
		JSONObject error=new JSONObject();
		error.put("Failure", e.getMessage());
		return error;
			
		}
	return result;

}

public JSONObject deleteEmployee(int sNo)throws JSONException{
	JSONObject result=new JSONObject();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ndetails", "root", "root");
		        Statement statement = connection.createStatement();
		        String query="delete from list where sNo="+ sNo;
		        statement.execute(query);
		        result.put("Status","Success");
			
			}catch (Exception e){
				JSONObject error=new JSONObject();
				error.put("Failure", e.getMessage());
				return error;
				
				
			}
	return result;
  
     }
public JSONObject getEmployeeDetails(int sNo)throws JSONException{
	JSONObject result=new JSONObject();
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ndetails", "root", "root");
        Statement statement = connection.createStatement();
        String query="select * from list where sNo="+ sNo;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
        	result.put("sNo", rs.getInt("sNo"));
        	result.put("name", rs.getString("name"));
        	result.put("gender", rs.getString("gender"));
        	result.put("fathersName",rs.getString("fathersName"));
        	result.put("mothersName", rs.getString("mothersName"));
        	result.put("address", rs.getString("address"));
        	result.put("dOfBirth", rs.getString("dOfBirth"));
        	result.put("work", rs.getString("work"));
        	result.put("mobileNumber", rs.getString("mobileNumber"));
        	result.put("emailId", rs.getString("emailId"));
        	result.put("whatsappNumber",rs.getString("whatsappNumber"));
        	result.put("facebookId", rs.getString("facebookId"));
        }
	}catch (Exception e){
		JSONObject error=new JSONObject();
		error.put("Failure", e.getMessage());
		return error;
		
	}
	return result;
}
public JSONArray getAllEmployees()throws JSONException{
	JSONArray result=new JSONArray();
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ndetails", "root", "root");
        Statement statement = connection.createStatement();
        String query="select * from list";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
        	JSONObject employee = new JSONObject();
        	employee.put("sNo", rs.getInt("sNo"));
        	employee.put("name", rs.getString("name"));
        	employee.put("gender", rs.getString("gender"));
        	employee.put("fathersName", rs.getString("fathersName"));
        	employee.put("mothersName",rs.getString("mothersName"));
        	employee.put("address",rs.getString("address"));
        	employee.put("dOfBirth", rs.getString("dOfBirth"));
        	employee.put("work", rs.getString("work"));
        	employee.put("mobileNumber",rs.getString("mobileNumber"));
        	employee.put("emailId", rs.getString("emailId"));
        	employee.put("whatsappNumber", rs.getString("whatsappNumber"));
        	employee.put("facebookId", rs.getString("facebookId"));
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
