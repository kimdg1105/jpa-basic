package hellojpa;

import hellojpa.entity.Child;
import hellojpa.entity.Member;
import hellojpa.entity.Parent;
import hellojpa.entity.Team;
import hellojpa.entity.embedded.Address;
import hellojpa.entity.embedded.AddressEntity;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {

            System.out.println("=================");

            Member member = new Member();
            member.setUsername("Dong");

            member.setWorkPeriod(new Period(LocalDateTime.now(),LocalDateTime.now()));

            member.getFavoriteFoods().add("Chicken");
            member.getFavoriteFoods().add("Meat");
            member.getFavoriteFoods().add("Fish");

            AddressEntity address1 = new AddressEntity("Busan", "12", "2223");
            member.setHomeAddress(address1.getAddress());
            member.getAddressHistory().add(address1);
            member.getAddressHistory().add(new AddressEntity("Seoul", "86", "1234"));

            em.persist(member);
//            em.flush();
//            em.clear();
//
//            System.out.println("----------");
//
//            Member member1 = em.find(Member.class, member.getId()); //@ElementCollection 은 지연로딩으로 불러온다. 기본값이 LAZY
//            System.out.println("----------");
//            Set<String> meber1FavoriteFoods = member1.getFavoriteFoods();
//            System.out.println("meber1FavoriteFoods = " + meber1FavoriteFoods.toString());
//
//            Address a = member1.getHomeAddress();
//            member1.setHomeAddress(new Address("NewPlace", a.getStreet(),a.getZipcode())); // 올바른 값 타입 변경 1
//
//            member1.getFavoriteFoods().remove("Meat");
//            member1.getFavoriteFoods().add("new Food"); //올바른 값 타입 변경 2
//
//            member1.getAddressHistory().remove(new AddressEntity("Busan", "12", "2223"));
//            member1.getAddressHistory().add(new AddressEntity("NewCity", "12", "2223"));



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
