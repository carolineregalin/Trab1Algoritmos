package estruturas;

class ItemLista <T>{
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
