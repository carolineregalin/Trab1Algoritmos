package estruturas.trabalho;

import estruturas.com.ListaEncadeada.ListaEncadeada;
import estruturas.com.PilhaLista.Pilha;
import estruturas.com.PilhaLista.PilhaLista;
import estruturas.com.PilhaLista.PilhaVetor;
import java.*;

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
    
    public Pilha exibir(ListaEncadeada<String> exprPosfixada, Pilha<String> nova) throws Exception{
        while (!(exprPosfixada.estaVazia()) ) {            
            nova.push(exprPosfixada.retirar(exprPosfixada.getPrimeiro().getInfo()));
        }
        return nova;
    }
    public double calcular(Pilha<String> exprPosFixada, Pilha pilhaOperandos) throws Exception{

        // Variáveis auxiliares
        double resultado = 0;
        double aux1 = 0;
        double aux2 = 0;
        
        while(!exprPosFixada.vazia()){
            //Pega o primeiro item da pilha
            String aux = exprPosFixada.peek();
            // Se for operando
            // Verifica se é um número positivo, negativo ou 
            if (aux.matches("^-?[0-9]\\d*(\\,\\d+)?$")) {
                // Inserir na pilha
                pilhaOperandos.push(aux);
                // Remove ele da fila
                exprPosFixada.pop();
            }else { // Se for operador
                // Caso não haja elementos suficientes na pilha (pelo menos dois) para realizar a operação
                if (pilhaOperandos.getTamanho() < 2) {
                    throw new IllegalArgumentException("Não há o número mínimo (dois) de parâmetros para realizar uma operação!");
                }
                // Calcula a operação enviando o operador e os dois operandos
                resultado = calcularValor(exprPosFixada.pop(), Double.valueOf(((String)pilhaOperandos.pop()).replace(",", ".")), Double.valueOf(((String)pilhaOperandos.pop()).replace(",", ".")));
                // Joga os valores pra pilha de operandos
                pilhaOperandos.push(String.valueOf(resultado));
            }
            
        }
        // Retorna o valor da expressão
        return Double.valueOf((String)pilhaOperandos.pop());
    
    }
    
    private double calcularValor(String operacao, double valorUm, double valorDois) {
        // Verifica qual operação realizar
        switch (operacao) {
            // Soma
            case "+":
                // Realiza a operação
                return valorUm + valorDois;
            // Subtração
            case "-":
                return valorDois - valorUm;
            // Multiplicação
            case "*":
                return valorUm * valorDois;
            // Divisão
            case "/":
                if (valorUm == 0) {
                    throw new IllegalArgumentException("Operação inválida, impossível dividir por zero!");
                }
                return valorDois / valorUm;
            default:
                throw new IllegalArgumentException("Operação inválida!");
        }
    }

}
