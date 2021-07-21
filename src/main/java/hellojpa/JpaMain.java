package hellojpa;

import hellojpa.entity.Child;
import hellojpa.entity.Member;
import hellojpa.entity.Parent;
import hellojpa.entity.Team;
import hellojpa.entity.embedded.Address;
import hellojpa.entity.embedded.Period;
import hellojpa.entity.inheritance.Album;
import hellojpa.entity.inheritance.Book;
import hellojpa.entity.inheritance.Movie;
import org.hibernate.Hibernate;

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

            Address address1 = new Address("Seoul", "86", "1234");

            Member member = new Member();
            member.setUsername("Dong");
            member.setHomeAddress(address1);
            member.setWorkPeriod(new Period(LocalDateTime.now(),LocalDateTime.now()));

            Address address = new Address(address1.getCity(),address1.getStreet(), "5678");
            member.setHomeAddress(address);

            em.persist(member);

            System.out.println("=================");



            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        finally {
            em.close();
        }

        emf.close();




    }
}
