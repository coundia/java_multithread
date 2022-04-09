import com.coundia.core.logger.Log;
import com.coundia.core.services.Compte;
import com.coundia.core.services.TransactionService;



/**
 * @author Papa Coundia
 * @created 09/04/2022 / 13:30
 * @project java_junit
 */


    public class Main {

//    private static final Logger log = LogManager.getLogger(Main.class);

        public static void main(String args[]) throws InterruptedException {
            //creer un compte
            Compte compte = new Compte("c1",200d);
           Log.info("***** Debut traitement ***** "+Thread.currentThread().getName());
            Log.info("***** Etat Compte   . ***** \n "+compte);
           //creer deux transactions

            TransactionService trx1 = new TransactionService("t1","user1",compte,100d);
            TransactionService trx2 = new TransactionService("t2","user2",compte,100d);
            //creer deux thread
            Thread thread1  = new Thread(trx1,"Thread-trx1");
            Thread thread2  = new Thread(trx2,"Thread-trx2");
            //demarrer les threads //parallele
            thread1.start();
            thread2.start();
            //terminer thread1 puis thread2
            thread1.join(); //attendre  la fin
            thread2.join();  //attendre  la fin
            //fin transaction


            Log.info("***** Fin traitement  . ***** "+Thread.currentThread().getName());
            Log.info("***** Etat Compte   . ***** \n "+compte);

        }
    }
