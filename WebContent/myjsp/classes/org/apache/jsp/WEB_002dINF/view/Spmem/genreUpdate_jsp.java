/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.56
 * Generated at: 2020-09-22 14:11:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.Spmem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class genreUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("jar:file:/Users/Haka4700/SpringWork/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpinUrOwn/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/Users/Haka4700/SpringWork/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpinUrOwn/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1595550836000L));
    _jspx_dependants.put("jar:file:/Users/Haka4700/SpringWork/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpinUrOwn/WEB-INF/lib/jstl-1.2.jar!/META-INF/sql.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<style type=\"text/css\">\n");
      out.write(".tab { white-space: pre; }\n");
      out.write("</style>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/shorthandcss@1.1.1/dist/shorthand.min.css\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Muli:200,300,400,500,600,700,800,900&display=swap\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\thref=\"https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css\" />\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function reggenre(){\n");
      out.write("\t/* alert('regatmos1') */\n");
      out.write("\tClassic = document.getElementById(\"Classic\")\n");
      out.write("\tJazz = document.getElementById(\"Jazz\")\n");
      out.write("\tRock = document.getElementById(\"Rock\")\n");
      out.write("\tMetal = document.getElementById(\"Metal\")\n");
      out.write("\tRap = document.getElementById(\"Rap\")\n");
      out.write("\tElectronic = document.getElementById(\"Electronic\")\n");
      out.write("\tMeaningful_Joyful = document.getElementById(\"Meaningful~Joyful\")\n");
      out.write("\t$.ajax({\n");
      out.write("\t\turl:\"/SpinUrOwn/reggenre.ma\",\n");
      out.write("\t\ttype:\"POST\",\n");
      out.write("\t\tdata: {\n");
      out.write("\t\t\tClassic : Classic.value,\n");
      out.write("\t\t\tJazz : Jazz.value,\n");
      out.write("\t\t\tRock : Rock.value,\n");
      out.write("\t\t\tMetal : Metal.value,\n");
      out.write("\t\t\tRap : Rap.value,\n");
      out.write("\t\t\tElectronic : Electronic.value,\n");
      out.write("\t\t\tMeaningful_Joyful : Meaningful_Joyful.value\n");
      out.write("\t\t},\n");
      out.write("\t\tsuccess : function(data) {\n");
      out.write("\t\t\talert(\"genreUpdate1 done!\")\n");
      out.write("\t\t}\n");
      out.write("\t});//ajax end\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body class=\"bg-black muli\">\n");
      out.write("<hr/>\n");
      out.write("<form method=\"post\">\n");
      out.write("<font class=\"white fs-m3 fw-200\" size=\"12\">\n");
      out.write("\tPlz show your Prefered Component!\n");
      out.write("\t<br/>\n");
      out.write("\t\tClassic :  <span class=\"tab\">&#9;&#9;&#9;</span> \n");
      out.write("\t\t<input type=\"range\" name=\"Classic\" id=\"Classic\"\n");
      out.write("\t\t\t value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${classic}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" min=\"1\" max=\"9\" maxlength=\"40\"><br/>\n");
      out.write("\t\tJazz : <span class=\"tab\">&#9;&#9;&#9;&#9;</span> \n");
      out.write("\t\t<input type=\"range\" name=\"Jazz\" id=\"Jazz\"\n");
      out.write("\t\t\t value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Jazz}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" min=\"1\" max=\"9\" maxlength=\"40\"><br/>\n");
      out.write("\t\tRock :<span class=\"tab\">&#9;&#9;&#9;&#9;</span> \n");
      out.write("\t\t<input type=\"range\" name=\"Rock\" id=\"Rock\"\n");
      out.write("\t\t\t value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Rock}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" min=\"1\" max=\"9\" maxlength=\"40\"><br/>\n");
      out.write("\t\tMetal : <span class=\"tab\">&#9;&#9;&#9;&#9;</span>             \n");
      out.write("\t\t<input type=\"range\" name=\"Metal\" id=\"Metal\"\n");
      out.write("\t\t\t value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Metal}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" min=\"1\" max=\"9\" maxlength=\"40\"><br/>\n");
      out.write("\t\tRap : <span class=\"tab\">&#9;&#9;&#9;&#9;</span>  \n");
      out.write("\t\t<input type=\"range\" name=\"Rap\" id=\"Rap\"\n");
      out.write("\t\t\t value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Rap}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" min=\"1\" max=\"9\" maxlength=\"40\"><br/>\n");
      out.write("\t\tElectronic :<span class=\"tab\">&#9;&#9;&#9;</span> \n");
      out.write("\t\t<input type=\"range\" name=\"Electronic\" id=\"Electronic\"\n");
      out.write("\t\t\t value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Electronic}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" min=\"1\" max=\"9\" maxlength=\"40\"><br/>\n");
      out.write("\t\tMeaningful~Joyful :<span class=\"tab\">&#9;</span> \n");
      out.write("\t\t<input type=\"range\" name=\"Meaningful_Joyful\" id=\"Meaningful~Joyful\"\n");
      out.write("\t\t value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Meaningful_Joyful}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" min=\"1\" max=\"9\" maxlength=\"40\"><br/></font>\n");
      out.write("\t\t<input type=\"button\" value=\"submit\" onclick=\"return reggenre()\"\n");
      out.write("\t\tclass=\"button-lg bg-indigo-lightest-20 indigo-lightest \n");
      out.write("\t\tfocus-white fw-300 fs-s3 mr-0 br-l-0\">\n");
      out.write("\t</form>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}