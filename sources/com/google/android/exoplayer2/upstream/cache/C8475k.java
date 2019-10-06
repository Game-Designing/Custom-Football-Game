package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.util.C8514e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.exoplayer2.upstream.cache.k */
/* compiled from: ContentMetadataMutations */
public class C8475k {

    /* renamed from: a */
    private final Map<String, Object> f18689a = new HashMap();

    /* renamed from: b */
    private final List<String> f18690b = new ArrayList();

    /* renamed from: a */
    public C8475k mo25993a(String name, String value) {
        m20262a(name, (Object) value);
        return this;
    }

    /* renamed from: a */
    public C8475k mo25992a(String name, long value) {
        m20262a(name, (Object) Long.valueOf(value));
        return this;
    }

    /* renamed from: a */
    public C8475k mo25991a(String name) {
        this.f18690b.add(name);
        this.f18689a.remove(name);
        return this;
    }

    /* renamed from: b */
    public List<String> mo25995b() {
        return Collections.unmodifiableList(new ArrayList(this.f18690b));
    }

    /* renamed from: a */
    public Map<String, Object> mo25994a() {
        HashMap<String, Object> hashMap = new HashMap<>(this.f18689a);
        for (Entry<String, Object> entry : hashMap.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bytes = (byte[]) value;
                entry.setValue(Arrays.copyOf(bytes, bytes.length));
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: a */
    private C8475k m20262a(String name, Object value) {
        Map<String, Object> map = this.f18689a;
        C8514e.m20486a(name);
        C8514e.m20486a(value);
        map.put(name, value);
        this.f18690b.remove(name);
        return this;
    }
}
