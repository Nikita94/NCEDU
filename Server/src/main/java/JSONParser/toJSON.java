package JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Set;

/**
 * Created by nik on 26.02.2016.
 */
public class toJSON {

    DependenciesJars dependenciesJars = null;

    public toJSON(DependenciesJars dependenciesJars) {
        this.dependenciesJars = dependenciesJars;
    }

    public Gson createJSON() throws IOException{
        Writer writer = new FileWriter("Output.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(dependenciesJars, writer);
        writer.close();
        return gson;
    }
}
