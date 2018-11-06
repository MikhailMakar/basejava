package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void deleteElementFromStorage(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - 1);
        size--;
    }

    @Override
    protected void saveElement(Resume r) {
        if (getIndex(r.getUuid()) >= 0) {
            System.out.println("Resume is already exist!");
        } else {
            int index = -(getIndex(r.getUuid()) + 1);
            System.arraycopy(storage, index, storage, index + 1, size + 1);
            storage[index] = r;
            size++;
        }
    }
}
