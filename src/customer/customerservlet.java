package customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import customer.customerclass;
//import customer
/**
 * Servlet implementation class customerservlet
 */
@WebServlet("/customerservlet")
public class customerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public customerservlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String operation = req.getParameter("operation");
        customerclass empObject = new customerclass();
      
		if (operation.equals("add")) {
			String name = req.getParameter("name");
            String address = req.getParameter("address");
            String phoneNumber = req.getParameter("phoneNumber");
            JSONObject result;
			try {
				result = empObject.addCustomers( name,  address,  phoneNumber );
				resp.getWriter().print(result);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }} else if (operation.equals("update")) {
				
					String name = req.getParameter("name");
		            String address = req.getParameter("address");
		            String phoneNumber = req.getParameter("phoneNumber");
		            JSONObject result;
					try {
						result = empObject.updateCustomers( name, address, phoneNumber);
						resp.getWriter().print(result);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
		        } else if (operation.equals("delete")) {
		        	 String phoneNumber = req.getParameter("phoneNumber");
		            JSONObject result;
					try {
						result = empObject.deleteCustomers(phoneNumber);
						 resp.getWriter().print(result);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		           
		        } else if (operation.equals("getOneCustomer")) {
		        	 String phoneNumber = req.getParameter("phoneNumber");
		            JSONObject result;
					try {
						result = empObject.getCustomerDetails(phoneNumber);
						 resp.getWriter().print(result);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		           
		        } else if (operation.equals("getAllCustomers")) {
		            JSONArray result;
					try {
						result = empObject.getAllCustomers(); 
						   resp.getWriter().print(result);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		         
		        }
		    }
	}
