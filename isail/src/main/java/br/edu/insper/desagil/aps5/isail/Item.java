package br.edu.insper.desagil.aps5.isail;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Item {
    private String nome;
    private double minimo;
    private List<LocalDateTime> momentos;
    private List<Comprador> compradores;
    private List<Double> ofertas;

    public Item(String nome, double minimo) {
        this.nome = nome;
        this.minimo = minimo;
        this.momentos = new ArrayList<>();
        this.compradores = new ArrayList<>();
        this.ofertas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int indiceMelhorLance() {
        if (ofertas.isEmpty()) {
            return -1;
        }
        int indiceMelhor = 0;
        for (int i = 1; i < ofertas.size(); i++) {
            if (ofertas.get(i) > ofertas.get(indiceMelhor)) {
                indiceMelhor = i;
            }
        }
        return indiceMelhor;
    }

    public void fazLance(Comprador comprador, double oferta) {
        if (oferta < minimo) {
            return;
        }

        if (!ofertas.isEmpty()) {
            int indiceMelhor = indiceMelhorLance();
            if (oferta <= ofertas.get(indiceMelhor)) {
                return;
            }
        }

        momentos.add(LocalDateTime.now());
        compradores.add(comprador);
        ofertas.add(oferta);

        comprador.incrementa();
    }


    public void imprimeMelhorLance() {
        int indiceMelhor = indiceMelhorLance();
        if (indiceMelhor == -1) {
            System.out.println("Nenhum lance foi feito ainda!");
        } else {
            System.out.println(compradores.get(indiceMelhor) + " ofereceu "
                    + ofertas.get(indiceMelhor) + " (" + momentos.get(indiceMelhor) + ")");
        }
    }
}