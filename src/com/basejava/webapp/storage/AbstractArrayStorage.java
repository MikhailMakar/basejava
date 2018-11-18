package com.basejava.webapp.storage;

import com.basejava.webapp.exception.NotExistStorageException;
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
    public void update(Resume r) {
        Object index = getSearchKey(r.getUuid());
        if (checkIndex(index)) {
            storage[((int) index)] = r;
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
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
}
