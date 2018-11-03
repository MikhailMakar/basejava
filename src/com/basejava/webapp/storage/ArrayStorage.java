package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage implements Storage {

    private static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size < STORAGE_LIMIT) {
            if (positionResumeInStorage(r.getUuid()) >= 0) {
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
        int position = positionResumeInStorage(r.getUuid());
        if (position >= 0) {
            storage[position] = r;
        } else {
            System.out.println("Resume aren't exist in the storage!");
        }
    }

    public Resume get(String uuid) {
        int position = positionResumeInStorage(uuid);
        if (position >= 0) {
            return storage[position];
        } else {
            System.out.println("Resume aren't exist in the storage!");
            return null;
        }
    }

    public void delete(String uuid) {
        int position = positionResumeInStorage(uuid);
        if (position >= 0) {
            storage[position] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Resume aren't exist in the storage!");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int positionResumeInStorage(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
