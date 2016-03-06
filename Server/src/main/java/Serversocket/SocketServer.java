package Serversocket;

import JSONParser.DependenciesJars;
import JSONParser.fromJSON;
import JSONParser.toJSON;
import com.google.gson.Gson;
import workWithBD.Dao.ParentJarAndHisDependencies;
import workWithBD.util.Factory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Created by nik on 02.03.2016.
 */
public class SocketServer {
    private int port = 5555;
    private ServerSocket myServerSocket = null;

    public void createSocket () {
        try
        {
            myServerSocket = new ServerSocket(port);
        }
        catch(IOException ioe)
        {
            System.out.println("Could not create server socket on port 11111. Quitting.");
            System.exit(-1);
        }

        while(true)
        {
            try
            {
                Socket clientSocket = myServerSocket.accept();
                ClientServiceThread cliThread = new ClientServiceThread(clientSocket);
                cliThread.start();

            }
            catch(IOException ioe)
            {
                System.out.println("Exception encountered on accept. Ignoring. Stack Trace :");
                ioe.printStackTrace();
            }

        }
    }


    class ClientServiceThread extends Thread
    {
        Socket myClientSocket;
        private fromJSON fromjson = null;
        private List<String> listNames = null;
        private BufferedReader in = null;
        private PrintWriter out = null;
        private  ParentJarAndHisDependencies navD = null;
        private Factory factory = null;

        public ClientServiceThread()
        {
            super();
        }

        ClientServiceThread(Socket s)
        {
            myClientSocket = s;
            factory = Factory.getInstance();
            navD = factory.getJarNameAndVersionDao();
        }

        public void run()
        {
            try
            {
                in = new BufferedReader(new InputStreamReader(myClientSocket.getInputStream()));
                out = new PrintWriter(new OutputStreamWriter(myClientSocket.getOutputStream()));


                String names = in.readLine();
                System.out.println(names);
                fromjson = new fromJSON(names);
                listNames = fromjson.getListNames();
                DependenciesJars dependenciesJars = navD.checkDependencies(listNames);
                navD.clean();
                //System.out.println(list.toString());
                toJSON json = new toJSON(dependenciesJars);
                json.createJSON();
                //System.out.println(dependenciesJars.getSetDep().toString());
                send(json);

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    in.close();
                    out.close();
                    myClientSocket.close();
                }
                catch(IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
        }

        private void send(toJSON json) throws IOException {
            Gson gsone = new Gson();
            String str = gsone.toJson(json);
            out.print(str);
            out.flush();
        }


    }
}
