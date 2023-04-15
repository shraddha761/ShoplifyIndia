package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DTO.loginDTO;
import java.text.DecimalFormat;
import DBConnection.DBConnection;
import DAO.productDAO;
import java.util.List;
import DAO.cancle;
import java.util.ArrayList;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/head.jsp");
    _jspx_dependants.add("/main.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

     loginDTO auth=(loginDTO)request.getSession().getAttribute("auth");
                if(auth!=null){
                  request.setAttribute("auth",auth);
                 }
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
 
      out.write(' ');
      out.write('\n');

ArrayList<cancle> cart_list = (ArrayList<cancle>) session.getAttribute("cart-list");
List<cancle> cartProduct = null;
if(cart_list != null){
   productDAO pd = new productDAO(DBConnection.getConn());
  cartProduct = pd.getCartProduct(cart_list);
 double total =  pd.getTotalCartPrice(cart_list);
  request.setAttribute("cart_list" , cart_list);
  request.setAttribute("total", total);
}

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cart</title>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" >\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css\" />");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .table tbody td{\n");
      out.write("                vertical-align: middle;\n");
      out.write("            }\n");
      out.write("            .btn-incre,.btn-decre{\n");
      out.write("                box-shadow: none;\n");
      out.write("                font-size: 25px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("    <a class=\"navbar-brand\" href=\"index.jsp\">Cosmetics</a>\n");
      out.write("  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("  </button>\n");
      out.write("\n");
      out.write("  <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("    <ul class=\"navbar-nav ml-auto\">\n");
      out.write("        \n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">\n");
      out.write("      <div class=\"navbar-nav\">\n");
      out.write("        <a class=\"nav-link active\" aria-current=\"page\" href=\"index.jsp\">Home</a>\n");
      out.write("        <li class=\"nav-item\">\n");
      out.write("          <a class=\"nav-link\" href=\"cart.jsp\">Cart<span class=\"badge badge-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cart_list.size()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span></a>\n");
      out.write("      </li>\n");
      out.write("      ");
if(auth!=null){
      out.write("\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("               <a class=\"nav-link\" href=\"order.jsp\">Order</a>\n");
      out.write("      </li>\n");
      out.write("       ");
} 
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("              <a class=\"nav-link\" href=\"login.jsp\">Login</a>\n");
      out.write("                </li>\n");
      out.write("                    \n");
      out.write("      </li> \n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("        \n");
      out.write("   <div class =\"container\">\n");
      out.write("      <div class=\"d-flex py-3\"><h3>Total Price: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ total>0?dcf.format(total) : 0 }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("          <a class=\"mx-3 btn btn-primary\" href=\"checkout\">Check outs</a></div>\n");
      out.write("      <table class=\"table table-loght\">\n");
      out.write("  <thead>\n");
      out.write("    <tr>\n");
      out.write("               <th scope=\"col\">Name</th>\n");
      out.write("               <th scope=\"col\">Category</th>\n");
      out.write("               <th scope=\"col\">Price</th>\n");
      out.write("               <th scope=\"col\">Buy Now</th>\n");
      out.write("               <th scope=\"col\">Cancel</th>\n");
      out.write("           </tr>\n");
      out.write("       </thead>\n");
      out.write("     <tbody>\n");
      out.write("      ");
 
         if(cart_list != null){
             for(cancle c : cartProduct){
      out.write("\n");
      out.write("                 <tr>\n");
      out.write("                       <td>");
      out.print(c.getName());
      out.write("</td>\n");
      out.write("                       <td>");
      out.print(c.getCategory());
      out.write("</td>\n");
      out.write("                       <td>");
      out.print(c.getPrice());
      out.write("</td>\n");
      out.write("                       <td>\n");
      out.write("                           <form action=\"orderNow\" method=\"post\" class=\"form-inline\">\n");
      out.write("                               <input type=\"hidden\" name=\"id\" value=\"");
      out.print(c.getId());
      out.write("\" class=\"form-input\">\n");
      out.write("                               <div class=\"form-group d-flex justify-content-between w-50\">\n");
      out.write("                                   <a class=\"btn btn-sm btn-decre\" href=\"qtyIncDec?action=dec&id=");
      out.print(c.getId());
      out.write("\"><i class=\"fas fa-minus-square\"></i></a>\n");
      out.write("                                   <input type=\"text\" name=\"quantity\" class=\"form-control w-50\" value=\"");
      out.print(c.getQuantity());
      out.write("\" readonly>\n");
      out.write("                                   <a class=\"btn btn-sm btn-incre\" href=\"qtyIncDec?action=inc&id=");
      out.print(c.getId());
      out.write("\"><i class=\"fas fa-plus-square\"></i></a>\n");
      out.write("                               </div>\n");
      out.write("                              \n");
      out.write("                               <a href=\"orderNow?quantity=1&id=");
      out.print(c.getId());
      out.write("\" class=\"btn btn-primary\">Buy Now</a>\n");
      out.write("                           </form>\n");
      out.write("                       </td>\n");
      out.write("                       <td><a class=\"btn btn-sm btn-danger\" href=\"Remove?id=");
      out.print(c.getId());
      out.write("\">Remove</a></td>\n");
      out.write("                   </tr>\n");
      out.write("             ");
}
         }
      
      out.write("\n");
      out.write("     </td>\n");
      out.write("  </tbody>\n");
      out.write("</table>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" ></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\" ></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\"></script>");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
