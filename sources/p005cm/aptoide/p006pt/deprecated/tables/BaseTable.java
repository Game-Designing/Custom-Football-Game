package p005cm.aptoide.p006pt.deprecated.tables;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p024io.realm.C0106Z;

/* renamed from: cm.aptoide.pt.deprecated.tables.BaseTable */
public abstract class BaseTable {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS ";
    private static final String TAG = BaseTable.class.getSimpleName();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8525110638802417151L, "cm/aptoide/pt/deprecated/tables/BaseTable", 45);
        $jacocoData = probes;
        return probes;
    }

    public abstract C0106Z convert(Cursor cursor, PackageManager packageManager, Context context);

    public abstract String getTableName();

    public BaseTable() {
        $jacocoInit()[0] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[44] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x019c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void migrate(android.database.sqlite.SQLiteDatabase r12, p005cm.aptoide.p006pt.database.accessors.Accessor<p024io.realm.C0106Z> r13, android.content.pm.PackageManager r14, android.content.Context r15) {
        /*
            r11 = this;
            boolean[] r0 = $jacocoInit()
            r1 = 0
            r2 = 1
            r0[r2] = r2     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            r3 = r1
            java.lang.String r4 = r11.getTableName()     // Catch:{ Exception -> 0x0143 }
            java.util.Locale r5 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x0143 }
            java.lang.String r4 = r4.toLowerCase(r5)     // Catch:{ Exception -> 0x0143 }
            r5 = 2
            r0[r5] = r2     // Catch:{ Exception -> 0x0143 }
            java.lang.String r5 = r11.getCustomQuery()     // Catch:{ Exception -> 0x0143 }
            r6 = 3
            r0[r6] = r2     // Catch:{ Exception -> 0x0143 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0143 }
            if (r6 == 0) goto L_0x0040
            r6 = 4
            r0[r6] = r2     // Catch:{ Exception -> 0x0143 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0143 }
            r6.<init>()     // Catch:{ Exception -> 0x0143 }
            java.lang.String r7 = "select * from "
            r6.append(r7)     // Catch:{ Exception -> 0x0143 }
            r6.append(r4)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0143 }
            android.database.Cursor r1 = r12.rawQuery(r6, r1)     // Catch:{ Exception -> 0x0143 }
            r3 = r1
            r1 = 5
            r0[r1] = r2     // Catch:{ Exception -> 0x0143 }
            goto L_0x0048
        L_0x0040:
            android.database.Cursor r1 = r12.rawQuery(r5, r1)     // Catch:{ Exception -> 0x0143 }
            r3 = r1
            r1 = 6
            r0[r1] = r2     // Catch:{ Exception -> 0x0143 }
        L_0x0048:
            if (r3 == 0) goto L_0x011e
            boolean r1 = r3.isAfterLast()     // Catch:{ Exception -> 0x0143 }
            if (r1 != 0) goto L_0x0119
            boolean r1 = r3.isClosed()     // Catch:{ Exception -> 0x0143 }
            if (r1 != 0) goto L_0x0114
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0143 }
            r1.<init>()     // Catch:{ Exception -> 0x0143 }
            r6 = 11
            r0[r6] = r2     // Catch:{ Exception -> 0x0143 }
            r3.moveToFirst()     // Catch:{ Exception -> 0x0143 }
            r6 = 12
            r0[r6] = r2     // Catch:{ Exception -> 0x0143 }
        L_0x0066:
            boolean r6 = r3.isAfterLast()     // Catch:{ Exception -> 0x0143 }
            if (r6 != 0) goto L_0x008e
            r6 = 13
            r0[r6] = r2     // Catch:{ Exception -> 0x0143 }
            io.realm.Z r6 = r11.convert(r3, r14, r15)     // Catch:{ Exception -> 0x0143 }
            r7 = 14
            r0[r7] = r2     // Catch:{ Exception -> 0x0143 }
            if (r6 != 0) goto L_0x007f
            r7 = 15
            r0[r7] = r2     // Catch:{ Exception -> 0x0143 }
            goto L_0x0086
        L_0x007f:
            r1.add(r6)     // Catch:{ Exception -> 0x0143 }
            r7 = 16
            r0[r7] = r2     // Catch:{ Exception -> 0x0143 }
        L_0x0086:
            r3.moveToNext()     // Catch:{ Exception -> 0x0143 }
            r7 = 17
            r0[r7] = r2     // Catch:{ Exception -> 0x0143 }
            goto L_0x0066
        L_0x008e:
            int r6 = r1.size()     // Catch:{ Exception -> 0x0143 }
            if (r6 > 0) goto L_0x0099
            r6 = 18
            r0[r6] = r2     // Catch:{ Exception -> 0x0143 }
            goto L_0x00ab
        L_0x0099:
            if (r13 != 0) goto L_0x00a0
            r6 = 19
            r0[r6] = r2     // Catch:{ Exception -> 0x0143 }
            goto L_0x00ab
        L_0x00a0:
            r6 = 20
            r0[r6] = r2     // Catch:{ Exception -> 0x0143 }
            r13.insertAll(r1)     // Catch:{ Exception -> 0x0143 }
            r6 = 21
            r0[r6] = r2     // Catch:{ Exception -> 0x0143 }
        L_0x00ab:
            if (r13 == 0) goto L_0x00f5
            cm.aptoide.pt.logger.Logger r6 = p005cm.aptoide.p006pt.logger.Logger.getInstance()     // Catch:{ Exception -> 0x0143 }
            java.lang.String r7 = TAG     // Catch:{ Exception -> 0x0143 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0143 }
            r8.<init>()     // Catch:{ Exception -> 0x0143 }
            java.lang.String r9 = "Table "
            r8.append(r9)     // Catch:{ Exception -> 0x0143 }
            r8.append(r4)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r9 = " migrated with success."
            r8.append(r9)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0143 }
            r9 = 24
            r0[r9] = r2     // Catch:{ Exception -> 0x0143 }
            r6.mo2136d(r7, r8)     // Catch:{ Exception -> 0x0143 }
            r6 = 25
            r0[r6] = r2     // Catch:{ Exception -> 0x0143 }
            if (r3 != 0) goto L_0x00dc
            r1 = 26
            r0[r1] = r2
            goto L_0x017e
        L_0x00dc:
            boolean r1 = r3.isClosed()
            if (r1 == 0) goto L_0x00e8
            r1 = 27
            r0[r1] = r2
            goto L_0x017e
        L_0x00e8:
            r1 = 28
            r0[r1] = r2
            r3.close()
            r1 = 29
            r0[r1] = r2
            goto L_0x017e
        L_0x00f5:
            r6 = 22
            r0[r6] = r2     // Catch:{ Exception -> 0x0143 }
            java.lang.RuntimeException r6 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0143 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0143 }
            r7.<init>()     // Catch:{ Exception -> 0x0143 }
            java.lang.String r8 = "Accessor ir null for table "
            r7.append(r8)     // Catch:{ Exception -> 0x0143 }
            r7.append(r4)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0143 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0143 }
            r7 = 23
            r0[r7] = r2     // Catch:{ Exception -> 0x0143 }
            throw r6     // Catch:{ Exception -> 0x0143 }
        L_0x0114:
            r1 = 9
            r0[r1] = r2     // Catch:{ Exception -> 0x0143 }
            goto L_0x0121
        L_0x0119:
            r1 = 8
            r0[r1] = r2     // Catch:{ Exception -> 0x0143 }
            goto L_0x0121
        L_0x011e:
            r1 = 7
            r0[r1] = r2     // Catch:{ Exception -> 0x0143 }
        L_0x0121:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0143 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0143 }
            r6.<init>()     // Catch:{ Exception -> 0x0143 }
            java.lang.String r7 = "Cursor for table "
            r6.append(r7)     // Catch:{ Exception -> 0x0143 }
            r6.append(r4)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r7 = " is not available"
            r6.append(r7)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0143 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0143 }
            r6 = 10
            r0[r6] = r2     // Catch:{ Exception -> 0x0143 }
            throw r1     // Catch:{ Exception -> 0x0143 }
        L_0x0141:
            r1 = move-exception
            goto L_0x0183
        L_0x0143:
            r1 = move-exception
            goto L_0x014e
        L_0x0145:
            r3 = move-exception
            r10 = r3
            r3 = r1
            r1 = r10
            goto L_0x0183
        L_0x014a:
            r3 = move-exception
            r10 = r3
            r3 = r1
            r1 = r10
        L_0x014e:
            r4 = 30
            r0[r4] = r2     // Catch:{ all -> 0x0141 }
            cm.aptoide.pt.crashreports.CrashReport r4 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()     // Catch:{ all -> 0x0141 }
            r5 = 31
            r0[r5] = r2     // Catch:{ all -> 0x0141 }
            r4.log(r1)     // Catch:{ all -> 0x0141 }
            r4 = 32
            r0[r4] = r2     // Catch:{ all -> 0x0141 }
            if (r3 != 0) goto L_0x0168
            r1 = 33
            r0[r1] = r2
            goto L_0x017e
        L_0x0168:
            boolean r1 = r3.isClosed()
            if (r1 == 0) goto L_0x0173
            r1 = 34
            r0[r1] = r2
            goto L_0x017e
        L_0x0173:
            r1 = 35
            r0[r1] = r2
            r3.close()
            r1 = 36
            r0[r1] = r2
        L_0x017e:
            r1 = 42
            r0[r1] = r2
            return
        L_0x0183:
            if (r3 == 0) goto L_0x019c
            boolean r4 = r3.isClosed()
            if (r4 == 0) goto L_0x0190
            r4 = 38
            r0[r4] = r2
            goto L_0x01a0
        L_0x0190:
            r4 = 39
            r0[r4] = r2
            r3.close()
            r4 = 40
            r0[r4] = r2
            goto L_0x01a0
        L_0x019c:
            r4 = 37
            r0[r4] = r2
        L_0x01a0:
            r4 = 41
            r0[r4] = r2
            goto L_0x01a6
        L_0x01a5:
            throw r1
        L_0x01a6:
            goto L_0x01a5
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.deprecated.tables.BaseTable.migrate(android.database.sqlite.SQLiteDatabase, cm.aptoide.pt.database.accessors.Accessor, android.content.pm.PackageManager, android.content.Context):void");
    }

    public String getCustomQuery() {
        $jacocoInit()[43] = true;
        return null;
    }
}
