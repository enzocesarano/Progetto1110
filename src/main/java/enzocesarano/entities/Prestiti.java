package enzocesarano.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

@NamedQuery(name = "findElementiPrestitoInCorso",
        query = "SELECT p.elementoPrestato.id FROM Prestiti p WHERE p.utente.numero_tessera = :numeroTessera AND CURRENT_DATE BETWEEN p.data_inizio_prestito AND p.data_restituzione_prevista")

@NamedQuery(name = "findScadutiENonRestituiti", query = "SELECT p FROM Prestiti p WHERE p.data_restituzione_prevista < CURRENT_DATE AND p.data_restituzione_effettiva IS NULL")

@Table(name = "Prestiti")
public class Prestiti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prestito_id;

    @ManyToOne
    @JoinColumn(name = "utente")
    private Utenti utente;

    @ManyToOne
    @JoinColumn(name = "elemento_prestato")
    private Catalogo elementoPrestato;

    private LocalDate data_inizio_prestito;
    private LocalDate data_restituzione_prevista;
    private LocalDate data_restituzione_effettiva;

    public Prestiti() {
    }

    public Prestiti(Utenti utente, Catalogo elementoPrestato, LocalDate data_inizio_prestito, LocalDate data_restituzione_prevista, LocalDate data_restituzione_effettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.data_inizio_prestito = data_inizio_prestito;
        this.data_restituzione_prevista = data_restituzione_prevista;
        this.data_restituzione_effettiva = data_restituzione_effettiva;
    }

    public Long getId() {
        return prestito_id;
    }

    public Utenti getUtente() {
        return utente;
    }

    public void setUtente(Utenti utente) {
        this.utente = utente;
    }

    public Catalogo getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(Catalogo elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getData_inizio_prestito() {
        return data_inizio_prestito;
    }

    public void setData_inizio_prestito(LocalDate data_inizio_prestito) {
        this.data_inizio_prestito = data_inizio_prestito;
    }

    public LocalDate getData_restituzione_prevista() {
        return data_restituzione_prevista;
    }

    public void setData_restituzione_prevista(LocalDate data_restituzione_prevista) {
        this.data_restituzione_prevista = data_restituzione_prevista;
    }

    public LocalDate getData_restituzione_effettiva() {
        return data_restituzione_effettiva;
    }

    public void setData_restituzione_effettiva(LocalDate data_restituzione_effettiva) {
        this.data_restituzione_effettiva = data_restituzione_effettiva;
    }

    @Override
    public String toString() {
        return "Prestiti{" +
                "prestito_id=" + prestito_id +
                ", utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", data_inizio_prestito=" + data_inizio_prestito +
                ", data_restituzione_prevista=" + data_restituzione_prevista +
                ", data_restituzione_effettiva=" + data_restituzione_effettiva +
                '}';
    }
}