package enzocesarano.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Libri")
public class Libri extends Catalogo {

    private String autore;
    private String genere;

    public Libri() {
    }

    public Libri(String title, int numero_pagine, LocalDate anno_pubblicazione, String autore, String genere) {
        super(title, numero_pagine, anno_pubblicazione);
        this.autore = autore;
        this.genere = genere;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                "} " + super.toString();
    }
}