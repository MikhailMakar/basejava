package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.LinkedList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> listResume = new LinkedList<>();
    private int listSize = listResume.size();

    @Override
    public void clear() {
        listResume.clear();
    }

    @Override
    public void update(Resume r) {
        boolean flag = false;
        if (r != null) {
            for (Resume resume : listResume) {
                flag = r.getUuid().equals(resume.getUuid());
                if (flag) {
                    int index = listResume.indexOf(resume);
                    listResume.add(index, r);
                }
            }
            if (!flag) {
                throw new NotExistStorageException(r.getUuid());
            }
        } else {
            throw new NullPointerException("Object is null");
        }
    }

    @Override
    public void save(Resume r) {
        String id = r.getUuid();
        if (listSize < STORAGE_LIMIT) {
            if (id != null) {
                for (Resume resume : listResume) {
                    if (id.equals(resume.getUuid())) {
                        throw new ExistStorageException(id);
                    }
                }
                listResume.add(r);
            } else {
                throw new NullPointerException("uuid is null!");
            }
        } else {
            throw new StorageException("Storage overflow", id);
        }

    }

    @Override
    public Resume get(String uuid) {
        for (Resume resume : listResume) {
            if (uuid.equals(resume.getUuid())) {
                int index = listResume.indexOf(resume);
                return listResume.get(index);
            }
        }
        throw new NotExistStorageException(uuid);
    }

    @Override
    public void delete(String uuid) {
        boolean flag = false;
        for (Resume resume : listResume) {
            flag = uuid.equals(resume.getUuid());
            if (flag) {
                int index = listResume.indexOf(resume);
                listResume.remove(index);
            }
        }
        if (!flag) {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) listResume.toArray();
    }

    @Override
    public int size() {
        return listSize;
    }
}
