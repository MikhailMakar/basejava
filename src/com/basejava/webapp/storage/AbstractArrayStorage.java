package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected abstract int getIndex(String uuid);

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            storage[index] = r;
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (size < STORAGE_LIMIT) {
            if (index >= 0) {
                throw new ExistStorageException(r.getUuid());
            } else {
                insertElement(r, index);
                size++;
            }
        } else {
            throw new StorageException("Storage overflow", r.getUuid());
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }
}
