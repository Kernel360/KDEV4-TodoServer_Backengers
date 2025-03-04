package com.example.demo.db;

import com.example.demo.entity.Entity;

import java.util.*;
import java.util.stream.Collectors;

public abstract class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID> {
    private List<T> dataList = new ArrayList<>();
    private static long index = 0;
    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };

    // create
    @Override
    public T save(T data) {
        if (Objects.isNull(data)) {
            throw new RuntimeException("Data is null");
        }

        // db 에 데이터가 있는가?
        var prevData = dataList.stream().filter(
                it -> it.getId().equals(data.getId())
        ).findFirst();

        if (prevData.isPresent()) {
            // 기존 데이터 있는 경우 업데이트
            // 이전 데이터를 없애버리고 새로운 데이터가 자리 잡게 되지만 고유한 아이디는 동일함.
            dataList.remove(prevData);
            dataList.add(data);
        } else {
            // 없는 경우
            // unique id;
            data.setId(index++);
            dataList.add(data);
        }
        return data;
    }


    // read
    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream()
                .filter(it -> {
                    return (it.getId().equals(id));
                })
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList.stream()
                .sorted(sort)
                .collect(Collectors.toList());
    }

    // delete
    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();

        if (deleteEntity.isPresent()) {
            dataList.remove(deleteEntity);
        }
    }
}
