package ink.hearing.login;

import ink.hearing.Utils.DataSourceUtils;
import ink.hearing.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by zk on 2017/9/9.
 */

public class LoginServlet extends HttpServlet
{
    @Override
    public void init() throws ServletException
    {
        int i = 0;
        this.getServletContext().setAttribute("count", i);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("访问成功");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from tbl_user where uname = ? and upassword = ?";
        User user = null;
        try
        {
            user = queryRunner.query(sql, new BeanHandler<>(User.class), username, password);
            if (user != null)
            {
                ServletContext servletContext = this.getServletContext();
                Integer count = (Integer) servletContext.getAttribute("count");
                count++;
                response.getWriter().write("登陆成功" + user);
                servletContext.setAttribute("count", count);
                System.out.println(count);
            }
            else
            {
                response.getWriter().write("登陆失败，请重新确认");
            }
        }
        catch (SQLException e)
        {
            System.out.println("异常发生");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("盗链请求");
    }

    /*@Test
    public void demo01()
    {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from tbl_user where uname = ? and upassword = ?";
        User user = null;
        try
        {
            user = queryRunner.query(sql, new BeanHandler<>(User.class), "12354","fdkshf");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println(user);
    }*/
}
