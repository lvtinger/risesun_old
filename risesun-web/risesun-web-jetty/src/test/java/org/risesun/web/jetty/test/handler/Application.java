package org.risesun.web.jetty.test.handler;

import org.eclipse.jetty.server.Server;

public class Application {
    public static void main(String[] args) throws Exception {
        Server server = new Server(80);
        server.setHandler(new HelloHandler());
        server.start();
        server.join();
    }
}
