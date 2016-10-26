package dealer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dealer.dealerclass;

/**
 * Servlet implementation class dealerservlet
 */
@WebServlet("/dealerservlet")
public class dealerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dealerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
        dealerclass empObject = new dealerclass();
      
		if (operation.equals("add")) {
			String name = req.getParameter("name");
			String company = req.getParameter("company");
            String address = req.getParameter("address");
            String phoneNumber = req.getParameter("phoneNumber");
            JSONObject result;
			try {
				result = empObject.addDealers( name,company,  address,  phoneNumber );
				resp.getWriter().print(result);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }} else if (operation.equals("update")) {
				
				
					String name = req.getParameter("name");
					 String company = req.getParameter("company");
		            String address = req.getParameter("address");
		            String phoneNumber = req.getParameter("phoneNumber");
		            JSONObject result;
					try {
						result = empObject.updateDealers(  name,company, address, phoneNumber);
						resp.getWriter().print(result);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
		        } else if (operation.equals("delete")) {
		        	String name = req.getParameter("name");

		            JSONObject result;
					try {
						result = empObject.deleteDealers(name);
						 resp.getWriter().print(result);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		           
		        } else if (operation.equals("getOneDealer")) {
		        	 String company = req.getParameter("company");
		            JSONObject result;
					try {
						result = empObject.getDealerDetails(company);
						 resp.getWriter().print(result);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		           
					 else if (operation.equals("getPhoneNumber")) {
						  String phoneNumber = req.getParameter("phoneNumber");

				            JSONObject result;
							try {
								result = empObject.getPhoneNumber(phoneNumber);
								 resp.getWriter().print(result);
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				           
		        } else if (operation.equals("getAllDealers")) {
		            JSONArray result;
					try {
						result = empObject.getAllDealers();
						   resp.getWriter().print(result);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		         
		        }
		    }


	// TODO Auto-generated method stub
			

		/**
		 * @see HttpServlet#doPost1(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(req, resp);
		}

	
}