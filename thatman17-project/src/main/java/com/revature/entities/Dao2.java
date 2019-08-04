package com.revature.entities;

import java.util.List;

/**
 * Dao
 */
public interface Dao2<E> {
    
    List<E> getAll();
    
    List<E> getApproved();

    /**void update();

    void delete();*/
    
    void insert(E e);
    
    void approve(int id, int approval);
}