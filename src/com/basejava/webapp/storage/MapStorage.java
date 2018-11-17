package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public class MapStorage extends AbstractStorage {

    @Override
    public void clear() {
        mapResume.clear();
    }

    @Override
    public void update(Resume r) {
        String id = r.getUuid();
        if (mapResume.putIfAbsent(id, r) == null) {
            throw new NotExistStorageException(id);
        }
    }

    @Override
    public void save(Resume r) {
        String id = r.getUuid();
        if (!(mapResume.putIfAbsent(id, r) == null)) {
            throw new ExistStorageException(id);
        }
    }

    @Override
    public Resume get(String uuid) {
        Resume resume = mapResume.get(uuid);
        if (resume == null) {
            throw new NotExistStorageException(uuid);
        }
        return resume;
    }

    @Override
    public void delete(String uuid) {
        if (mapResume.remove(uuid) == null) {
            throw new NotExistStorageException(uuid);
        }
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
