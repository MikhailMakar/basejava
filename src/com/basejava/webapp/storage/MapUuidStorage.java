package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {

    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume resume, String searchKey) {
        mapResume.put(searchKey, resume);
    }

    @Override
    protected boolean isExist(String searchKey) {
        return mapResume.containsKey(searchKey);
    }

    @Override
    protected Resume doGet(String index) {
        return mapResume.get(index);
    }

    @Override
    protected void doDelete(String index) {
        mapResume.remove(index);
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(mapResume.values());
    }

    @Override
    protected void doSave(Resume resume, String index) {
        mapResume.put(index, resume);
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
