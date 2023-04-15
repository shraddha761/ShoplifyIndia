/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DBConnection.DBConnection;
import DTO.OrderModel;
import DTO.loginDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "orderNow", urlPatterns = {"/orderNow"})
public class orderNow extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet order</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet order at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
           loginDTO auth = (loginDTO)request.getSession().getAttribute("auth");
            if(auth != null){
                String productId = request.getParameter("id");
                int productQuantity = Integer.parseInt(request.getParameter("quantity"));
                if(productQuantity <= 0){
                    productQuantity = 1;
                }
                OrderModel order = new OrderModel();
                order.setId(Integer.parseInt(productId));
                order.setUid(auth.getId());
                order.setQty(productQuantity);
                order.setDate(formatter.format(date));
                
                orderDAO d = new orderDAO(DBConnection.getConn());
                boolean a = d.insertOrder(order);
                if(a){
                    ArrayList<cancle>  cart_list =  (ArrayList<cancle>) request.getSession().getAttribute("cart-list");
              if(cart_list != null){
                  for(cancle c : cart_list){
                      if(c.getId() == Integer.parseInt(productId)){
                          cart_list.remove(cart_list.indexOf(c));
                          break;
                      }
                  }
              }
              System.out.print("remove ka code chala");
                    response.sendRedirect("order.jsp");   
                }else{
                   out.println("order fails");
                }
            }else{
                response.sendRedirect("login.jsp");
            }
        }catch(Exception t){
            System.out.print(t);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         doGet(request, response);
//        try(PrintWriter out = response.getWriter()){
//            
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = new Date();
//           loginDTO auth = (loginDTO)request.getSession().getAttribute("auth");
//            if(auth != null){
//                String productId = request.getParameter("id");
//                int productQuantity = Integer.parseInt(request.getParameter("quantity"));
//                if(productQuantity <= 0){
//                    productQuantity = 1;
//                }
//                OrderModel order = new OrderModel();
//                order.setId(Integer.parseInt(productId));
//                order.setUid(auth.getId());
//                order.setQty(productQuantity);
//                order.setDate(formatter.format(date));
//                
//                orderDAO d = new orderDAO(DBConnection.getConn());
//                boolean a = d.insertOrder(order);
//                if(a){
//                   response.sendRedirect("order.jsp");
//                }else{
//                   response.sendRedirect("order fail");
//                }
//            }else{
//                response.sendRedirect("login.jsp");
//            }
//        }catch(Exception t){
//            System.out.print(t);
//        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
