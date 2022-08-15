import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 2125;

        try (Socket client = new Socket(host, port);
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

            String resp = in.readLine();
            System.out.println(resp);
            out.println("Dmitrii Sobin");
            System.out.println(in.readLine());
            out.println("Да");
            System.out.println(in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
