package com.coundia.core.singleton;

import com.coundia.core.logger.Log;

/**
 * @author Papa Coundia
 * @created 09/04/2022 / 23:23
 * @project java_multithread
 */
public class Connexion {
    private static Connexion connexion;
    public static   Connexion   getInstance (){
        //si l'instance est null on le cree
        if(connexion == null)
            synchronized(Connexion.class){
                //si l'instance est null  et il y a un autre thread
                if(connexion == null)
                connexion = new Connexion();
            }

        return connexion;
    }


    public Connexion() {
        Log.info(" *** Creer une instance de connexion *** ");
    }
    public void open () throws InterruptedException {
        Log.info(" *** open connexion *** ...");
        Thread.sleep(1000);
    }
    public void close() throws InterruptedException {
        Log.info(" *** close connexion *** ...");
        Thread.sleep(1000);
    }
}
