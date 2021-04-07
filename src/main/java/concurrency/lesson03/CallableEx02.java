package concurrency.lesson03;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*Callable - появился вначиная с JDK 1.5 в составе Concurrency API, который помагает вернуть рез-т выполненной работы из потока*/
public class CallableEx02 {

    public static void main(String[] args) {
        Callable<String> task = () -> {
            System.out.println("Что-то выполняем...");
            TimeUnit.SECONDS.sleep(2);
            return "Результат выполнения задачи...";
        };

        /*newFixedThreadPool - создает процесс с двумя активными потоками*/
        ExecutorService es = Executors.newFixedThreadPool(2);
        /*submit - позволяет запустить Callable задачу в отдельном потоке
        * Future - класс, который позволяет контроллировать работу потока и получить рез-т выполнения после завершения задачи*/
        Future<String> taskResult = es.submit(task);

        try {
            System.out.println("Ожидание результата работы...");
            System.out.println("Задача завершена? - " + taskResult.isDone());
            if (!taskResult.isDone()) {
                String result = taskResult.get(3, TimeUnit.SECONDS);
                System.out.println("Результат --> " + result);
            }
            System.out.println("Задача завершена? - " + taskResult.isDone());
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } /*catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }*/
        es.shutdown();
    }
}
