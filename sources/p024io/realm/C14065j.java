package p024io.realm;

import java.util.Date;
import java.util.Locale;
import p024io.realm.internal.C7344p;
import p024io.realm.internal.C7347r;
import p024io.realm.internal.LinkView;
import p024io.realm.internal.Table;
import p024io.realm.internal.android.C7321c;

/* renamed from: io.realm.j */
/* compiled from: DynamicRealmObject */
public class C14065j extends C0106Z implements C7344p {

    /* renamed from: a */
    private final C13986D<C14065j> f42617a = new C13986D<>(this);

    C14065j(C14048d realm, C7347r row) {
        this.f42617a.mo43507a(realm);
        this.f42617a.mo43513b(row);
        this.f42617a.mo43520i();
    }

    /* renamed from: a */
    public int mo43738a(String fieldName) {
        return (int) mo43752b(fieldName);
    }

    /* renamed from: b */
    public long mo43752b(String fieldName) {
        this.f42617a.mo43514c().mo43690d();
        long columnIndex = this.f42617a.mo43515d().getColumnIndex(fieldName);
        try {
            return this.f42617a.mo43515d().mo23716h(columnIndex);
        } catch (IllegalArgumentException e) {
            m44891a(fieldName, columnIndex, RealmFieldType.INTEGER);
            throw e;
        }
    }

    /* renamed from: c */
    public String mo43753c(String fieldName) {
        this.f42617a.mo43514c().mo43690d();
        long columnIndex = this.f42617a.mo43515d().getColumnIndex(fieldName);
        try {
            return this.f42617a.mo43515d().mo23720m(columnIndex);
        } catch (IllegalArgumentException e) {
            m44891a(fieldName, columnIndex, RealmFieldType.STRING);
            throw e;
        }
    }

