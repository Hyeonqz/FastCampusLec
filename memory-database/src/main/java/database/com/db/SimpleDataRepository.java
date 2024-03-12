package database.com.db;

import database.com.entity.Entity;

import java.util.*;
import java.util.stream.Collectors;

abstract public class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T,ID> {
    // 제네릭 타입은 Entity를 상속받은 것만 들어옴.
    private List<T> dataList = new ArrayList<>();
    private static long index = 0;

    private Comparator<T> sorting = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };

    // create, update
    @Override
    public T save(T data) {
        // null 값 처리
        if (Objects.isNull(data)) {
            throw new RuntimeException("data is null");
        }

        var prevData = dataList.stream()
                .filter(it -> {
                    return it.getId().equals(data.getId());
                })
                .findFirst();

        if (prevData.isPresent()) {
            //기존 데이터가 있는 경우는 update
            dataList.remove(prevData);
            dataList.add(data);


        }
        //기존 데이터가 없으면 insert
        else {
            // unique id
            data.setId(index);
            dataList.add(data);
            index++;
        }

        return null;
    }

    // Read
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
                .sorted(sorting)
                .collect(Collectors.toList());
    }


    //delete

    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream()
                .filter(it -> {
                    return it.getId().equals(id);
                })
                .findFirst();

        if (deleteEntity.isPresent()) {
            dataList.remove(deleteEntity.get());
        }
    }
}
