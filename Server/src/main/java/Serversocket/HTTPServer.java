package Serversocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by nik on 02.03.2016.
 */
public class HTTPServer {
    private int port = 5555;
    private ServerSocket serverSocket = null;

    public void createSocket () {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + serverSocket.getLocalPort() + "\n");
        } catch (IOException e) {
            System.out.println("Port " + port + " is blocked.");
            System.exit(-1);
        }
    }

    public void runServer () {
    /* * Если порт был свободен и сокет был успешно создан, можно переходить к * следующему шагу - ожиданию клинтов */
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
            /* Для обработки запроса от каждого клиента создается * отдельный объект и отдельный поток */
                ClientSession session = new ClientSession(clientSocket);
                new Thread(session).start();
            } catch (IOException e) {
                System.out.println("Failed to establish connection.");
                System.out.println(e.getMessage());
                System.exit(-1);
            }
        }
    }
}
