package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {

    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return mapResume.get(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Resume searchKey) {
        mapResume.put(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(Resume searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doSave(Resume r, Resume searchKey) {
        mapResume.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Resume searchKey) {
        return searchKey;
    }

    @Override
    protected void doDelete(Resume searchKey) {
        mapResume.remove(searchKey.getUuid());
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(mapResume.values());
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
