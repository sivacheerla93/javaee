package ws;

public class EmployeeServiceProxy implements ws.EmployeeService_PortType {
  private String _endpoint = null;
  private ws.EmployeeService_PortType employeeService_PortType = null;
  
  public EmployeeServiceProxy() {
    _initEmployeeServiceProxy();
  }
  
  public EmployeeServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeeServiceProxy();
  }
  
  private void _initEmployeeServiceProxy() {
    try {
      employeeService_PortType = (new ws.EmployeeService_ServiceLocator()).getEmployeeServicePort();
      if (employeeService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employeeService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employeeService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employeeService_PortType != null)
      ((javax.xml.rpc.Stub)employeeService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.EmployeeService_PortType getEmployeeService_PortType() {
    if (employeeService_PortType == null)
      _initEmployeeServiceProxy();
    return employeeService_PortType;
  }
  
  public ws.Employee[] getEmployees() throws java.rmi.RemoteException{
    if (employeeService_PortType == null)
      _initEmployeeServiceProxy();
    return employeeService_PortType.getEmployees();
  }
  
  public ws.Employee getDetails(java.lang.String empid) throws java.rmi.RemoteException{
    if (employeeService_PortType == null)
      _initEmployeeServiceProxy();
    return employeeService_PortType.getDetails(empid);
  }
  
  
}