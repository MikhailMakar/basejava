package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractArrayStorageTest {

    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        Resume resume = new Resume(UUID_1);
        storage.update(resume);
        Assert.assertEquals(resume, storage.get("uuid1"));
    }

    @Test
    public void save() throws Exception {
        if (storage.size() < AbstractArrayStorage.STORAGE_LIMIT) {
            Resume resume = new Resume("uuid4");
            storage.save(resume);
            Assert.assertEquals(resume, storage.get("uuid4"));
            Assert.assertEquals(4, storage.size());
        }
    }

    @Test
    public void get() throws Exception {
        Resume resume = new Resume("uuid1");
        Assert.assertEquals(resume, storage.get("uuid1"));
    }

    @Test
    public void delete() throws Exception {
        storage.delete("uuid1");
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void getAll() throws Exception {
        Resume[] resumes = new Resume[3];
        resumes[0] = new Resume("uuid1");
        resumes[1] = new Resume("uuid2");
        resumes[2] = new Resume("uuid3");
        Assert.assertEquals(resumes, storage.getAll());
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(new Resume("dummy"));
    }

    @Test(expected = StorageException.class)
    public void saveInOverFlowStorage() throws Exception {
        try {
            storage.save(new Resume("uuid4"));
            Assert.fail("There is no mistake, just storage is not over!");
        } catch (StorageException e) {
            if (storage.size() < AbstractArrayStorage.STORAGE_LIMIT){
                Assert.fail("There is no mistake, just storage is not over!");
            } else {
                throw e;
            }
        }
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        if (storage.size() < AbstractArrayStorage.STORAGE_LIMIT) {
            storage.save(new Resume(UUID_1));
        } else {
            throw new ExistStorageException("Our storage is over");
        }
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }
}