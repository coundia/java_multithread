package com.coundia.core.services;

import com.coundia.core.logger.Log;

/**
 * @author Papa Coundia
 * @created 09/04/2022 / 21:52
 * @project java_multithread
 */
public class TransactionService implements Runnable {
    private String reference;
    private String user;
    private Compte compte ;
    private Double montant ;
    private int type ;
    @Override
    public void run() {

        Log.info("**** run () : "+getReference()+"@"+Thread.currentThread().getName());
        try {
            faire();
            debiter();
            notifier(getUser());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public boolean faire() throws InterruptedException {


        Log.info("**** faire () : "+getReference()+"@"+Thread.currentThread().getName()+" ...");
        Thread.sleep(1000);

        return false;
    }


    public boolean debiter() throws InterruptedException {
        Log.info("**** debiter () :"+getReference()+"@"+Thread.currentThread().getName()+" ... ");
        Thread.sleep(1000);
        //debiter le compte
        this.compte.setSolde(this.compte.getSolde()-this.getMontant());
        return false;
    }


    public boolean notifier(String user) throws InterruptedException {

        Log.info("**** notifier () : "+getReference()+"@"+Thread.currentThread().getName()+" ... ");
        Thread.sleep(1000);
        return false;
    }

    public TransactionService(String reference,String user) {

        Log.info("**** constructeur () : "+reference+"@"+Thread.currentThread().getName());
        this.reference = reference;
        this.user = user;
        this.montant = 0d;

    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public TransactionService(String reference, String user, Compte compte) {
        this.reference = reference;
        this.user = user;
        this.compte = compte;
        this.montant = 0d;
    }

    public TransactionService(String reference, String user, Compte compte, Double montant) {
        if(montant < 0){
            Log.info("Erreur montant negatif ! ");
            return;
        }
        this.reference = reference;
        this.user = user;
        this.compte = compte;
        this.montant = montant;

    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public TransactionService(String reference, String user, Compte compte, Double montant, int type) {
        this.reference = reference;
        this.user = user;
        this.compte = compte;
        this.montant = montant;
        this.type = type;
    }
}
