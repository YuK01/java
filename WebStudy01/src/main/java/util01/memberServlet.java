package util01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class memberServlet
 */
@WebServlet("/memberServlet")
public class memberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String id=request.getParameter("id");
		String passcode=request.getParameter("passcode");
		String re_passcode=request.getParameter("re_passcode");
		String mobile=request.getParameter("mobile");
		String[] arInter=request.getParameterValues("interest");
		
		String outstr="<html><head><title>회원가입</title></head><body>";
		if(name==null || gender==null || id==null || passcode==null || re_passcode==null ||
				mobile==null || arInter==null) {
			outstr+="전부 입력하세요.";
		} else {
			if(!passcode.equals(re_passcode)) {
				outstr+="비밀번호와 비밀번호 확인이 맞지 않습니다.";
			} else {				
				outstr+="실명:"+name+"<br>성별:"+gender+"<br>아이디:"+id+"<br>비밀번호:"+passcode+
						"<br>비밀번호확인:"+re_passcode+"<br>모바일번호:"+mobile+"<br>관심분야:";
				for(int i=0; i<arInter.length; i++) {
					outstr+=arInter[i]+",";
				}
			}
		}
		outstr+="</body></html>";
		PrintWriter out=response.getWriter();
		out.println(outstr);
		
	}

}
