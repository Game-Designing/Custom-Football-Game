package p024io.realm;

import io.realm.RealmObjectSchema.FieldMetaData;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p024io.realm.internal.C7327c;
import p024io.realm.internal.Table;
import p024io.realm.internal.p156a.C7317c;
import p024io.realm.internal.p156a.C7317c.C7318a;

/* renamed from: io.realm.ba */
/* compiled from: RealmObjectSchema */
public class C14042ba {

    /* renamed from: a */
    private static final Map<Class<?>, C14044b> f42542a;

    /* renamed from: b */
    private static final Map<Class<?>, C14044b> f42543b;

    /* renamed from: c */
    private final C14054ea f42544c;

    /* renamed from: d */
    private final C14048d f42545d;

    /* renamed from: e */
    private final C7327c f42546e;

    /* renamed from: f */
    private final Table f42547f;

    /* renamed from: io.realm.ba$a */
    /* compiled from: RealmObjectSchema */
    private static final class C14043a extends C7327c {

        /* renamed from: c */
        private final Table f42548c;

        C14043a(Table table) {
            super((C7327c) null, false);
            this.f42548c = table;
        }

        /* renamed from: a */
        public long mo23758a(String columnName) {
            return this.f42548c.mo23656b(columnName);
        }

        /* renamed from: b */
        public RealmFieldType mo23763b(String columnName) {
            throw new UnsupportedOperationException("DynamicColumnIndices do not support 'getColumnType'");
        }

        /* renamed from: c */
        public String mo23764c(String columnName) {
            throw new UnsupportedOperationException("DynamicColumnIndices do not support 'getLinkedTable'");
        }

        /* renamed from: a */
        public void mo23760a(C7327c src) {
            throw new UnsupportedOperationException("DynamicColumnIndices cannot be copied");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C7327c mo23759a(boolean immutable) {
            throw new UnsupportedOperationException("DynamicColumnIndices cannot be copied");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo23761a(C7327c src, C7327c dst) {
            throw new UnsupportedOperationException("DynamicColumnIndices cannot copy");
        }
    }

    /* renamed from: io.realm.ba$b */
    /* compiled from: RealmObjectSchema */
    private static final class C14044b {

        /* renamed from: a */
        final RealmFieldType f42549a;

        /* renamed from: b */
        final boolean f42550b;

        C14044b(RealmFieldType realmType, boolean defaultNullable) {
            this.f42549a = realmType;
            this.f42550b = defaultNullable;
        }
    }

    /* renamed from: io.realm.ba$c */
    /* compiled from: RealmObjectSchema */
    public interface C14045c {
        /* renamed from: a */
        void mo11667a(C14065j jVar);
    }

    static {
        Map<Class<?>, FieldMetaData> m = new HashMap<>();
        m.put(String.class, new C14044b(RealmFieldType.STRING, true));
        m.put(Short.TYPE, new C14044b(RealmFieldType.INTEGER, false));
        m.put(Short.class, new C14044b(RealmFieldType.INTEGER, true));
        m.put(Integer.TYPE, new C14044b(RealmFieldType.INTEGER, false));
        m.put(Integer.class, new C14044b(RealmFieldType.INTEGER, true));
        m.put(Long.TYPE, new C14044b(RealmFieldType.INTEGER, false));
        m.put(Long.class, new C14044b(RealmFieldType.INTEGER, true));
        m.put(Float.TYPE, new C14044b(RealmFieldType.FLOAT, false));
        m.put(Float.class, new C14044b(RealmFieldType.FLOAT, true));
        m.put(Double.TYPE, new C14044b(RealmFieldType.DOUBLE, false));
        m.put(Double.class, new C14044b(RealmFieldType.DOUBLE, true));
        m.put(Boolean.TYPE, new C14044b(RealmFieldType.BOOLEAN, false));
        m.put(Boolean.class, new C14044b(RealmFieldType.BOOLEAN, true));
        m.put(Byte.TYPE, new C14044b(RealmFieldType.INTEGER, false));
        m.put(Byte.class, new C14044b(RealmFieldType.INTEGER, true));
        m.put(byte[].class, new C14044b(RealmFieldType.BINARY, true));
        m.put(Date.class, new C14044b(RealmFieldType.DATE, true));
        f42542a = Collections.unmodifiableMap(m);
        Map<Class<?>, FieldMetaData> m2 = new HashMap<>();
        m2.put(C0106Z.class, new C14044b(RealmFieldType.OBJECT, false));
        m2.put(C14014U.class, new C14044b(RealmFieldType.LIST, false));
        f42543b = Collections.unmodifiableMap(m2);
    }

    C14042ba(C14048d realm, C14054ea schema, Table table) {
        this(realm, schema, table, new C14043a(table));
    }

    C14042ba(C14048d realm, C14054ea schema, Table table, C7327c columnInfo) {
        this.f42544c = schema;
        this.f42545d = realm;
        this.f42547f = table;
        this.f42546e = columnInfo;
    }

    /* renamed from: a */
    public String mo43656a() {
        return this.f42547f.mo23659c();
    }

    /* renamed from: a */
    public C14042ba mo43653a(String fieldName, Class<?> fieldType, C14073m... attributes) {
        C14044b metadata = (C14044b) f42542a.get(fieldType);
        if (metadata != null) {
            m44727i(fieldName);
            boolean nullable = metadata.f42550b;
            if (m44722a(attributes, C14073m.REQUIRED)) {
                nullable = false;
            }
            long columnIndex = this.f42547f.mo23643a(metadata.f42549a, fieldName, nullable);
            try {
                m44721a(fieldName, attributes);
                return this;
            } catch (Exception e) {
                this.f42547f.mo23680n(columnIndex);
                throw e;
            }
        } else if (f42543b.containsKey(fieldType)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Use addRealmObjectField() instead to add fields that link to other RealmObjects: ");
            sb.append(fieldName);
            throw new IllegalArgumentException(sb.toString());
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "Realm doesn't support this field type: %s(%s)", new Object[]{fieldName, fieldType}));
        }
    }

