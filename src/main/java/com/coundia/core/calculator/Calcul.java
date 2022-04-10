package com.coundia.core.calculator;

import com.coundia.core.logger.Log;

import java.util.concurrent.Callable;

/**
 * @author Papa Coundia
 * @created 10/04/2022 / 01:12
 * @project java_multithread
 */
public class Calcul implements Callable<Integer> {
    int [] donnees;
    int debut;
    int fin;

    public Calcul(int[] donnees, int debut, int fin) {
        this.donnees = donnees;
        this.debut = debut;
        this.fin = fin;
    }
    public Calcul(int[] donnees) {
        this.donnees = donnees;
        this.debut = 0;
        this.fin = 0;
    }
    @Override
    public Integer call() throws Exception {
        Log.info("Call "+Thread.currentThread().getName()+" ...");
     //   Thread.sleep(1000);
        int somme =0;
            for (int i =debut;i<=fin;i++){
                Log.info("Calcul ... "+String.valueOf(somme));
                Thread.sleep(1000);
                somme += donnees[i];

        }
        return somme;
    }

    /***
     *
     * @return
     */
    public int getSomme() throws InterruptedException {
        int somme =0;
        for (int i =0;i<donnees.length;i++){
            Thread.sleep(1000);
            Log.info("Calcul ... "+String.valueOf(somme));
            somme += donnees[i];
        }
        return somme;
    }
}
