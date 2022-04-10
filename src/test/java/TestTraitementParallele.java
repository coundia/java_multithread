import com.coundia.core.calculator.Calcul;
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
}
