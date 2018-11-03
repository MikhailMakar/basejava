package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            storage[index] = r;
            sortStorage(storage);
        } else {
            System.out.println("Resume aren't exist in the storage!");
        }
    }

    @Override
    public void save(Resume r) {
        if (size < STORAGE_LIMIT) {
            if (getIndex(r.getUuid()) >= 0) {
                System.out.println("Resume is already exist!");
            } else {
                storage[size] = r;
                size++;
                sortStorage(storage);
            }
        } else {
            System.out.println("Storage is over!");
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            while (storage[index] != null){
                storage[index] = storage[index + 1];
                index++;
            }
            size--;
        } else {
            System.out.println("Resume aren't exist in the storage!");
        }
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    private void sortStorage(Resume[] resumes){
        for (int i = size - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (resumes[j].compareTo(resumes[j+1]) > 0){
                    Resume resume = resumes[j];
                    resumes[j] = resumes[j+1];
                    resumes[j+1] = resume;
                }
            }
        }
    }
}
