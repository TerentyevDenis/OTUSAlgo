package HashTables;

public class MyHashTable<T, M> {
    private static final float LOAD_FACTOR = 0.75f;
    private int initialCapacity;
    private int size;

    public MyHashTable(int initialCapacity){
        this.initialCapacity = initialCapacity;
        buckets = (MyEntry<T, M>[])  new MyEntry[initialCapacity];
    }

    public MyHashTable(){
        this(11);
    }

    MyEntry<T, M>[] buckets;

    private class MyEntry<T, M> {
         T key;
         M value;
         MyEntry<T, M> next;

        public MyEntry(T key, M value, MyEntry<T, M> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public M get(Object key) {
     int idx = hash(key);
     MyEntry<T, M> elem = buckets[idx];
     while (elem != null)
       {
         if (elem.key.equals(key)) {
             return elem.value;
         }
         elem = elem.next;
       }
     return null;
   }

    public M put(T key, M value)
    {
        if (value == null)
            throw new NullPointerException();
        int idx = hash(key);
        MyEntry<T, M> elem = buckets[idx];
        while (elem != null)
        {
            if (elem.key.equals(key))
            {
                M r = elem.value;
                elem.value = value;
                return r;
            }
            else {
                elem = elem.next;
            }
        }
        if (++size > LOAD_FACTOR*buckets.length){
            rehash();
            idx = hash(key);
        }
        elem = new MyEntry<T, M>(key, value,buckets[idx]);
        buckets[idx] = elem;
         return null;
    }

    public synchronized M remove(Object key) {
        int idx = hash(key);
        MyEntry<T, M> elem = buckets[idx] == null? null:buckets[idx];
        MyEntry<T, M> last = null;
        while (elem != null) {
            if (elem.key.equals(key)) {
                if (last == null)
                    buckets[idx] = elem.next;
                else
                    last.next = elem.next;
                size--;
                return elem.value;
            }
            last = elem;
            elem = elem.next;
        }
        return null;
    }

    private void rehash() {
        MyEntry<T, M>[] oldBuckets = buckets;
        int newcapacity = (buckets.length * 2) + 1;
        buckets = (MyEntry<T, M>[])  new MyEntry[newcapacity];

        for (int i = oldBuckets.length - 1; i >= 0; i--) {
            MyEntry<T, M> elem = oldBuckets[i];
            while (elem != null) {
                int idx = hash(elem.key);
                MyEntry<T, M> dest = buckets[idx];
                if (dest != null) {
                    MyEntry next = dest.next;
                    while (next != null) {
                        dest = next;
                        next = dest.next;
                    }
                    dest.next = elem;
                } else {
                    buckets[idx] = elem;
                }
                MyEntry<T, M> next = elem.next;
                elem.next = null;
                elem = next;
            }
        }
    }

    private int hash(Object key) {
        int hash = key.hashCode()%buckets.length;
        return hash < 0 ? -hash : hash;
    }
}
