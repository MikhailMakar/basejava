package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected boolean checkIndex(Object index) {
        return ((int) index) >= 0;
    }

    @Override
    protected Resume doGet(Object index) {
        return storage[(int) index];
    }

    @Override
    protected void updateElement(Resume r, Object index) {
        storage[((int) index)] = r;
    }

    @Override
    protected void decreaseQuantity() {
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected void checkStorage(Resume r) {
        if (!(size < STORAGE_LIMIT)) {
            throw new StorageException("Storage overflow", r.getUuid());
        }
    }

    @Override
    protected void increaseQuantity() {
        size++;
    }
}
