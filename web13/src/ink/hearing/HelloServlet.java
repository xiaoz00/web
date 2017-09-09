package ink.hearing;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zk on 2017/9/8.
 */
public class HelloServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("这是get请求");

        ServletContext servletContext = getServletContext();
        String driver = servletContext.getInitParameter("driver");
        System.out.println(driver);

        String realPath = servletContext.getRealPath("a.txt");
        System.out.println(realPath);
    //    web-inf是被保护的  不可以被直接访问



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.getWriter().write("这是poet请求并交给get方式处理");
        doGet(request, response);
    }

}
