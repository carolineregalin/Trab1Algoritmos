package estruturas;

public interface Lista <T>{

    Lista concatena(Lista outra);

    T consulta(int p);

    Lista copia();

    Lista divide();

    boolean estaCheia();

    boolean estaVazia();

    int getTamanho();

    String imprime();

    void insere(T x);

    void insere(T x, int p);

    int localiza(T x);

    T retira(int p);
    
    
}
