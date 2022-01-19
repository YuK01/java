

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SumC
 */
@WebServlet("/SumC")
public class SumC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SumC() {
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
	    Statement stmt=null;
	    ResultSet rs=null;
	    
	    String url="jdbc:oracle:thin:@localhost:1521:orcl";
	    String userid="ora_user";
	    String passcode="human123";
		String sql="select mobile,sum(total) as tt"
				+ " from cafe_sales"
				+ " where substr(sold_time,1,8)=to_char(sysdate,'yyyymmdd')"
				+ " group by mobile"
				+ " order by sum(total) desc";
		String strReturn="";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url,userid,passcode);
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			
			while(rs.next()){
				if(!strReturn.equals("")) strReturn+=";";
				strReturn+=rs.getString("mobile")+","+rs.getInt("tt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		response.getWriter().print(strReturn);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
