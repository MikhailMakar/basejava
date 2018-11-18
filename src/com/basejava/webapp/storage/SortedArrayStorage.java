package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected Object getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void fillDeletedElement(Object index) {
        System.arraycopy(storage, ((int) index) + 1, storage, (int) index, size - ((int) index) - 1);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected void insertElement(Resume r, Object index) {
        if (size < STORAGE_LIMIT) {
            int insertionIndex = -(((int) index) + 1);
            System.arraycopy(storage, insertionIndex, storage, insertionIndex + 1, size - insertionIndex);
            storage[insertionIndex] = r;
            size++;
        } else {
            throw new StorageException("Storage overflow", r.getUuid());
        }
    }
}
