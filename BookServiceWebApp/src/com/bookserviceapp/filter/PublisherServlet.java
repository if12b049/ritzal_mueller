package com.bookserviceapp.filter;

import com.bookserviceapp.businessobjects.Publisher;
import com.bookserviceapp.services.PublisherService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
@SuppressWarnings("serial")
@WebServlet("/publisher")
public class PublisherServlet extends HttpServlet {
    @Inject
    private PublisherService service;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");

        List<Publisher> allPublishers = service.getAllPublishers();
        for (Publisher publisher : allPublishers) {
            out.println("<h1>" + publisher.getName() + "</h1>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
*/