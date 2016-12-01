public class ServerMain {
    public static void main(String[] args) {
        System.out.println("Server start");
        new Server();
        System.out.println("Server end");
    }

//    static void serverExample() {
//        try (ServerSocket serverSocket = new ServerSocket(1616)) {
//            while (true) {
//                Socket clientSocket = serverSocket.accept();
//                new Thread(
//                        new Runnable() {
//                            public void run() {
//                                try {
//                                    InputStream inputStream = clientSocket.getInputStream();
//                                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                                    BufferedReader reader = new BufferedReader(inputStreamReader);
//
//                                    OutputStream outputStream = clientSocket.getOutputStream();
//                                    PrintWriter writer = new PrintWriter(outputStream);
//
//                                    for (String line = reader.readLine(); line != null; line = reader.readLine()) {
//                                        System.out.println(line);
//                                        writer.println("Message received: " + line);
//                                        if (line.equals("exit")) {
//                                            System.out.println("line equals exit");
//                                            writer.flush();
//                                            break;
//                                        }
//                                    }
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }
//                ).start();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
