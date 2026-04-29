package ChoiLearnNetwork6;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerReaderThread extends Thread{
    //定义一个有参构造器接收socket
    private Socket socket;
    public ServerReaderThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try{
            InputStream is = socket.getInputStream();//读信息
            DataInputStream dis= new DataInputStream(is);
            while(true){
                try {
                    String msg = dis.readUTF();
                    System.out.println(msg);
                } catch (IOException e) {
                    //拦截异常
                    System.out.println("有人下线了" + socket.getRemoteSocketAddress());
                    dis.close();
                    socket.close();
                    break;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
