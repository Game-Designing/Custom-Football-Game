package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;

public final class CharsToNameCanonicalizer {
    /* access modifiers changed from: private */
    public Bucket[] _buckets;
    private boolean _canonicalize;
    private final int _flags;
    private boolean _hashShared;
    private int _indexMask;
    /* access modifiers changed from: private */
    public int _longestCollisionList;
    private BitSet _overflows;
    private final CharsToNameCanonicalizer _parent;
    private final int _seed;
    /* access modifiers changed from: private */
    public int _size;
    private int _sizeThreshold;
    /* access modifiers changed from: private */
    public String[] _symbols;
    private final AtomicReference<TableInfo> _tableInfo;

    static final class Bucket {
        public final int length;
        public final Bucket next;
        public final String symbol;

        public Bucket(String s, Bucket n) {
            this.symbol = s;
            this.next = n;
            int i = 1;
            if (n != null) {
                i = 1 + n.length;
            }
            this.length = i;
        }

        public String has(char[] buf, int start, int len) {
            if (this.symbol.length() != len) {
                return null;
            }
            int i = 0;
            while (this.symbol.charAt(i) == buf[start + i]) {
                i++;
                if (i >= len) {
                    return this.symbol;
                }
            }
            return null;
        }
    }

    private static final class TableInfo {
        final Bucket[] buckets;
        final int longestCollisionList;
        final int size;
        final String[] symbols;

        public TableInfo(int size2, int longestCollisionList2, String[] symbols2, Bucket[] buckets2) {
            this.size = size2;
            this.longestCollisionList = longestCollisionList2;
            this.symbols = symbols2;
            this.buckets = buckets2;
        }

        public TableInfo(CharsToNameCanonicalizer src) {
            this.size = src._size;
            this.longestCollisionList = src._longestCollisionList;
            this.symbols = src._symbols;
            this.buckets = src._buckets;
        }

        public static TableInfo createInitial(int sz) {
            return new TableInfo(0, 0, new String[sz], new Bucket[(sz >> 1)]);
        }
    }

    private CharsToNameCanonicalizer(int seed) {
        this._parent = null;
        this._seed = seed;
        this._canonicalize = true;
        this._flags = -1;
        this._hashShared = false;
        this._longestCollisionList = 0;
        this._tableInfo = new AtomicReference<>(TableInfo.createInitial(64));
    }

    private CharsToNameCanonicalizer(CharsToNameCanonicalizer parent, int flags, int seed, TableInfo parentState) {
        this._parent = parent;
        this._seed = seed;
        this._tableInfo = null;
        this._flags = flags;
        this._canonicalize = Feature.CANONICALIZE_FIELD_NAMES.enabledIn(flags);
        this._symbols = parentState.symbols;
        this._buckets = parentState.buckets;
        this._size = parentState.size;
        this._longestCollisionList = parentState.longestCollisionList;
        int arrayLen = this._symbols.length;
        this._sizeThreshold = _thresholdSize(arrayLen);
        this._indexMask = arrayLen - 1;
        this._hashShared = true;
    }

    private static int _thresholdSize(int hashAreaSize) {
        return hashAreaSize - (hashAreaSize >> 2);
    }

    public static CharsToNameCanonicalizer createRoot() {
        long now = System.currentTimeMillis();
        return createRoot((((int) now) + ((int) (now >>> 32))) | 1);
    }

    protected static CharsToNameCanonicalizer createRoot(int seed) {
        return new CharsToNameCanonicalizer(seed);
    }

    public CharsToNameCanonicalizer makeChild(int flags) {
        return new CharsToNameCanonicalizer(this, flags, this._seed, (TableInfo) this._tableInfo.get());
    }

    public void release() {
        if (maybeDirty()) {
            CharsToNameCanonicalizer charsToNameCanonicalizer = this._parent;
            if (charsToNameCanonicalizer != null && this._canonicalize) {
                charsToNameCanonicalizer.mergeChild(new TableInfo(this));
                this._hashShared = true;
            }
        }
    }

    private void mergeChild(TableInfo childState) {
        int childCount = childState.size;
        TableInfo currState = (TableInfo) this._tableInfo.get();
        if (childCount != currState.size) {
            if (childCount > 12000) {
                childState = TableInfo.createInitial(64);
            }
            this._tableInfo.compareAndSet(currState, childState);
        }
    }

    public boolean maybeDirty() {
        return !this._hashShared;
    }

    public int hashSeed() {
        return this._seed;
    }

    public String findSymbol(char[] buffer, int start, int len, int h) {
        if (len < 1) {
            return "";
        }
        if (!this._canonicalize) {
            return new String(buffer, start, len);
        }
        int index = _hashToIndex(h);
        String sym = this._symbols[index];
        if (sym != null) {
            if (sym.length() == len) {
                int i = 0;
                while (sym.charAt(i) == buffer[start + i]) {
                    i++;
                    if (i == len) {
                        return sym;
                    }
                }
            }
            Bucket b = this._buckets[index >> 1];
            if (b != null) {
                String sym2 = b.has(buffer, start, len);
                if (sym2 != null) {
                    return sym2;
                }
                String sym3 = _findSymbol2(buffer, start, len, b.next);
                if (sym3 != null) {
                    return sym3;
                }
                String str = sym3;
                return _addSymbol(buffer, start, len, h, index);
            }
        }
        String str2 = sym;
        return _addSymbol(buffer, start, len, h, index);
    }

