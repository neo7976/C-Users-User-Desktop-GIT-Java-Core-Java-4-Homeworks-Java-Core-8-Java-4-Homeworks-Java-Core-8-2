import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        System.out.println("Hello! Server started!");
        int port = 2125;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept(); // ожидание подтверждения
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.println("New connection accept! Port: " + clientSocket.getPort());
                out.println("Напиши, как тебя зовут?");
                final String name = in.readLine();
                out.println("Ты ребёнок? (Да/Нет");
                final String ageUser = in.readLine();

                if (ageUser.equals("Да"))
                    out.printf(String.format("Добро пожаловать в детскую зону развлечений, %s !\n" +
                            "Давай играть !", name));
                else
                    out.printf(String.format("Добро пожаловать во взрослую зону развлечений, %s !\n" +
                            "Хорошего отдыха или хорошего рабочего дня !", name));
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
