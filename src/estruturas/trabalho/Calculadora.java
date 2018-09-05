/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import com.FilaLista.FilaLista;
import com.ListaEncadeada.ListaEncadeada;
import com.PilhaLista.PilhaLista;
import com.PilhaLista.PilhaVetor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author Daniel Borba Varela dos Santos e Bruno Henrique de Borba
 */
public class Calculadora {

    ListaEncadeada<String> a = new ListaEncadeada<>();
    int contTotal = 0;
    public Calculadora() {

    }

    public ListaEncadeada<String> extrairTermos(String expressao) {
        String[] result = expressao.replace(" ", "").replace(",", ".").split("((?<=[\\(|\\)|\\+|\\*|\\-|/])|(?=[\\(|\\)|\\+|\\*|\\-|/]))");
        
        for (String r : result) {
            a.inserirNoFinal(r);
            contTotal++;
        }
        return a;
    }

    public ListaEncadeada<String> gerarExprPosfixadaPv(ListaEncadeada<String> exprInfixada) {
        PilhaVetor<String> b = new PilhaVetor(contTotal);
        
        ListaEncadeada<String> c = new ListaEncadeada();
        String s = "";
        String v = "";
        int psa = 0, psb = 0, contB = 0, i = 0;

        while (!(exprInfixada.estaVazia())) {

            s = exprInfixada.retirar(exprInfixada.getPrimeiro().getInfo());

            if (s.contains("(")) {
                b.push(s);
                contB++;

            } else if (s.contains(")")) {
                while (!b.vazia()) {
                    v = b.pop();
                    contB--;
                    if (v.contains("(")) {
                        break;
                    } else {
                        c.inserir(v);
                    }
                }

            } else if (s.contains("+") || s.contains("-") || s.contains("*") || s.contains("/")) {
                if (s.contains("+") || s.contains("-")) {
                    psa = 1;
                } else {
                    psa = 2;
                }

                while (!b.vazia()) {
                    v = b.pop();
                    if ((v.contains("(") == false) || (v.contains(")") == false)) {
                        if (v.contains("+") || v.contains("-")) {
                            psb = 1;
                        } else if (v.contains("*") || v.contains("/")) {
                            psb = 2;
                        }
                        if (psb >= psa) {
                            c.inserir(v);
                        } else {
                            b.push(v);
                        }
                    } else {
                        b.push(v);
                    }
                    if (i > contB) {
                        break;
                    }
                    i++;
                }
                b.push(s);
                contB++;
            } else {
                c.inserir(s);
            }
        }
        while (!b.vazia()) {
            v = b.pop();
            contB--;
            if (v.contains("(")) {
                break;
            } else {
                c.inserir(v);
            }
        }
        return c;
    }
    
    public ListaEncadeada<String> gerarExprPosfixadaPl(ListaEncadeada<String> exprInfixada) {

        PilhaLista<String> b = new PilhaLista();

        ListaEncadeada<String> c = new ListaEncadeada();

        String s = "";
        String v = "";
        int psa = 0, psb = 0, contB = 0, i = 0;

        while (!(exprInfixada.estaVazia())) {

            s = exprInfixada.retirar(exprInfixada.getPrimeiro().getInfo());

            if (s.contains("(")) {
                b.push(s);
                contB++;

            } else if (s.contains(")")) {
                while (!b.vazia()) {
                    v = b.pop();
                    contB--;
                    if (v.contains("(")) {
                        break;
                    } else {
                        c.inserir(v);
                    }
                }

            } else if (s.contains("+") || s.contains("-") || s.contains("*") || s.contains("/")) {
                if (s.contains("+") || s.contains("-")) {
                    psa = 1;
                } else {
                    psa = 2;
                }

                while (!b.vazia()) {
                    v = b.pop();
                    if ((v.contains("(") == false) || (v.contains(")") == false)) {
                        if (v.contains("+") || v.contains("-")) {
                            psb = 1;
                        } else if (v.contains("*") || v.contains("/")) {
                            psb = 2;
                        }
                        if (psb >= psa) {
                            c.inserir(v);
                        } else {
                            b.push(v);
                        }
                    } else {
                        b.push(v);
                    }
                    if (i > contB) {
                        break;
                    }
                    i++;
                }
                b.push(s);
                contB++;
            } else {
                c.inserir(s);
            }
        }
        while (!b.vazia()) {
            v = b.pop();
            contB--;
            if (v.contains("(")) {
                break;
            } else {
                c.inserir(v);
            }
        }
        return c;

    }
    
    public ListaEncadeada exibir(ListaEncadeada<String> exprPosfixada){
        ListaEncadeada nova = new ListaEncadeada();
        while (!(exprPosfixada.estaVazia()) ) {            
            nova.inserir(exprPosfixada.retirar(exprPosfixada.getPrimeiro().getInfo()));
        }
        return nova;
    }
 

}
