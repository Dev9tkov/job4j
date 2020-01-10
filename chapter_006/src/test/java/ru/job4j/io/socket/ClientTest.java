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
public class ClientTest {
    private static final String LN = System.lineSeparator();

    private void testClient(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(
                input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        Client client = new Client(socket);
        client.startClient();
        assertThat(out.toString(), is(expected));
        System.setIn(System.in);
    }

    @Test
    public void whenSayHelloThenGreets() throws IOException {
        this.testClient(
                String.format("Hello, dear friend, I'm a oracle%s%s", LN, LN),
                String.format("hello%sexit%s", LN, LN)
        );
    }

    @Test
    public void whenSayOtherThenOracleDontUnderstand() throws IOException {
        this.testClient(
                String.format("I don't understand%s%s", LN, LN),
                String.format("Whats up, Oracle%sexit%s", LN, LN)
        );
    }
}
