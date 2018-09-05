/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ListaEncadeada;

/**
 *
 * @author bruno
 */
public class ItemLista <T>  {
    private T info;
    private ItemLista proximo;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public ItemLista getProximo() {
        return proximo;
    }

    public void setProximo(ItemLista proximo) {
        this.proximo = proximo;
    }
    
    
}
