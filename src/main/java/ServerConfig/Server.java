package ServerConfig;

import java.io.IOException;
import java.net.Socket;

import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.IServerListener;

public class Server implements ServerInterface {

	public Server() {
        try {
            CallHandler callHandler = new CallHandler();
            callHandler.registerGlobal(ServerInterface.class, this);
            net.sf.lipermi.net.Server server = new net.sf.lipermi.net.Server();
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
	public String ping() {
		System.out.println("A client is pinging!");
        return "ping";
	}

}
