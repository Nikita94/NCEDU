import JSONParser.DependenciesJars;
import JSONParser.toJSON;
import Serversocket.HTTPServer;
import workWithBD.Dao.ParentJarAndHisDependencies;
import workWithBD.util.Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 17.02.2016.
 */
public class Server {
    public static void main (String argv[]) throws Exception {
       Factory factory = Factory.getInstance();
       ParentJarAndHisDependencies navD = factory.getJarNameAndVersionDao();
      // List<String> list = new ArrayList<String>(navD.getAllDependencies("TestNameA v1.0.0.2"));
      // navD.removeSetDependencies();
      // List<String> list2 = new ArrayList<String>(navD.getAllDependencies("DependeceWithDependecies v3.0.0.2"));
      // toJSON json = new toJSON(list);
      // json.createJSON();

     //HTTPServer httpserver = new HTTPServer();
     //httpserver.createSocket();
     //httpserver.runServer();
        List<String> list = new ArrayList<>();
        list.add("DependeceWithDependecies v3.0.0.2");
        list.add("Dependece1_1 v4.1");
        list.add("Dependece1_2 v2.2.1");
        list.add("Dependece2 v1.2.1");
        list.add("Dependece2_1 v3.1");
        list.add("Dependece1 v1.1");
        list.add("Dependencies2_1_1 v.12.3");
        DependenciesJars dependenciesJars = navD.checkDependencies(list);
        toJSON tojson = new toJSON(dependenciesJars);
        tojson.createJSON();
    }
}
