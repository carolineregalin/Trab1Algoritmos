package com.FilaLista;

import com.Exception.FilaVaziaException;
import com.ListaEncadeada.ListaEncadeada;

/**
 *
 * @author daniel
 */

public class FilaLista<T> implements Fila<T> {

    private ListaEncadeada<T> lista;

    public FilaLista() {
        lista = new ListaEncadeada<>();
    }

    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException("Fila está vazia.");
        }

        return (T) lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {
        T valor = peek();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public void liberar() {
        try {
            while (true) {
                retirar();
            }
        } catch (FilaVaziaException f) {
            
        }
    }

    @Override
    public String toString() {
        return lista.toString();
        
    }
}
