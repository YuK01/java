package util01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class opServlet
 */
@WebServlet("/opServlet")
public class opServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public opServlet() {
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
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		String str1=req.getParameter("val1");
		String str2=req.getParameter("val2");
		String oper=req.getParameter("oper");
		int val1=Integer.parseInt(str1);
		int val2=Integer.parseInt(str2);
		int result=0;
		if(oper.equals("+")) {
			result=val1+val2;
		} else if(oper.equals("-")) {
			result=val1-val2;
		} else if(oper.equals("*")) {
			result=val1*val2;
		} else {
			if(val2==0) {
				return; //0이면 에러나서..
			} else {
				result=val1/val2;	
			}
		}
		out.println("<html><head><title>사칙연산</title></head><body>");
		out.println("value1: "+val1+"<br>");
		out.println("value2: "+val2+"<br>");
		out.println("operator: "+oper+"<br>");
		out.println("result: "+result);
		out.println("</body></html>");
	}

}