    /* renamed from: c */
    public String[] mo43754c() {
        this.f42617a.mo43514c().mo43690d();
        String[] keys = new String[((int) this.f42617a.mo43515d().getColumnCount())];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = this.f42617a.mo43515d().mo23718j((long) i);
        }
        return keys;
    }

    /* renamed from: a */
    public void mo43746a(String fieldName, Object value) {
        this.f42617a.mo43514c().mo43690d();
        boolean isString = value instanceof String;
        String strValue = isString ? (String) value : null;
        RealmFieldType type = this.f42617a.mo43515d().mo23721n(this.f42617a.mo43515d().getColumnIndex(fieldName));
        if (isString && type != RealmFieldType.STRING) {
            int i = C14063i.f42612a[type.ordinal()];
            if (i == 1) {
                value = Boolean.valueOf(Boolean.parseBoolean(strValue));
            } else if (i == 2) {
                value = Long.valueOf(Long.parseLong(strValue));
            } else if (i == 3) {
                value = Float.valueOf(Float.parseFloat(strValue));
            } else if (i == 4) {
                value = Double.valueOf(Double.parseDouble(strValue));
            } else if (i == 7) {
                value = C7321c.m16083a(strValue);
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Field %s is not a String field, and the provide value could not be automatically converted: %s. Use a typedsetter instead", new Object[]{fieldName, value}));
            }
        }
        if (value == null) {
            mo43755d(fieldName);
        } else {
            m44892b(fieldName, value);
        }
    }

    /* renamed from: b */
    private void m44892b(String fieldName, Object value) {
        Class<?> valueClass = value.getClass();
        if (valueClass == Boolean.class) {
            mo43750a(fieldName, ((Boolean) value).booleanValue());
        } else if (valueClass == Short.class) {
            mo43749a(fieldName, ((Short) value).shortValue());
        } else if (valueClass == Integer.class) {
            mo43742a(fieldName, ((Integer) value).intValue());
        } else if (valueClass == Long.class) {
            mo43743a(fieldName, ((Long) value).longValue());
        } else if (valueClass == Byte.class) {
            mo43739a(fieldName, ((Byte) value).byteValue());
        } else if (valueClass == Float.class) {
            mo43741a(fieldName, ((Float) value).floatValue());
        } else if (valueClass == Double.class) {
            mo43740a(fieldName, ((Double) value).doubleValue());
        } else if (valueClass == String.class) {
            mo43747a(fieldName, (String) value);
        } else if (value instanceof Date) {
            mo43748a(fieldName, (Date) value);
        } else if (value instanceof byte[]) {
            mo43751a(fieldName, (byte[]) value);
        } else if (valueClass == C14065j.class) {
            mo43745a(fieldName, (C14065j) value);
        } else if (valueClass == C14014U.class) {
            mo43744a(fieldName, (C14014U<C14065j>) (C14014U) value);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Value is of an type not supported: ");
            sb.append(value.getClass());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    public void mo43750a(String fieldName, boolean value) {
        this.f42617a.mo43514c().mo43690d();
        this.f42617a.mo43515d().mo23703a(this.f42617a.mo43515d().getColumnIndex(fieldName), value);
    }

    /* renamed from: a */
    public void mo43749a(String fieldName, short value) {
        this.f42617a.mo43514c().mo43690d();
        m44893e(fieldName);
        this.f42617a.mo43515d().mo23705b(this.f42617a.mo43515d().getColumnIndex(fieldName), (long) value);
    }

    /* renamed from: a */
    public void mo43742a(String fieldName, int value) {
        this.f42617a.mo43514c().mo43690d();
        m44893e(fieldName);
        this.f42617a.mo43515d().mo23705b(this.f42617a.mo43515d().getColumnIndex(fieldName), (long) value);
    }

    /* renamed from: a */
    public void mo43743a(String fieldName, long value) {
        this.f42617a.mo43514c().mo43690d();
        m44893e(fieldName);
        this.f42617a.mo43515d().mo23705b(this.f42617a.mo43515d().getColumnIndex(fieldName), value);
    }

    /* renamed from: a */
    public void mo43739a(String fieldName, byte value) {
        this.f42617a.mo43514c().mo43690d();
        m44893e(fieldName);
        this.f42617a.mo43515d().mo23705b(this.f42617a.mo43515d().getColumnIndex(fieldName), (long) value);
    }

    /* renamed from: a */
    public void mo43741a(String fieldName, float value) {
        this.f42617a.mo43514c().mo43690d();
        this.f42617a.mo43515d().mo23700a(this.f42617a.mo43515d().getColumnIndex(fieldName), value);
    }

    /* renamed from: a */
    public void mo43740a(String fieldName, double value) {
        this.f42617a.mo43514c().mo43690d();
        this.f42617a.mo43515d().mo23699a(this.f42617a.mo43515d().getColumnIndex(fieldName), value);
    }

    /* renamed from: a */
    public void mo43747a(String fieldName, String value) {
        this.f42617a.mo43514c().mo43690d();
        m44893e(fieldName);
        this.f42617a.mo43515d().setString(this.f42617a.mo43515d().getColumnIndex(fieldName), value);
    }

    /* renamed from: a */
    public void mo43751a(String fieldName, byte[] value) {
        this.f42617a.mo43514c().mo43690d();
        this.f42617a.mo43515d().mo23704a(this.f42617a.mo43515d().getColumnIndex(fieldName), value);
    }

    /* renamed from: a */
    public void mo43748a(String fieldName, Date value) {
        this.f42617a.mo43514c().mo43690d();
        long columnIndex = this.f42617a.mo43515d().getColumnIndex(fieldName);
        if (value == null) {
            this.f42617a.mo43515d().mo23512b(columnIndex);
        } else {
            this.f42617a.mo43515d().mo23702a(columnIndex, value);
        }
    }

    /* renamed from: a */
    public void mo43745a(String fieldName, C14065j value) {
        this.f42617a.mo43514c().mo43690d();
        long columnIndex = this.f42617a.mo43515d().getColumnIndex(fieldName);
        if (value == null) {
            this.f42617a.mo43515d().mo23719k(columnIndex);
        } else if (value.f42617a.mo43514c() == null || value.f42617a.mo43515d() == null) {
            throw new IllegalArgumentException("Cannot link to objects that are not part of the Realm.");
        } else if (this.f42617a.mo43514c() == value.f42617a.mo43514c()) {
            Table table = this.f42617a.mo43515d().mo23711f().mo23670h(columnIndex);
            Table inputTable = value.f42617a.mo43515d().mo23711f();
            if (table.mo23654a(inputTable)) {
                this.f42617a.mo43515d().mo23701a(columnIndex, value.f42617a.mo43515d().getIndex());
                return;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Type of object is wrong. Was %s, expected %s", new Object[]{inputTable.mo23665e(), table.mo23665e()}));
        } else {
            throw new IllegalArgumentException("Cannot add an object from another Realm instance.");
        }
    }

    /* renamed from: a */
    public void mo43744a(String fieldName, C14014U<C14065j> list) {
        boolean typeValidated;
        C14065j jVar = this;
        C14014U<C14065j> u = list;
        jVar.f42617a.mo43514c().mo43690d();
        if (u != null) {
            LinkView links = jVar.f42617a.mo43515d().mo23710f(jVar.f42617a.mo43515d().getColumnIndex(fieldName));
            Table linkTargetTable = links.mo23590b();
            String linkTargetTableName = linkTargetTable.mo23659c();
            if (u.f42480c == null && u.f42479b == null) {
                typeValidated = false;
            } else {
                String listType = u.f42480c;
                if (listType == null) {
                    listType = jVar.f42617a.mo43514c().mo43546v().mo43722c(u.f42479b).mo23659c();
                }
                if (linkTargetTableName.equals(listType)) {
                    typeValidated = true;
                } else {
                    throw new IllegalArgumentException(String.format(Locale.US, "The elements in the list are not the proper type. Was %s expected %s.", new Object[]{listType, linkTargetTableName}));
                }
            }
            int listLength = list.size();
            long[] indices = new long[listLength];
            int i = 0;
            while (i < listLength) {
                C7344p obj = (C7344p) u.get(i);
                if (obj.mo23791a().mo43514c() != jVar.f42617a.mo43514c()) {
                    throw new IllegalArgumentException("Each element in 'list' must belong to the same Realm instance.");
                } else if (typeValidated || linkTargetTable.mo23654a(obj.mo23791a().mo43515d().mo23711f())) {
                    indices[i] = obj.mo23791a().mo43515d().getIndex();
                    i++;
                    jVar = this;
                } else {
                    throw new IllegalArgumentException(String.format(Locale.US, "Element at index %d is not the proper type. Was '%s' expected '%s'.", new Object[]{Integer.valueOf(i), obj.mo23791a().mo43515d().mo23711f().mo23659c(), linkTargetTableName}));
                }
            }
            links.mo23586a();
            for (int i2 = 0; i2 < listLength; i2++) {
                links.mo23587a(indices[i2]);
            }
            return;
        }
        String str = fieldName;
        throw new IllegalArgumentException("Null values not allowed for lists");
    }

    /* renamed from: d */
    public void mo43755d(String fieldName) {
        this.f42617a.mo43514c().mo43690d();
        long columnIndex = this.f42617a.mo43515d().getColumnIndex(fieldName);
        if (this.f42617a.mo43515d().mo23721n(columnIndex) == RealmFieldType.OBJECT) {
            this.f42617a.mo43515d().mo23719k(columnIndex);
            return;
        }
        m44893e(fieldName);
        this.f42617a.mo43515d().mo23512b(columnIndex);
    }

    public String getType() {
        this.f42617a.mo43514c().mo43690d();
        return this.f42617a.mo43515d().mo23711f().mo23659c();
    }

    /* renamed from: a */
    private void m44891a(String fieldName, long columnIndex, RealmFieldType expectedType) {
        RealmFieldType columnType = this.f42617a.mo43515d().mo23721n(columnIndex);
        if (columnType != expectedType) {
            String expectedIndefiniteVowel = "";
            if (expectedType == RealmFieldType.INTEGER || expectedType == RealmFieldType.OBJECT) {
                expectedIndefiniteVowel = "n";
            }
            String columnTypeIndefiniteVowel = "";
            if (columnType == RealmFieldType.INTEGER || columnType == RealmFieldType.OBJECT) {
                columnTypeIndefiniteVowel = "n";
            }
            throw new IllegalArgumentException(String.format(Locale.US, "'%s' is not a%s '%s', but a%s '%s'.", new Object[]{fieldName, expectedIndefiniteVowel, expectedType, columnTypeIndefiniteVowel, columnType}));
        }
    }

    public int hashCode() {
        this.f42617a.mo43514c().mo43690d();
        String realmName = this.f42617a.mo43514c().mo43545j();
        String tableName = this.f42617a.mo43515d().mo23711f().mo23665e();
        long rowIndex = this.f42617a.mo43515d().getIndex();
        int i = 0;
        int result = ((17 * 31) + (realmName != null ? realmName.hashCode() : 0)) * 31;
        if (tableName != null) {
            i = tableName.hashCode();
        }
        return ((result + i) * 31) + ((int) ((rowIndex >>> 32) ^ rowIndex));
    }

    public boolean equals(Object o) {
        this.f42617a.mo43514c().mo43690d();
        boolean z = true;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        C14065j other = (C14065j) o;
        String path = this.f42617a.mo43514c().mo43545j();
        String otherPath = other.f42617a.mo43514c().mo43545j();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.f42617a.mo43515d().mo23711f().mo23665e();
        String otherTableName = other.f42617a.mo43515d().mo23711f().mo23665e();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.f42617a.mo43515d().getIndex() != other.f42617a.mo43515d().getIndex()) {
            z = false;
        }
        return z;
    }

    /* JADX WARNING: type inference failed for: r13v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r13v2, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r13v3, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r13v4, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r13v5, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r13v6, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r13v7, types: [java.lang.Float] */
    /* JADX WARNING: type inference failed for: r13v8, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r13v9, types: [java.lang.Double] */
    /* JADX WARNING: type inference failed for: r13v10, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r13v11, types: [java.util.Date] */
    /* JADX WARNING: type inference failed for: r13v12, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r13v13, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r13v15 */
    /* JADX WARNING: type inference failed for: r13v16 */
    /* JADX WARNING: type inference failed for: r13v17 */
    /* JADX WARNING: type inference failed for: r13v18 */
    /* JADX WARNING: type inference failed for: r13v19 */
    /* JADX WARNING: type inference failed for: r13v20 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r13v1, types: [java.lang.String]
      assigns: [java.lang.String, java.lang.Long, java.lang.Boolean, java.lang.Float, java.lang.Double, java.util.Date]
      uses: [java.lang.Object, java.lang.String]
      mth insns count: 141
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r17 = this;
            r0 = r17
            io.realm.D<io.realm.j> r1 = r0.f42617a
            io.realm.d r1 = r1.mo43514c()
            r1.mo43690d()
            io.realm.D<io.realm.j> r1 = r0.f42617a
            io.realm.internal.r r1 = r1.mo43515d()
            boolean r1 = r1.mo23709e()
            if (r1 != 0) goto L_0x001a
            java.lang.String r1 = "Invalid object"
            return r1
        L_0x001a:
            io.realm.D<io.realm.j> r1 = r0.f42617a
            io.realm.internal.r r1 = r1.mo43515d()
            io.realm.internal.Table r1 = r1.mo23711f()
            java.lang.String r1 = r1.mo23659c()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r4 = " = dynamic["
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            java.lang.String[] r3 = r17.mo43754c()
            int r4 = r3.length
            r5 = 0
            r6 = 0
        L_0x0045:
            r7 = 1
            if (r6 >= r4) goto L_0x019e
            r8 = r3[r6]
            io.realm.D<io.realm.j> r9 = r0.f42617a
            io.realm.internal.r r9 = r9.mo43515d()
            long r9 = r9.getColumnIndex(r8)
            io.realm.D<io.realm.j> r11 = r0.f42617a
            io.realm.internal.r r11 = r11.mo43515d()
            io.realm.RealmFieldType r11 = r11.mo23721n(r9)
            java.lang.String r12 = "{"
            r2.append(r12)
            r2.append(r8)
            java.lang.String r12 = ":"
            r2.append(r12)
            int[] r12 = p024io.realm.C14063i.f42612a
            int r13 = r11.ordinal()
            r12 = r12[r13]
            java.lang.String r13 = "null"
            switch(r12) {
                case 1: goto L_0x0176;
                case 2: goto L_0x0157;
                case 3: goto L_0x0138;
                case 4: goto L_0x0119;
                case 5: goto L_0x010a;
                case 6: goto L_0x00f7;
                case 7: goto L_0x00db;
                case 8: goto L_0x00b7;
                case 9: goto L_0x007f;
                default: goto L_0x0078;
            }
        L_0x0078:
            java.lang.String r7 = "?"
            r2.append(r7)
            goto L_0x0195
        L_0x007f:
            io.realm.D<io.realm.j> r12 = r0.f42617a
            io.realm.internal.r r12 = r12.mo43515d()
            io.realm.internal.Table r12 = r12.mo23711f()
            io.realm.internal.Table r12 = r12.mo23670h(r9)
            java.lang.String r12 = r12.mo23659c()
            java.util.Locale r13 = java.util.Locale.US
            r14 = 2
            java.lang.Object[] r14 = new java.lang.Object[r14]
            r14[r5] = r12
            io.realm.D<io.realm.j> r15 = r0.f42617a
            io.realm.internal.r r15 = r15.mo43515d()
            io.realm.internal.LinkView r15 = r15.mo23710f(r9)
            long r15 = r15.mo23594d()
            java.lang.Long r15 = java.lang.Long.valueOf(r15)
            r14[r7] = r15
            java.lang.String r7 = "RealmList<%s>[%s]"
            java.lang.String r7 = java.lang.String.format(r13, r7, r14)
            r2.append(r7)
            goto L_0x0195
        L_0x00b7:
            io.realm.D<io.realm.j> r7 = r0.f42617a
            io.realm.internal.r r7 = r7.mo43515d()
            boolean r7 = r7.mo23513l(r9)
            if (r7 == 0) goto L_0x00c4
            goto L_0x00d6
        L_0x00c4:
            io.realm.D<io.realm.j> r7 = r0.f42617a
            io.realm.internal.r r7 = r7.mo43515d()
            io.realm.internal.Table r7 = r7.mo23711f()
            io.realm.internal.Table r7 = r7.mo23670h(r9)
            java.lang.String r13 = r7.mo23659c()
        L_0x00d6:
            r2.append(r13)
            goto L_0x0195
        L_0x00db:
            io.realm.D<io.realm.j> r7 = r0.f42617a
            io.realm.internal.r r7 = r7.mo43515d()
            boolean r7 = r7.mo23511a(r9)
            if (r7 == 0) goto L_0x00e8
            goto L_0x00f2
        L_0x00e8:
            io.realm.D<io.realm.j> r7 = r0.f42617a
            io.realm.internal.r r7 = r7.mo43515d()
            java.util.Date r13 = r7.mo23717i(r9)
        L_0x00f2:
            r2.append(r13)
            goto L_0x0195
        L_0x00f7:
            io.realm.D<io.realm.j> r7 = r0.f42617a
            io.realm.internal.r r7 = r7.mo43515d()
            byte[] r7 = r7.mo23706c(r9)
            java.lang.String r7 = java.util.Arrays.toString(r7)
            r2.append(r7)
            goto L_0x0195
        L_0x010a:
            io.realm.D<io.realm.j> r7 = r0.f42617a
            io.realm.internal.r r7 = r7.mo43515d()
            java.lang.String r7 = r7.mo23720m(r9)
            r2.append(r7)
            goto L_0x0195
        L_0x0119:
            io.realm.D<io.realm.j> r7 = r0.f42617a
            io.realm.internal.r r7 = r7.mo43515d()
            boolean r7 = r7.mo23511a(r9)
            if (r7 == 0) goto L_0x0126
            goto L_0x0134
        L_0x0126:
            io.realm.D<io.realm.j> r7 = r0.f42617a
            io.realm.internal.r r7 = r7.mo43515d()
            double r12 = r7.mo23707d(r9)
            java.lang.Double r13 = java.lang.Double.valueOf(r12)
        L_0x0134:
            r2.append(r13)
            goto L_0x0195
        L_0x0138:
            io.realm.D<io.realm.j> r7 = r0.f42617a
            io.realm.internal.r r7 = r7.mo43515d()
            boolean r7 = r7.mo23511a(r9)
            if (r7 == 0) goto L_0x0145
            goto L_0x0153
        L_0x0145:
            io.realm.D<io.realm.j> r7 = r0.f42617a
            io.realm.internal.r r7 = r7.mo43515d()
            float r7 = r7.mo23708e(r9)
            java.lang.Float r13 = java.lang.Float.valueOf(r7)
        L_0x0153:
            r2.append(r13)
            goto L_0x0195
        L_0x0157:
            io.realm.D<io.realm.j> r7 = r0.f42617a
            io.realm.internal.r r7 = r7.mo43515d()
            boolean r7 = r7.mo23511a(r9)
            if (r7 == 0) goto L_0x0164
            goto L_0x0172
        L_0x0164:
            io.realm.D<io.realm.j> r7 = r0.f42617a
            io.realm.internal.r r7 = r7.mo43515d()
            long r12 = r7.mo23716h(r9)
            java.lang.Long r13 = java.lang.Long.valueOf(r12)
        L_0x0172:
            r2.append(r13)
            goto L_0x0195
        L_0x0176:
            io.realm.D<io.realm.j> r7 = r0.f42617a
            io.realm.internal.r r7 = r7.mo43515d()
            boolean r7 = r7.mo23511a(r9)
            if (r7 == 0) goto L_0x0183
            goto L_0x0191
        L_0x0183:
            io.realm.D<io.realm.j> r7 = r0.f42617a
            io.realm.internal.r r7 = r7.mo43515d()
            boolean r7 = r7.mo23712g(r9)
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r7)
        L_0x0191:
            r2.append(r13)
        L_0x0195:
            java.lang.String r7 = "},"
            r2.append(r7)
            int r6 = r6 + 1
            goto L_0x0045
        L_0x019e:
            int r4 = r2.length()
            int r4 = r4 - r7
            int r5 = r2.length()
            java.lang.String r6 = ""
            r2.replace(r4, r5, r6)
            java.lang.String r4 = "]"
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p024io.realm.C14065j.toString():java.lang.String");
    }

    /* renamed from: b */
    public void mo23792b() {
    }

    /* renamed from: a */
    public C13986D mo23791a() {
        return this.f42617a;
    }

    /* renamed from: e */
    private void m44893e(String fieldName) {
        C14042ba objectSchema = this.f42617a.mo43514c().mo43546v().mo43725e(getType());
        if (objectSchema.mo43662d() && objectSchema.mo43659b().equals(fieldName)) {
            throw new IllegalArgumentException(String.format(Locale.US, "Primary key field '%s' cannot be changed after object was created.", new Object[]{fieldName}));
        }
    }
}
