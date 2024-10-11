package enzocesarano.entities;

import enzocesarano.entities.ENUM.Periodicità;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Riviste")
public class Riviste extends Catalogo {

    @Enumerated(EnumType.STRING)
    private Periodicità periodicita;

    public Riviste() {
    }

    public Riviste(String title, int numero_pagine, LocalDate anno_pubblicazione, Periodicità periodicita) {
        super(title, numero_pagine, anno_pubblicazione);
        this.periodicita = periodicita;
    }

    public Periodicità getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicità periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "periodicita=" + periodicita +
                "} " + super.toString();
    }
}
