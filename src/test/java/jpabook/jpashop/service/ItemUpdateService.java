package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

/**
 * Created by wansoo.
 * User: accomplishlee
 */
public class ItemUpdateService {

    @Autowired
    EntityManager em;

    @Test
    public void updateTest() throws Exception {
        em.find(Book.class, 1L);



    }
}
