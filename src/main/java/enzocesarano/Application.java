package enzocesarano;

import enzocesarano.dao.CatalogoDAO;
import enzocesarano.dao.DefaultDAO;
import enzocesarano.dao.PrestitiDAO;
import enzocesarano.entities.Catalogo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.UUID;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto11_10_2024");

    public static void main(String[] args) throws Exception {
        EntityManager em = emf.createEntityManager();
        DefaultDAO dd = new DefaultDAO(em);
        CatalogoDAO cd = new CatalogoDAO(em);
        PrestitiDAO pd /*(giuro non è una bestemmia, neanche il partito democratico...scusa. T.T)*/ = new PrestitiDAO(em);


        // Ho usato il metodo generico per il salvataggio, ricerca e eliminazione degli elementi suggerito dal Sign. PELLIZZARI <3

        System.out.println("\n*********************** AGGIUNGI ELEMENTO AL CATALOGO ***********************\n");

        /*
        Libri ilSignoreDegliAnelli = new Libri("Il Signore degli Anelli", 1000, LocalDate.of(1954, 7, 29), "J.R.R. Tolkien", "Fantasy");
        Libri millenovecentottantaquattro = new Libri("1984", 326, LocalDate.of(1949, 6, 8), "George Orwell", "Distopia");
        Libri mobyDick = new Libri("Moby Dick", 635, LocalDate.of(1851, 11, 14), "Herman Melville", "Avventura");
        Libri prideAndPrejudice = new Libri("Pride and Prejudice", 432, LocalDate.of(1813, 1, 28), "Jane Austen", "Romanzo");
        Libri theGreatGatsby = new Libri("The Great Gatsby", 218, LocalDate.of(1925, 4, 10), "F. Scott Fitzgerald", "Classico");
        Libri warAndPeace = new Libri("War and Peace", 1225, LocalDate.of(1869, 1, 1), "Leo Tolstoy", "Storico");
        Libri donQuixote = new Libri("Don Quixote", 863, LocalDate.of(1605, 1, 16), "Miguel de Cervantes", "Classico");
        Libri theHobbit = new Libri("The Hobbit", 310, LocalDate.of(1937, 9, 21), "J.R.R. Tolkien", "Fantasy");
        Libri toKillAMockingbird = new Libri("To Kill a Mockingbird", 281, LocalDate.of(1960, 7, 11), "Harper Lee", "Classico");
        Libri theCatcherInTheRye = new Libri("The Catcher in the Rye", 214, LocalDate.of(1951, 7, 16), "J.D. Salinger", "Romanzo");

        dd.save(ilSignoreDegliAnelli);
        dd.save(millenovecentottantaquattro);
        dd.save(mobyDick);
        dd.save(prideAndPrejudice);
        dd.save(theGreatGatsby);
        dd.save(warAndPeace);
        dd.save(donQuixote);
        dd.save(theHobbit);
        dd.save(toKillAMockingbird);
        dd.save(theCatcherInTheRye);

        Riviste nationalGeographic = new Riviste("National Geographic", 90, LocalDate.of(2022, 10, 1), Periodicità.MENSILE);
        Riviste science = new Riviste("Science", 120, LocalDate.of(2023, 4, 15), Periodicità.SETTIMANALE);
        Riviste time = new Riviste("Time", 80, LocalDate.of(2023, 3, 10), Periodicità.MENSILE);
        Riviste forbes = new Riviste("Forbes", 75, LocalDate.of(2022, 11, 20), Periodicità.SETTIMANALE);
        Riviste vogue = new Riviste("Vogue", 100, LocalDate.of(2023, 1, 5), Periodicità.SEMESTRALE);

        dd.save(nationalGeographic);
        dd.save(science);
        dd.save(time);
        dd.save(forbes);
        dd.save(vogue);

        Utenti marioRossi = new Utenti("Mario", "Rossi", LocalDate.of(1985, 5, 20));
        Utenti lucaBianchi = new Utenti("Luca", "Bianchi", LocalDate.of(1990, 3, 14));
        Utenti annaVerdi = new Utenti("Anna", "Verdi", LocalDate.of(1995, 8, 25));

        dd.save(marioRossi);
        dd.save(lucaBianchi);
        dd.save(annaVerdi);

        Libri ilSignoreDegliAnelli = dd.getEntityById(Libri.class, "34f532e7-c803-462f-8928-2f41b22bd712");
        Riviste nationalGeographic = dd.getEntityById(Riviste.class, "bbc98ed4-5f3f-4ff8-a934-4581e7c3f7df");
        Libri millenovecentottantaquattro = dd.getEntityById(Libri.class, "f3776d94-3868-4fd5-a5c1-366d32a6e802");
        Riviste science = dd.getEntityById(Riviste.class, "1d852577-f27e-4fcf-a5e8-dbd9675c6c43");
        Libri mobyDick = dd.getEntityById(Libri.class, "34f532e7-c803-462f-8928-2f41b22bd712");

        Utenti marioRossi = dd.getEntityById(Utenti.class, "2cf68bbe-06b0-45d6-a5d0-70fd75bbc8e0");
        Utenti lucaBianchi = dd.getEntityById(Utenti.class, "5bc38e12-add5-48c3-b388-3c515ced1c81");
        Utenti annaVerdi = dd.getEntityById(Utenti.class, "df6783f8-d398-4ab0-a4b4-93142af2a1ad");

        Prestiti prestito1 = new Prestiti(marioRossi, ilSignoreDegliAnelli, LocalDate.of(2024, 10, 10), LocalDate.of(2024, 11, 10), null);
        Prestiti prestito2 = new Prestiti(marioRossi, nationalGeographic, LocalDate.of(2023, 9, 1), LocalDate.of(2023, 10, 1), LocalDate.of(2023, 9, 29));
        Prestiti prestito3 = new Prestiti(lucaBianchi, millenovecentottantaquattro, LocalDate.of(2023, 9, 15), LocalDate.of(2023, 10, 15), null);
        Prestiti prestito4 = new Prestiti(lucaBianchi, science, LocalDate.of(2023, 9, 20), LocalDate.of(2023, 10, 20), null);
        Prestiti prestito5 = new Prestiti(annaVerdi, mobyDick, LocalDate.of(2023, 10, 5), LocalDate.of(2023, 11, 5), null);

        dd.save(prestito1);
        dd.save(prestito2);
        dd.save(prestito3);
        dd.save(prestito4);
        dd.save(prestito5);
        */

        System.out.println("\n*********************** RMOZIONE DI UN ELEMENTO DATO UN ID ***********************\n");
        dd.delete(Catalogo.class, "119ca138-3a1c-4632-99d9-753bb4596666");      // cambia l'id per testare il metodo (id già utilizzato).

        System.out.println("\n*********************** RICERCA PER ID ***********************\n");
        Catalogo elemento = dd.getEntityById(Catalogo.class, "c5c80110-4969-454e-a8ad-85a9d92e6c91");
        System.out.println(elemento);

        System.out.println("\n*********************** RICERCA PER ANNO ***********************\n");
        cd.ricercaPerAnno(1992).forEach(System.out::println);             // il metodo è per l'anno specifico, non per gli elementi pubblicati fino a quella data.

        System.out.println("\n*********************** RICERCA PER TITOLO ***********************\n");
        cd.ricercaPerTitolo("the").forEach(System.out::println);

        System.out.println("\n*********************** RICERCA PER AUTORE ***********************\n");
        cd.ricercaPerAutore("J.R.R. Tolkien").forEach(System.out::println);          // questo metodo è praticamente identico a quello della ricerca per titolo.

        System.out.println("\n*********************** IN PRESTITO PER NUMERO DI TESSERA ***********************\n");
        pd.findElementiPrestitoInCorso(UUID.fromString("2cf68bbe-06b0-45d6-a5d0-70fd75bbc8e0")).forEach(System.out::println);

        System.out.println("\n*********************** PRESTITI SCADUTI E NON RESTITUITI ***********************\n");
        pd.scadutiNonRestituiti().forEach(System.out::println);

        em.close();
        emf.close();
    }
}
