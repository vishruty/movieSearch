package com.movie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddMovie
 */
@WebServlet("/add_movie")
public class AddMovie extends HttpServlet { private static final long serialVersionUID = 1L;

public AddMovie() {
    super();
    // TODO Auto-generated constructor stub
}

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
    response.setContentType("text/html");
    String newMovies[]=request.getParameterValues("movies_to_watch");
    HttpSession session= request.getSession();
   
    CartBean cartBean = null;
    Object objCartBean = session.getAttribute("cart");
    PrintWriter out = response.getWriter();
      if(objCartBean!=null) {
       cartBean = (CartBean) objCartBean ;
      } else {
       cartBean = new CartBean();
       session.setAttribute("cart", cartBean);
      }
     
      for(String part: newMovies) {
    	  if(cartBean.cartSize()<10) {
    		  cartBean.addCartItem(part);
    	  }
    	  else{
    		  String str="You have adready added 10 movies";
    	      request.setAttribute("error", str);
    	      RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
    	      rd.forward(request, response);
    	  }
      }
      int k=10-cartBean.cartSize();
      String str="Add " + k+" more movies";
      request.setAttribute("countLeft", str);
      RequestDispatcher rd = request.getRequestDispatcher("addMoreMovies.jsp");
      rd.forward(request, response);
      
}

}


