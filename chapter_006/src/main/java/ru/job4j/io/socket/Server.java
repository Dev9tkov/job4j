package ru.job4j.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Серверная сторона бота
 * Сервер должен отвечать на простые вопросы. Если Оралку сказали пока. То приложение выключается.
 * @author Ilya Devyatkov
 * @since 09.01.2020
 */
public class Server {
    private static int port = 5050;
    private Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void startServer() {
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()))
        ) {
            String ask;
            do {
                System.out.println("Wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                if ("hello".equals(ask)) {
                    out.println("Hello, dear friend, I'm a oracle");
                    out.println();
                } else if (!("exit".equals(ask))) {
                    out.println("I don't understand");
                    out.println();
                }
            } while (!("exit".equals(ask)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new ServerSocket(port).accept()){
            new Server(socket).startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
