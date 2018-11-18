package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract int getIndex(String uuid);

    protected abstract Resume doGet(int index);

    protected abstract boolean checkIndex(int index);

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);

    @Override
    public void update(Resume r) {
        String id = r.getUuid();
        int index = getIndex(id);
        if (checkIndex(index)) {
            throw new NotExistStorageException(id);
        } else {
            insertElement(r, index);
        }
    }

    @Override
    public void save(Resume r) {
        String id = r.getUuid();
        int index = getIndex(id);
        if (checkIndex(index)) {
            insertElement(r, index);
        } else {
            throw new ExistStorageException(id);
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (checkIndex(index)) {
            throw new NotExistStorageException(uuid);
        } else {
            return doGet(index);
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (checkIndex(index)) {
            throw new NotExistStorageException(uuid);
        } else {
            fillDeletedElement(index);
        }
    }
}
