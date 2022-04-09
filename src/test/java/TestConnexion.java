import com.coundia.core.singleton.Connexion;
import org.junit.jupiter.api.Test;

/**
 * @author Papa Coundia
 * @created 09/04/2022 / 23:37
 * @project java_multithread
 */
public class TestConnexion {
    @Test
    void testConnexion(){
        //t1
        new Thread(()-> {
            try {
                Connexion.getInstance().open();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //t2
        new Thread(()-> {
            try {
                Connexion.getInstance().close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
