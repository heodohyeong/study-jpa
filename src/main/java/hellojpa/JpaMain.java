package hellojpa;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    /*public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            *//*Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");
            em.persist(member);
            *//*
            *//*Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            findMember.setName("HelloJPA");*//*

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            for(Member member : result){
                System.out.println("member.name = " + member.getName());
            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();


    }*/
     public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
           Member member = new Member();
           member.setName("hello");
           member.setHomeAddress(new Address("homeCity" , "street" , "101010"));

           member.getFavoriteFoods().add("치킨");
           member.getFavoriteFoods().add("피자");
           member.getFavoriteFoods().add("족발");

           member.getAddressHistory().add(new Address("old1" , "street" , "101010"));
           member.getAddressHistory().add(new Address("old2" , "street" , "101010"));
           
           em.persist(member);
           
           em.flush();
           em.clear();

           System.out.println("===================START==================");
           Member findMember = em.find(Member.class, member.getId());

           Address a = findMember.getHomeAddress();
           findMember.setHomeAddress(new Address("newCity" , a.getStreet() , a.getZipcode()));

           // 치킨 --> 한식
           findMember.getFavoriteFoods().remove("치킨");
           findMember.getFavoriteFoods().add("한식");




           //지연로딩 전략
           for(Address address : findMember.getAddressHistory()){
               System.out.println("favoriteFood = " + address.getCity());
           }

           for(String food : findMember.getFavoriteFoods()){
               System.out.println("favoriteFood = " + food);
           }


            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();


    }


}
