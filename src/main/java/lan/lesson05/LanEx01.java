package lan.lesson05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class LanEx01 {

    /*Сетевое взаимодействие
    *
    * Protocol - описывает набор правил для интерактивного обмена информацией между компьютерами в рамках сети
    *
    * TCP/IP
    * TCP - Transmission Control Protocol - гарантировать передачу данный между компьютерами
    * IP  - Internet Protocol - решение коммуникационных вопросов, возникающих в процессе передачи данных
    *
    * IPv4:
    * xxx.xxx.xxx.xxx
    * 127.0.0.1 (localhost) - необходим для тестов в пределах одного компьютера*/

    public static void main(String[] args) {
        try (SocketChannel channel = SocketChannel.open(new InetSocketAddress("192.168.1.148"/*"127.0.0.1"*/, 20000))) {
            /*SocketChannel - класс необходим для подключения удаленному ресурсу*/
            String text = "Китайская продукция ГОВНО!";
            ByteBuffer buffer = ByteBuffer.allocate(128);
            buffer.put(text.getBytes());
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
