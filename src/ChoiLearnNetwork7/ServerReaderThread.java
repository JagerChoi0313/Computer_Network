package ChoiLearnNetwork7;

import java.io.*;
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
                    //把消息分发给客户端进行接收
                    sendMsgToAll(msg);
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

    private void sendMsgToAll(String msg) throws IOException{
        //发送全部在线的Socket的管道接收
        for (Socket onLineSocket : Server.onLineSockets) {
            OutputStream os= onLineSocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(msg);
            dos.flush();
        }
    }
}
