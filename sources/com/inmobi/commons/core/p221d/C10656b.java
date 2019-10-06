package com.inmobi.commons.core.p221d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.inmobi.commons.p217a.C10619a;

/* renamed from: com.inmobi.commons.core.d.b */
/* compiled from: DbStore */
public final class C10656b {

    /* renamed from: a */
    private static final String f32487a = C10656b.class.getSimpleName();

    /* renamed from: b */
    private static volatile C10656b f32488b;

    /* renamed from: c */
    private static final Object f32489c = new Object();

    /* renamed from: d */
    private static final Object f32490d = new Object();

    /* renamed from: e */
    private static int f32491e = 0;

    /* renamed from: f */
    private SQLiteDatabase f32492f;

    private C10656b() {
        try {
            this.f32492f = new C10655a(C10619a.m34839b()).getWritableDatabase();
            f32488b = this;
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static synchronized C10656b m34962a() {
        C10656b bVar;
        C10656b bVar2;
        synchronized (C10656b.class) {
            synchronized (f32490d) {
                f32491e++;
            }
            bVar = f32488b;
            if (bVar == null) {
                synchronized (f32489c) {
                    bVar2 = f32488b;
                    if (bVar2 == null) {
                        bVar2 = new C10656b();
                        f32488b = bVar2;
                    }
                }
                bVar = bVar2;
            }
        }
        return bVar;
    }

    /* renamed from: a */
    public final synchronized void mo34471a(String str, ContentValues contentValues, String str2, String[] strArr) {
        try {
            if (!mo34473a(str, contentValues)) {
                mo34474b(str, contentValues, str2, strArr);
            }
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in DbStore.insertOrUpdate() method; ").append(e.getMessage());
        }
    }

    /* renamed from: a */
    public final synchronized boolean mo34473a(String str, ContentValues contentValues) {
        try {
            if (this.f32492f.insertWithOnConflict(str, null, contentValues, 4) != -1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in DbStore.insert() method; ").append(e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public final synchronized int mo34469a(String str, String str2, String[] strArr) {
        try {
        } catch (Exception e) {
            new StringBuilder("SDK encountered an unexpected error in DbStore.delete() method; ").append(e.getMessage());
            return -1;
        }
        return this.f32492f.delete(str, str2, strArr);
    }

    /* renamed from: b */
    public final synchronized int mo34474b(String str, ContentValues contentValues, String str2, String[] strArr) {
        try {
        } catch (Exception e) {
            new StringBuilder("SDK encountered an unexpected error in DbStore.delete() method; ").append(e.getMessage());
            return -1;
        }
        return this.f32492f.updateWithOnConflict(str, contentValues, str2, strArr, 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        if (r3 != null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r3.close();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<android.content.ContentValues> mo34470a(java.lang.String r14, java.lang.String[] r15, java.lang.String r16, java.lang.String[] r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21) {
        /*
            r13 = this;
            r1 = r13
            monitor-enter(r13)
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0058 }
            r2.<init>()     // Catch:{ all -> 0x0058 }
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r1.f32492f     // Catch:{ Exception -> 0x003e }
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            r10 = r19
            r11 = r20
            r12 = r21
            android.database.Cursor r3 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x003e }
            boolean r0 = r3.moveToFirst()     // Catch:{ Exception -> 0x003e }
            if (r0 == 0) goto L_0x0033
        L_0x0022:
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ Exception -> 0x003e }
            r0.<init>()     // Catch:{ Exception -> 0x003e }
            android.database.DatabaseUtils.cursorRowToContentValues(r3, r0)     // Catch:{ Exception -> 0x003e }
            r2.add(r0)     // Catch:{ Exception -> 0x003e }
            boolean r0 = r3.moveToNext()     // Catch:{ Exception -> 0x003e }
            if (r0 != 0) goto L_0x0022
        L_0x0033:
            r3.close()     // Catch:{ Exception -> 0x003e }
            if (r3 == 0) goto L_0x0050
        L_0x0038:
            r3.close()     // Catch:{ all -> 0x0058 }
            goto L_0x0050
        L_0x003c:
            r0 = move-exception
            goto L_0x0052
        L_0x003e:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x003c }
            java.lang.String r5 = "SDK encountered unexpected error in DbStore.getRows() method; "
            r4.<init>(r5)     // Catch:{ all -> 0x003c }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x003c }
            r4.append(r0)     // Catch:{ all -> 0x003c }
            if (r3 == 0) goto L_0x0050
            goto L_0x0038
        L_0x0050:
            monitor-exit(r13)
            return r2
        L_0x0052:
            if (r3 == 0) goto L_0x0057
            r3.close()     // Catch:{ all -> 0x0058 }
        L_0x0057:
            throw r0     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r0 = move-exception
            monitor-exit(r13)
            goto L_0x005c
        L_0x005b:
            throw r0
        L_0x005c:
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.commons.core.p221d.C10656b.mo34470a(java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* renamed from: a */
    public final synchronized int mo34468a(String str) {
        int i;
        try {
            StringBuilder sb = new StringBuilder("SELECT COUNT(*) FROM ");
            sb.append(str);
            sb.append(" ; ");
            Cursor rawQuery = this.f32492f.rawQuery(sb.toString(), null);
            rawQuery.moveToFirst();
            i = rawQuery.getInt(0);
            rawQuery.close();
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in DbStore.getCount() method; ").append(e.getMessage());
            return -1;
        }
        return i;
    }

    /* renamed from: b */
    public final synchronized int mo34475b(String str, String str2, String[] strArr) {
        int i;
        try {
            StringBuilder sb = new StringBuilder("SELECT COUNT(*) FROM ");
            sb.append(str);
            sb.append(" WHERE ");
            sb.append(str2);
            sb.append(" ; ");
            Cursor rawQuery = this.f32492f.rawQuery(sb.toString(), strArr);
            rawQuery.moveToFirst();
            i = rawQuery.getInt(0);
            rawQuery.close();
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in DbStore.getCount() method; ").append(e.getMessage());
            return -1;
        }
        return i;
    }

    /* renamed from: a */
    public final synchronized void mo34472a(String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
            sb.append(str);
            sb.append(str2);
            sb.append(";");
            this.f32492f.execSQL(sb.toString());
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in DbStore.createTableIfNotExists() method; ").append(e.getMessage());
        }
    }

    /* renamed from: b */
    public final synchronized void mo34476b() {
        try {
            synchronized (f32490d) {
                int i = f32491e - 1;
                f32491e = i;
                if (i == 0) {
                    this.f32492f.close();
                    f32488b = null;
                }
            }
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in DbStore.close() method; ").append(e.getMessage());
        }
    }
}
