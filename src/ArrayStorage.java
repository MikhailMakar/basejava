/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];
    int count = 0;

    void clear() {
        for (int i = 0; i < storage.length; i++){
            storage[i] = null;
        }
        count = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++){
            if (storage[i] == null) {
                storage[i] = r;
                count++;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume aStorage : storage){
            if (aStorage != null && aStorage.uuid.equals(uuid)) {
                return aStorage;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for(int i = 0; i < storage.length; i++){
            if (storage[i] != null && storage[i].uuid.equals(uuid)){
                storage[i] = null;
                count--;
                while (storage[i] == null && storage[i+1] != null && i <= storage.length - 1){
                    storage[i] = storage[i+1];
                    storage[i+1] = null;
                    i++;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] getAllResume = new Resume[count];
        System.arraycopy(storage, 0, getAllResume, 0, getAllResume.length);
        return getAllResume;
    }

    int size() {
        return count;
    }
}
