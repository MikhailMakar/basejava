package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
        return mapResume.containsValue(searchKey);
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
    public void clear() {
        mapResume.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        Resume[] resumes = mapResume.values().toArray(new Resume[mapResume.size()]);
        Arrays.sort(resumes);
        return Arrays.asList(resumes);
    }

    @Override
    public int size() {
        return mapResume.size();
    }
}
