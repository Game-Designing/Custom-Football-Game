package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class zzp {

    /* renamed from: a */
    public final int f29060a;

    /* renamed from: b */
    public final byte[] f29061b;

    /* renamed from: c */
    public final Map<String, String> f29062c;

    /* renamed from: d */
    public final List<zzl> f29063d;

    /* renamed from: e */
    public final boolean f29064e;

    /* renamed from: f */
    private final long f29065f;

    @Deprecated
    public zzp(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        List list;
        if (map == null) {
            list = null;
        } else if (map.isEmpty()) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Entry entry : map.entrySet()) {
                arrayList.add(new zzl((String) entry.getKey(), (String) entry.getValue()));
            }
            list = arrayList;
        }
        this(i, bArr, map, list, z, j);
    }

    public zzp(int i, byte[] bArr, boolean z, long j, List<zzl> list) {
        Map map;
        if (list == null) {
            map = null;
        } else if (list.isEmpty()) {
            map = Collections.emptyMap();
        } else {
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (zzl zzl : list) {
                treeMap.put(zzl.mo31933a(), zzl.mo31934b());
            }
            map = treeMap;
        }
        this(i, bArr, map, list, z, j);
    }

    @Deprecated
    public zzp(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0);
    }

    private zzp(int i, byte[] bArr, Map<String, String> map, List<zzl> list, boolean z, long j) {
        this.f29060a = i;
        this.f29061b = bArr;
        this.f29062c = map;
        if (list == null) {
            this.f29063d = null;
        } else {
            this.f29063d = Collections.unmodifiableList(list);
        }
        this.f29064e = z;
        this.f29065f = j;
    }
}
