import com.coundia.core.logger.Log;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Papa Coundia
 * @created 10/04/2022 / 00:50
 * @project java_multithread
 */
public class TestExecutors {
    @Test
    void testerExecutor() {
        //creer un  thread
        ExecutorService exe = Executors.newSingleThreadExecutor();

        //lancer le thread1
        exe.execute(() -> {
            Log.info("*****   traitement  . ***** "+Thread.currentThread().getName());
            System.out.println("Hello ...");
        });

    }
}
