package enzocesarano.dao;

import enzocesarano.entities.Catalogo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class CatalogoDAO {
    private final EntityManager entityManager;

    public CatalogoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Catalogo> ricercaPerAnno(int anno) {
        List<Catalogo> risultati = new ArrayList<>();
        try {
            TypedQuery<Catalogo> query = entityManager.createNamedQuery("findByAnnoPubblicazione", Catalogo.class);
            query.setParameter("annoPubblicazione", anno);
            risultati = query.getResultList();
            if (risultati.isEmpty()) {
                System.out.println("Nessun elemento trovato per l'anno: " + anno);
            }
        } catch (Exception e) {
            System.out.println("Errore durante la ricerca per anno: " + e.getMessage());
        }
        return risultati;
    }

    public List<Catalogo> ricercaPerTitolo(String titolo) {
        List<Catalogo> risultati = new ArrayList<>();
        try {
            TypedQuery<Catalogo> query = entityManager.createNamedQuery("findByTitle", Catalogo.class);
            query.setParameter("titolo", titolo);
            risultati = query.getResultList();
            if (risultati.isEmpty()) {
                System.out.println("Nessun elemento trovato per il titolo: " + titolo);
            }
        } catch (Exception e) {
            System.out.println("Errore durante la ricerca per titolo: " + e.getMessage());
        }
        return risultati;
    }

    public List<Catalogo> ricercaPerAutore(String autore) {
        List<Catalogo> risultati = new ArrayList<>();
        try {
            TypedQuery<Catalogo> query = entityManager.createNamedQuery("findByAuthor", Catalogo.class);
            query.setParameter("autore", autore);
            risultati = query.getResultList();
            if (risultati.isEmpty()) {
                System.out.println("Nessun elemento trovato per l'autore: " + autore);
            }
        } catch (Exception e) {
            System.out.println("Errore durante la ricerca per autore: " + e.getMessage());
        }
        return risultati;
    }
}