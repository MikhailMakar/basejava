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
    protected void deleteElement(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    @Override
    protected void saveElement(Resume r, int index) {
        int insertionIndex = -(index + 1);
        System.arraycopy(storage, insertionIndex, storage, insertionIndex + 1, size - insertionIndex);
        storage[insertionIndex] = r;
    }
}
