package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.BorrowerRecords;
import seedu.address.model.Catalog;
import seedu.address.model.LoanRecords;
import seedu.address.model.ReadOnlyBorrowerRecords;
import seedu.address.model.ReadOnlyCatalog;
import seedu.address.model.ReadOnlyLoanRecords;
import seedu.address.model.book.Author;
import seedu.address.model.book.Book;
import seedu.address.model.book.SerialNumberGenerator;
import seedu.address.model.book.Title;
import seedu.address.model.genre.Genre;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Book[] getSampleBooks() {
        SerialNumberGenerator.setCatalog(new Catalog());
        return new Book[] {
            new Book(new Title("Harry Botter"), SerialNumberGenerator.generateSerialNumber(),
                    new Author("J K Rowling"), null, getGenreSet("FICTION")),
            new Book(new Title("Legend of the Condor Heroes"), SerialNumberGenerator.generateSerialNumber(),
                    new Author("Jin Yong"), null, getGenreSet("FICTION", "HISTORY")),
            new Book(new Title("Animal the Farm"), SerialNumberGenerator.generateSerialNumber(),
                    new Author("George Orwell"), null, getGenreSet("FICTION")),
            new Book(new Title("Harry Botter and the Full Blood Prince"), SerialNumberGenerator.generateSerialNumber(),
                    new Author("J K Rowling"), null, getGenreSet("FICTION", "ACTION")),
            new Book(new Title("Man's Search for Munning"), SerialNumberGenerator.generateSerialNumber(),
                    new Author("Viktor Frankel"), null, getGenreSet("NON-FICTION", "BIOGRAPHY")),
            new Book(new Title("Stefe Jobz"), SerialNumberGenerator.generateSerialNumber(),
                    new Author("Walter Izakson"), null, getGenreSet("NON-FICTION", "BIOGRAPHY")),
            new Book(new Title("Behaves"), SerialNumberGenerator.generateSerialNumber(),
                    new Author("Robert Sapoloksy"), null, getGenreSet("NON-FICTION", "POPULAR-SCIENCE", "PSYCHOLOGY")),
            new Book(new Title("A Brief History of Space"), SerialNumberGenerator.generateSerialNumber(),
                    new Author("Stephen Birding"), null, getGenreSet("NON-FICTION", "POPULAR-SCIENCE")),
            new Book(new Title("Painting with Bobby Ross"), SerialNumberGenerator.generateSerialNumber(),
                    new Author("Bobby Ross"), null, getGenreSet("NON-FICTION", "ART", "HOW-TO")),
        };
    }

    public static ReadOnlyCatalog getSampleCatalog() {
        Catalog sampleAb = new Catalog();
        Arrays.stream(getSampleBooks()).forEach(book -> sampleAb.addBook(book));
        return sampleAb;
    }

    /**
     * Returns a genre set containing the list of strings given,
     * after formatting the strings to UPPERCASE
     */
    public static Set<Genre> getGenreSet(String... strings) {
        return Arrays.stream(strings)
                .map(genreName -> genreName.trim().toUpperCase())
                .map(Genre::new)
                .collect(Collectors.toSet());
    }

    // Technically not needed
    public static ReadOnlyLoanRecords getSampleLoanRecords() {
        LoanRecords loanRecords = new LoanRecords();
        return loanRecords;
    }

    public static ReadOnlyBorrowerRecords getSampleBorrowerRecords() {
        BorrowerRecords borrowerRecords = new BorrowerRecords();
        return borrowerRecords;
    }
}
