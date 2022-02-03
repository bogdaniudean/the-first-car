package ro.ubb.vvss.repository.base;

import ro.ubb.vvss.model.base.Entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class InMemoryRepository<T extends Entity> implements IRepository<T> {

    private Set<T> entities = new HashSet<>();

    @Override
    public Set<T> get() {
        return Collections.unmodifiableSet(entities);
    }

    @Override
    public void persist(T entity) {
        entities.add(entity);
    }

    @Override
    public void remove(T entity) {
        entities.remove(entity);
    }
}