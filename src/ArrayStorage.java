/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear(){
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        if (size >= 0 && size <= storage.length){
            storage[size] = r;
            size++;
            for (int i = 0; i < size - 1; i++){
                if (storage[i].getUuid().equals(r.getUuid())){
                    storage[size] = null;
                    System.out.println("Resume already exists!");
                    size--;
                }
            }
        } else System.out.println("Storage is over!");
    }

    public void update(Resume r) {
        if (checkResumeInStorage(r.getUuid())) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(r.getUuid())) {
                    storage[i] = new Resume();
                    storage[i].setUuid(r.getUuid() + "updated");
                }
            }
        } else System.out.println("Resume aren't exist in the storage!");
    }

    public Resume get(String uuid) {
        if (checkResumeInStorage(uuid)) {
            for (Resume aStorage : storage) {
                if (aStorage != null && aStorage.getUuid().equals(uuid)) {
                    return aStorage;
                }
            }
        } else System.out.println("Resume aren't exist in the storage!");
        return null;
    }

    public void delete(String uuid) {
        if (checkResumeInStorage(uuid)) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                }
            }
        } else System.out.println("Resume aren't exist in the storage!");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] getAllResume = new Resume[size];
        System.arraycopy(storage, 0, getAllResume, 0, getAllResume.length);
        return getAllResume;
    }

    public int size() {
        return size;
    }

    private boolean checkResumeInStorage(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return true;
            }
        }
        return false;
    }
}
