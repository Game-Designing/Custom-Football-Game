package p024io.realm;

import com.unity3d.services.purchasing.core.TransactionDetailsUtilities;
import io.realm.internal.RealmObjectProxy.CacheData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.database.realm.RealmAuthorization;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;
import p024io.realm.C14048d.C14050b;
import p024io.realm.exceptions.RealmException;
import p024io.realm.exceptions.RealmMigrationNeededException;
import p024io.realm.internal.C7327c;
import p024io.realm.internal.C7344p;
import p024io.realm.internal.C7344p.C7345a;
import p024io.realm.internal.C7347r;
import p024io.realm.internal.OsObject;
import p024io.realm.internal.OsObjectSchemaInfo;
import p024io.realm.internal.OsObjectSchemaInfo.C7309a;
import p024io.realm.internal.SharedRealm;
import p024io.realm.internal.Table;
import p024io.realm.log.RealmLog;

/* renamed from: io.realm.G */
/* compiled from: RealmAuthorizationRealmProxy */
public class C13992G extends RealmAuthorization implements C7344p, C13994H {

    /* renamed from: a */
    private static final OsObjectSchemaInfo f42377a = m44555e();

    /* renamed from: b */
    private static final List<String> f42378b;

    /* renamed from: c */
    private C13993a f42379c;

    /* renamed from: d */
    private C13986D<RealmAuthorization> f42380d;

    /* renamed from: io.realm.G$a */
    /* compiled from: RealmAuthorizationRealmProxy */
    static final class C13993a extends C7327c {

        /* renamed from: c */
        long f42381c;

        /* renamed from: d */
        long f42382d;

        /* renamed from: e */
        long f42383e;

        /* renamed from: f */
        long f42384f;

        /* renamed from: g */
        long f42385g;

        /* renamed from: h */
        long f42386h;

        /* renamed from: i */
        long f42387i;

        /* renamed from: j */
        long f42388j;

        /* renamed from: k */
        long f42389k;

        /* renamed from: l */
        long f42390l;

        C13993a(SharedRealm realm, Table table) {
            super(10);
            this.f42381c = mo23757a(table, "id", RealmFieldType.STRING);
            this.f42382d = mo23757a(table, "customerId", RealmFieldType.STRING);
            this.f42383e = mo23757a(table, "status", RealmFieldType.STRING);
            this.f42384f = mo23757a(table, "type", RealmFieldType.STRING);
            this.f42385g = mo23757a(table, "metadata", RealmFieldType.STRING);
            this.f42386h = mo23757a(table, TransactionDetailsUtilities.TRANSACTION_ID, RealmFieldType.STRING);
            this.f42387i = mo23757a(table, Repo.COLUMN_DESCRIPTION, RealmFieldType.STRING);
            this.f42388j = mo23757a(table, "amount", RealmFieldType.DOUBLE);
            this.f42389k = mo23757a(table, "currency", RealmFieldType.STRING);
            this.f42390l = mo23757a(table, "currencySymbol", RealmFieldType.STRING);
        }

