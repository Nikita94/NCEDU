package Serversocket;

import JSONParser.fromJSON;
import workWithBD.Dao.ParentJarAndHisDependencies;
import workWithBD.util.Factory;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.List;

/**
 * Created by nik on 02.03.2016.
 */
public class ClientSession implements Runnable{
    private Socket socket = null;
    private InputStream in = null;
    private OutputStream out = null;
    private fromJSON fromjson = null;
    private List<String> listNames = null;


    ClientSession (Socket socket) throws IOException {
        this.socket = socket;
        initialize();
        Factory factory = Factory.getInstance();
        ParentJarAndHisDependencies navD = factory.getJarNameAndVersionDao();
    }

    private void initialize() throws IOException {
        /* Получаем поток ввода, в который помещаются сообщения от клиента */
        in = socket.getInputStream();
        /* Получаем поток вывода, для отправки сообщений клиенту */
        out = socket.getOutputStream();
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        /*try { 
            /* Получаем заголовок сообщения от клиента */ 
          /*  String header = readHeader(); 
            System.out.println(header + "\n"); 
            /* Получаем из заголовка указатель на интересующий ресурс */ 
        /*    String url = getURIFromHeader(header); 
            System.out.println("Resource: " + url + "\n"); 
            /* Отправляем содержимое ресурса клиенту */ 
         /*   int code = send(url); 
            System.out.println("Result code: " + code + "\n"); 
        } catch (IOException e) {
            e.printStackTrace();
        } finally
        { 
            try 
            { 
                socket.close(); 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } */

        try {
            String names = readJarNames();
            fromjson = new fromJSON(names);
            listNames = fromjson.getListNames(); // дописать парсер
            // добавление списка jars на иследование (дописать иследование)


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readJarNames() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder builder = new StringBuilder();
        String ln = null;
        while (true) {
            ln = reader.readLine();
            if (ln == null || ln.isEmpty()) {
                break;
            }
            builder.append(ln);
        }
        return builder.toString();
    }


    private void send(String url) throws IOException {
        
    }

    private String getHeader(int code) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("HTTP/1.1 " + code + " " + getAnswer(code) + "\n");
        buffer.append("Date: " + new Date().toGMTString() + "\n");
        buffer.append("Accept-Ranges: none\n");
        buffer.append("\n"); return buffer.toString();
    }

    private String getAnswer(int code) {
        switch (code) {
            case 200: return "OK";
            case 404: return "Not Found";
            default: return "Internal Server Error";
        }
    }

    private String getURIFromHeader(String header) {
        int from = header.indexOf(" ") + 1;
        int to = header.indexOf(" ", from);
        String uri = header.substring(from, to);
        int paramIndex = uri.indexOf("?");
        if (paramIndex != -1) {
            uri = uri.substring(0, paramIndex);
        }
        return uri;
    }
}
