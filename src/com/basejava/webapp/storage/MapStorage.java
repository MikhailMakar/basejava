package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected Resume doGet(Object index) {
        return mapResume.get(index);
    }

    @Override
    protected boolean checkIndex(Object index) {
        return mapResume.containsKey(index);
    }

    @Override
    protected void fillDeletedElement(Object index) {
        mapResume.remove(index);
    }

    @Override
    protected void insertElement(Resume r, Object index) {
        mapResume.put((String) index, r);
    }

    @Override
    protected void updateElement(Resume r, Object index) {
        mapResume.put((String) index, r);
    }

    @Override
    protected void decreaseQuantity() {
    }

    @Override
    protected void increaseQuantity() {

    }

    @Override
    protected void checkStorage(Resume r) {

    }

    @Override
    public void clear() {
        mapResume.clear();
    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) mapResume.values().toArray();
    }

    @Override
    public int size() {
        return mapResume.size();
    }
}
