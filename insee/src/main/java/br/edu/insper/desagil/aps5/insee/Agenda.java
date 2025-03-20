package br.edu.insper.desagil.aps5.insee;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Evento> eventos;

    public Agenda(){
        this.eventos = new ArrayList<>();


    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void adiciona(Evento evento){
        if (evento.valido()){
            eventos.add(evento);
        }
        else{
            throw new IllegalArgumentException("Evento inválido!");
        }
    }
}
