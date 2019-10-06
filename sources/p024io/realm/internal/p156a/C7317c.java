package p024io.realm.internal.p156a;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import p024io.realm.RealmFieldType;
import p024io.realm.internal.C7327c;
import p024io.realm.internal.Table;

/* renamed from: io.realm.internal.a.c */
/* compiled from: FieldDescriptor */
public abstract class C7317c {

    /* renamed from: a */
    public static final Set<RealmFieldType> f14269a;

    /* renamed from: b */
    public static final Set<RealmFieldType> f14270b;

    /* renamed from: c */
    public static final Set<RealmFieldType> f14271c;

    /* renamed from: d */
    public static final Set<RealmFieldType> f14272d;

    /* renamed from: e */
    public static final Set<RealmFieldType> f14273e = Collections.emptySet();

    /* renamed from: f */
    private final List<String> f14274f;

    /* renamed from: g */
    private final Set<RealmFieldType> f14275g;

    /* renamed from: h */
    private final Set<RealmFieldType> f14276h;

    /* renamed from: i */
    private String f14277i;

    /* renamed from: j */
    private RealmFieldType f14278j;

    /* renamed from: k */
    private long[] f14279k;

    /* renamed from: l */
    private long[] f14280l;

    /* renamed from: io.realm.internal.a.c$a */
    /* compiled from: FieldDescriptor */
    public interface C7318a {
        /* renamed from: a */
        C7327c mo23737a(String str);

        /* renamed from: a */
        boolean mo23738a();

        /* renamed from: b */
        long mo23739b(String str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo23729a(List<String> list);

    static {
        Set<RealmFieldType> s = new HashSet<>(3);
        s.add(RealmFieldType.OBJECT);
        s.add(RealmFieldType.LIST);
        s.add(RealmFieldType.LINKING_OBJECTS);
        f14269a = Collections.unmodifiableSet(s);
        Set<RealmFieldType> s2 = new HashSet<>(2);
        s2.add(RealmFieldType.OBJECT);
        s2.add(RealmFieldType.LIST);
        f14270b = Collections.unmodifiableSet(s2);
        Set<RealmFieldType> s3 = new HashSet<>(1);
        s3.add(RealmFieldType.LIST);
        f14271c = Collections.unmodifiableSet(s3);
        Set<RealmFieldType> s4 = new HashSet<>(1);
        s4.add(RealmFieldType.OBJECT);
        f14272d = Collections.unmodifiableSet(s4);
    }

    /* renamed from: a */
    public static C7317c m16060a(C7318a schema, Table table, String fieldDescription, RealmFieldType... validFinalColumnTypes) {
        return m16059a(schema, table, fieldDescription, null, (Set<RealmFieldType>) new HashSet<RealmFieldType>(Arrays.asList(validFinalColumnTypes)));
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [io.realm.internal.a.b] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p024io.realm.internal.p156a.C7317c m16059a(p024io.realm.internal.p156a.C7317c.C7318a r7, p024io.realm.internal.Table r8, java.lang.String r9, java.util.Set<p024io.realm.RealmFieldType> r10, java.util.Set<p024io.realm.RealmFieldType> r11) {
        /*
            if (r7 == 0) goto L_0x001e
            boolean r0 = r7.mo23738a()
            if (r0 != 0) goto L_0x0009
            goto L_0x001e
        L_0x0009:
            io.realm.internal.a.a r0 = new io.realm.internal.a.a
            java.lang.String r3 = r8.mo23659c()
            if (r10 == 0) goto L_0x0013
            r5 = r10
            goto L_0x0016
        L_0x0013:
            java.util.Set<io.realm.RealmFieldType> r1 = f14269a
            r5 = r1
        L_0x0016:
            r1 = r0
            r2 = r7
            r4 = r9
            r6 = r11
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0029
        L_0x001e:
            io.realm.internal.a.b r0 = new io.realm.internal.a.b
            if (r10 == 0) goto L_0x0024
            r1 = r10
            goto L_0x0026
        L_0x0024:
            java.util.Set<io.realm.RealmFieldType> r1 = f14270b
        L_0x0026:
            r0.<init>(r8, r9, r1, r11)
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p024io.realm.internal.p156a.C7317c.m16059a(io.realm.internal.a.c$a, io.realm.internal.Table, java.lang.String, java.util.Set, java.util.Set):io.realm.internal.a.c");
    }

    protected C7317c(String fieldDescription, Set<RealmFieldType> validInternalColumnTypes, Set<RealmFieldType> validFinalColumnTypes) {
        this.f14274f = m16061a(fieldDescription);
        if (this.f14274f.size() > 0) {
            this.f14275g = validInternalColumnTypes;
            this.f14276h = validFinalColumnTypes;
            return;
        }
        throw new IllegalArgumentException("Invalid query: Empty field descriptor");
    }

    /* renamed from: e */
    public final int mo23736e() {
        return this.f14274f.size();
    }

    /* renamed from: a */
    public final long[] mo23732a() {
        m16063f();
        long[] jArr = this.f14279k;
        return Arrays.copyOf(jArr, jArr.length);
    }

    /* renamed from: d */
    public final long[] mo23735d() {
        m16063f();
        long[] jArr = this.f14280l;
        return Arrays.copyOf(jArr, jArr.length);
    }

    /* renamed from: b */
    public final String mo23733b() {
        m16063f();
        return this.f14277i;
    }

    /* renamed from: c */
    public final RealmFieldType mo23734c() {
        m16063f();
        return this.f14278j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo23730a(String tableName, String columnName, RealmFieldType columnType) {
        m16062a(tableName, columnName, columnType, this.f14275g);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo23731a(String finalClassName, String finalColumnName, RealmFieldType finalColumnType, long[] columnIndices, long[] nativeTablePointers) {
        Set<RealmFieldType> set = this.f14276h;
        if (set != null && set.size() > 0) {
            m16062a(finalClassName, finalColumnName, finalColumnType, this.f14276h);
        }
        this.f14277i = finalColumnName;
        this.f14278j = finalColumnType;
        this.f14279k = columnIndices;
        this.f14280l = nativeTablePointers;
    }

    /* renamed from: a */
    private List<String> m16061a(String fieldDescription) {
        if (fieldDescription == null || fieldDescription.equals("")) {
            throw new IllegalArgumentException("Invalid query: field name is empty");
        } else if (!fieldDescription.endsWith(".")) {
            return Arrays.asList(fieldDescription.split("\\."));
        } else {
            throw new IllegalArgumentException("Invalid query: field name must not end with a period ('.')");
        }
    }

    /* renamed from: a */
    private void m16062a(String tableName, String columnName, RealmFieldType columnType, Set<RealmFieldType> validTypes) {
        if (!validTypes.contains(columnType)) {
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' in table '%s' is of invalid type '%s'.", new Object[]{columnName, tableName, columnType.toString()}));
        }
    }

    /* renamed from: f */
    private void m16063f() {
        if (this.f14278j == null) {
            mo23729a(this.f14274f);
        }
    }
}
