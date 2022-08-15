import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Hello! Server started!");
        int port = 2125;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.println("New connection accept! Port: " + clientSocket.getPort());
                out.println("Напиши, как тебя зовут?");
                final String name = in.readLine();
                out.println("Ты ребёнок? (Да/Нет)");
                final String ageUser = in.readLine();
                if (ageUser.equals("Да")) {
                    out.println(String.format("Добро пожаловать в детскую зону развлечений, %s!" +
                            " Давай играть!", name));
                } else if (ageUser.equals("Нет")) {
                    out.println(String.format(" Добро пожаловать во взрослую зону развлечений, %s!" +
                            " Хорошего отдыха или хорошего рабочего дня!", name));
                } else out.println(String.format("Такого варианта нет, %s!" +
                        " Введите ваш возраст в формате \"Да\" или \"Нет\".", name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
