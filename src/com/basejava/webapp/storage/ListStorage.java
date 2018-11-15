package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.LinkedList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> listResume = new LinkedList<>();
    private int listSize = listResume.size();

    @Override
    public void clear() {
        listResume.clear();
    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public void save(Resume r) {

    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) listResume.toArray();
    }

    @Override
    public int size() {
        return listSize;
    }
}
