/**
 * HelloServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public class HelloServiceServiceLocator extends org.apache.axis.client.Service implements ws.HelloServiceService {

    public HelloServiceServiceLocator() {
    }


    public HelloServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HelloServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HelloServicePort
    private java.lang.String HelloServicePort_address = "http://localhost:8888/webdemo/services/hello";

    public java.lang.String getHelloServicePortAddress() {
        return HelloServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HelloServicePortWSDDServiceName = "HelloServicePort";

    public java.lang.String getHelloServicePortWSDDServiceName() {
        return HelloServicePortWSDDServiceName;
    }

    public void setHelloServicePortWSDDServiceName(java.lang.String name) {
        HelloServicePortWSDDServiceName = name;
    }

    public ws.HelloService getHelloServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloServicePort(endpoint);
    }

    public ws.HelloService getHelloServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ws.HelloServicePortBindingStub _stub = new ws.HelloServicePortBindingStub(portAddress, this);
            _stub.setPortName(getHelloServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloServicePortEndpointAddress(java.lang.String address) {
        HelloServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws.HelloService.class.isAssignableFrom(serviceEndpointInterface)) {
                ws.HelloServicePortBindingStub _stub = new ws.HelloServicePortBindingStub(new java.net.URL(HelloServicePort_address), this);
                _stub.setPortName(getHelloServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("HelloServicePort".equals(inputPortName)) {
            return getHelloServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws/", "HelloServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws/", "HelloServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HelloServicePort".equals(portName)) {
            setHelloServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
