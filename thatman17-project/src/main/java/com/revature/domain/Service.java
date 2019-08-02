package com.revature.domain;

import java.util.List;

public interface Service<E> {
    void insert(E e);

    List<E> getAll();

    void update();

    void delete();
}