/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PilhaLista;

/**
 *
 * @author bruno
 */
public class PilhaVetor<T> implements Pilha<T> {
     private T[] vet;
     private int tam;
     private int n; 
   
    
    /*
    Cria uma pilha com o tamanho especificado 
    tam Capacidade máxima de empilhamento
    */
    
    public PilhaVetor(int tam){
        vet = (T[]) new Object[tam];
        this.tam = tam;
        this.n = 0;
    }
    
    /*
    Empilha um dado
    v Dado a ser empilhado
    */
    
    public void push(T v){
        /*if (n == tam) {
            throw new PilhaCheiaException();
        } else {*/
           vet[n] = v;
           n++; 
        }
        
    //}
    
    /*
    Retira um dado da pilha
    @return dado desempilhado
    */
    
    public T pop(){
        
        T valor = peek();
        vet[n -1 ] = null; 
        n--;
        
        return valor;
        
    }
    
    /*
    Rtorna true se a pilha estiver vazia
    @return true se a pilha estiver vazia
    */
    
    public boolean vazia(){    
        return (n==0);
    }
    
    /*
    Retorna o conteúdo do topo da pilha
    @return topo da pilha
    */
    
    @Override
    public T peek(){
        /* if (estaVazia()) 
            throw new PilhaVaziaException();  */
        return vet[n-1];
    }
    
    /*
    Desempilha todos os dados da pilha
    */
    
    
    public void libera(){
        
        //1a implementação
        vet = (T[]) new Object[tam];
        n = 0;
        
       
    }
    
    /*
    Retorna o conteúdo da pilha
    partindo do topo até a base
    */
    
    @Override
    public String toString (){
        String resultado = "";
        
        for (int i = n - 1; i >= 0; i--) {
           resultado = resultado + vet[i];
            if (i > 0) 
                resultado = resultado + ",";
        }
        
        return resultado;
    }
    
    /*
    Concatena a pilha corrente com outra pilha
    @param p Pilha ser concatenada a pilha atual
    */
    
    public void concatenar(PilhaVetor<T> p){
        for (int i = 0; i < p.n; i++) {
            this.push(p.vet[i]);
        }
    }
     
    
}
