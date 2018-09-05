package estruturas;
import estruturas.ListaEncadeada;

public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada lista = new ListaEncadeada<T>();

    @Override
    public void push(Object v) {
        //lança erro de quantidade quando vetor esta cheio
        lista.insere(v);
    }

    @Override
    public T pop() {
        if (lista.getTamanho() == 0) {
            try {
                throw new RuntimeException("A lista está vazia!");
            } catch (RuntimeException ex) {
                throw new RuntimeException();
            }
        }
        T aux = (T) lista.getPrimeiro().getInfo();
        lista.retira(lista.getTamanho());
        return aux;
    }

    @Override
    public T peek() {
        if (lista.getTamanho() == 0) {
            try {
                throw new RuntimeException("A lista está vazia!");
            } catch (RuntimeException ex) {
                throw new RuntimeException();
            }
        }
        T aux = (T) lista.getPrimeiro().getInfo();
        return aux;
    }

    @Override
    public boolean vazia() {
        if (lista.getTamanho() > 0) {
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
