package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected int getIndex(String uuid) {
        return uuid.hashCode();
    }

    @Override
    protected Resume doGet(int index) {
        return mapResume.get(getKey(index));
    }

    @Override
    protected boolean checkIndex(int index) {
        return !(mapResume.containsKey(getKey(index)));
    }

    @Override
    protected void fillDeletedElement(int index) {
        mapResume.remove(getKey(index));
    }

    @Override
    protected void insertElement(Resume r, int index) {
        mapResume.put(getKey(index), r);
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

    private String getKey(int index) {
        String key = null;
        for (Map.Entry entry : mapResume.entrySet()) {
            Object gKey = entry.getKey();
            if (gKey.hashCode() == index) {
                key = (String) gKey;
            }
        }
        return key;
    }
}
