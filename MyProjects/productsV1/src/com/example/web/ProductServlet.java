package com.example.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.example.dao.ProductsDao;
import com.example.model.Products;

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
    	
        super();
        // TODO Auto-generated constructor stub
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int result =0;
		String bc = request.getParameter("barcode");
		String nm = request.getParameter("name");
		String c = request.getParameter("color");
		String dsc = request.getParameter("description");
		
		Products product = new Products();
		product.setBarcode(bc);
		product.setName(nm);
		product.setColor(c);
		product.setDescription(dsc);
		product.setSuccessCode(0);
		
		
		try {
			result = product.registerPRoduct(product);
			if (result == -1){//an yparxei dld hdh sth vash
					//product.setSuccessCode(-1);
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		//response.sendRedirect(arg0);
		request.setAttribute("styles", product);
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
		
	}
}


