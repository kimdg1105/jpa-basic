package hellojpa;

import hellojpa.entity.Child;
import hellojpa.entity.Member;
import hellojpa.entity.Parent;
import hellojpa.entity.Team;
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

            Parent parent = new Parent();

            Child child1 = new Child();
            Child child2= new Child();

            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);
            em.flush();
            em.clear();

            Parent parent1 = em.find(Parent.class, parent.getId());
            em.remove(parent1);


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
