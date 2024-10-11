package enzocesarano.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)

/*
Ho scelto la strategia JOINED per facilitare l'accesso e la gestione delle entità Libri e Riviste tramite
la tabella Catalogo. In questo modo, posso trovare facilmente le informazioni che mi servono senza complicarmi LA VITA.
Tra le tre strategie, sembrava quella più logica da un punto di vista organizzativo.
*/


@DiscriminatorColumn(name = "libro_rivista", discriminatorType = DiscriminatorType.STRING)

@NamedQuery(name = "findByAnnoPubblicazione", query = "SELECT c FROM Catalogo c WHERE YEAR(c.anno_pubblicazione) = :annoPubblicazione")
@NamedQuery(name = "findByTitle", query = "SELECT c FROM Catalogo c WHERE LOWER(c.title) LIKE CONCAT('%', LOWER(:titolo), '%')")
@NamedQuery(name = "findByAuthor", query = "SELECT c FROM Catalogo c WHERE LOWER(c.autore) LIKE CONCAT('%', LOWER(:autore), '%')")

@Table(name = "Catalogo")
public abstract class Catalogo {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private int numero_pagine;
    private LocalDate anno_pubblicazione;


    public Catalogo() {
    }

    public Catalogo(String title, int numero_pagine, LocalDate anno_pubblicazione) {
        this.title = title;
        this.numero_pagine = numero_pagine;
        this.anno_pubblicazione = anno_pubblicazione;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumero_pagine() {
        return numero_pagine;
    }

    public void setNumero_pagine(int numero_pagine) {
        this.numero_pagine = numero_pagine;
    }

    public LocalDate getAnno_pubblicazione() {
        return anno_pubblicazione;
    }

    public void setAnno_pubblicazione(LocalDate anno_pubblicazione) {
        this.anno_pubblicazione = anno_pubblicazione;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", numero_pagine=" + numero_pagine +
                ", anno_pubblicazione=" + anno_pubblicazione +
                '}';
    }
}
