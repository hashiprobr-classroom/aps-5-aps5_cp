package br.edu.insper.desagil.aps5.insee;

public class Evento {

    private DataTempo inicio;
    private DataTempo fim;

    public Evento(DataTempo inicio, DataTempo fim){
        this.inicio = inicio;
        this.fim = fim;
    }

    public DataTempo getInicio() {
        return inicio;
    }

    public DataTempo getFim() {
        return fim;
    }

    public boolean valido(){
        return inicio.comoInteiro() < fim.comoInteiro();
    }
}

