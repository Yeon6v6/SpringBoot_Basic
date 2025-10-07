package com.java.spring;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;

public class Application {
    public static void main(String[] args) {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        // 실제 웹 서버 인스턴스 생성
        WebServer webServer = factory.getWebServer();
        webServer.start(); // 톰캣 서블릿 컨테이너 실행
    }
}
