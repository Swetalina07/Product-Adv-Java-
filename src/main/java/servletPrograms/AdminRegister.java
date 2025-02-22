package servletPrograms;
import java.io.IOException;

import Beans.UserBean;
import DAO.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/adminreg")
public class AdminRegister extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession();
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, resp);
		}
		else
		{
		String un = req.getParameter("us");
		String ps = req.getParameter("pa");
		String fn = req.getParameter("fn");
		String ln = req.getParameter("ln");
		String mid = req.getParameter("mid");
		Long phno=Long.parseLong(req.getParameter("phno"));
		UserBean ub =new UserBean();
		ub.setUserName(un);
		ub.setPassWord(ps);
		ub.setFirstName(fn);
		ub.setLastName(ln);
		ub.setEmail(mid);
		ub.setMobile(phno);
		int k=new AdminDao().insert(ub);
		if(k>0)
		{
			req.setAttribute("msg","Register Succefull...<br>");
			req.getRequestDispatcher("RegisterSuccess.jsp").forward(req, resp);
		}
		
		}
	}

	}


