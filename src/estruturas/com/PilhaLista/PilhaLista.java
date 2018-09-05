/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PilhaLista;
import com.ListaEncadeada.ListaEncadeada;
import com.Exception.PilhaVaziaException;


/**
 *
 * @author daniel
 */
public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada lista = new ListaEncadeada<T>();

    @Override
    public void push(T v) {
        //lança erro de quantidade quando vetor esta cheio
        lista.inserir(v);
    }

    @Override
    public T pop() {
        if (lista.obterComprimento() == 0) {
            try {
                throw new PilhaVaziaException("A lista está vazia!");
            } catch (PilhaVaziaException ex) {
                throw new RuntimeException();
            }
        }
        T aux = (T) lista.getPrimeiro().getInfo();
        lista.retirar(lista.getPrimeiro().getInfo());
        return aux;
    }

    @Override
    public T peek() {
        if (lista.obterComprimento() == 0) {
            try {
                throw new PilhaVaziaException("A lista está vazia!");
            } catch (PilhaVaziaException ex) {
                throw new RuntimeException();
            }
        }
        T aux = (T) lista.getPrimeiro().getInfo();
        return aux;
    }

    @Override
    public boolean vazia() {
        if (lista.obterComprimento() > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void libera() {
        ListaEncadeada lista2 = new ListaEncadeada<T>();
        this.lista = lista2;
    }
    
    @Override
    public String toString() {
        return lista.toString();
    }
    
}
