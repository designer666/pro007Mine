package concurrency.lesson03;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableEx03 {

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<String> result = es.submit(() -> {
            System.out.println("Запуск задачи...");
            TimeUnit.SECONDS.sleep(3);
            return "Результат выполнения задачи";
        });

        try {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Ожидание выполнения...");
            while (!result.isDone()) {
                System.out.println("Ждем одну секунду");
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println("Получаем результат");
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        es.shutdown();
    }
}
