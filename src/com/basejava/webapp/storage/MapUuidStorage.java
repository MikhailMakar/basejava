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
    protected void doUpdate(Resume r, String searchKey) {
        mapResume.put( searchKey, r);
    }

    @Override
    protected boolean isExist(String searchKey) {
        return mapResume.containsKey( searchKey);
    }

    @Override
    protected Resume doGet(String index) {
        return mapResume.get( index);
    }

    @Override
    protected void doDelete(String index) {
        mapResume.remove( index);
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(mapResume.values());
    }

    @Override
    protected void doSave(Resume r, String index) {
        mapResume.put( index, r);
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
