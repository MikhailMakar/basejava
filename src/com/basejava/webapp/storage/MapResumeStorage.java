package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {

    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return mapResume.get(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        mapResume.put(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        mapResume.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return (Resume) searchKey;
    }

    @Override
    protected void doDelete(Object searchKey) {
        Resume r = (Resume) searchKey;
        mapResume.remove(r.getUuid());
    }

    @Override
    protected Resume[] getAll() {
        return mapResume.values().toArray(new Resume[mapResume.size()]);
    }

    @Override
    public void clear() {
        mapResume.clear();
    }

    @Override
    public int size() {
        return mapResume.size();
    }
}
