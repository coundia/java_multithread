package com.coundia.core.calculator;

import com.coundia.core.logger.Log;

import java.util.concurrent.RecursiveTask;

/**
 * @author Papa Coundia
 * @created 10/04/2022 / 01:12
 * @project java_multithread
 */
public class CalculRTask extends RecursiveTask<Integer>    {
    int [] donnees;
    int debut;
    int fin;

    public CalculRTask(int[] donnees, int debut, int fin) {
        this.donnees = donnees;
        this.debut = debut;
        this.fin = fin;
    }

    /***
     *
     * @return
     * @throws InterruptedException
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

    @Override
    protected Integer compute() {
        Log.info("Call "+Thread.currentThread().getName()+" ...");
        int somme =0;

            try {
                Log.info("Calcul ... " + String.valueOf(somme));
                Thread.sleep(1000);
                int milieu = (debut - fin)/ 2;
               if(milieu > 5){
                   CalculRTask p1 = new CalculRTask(donnees,debut,debut+milieu-1);
                   p1.fork();
                   CalculRTask p2 = new CalculRTask(donnees,debut+milieu+1,fin);
                   somme = p2.compute()+p1.join();
               }else{
                   for (int i =debut;i<=fin;i++) {
                       somme += donnees[i];

                   }
               }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        return somme;
    }
}
