package com.nolascojoao.javapersistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldJPATest {

    @Test
    public void storeAndLoadMessage() {
        // Create an EntityManagerFactory based on the persistence unit ch02
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch02");

        try {
            // Create an EntityManager from the EntityManagerFactory
            EntityManager em = emf.createEntityManager();
            // Begin a transaction
            em.getTransaction().begin();

            // Create a new instance of Message and set its text to "Hello World"
            Message message = new Message();
            message.setText("Hello World");

            // Persist the message to the database
            em.persist(message);

            // Commit the transaction
            // INSERT into MESSAGE(ID, TEXT) values(1,"Hello World")
            em.getTransaction().commit();

            // Begin another transaction
            em.getTransaction().begin();

            // Execute a JPQL query to select all messages
            // SELECT * from MESSAGE
            List<Message> messages = em.createQuery("select m from Message m", Message.class)
                    .getResultList();

            // Update the text of the last message in the list
            messages.get(messages.size() - 1).setText("Hello World from JPA!");

            // Commit the second transaction
            // UPDATE MESSAGE set TEXT = 'Hello World from JPA!' where ID = 1
            em.getTransaction().commit();

            // Verify the results using JUnit
            assertAll(
                    () -> assertEquals(1, messages.size()),
                    () -> assertEquals("Hello World from JPA!", messages.get(0).getText())
            );

            // Close the EntityManager
            em.close();
        } finally {
            // Close the EntityManagerFactory
            emf.close();
        }
    }

}
