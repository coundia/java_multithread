package com.coundia.core.services;

import com.coundia.core.logger.Log;

/**
 * @author Papa Coundia
 * @created 09/04/2022 / 22:52
 * @project java_multithread
 */
public class Compte {
    private String numero ;
    private Double solde ;
    private int etat ;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        if(solde < 0){
            Log.info("Erreur montant negatif ! ");
            return;
        }

        this.solde = solde;

    }

    public Compte(String numero, Double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "numero='" + numero + '\'' +
                ", solde=" + solde +
                ", etat=" + etat +
                '}';
    }
}
