package estruturas.com.ListaEncadeada;

public class ListaEncadeada<T> {
    
    private ItemLista primeiro;
    private ItemLista ultimo;
    
    public ListaEncadeada(){
        primeiro = null;
        ultimo = null;
    }
    
    public ItemLista<T> getPrimeiro() {
        return primeiro;
    }
    
    public void inserir(T info){
        ItemLista novo = new ItemLista();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }
    
    public void exibir(){
        
        ItemLista p = primeiro;
        
        while (p != null) {            
            System.out.println(p.getProximo());
        }
        
    }
    
    public boolean estaVazia(){
        
        if (primeiro == null) {
            return true;
        }
        
        return false;
    }
    
    public ItemLista buscar(T info){
        
        ItemLista p = primeiro;
        
        while (p != null){
            if (p.equals(info)){
                return p;
            }
            p = p.getProximo();
        }
        
        return null;
    }
    
    public T retirar(T info){
        
        ItemLista anterior = null;
        ItemLista p = primeiro;
        
        while (p != null && (p.getInfo() != info)) {            
            anterior = p;
            p = p.getProximo();
        }
        
        if (p != null) {
            if (anterior == null) {
                this.primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
        return info;
    }
    
    public int obterComprimento(){
        
        int cont = 0;
        ItemLista aux = this.getPrimeiro();
        
        while (aux != null) {
            cont++;
            aux = aux.getProximo();
        }
        
        return cont;
    }
    
    public ItemLista obterNo(int idx){
        
        if (idx < 0 || idx > obterComprimento()) {
            throw new IndexOutOfBoundsException();
        }
        
        int cont = 0;
        
        ItemLista aux = this.getPrimeiro();
        while (aux != null && cont != idx) {
            cont++;
            aux = aux.getProximo();
        }
        
        return aux;
    }
    
    @Override
    public String toString() {
        
        String saida = "";

        int cont = 0;
        ItemLista aux = this.getPrimeiro();
        while (aux != null) {
            if (cont > 0) {
                saida += " ";
            }
            saida += aux.getInfo().toString();

            cont++;
            aux = aux.getProximo();
        }

        return saida;
    }
    
    public ListaEncadeada<T> criarSubLista(int inicio,int fim) {
        if (inicio < 0 || fim < 0) {
            throw new IndexOutOfBoundsException();
        }
        ListaEncadeada<T> lista = new ListaEncadeada<T>();
        for (int i = inicio; i < fim; i++) {
            lista.inserir((T) this.obterNo(i).getInfo());
        }
        return lista;
    }
    
    public void inserirNoFinal(T valor) {
        ItemLista<T> novo = new ItemLista<>();
        novo.setInfo(valor);
        novo.setProximo(null);
        if (estaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }
    
}
