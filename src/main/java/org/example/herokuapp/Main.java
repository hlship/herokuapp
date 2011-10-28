package org.example.herokuapp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Main class to start up an embedded copy of the Jetty web server to run the web application. The web server
 * is started on the port defined by the {@code PORT} environment variable (normally set by Heroku) or 8080
 * (when running locally).
 * <p/>
 * This is <em>not</em> part of the Tapestry quickstart archetype.
 */
public class Main {
    public static final String WEB_DIR = "src/main/webapp";

    public static void main(String[] args) throws Exception {

        String portEnv = System.getenv("PORT");

        // Allow for local execution, or on Heroku

        int port = portEnv == null ? 8080 : Integer.parseInt(portEnv);

        Server server = new Server(port);

        WebAppContext root = new WebAppContext();

        root.setContextPath("/");
        root.setDescriptor(WEB_DIR + "/WEB-INF/web.xml");
        root.setResourceBase(WEB_DIR);

        root.setParentLoaderPriority(true);

        server.setHandler(root);

        server.start();
        server.join();
    }

}
