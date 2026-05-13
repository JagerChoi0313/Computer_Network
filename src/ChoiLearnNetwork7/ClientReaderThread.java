package ChoiLearnNetwork7;
//客户端读线程

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientReaderThread extends Thread{
    private Socket socket;
    public ClientReaderThread(Socket socket){
        this.socket = socket;
    }

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
                    Server.onLineSockets.remove(socket);
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
