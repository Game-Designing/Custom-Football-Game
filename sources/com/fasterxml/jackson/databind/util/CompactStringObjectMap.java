package com.fasterxml.jackson.databind.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class CompactStringObjectMap implements Serializable {
    private static final CompactStringObjectMap EMPTY = new CompactStringObjectMap(1, 0, new Object[4]);
    private final Object[] _hashArea;
    private final int _hashMask;
    private final int _spillCount;

    private CompactStringObjectMap(int hashMask, int spillCount, Object[] hashArea) {
        this._hashMask = hashMask;
        this._spillCount = spillCount;
        this._hashArea = hashArea;
    }

    public static <T> CompactStringObjectMap construct(Map<String, T> all) {
        if (all.isEmpty()) {
            return EMPTY;
        }
        int size = findSize(all.size());
        int mask = size - 1;
        Object[] hashArea = new Object[(((size >> 1) + size) * 2)];
        int spillCount = 0;
        for (Entry<String, T> entry : all.entrySet()) {
            String key = (String) entry.getKey();
            int slot = key.hashCode() & mask;
            int ix = slot + slot;
            if (hashArea[ix] != null) {
                ix = ((slot >> 1) + size) << 1;
                if (hashArea[ix] != null) {
                    ix = (((size >> 1) + size) << 1) + spillCount;
                    spillCount += 2;
                    if (ix >= hashArea.length) {
                        hashArea = Arrays.copyOf(hashArea, hashArea.length + 4);
                    }
                }
            }
            hashArea[ix] = key;
            hashArea[ix + 1] = entry.getValue();
        }
        return new CompactStringObjectMap(mask, spillCount, hashArea);
    }

    private static final int findSize(int size) {
        if (size <= 5) {
            return 8;
        }
        if (size <= 12) {
            return 16;
        }
        int result = 32;
        while (result < (size >> 2) + size) {
            result += result;
        }
        return result;
    }

    public Object find(String key) {
        int slot = key.hashCode() & this._hashMask;
        int ix = slot << 1;
        Object match = this._hashArea[ix];
        if (match == key || key.equals(match)) {
            return this._hashArea[ix + 1];
        }
        return _find2(key, slot, match);
    }

    private final Object _find2(String key, int slot, Object match) {
        if (match == null) {
            return null;
        }
        int hashSize = this._hashMask + 1;
        int ix = ((slot >> 1) + hashSize) << 1;
        Object match2 = this._hashArea[ix];
        if (key.equals(match2)) {
            return this._hashArea[ix + 1];
        }
        if (match2 != null) {
            int i = ((hashSize >> 1) + hashSize) << 1;
            int end = this._spillCount + i;
            while (i < end) {
                Object match3 = this._hashArea[i];
                if (match3 == key || key.equals(match3)) {
                    return this._hashArea[i + 1];
                }
                i += 2;
            }
        }
        return null;
    }

    public Object findCaseInsensitive(String key) {
        int end = this._hashArea.length;
        for (int i = 0; i < end; i += 2) {
            Object k2 = this._hashArea[i];
            if (k2 != null && ((String) k2).equalsIgnoreCase(key)) {
                return this._hashArea[i + 1];
            }
        }
        return null;
    }

    public List<String> keys() {
        int end = this._hashArea.length;
        List<String> keys = new ArrayList<>(end >> 2);
        for (int i = 0; i < end; i += 2) {
            Object key = this._hashArea[i];
            if (key != null) {
                keys.add((String) key);
            }
        }
        return keys;
    }
}
