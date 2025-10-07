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
        WebServer webServer = factory.getWebServer(servletContext -> {
            servletContext.addServlet("hello", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp)
                        throws ServletException, IOException {
                    resp.setStatus(200);
                    resp.setContentType("text/plain");
                    // 요청 파라미터를 읽어 동적으로 응답하기
                    resp.getWriter().println("Hello " + req.getParameter("name"));
                }
            }).addMapping("/hello");
        });
        webServer.start();
    }
}