        C13993a(C7327c src, boolean mutable) {
            super(src, mutable);
            mo23761a(src, this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final C7327c mo23759a(boolean mutable) {
            return new C13993a((C7327c) this, mutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo23761a(C7327c rawSrc, C7327c rawDst) {
            C13993a src = (C13993a) rawSrc;
            C13993a dst = (C13993a) rawDst;
            dst.f42381c = src.f42381c;
            dst.f42382d = src.f42382d;
            dst.f42383e = src.f42383e;
            dst.f42384f = src.f42384f;
            dst.f42385g = src.f42385g;
            dst.f42386h = src.f42386h;
            dst.f42387i = src.f42387i;
            dst.f42388j = src.f42388j;
            dst.f42389k = src.f42389k;
            dst.f42390l = src.f42390l;
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("id");
        fieldNames.add("customerId");
        fieldNames.add("status");
        fieldNames.add("type");
        fieldNames.add("metadata");
        fieldNames.add(TransactionDetailsUtilities.TRANSACTION_ID);
        fieldNames.add(Repo.COLUMN_DESCRIPTION);
        fieldNames.add("amount");
        fieldNames.add("currency");
        fieldNames.add("currencySymbol");
        f42378b = Collections.unmodifiableList(fieldNames);
    }

    C13992G() {
        this.f42380d.mo43520i();
    }

    /* renamed from: b */
    public void mo23792b() {
        if (this.f42380d == null) {
            C14050b context = (C14050b) C14048d.f42564c.get();
            this.f42379c = (C13993a) context.mo43700c();
            this.f42380d = new C13986D<>(this);
            this.f42380d.mo43507a(context.mo43702e());
            this.f42380d.mo43513b(context.mo43703f());
            this.f42380d.mo43509a(context.mo43699b());
            this.f42380d.mo43508a(context.mo43701d());
        }
    }

    public String realmGet$id() {
        this.f42380d.mo43514c().mo43690d();
        return this.f42380d.mo43515d().mo23720m(this.f42379c.f42381c);
    }

    public void realmSet$id(String value) {
        if (!this.f42380d.mo43517f()) {
            this.f42380d.mo43514c().mo43690d();
            throw new RealmException("Primary key field 'id' cannot be changed after object was created.");
        }
    }

    public String realmGet$customerId() {
        this.f42380d.mo43514c().mo43690d();
        return this.f42380d.mo43515d().mo23720m(this.f42379c.f42382d);
    }

    public void realmSet$customerId(String value) {
        String str = "Trying to set non-nullable field 'customerId' to null.";
        if (!this.f42380d.mo43517f()) {
            this.f42380d.mo43514c().mo43690d();
            if (value != null) {
                this.f42380d.mo43515d().setString(this.f42379c.f42382d, value);
                return;
            }
            throw new IllegalArgumentException(str);
        } else if (this.f42380d.mo43510a()) {
            C7347r row = this.f42380d.mo43515d();
            if (value != null) {
                row.mo23711f().mo23651a(this.f42379c.f42382d, row.getIndex(), value, true);
                return;
            }
            throw new IllegalArgumentException(str);
        }
    }

    public String realmGet$status() {
        this.f42380d.mo43514c().mo43690d();
        return this.f42380d.mo43515d().mo23720m(this.f42379c.f42383e);
    }

    public void realmSet$status(String value) {
        String str = "Trying to set non-nullable field 'status' to null.";
        if (!this.f42380d.mo43517f()) {
            this.f42380d.mo43514c().mo43690d();
            if (value != null) {
                this.f42380d.mo43515d().setString(this.f42379c.f42383e, value);
                return;
            }
            throw new IllegalArgumentException(str);
        } else if (this.f42380d.mo43510a()) {
            C7347r row = this.f42380d.mo43515d();
            if (value != null) {
                row.mo23711f().mo23651a(this.f42379c.f42383e, row.getIndex(), value, true);
                return;
            }
            throw new IllegalArgumentException(str);
        }
    }

    public String realmGet$type() {
        this.f42380d.mo43514c().mo43690d();
        return this.f42380d.mo43515d().mo23720m(this.f42379c.f42384f);
    }

    public void realmSet$type(String value) {
        String str = "Trying to set non-nullable field 'type' to null.";
        if (!this.f42380d.mo43517f()) {
            this.f42380d.mo43514c().mo43690d();
            if (value != null) {
                this.f42380d.mo43515d().setString(this.f42379c.f42384f, value);
                return;
            }
            throw new IllegalArgumentException(str);
        } else if (this.f42380d.mo43510a()) {
            C7347r row = this.f42380d.mo43515d();
            if (value != null) {
                row.mo23711f().mo23651a(this.f42379c.f42384f, row.getIndex(), value, true);
                return;
            }
            throw new IllegalArgumentException(str);
        }
    }

    public String realmGet$metadata() {
        this.f42380d.mo43514c().mo43690d();
        return this.f42380d.mo43515d().mo23720m(this.f42379c.f42385g);
    }

    public void realmSet$metadata(String value) {
        String str = "Trying to set non-nullable field 'metadata' to null.";
        if (!this.f42380d.mo43517f()) {
            this.f42380d.mo43514c().mo43690d();
            if (value != null) {
                this.f42380d.mo43515d().setString(this.f42379c.f42385g, value);
                return;
            }
            throw new IllegalArgumentException(str);
        } else if (this.f42380d.mo43510a()) {
            C7347r row = this.f42380d.mo43515d();
            if (value != null) {
                row.mo23711f().mo23651a(this.f42379c.f42385g, row.getIndex(), value, true);
                return;
            }
            throw new IllegalArgumentException(str);
        }
    }

    public String realmGet$transactionId() {
        this.f42380d.mo43514c().mo43690d();
        return this.f42380d.mo43515d().mo23720m(this.f42379c.f42386h);
    }

    public void realmSet$transactionId(String value) {
        String str = "Trying to set non-nullable field 'transactionId' to null.";
        if (!this.f42380d.mo43517f()) {
            this.f42380d.mo43514c().mo43690d();
            if (value != null) {
                this.f42380d.mo43515d().setString(this.f42379c.f42386h, value);
                return;
            }
            throw new IllegalArgumentException(str);
        } else if (this.f42380d.mo43510a()) {
            C7347r row = this.f42380d.mo43515d();
            if (value != null) {
                row.mo23711f().mo23651a(this.f42379c.f42386h, row.getIndex(), value, true);
                return;
            }
            throw new IllegalArgumentException(str);
        }
    }

    public String realmGet$description() {
        this.f42380d.mo43514c().mo43690d();
        return this.f42380d.mo43515d().mo23720m(this.f42379c.f42387i);
    }

    public void realmSet$description(String value) {
        if (!this.f42380d.mo43517f()) {
            this.f42380d.mo43514c().mo43690d();
            if (value == null) {
                this.f42380d.mo43515d().mo23512b(this.f42379c.f42387i);
            } else {
                this.f42380d.mo43515d().setString(this.f42379c.f42387i, value);
            }
        } else if (this.f42380d.mo43510a()) {
            C7347r row = this.f42380d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42379c.f42387i, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42379c.f42387i, row.getIndex(), value, true);
            }
        }
    }

    public double realmGet$amount() {
        this.f42380d.mo43514c().mo43690d();
        return this.f42380d.mo43515d().mo23707d(this.f42379c.f42388j);
    }

    public void realmSet$amount(double value) {
        if (!this.f42380d.mo43517f()) {
            this.f42380d.mo43514c().mo43690d();
            this.f42380d.mo43515d().mo23699a(this.f42379c.f42388j, value);
        } else if (this.f42380d.mo43510a()) {
            C7347r row = this.f42380d.mo43515d();
            row.mo23711f().mo23647a(this.f42379c.f42388j, row.getIndex(), value, true);
        }
    }

    public String realmGet$currency() {
        this.f42380d.mo43514c().mo43690d();
        return this.f42380d.mo43515d().mo23720m(this.f42379c.f42389k);
    }

    public void realmSet$currency(String value) {
        if (!this.f42380d.mo43517f()) {
            this.f42380d.mo43514c().mo43690d();
            if (value == null) {
                this.f42380d.mo43515d().mo23512b(this.f42379c.f42389k);
            } else {
                this.f42380d.mo43515d().setString(this.f42379c.f42389k, value);
            }
        } else if (this.f42380d.mo43510a()) {
            C7347r row = this.f42380d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42379c.f42389k, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42379c.f42389k, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$currencySymbol() {
        this.f42380d.mo43514c().mo43690d();
        return this.f42380d.mo43515d().mo23720m(this.f42379c.f42390l);
    }

    public void realmSet$currencySymbol(String value) {
        if (!this.f42380d.mo43517f()) {
            this.f42380d.mo43514c().mo43690d();
            if (value == null) {
                this.f42380d.mo43515d().mo23512b(this.f42379c.f42390l);
            } else {
                this.f42380d.mo43515d().setString(this.f42379c.f42390l, value);
            }
        } else if (this.f42380d.mo43510a()) {
            C7347r row = this.f42380d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42379c.f42390l, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42379c.f42390l, row.getIndex(), value, true);
            }
        }
    }

    /* renamed from: e */
    private static OsObjectSchemaInfo m44555e() {
        C7309a builder = new C7309a("RealmAuthorization");
        builder.mo23605a("id", RealmFieldType.STRING, true, true, false);
        C7309a aVar = builder;
        aVar.mo23605a("customerId", RealmFieldType.STRING, false, false, true);
        C7309a aVar2 = builder;
        aVar2.mo23605a("status", RealmFieldType.STRING, false, false, true);
        C7309a aVar3 = builder;
        aVar3.mo23605a("type", RealmFieldType.STRING, false, false, true);
        aVar2.mo23605a("metadata", RealmFieldType.STRING, false, false, true);
        aVar3.mo23605a(TransactionDetailsUtilities.TRANSACTION_ID, RealmFieldType.STRING, false, false, true);
        aVar2.mo23605a(Repo.COLUMN_DESCRIPTION, RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("amount", RealmFieldType.DOUBLE, false, false, true);
        aVar2.mo23605a("currency", RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("currencySymbol", RealmFieldType.STRING, false, false, false);
        return builder.mo23606a();
    }

    /* renamed from: c */
    public static OsObjectSchemaInfo m44553c() {
        return f42377a;
    }

    /* renamed from: a */
    public static C13993a m44550a(SharedRealm sharedRealm, boolean allowExtraColumns) {
        String str = "class_RealmAuthorization";
        if (sharedRealm.mo23625c(str)) {
            Table table = sharedRealm.mo23622b(str);
            long columnCount = table.mo23661d();
            if (columnCount != 10) {
                if (columnCount < 10) {
                    String f = sharedRealm.mo23630f();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Field count is less than expected - expected 10 but was ");
                    sb.append(columnCount);
                    throw new RealmMigrationNeededException(f, sb.toString());
                } else if (allowExtraColumns) {
                    RealmLog.m16234a("Field count is more than expected - expected 10 but was %1$d", Long.valueOf(columnCount));
                } else {
                    String f2 = sharedRealm.mo23630f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Field count is more than expected - expected 10 but was ");
                    sb2.append(columnCount);
                    throw new RealmMigrationNeededException(f2, sb2.toString());
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.mo23667f(i), table.mo23668g(i));
            }
            C13993a columnInfo = new C13993a(sharedRealm, table);
            if (!table.mo23671h()) {
                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
            } else if (table.mo23666f() == columnInfo.f42381c) {
                String str2 = "id";
                if (!columnTypes.containsKey(str2)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                } else if (columnTypes.get(str2) != RealmFieldType.STRING) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'id' in existing Realm file.");
                } else if (!table.mo23678l(columnInfo.f42381c)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "@PrimaryKey field 'id' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
                } else if (table.mo23677k(table.mo23656b(str2))) {
                    String str3 = "customerId";
                    if (!columnTypes.containsKey(str3)) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'customerId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (columnTypes.get(str3) != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'customerId' in existing Realm file.");
                    } else if (!table.mo23678l(columnInfo.f42382d)) {
                        String str4 = "status";
                        if (!columnTypes.containsKey(str4)) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'status' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                        } else if (columnTypes.get(str4) != RealmFieldType.STRING) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'status' in existing Realm file.");
                        } else if (!table.mo23678l(columnInfo.f42383e)) {
                            String str5 = "type";
                            if (!columnTypes.containsKey(str5)) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'type' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                            } else if (columnTypes.get(str5) != RealmFieldType.STRING) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'type' in existing Realm file.");
                            } else if (!table.mo23678l(columnInfo.f42384f)) {
                                String str6 = "metadata";
                                if (!columnTypes.containsKey(str6)) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'metadata' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                } else if (columnTypes.get(str6) != RealmFieldType.STRING) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'metadata' in existing Realm file.");
                                } else if (!table.mo23678l(columnInfo.f42385g)) {
                                    String str7 = TransactionDetailsUtilities.TRANSACTION_ID;
                                    if (!columnTypes.containsKey(str7)) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'transactionId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                    } else if (columnTypes.get(str7) != RealmFieldType.STRING) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'transactionId' in existing Realm file.");
                                    } else if (!table.mo23678l(columnInfo.f42386h)) {
                                        String str8 = Repo.COLUMN_DESCRIPTION;
                                        if (!columnTypes.containsKey(str8)) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'description' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                        } else if (columnTypes.get(str8) != RealmFieldType.STRING) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'description' in existing Realm file.");
                                        } else if (table.mo23678l(columnInfo.f42387i)) {
                                            String str9 = "amount";
                                            if (!columnTypes.containsKey(str9)) {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'amount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                            } else if (columnTypes.get(str9) != RealmFieldType.DOUBLE) {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'double' for field 'amount' in existing Realm file.");
                                            } else if (!table.mo23678l(columnInfo.f42388j)) {
                                                String str10 = "currency";
                                                if (!columnTypes.containsKey(str10)) {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'currency' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                } else if (columnTypes.get(str10) != RealmFieldType.STRING) {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'currency' in existing Realm file.");
                                                } else if (table.mo23678l(columnInfo.f42389k)) {
                                                    String str11 = "currencySymbol";
                                                    if (!columnTypes.containsKey(str11)) {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'currencySymbol' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                    } else if (columnTypes.get(str11) != RealmFieldType.STRING) {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'currencySymbol' in existing Realm file.");
                                                    } else if (table.mo23678l(columnInfo.f42390l)) {
                                                        return columnInfo;
                                                    } else {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'currencySymbol' is required. Either set @Required to field 'currencySymbol' or migrate using RealmObjectSchema.setNullable().");
                                                    }
                                                } else {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'currency' is required. Either set @Required to field 'currency' or migrate using RealmObjectSchema.setNullable().");
                                                }
                                            } else {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'amount' does support null values in the existing Realm file. Use corresponding boxed type for field 'amount' or migrate using RealmObjectSchema.setNullable().");
                                            }
                                        } else {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'description' is required. Either set @Required to field 'description' or migrate using RealmObjectSchema.setNullable().");
                                        }
                                    } else {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'transactionId' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'transactionId' or migrate using RealmObjectSchema.setNullable().");
                                    }
                                } else {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'metadata' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'metadata' or migrate using RealmObjectSchema.setNullable().");
                                }
                            } else {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'type' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'type' or migrate using RealmObjectSchema.setNullable().");
                            }
                        } else {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'status' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'status' or migrate using RealmObjectSchema.setNullable().");
                        }
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'customerId' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'customerId' or migrate using RealmObjectSchema.setNullable().");
                    }
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
                }
            } else {
                String f3 = sharedRealm.mo23630f();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Primary Key annotation definition was changed, from field ");
                sb3.append(table.mo23667f(table.mo23666f()));
                sb3.append(" to field id");
                throw new RealmMigrationNeededException(f3, sb3.toString());
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "The 'RealmAuthorization' class is missing from the schema for this Realm.");
        }
    }

    /* renamed from: d */
    public static String m44554d() {
        return "class_RealmAuthorization";
    }

    /* renamed from: b */
    public static RealmAuthorization m44552b(C13990F realm, RealmAuthorization object, boolean update, Map<C0105Y, C7344p> cache) {
        long rowIndex;
        C13990F f = realm;
        RealmAuthorization realmAuthorization = object;
        Map<C0105Y, C7344p> map = cache;
        if ((realmAuthorization instanceof C7344p) && ((C7344p) realmAuthorization).mo23791a().mo43514c() != null && ((C7344p) realmAuthorization).mo23791a().mo43514c().f42565d != f.f42565d) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((realmAuthorization instanceof C7344p) && ((C7344p) realmAuthorization).mo23791a().mo43514c() != null && ((C7344p) realmAuthorization).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return realmAuthorization;
        } else {
            C14050b objectContext = (C14050b) C14048d.f42564c.get();
            C7344p cachedRealmObject = (C7344p) map.get(realmAuthorization);
            if (cachedRealmObject != null) {
                return (RealmAuthorization) cachedRealmObject;
            }
            RealmAuthorization realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = f.mo43537b(RealmAuthorization.class);
                long pkColumnIndex = table.mo23666f();
                String value = object.realmGet$id();
                if (value == null) {
                    rowIndex = table.mo23662d(pkColumnIndex);
                } else {
                    rowIndex = table.mo23641a(pkColumnIndex, value);
                }
                if (rowIndex != -1) {
                    try {
                        long j = rowIndex;
                        long j2 = pkColumnIndex;
                        try {
                            objectContext.mo43698a(realm, table.mo23672i(rowIndex), f.f42569h.mo43710a(RealmAuthorization.class), false, Collections.emptyList());
                            realmObject = new C13992G();
                            map.put(realmAuthorization, realmObject);
                            objectContext.mo43697a();
                        } catch (Throwable th) {
                            th = th;
                            objectContext.mo43697a();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        long j3 = rowIndex;
                        long j4 = pkColumnIndex;
                        objectContext.mo43697a();
                        throw th;
                    }
                } else {
                    long j5 = pkColumnIndex;
                    canUpdate = false;
                }
            }
            if (!canUpdate) {
                return m44549a(realm, object, update, cache);
            }
            m44548a(f, realmObject, realmAuthorization, map);
            return realmObject;
        }
    }

    /* renamed from: a */
    public static RealmAuthorization m44549a(C13990F realm, RealmAuthorization newObject, boolean update, Map<C0105Y, C7344p> cache) {
        C7344p cachedRealmObject = (C7344p) cache.get(newObject);
        if (cachedRealmObject != null) {
            return (RealmAuthorization) cachedRealmObject;
        }
        RealmAuthorization realmObject = (RealmAuthorization) realm.mo43528a(RealmAuthorization.class, newObject.realmGet$id(), false, Collections.emptyList());
        cache.put(newObject, (C7344p) realmObject);
        C13994H realmObjectSource = newObject;
        RealmAuthorization realmAuthorization = realmObject;
        realmAuthorization.realmSet$customerId(realmObjectSource.realmGet$customerId());
        realmAuthorization.realmSet$status(realmObjectSource.realmGet$status());
        realmAuthorization.realmSet$type(realmObjectSource.realmGet$type());
        realmAuthorization.realmSet$metadata(realmObjectSource.realmGet$metadata());
        realmAuthorization.realmSet$transactionId(realmObjectSource.realmGet$transactionId());
        realmAuthorization.realmSet$description(realmObjectSource.realmGet$description());
        realmAuthorization.realmSet$amount(realmObjectSource.realmGet$amount());
        realmAuthorization.realmSet$currency(realmObjectSource.realmGet$currency());
        realmAuthorization.realmSet$currencySymbol(realmObjectSource.realmGet$currencySymbol());
        return realmObject;
    }

    /* renamed from: a */
    public static long m44546a(C13990F realm, RealmAuthorization object, Map<C0105Y, Long> cache) {
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        RealmAuthorization realmAuthorization = object;
        if ((realmAuthorization instanceof C7344p) && ((C7344p) realmAuthorization).mo23791a().mo43514c() != null && ((C7344p) realmAuthorization).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return ((C7344p) realmAuthorization).mo23791a().mo43515d().getIndex();
        }
        Table table = f.mo43537b(RealmAuthorization.class);
        long tableNativePtr = table.getNativePtr();
        C13993a columnInfo = (C13993a) f.f42569h.mo43710a(RealmAuthorization.class);
        long pkColumnIndex = table.mo23666f();
        String primaryKeyValue = object.realmGet$id();
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == -1) {
            rowIndex2 = OsObject.m15909a(table, (Object) primaryKeyValue);
        } else {
            rowIndex2 = rowIndex;
        }
        cache.put(realmAuthorization, Long.valueOf(rowIndex2));
        String realmGet$customerId = object.realmGet$customerId();
        if (realmGet$customerId != null) {
            long j = pkColumnIndex;
            Table.nativeSetString(tableNativePtr, columnInfo.f42382d, rowIndex2, realmGet$customerId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42382d, rowIndex2, false);
        }
        String realmGet$status = object.realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42383e, rowIndex2, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42383e, rowIndex2, false);
        }
        String realmGet$type = object.realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42384f, rowIndex2, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42384f, rowIndex2, false);
        }
        String realmGet$metadata = object.realmGet$metadata();
        if (realmGet$metadata != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42385g, rowIndex2, realmGet$metadata, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42385g, rowIndex2, false);
        }
        String realmGet$transactionId = object.realmGet$transactionId();
        if (realmGet$transactionId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42386h, rowIndex2, realmGet$transactionId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42386h, rowIndex2, false);
        }
        String realmGet$description = object.realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42387i, rowIndex2, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42387i, rowIndex2, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.f42388j, rowIndex2, object.realmGet$amount(), false);
        String realmGet$currency = object.realmGet$currency();
        if (realmGet$currency != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42389k, rowIndex2, realmGet$currency, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42389k, rowIndex2, false);
        }
        String realmGet$currencySymbol = object.realmGet$currencySymbol();
        if (realmGet$currencySymbol != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42390l, rowIndex2, realmGet$currencySymbol, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42390l, rowIndex2, false);
        }
        return rowIndex2;
    }

    /* renamed from: a */
    public static void m44551a(C13990F realm, Iterator<? extends C0105Y> objects, Map<C0105Y, Long> cache) {
        long pkColumnIndex;
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        Map<C0105Y, Long> map = cache;
        Table table = f.mo43537b(RealmAuthorization.class);
        long tableNativePtr = table.getNativePtr();
        C13993a columnInfo = (C13993a) f.f42569h.mo43710a(RealmAuthorization.class);
        long pkColumnIndex2 = table.mo23666f();
        while (objects.hasNext()) {
            RealmAuthorization object = (RealmAuthorization) objects.next();
            if (map.containsKey(object)) {
                pkColumnIndex = pkColumnIndex2;
            } else if (!(object instanceof C7344p) || ((C7344p) object).mo23791a().mo43514c() == null || !((C7344p) object).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
                String primaryKeyValue = object.realmGet$id();
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex2);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex2, primaryKeyValue);
                }
                if (rowIndex == -1) {
                    rowIndex2 = OsObject.m15909a(table, (Object) primaryKeyValue);
                } else {
                    rowIndex2 = rowIndex;
                }
                map.put(object, Long.valueOf(rowIndex2));
                String realmGet$customerId = object.realmGet$customerId();
                if (realmGet$customerId != null) {
                    String str = primaryKeyValue;
                    pkColumnIndex = pkColumnIndex2;
                    Table.nativeSetString(tableNativePtr, columnInfo.f42382d, rowIndex2, realmGet$customerId, false);
                } else {
                    pkColumnIndex = pkColumnIndex2;
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42382d, rowIndex2, false);
                }
                String realmGet$status = object.realmGet$status();
                if (realmGet$status != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42383e, rowIndex2, realmGet$status, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42383e, rowIndex2, false);
                }
                String realmGet$type = object.realmGet$type();
                if (realmGet$type != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42384f, rowIndex2, realmGet$type, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42384f, rowIndex2, false);
                }
                String realmGet$metadata = object.realmGet$metadata();
                if (realmGet$metadata != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42385g, rowIndex2, realmGet$metadata, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42385g, rowIndex2, false);
                }
                String realmGet$transactionId = object.realmGet$transactionId();
                if (realmGet$transactionId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42386h, rowIndex2, realmGet$transactionId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42386h, rowIndex2, false);
                }
                String realmGet$description = object.realmGet$description();
                if (realmGet$description != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42387i, rowIndex2, realmGet$description, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42387i, rowIndex2, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.f42388j, rowIndex2, object.realmGet$amount(), false);
                String realmGet$currency = object.realmGet$currency();
                if (realmGet$currency != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42389k, rowIndex2, realmGet$currency, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42389k, rowIndex2, false);
                }
                String realmGet$currencySymbol = object.realmGet$currencySymbol();
                if (realmGet$currencySymbol != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42390l, rowIndex2, realmGet$currencySymbol, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42390l, rowIndex2, false);
                }
            } else {
                map.put(object, Long.valueOf(((C7344p) object).mo23791a().mo43515d().getIndex()));
                pkColumnIndex = pkColumnIndex2;
            }
            RealmAuthorization realmAuthorization = object;
            pkColumnIndex2 = pkColumnIndex;
        }
    }

    /* renamed from: a */
    public static RealmAuthorization m44547a(RealmAuthorization realmObject, int currentDepth, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        RealmAuthorization unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = (C7345a) cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new RealmAuthorization();
            cache.put(realmObject, new C7345a(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.f14331a) {
            return (RealmAuthorization) cachedObject.f14332b;
        } else {
            unmanagedObject = (RealmAuthorization) cachedObject.f14332b;
            cachedObject.f14331a = currentDepth;
        }
        RealmAuthorization realmAuthorization = unmanagedObject;
        C13994H realmSource = realmObject;
        realmAuthorization.realmSet$id(realmSource.realmGet$id());
        realmAuthorization.realmSet$customerId(realmSource.realmGet$customerId());
        realmAuthorization.realmSet$status(realmSource.realmGet$status());
        realmAuthorization.realmSet$type(realmSource.realmGet$type());
        realmAuthorization.realmSet$metadata(realmSource.realmGet$metadata());
        realmAuthorization.realmSet$transactionId(realmSource.realmGet$transactionId());
        realmAuthorization.realmSet$description(realmSource.realmGet$description());
        realmAuthorization.realmSet$amount(realmSource.realmGet$amount());
        realmAuthorization.realmSet$currency(realmSource.realmGet$currency());
        realmAuthorization.realmSet$currencySymbol(realmSource.realmGet$currencySymbol());
        return unmanagedObject;
    }

    /* renamed from: a */
    static RealmAuthorization m44548a(C13990F realm, RealmAuthorization realmObject, RealmAuthorization newObject, Map<C0105Y, C7344p> map) {
        RealmAuthorization realmAuthorization = realmObject;
        C13994H realmObjectSource = newObject;
        realmAuthorization.realmSet$customerId(realmObjectSource.realmGet$customerId());
        realmAuthorization.realmSet$status(realmObjectSource.realmGet$status());
        realmAuthorization.realmSet$type(realmObjectSource.realmGet$type());
        realmAuthorization.realmSet$metadata(realmObjectSource.realmGet$metadata());
        realmAuthorization.realmSet$transactionId(realmObjectSource.realmGet$transactionId());
        realmAuthorization.realmSet$description(realmObjectSource.realmGet$description());
        realmAuthorization.realmSet$amount(realmObjectSource.realmGet$amount());
        realmAuthorization.realmSet$currency(realmObjectSource.realmGet$currency());
        realmAuthorization.realmSet$currencySymbol(realmObjectSource.realmGet$currencySymbol());
        return realmObject;
    }

    public String toString() {
        if (!C0106Z.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmAuthorization = proxy[");
        stringBuilder.append("{id:");
        String str = "null";
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : str);
        String str2 = "}";
        stringBuilder.append(str2);
        String str3 = ",";
        stringBuilder.append(str3);
        stringBuilder.append("{customerId:");
        stringBuilder.append(realmGet$customerId());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{metadata:");
        stringBuilder.append(realmGet$metadata());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{transactionId:");
        stringBuilder.append(realmGet$transactionId());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{amount:");
        stringBuilder.append(realmGet$amount());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{currency:");
        stringBuilder.append(realmGet$currency() != null ? realmGet$currency() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{currencySymbol:");
        if (realmGet$currencySymbol() != null) {
            str = realmGet$currencySymbol();
        }
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public C13986D<?> mo23791a() {
        return this.f42380d;
    }

    public int hashCode() {
        String realmName = this.f42380d.mo43514c().mo43545j();
        String tableName = this.f42380d.mo43515d().mo23711f().mo23665e();
        long rowIndex = this.f42380d.mo43515d().getIndex();
        int i = 0;
        int result = ((17 * 31) + (realmName != null ? realmName.hashCode() : 0)) * 31;
        if (tableName != null) {
            i = tableName.hashCode();
        }
        return ((result + i) * 31) + ((int) ((rowIndex >>> 32) ^ rowIndex));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        C13992G aRealmAuthorization = (C13992G) o;
        String path = this.f42380d.mo43514c().mo43545j();
        String otherPath = aRealmAuthorization.f42380d.mo43514c().mo43545j();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.f42380d.mo43515d().mo23711f().mo23665e();
        String otherTableName = aRealmAuthorization.f42380d.mo43515d().mo23711f().mo23665e();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.f42380d.mo43515d().getIndex() != aRealmAuthorization.f42380d.mo43515d().getIndex()) {
            return false;
        }
        return true;
    }
}
