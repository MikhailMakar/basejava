package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void deleteElementFromStorage(int index) {
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected void saveElement(Resume r) {
        if (getIndex(r.getUuid()) >= 0) {
            System.out.println("Resume is already exist!");
        } else {
            storage[size] = r;
            size++;
        }
    }
}
