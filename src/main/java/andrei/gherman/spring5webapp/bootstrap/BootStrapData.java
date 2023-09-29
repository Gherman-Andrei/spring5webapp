package andrei.gherman.spring5webapp.bootstrap;

import andrei.gherman.spring5webapp.domain.Author;
import andrei.gherman.spring5webapp.domain.Book;
import andrei.gherman.spring5webapp.domain.Publisher;
import andrei.gherman.spring5webapp.repositories.AuthorRepository;
import andrei.gherman.spring5webapp.repositories.BookRepository;
import andrei.gherman.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository , PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author autor1 = new Author("Prenume1","Nume1");
        Book carte1 = new Book("Cartea 1 de test" , "0001");

        Publisher editura1 = new Publisher();
        editura1.setname("Editura 1");
        editura1.setCity("Cluj-Napoca");
        editura1.setState("CJ");

        publisherRepository.save(editura1);

        autor1.getBooks().add(carte1);
        carte1.getAuthors().add(autor1);
        carte1.setPublisher(editura1);
        editura1.getBooks().add(carte1);

        authorRepository.save(autor1);
        bookRepository.save(carte1);
        publisherRepository.save(editura1);

        Author autor2 = new Author("Prenume2","Nume2");
        Book carte2 = new Book("Carte 2 de test ", "0002");

        autor2.getBooks().add(carte2);
        carte2.getAuthors().add(autor2);

        authorRepository.save(autor2);
        bookRepository.save(carte2);

        System.out.println("Started in Booststrap");
        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Number of publisher" + publisherRepository.count());
    }
}
