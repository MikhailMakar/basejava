package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> listResume = new ArrayList<>();

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < listResume.size(); i++) {
            if (uuid.equals(listResume.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected Resume doGet(int index) {
        return listResume.get(index);
    }

    @Override
    protected boolean checkIndex(int index) {
        return index < 0;
    }

    @Override
    protected void fillDeletedElement(int index) {
        listResume.remove(index);
    }

    @Override
    protected void insertElement(Resume r, int index) {
        listResume.add(index, r);
    }

    @Override
    public void clear() {
        listResume.clear();
    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) listResume.toArray();
    }

    @Override
    public int size() {
        return listResume.size();
    }
}
