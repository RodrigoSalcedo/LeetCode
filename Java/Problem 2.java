public class LRUCache {

    private final int capacidad;
    private final HashMap<Integer, Integer> cache;
    private final LinkedList<Integer> ordenDeUso;

    public LRUCache(int capacity) {
        this.capacidad = capacity;
        this.cache = new HashMap<>();
        this.ordenDeUso = new LinkedList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        ordenDeUso.remove((Integer) key);
        ordenDeUso.addFirst(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ordenDeUso.remove((Integer) key);
        } else if (cache.size() == capacidad) {
            int LRU = ordenDeUso.removeLast();
            cache.remove(LRU);
        }
        ordenDeUso.addFirst(key);
        cache.put(key, value);
    }

}