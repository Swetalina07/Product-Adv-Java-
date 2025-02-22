package servletPrograms;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.util.ArrayList;
import Beans.ProductBean;
import DAO.FetchingProductDAO;
@SuppressWarnings("serial")
@WebServlet("/viewCproduct")
public class ViewCustProducts extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		HttpSession ht=req.getSession(false);
		if(ht==null)
		{
			req.setAttribute("msg","Session Expired..<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
		   ArrayList<ProductBean> al =new FetchingProductDAO().view();
			ht.setAttribute("al", al);
			req.getRequestDispatcher("ViewCustProduct.jsp").forward(req, res);
	  }
    }

	
}
