package com.fit.calories_management.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {

    private int count = 0;

    /*int getCount() {
        System.out.println( "In getCount() method" );
        return count;
    }*/

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.write("<html><body>");
        out.write("Page count is:");
        out.print(++count);
        out.write("</body></html>");
        out.close();
    }
}