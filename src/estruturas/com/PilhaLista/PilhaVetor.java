
package estruturas.com.PilhaLista;

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
    @Override
    public void push(Object v){
        /*if (n == tam) {
            throw new PilhaCheiaException();
        } else {*/
           vet[n] = (T)v;
           n++; 
        }
        
    //}
    
    /*
    Retira um dado da pilha
    @return dado desempilhado
    */
    @Override
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
    @Override
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
    
    @Override
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

    @Override
    public int getTamanho() {
        return this.n;
    }
     
    
}
