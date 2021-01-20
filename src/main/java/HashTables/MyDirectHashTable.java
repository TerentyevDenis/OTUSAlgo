package HashTables;

public class MyDirectHashTable<T, M> {
    private static final float LOAD_FACTOR = 0.5f;
    private int initialCapacity;
    private int size;
    private MyEntry<T,M>[] elements;

    public MyDirectHashTable(int initialCapacity){
        this.initialCapacity = initialCapacity;
        this.size = 0;
        this.elements = (MyEntry<T,M>[]) new MyEntry[initialCapacity];
    }

    public MyDirectHashTable(){
        this(11);
    }

    private class MyEntry<T, M> {
        T key;
        M value;
        boolean isRemoved;

        public MyEntry(T key, M value) {
            this.key = key;
            this.value = value;
            isRemoved = false;
        }

        public M remove(){
            isRemoved = true;
            return value;
        }

        public boolean isRemoved(){
            return isRemoved;
        }
    }

    public M get(Object key){
        MyEntry<T, M> last = null;
        int lastDeletedId = -1;
        int attempt = 0;
        int i = prob(key, attempt);
        while (elements[i]!=null){
            if (elements[i].isRemoved) {
                lastDeletedId = i;
            } else {
                last = elements[i];
            }
            i = prob(key, ++attempt);
        }
        if (lastDeletedId != -1){
            elements[lastDeletedId] = elements[i];
        }
        if (last != null){
            return last.value;
        }
        return null;
    }

    public M remove(T key){
        MyEntry<T, M> last = null;
        int attempt = 0;
        int i = prob(key, attempt);
        while (elements[i]!=null){
            if (!elements[i].isRemoved) {
                last = elements[i];
            }
            i = prob(key, ++attempt);
        }
        if (last != null) {
            return last.remove();
        }
        return null;
    }

    public M put(T key, M value){
        if (value == null)
            throw new NullPointerException();
        int attempt = 0;
        int i = prob(key, attempt);
        while (elements[i]!=null
                || elements[i]!=null && (!elements[i].isRemoved || elements[i].key.equals(key))){
            i = prob(key, ++attempt);
        }
        if (elements[i]!=null &&(elements[i].key.equals(key) && !elements[i].isRemoved)){
            M r = elements[i].value;
            elements[i].value = value;
            return r;
         }
        if (!(elements[i]!=null && elements[i].isRemoved)){
            size++;
        }
        elements[i] = new MyEntry<>(key,value);
        if (size > LOAD_FACTOR*elements.length){
            rehash();
        }
        return null;
    }

    private void rehash() {
        MyEntry<T, M>[] oldElements = elements;
        int newcapacity = (elements.length * 2) + 1;
        elements = (MyEntry<T,M>[]) new MyEntry[newcapacity];
        for (int i = oldElements.length - 1; i >= 0; i--){
            if(oldElements[i] != null) {
                if (!oldElements[i].isRemoved) {
                    int attempt = 0;
                    int index = prob(oldElements[i].key, attempt);
                    while (elements[i] != null) {
                        index = prob(oldElements[i].key, ++attempt);
                    }
                    elements[index] = new MyEntry<>(oldElements[i].key, oldElements[i].value);
                }
            }
        }
    }

    private int prob(Object key, int attempt){
        return (hash(key) + attempt*key.hashCode())%elements.length;
    }

    private int hash(Object key) {
        int hash = key.hashCode();
        return hash < 0 ? -hash : hash;
    }
}
