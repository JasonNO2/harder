import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Callable {
    public static void main (String[] args) throws ExecutionException, InterruptedException {
        //ExecutionService用来执行,Future用来存取数据
        List<Future<Integer>> future = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            future.add(executorService.submit(new call()));
        }

        for (int i = 0; i < future.size(); i++) {
            Future<Integer> integerFuture =  future.get(i);
            System.out.println(integerFuture.get());
        }

        System.exit(0);
    }
}

class call implements java.util.concurrent.Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 20;
    }

}
