package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void fillDeletedElement(Object index) {
        storage[(int) index] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected void insertElement(Resume r, Object index) {
        if (checkIndex(index)) {
            storage[((int) index)] = r;
        } else {
            saveElement(r, index);
        }
    }

    @Override
    protected void saveElement(Resume r, Object index) {
        if (size < STORAGE_LIMIT) {
            storage[size] = r;
            size++;
        } else {
            throw new StorageException("Storage overflow", r.getUuid());
        }
    }
}
