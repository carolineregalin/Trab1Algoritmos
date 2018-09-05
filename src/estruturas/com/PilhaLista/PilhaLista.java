package estruturas.com.PilhaLista;
import estruturas.com.ListaEncadeada.ListaEncadeada;

public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada lista = new ListaEncadeada<T>();

    public void push(Object v) {
        //lança erro de quantidade quando vetor esta cheio
        lista.inserir((T)v);
    }

    public T pop() {
        if (lista.obterComprimento() == 0) {
            try {
                throw new RuntimeException("A lista está vazia!");
            } catch (RuntimeException ex) {
                throw new RuntimeException();
            }
        }
        T aux = (T) lista.getPrimeiro().getInfo();
        lista.retirar(aux);
        return aux;
    }

    public T peek() {
        if (lista.obterComprimento() == 0) {
            try {
                throw new RuntimeException("A lista está vazia!");
            } catch (RuntimeException ex) {
                throw new RuntimeException();
            }
        }
        T aux = (T) lista.getPrimeiro().getInfo();
        return aux;
    }

    public boolean vazia() {
        if (lista.obterComprimento() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public void libera() {
        ListaEncadeada lista2 = new ListaEncadeada<T>();
        this.lista = lista2;
    }
    
    @Override
    public String toString() {
        return lista.toString();
    }
    @Override
    public int getTamanho(){
        return this.lista.obterComprimento();
    }
    
}
