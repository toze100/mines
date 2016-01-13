/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipleiria.estg.es1.as2130557.minesfinder;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author tony
 */
public class TabelaRecordes implements Serializable {

    private String nomeJogador;
    private long tempoJogo;

    private transient ArrayList<TabelaRecordesListener> listeners;

    /* ************* CONSTRUTOR DA CLASSE ************** */
    public TabelaRecordes() {
        nomeJogador = "Anónimo";
        tempoJogo = 9999999;
        listeners = new ArrayList<>();

    }

    private void notifyRecordesActualizados() {
        if (listeners != null) {
            for (TabelaRecordesListener list : listeners) {
                list.recordesActualizados(this);
            }
        }
    }
    /* ************** GETTERS e SETTERS DA  CLASSE *************** */

    public String getNomeJogador() {
        return nomeJogador;
    }

    public Long getTempoJogo() {
        return tempoJogo;
    }

    public void setRecorde(String nomeJogador, long tempoJogo) {
        if (this.tempoJogo > tempoJogo) {
            this.nomeJogador = nomeJogador;
            this.tempoJogo = tempoJogo;
            notifyRecordesActualizados();
        }
    }

    public void addTabelaRecordesListener(TabelaRecordesListener list) {
        if (listeners == null) {
            listeners = new ArrayList<>();
        }
        listeners.add(list);
    }

    public void removeTabelaRecordesListener(TabelaRecordesListener list) {
        if (listeners != null) {
            listeners.remove(list);
        }
    }

}
