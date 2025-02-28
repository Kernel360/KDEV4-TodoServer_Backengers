package com.example.memorydb.db;

import com.example.memorydb.entity.Entity;

import java.util.*;

public abstract class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID> {

    private final List<T> dataList = new ArrayList<>();

    private static Long index = 0L;

    private final Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };

    //create, update
    @Override
    public T save(T data) {

        if (Objects.isNull(data)) throw new RuntimeException("Data is null");

        var prevData = dataList.stream()
                .filter(it -> it.getId().equals(data.getId()))
                .findFirst();

        if (prevData.isPresent()) {
            dataList.remove(prevData.get());
            dataList.add(data);
        } else {
            data.setId(index);
            dataList.add(data);
            index++;
        }

        return data;
    }


    //read
    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList.stream()
                .sorted(sort)
                .toList();
    }

    //delete
    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();

        if (deleteEntity.isPresent()) {
            dataList.remove(deleteEntity.get());
        }
    }
}
