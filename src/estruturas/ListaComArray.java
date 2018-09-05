package estruturas;

public class ListaComArray<T> implements Lista  {
    private T[]  valores;
    private static final int MAXTAM = 100;
    private int ultimo = 0;
    
    public ListaComArray() {
        valores =  (T[]) new Object[MAXTAM];
    }
    
    @Override
    public void insere(Object x){
        /*
        if (ultimo < MAXTAM){
            valores[ultimo] = x;
            ultimo++;
        }
        */
        try {
            valores[ultimo] = (T)x;
            ultimo++;            
        } catch (ArrayIndexOutOfBoundsException aiobe){  
            // não é feito nada, ou seja, o elemento não é incluído por não ter mais espaço
        }
    }
    
    
    @Override
    public boolean estaCheia() {
        return (ultimo == MAXTAM);
    }
    
    
    @Override
    public boolean estaVazia() {
        return (ultimo == 0);
    }
    
    /**
     *
     * @param x
     * @param p
     */
    @Override
    public void insere(Object x, int p){
        if (!this.estaCheia()
            && p <= ultimo){
            Object temp;
            for (int i = p; i <= ultimo; i++){
                temp = valores[i];
                valores[i] = (T)x;
                x = temp;
            }
            ultimo++;
        }
    }
    
    
    @Override
    public T retira(int p){
        T retorno=null;
        if (!this.estaVazia()
            && p >= 0 
            && p < ultimo){
            retorno = valores[p];
            for (int i = p; i < ultimo-1; i++){
                valores[i] = valores[i+1];
            }
            ultimo--;
            valores[ultimo] = null;  // opcional
        }
        return retorno;
    }

    
    @Override
    public int localiza(Object x){
        for (int i=0; i < this.ultimo; i++){
            if (valores[i].equals(x)){
                return i;
            }
        }
        return -1;
    }

    
    @Override
    public int getTamanho() {
        return this.ultimo;
    }

    @Override
    public String imprime() {
        String retorno = "[";

        for (int i=0; i < this.ultimo; i++){
            retorno += valores[i]+"; ";
        }
        try {
            // para retirar a última vírgula e espaço
            retorno = retorno.substring(0,retorno.length()-2);
            return retorno+"]";
        } catch (StringIndexOutOfBoundsException strExc){
            return "[]";
        }
    }

    @Override
    public T consulta(int p){
        try {
            return this.valores[p];
        } catch (IndexOutOfBoundsException iae){
            return null;
        }
    }

    @Override
    public Lista concatena(Lista outra){
        if (this.getTamanho()+outra.getTamanho() > MAXTAM)
            return null;

        ListaComArray nova = new ListaComArray();
        for (int i=0; i < this.getTamanho(); i++){
            nova.insere(this.consulta(i));
        }
        for (int i=0; i < outra.getTamanho(); i++){
            nova.insere(outra.consulta(i));
        }

        return nova;
    }

    @Override
    public Lista divide(){
        if (this.estaVazia())
            return null;

        ListaComArray nova = new ListaComArray();
        int meio = this.getTamanho() / 2;

        for (int i = meio; i < this.getTamanho(); i++){
            nova.insere(valores[i]);
            valores[i] = null;
        }
        this.ultimo = meio;
        return nova;
    }

    @Override
    public Lista copia(){
        ListaComArray nova = new ListaComArray();

        for (int i=0; i < this.getTamanho(); i++){
            nova.insere(valores[i]);
        }

        return nova;
    }

}
