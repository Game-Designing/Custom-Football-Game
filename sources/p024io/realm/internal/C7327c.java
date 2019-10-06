package p024io.realm.internal;

import io.realm.internal.ColumnInfo.ColumnDetails;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import p024io.realm.RealmFieldType;

/* renamed from: io.realm.internal.c */
/* compiled from: ColumnInfo */
public abstract class C7327c {

    /* renamed from: a */
    private final Map<String, C7328a> f14301a;

    /* renamed from: b */
    private final boolean f14302b;

    /* renamed from: io.realm.internal.c$a */
    /* compiled from: ColumnInfo */
    private static final class C7328a {

        /* renamed from: a */
        public final long f14303a;

        /* renamed from: b */
        public final RealmFieldType f14304b;

        /* renamed from: c */
        public final String f14305c;

        C7328a(long columnIndex, RealmFieldType columnType, String srcTable) {
            this.f14303a = columnIndex;
            this.f14304b = columnType;
            this.f14305c = srcTable;
        }

        public String toString() {
            StringBuilder buf = new StringBuilder("ColumnDetails[");
            buf.append(this.f14303a);
            String str = ", ";
            buf.append(str);
            buf.append(this.f14304b);
            buf.append(str);
            buf.append(this.f14305c);
            buf.append("]");
            return buf.toString();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C7327c mo23759a(boolean z);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo23761a(C7327c cVar, C7327c cVar2);

    protected C7327c(int mapSize) {
        this(mapSize, true);
    }

    protected C7327c(C7327c src, boolean mutable) {
        this(src == null ? 0 : src.f14301a.size(), mutable);
        if (src != null) {
            this.f14301a.putAll(src.f14301a);
        }
    }

    private C7327c(int mapSize, boolean mutable) {
        this.f14301a = new HashMap(mapSize);
        this.f14302b = mutable;
    }

    /* renamed from: a */
    public final boolean mo23762a() {
        return this.f14302b;
    }

    /* renamed from: a */
    public long mo23758a(String columnName) {
        C7328a details = (C7328a) this.f14301a.get(columnName);
        if (details == null) {
            return -1;
        }
        return details.f14303a;
    }

    /* renamed from: b */
    public RealmFieldType mo23763b(String columnName) {
        C7328a details = (C7328a) this.f14301a.get(columnName);
        return details == null ? RealmFieldType.UNSUPPORTED_TABLE : details.f14304b;
    }

    /* renamed from: c */
    public String mo23764c(String columnName) {
        C7328a details = (C7328a) this.f14301a.get(columnName);
        if (details == null) {
            return null;
        }
        return details.f14305c;
    }

    /* renamed from: a */
    public void mo23760a(C7327c src) {
        if (!this.f14302b) {
            throw new UnsupportedOperationException("Attempt to modify an immutable ColumnInfo");
        } else if (src != null) {
            this.f14301a.clear();
            this.f14301a.putAll(src.f14301a);
            mo23761a(src, this);
        } else {
            throw new NullPointerException("Attempt to copy null ColumnInfo");
        }
    }

    public String toString() {
        StringBuilder buf = new StringBuilder("ColumnInfo[");
        buf.append(this.f14302b);
        String str = ",";
        buf.append(str);
        Map<String, C7328a> map = this.f14301a;
        if (map != null) {
            boolean commaNeeded = false;
            for (Entry<String, ColumnDetails> entry : map.entrySet()) {
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

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final long mo23757a(Table table, String columnName, RealmFieldType columnType) {
        String linkedTableName;
        long columnIndex = table.mo23656b(columnName);
        if (columnIndex >= 0) {
            if (columnType == RealmFieldType.OBJECT || columnType == RealmFieldType.LIST) {
                linkedTableName = table.mo23670h(columnIndex).mo23659c();
            } else {
                linkedTableName = null;
            }
            this.f14301a.put(columnName, new C7328a(columnIndex, columnType, linkedTableName));
        }
        return columnIndex;
    }
}
