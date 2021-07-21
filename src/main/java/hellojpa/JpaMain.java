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

            Member member2 = new Member();
            Address address2 = new Address(address1.getCity(),address1.getStreet(),address1.getZipcode());

            member2.setUsername("Dong2");
            member2.setHomeAddress(address2);
            member2.setWorkPeriod(new Period(LocalDateTime.now(),LocalDateTime.now()));

            em.persist(member);
            em.persist(member2);

            em.flush();


            address2.setCity("MAPO");
            member2.setHomeAddress(address2);

            em.persist(member2);


            System.out.println("address2 = " + address2.toString());


            em.flush();
            em.clear();


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
