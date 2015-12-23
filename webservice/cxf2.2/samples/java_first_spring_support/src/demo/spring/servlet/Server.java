/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package demo.spring.servlet;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Handler;
import org.mortbay.jetty.handler.DefaultHandler;
import org.mortbay.jetty.handler.HandlerCollection;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;

public class Server {

    protected Server() throws Exception {
        System.out.println("Jetty Starting Server");

        /**
         * Important: This code simply starts up a servlet container and adds
         * the web application in src/webapp to it. Normally you would be using
         * Jetty or Tomcat and have the webapp packaged as a WAR. This is simply
         * as a convenience so you do not need to configure your servlet
         * container to see CXF in action!
         */
        org.mortbay.jetty.Server server = new org.mortbay.jetty.Server();

        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(9002);
        server.setConnectors(new Connector[] { connector });

        WebAppContext webappcontext = new WebAppContext();

        webappcontext.setContextPath("/");
        webappcontext.setWar("webapp");
        // webappcontext.setWar("D:/Java/eclipse_projects/webservice/source/cxf2.2/samples/java_first_spring_support/src/webapp");

        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[] { webappcontext, new DefaultHandler() });

        server.setHandler(handlers);
        server.start();
        server.join();

        System.out.println("Jetty Server ready...");
    }

    public static void main(String args[]) throws Exception {
        new Server();
    }

}
