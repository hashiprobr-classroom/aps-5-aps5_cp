package br.edu.insper.desagil.aps5.insee;

public class DataTempo extends Referencia{

    private Data data;
    private Tempo tempo;

    public DataTempo(Data data, Tempo tempo){
        this.data = data;
        this.tempo = tempo;
    }


    public Tempo getTempo() {
        return tempo;
    }

    public Data getData() {
        return data;
    }

    @Override
    public int comoInteiro() {

        return data.comoInteiro() * 1440 + tempo.comoInteiro();
    }

}
