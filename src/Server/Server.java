package Server;

import java.io.IOException;
import java.net.Socket;

import net.sf.lipermi.handler.CallHandler;

public class Server implements ServerInterface {

    public String ping() {
        try {
            CallHandler callHandler = new CallHandler();
            callHandler.registerGlobal(TestService.class, this);
            Server server = new Server();
            server.bind(7777, callHandler);
            server.addServerListener(new IServerListener() {
                
                @Override
                public void clientDisconnected(Socket socket) {
                    System.out.println("Client Disconnected: " + socket.getInetAddress());
                }
                
                @Override
                public void clientConnected(Socket socket) {
                    System.out.println("Client Connected: " + socket.getInetAddress());
                }
            });
            System.out.println("Server Listening");
        } catch (LipeRMIException | IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String getResponse(String data) {
        System.out.println("A client is pinging!");
        return "ping";
    }

}
