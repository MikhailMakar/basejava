package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public class ListStorage extends AbstractStorage {

    @Override
    public void clear() {
        listResume.clear();
    }

    @Override
    public void update(Resume r) {
        int index = getInformationForList(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            listResume.add(index, r);
        }
    }

    @Override
    public void save(Resume r) {
        String id = r.getUuid();
        int index = getInformationForList(r.getUuid());
        if (index < 0) {
            listResume.add(index, r);
        } else {
            throw new ExistStorageException(id);
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = getInformationForList(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            return listResume.get(index);
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getInformationForList(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            listResume.remove(index);
        }
    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) listResume.toArray();
    }

    @Override
    public int size() {
        return listResume.size();
    }
}
