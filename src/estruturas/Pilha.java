package estruturas;

public interface Pilha<T> {
    
    void push(T v) throws Exception; 
    T pop () throws Exception; 
    T peek(); 
    boolean vazia(); 
    void libera();
    
}
