/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shrad
 */
@WebServlet(name = "qtyIncDec", urlPatterns = {"/qtyIncDec"})
public class qtyIncDec extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet qtyIncDec</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet qtyIncDec at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try(PrintWriter out = response.getWriter();){
          response.setContentType("text/html;charset=UTF-8");
          String action = request.getParameter("action");
          int id = Integer.parseInt(request.getParameter("id"));
          System.out.print("inc dec servlet");
          ArrayList<cancle> cart_list = (ArrayList<cancle>) request.getSession().getAttribute("cart-list");
        
        if(action != null && id >= 1){
            if(action.equals("inc")){
                for(cancle c : cart_list){
                    if(c.getId() == id){
                        int quantity = c.getQuantity();
                        quantity++;
                        c.setQuantity(quantity);
                        break; 
                    }
                }
                response.sendRedirect("cart.jsp");
            }
            if(action.equals("dec")){
                for(cancle c : cart_list){
                    if(c.getId() == id && c.getQuantity() > 1){
                        int quantity = c.getQuantity();
                        quantity--;
                        c.setQuantity(quantity);
                        break; 
                    }
                }
                response.sendRedirect("cart.jsp");
            }
        }else{
            response.sendRedirect("cart.jsp");
        }
    }catch(Exception e) {
       System.out.print(e);
    }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
