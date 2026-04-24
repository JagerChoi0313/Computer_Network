package ChoiLearnNetwork2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws Exception{
        //1,创建客户端对象（发韭菜出去的人）
        DatagramSocket socket = new DatagramSocket();

        //2,创建数据包对象封装要发出去的数据（创建一个韭菜盘子）
        /*public DatagramPacket(byte[] buf, int length,
        InetAddress address, int port) {
            this(buf, 0, length, address, port);

            参数一：封装要发出去的数据
            参数二：发送出去的数据大小（字节个数）
            参数三：服务端的IP地址（找到服务端主机）
            参数四：服务端程序的端口
        }*/
        byte[] bytes="我是这里的客户端，现在需要发送信息".getBytes();    //将要发出去的字符串转换为字符数组

        //如果要发到别人的电脑上去，则应该是InetAddress.getByName()
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length,InetAddress.getLocalHost(),6666);

        //3.开始正式发送这个数据包的数据
        socket.send(packet);

        System.out.println("客户端数据发送完毕");
        socket.close();     //发完之后得关掉，因为它会占用网卡资源
    }
}
