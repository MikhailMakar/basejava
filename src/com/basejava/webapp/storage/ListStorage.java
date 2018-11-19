package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> listResume = new ArrayList<>();

    @Override
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < listResume.size(); i++) {
            if (uuid.equals(listResume.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected Resume doGet(Object index) {
        return listResume.get((int) index);
    }

    @Override
    protected boolean checkIndex(Object index) {
        return ((int) index) >= 0;
    }

    @Override
    protected void fillDeletedElement(Object index) {
        listResume.remove(((int) index));
    }

    @Override
    protected void insertElement(Resume r, Object index) {
        listResume.add(r);
    }

    @Override
    protected void updateElement(Resume r, Object index) {
        listResume.add(((int) index), r);
    }

    @Override
    protected void decreaseQuantity() {
    }

    @Override
    protected void increaseQuantity() {

    }

    @Override
    protected void checkStorage(Resume r) {
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
