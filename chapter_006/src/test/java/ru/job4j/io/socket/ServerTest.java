package ru.job4j.io.socket;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Ilya Devyatkov
 * @since 10.01.2020
 */
public class ServerTest {
    private static final String LN = System.lineSeparator();

    private void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(
                input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.startServer();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenAskAnswerThenChooseRandom() throws IOException {
        this.testServer("exit", "");
    }

    @Test
    public void whenAskHelloThenBackGreatOracle() throws IOException {
        this.testServer(
                String.format("hello%sexit", LN),
                String.format("Hello, dear friend, I'm a oracle%s%s", LN, LN)
        );
}

    @Test
    public void whenUnsupportedThenDontUnderstand() throws IOException {
        this.testServer(
                String.format("unsupported%sexit", LN),
                String.format("I don't understand%s%s", LN, LN)
        );
    }
}
