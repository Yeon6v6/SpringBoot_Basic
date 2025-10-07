package com.java.spring;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        // 컨테이너에 서블릿 등록
        WebServer webServer = factory.getWebServer(servletContext -> {
            servletContext.addServlet("hello", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp)
                        throws ServletException, IOException {
                    resp.setStatus(200);
                    resp.setContentType("text/plain");
                    resp.getWriter().println("Hello Servlet");
                }
            }).addMapping("/hello");
        });
        webServer.start();
    }
}
