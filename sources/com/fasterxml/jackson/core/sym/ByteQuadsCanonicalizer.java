package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class ByteQuadsCanonicalizer {
    /* access modifiers changed from: private */
    public int _count;
    private final boolean _failOnDoS;
    /* access modifiers changed from: private */
    public int[] _hashArea;
    private boolean _hashShared;
    /* access modifiers changed from: private */
    public int _hashSize;
    private boolean _intern;
    /* access modifiers changed from: private */
    public int _longNameOffset;
    /* access modifiers changed from: private */
    public String[] _names;
    private transient boolean _needRehash;
    private final ByteQuadsCanonicalizer _parent;
    private int _secondaryStart;
    private final int _seed;
    /* access modifiers changed from: private */
    public int _spilloverEnd;
    private final AtomicReference<TableInfo> _tableInfo;
    /* access modifiers changed from: private */
    public int _tertiaryShift;
    private int _tertiaryStart;

    private static final class TableInfo {
        public final int count;
        public final int longNameOffset;
        public final int[] mainHash;
        public final String[] names;
        public final int size;
        public final int spilloverEnd;
        public final int tertiaryShift;

        public TableInfo(int size2, int count2, int tertiaryShift2, int[] mainHash2, String[] names2, int spilloverEnd2, int longNameOffset2) {
            this.size = size2;
            this.count = count2;
            this.tertiaryShift = tertiaryShift2;
            this.mainHash = mainHash2;
            this.names = names2;
            this.spilloverEnd = spilloverEnd2;
            this.longNameOffset = longNameOffset2;
        }

        public TableInfo(ByteQuadsCanonicalizer src) {
            this.size = src._hashSize;
            this.count = src._count;
            this.tertiaryShift = src._tertiaryShift;
            this.mainHash = src._hashArea;
            this.names = src._names;
            this.spilloverEnd = src._spilloverEnd;
            this.longNameOffset = src._longNameOffset;
        }

        public static TableInfo createInitial(int sz) {
            int hashAreaSize = sz << 3;
            TableInfo tableInfo = new TableInfo(sz, 0, ByteQuadsCanonicalizer._calcTertiaryShift(sz), new int[hashAreaSize], new String[(sz << 1)], hashAreaSize - sz, hashAreaSize);
            return tableInfo;
        }
    }

    private ByteQuadsCanonicalizer(int sz, boolean intern, int seed, boolean failOnDoS) {
        this._parent = null;
        this._seed = seed;
        this._intern = intern;
        this._failOnDoS = failOnDoS;
        if (sz < 16) {
            sz = 16;
        } else if (((sz - 1) & sz) != 0) {
            int curr = 16;
            while (curr < sz) {
                curr += curr;
            }
            sz = curr;
        }
        this._tableInfo = new AtomicReference<>(TableInfo.createInitial(sz));
    }

    private ByteQuadsCanonicalizer(ByteQuadsCanonicalizer parent, boolean intern, int seed, boolean failOnDoS, TableInfo state) {
        this._parent = parent;
        this._seed = seed;
        this._intern = intern;
        this._failOnDoS = failOnDoS;
        this._tableInfo = null;
        this._count = state.count;
        this._hashSize = state.size;
        this._secondaryStart = this._hashSize << 2;
        int i = this._secondaryStart;
        this._tertiaryStart = i + (i >> 1);
        this._tertiaryShift = state.tertiaryShift;
        this._hashArea = state.mainHash;
        this._names = state.names;
        this._spilloverEnd = state.spilloverEnd;
        this._longNameOffset = state.longNameOffset;
        this._needRehash = false;
        this._hashShared = true;
    }

    public static ByteQuadsCanonicalizer createRoot() {
        long now = System.currentTimeMillis();
        return createRoot((((int) now) + ((int) (now >>> 32))) | 1);
    }

    protected static ByteQuadsCanonicalizer createRoot(int seed) {
        return new ByteQuadsCanonicalizer(64, true, seed, true);
    }

    public ByteQuadsCanonicalizer makeChild(int flags) {
        ByteQuadsCanonicalizer byteQuadsCanonicalizer = new ByteQuadsCanonicalizer(this, Feature.INTERN_FIELD_NAMES.enabledIn(flags), this._seed, Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(flags), (TableInfo) this._tableInfo.get());
        return byteQuadsCanonicalizer;
    }

    public void release() {
        if (this._parent != null && maybeDirty()) {
            this._parent.mergeChild(new TableInfo(this));
            this._hashShared = true;
        }
    }

    private void mergeChild(TableInfo childState) {
        int childCount = childState.count;
        TableInfo currState = (TableInfo) this._tableInfo.get();
        if (childCount != currState.count) {
            if (childCount > 6000) {
                childState = TableInfo.createInitial(64);
            }
            this._tableInfo.compareAndSet(currState, childState);
        }
    }

    public boolean maybeDirty() {
        return !this._hashShared;
    }

    public int primaryCount() {
        int count = 0;
        int end = this._secondaryStart;
        for (int offset = 3; offset < end; offset += 4) {
            if (this._hashArea[offset] != 0) {
                count++;
            }
        }
        return count;
    }

    public int secondaryCount() {
        int count = 0;
        int end = this._tertiaryStart;
        for (int offset = this._secondaryStart + 3; offset < end; offset += 4) {
            if (this._hashArea[offset] != 0) {
                count++;
            }
        }
        return count;
    }

    public int tertiaryCount() {
        int count = 0;
        int offset = this._tertiaryStart + 3;
        int end = this._hashSize + offset;
        while (offset < end) {
            if (this._hashArea[offset] != 0) {
                count++;
            }
            offset += 4;
        }
        return count;
    }

    public int spilloverCount() {
        return (this._spilloverEnd - _spilloverStart()) >> 2;
    }

    public int totalCount() {
        int count = 0;
        int end = this._hashSize << 3;
        for (int offset = 3; offset < end; offset += 4) {
            if (this._hashArea[offset] != 0) {
                count++;
            }
        }
        return count;
    }

    public String toString() {
        int pri = primaryCount();
        int sec = secondaryCount();
        int tert = tertiaryCount();
        int spill = spilloverCount();
        return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", new Object[]{getClass().getName(), Integer.valueOf(this._count), Integer.valueOf(this._hashSize), Integer.valueOf(pri), Integer.valueOf(sec), Integer.valueOf(tert), Integer.valueOf(spill), Integer.valueOf(pri + sec + tert + spill), Integer.valueOf(totalCount())});
    }

    public String findName(int q1) {
        int offset = _calcOffset(calcHash(q1));
        int[] hashArea = this._hashArea;
        int len = hashArea[offset + 3];
        if (len == 1) {
            if (hashArea[offset] == q1) {
                return this._names[offset >> 2];
            }
        } else if (len == 0) {
            return null;
        }
        int offset2 = this._secondaryStart + ((offset >> 3) << 2);
        int len2 = hashArea[offset2 + 3];
        if (len2 == 1) {
            if (hashArea[offset2] == q1) {
                return this._names[offset2 >> 2];
            }
        } else if (len2 == 0) {
            return null;
        }
        return _findSecondary(offset, q1);
    }

    public String findName(int q1, int q2) {
        int offset = _calcOffset(calcHash(q1, q2));
        int[] hashArea = this._hashArea;
        int len = hashArea[offset + 3];
        if (len == 2) {
            if (q1 == hashArea[offset] && q2 == hashArea[offset + 1]) {
                return this._names[offset >> 2];
            }
        } else if (len == 0) {
            return null;
        }
        int offset2 = this._secondaryStart + ((offset >> 3) << 2);
        int len2 = hashArea[offset2 + 3];
        if (len2 == 2) {
            if (q1 == hashArea[offset2] && q2 == hashArea[offset2 + 1]) {
                return this._names[offset2 >> 2];
            }
        } else if (len2 == 0) {
            return null;
        }
        return _findSecondary(offset, q1, q2);
    }

    public String findName(int q1, int q2, int q3) {
        int offset = _calcOffset(calcHash(q1, q2, q3));
        int[] hashArea = this._hashArea;
        int len = hashArea[offset + 3];
        if (len == 3) {
            if (q1 == hashArea[offset] && hashArea[offset + 1] == q2 && hashArea[offset + 2] == q3) {
                return this._names[offset >> 2];
            }
        } else if (len == 0) {
            return null;
        }
        int offset2 = this._secondaryStart + ((offset >> 3) << 2);
        int len2 = hashArea[offset2 + 3];
        if (len2 == 3) {
            if (q1 == hashArea[offset2] && hashArea[offset2 + 1] == q2 && hashArea[offset2 + 2] == q3) {
                return this._names[offset2 >> 2];
            }
        } else if (len2 == 0) {
            return null;
        }
        return _findSecondary(offset, q1, q2, q3);
    }

    public String findName(int[] q, int qlen) {
        if (qlen >= 4) {
            int hash = calcHash(q, qlen);
            int offset = _calcOffset(hash);
            int[] hashArea = this._hashArea;
            int len = hashArea[offset + 3];
            if (hash == hashArea[offset] && len == qlen && _verifyLongName(q, qlen, hashArea[offset + 1])) {
                return this._names[offset >> 2];
            }
            if (len == 0) {
                return null;
            }
            int offset2 = this._secondaryStart + ((offset >> 3) << 2);
            int len2 = hashArea[offset2 + 3];
            if (hash == hashArea[offset2] && len2 == qlen && _verifyLongName(q, qlen, hashArea[offset2 + 1])) {
                return this._names[offset2 >> 2];
            }
            return _findSecondary(offset, hash, q, qlen);
        } else if (qlen == 1) {
            return findName(q[0]);
        } else {
            if (qlen == 2) {
                return findName(q[0], q[1]);
            }
            if (qlen != 3) {
                return "";
            }
            return findName(q[0], q[1], q[2]);
        }
    }

    private final int _calcOffset(int hash) {
        return ((this._hashSize - 1) & hash) << 2;
    }

    private String _findSecondary(int origOffset, int q1) {
        int i = this._tertiaryStart;
        int i2 = this._tertiaryShift;
        int offset = i + ((origOffset >> (i2 + 2)) << i2);
        int[] hashArea = this._hashArea;
        int end = offset + (1 << i2);
        while (offset < end) {
            int len = hashArea[offset + 3];
            if (q1 == hashArea[offset] && 1 == len) {
                return this._names[offset >> 2];
            }
            if (len == 0) {
                return null;
            }
            offset += 4;
        }
        for (int offset2 = _spilloverStart(); offset2 < this._spilloverEnd; offset2 += 4) {
            if (q1 == hashArea[offset2] && 1 == hashArea[offset2 + 3]) {
                return this._names[offset2 >> 2];
            }
        }
        return null;
    }

    private String _findSecondary(int origOffset, int q1, int q2) {
        int i = this._tertiaryStart;
        int i2 = this._tertiaryShift;
        int offset = i + ((origOffset >> (i2 + 2)) << i2);
        int[] hashArea = this._hashArea;
        int end = offset + (1 << i2);
        while (offset < end) {
            int len = hashArea[offset + 3];
            if (q1 == hashArea[offset] && q2 == hashArea[offset + 1] && 2 == len) {
                return this._names[offset >> 2];
            }
            if (len == 0) {
                return null;
            }
            offset += 4;
        }
        for (int offset2 = _spilloverStart(); offset2 < this._spilloverEnd; offset2 += 4) {
            if (q1 == hashArea[offset2] && q2 == hashArea[offset2 + 1] && 2 == hashArea[offset2 + 3]) {
                return this._names[offset2 >> 2];
            }
        }
        return null;
    }

    private String _findSecondary(int origOffset, int q1, int q2, int q3) {
        int i = this._tertiaryStart;
        int i2 = this._tertiaryShift;
        int offset = i + ((origOffset >> (i2 + 2)) << i2);
        int[] hashArea = this._hashArea;
        int end = offset + (1 << i2);
        while (offset < end) {
            int len = hashArea[offset + 3];
            if (q1 == hashArea[offset] && q2 == hashArea[offset + 1] && q3 == hashArea[offset + 2] && 3 == len) {
                return this._names[offset >> 2];
            }
            if (len == 0) {
                return null;
            }
            offset += 4;
        }
        for (int offset2 = _spilloverStart(); offset2 < this._spilloverEnd; offset2 += 4) {
            if (q1 == hashArea[offset2] && q2 == hashArea[offset2 + 1] && q3 == hashArea[offset2 + 2] && 3 == hashArea[offset2 + 3]) {
                return this._names[offset2 >> 2];
            }
        }
        return null;
    }

    private String _findSecondary(int origOffset, int hash, int[] q, int qlen) {
        int i = this._tertiaryStart;
        int i2 = this._tertiaryShift;
        int offset = i + ((origOffset >> (i2 + 2)) << i2);
        int[] hashArea = this._hashArea;
        int end = offset + (1 << i2);
        while (offset < end) {
            int len = hashArea[offset + 3];
            if (hash == hashArea[offset] && qlen == len && _verifyLongName(q, qlen, hashArea[offset + 1])) {
                return this._names[offset >> 2];
            }
            if (len == 0) {
                return null;
            }
            offset += 4;
        }
        for (int offset2 = _spilloverStart(); offset2 < this._spilloverEnd; offset2 += 4) {
            if (hash == hashArea[offset2] && qlen == hashArea[offset2 + 3] && _verifyLongName(q, qlen, hashArea[offset2 + 1])) {
                return this._names[offset2 >> 2];
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r1 = r3;
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        r3 = r1 + 1;
        r4 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r6[r1] == r0[r8]) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        r1 = r3;
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        r3 = r1 + 1;
        r4 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        if (r6[r1] == r0[r8]) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        r1 = r3;
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        r3 = r1 + 1;
        r4 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0048, code lost:
        if (r6[r1] == r0[r8]) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004a, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004b, code lost:
        r8 = r3 + 1;
        r1 = r6[r3];
        r3 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0053, code lost:
        if (r1 == r0[r4]) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0056, code lost:
        r1 = r8 + 1;
        r4 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005e, code lost:
        if (r6[r8] == r0[r3]) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0060, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        r8 = r1 + 1;
        r3 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
        if (r6[r1] == r0[r4]) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006b, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006d, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r3 = r1 + 1;
        r4 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r6[r1] == r0[r8]) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean _verifyLongName(int[] r6, int r7, int r8) {
        /*
            r5 = this;
            int[] r0 = r5._hashArea
            r1 = 0
            r2 = 0
            switch(r7) {
                case 4: goto L_0x0040;
                case 5: goto L_0x0033;
                case 6: goto L_0x0026;
                case 7: goto L_0x0019;
                case 8: goto L_0x000c;
                default: goto L_0x0007;
            }
        L_0x0007:
            boolean r2 = r5._verifyLongName2(r6, r7, r8)
            return r2
        L_0x000c:
            int r3 = r1 + 1
            r1 = r6[r1]
            int r4 = r8 + 1
            r8 = r0[r8]
            if (r1 == r8) goto L_0x0017
            return r2
        L_0x0017:
            r1 = r3
            r8 = r4
        L_0x0019:
            int r3 = r1 + 1
            r1 = r6[r1]
            int r4 = r8 + 1
            r8 = r0[r8]
            if (r1 == r8) goto L_0x0024
            return r2
        L_0x0024:
            r1 = r3
            r8 = r4
        L_0x0026:
            int r3 = r1 + 1
            r1 = r6[r1]
            int r4 = r8 + 1
            r8 = r0[r8]
            if (r1 == r8) goto L_0x0031
            return r2
        L_0x0031:
            r1 = r3
            r8 = r4
        L_0x0033:
            int r3 = r1 + 1
            r1 = r6[r1]
            int r4 = r8 + 1
            r8 = r0[r8]
            if (r1 == r8) goto L_0x003e
            return r2
        L_0x003e:
            r1 = r3
            r8 = r4
        L_0x0040:
            int r3 = r1 + 1
            r1 = r6[r1]
            int r4 = r8 + 1
            r8 = r0[r8]
            if (r1 == r8) goto L_0x004b
            return r2
        L_0x004b:
            int r8 = r3 + 1
            r1 = r6[r3]
            int r3 = r4 + 1
            r4 = r0[r4]
            if (r1 == r4) goto L_0x0056
            return r2
        L_0x0056:
            int r1 = r8 + 1
            r8 = r6[r8]
            int r4 = r3 + 1
            r3 = r0[r3]
            if (r8 == r3) goto L_0x0061
            return r2
        L_0x0061:
            int r8 = r1 + 1
            r1 = r6[r1]
            int r3 = r4 + 1
            r4 = r0[r4]
            if (r1 == r4) goto L_0x006c
            return r2
        L_0x006c:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer._verifyLongName(int[], int, int):boolean");
    }

    private boolean _verifyLongName2(int[] q, int qlen, int spillOffset) {
        int ix = 0;
        while (true) {
            int ix2 = ix + 1;
            int spillOffset2 = spillOffset + 1;
            if (q[ix] != this._hashArea[spillOffset]) {
                return false;
            }
            if (ix2 >= qlen) {
                return true;
            }
            ix = ix2;
            spillOffset = spillOffset2;
        }
    }

    public String addName(String name, int[] q, int qlen) {
        int offset;
        _verifySharing();
        if (this._intern) {
            name = InternCache.instance.intern(name);
        }
        if (qlen == 1) {
            int offset2 = _findOffsetForAdd(calcHash(q[0]));
            int[] iArr = this._hashArea;
            iArr[offset2] = q[0];
            iArr[offset2 + 3] = 1;
            offset = offset2;
        } else if (qlen == 2) {
            int offset3 = _findOffsetForAdd(calcHash(q[0], q[1]));
            int[] iArr2 = this._hashArea;
            iArr2[offset3] = q[0];
            iArr2[offset3 + 1] = q[1];
            iArr2[offset3 + 3] = 2;
            offset = offset3;
        } else if (qlen != 3) {
            int hash = calcHash(q, qlen);
            offset = _findOffsetForAdd(hash);
            this._hashArea[offset] = hash;
            int longStart = _appendLongName(q, qlen);
            int[] iArr3 = this._hashArea;
            iArr3[offset + 1] = longStart;
            iArr3[offset + 3] = qlen;
        } else {
            int offset4 = _findOffsetForAdd(calcHash(q[0], q[1], q[2]));
            int[] iArr4 = this._hashArea;
            iArr4[offset4] = q[0];
            iArr4[offset4 + 1] = q[1];
            iArr4[offset4 + 2] = q[2];
            iArr4[offset4 + 3] = 3;
            offset = offset4;
        }
        this._names[offset >> 2] = name;
        this._count++;
        _verifyNeedForRehash();
        return name;
    }

    private void _verifyNeedForRehash() {
        if (this._count > (this._hashSize >> 1)) {
            int spillCount = (this._spilloverEnd - _spilloverStart()) >> 2;
            int i = this._count;
            if (spillCount <= ((i + 1) >> 7)) {
                double d = (double) i;
                double d2 = (double) this._hashSize;
                Double.isNaN(d2);
                if (d <= d2 * 0.8d) {
                    return;
                }
            }
            this._needRehash = true;
        }
    }

    private void _verifySharing() {
        if (this._hashShared) {
            int[] iArr = this._hashArea;
            this._hashArea = Arrays.copyOf(iArr, iArr.length);
            String[] strArr = this._names;
            this._names = (String[]) Arrays.copyOf(strArr, strArr.length);
            this._hashShared = false;
            _verifyNeedForRehash();
        }
        if (this._needRehash) {
            rehash();
        }
    }

    private int _findOffsetForAdd(int hash) {
        int offset = _calcOffset(hash);
        int[] hashArea = this._hashArea;
        if (hashArea[offset + 3] == 0) {
            return offset;
        }
        int offset2 = this._secondaryStart + ((offset >> 3) << 2);
        if (hashArea[offset2 + 3] == 0) {
            return offset2;
        }
        int i = this._tertiaryStart;
        int i2 = this._tertiaryShift;
        int offset22 = i + ((offset >> (i2 + 2)) << i2);
        int end = offset22 + (1 << i2);
        while (offset22 < end) {
            if (hashArea[offset22 + 3] == 0) {
                return offset22;
            }
            offset22 += 4;
        }
        int offset3 = this._spilloverEnd;
        this._spilloverEnd += 4;
        if (this._spilloverEnd >= (this._hashSize << 3)) {
            if (this._failOnDoS) {
                _reportTooManyCollisions();
            }
            this._needRehash = true;
        }
        return offset3;
    }

    private int _appendLongName(int[] quads, int qlen) {
        int start = this._longNameOffset;
        int i = start + qlen;
        int[] iArr = this._hashArea;
        if (i > iArr.length) {
            this._hashArea = Arrays.copyOf(this._hashArea, this._hashArea.length + Math.max((start + qlen) - iArr.length, Math.min(Opcodes.ACC_SYNTHETIC, this._hashSize)));
        }
        System.arraycopy(quads, 0, this._hashArea, start, qlen);
        this._longNameOffset += qlen;
        return start;
    }

    public int calcHash(int q1) {
        int hash = this._seed ^ q1;
        int hash2 = hash + (hash >>> 16);
        int hash3 = hash2 ^ (hash2 << 3);
        return hash3 + (hash3 >>> 12);
    }

    public int calcHash(int q1, int q2) {
        int hash = q1;
        int hash2 = hash + (hash >>> 15);
        int hash3 = ((hash2 ^ (hash2 >>> 9)) + (q2 * 33)) ^ this._seed;
        int hash4 = hash3 + (hash3 >>> 16);
        int hash5 = hash4 ^ (hash4 >>> 4);
        return hash5 + (hash5 << 3);
    }

    public int calcHash(int q1, int q2, int q3) {
        int hash = this._seed ^ q1;
        int hash2 = (((hash + (hash >>> 9)) * 31) + q2) * 33;
        int hash3 = (hash2 + (hash2 >>> 15)) ^ q3;
        int hash4 = hash3 + (hash3 >>> 4);
        int hash5 = hash4 + (hash4 >>> 15);
        return hash5 ^ (hash5 << 9);
    }

    public int calcHash(int[] q, int qlen) {
        if (qlen >= 4) {
            int hash = q[0] ^ this._seed;
            int hash2 = hash + (hash >>> 9) + q[1];
            int hash3 = ((hash2 + (hash2 >>> 15)) * 33) ^ q[2];
            int hash4 = hash3 + (hash3 >>> 4);
            for (int i = 3; i < qlen; i++) {
                int next = q[i];
                hash4 += next ^ (next >> 21);
            }
            int hash5 = hash4 * 65599;
            int hash6 = hash5 + (hash5 >>> 19);
            return hash6 ^ (hash6 << 5);
        }
        throw new IllegalArgumentException();
    }

    private void rehash() {
        this._needRehash = false;
        this._hashShared = false;
        int[] oldHashArea = this._hashArea;
        String[] oldNames = this._names;
        int oldSize = this._hashSize;
        int oldCount = this._count;
        int newSize = oldSize + oldSize;
        int oldEnd = this._spilloverEnd;
        if (newSize > 65536) {
            nukeSymbols(true);
            return;
        }
        this._hashArea = new int[(oldHashArea.length + (oldSize << 3))];
        this._hashSize = newSize;
        this._secondaryStart = newSize << 2;
        int i = this._secondaryStart;
        this._tertiaryStart = i + (i >> 1);
        this._tertiaryShift = _calcTertiaryShift(newSize);
        this._names = new String[(oldNames.length << 1)];
        nukeSymbols(false);
        int copyCount = 0;
        int[] q = new int[16];
        int end = oldEnd;
        for (int offset = 0; offset < end; offset += 4) {
            int len = oldHashArea[offset + 3];
            if (len != 0) {
                copyCount++;
                String name = oldNames[offset >> 2];
                if (len == 1) {
                    q[0] = oldHashArea[offset];
                    addName(name, q, 1);
                } else if (len == 2) {
                    q[0] = oldHashArea[offset];
                    q[1] = oldHashArea[offset + 1];
                    addName(name, q, 2);
                } else if (len != 3) {
                    if (len > q.length) {
                        q = new int[len];
                    }
                    System.arraycopy(oldHashArea, oldHashArea[offset + 1], q, 0, len);
                    addName(name, q, len);
                } else {
                    q[0] = oldHashArea[offset];
                    q[1] = oldHashArea[offset + 1];
                    q[2] = oldHashArea[offset + 2];
                    addName(name, q, 3);
                }
            }
        }
        if (copyCount != oldCount) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed rehash(): old count=");
            sb.append(oldCount);
            sb.append(", copyCount=");
            sb.append(copyCount);
            throw new IllegalStateException(sb.toString());
        }
    }

    private void nukeSymbols(boolean fill) {
        this._count = 0;
        this._spilloverEnd = _spilloverStart();
        this._longNameOffset = this._hashSize << 3;
        if (fill) {
            Arrays.fill(this._hashArea, 0);
            Arrays.fill(this._names, null);
        }
    }

    private final int _spilloverStart() {
        int offset = this._hashSize;
        return (offset << 3) - offset;
    }

    /* access modifiers changed from: protected */
    public void _reportTooManyCollisions() {
        if (this._hashSize > 1024) {
            StringBuilder sb = new StringBuilder();
            sb.append("Spill-over slots in symbol table with ");
            sb.append(this._count);
            sb.append(" entries, hash area of ");
            sb.append(this._hashSize);
            sb.append(" slots is now full (all ");
            sb.append(this._hashSize >> 3);
            sb.append(" slots -- suspect a DoS attack based on hash collisions.");
            sb.append(" You can disable the check via `JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW`");
            throw new IllegalStateException(sb.toString());
        }
    }

    static int _calcTertiaryShift(int primarySlots) {
        int tertSlots = primarySlots >> 2;
        if (tertSlots < 64) {
            return 4;
        }
        if (tertSlots <= 256) {
            return 5;
        }
        if (tertSlots <= 1024) {
            return 6;
        }
        return 7;
    }
}
