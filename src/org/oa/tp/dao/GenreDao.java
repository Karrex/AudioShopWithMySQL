package org.oa.tp.dao;

import org.oa.tp.data.Genre;

import java.util.Collection;
import java.util.List;

/**
 * Created by Eugene on 02.06.2015.
 */
public class GenreDao implements AbstractDao<Genre>{
    @Override
    public List<Genre> loadAll() {
        return null;
    }

    @Override
    public Genre findById() {
        return null;
    }

    @Override
    public boolean delete(int objectId) {
        return false;
    }

    @Override
    public boolean update(Genre changed) {
        return false;
    }

    @Override
    public boolean add(Genre add) {
        return false;
    }

    @Override
    public boolean addAll(Collection<Genre> collection) {
        return false;
    }
}
