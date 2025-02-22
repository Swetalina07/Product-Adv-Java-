package servletPrograms;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.util.ArrayList;
import java.util.Iterator;


import Beans.ProductBean;
@SuppressWarnings("serial")
@WebServlet("/editproduct")
public class EditProduct extends HttpServlet
{
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired..<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			String code = req.getParameter("pcode");
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("al");
			Iterator<ProductBean> it = al.iterator();
			while(it.hasNext())
			{
				ProductBean pb=(ProductBean)it.next();
				if(pb.getCode().equals(code))
				{
					req.setAttribute("pb", pb);
					break;
				}
			}
			req.getRequestDispatcher("EditProduct.jsp").forward(req, res);
			
		}
		
	}

}
