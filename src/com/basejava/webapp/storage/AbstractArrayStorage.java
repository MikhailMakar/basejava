package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
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
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (checkIndex(index)) {
            storage[index] = r;
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (size < STORAGE_LIMIT) {
            if (checkIndex(index)) {
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
        if (!checkIndex(index)) {
            throw new NotExistStorageException(uuid);
        }
        return doGet(index);
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (checkIndex(index)) {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        } else {
            throw new NotExistStorageException(uuid);
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
    protected boolean checkIndex(int index) {
        return index >= 0;
    }

    @Override
    protected Resume doGet(int index) {
        return storage[index];
    }
}
