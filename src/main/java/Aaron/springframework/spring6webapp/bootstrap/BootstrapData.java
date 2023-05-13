package Aaron.springframework.spring6webapp.bootstrap;

import Aaron.springframework.spring6webapp.domain.Author;
import Aaron.springframework.spring6webapp.domain.Book;
import Aaron.springframework.spring6webapp.domain.Publisher;
import Aaron.springframework.spring6webapp.repositories.AuthorRepository;
import Aaron.springframework.spring6webapp.repositories.BookRepository;
import Aaron.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");
        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");
        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);


        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");
        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");
        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        //add book to their Author's book set
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        //saved Author's updated data to database
        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        //publisher
        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main");
        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
