package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size < STORAGE_LIMIT) {
            if (getIndex(r.getUuid()) >= 0) {
                System.out.println("Resume is already exist!");
            } else {
                storage[size] = r;
                size++;
            }
        } else {
            System.out.println("Storage is over!");
        }
    }

    public void update(Resume r) {
        int position = getIndex(r.getUuid());
        if (position >= 0) {
            storage[position] = r;
        } else {
            System.out.println("Resume aren't exist in the storage!");
        }
    }

    public void delete(String uuid) {
        int position = getIndex(uuid);
        if (position >= 0) {
            storage[position] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Resume aren't exist in the storage!");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
