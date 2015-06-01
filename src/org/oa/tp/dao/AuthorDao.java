package org.oa.tp.dao;

import org.oa.tp.data.Author;

import java.util.Collection;
import java.util.List;

/**
 * Created by Eugene on 02.06.2015.
 */
public class AuthorDao implements AbstractDao<Author> {
    @Override
    public List<Author> loadAll() {
        return null;
    }

    @Override
    public Author findById() {
        return null;
    }

    @Override
    public boolean delete(int objectId) {
        return false;
    }

    @Override
    public boolean update(Author changed) {
        return false;
    }

    @Override
    public boolean add(Author add) {
        return false;
    }

    @Override
    public boolean addAll(Collection<Author> collection) {
        return false;
    }
}
