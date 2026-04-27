package ChoiLearnNetwork3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

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

        Scanner sc = new Scanner(System.in);

        //客户端不断发消息
        while (true) {

            //让用户输入数据
            System.out.println("请说：");
            String msg = sc.nextLine();     //用来接收用户的消息

            //一旦发现用户输入的是Exit命令，就退出客户端
            if("Exit".equals(msg)){
                System.out.println("欢迎再次观临，退出成功");
                socket.close();     //释放网卡资源
                break;
            }

            byte[] bytes = msg.getBytes();  //将用户发送的消息转换成字节数组的形式

            //把字节数组封装成数据包
            DatagramPacket packet = new DatagramPacket(bytes,bytes.length,InetAddress.getLocalHost(),6666);

            //3.开始正式发送这个数据包的数据
            socket.send(packet);
        }


    }
}
