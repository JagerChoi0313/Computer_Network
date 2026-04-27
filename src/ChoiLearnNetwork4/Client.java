package ChoiLearnNetwork4;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        //创建Socket对象，并同时请求与服务器的连接
        Socket socket = new Socket("127.0.0.1",8888);

        //从Socket通信管道中得到一个字节输出流，用来发数据给服务端程序
        OutputStream os = socket.getOutputStream();

        //把低级的字节输出流包装成数据输出流
        DataOutputStream dos = new DataOutputStream(os);

        //开始写数据出去了
        dos.writeUTF("我是Choi");
        dos.close();

        socket.close();     //释放连接资源
    }
}
