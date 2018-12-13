package com.basejava.webapp.storage;

import com.basejava.webapp.ResumeTestData;
import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Organization;
import com.basejava.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class AbstractStorageTest {
    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;

    static {
        RESUME_1 = ResumeTestData.receiveResume(UUID_1, "A", "gkislin@yandex.ru", "+7(921) 855-0482", "objective", "personal", "achievement", "qualifications", Arrays.asList(new Organization("name", "url"), new Organization("name", "url")), Arrays.asList(new Organization("name", "url"), new Organization("name", "url")));
        RESUME_2 = ResumeTestData.receiveResume(UUID_2, "B", "gkislin@yandex.ru", "+7(921) 855-0482", "objective", "personal", "achievement", "qualifications", Arrays.asList(new Organization("name", "url"), new Organization("name", "url")), Arrays.asList(new Organization("name", "url"), new Organization("name", "url")));
        RESUME_3 = ResumeTestData.receiveResume(UUID_3, "C", "gkislin@yandex.ru", "+7(921) 855-0482", "objective", "personal", "achievement", "qualifications", Arrays.asList(new Organization("name", "url"), new Organization("name", "url")), Arrays.asList(new Organization("name", "url"), new Organization("name", "url")));
        RESUME_4 = ResumeTestData.receiveResume(UUID_4, "D", "gkislin@yandex.ru", "+7(921) 855-0482", "objective", "personal", "achievement", "qualifications", Arrays.asList(new Organization("name", "url"), new Organization("name", "url")), Arrays.asList(new Organization("name", "url"), new Organization("name", "url")));
    }

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() throws Exception {
        assertSize(3);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() throws Exception {
        Resume newResume = new Resume(UUID_1, "New Name");
        storage.update(newResume);
        assertSame(newResume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> array = storage.getAllSorted();
        assertEquals(3, array.size());
        assertEquals(Arrays.asList(RESUME_1, RESUME_2, RESUME_3), array);
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void get() throws Exception {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}