package jpa.jpa_basic.jpashop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpa.jpa_basic.jpashop.domain.*;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Album album = new Album();
            album.setName("dd");

            Movie movie = new Movie();
            movie.setName("mm");

            Book book = new Book();
            book.setAuthor("kim");
            book.setName("미움받을 용기");

            em.persist(album);
            em.persist(movie);
            em.persist(book);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}