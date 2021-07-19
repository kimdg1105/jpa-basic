package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.Team;
import hellojpa.entity.inheritance.Album;
import hellojpa.entity.inheritance.Book;
import hellojpa.entity.inheritance.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {

            System.out.println("=================");

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("Kim");

            Album album = new Album();
            album.setArtist("Choi");
            album.setName("Rap");

            em.persist(book);
            em.persist(album);


            System.out.println("=================");



            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }
        finally {
            em.close();
        }

        emf.close();




    }
}
