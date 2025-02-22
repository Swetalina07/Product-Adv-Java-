package servletPrograms;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import Beans.CustomerBean;
import DAO.CustomerDAO;
@SuppressWarnings("serial")
@WebServlet("/customer")
public class CustomerLogin extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		CustomerBean cb=new CustomerDAO().custValid(req.getParameter("uname"), req.getParameter("pword"));
		if(cb==null)
		{
			req.setAttribute("msg","UserName/PassWord is wrong");
			RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		
		}
		
		else
		{
			HttpSession ht = req.getSession();
			ht.setAttribute("cbean",cb);
			req.setAttribute("msg","Welcome Customer :");
			RequestDispatcher rd = req.getRequestDispatcher("CustomerLoginSuccess.jsp");
			rd.forward(req, res);
		}
		
	}

}
