package com.wjl.test0;

/**
 * 在运行客户端测试前，需要采用命令生成相关的接口类。<p/>
 * 格式：
 * wsimport -s "src目录" -p “生成类所在包名” -keep “wsdl发布地址”
 * 示例：
 * wsimport -s F:\ArchitectureDemo\Webservice_Client\src -p com.wjl.test0 -keep
 * http://127.0.0.1:9001/Service/ServiceTest?wsdl
 */
public class ClientTest {

    public static void main(String[] args) {
        ServiceTest st = new ServiceTestService().getServiceTestPort();
        String result = st.handler("武坚利");
        System.out.println(result);
    }
}
