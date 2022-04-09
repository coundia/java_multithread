package com.coundia.core.services;

/**
 * @author Papa Coundia
 * @created 09/04/2022 / 21:56
 * @project java_multithread
 */
public interface ITransaction {
    boolean faire();
    boolean debiter(String compte);
    boolean notifier(String user);
}
