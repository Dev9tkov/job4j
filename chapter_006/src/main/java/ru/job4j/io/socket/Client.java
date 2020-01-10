package ru.job4j.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Клиентская сторона бота
 * @author Ilya Devyatkov
 * @since 09.01.2020
 */
public class Client {
    private static int port;
    private static String ip;
    private Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    /**
     * Реализация клиентской части бота.
     * Пользователь вводит данные в консоли и получает ответ с сервера.
     * Сервер может отправлять большие сообщения. Чтобы понять, когда конец сообщения, он отправляет пустую строку.
     * Оракл отвечает на приветствие Hello Oracle.
     * Если Ораклу сказали exit, то приложение выключается.
     * На любую другую слово-фразу, сервер отвечает I don't understand you.
     */
    public void startClient() {
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
             Scanner console = new Scanner(System.in)
        ) {
            String ask;
            String answer;
            do {
                ask = console.nextLine();
                out.println(ask);
                if (!"exit".equals(ask)) {
                    answer = in.readLine();
                    while (!answer.isEmpty()) {
                        System.out.println(answer);
                        answer = in.readLine();
                    }
                }
            } while (!"exit".equals(ask));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket(InetAddress.getByName(ip), port)){
            new Client(socket).startClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
