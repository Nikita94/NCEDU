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
import java.util.ArrayList;
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
        BufferedReader in = null;
        PrintWriter out = null;

        public ClientServiceThread()
        {
            super();
        }

        ClientServiceThread(Socket s)
        {
            myClientSocket = s;
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

                List<String> list = new ArrayList<>();
                list.add("DependeceWithDependecies v3.0.0.2");
                list.add("Dependece1_1 v4.1");
                list.add("Dependece1_2 v2.2.1");
                list.add("Dependece2 v1.2.1");
                list.add("Dependece2_1 v3.1");
                list.add("Dependece1 v1.1");
                list.add("Dependencies2_1_1 v.12.3");

                Factory factory = Factory.getInstance();

                ParentJarAndHisDependencies navD = factory.getJarNameAndVersionDao();
                DependenciesJars dependenciesJars = navD.checkDependencies(list);
                navD.removeSetDependencies();
                //System.out.println(list.toString());
                toJSON json = new toJSON(dependenciesJars);
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
