package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.HashMap;

public class MapStorage extends AbstractStorage {

    private HashMap<String, Resume> mapResume = new HashMap<>();
    private int mapSize = mapResume.size();

    @Override
    public void clear() {
        mapResume.clear();
    }

    @Override
    public void update(Resume r) {
        if (r != null && r.getUuid() != null) {
            if (mapResume.put(r.getUuid(), r) == null && mapSize > 1) {
                throw new NotExistStorageException(r.getUuid());
            }
        } else {
            throw new NullPointerException("Key or Value equal null!");
        }
    }

    @Override
    public void save(Resume r) {
        String id = r.getUuid();
        if (mapSize < STORAGE_LIMIT) {
            if (id != null) {
                for (String uuid : mapResume.keySet()) {
                    if (id.equals(uuid)) {
                        throw new ExistStorageException(id);
                    }
                }
                mapResume.put(id, r);
            } else {
                throw new NullPointerException("Key equals null!");
            }
        } else {
            throw new StorageException("Storage overflow", id);
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
        for (String id : mapResume.keySet()) {
            if (uuid.equals(id)) {
                mapResume.remove(uuid);
            } else {
                throw new NotExistStorageException(uuid);
            }
        }
    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) mapResume.values().toArray();
    }

    @Override
    public int size() {
        return mapSize;
    }
}
