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
        String id = r.getUuid();
        int index = getListIndex(id);
        if (index < 0) {
            throw new NotExistStorageException(id);
        } else {
            listResume.add(index, r);
        }
    }

    @Override
    public void save(Resume r) {
        String id = r.getUuid();
        int index = getListIndex(id);
        if (index < 0) {
            listResume.add(index, r);
        } else {
            throw new ExistStorageException(id);
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = getListIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            return listResume.get(index);
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getListIndex(uuid);
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

    private int getListIndex(String uuid){
        for (int i = 0; i < listResume.size(); i++) {
            if (uuid.equals(listResume.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
