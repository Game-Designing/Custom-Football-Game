package p024io.realm.internal;

import io.realm.RealmModel;
import io.realm.internal.util.Pair;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import p024io.realm.C0105Y;
import p024io.realm.internal.p158c.C7329a;

/* renamed from: io.realm.internal.b */
/* compiled from: ColumnIndices */
public final class C7324b {

    /* renamed from: a */
    private final Map<C7329a<Class<? extends C0105Y>, String>, C7327c> f14293a;

    /* renamed from: b */
    private final Map<Class<? extends C0105Y>, C7327c> f14294b;

    /* renamed from: c */
    private final Map<String, C7327c> f14295c;

    /* renamed from: d */
    private final boolean f14296d;

    /* renamed from: e */
    private long f14297e;

    public C7324b(long schemaVersion, Map<C7329a<Class<? extends C0105Y>, String>, C7327c> classesMap) {
        this(schemaVersion, new HashMap(classesMap), true);
        for (Entry<Pair<Class<? extends RealmModel>, String>, ColumnInfo> entry : classesMap.entrySet()) {
            C7327c columnInfo = (C7327c) entry.getValue();
            if (this.f14296d == columnInfo.mo23762a()) {
                Pair<Class<? extends RealmModel>, String> classDescription = (C7329a) entry.getKey();
                this.f14294b.put(classDescription.f14306a, columnInfo);
                this.f14295c.put(classDescription.f14307b, columnInfo);
            } else {
                throw new IllegalArgumentException("ColumnInfo mutability does not match ColumnIndices");
            }
        }
    }

    public C7324b(C7324b other, boolean mutable) {
        this(other.f14297e, new HashMap(other.f14293a.size()), mutable);
        for (Entry<Pair<Class<? extends RealmModel>, String>, ColumnInfo> entry : other.f14293a.entrySet()) {
            C7327c columnInfo = ((C7327c) entry.getValue()).mo23759a(mutable);
            Pair<Class<? extends RealmModel>, String> key = (C7329a) entry.getKey();
            this.f14294b.put(key.f14306a, columnInfo);
            this.f14295c.put(key.f14307b, columnInfo);
            this.f14293a.put(key, columnInfo);
        }
    }

    private C7324b(long schemaVersion, Map<C7329a<Class<? extends C0105Y>, String>, C7327c> classesMap, boolean mutable) {
        this.f14297e = schemaVersion;
        this.f14293a = classesMap;
        this.f14296d = mutable;
        this.f14294b = new HashMap(classesMap.size());
        this.f14295c = new HashMap(classesMap.size());
    }

    /* renamed from: a */
    public long mo23742a() {
        return this.f14297e;
    }

    /* renamed from: a */
    public C7327c mo23743a(Class<? extends C0105Y> clazz) {
        return (C7327c) this.f14294b.get(clazz);
    }

    /* renamed from: a */
    public C7327c mo23744a(String className) {
        return (C7327c) this.f14295c.get(className);
    }

    /* renamed from: a */
    public void mo23745a(C7324b src) {
        if (this.f14296d) {
            for (Entry<String, ColumnInfo> entry : this.f14295c.entrySet()) {
                C7327c otherColumnInfo = (C7327c) src.f14295c.get(entry.getKey());
                if (otherColumnInfo != null) {
                    ((C7327c) entry.getValue()).mo23760a(otherColumnInfo);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to copy ColumnIndices cache for class: ");
                    sb.append((String) entry.getKey());
                    throw new IllegalStateException(sb.toString());
                }
            }
            this.f14297e = src.f14297e;
            return;
        }
        throw new UnsupportedOperationException("Attempt to modify immutable cache");
    }

    public String toString() {
        StringBuilder buf = new StringBuilder("ColumnIndices[");
        buf.append(this.f14297e);
        String str = ",";
        buf.append(str);
        buf.append(this.f14296d);
        buf.append(str);
        if (this.f14294b != null) {
            boolean commaNeeded = false;
            for (Entry<String, ColumnInfo> entry : this.f14295c.entrySet()) {
                if (commaNeeded) {
                    buf.append(str);
                }
                buf.append((String) entry.getKey());
                buf.append("->");
                buf.append(entry.getValue());
                commaNeeded = true;
            }
        }
        buf.append("]");
        return buf.toString();
    }
}
