package com.example.restaurantexam.db;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDBRepositoryIfs<T>{
    private final List<T> db = new ArrayList<>();
    private int index = 0;
    @Override
    public Optional<T> findById(int index) {
        db.stream().filter(it -> it.getIndex() == index).findFirst();
        return Optional.empty();
    }

    @Override
    public T save(T entity) {

        var e = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();

        if (e.isEmpty()){//없는경우
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;
        }else{      //db에 데이터가 있는경우
            var preIndex = e.get().getIndex();
            entity.setIndex(preIndex);

            deleteById(preIndex);
            db.add(entity);
            return entity;
        }
    }

    @Override
    public void deleteById(int index) {
        var e = db.stream().filter(it -> it.getIndex() == index).findFirst();
        if(e.isPresent()){
            db.remove(e.get());
        }

    }

    @Override
    public List<T> findAll() {
        return db;
    }
}
