package com.itfusen.comm.webservice;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

/**
 * 发送主数据到子个系统通用方法
 * @param urlname		接口地址
 * @param namespace		接口域名
 * @param function		接口方法名
 * @param str			数据json字符串
 * @param parameterName 接口参数名
 */
public class SendUtils {
	
	
	public static String sendTo(String urlname,String namespace,String function,String str,String parameterName) {
		String result = null;
		try {     
//			 	  String op = "{\"status\":\"0\",\"oldcode\":\"700001\",\"isdelete\":\"0\",\"zt\":\"9\",\"tpsc\":\"1234567\",\"qx\":\"1234567\",\"ywy\":\"111\",\"fzrdh\":\"565656\",\"fzr\":\"112\",\"qx\":\"1234567\",\"sq\":\"145600\",\"mdgpsjwd\":\"1212121\",\"mdgps\":\"1278091\",\"terminalcode\":\"800001\",\"operation\":\"1\",\"mdbm\":\"MD20180115267\",\"mdmc\":\"不是店\",\"sf\":\"北京\",\"mddz\":\"朝阳路\",\"zdyj\":\"呵呵\",\"qd\":\"1\"}";
                  Service s = new  Service();
                  Call call = (Call) s.createCall();
                  call.setTargetEndpointAddress(new java.net.URL(urlname));
               
                  call.setOperationName(new QName(namespace,function));//WSDL里面描述的接口名称
                  if(parameterName==null||"".equals(parameterName)){
                	  parameterName="arg0";
                  }
                  call.addParameter(parameterName, XMLType.XSD_STRING,
                          ParameterMode.IN);
/*                  call.addParameter("dealerJson", XMLType.XSD_STRING,
                          ParameterMode.IN);*/
//                  call.addParameter("arg0", XMLType.XSD_STRING,
//                          ParameterMode.IN);//接口的参数
                  call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型
                  result = (String)call.invoke(new Object[]{str});
                 
        } catch (Exception e) {
              System.out.println(e.getMessage());
        }
		 return result;
 
  
		
	}
	//给ESB返回客户数据
	public static String sendCustomerTo(String urlname,String namespace,String function,String str,String parameterName,String id) {
		String result = null;
		try {     
//			 	  String op = "{\"status\":\"0\",\"oldcode\":\"700001\",\"isdelete\":\"0\",\"zt\":\"9\",\"tpsc\":\"1234567\",\"qx\":\"1234567\",\"ywy\":\"111\",\"fzrdh\":\"565656\",\"fzr\":\"112\",\"qx\":\"1234567\",\"sq\":\"145600\",\"mdgpsjwd\":\"1212121\",\"mdgps\":\"1278091\",\"terminalcode\":\"800001\",\"operation\":\"1\",\"mdbm\":\"MD20180115267\",\"mdmc\":\"不是店\",\"sf\":\"北京\",\"mddz\":\"朝阳路\",\"zdyj\":\"呵呵\",\"qd\":\"1\"}";
                  Service s = new  Service();
                  Call call = (Call) s.createCall();
                  call.setTargetEndpointAddress(new java.net.URL(urlname));
               
                  call.setOperationName(new QName(namespace,function));//WSDL里面描述的接口名称
                  call.addParameter("in5", XMLType.XSD_STRING,
                          ParameterMode.IN);
                  call.addParameter("in0", XMLType.XSD_STRING,
                          ParameterMode.IN);
                  call.addParameter("in1", XMLType.XSD_STRING,
                          ParameterMode.IN);
                  call.addParameter("in2", XMLType.XSD_STRING,
                          ParameterMode.IN);
                  call.addParameter("in3", XMLType.XSD_STRING,
                          ParameterMode.IN);
                  call.addParameter("in4", XMLType.XSD_STRING,
                          ParameterMode.IN);
                  call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型
                  Object[] obj = {"MDM","WLY88888","re_crm_customer","INSERT",id,str};
                  result = (String)call.invoke(obj);
                 
        } catch (Exception e) {
              System.out.println(e.getMessage());
        }
		 return result;
 	
	}
	
	 public static void main(String args[]) throws Exception {
	        try {
	        	
//	        	   String urlname = "http://localhost:8081/mdm/webservice/dataShore?wsdl";
	        	   String urlname = "http://127.0.0.1:8080/wlyclub/webService/MDDK?wsdl";
//	        	   String urlname = "http://www.joffro.com/PlsLargeDataService/services/MDTBD?wsdl";
	        	   String op = "{\"status\":\"0\",\"oldcode\":\"700001\",\"isdelete\":\"0\",\"zt\":\"9\",\"tpsc\":\"1234567\",\"qx\":\"1234567\",\"ywy\":\"111\",\"fzrdh\":\"565656\",\"fzr\":\"112\",\"qx\":\"1234567\",\"sq\":\"145600\",\"mdgpsjwd\":\"1212121\",\"mdgps\":\"1278091\",\"terminalcode\":\"800001\",\"operation\":\"1\",\"mdbm\":\"MD20180115267\",\"mdmc\":\"不是店\",\"sf\":\"北京\",\"mddz\":\"朝阳路\",\"zdyj\":\"呵呵\",\"qd\":\"1\"}";
	                  Service s = new  Service();
	                  Call call = (Call) s.createCall();
	                  call.setTargetEndpointAddress(new java.net.URL(urlname));
	                  /**
	                  *注意这里，要设置Namespace
	                  */
	                  String result = null;
	               
                  call.setOperationName(new QName("http://distributor.service.server.wlyclub.com/","masterData"));//WSDL里面描述的接口名称
              //		                  call.setOperationName(new QName("http://controller.common.service.com/","masterDate"));
	                  call.addParameter("dealerJson", XMLType.XSD_STRING,
	                          ParameterMode.IN);//接口的参数
	                  call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型
//	                  call.setReturnClass(TerminalResult.class);
	                  result = (String) call.invoke(new Object[]{op});
	                  //给方法传递参数，并且调用方法
	                  System.out.println("result is :"+result);	           
	        } catch (Exception e) {
	              System.out.println(e.getMessage());
	        }
	 
	  }

}
