package enzocesarano.dao;

import enzocesarano.entities.Catalogo;
import enzocesarano.entities.Prestiti;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PrestitiDAO {
    private final EntityManager entityManager;

    public PrestitiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Catalogo> findElementiPrestitoInCorso(UUID numeroTessera) {
        List<Catalogo> elementiSearch = new ArrayList<>();
        try {
            TypedQuery<Catalogo> query = entityManager.createNamedQuery("findElementiPrestitoInCorso", Catalogo.class);
            query.setParameter("numeroTessera", numeroTessera);

            elementiSearch = query.getResultList();

            if (elementiSearch.isEmpty()) {
                System.out.println("Nessun elemento in prestito trovato per la tessera: " + numeroTessera);
            }
        } catch (Exception e) {
            System.out.println("Errore durante la ricerca degli elementi in prestito per tessera: " + numeroTessera + ". " + e.getMessage());
        }
        return elementiSearch;
    }

    public List<Prestiti> scadutiNonRestituiti() {
        List<Prestiti> risultati = new ArrayList<>();
        try {
            TypedQuery<Prestiti> query = entityManager.createNamedQuery("findScadutiENonRestituiti", Prestiti.class);
            risultati = query.getResultList();

            if (risultati.isEmpty()) {
                System.out.println("Nessun prestito scaduto e non restituito trovato.");
            }
        } catch (Exception e) {
            System.out.println("Errore durante la ricerca dei prestiti scaduti e non restituiti: " + e.getMessage());
        }

        return risultati;
    }
}