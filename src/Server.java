import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public Server() {
        startServer();
    }

    private void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(61616);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> {
                    String inputLine;
                    String outputLine;
                    try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                         BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                         Scanner sc = new Scanner(new FileReader("src/text.txt"))
                    ) {
                        while ((inputLine = in.readLine()) != null) {

                            System.out.println("Request: " + inputLine);

                            if (inputLine.equals("exit")) {
                                break;
                            } else if (inputLine.equals("get all")) {
                                while (sc.hasNextLine()) {
                                    outputLine = sc.nextLine().replaceAll(",", " ");

                                    out.println(outputLine);
                                }
                                out.println("end message");

                            }
                        }
                        in.close();
                        out.close();
                        clientSocket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                ).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
