package servletPrograms;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Beans.ProductBean;
import DAO.ByProductDAO;

@SuppressWarnings("serial")
@WebServlet("/billProduct")
public class BillProduct extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired..<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		} else {
			String code = req.getParameter("pcode");
			int reqqty = Integer.parseInt(req.getParameter("reqqty"));
			@SuppressWarnings("unchecked")
			ArrayList<ProductBean> al = (ArrayList<ProductBean>) hs.getAttribute("al");
			Iterator<ProductBean> it = al.iterator();
			while (it.hasNext()) {
				ProductBean pb = (ProductBean) it.next();
				if (pb.getCode().equals(code)) {
					req.setAttribute("pb", pb);
					pb.setCode(code);
					pb.setQty(pb.getQty()-(reqqty));
					int k = new ByProductDAO().purchase(pb);
					if (k > 0) {
						float totalAmount = pb.getPrice() * reqqty;
						req.setAttribute("reqqty", reqqty);
						req.setAttribute("totAmt", totalAmount);
						req.getRequestDispatcher("BillProduct.jsp").forward(req, res);
						break;
					}
				}

			}
		}
	}

}
