import JSONParser.DependenciesJars;
import JSONParser.toJSON;
import Serversocket.SocketServer;
import workWithBD.Dao.ParentJarAndHisDependencies;
import workWithBD.util.Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 17.02.2016.
 */
public class Server {
    public static void main (String argv[]) throws Exception {
        SocketServer socketServer = new SocketServer();
        socketServer.runServer();
    }
}
