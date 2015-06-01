package org.oa.tp.dao;

import org.oa.tp.data.Audio;

import java.util.Collection;
import java.util.List;

/**
 * Created by Eugene on 02.06.2015.
 */
public class AudioDao implements AbstractDao<Audio> {
    @Override
    public List<Audio> loadAll() {
        return null;
    }

    @Override
    public Audio findById() {
        return null;
    }

    @Override
    public boolean delete(int objectId) {
        return false;
    }

    @Override
    public boolean update(Audio changed) {
        return false;
    }

    @Override
    public boolean add(Audio add) {
        return false;
    }

    @Override
    public boolean addAll(Collection<Audio> collection) {
        return false;
    }
}
