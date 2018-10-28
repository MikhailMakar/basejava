/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++){
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++){
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {

        Resume getResume = null;

        for (Resume aStorage : storage){
            getResume = aStorage;
            if (getResume != null && getResume.uuid.equals(uuid)) {
                getResume = aStorage;
                break;
            }
        }

        return getResume;
    }

    void delete(String uuid) {
        for(int i = 0; i < storage.length; i++){
            if (storage[i] != null && storage[i].uuid.equals(uuid)){
                storage[i] = null;
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

        Resume[] getAllResume = new Resume[size()];

        System.arraycopy(storage, 0, getAllResume, 0, getAllResume.length);

        return getAllResume;
    }

    int size() {

        int count = 0;

        for (Resume sizeStorage: storage){
            if (sizeStorage != null) count++;
        }

        return count;
    }
}
