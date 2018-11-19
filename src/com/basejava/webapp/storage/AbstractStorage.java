package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getSearchKey(String uuid);

    protected abstract Resume doGet(Object index);

    protected abstract boolean checkIndex(Object index);

    protected abstract void updateElement(Resume r, Object index);

    protected abstract void doSave(Resume r, Object index);

    protected abstract void doDelete(Object index);

    @Override
    public void update(Resume r) {
        String id = r.getUuid();
        Object index = getSearchKey(id);
        if (!checkIndex(index)) {
            throw new NotExistStorageException(id);
        } else {
            updateElement(r, index);
        }
    }

    @Override
    public void save(Resume r) {
        String id = r.getUuid();
        Object index = getSearchKey(id);
        if (!checkIndex(index)) {
            doSave(r, index);
        } else {
            throw new ExistStorageException(id);
        }
    }

    @Override
    public Resume get(String uuid) {
        Object index = getSearchKey(uuid);
        if (!checkIndex(index)) {
            throw new NotExistStorageException(uuid);
        } else {
            return doGet(index);
        }
    }

    @Override
    public void delete(String uuid) {
        Object index = getSearchKey(uuid);
        if (!checkIndex(index)) {
            throw new NotExistStorageException(uuid);
        } else {
            doDelete(index);
        }
    }
}
