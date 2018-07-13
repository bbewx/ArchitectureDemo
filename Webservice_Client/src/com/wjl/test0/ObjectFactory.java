
package com.wjl.test0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.wjl.test0 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Handler_QNAME = new QName("http://test0.wjl.com/", "handler");
    private final static QName _HandlerResponse_QNAME = new QName("http://test0.wjl.com/", "handlerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wjl.test0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HandlerResponse }
     * 
     */
    public HandlerResponse createHandlerResponse() {
        return new HandlerResponse();
    }

    /**
     * Create an instance of {@link Handler }
     * 
     */
    public Handler createHandler() {
        return new Handler();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Handler }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test0.wjl.com/", name = "handler")
    public JAXBElement<Handler> createHandler(Handler value) {
        return new JAXBElement<Handler>(_Handler_QNAME, Handler.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HandlerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test0.wjl.com/", name = "handlerResponse")
    public JAXBElement<HandlerResponse> createHandlerResponse(HandlerResponse value) {
        return new JAXBElement<HandlerResponse>(_HandlerResponse_QNAME, HandlerResponse.class, null, value);
    }

}
