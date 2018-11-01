/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume r) {
        if (size >= 0 && size <= storage.length) {
            if (checkResumeInStorage(r.getUuid()) >= 0) {
                System.out.println("Resume is already exist!");
            } else {
                storage[size] = r;
                size++;
            }
        } else System.out.println("Storage is over!");
    }

    public void update(Resume r) {
        if (checkResumeInStorage(r.getUuid()) >= 0) {
            storage[checkResumeInStorage(r.getUuid())] = r;
            System.out.println("Resume " + r.getUuid() + " updated!");
        } else System.out.println("Resume aren't exist in the storage!");
    }

    public Resume get(String uuid) {
        if (checkResumeInStorage(uuid) >= 0) {
            return storage[checkResumeInStorage(uuid)];
        } else System.out.println("Resume aren't exist in the storage!");
        return null;
    }

    public void delete(String uuid) {
        if (checkResumeInStorage(uuid) >= 0) {
            storage[checkResumeInStorage(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else System.out.println("Resume aren't exist in the storage!");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] getAllResume = new Resume[size];
        System.arraycopy(storage, 0, getAllResume, 0, size);
        return getAllResume;
    }

    public int size() {
        return size;
    }

    private int checkResumeInStorage(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
