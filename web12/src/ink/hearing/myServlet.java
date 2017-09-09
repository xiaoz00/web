package ink.hearing;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * Created by zk on 2017/9/8.
 */
public class myServlet extends javax.servlet.http.HttpServlet
{
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException
    {
        response.getWriter().write("hello world");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException
    {
        response.getWriter().write("hello world");
    }
}
