package ChoiLearnNetwork7;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        //创建Socket对象，并同时请求与服务器的连接
        Socket socket = new Socket("127.0.0.1",8888);

        //创建一个独立的线程，负责随机从Socket中接收服务端发送过来的消息
        new ClientReaderThread(socket).start();

        //从Socket通信管道中得到一个字节输出流，用来发数据给服务端程序
        OutputStream os = socket.getOutputStream();

        //把低级的字节输出流包装成数据输出流
        DataOutputStream dos = new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请说：");
            String msg = sc.nextLine();

            //一旦用户输入了Exit就退出客户端程序
            if("Exit".equals(msg)){
                System.out.println("欢迎你下次光临，退出成功");
                dos.close();
                socket.close();
                break;
            }

            //开始写数据出去了
            dos.writeUTF(msg);
            dos.flush();
        }
    }
}
