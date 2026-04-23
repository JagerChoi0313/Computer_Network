package ChoiLearnNetwork1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws Exception{
        //获取本机IP地址
        InetAddress ip1= InetAddress.getLocalHost();
        System.out.println(ip1.getHostName());
        System.out.println(ip1.getHostAddress());

        //获取指定IP或者域名IP的地址对象
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println(ip2.getHostName());
        System.out.println(ip2.getHostAddress());
        System.out.println(ip2.isReachable(6000));
    }
}
