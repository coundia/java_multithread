import com.coundia.core.calculator.Calcul;
import com.coundia.core.calculator.CalculRTask;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author Papa Coundia
 * @created 10/04/2022 / 01:06
 * @project java_multithread
 */
public class TestTraitementParallele {
    @Test
    void testSommeSimple() throws InterruptedException {
        long debut =  System.currentTimeMillis();
        System.out.println("***** Debut  testSommeSimple ***");
        //executor de taille fix
        int[] donnes = IntStream.range(0,11).toArray();
        //creer une task
        Calcul calcul = new Calcul(donnes);
        int somme = calcul.getSomme();
        long fin =  System.currentTimeMillis();
        System.out.println("Somme  : "+somme);
        System.out.println("***** Fin. : "+ String.valueOf(fin-debut)+" millis ");

    }
    @Test
    void testSommeWithFuture() throws ExecutionException, InterruptedException {
        long debut =  System.currentTimeMillis();
        System.out.println("***** Debut testSommeWithFuture *** ");
        //executor de taille fix
        ExecutorService exe = Executors.newFixedThreadPool(2);
        int[] donnes = IntStream.range(0,11).toArray();
        //creer une task
        Calcul task1 = new Calcul(donnes,0,3);
        Calcul task2 = new Calcul(donnes,4,10);
        //creer un futur
        Future<Integer> f1= exe.submit(task1);
        Future<Integer> f2= exe.submit(task2);
        //recuperer les valeur

        int somme = f1.get() + f2.get();

        long fin =  System.currentTimeMillis();
        System.out.println("Somme  : "+somme);
        System.out.println("***** Fin. : "+ String.valueOf(fin-debut)+" millis ");

    }

    @Test
    void testForJoinPool() throws ExecutionException, InterruptedException {
        long debut =  System.currentTimeMillis();
        System.out.println("***** Debut testForJoinPool  *** ");
        //bloc debut ***
        int [] tab = IntStream.range(0,11).toArray();
        ForkJoinPool fjp = new ForkJoinPool();
        CalculRTask calculTask=new CalculRTask(tab,0,10);
        int som=fjp.invoke(calculTask);
        //bloc fin ***
        long fin =  System.currentTimeMillis();
        System.out.println("***** somme :  "+String.valueOf(som));
        System.out.println("***** Fin. : "+ String.valueOf(fin-debut)+" millis ");
    }


    @Test
    void   TestCollectionConcurrent(){
        BlockingQueue bq =new ArrayBlockingQueue(3);
        //producteur
        new Thread(
                ()->{
                    for(int i=0 ; i<10;i++){
                        try {
                            System.out.println("***** Produire  *** ");
                            bq.put(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("***** Fini de production  *** ");
                }
        ).start();
        //consommateur
        new Thread(
                ()->{
                    for(int i=0 ; i<5;i++){
                        try {
                            System.out.println("***** Consommateur  *** ");
                            System.out.println(bq.take());

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("***** Fini de consommation  *** ");
                }
        ).start();
        //consommateur
        new Thread(
                ()->{
                    for(int i=0 ; i<5;i++){
                        try {
                            System.out.println("***** Consommateur  *** ");
                            System.out.println(bq.take());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("***** Fini de consommation  *** ");
                }
        ).start();
        //prevoir les blocages au besoin

    }
}
