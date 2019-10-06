package p005cm.aptoide.p006pt.dataprovider.cache;

/* renamed from: cm.aptoide.pt.dataprovider.cache.StringBaseCache */
abstract class StringBaseCache<K, V> extends BaseCache<K, V, String> {
    /* access modifiers changed from: 0000 */
    public abstract boolean contains(String str);

    /* access modifiers changed from: 0000 */
    public abstract V get(String str, K k);

    /* access modifiers changed from: 0000 */
    public abstract boolean isValid(String str);

    /* access modifiers changed from: 0000 */
    public abstract void put(String str, V v);

    /* access modifiers changed from: 0000 */
    public abstract void remove(String str);

    StringBaseCache(KeyAlgorithm<K, String> keyAlgorithm) {
        super(keyAlgorithm);
    }

    public void put(K key, V value) {
        KeyAlgorithm<K, Tout> keyAlgorithm = this.keyAlgorithm;
        if (keyAlgorithm != null) {
            put((String) keyAlgorithm.getKeyFrom(key), value);
            return;
        }
        throw new UnsupportedOperationException("Initialize cache using init() first");
    }

    public V get(K key) {
        if (this.keyAlgorithm == null) {
            throw new UnsupportedOperationException("Initialize cache using init() first");
        } else if (isValid(key)) {
            return get((String) this.keyAlgorithm.getKeyFrom(key), key);
        } else {
            return null;
        }
    }

    public void remove(K key) {
        KeyAlgorithm<K, Tout> keyAlgorithm = this.keyAlgorithm;
        if (keyAlgorithm != null) {
            remove((String) keyAlgorithm.getKeyFrom(key));
            return;
        }
        throw new UnsupportedOperationException("Initialize cache using init() first");
    }

    public boolean contains(K key) {
        KeyAlgorithm<K, Tout> keyAlgorithm = this.keyAlgorithm;
        if (keyAlgorithm != null) {
            return contains((String) keyAlgorithm.getKeyFrom(key));
        }
        throw new UnsupportedOperationException("Initialize cache using init() first");
    }

    public boolean isValid(K key) {
        KeyAlgorithm<K, Tout> keyAlgorithm = this.keyAlgorithm;
        if (keyAlgorithm != null) {
            String keyAsString = (String) keyAlgorithm.getKeyFrom(key);
            return contains(keyAsString) && isValid(keyAsString);
        }
        throw new UnsupportedOperationException("Initialize cache using init() first");
    }
}
