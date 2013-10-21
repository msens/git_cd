package testservlets;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created with IntelliJ IDEA.
 * User: michielsens
 * Date: 09/10/2013
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
public class TestJndiServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;

    public TestJndiServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        performTask(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        performTask(request, response);
    }

    private void performTask(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("TestJndiServlet says hi");
        out.println("<br/>");
        out.println("<br/>");
        out.println("Below the contents of the database:");

        out.println(testJndiDataSource());

        out.println("</body></html>");

    }

    public String testJndiDataSource() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer();
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQLTest");

            // This works too
            // Context envCtx = (Context) ctx.lookup("java:comp/env");
            // DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");

            conn = ds.getConnection();

            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM test.test");

            sb.append("<table border=\"1\">");
            sb.append("<tr>");
            sb.append("<th>Waarde in kolom 1</th>");
            sb.append("<th>Waarde in kolom 2</th>");
            sb.append("</tr>");

            while (rs.next()) {
                sb.append("<tr>");

                String kolom1 = rs.getString("kolom1");
                String kolom2 = rs.getString("kolom2");

                // concatenation in the append is on purpose to see whether Sonar will trigger a report on this.
                sb.append("<td>" + kolom1 + "</td>");
                sb.append("<td>" + kolom2 + "</td>");

                sb.append("</tr>");

                // sb.append("kolom1: " + kolom1 + ", kolom2: " + kolom2
               //          + "<br/>");
            }

            sb.append("</table>");


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (st != null) st.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return sb.toString();
    }

}
