package p024io.realm;

import java.util.HashMap;
import java.util.Map;
import p024io.realm.internal.C7324b;
import p024io.realm.internal.C7327c;
import p024io.realm.internal.Table;
import p024io.realm.internal.Util;
import p024io.realm.internal.p158c.C7329a;

/* renamed from: io.realm.ea */
/* compiled from: RealmSchema */
public class C14054ea {

    /* renamed from: a */
    private final Map<String, Table> f42579a = new HashMap();

    /* renamed from: b */
    private final Map<Class<? extends C0105Y>, Table> f42580b = new HashMap();

    /* renamed from: c */
    private final Map<Class<? extends C0105Y>, C14042ba> f42581c = new HashMap();

    /* renamed from: d */
    private final Map<String, C14042ba> f42582d = new HashMap();

    /* renamed from: e */
    private final C14048d f42583e;

    /* renamed from: f */
    private C7324b f42584f;

    C14054ea(C14048d realm) {
        this.f42583e = realm;
    }

    @Deprecated
    /* renamed from: a */
    public void mo43711a() {
    }

    /* renamed from: c */
    public C14042ba mo43721c(String className) {
        m44825a(className, "Null or empty class names are not allowed");
        String internalClassName = Table.m15962c(className);
        if (!this.f42583e.mo43696w().mo23625c(internalClassName)) {
            return null;
        }
        return new C14042ba(this.f42583e, this, this.f42583e.mo43696w().mo23622b(internalClassName));
    }

    /* renamed from: b */
    public C14042ba mo43717b(String className) {
        m44825a(className, "Null or empty class names are not allowed");
        String internalTableName = Table.m15962c(className);
        if (internalTableName.length() <= 56) {
            C14048d dVar = this.f42583e;
            return new C14042ba(dVar, this, dVar.mo43696w().mo23616a(internalTableName));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Class name is too long. Limit is 56 characters: ");
        sb.append(className.length());
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: g */
    public void mo43727g(String className) {
        this.f42583e.mo43692f();
        m44825a(className, "Null or empty class names are not allowed");
        String internalTableName = Table.m15962c(className);
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot remove class because it is not in this Realm: ");
        sb.append(className);
        m44826b(className, sb.toString());
        Table table = mo43726f(className);
        if (table.mo23671h()) {
            table.mo23663d((String) null);
        }
        this.f42583e.mo43696w().mo23628d(internalTableName);
    }

    /* renamed from: a */
    public boolean mo43715a(String className) {
        return this.f42583e.mo43696w().mo23625c(Table.m15962c(className));
    }

    /* renamed from: a */
    private void m44825a(String str, String error) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(error);
        }
    }

    /* renamed from: b */
    private void m44826b(String className, String errorMsg) {
        if (!this.f42583e.mo43696w().mo23625c(Table.m15962c(className))) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public Table mo43726f(String className) {
        String tableName = Table.m15962c(className);
        Table table = (Table) this.f42579a.get(tableName);
        if (table != null) {
            return table;
        }
        Table table2 = this.f42583e.mo43696w().mo23622b(tableName);
        this.f42579a.put(tableName, table2);
        return table2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Table mo43722c(Class<? extends C0105Y> clazz) {
        Table table = (Table) this.f42580b.get(clazz);
        if (table != null) {
            return table;
        }
        Class<? extends RealmModel> originalClass = Util.m16050a(clazz);
        if (mo43714a(originalClass, clazz)) {
            table = (Table) this.f42580b.get(originalClass);
        }
        if (table == null) {
            table = this.f42583e.mo43696w().mo23622b(this.f42583e.mo43544i().mo43572l().mo23755c(originalClass));
            this.f42580b.put(originalClass, table);
        }
        if (mo43714a(originalClass, clazz)) {
            this.f42580b.put(clazz, table);
        }
        return table;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C14042ba mo43716b(Class<? extends C0105Y> clazz) {
        C14042ba classSchema = (C14042ba) this.f42581c.get(clazz);
        if (classSchema != null) {
            return classSchema;
        }
        Class<? extends RealmModel> originalClass = Util.m16050a(clazz);
        if (mo43714a(originalClass, clazz)) {
            classSchema = (C14042ba) this.f42581c.get(originalClass);
        }
        if (classSchema == null) {
            classSchema = new C14042ba(this.f42583e, this, mo43722c(clazz), mo43710a(originalClass));
            this.f42581c.put(originalClass, classSchema);
        }
        if (mo43714a(originalClass, clazz)) {
            this.f42581c.put(clazz, classSchema);
        }
        return classSchema;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C14042ba mo43725e(String className) {
        String tableName = Table.m15962c(className);
        C14042ba dynamicSchema = (C14042ba) this.f42582d.get(tableName);
        if (dynamicSchema != null) {
            return dynamicSchema;
        }
        if (this.f42583e.mo43696w().mo23625c(tableName)) {
            C14048d dVar = this.f42583e;
            C14042ba dynamicSchema2 = new C14042ba(dVar, this, dVar.mo43696w().mo23622b(tableName));
            this.f42582d.put(tableName, dynamicSchema2);
            return dynamicSchema2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The class ");
        sb.append(className);
        sb.append(" doesn't exist in this Realm.");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo43713a(C7324b columnIndices) {
        if (this.f42584f == null) {
            this.f42584f = new C7324b(columnIndices, true);
            return;
        }
        throw new IllegalStateException("An instance of ColumnIndices is already set.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo43712a(long version, Map<C7329a<Class<? extends C0105Y>, String>, C7327c> columnInfoMap) {
        if (this.f42584f == null) {
            this.f42584f = new C7324b(version, columnInfoMap);
            return;
        }
        throw new IllegalStateException("An instance of ColumnIndices is already set.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo43719b(C7324b schemaVersion) {
        this.f42584f.mo23745a(schemaVersion);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo43714a(Class<? extends C0105Y> modelClass, Class<? extends C0105Y> testee) {
        return modelClass.equals(testee);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final C7324b mo43718b() {
        m44827e();
        return new C7324b(this.f42584f, false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final boolean mo43724d() {
        return this.f42584f != null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final long mo43720c() {
        m44827e();
        return this.f42584f.mo23742a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C7327c mo43710a(Class<? extends C0105Y> clazz) {
        m44827e();
        return this.f42584f.mo23743a(clazz);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final C7327c mo43723d(String className) {
        m44827e();
        return this.f42584f.mo23744a(className);
    }

    /* renamed from: e */
    private void m44827e() {
        if (!mo43724d()) {
            throw new IllegalStateException("Attempt to use column index before set.");
        }
    }
}
