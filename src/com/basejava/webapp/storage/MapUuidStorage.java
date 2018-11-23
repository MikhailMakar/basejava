package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {

    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        mapResume.put((String) searchKey, r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return mapResume.containsKey(searchKey);
    }

    @Override
    protected Resume doGet(Object index) {
        return mapResume.get(index);
    }

    @Override
    protected void doDelete(Object index) {
        mapResume.remove(index);
    }

    @Override
    protected void doSave(Resume r, Object index) {
        mapResume.put((String) index, r);
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