    private String _findSymbol2(char[] buffer, int start, int len, Bucket b) {
        while (b != null) {
            String sym = b.has(buffer, start, len);
            if (sym != null) {
                return sym;
            }
            b = b.next;
        }
        return null;
    }

    private String _addSymbol(char[] buffer, int start, int len, int h, int index) {
        if (this._hashShared) {
            copyArrays();
            this._hashShared = false;
        } else if (this._size >= this._sizeThreshold) {
            rehash();
            index = _hashToIndex(calcHash(buffer, start, len));
        }
        String newSymbol = new String(buffer, start, len);
        if (Feature.INTERN_FIELD_NAMES.enabledIn(this._flags)) {
            newSymbol = InternCache.instance.intern(newSymbol);
        }
        this._size++;
        String[] strArr = this._symbols;
        if (strArr[index] == null) {
            strArr[index] = newSymbol;
        } else {
            int bix = index >> 1;
            Bucket newB = new Bucket(newSymbol, this._buckets[bix]);
            int collLen = newB.length;
            if (collLen > 100) {
                _handleSpillOverflow(bix, newB);
            } else {
                this._buckets[bix] = newB;
                this._longestCollisionList = Math.max(collLen, this._longestCollisionList);
            }
        }
        return newSymbol;
    }

    private void _handleSpillOverflow(int bindex, Bucket newBucket) {
        BitSet bitSet = this._overflows;
        if (bitSet == null) {
            this._overflows = new BitSet();
            this._overflows.set(bindex);
        } else if (!bitSet.get(bindex)) {
            this._overflows.set(bindex);
        } else if (!Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(this._flags)) {
            this._canonicalize = false;
        } else {
            reportTooManyCollisions(100);
            throw null;
        }
        this._symbols[bindex + bindex] = newBucket.symbol;
        this._buckets[bindex] = null;
        this._size -= newBucket.length;
        this._longestCollisionList = -1;
    }

    public int _hashToIndex(int rawHash) {
        int rawHash2 = rawHash + (rawHash >>> 15);
        int rawHash3 = rawHash2 ^ (rawHash2 << 7);
        return this._indexMask & (rawHash3 + (rawHash3 >>> 3));
    }

    public int calcHash(char[] buffer, int start, int len) {
        int hash = this._seed;
        for (int i = start; i < start + len; i++) {
            hash = (hash * 33) + buffer[i];
        }
        if (hash == 0) {
            return 1;
        }
        return hash;
    }

    public int calcHash(String key) {
        int len = key.length();
        int hash = this._seed;
        for (int i = 0; i < len; i++) {
            hash = (hash * 33) + key.charAt(i);
        }
        if (hash == 0) {
            return 1;
        }
        return hash;
    }

    private void copyArrays() {
        String[] oldSyms = this._symbols;
        this._symbols = (String[]) Arrays.copyOf(oldSyms, oldSyms.length);
        Bucket[] oldBuckets = this._buckets;
        this._buckets = (Bucket[]) Arrays.copyOf(oldBuckets, oldBuckets.length);
    }

    private void rehash() {
        int size = this._symbols.length;
        int newSize = size + size;
        if (newSize > 65536) {
            this._size = 0;
            this._canonicalize = false;
            this._symbols = new String[64];
            this._buckets = new Bucket[32];
            this._indexMask = 63;
            this._hashShared = false;
            return;
        }
        String[] oldSyms = this._symbols;
        Bucket[] oldBuckets = this._buckets;
        this._symbols = new String[newSize];
        this._buckets = new Bucket[(newSize >> 1)];
        this._indexMask = newSize - 1;
        this._sizeThreshold = _thresholdSize(newSize);
        int count = 0;
        int maxColl = 0;
        for (int i = 0; i < size; i++) {
            String symbol = oldSyms[i];
            if (symbol != null) {
                count++;
                int index = _hashToIndex(calcHash(symbol));
                String[] strArr = this._symbols;
                if (strArr[index] == null) {
                    strArr[index] = symbol;
                } else {
                    int bix = index >> 1;
                    Bucket newB = new Bucket(symbol, this._buckets[bix]);
                    this._buckets[bix] = newB;
                    maxColl = Math.max(maxColl, newB.length);
                }
            }
        }
        int size2 = size >> 1;
        for (int i2 = 0; i2 < size2; i2++) {
            for (Bucket b = oldBuckets[i2]; b != null; b = b.next) {
                count++;
                String symbol2 = b.symbol;
                int index2 = _hashToIndex(calcHash(symbol2));
                String[] strArr2 = this._symbols;
                if (strArr2[index2] == null) {
                    strArr2[index2] = symbol2;
                } else {
                    int bix2 = index2 >> 1;
                    Bucket newB2 = new Bucket(symbol2, this._buckets[bix2]);
                    this._buckets[bix2] = newB2;
                    maxColl = Math.max(maxColl, newB2.length);
                }
            }
        }
        this._longestCollisionList = maxColl;
        this._overflows = null;
        int i3 = this._size;
        if (count != i3) {
            throw new IllegalStateException(String.format("Internal error on SymbolTable.rehash(): had %d entries; now have %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(count)}));
        }
    }

    /* access modifiers changed from: protected */
    public void reportTooManyCollisions(int maxLen) {
        StringBuilder sb = new StringBuilder();
        sb.append("Longest collision chain in symbol table (of size ");
        sb.append(this._size);
        sb.append(") now exceeds maximum, ");
        sb.append(maxLen);
        sb.append(" -- suspect a DoS attack based on hash collisions");
        throw new IllegalStateException(sb.toString());
    }
}
