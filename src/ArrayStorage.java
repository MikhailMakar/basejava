/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];
    int count = 0;

    void clear() {
        for (int i = 0; i < count; i++){
            storage[i] = null;
        }
        count = 0;
    }

    void save(Resume r) {
        storage[count] = r;
        count++;
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
        for(int i = 0; i < count; i++){
            if (storage[i].uuid.equals(uuid)){
                count--;
                while (i < count){
                    storage[i] = storage[i+1];
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
