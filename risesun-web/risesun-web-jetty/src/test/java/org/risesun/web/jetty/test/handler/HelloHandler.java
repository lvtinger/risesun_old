package org.risesun.web.jetty.test.handler;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloHandler extends AbstractHandler {
    @Override
    public void handle(
            String s,
            Request request,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)
            throws IOException, ServletException {
        httpServletResponse.setContentType("text/html; charset-set=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.getWriter().println("<h1>hello " + s + "</h1>");
        request.setHandled(true);
    }
}
