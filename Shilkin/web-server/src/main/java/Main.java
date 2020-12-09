import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        String rootFolder = Utils.getRootFolder();
        while (true) {
            new ThreadServerSocket(serverSocket.accept(), rootFolder);
        }
    }
}
