import Serversocket.SocketServer;

/**
 * Created by nik on 17.02.2016.
 */
public class Server {

    public static void main (String argv[]) throws Exception {
        int port = 5555;
        port = Integer.parseInt(argv[0]);
        SocketServer socketServer = new SocketServer(port);
        socketServer.runServer();
    }
}