    /* renamed from: e */
    public C14042ba mo43665e(String fieldName) {
        this.f42545d.mo43692f();
        m44726h(fieldName);
        if (mo43661c(fieldName)) {
            long columnIndex = m44728j(fieldName);
            if (this.f42547f.mo23666f() == columnIndex) {
                this.f42547f.mo23663d((String) null);
            }
            this.f42547f.mo23680n(columnIndex);
            return this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(fieldName);
        sb.append(" does not exist.");
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: c */
    public boolean mo43661c(String fieldName) {
        return this.f42547f.mo23656b(fieldName) != -1;
    }

    /* renamed from: a */
    public C14042ba mo43652a(String fieldName) {
        m44726h(fieldName);
        m44724f(fieldName);
        long columnIndex = m44728j(fieldName);
        if (!this.f42547f.mo23677k(columnIndex)) {
            this.f42547f.mo23645a(columnIndex);
            return this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(fieldName);
        sb.append(" already has an index.");
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: b */
    public C14042ba mo43657b(String fieldName) {
        m44726h(fieldName);
        m44724f(fieldName);
        if (!this.f42547f.mo23671h()) {
            this.f42547f.mo23663d(fieldName);
            long columnIndex = m44728j(fieldName);
            if (!this.f42547f.mo23677k(columnIndex)) {
                this.f42547f.mo23645a(columnIndex);
            }
            return this;
        }
        throw new IllegalStateException("A primary key is already defined");
    }

    /* renamed from: e */
    public C14042ba mo43664e() {
        this.f42545d.mo43692f();
        if (this.f42547f.mo23671h()) {
            long columnIndex = this.f42547f.mo23666f();
            if (this.f42547f.mo23677k(columnIndex)) {
                this.f42547f.mo23682o(columnIndex);
            }
            this.f42547f.mo23663d("");
            return this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(mo43656a());
        sb.append(" doesn't have a primary key.");
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: b */
    public C14042ba mo43658b(String fieldName, boolean required) {
        long columnIndex = this.f42547f.mo23656b(fieldName);
        boolean currentColumnRequired = mo43663d(fieldName);
        RealmFieldType type = this.f42547f.mo23668g(columnIndex);
        if (type == RealmFieldType.OBJECT) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot modify the required state for RealmObject references: ");
            sb.append(fieldName);
            throw new IllegalArgumentException(sb.toString());
        } else if (type == RealmFieldType.LIST) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot modify the required state for RealmList references: ");
            sb2.append(fieldName);
            throw new IllegalArgumentException(sb2.toString());
        } else if (required && currentColumnRequired) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Field is already required: ");
            sb3.append(fieldName);
            throw new IllegalStateException(sb3.toString());
        } else if (required || currentColumnRequired) {
            if (required) {
                this.f42547f.mo23658b(columnIndex);
            } else {
                this.f42547f.mo23660c(columnIndex);
            }
            return this;
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Field is already nullable: ");
            sb4.append(fieldName);
            throw new IllegalStateException(sb4.toString());
        }
    }

    /* renamed from: a */
    public C14042ba mo43654a(String fieldName, boolean nullable) {
        mo43658b(fieldName, !nullable);
        return this;
    }

    /* renamed from: d */
    public boolean mo43663d(String fieldName) {
        return !this.f42547f.mo23678l(m44728j(fieldName));
    }

    /* renamed from: d */
    public boolean mo43662d() {
        return this.f42547f.mo23671h();
    }

    /* renamed from: b */
    public String mo43659b() {
        if (this.f42547f.mo23671h()) {
            Table table = this.f42547f;
            return table.mo23667f(table.mo23666f());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(mo43656a());
        sb.append(" doesn't have a primary key.");
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public C14042ba mo43651a(C14045c function) {
        if (function != null) {
            long size = this.f42547f.mo23674j();
            for (long i = 0; i < size; i++) {
                function.mo11667a(new C14065j(this.f42545d, this.f42547f.mo23664e(i)));
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C7317c mo43655a(String fieldDescription, RealmFieldType... validColumnTypes) {
        return C7317c.m16060a((C7318a) m44723f(), mo43660c(), fieldDescription, validColumnTypes);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Table mo43660c() {
        return this.f42547f;
    }

    /* renamed from: f */
    private C14062ha m44723f() {
        return new C14062ha(this.f42544c);
    }

    /* renamed from: a */
    private void m44721a(String fieldName, C14073m[] attributes) {
        if (attributes != null) {
            try {
                if (attributes.length > 0) {
                    if (m44722a(attributes, C14073m.INDEXED)) {
                        mo43652a(fieldName);
                    }
                    if (m44722a(attributes, C14073m.PRIMARY_KEY)) {
                        mo43657b(fieldName);
                    }
                }
            } catch (Exception e) {
                long columnIndex = m44728j(fieldName);
                if (0 != 0) {
                    this.f42547f.mo23682o(columnIndex);
                }
                throw ((RuntimeException) e);
            }
        }
    }

    /* renamed from: a */
    private boolean m44722a(C14073m[] attributeList, C14073m attribute) {
        if (attributeList == null || attributeList.length == 0) {
            return false;
        }
        for (C14073m anAttributeList : attributeList) {
            if (anAttributeList == attribute) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    private void m44727i(String fieldName) {
        m44726h(fieldName);
        m44725g(fieldName);
    }

    /* renamed from: h */
    private void m44726h(String fieldName) {
        if (fieldName == null || fieldName.isEmpty()) {
            throw new IllegalArgumentException("Field name can not be null or empty");
        } else if (fieldName.contains(".")) {
            throw new IllegalArgumentException("Field name can not contain '.'");
        }
    }

    /* renamed from: g */
    private void m44725g(String fieldName) {
        if (this.f42547f.mo23656b(fieldName) != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Field already exists in '");
            sb.append(mo43656a());
            sb.append("': ");
            sb.append(fieldName);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: f */
    private void m44724f(String fieldName) {
        if (this.f42547f.mo23656b(fieldName) == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Field name doesn't exist on object '");
            sb.append(mo43656a());
            sb.append("': ");
            sb.append(fieldName);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: j */
    private long m44728j(String fieldName) {
        long columnIndex = this.f42547f.mo23656b(fieldName);
        if (columnIndex != -1) {
            return columnIndex;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Field name '%s' does not exist on schema for '%s'", new Object[]{fieldName, mo43656a()}));
    }
}
