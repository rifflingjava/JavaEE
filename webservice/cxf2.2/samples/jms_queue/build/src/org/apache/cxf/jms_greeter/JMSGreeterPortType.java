
package org.apache.cxf.jms_greeter;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.1
 * Tue Jul 14 22:54:25 CST 2009
 * Generated source version: 2.1
 * 
 */

@WebService(targetNamespace = "http://cxf.apache.org/jms_greeter", name = "JMSGreeterPortType")
@XmlSeeAlso({org.apache.cxf.jms_greeter.types.ObjectFactory.class})

public interface JMSGreeterPortType {

    @ResponseWrapper(localName = "greetMeResponse", targetNamespace = "http://cxf.apache.org/jms_greeter/types", className = "org.apache.cxf.jms_greeter.types.GreetMeResponse")
    @RequestWrapper(localName = "greetMe", targetNamespace = "http://cxf.apache.org/jms_greeter/types", className = "org.apache.cxf.jms_greeter.types.GreetMe")
    @WebResult(name = "responseType", targetNamespace = "http://cxf.apache.org/jms_greeter/types")
    @WebMethod
    public java.lang.String greetMe(
        @WebParam(name = "requestType", targetNamespace = "http://cxf.apache.org/jms_greeter/types")
        java.lang.String requestType
    );

    @ResponseWrapper(localName = "sayHiResponse", targetNamespace = "http://cxf.apache.org/jms_greeter/types", className = "org.apache.cxf.jms_greeter.types.SayHiResponse")
    @RequestWrapper(localName = "sayHi", targetNamespace = "http://cxf.apache.org/jms_greeter/types", className = "org.apache.cxf.jms_greeter.types.SayHi")
    @WebResult(name = "responseType", targetNamespace = "http://cxf.apache.org/jms_greeter/types")
    @WebMethod
    public java.lang.String sayHi();

    @Oneway
    @RequestWrapper(localName = "greetMeOneWay", targetNamespace = "http://cxf.apache.org/jms_greeter/types", className = "org.apache.cxf.jms_greeter.types.GreetMeOneWay")
    @WebMethod
    public void greetMeOneWay(
        @WebParam(name = "requestType", targetNamespace = "http://cxf.apache.org/jms_greeter/types")
        java.lang.String requestType
    );
}
