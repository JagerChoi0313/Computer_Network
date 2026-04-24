package ChoiLearnNetwork2;

//UDP通信快速入门：服务端的开发   //一般先启动服务端

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws Exception{

        System.out.println("----服务端启动----");
        //1，创建一个服务端对象（接韭菜的人）  注册端口
        DatagramSocket socket = new DatagramSocket(6666);

        //2，创建一个数据包对象，用来接收数据（创建一个韭菜盘子，用于接收韭菜）
        byte[] buffer = new byte[1024*64]; //64kb
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

        //3，开始正式使用数据包来接收客户端发来的数据
        socket.receive(packet);

        //4，从字节数组中，把接收到的数据打印出来
        //接收多少就倒出多少
        //获取本次数据包接收了多少数据

        int len = packet.getLength();
        String result = new String(buffer,0,len);


        System.out.println(result);

        //拿到客户端的IP地址
        System.out.println(packet.getAddress().getHostAddress());
        //拿到客户端的端口，系统会为客户端随机分配一个端口
        System.out.println(packet.getPort());

        socket.close();   //释放资源
    }
}
