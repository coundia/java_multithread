package com.coundia.core.services;

import com.coundia.core.logger.Log;

/**
 * @author Papa Coundia
 * @created 09/04/2022 / 21:52
 * @project java_multithread
 */
public class TransactionService implements Runnable, ITransaction {
    private String reference;
    private String user;
    @Override
    public void run() {

        Log.info("**** run () : "+getReference()+"@"+Thread.currentThread().getName());
        faire();
        debiter(getReference());
        notifier(getUser());
    }

    @Override
    public boolean faire() {

        Log.info("**** faire () : "+getReference()+"@"+Thread.currentThread().getName());
        return false;
    }

    @Override
    public boolean debiter(String compte) {

        Log.info("**** debiter () :"+getReference()+"@"+Thread.currentThread().getName());
        return false;
    }

    @Override
    public boolean notifier(String user) {

        Log.info("**** notifier () : "+getReference()+"@"+Thread.currentThread().getName());
        return false;
    }

    public TransactionService(String reference,String user) {

        Log.info("**** constructeur () : "+reference+"@"+Thread.currentThread().getName());
        this.reference = reference;
        this.user = user;
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


}
