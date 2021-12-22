package util01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Secondservlet
 */
@WebServlet("/Secondservlet")
public class Secondservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Secondservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String str1=req.getParameter("a");
		String str2=req.getParameter("b");
		String str3=req.getParameter("c");
		int a=Integer.parseInt(str1);
		int b=Integer.parseInt(str2);
		int c=Integer.parseInt(str3);
		int x1=(int)(-b+Math.sqrt(b*b-4*a*c))/(2*a);
		int x2=(int)(-b-Math.sqrt(b*b-4*a*c))/(2*a);
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>2차방정식</title></head><body>x1= "+x1+"<br> x2= "+x2+"</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
