

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddMenu
 */
@WebServlet("/AddMenu")
public class AddMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Connection conn=null;
	    PreparedStatement pstmt=null;
	    
	    String url="jdbc:oracle:thin:@localhost:1521:orcl";
	    String userid="ora_user";
	    String passcode="human123";
		String sql="insert into menu values(seq_menu.nextval,?,?)";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url,userid,passcode);
			pstmt=conn.prepareStatement(sql);			
			
			pstmt.setString(1,request.getParameter("name"));
			pstmt.setInt(2,Integer.parseInt(request.getParameter("price")));
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)	pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
