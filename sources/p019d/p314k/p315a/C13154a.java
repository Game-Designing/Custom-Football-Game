package p019d.p314k.p315a;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.tonyodev.fetch.exception.EnqueueException;

/* renamed from: d.k.a.a */
/* compiled from: DatabaseHelper */
final class C13154a extends SQLiteOpenHelper {

    /* renamed from: a */
    private static C13154a f40191a;

    /* renamed from: b */
    private final SQLiteDatabase f40192b = getWritableDatabase();

    /* renamed from: c */
    private boolean f40193c = true;

    private C13154a(Context context) {
        super(context, "com_tonyodev_fetch.db", null, 2);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE requests ( _id INTEGER PRIMARY KEY NOT NULL, _url TEXT NOT NULL, _file_path TEXT NOT NULL, _status INTEGER NOT NULL, _headers TEXT NOT NULL, _written_bytes INTEGER NOT NULL, _file_size INTEGER NOT NULL, _error INTEGER NOT NULL, _priority INTEGER NOT NULL, unique( _file_path ) )");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1) {
            db.execSQL("CREATE UNIQUE INDEX table_unique ON requests ( _file_path)");
        }
    }

    /* renamed from: a */
    static synchronized C13154a m42947a(Context context) {
        synchronized (C13154a.class) {
            if (f40191a != null) {
                C13154a aVar = f40191a;
                return aVar;
            } else if (context != null) {
                f40191a = new C13154a(context.getApplicationContext());
                C13154a aVar2 = f40191a;
                return aVar2;
            } else {
                throw new NullPointerException("Context cannot be null");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized boolean mo42180b(long id, String url, String filePath, int status, String headers, long downloadedBytes, long fileSize, int priority, int error) {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(mo42185e());
        sb.append(mo42169a(id, url, filePath, status, headers, downloadedBytes, fileSize, priority, error));
        sb.append(mo42183d());
        return mo42177a(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo42185e() {
        return "INSERT INTO requests ( _id, _url, _file_path, _status, _headers, _written_bytes, _file_size, _error, _priority ) VALUES ";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo42169a(long id, String url, String filePath, int status, String headers, long downloadedBytes, long fileSize, int priority, int error) {
        StringBuilder sb = new StringBuilder();
        sb.append("( ");
        sb.append(id);
        String str = ", ";
        sb.append(str);
        sb.append(DatabaseUtils.sqlEscapeString(url));
        sb.append(str);
        sb.append(DatabaseUtils.sqlEscapeString(filePath));
        sb.append(str);
        sb.append(status);
        sb.append(str);
        sb.append(DatabaseUtils.sqlEscapeString(headers));
        sb.append(str);
        sb.append(downloadedBytes);
        sb.append(str);
        sb.append(fileSize);
        sb.append(str);
        sb.append(error);
        sb.append(str);
        sb.append(priority);
        sb.append(" )");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo42183d() {
        return ";";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized boolean mo42177a(String insertStatement) {
        EnqueueException enqueueException;
        if (insertStatement == null) {
            return false;
        }
        try {
            this.f40192b.beginTransaction();
            this.f40192b.execSQL(insertStatement);
            this.f40192b.setTransactionSuccessful();
            this.f40192b.endTransaction();
            return true;
        } catch (Exception e) {
            if (this.f40193c) {
                e.printStackTrace();
            }
            throw new EnqueueException(e.getMessage(), C13156b.m42970a(e.getMessage()));
        } catch (SQLiteException e2) {
            if (this.f40193c) {
                e2.printStackTrace();
            }
            enqueueException = new EnqueueException(e2.getMessage(), C13156b.m42970a(e2.getMessage()));
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0091, code lost:
        if (r1 != null) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a1, code lost:
        if (r1 != null) goto L_0x0093;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo42182c(long r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.f40192b     // Catch:{ SQLiteException -> 0x004d }
            r1.beginTransaction()     // Catch:{ SQLiteException -> 0x004d }
            android.database.sqlite.SQLiteDatabase r1 = r5.f40192b     // Catch:{ SQLiteException -> 0x004d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x004d }
            r2.<init>()     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r3 = "UPDATE requests SET _status = 902 WHERE _id = "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            r2.append(r6)     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r3 = " AND "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r3 = "_status"
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r3 = " != "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            r3 = 903(0x387, float:1.265E-42)
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r3 = " AND "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r3 = "_status"
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r3 = " != "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            r3 = 904(0x388, float:1.267E-42)
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteException -> 0x004d }
            r1.execSQL(r2)     // Catch:{ SQLiteException -> 0x004d }
            android.database.sqlite.SQLiteDatabase r1 = r5.f40192b     // Catch:{ SQLiteException -> 0x004d }
            r1.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x004d }
            goto L_0x0055
        L_0x004b:
            r6 = move-exception
            goto L_0x00ac
        L_0x004d:
            r1 = move-exception
            boolean r2 = r5.f40193c     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x0055
            r1.printStackTrace()     // Catch:{ all -> 0x004b }
        L_0x0055:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.f40192b     // Catch:{ SQLiteException -> 0x0099 }
            r2.endTransaction()     // Catch:{ SQLiteException -> 0x0099 }
            android.database.sqlite.SQLiteDatabase r2 = r5.f40192b     // Catch:{ SQLiteException -> 0x0099 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0099 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0099 }
            java.lang.String r4 = "SELECT _id FROM requests WHERE _id = "
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0099 }
            r3.append(r6)     // Catch:{ SQLiteException -> 0x0099 }
            java.lang.String r4 = " AND "
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0099 }
            java.lang.String r4 = "_status"
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0099 }
            java.lang.String r4 = " = "
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0099 }
            r4 = 902(0x386, float:1.264E-42)
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0099 }
            java.lang.String r3 = r3.toString()     // Catch:{ SQLiteException -> 0x0099 }
            r4 = 0
            android.database.Cursor r2 = r2.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x0099 }
            r1 = r2
            if (r1 == 0) goto L_0x0091
            int r2 = r1.getCount()     // Catch:{ SQLiteException -> 0x0099 }
            if (r2 <= 0) goto L_0x0091
            r0 = 1
        L_0x0091:
            if (r1 == 0) goto L_0x00a4
        L_0x0093:
            r1.close()     // Catch:{ all -> 0x004b }
            goto L_0x00a4
        L_0x0097:
            r2 = move-exception
            goto L_0x00a6
        L_0x0099:
            r2 = move-exception
            boolean r3 = r5.f40193c     // Catch:{ all -> 0x0097 }
            if (r3 == 0) goto L_0x00a1
            r2.printStackTrace()     // Catch:{ all -> 0x0097 }
        L_0x00a1:
            if (r1 == 0) goto L_0x00a4
            goto L_0x0093
        L_0x00a4:
            monitor-exit(r5)
            return r0
        L_0x00a6:
            if (r1 == 0) goto L_0x00ab
            r1.close()     // Catch:{ all -> 0x004b }
        L_0x00ab:
            throw r2     // Catch:{ all -> 0x004b }
        L_0x00ac:
            monitor-exit(r5)
            goto L_0x00af
        L_0x00ae:
            throw r6
        L_0x00af:
            goto L_0x00ae
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p314k.p315a.C13154a.mo42182c(long):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0091, code lost:
        if (r1 != null) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a1, code lost:
        if (r1 != null) goto L_0x0093;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo42184d(long r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.f40192b     // Catch:{ SQLiteException -> 0x004d }
            r1.beginTransaction()     // Catch:{ SQLiteException -> 0x004d }
            android.database.sqlite.SQLiteDatabase r1 = r5.f40192b     // Catch:{ SQLiteException -> 0x004d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x004d }
            r2.<init>()     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r3 = "UPDATE requests SET _status = 900 WHERE _id = "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            r2.append(r6)     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r3 = " AND "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r3 = "_status"
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r3 = " != "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            r3 = 903(0x387, float:1.265E-42)
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r3 = " AND "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r3 = "_status"
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r3 = " != "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            r3 = 904(0x388, float:1.267E-42)
            r2.append(r3)     // Catch:{ SQLiteException -> 0x004d }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteException -> 0x004d }
            r1.execSQL(r2)     // Catch:{ SQLiteException -> 0x004d }
            android.database.sqlite.SQLiteDatabase r1 = r5.f40192b     // Catch:{ SQLiteException -> 0x004d }
            r1.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x004d }
            goto L_0x0055
        L_0x004b:
            r6 = move-exception
            goto L_0x00ac
        L_0x004d:
            r1 = move-exception
            boolean r2 = r5.f40193c     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x0055
            r1.printStackTrace()     // Catch:{ all -> 0x004b }
        L_0x0055:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.f40192b     // Catch:{ SQLiteException -> 0x0099 }
            r2.endTransaction()     // Catch:{ SQLiteException -> 0x0099 }
            android.database.sqlite.SQLiteDatabase r2 = r5.f40192b     // Catch:{ SQLiteException -> 0x0099 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0099 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0099 }
            java.lang.String r4 = "SELECT _id FROM requests WHERE _id = "
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0099 }
            r3.append(r6)     // Catch:{ SQLiteException -> 0x0099 }
            java.lang.String r4 = " AND "
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0099 }
            java.lang.String r4 = "_status"
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0099 }
            java.lang.String r4 = " = "
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0099 }
            r4 = 900(0x384, float:1.261E-42)
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0099 }
            java.lang.String r3 = r3.toString()     // Catch:{ SQLiteException -> 0x0099 }
            r4 = 0
            android.database.Cursor r2 = r2.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x0099 }
            r1 = r2
            if (r1 == 0) goto L_0x0091
            int r2 = r1.getCount()     // Catch:{ SQLiteException -> 0x0099 }
            if (r2 <= 0) goto L_0x0091
            r0 = 1
        L_0x0091:
            if (r1 == 0) goto L_0x00a4
        L_0x0093:
            r1.close()     // Catch:{ all -> 0x004b }
            goto L_0x00a4
        L_0x0097:
            r2 = move-exception
            goto L_0x00a6
        L_0x0099:
            r2 = move-exception
            boolean r3 = r5.f40193c     // Catch:{ all -> 0x0097 }
            if (r3 == 0) goto L_0x00a1
            r2.printStackTrace()     // Catch:{ all -> 0x0097 }
        L_0x00a1:
            if (r1 == 0) goto L_0x00a4
            goto L_0x0093
        L_0x00a4:
            monitor-exit(r5)
            return r0
        L_0x00a6:
            if (r1 == 0) goto L_0x00ab
            r1.close()     // Catch:{ all -> 0x004b }
        L_0x00ab:
            throw r2     // Catch:{ all -> 0x004b }
        L_0x00ac:
            monitor-exit(r5)
            goto L_0x00af
        L_0x00ae:
            throw r6
        L_0x00af:
            goto L_0x00ae
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p314k.p315a.C13154a.mo42184d(long):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized boolean mo42174a(long id, int status, int error) {
        boolean updated;
        updated = false;
        try {
            this.f40192b.beginTransaction();
            SQLiteDatabase sQLiteDatabase = this.f40192b;
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE requests SET _status = ");
            sb.append(status);
            sb.append(", ");
            sb.append("_error");
            sb.append(" = ");
            sb.append(error);
            sb.append(" WHERE ");
            sb.append("_id");
            sb.append(" = ");
            sb.append(id);
            sQLiteDatabase.execSQL(sb.toString());
            this.f40192b.setTransactionSuccessful();
        } catch (SQLiteException e) {
            if (this.f40193c) {
                e.printStackTrace();
            }
        }
        try {
            this.f40192b.endTransaction();
            updated = true;
        } catch (SQLiteException e2) {
            if (this.f40193c) {
                e2.printStackTrace();
            }
        }
        return updated;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized boolean mo42175a(long id, long downloadedBytes, long fileSize) {
        boolean updated;
        updated = false;
        try {
            this.f40192b.beginTransaction();
            SQLiteDatabase sQLiteDatabase = this.f40192b;
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE requests SET _file_size = ");
            sb.append(fileSize);
            sb.append(", ");
            sb.append("_written_bytes");
            sb.append(" = ");
            sb.append(downloadedBytes);
            sb.append(" WHERE ");
            sb.append("_id");
            sb.append(" = ");
            sb.append(id);
            sQLiteDatabase.execSQL(sb.toString());
            this.f40192b.setTransactionSuccessful();
        } catch (SQLiteException e) {
            if (this.f40193c) {
                e.printStackTrace();
            }
        }
        try {
            this.f40192b.endTransaction();
            updated = true;
        } catch (SQLiteException e2) {
            if (this.f40193c) {
                e2.printStackTrace();
            }
        }
        return updated;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized boolean mo42172a(long id) {
        boolean removed;
        removed = false;
        try {
            this.f40192b.beginTransaction();
            SQLiteDatabase sQLiteDatabase = this.f40192b;
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM requests WHERE _id = ");
            sb.append(id);
            sQLiteDatabase.execSQL(sb.toString());
            this.f40192b.setTransactionSuccessful();
        } catch (SQLiteException e) {
            if (this.f40193c) {
                e.printStackTrace();
            }
        }
        try {
            this.f40192b.endTransaction();
            removed = true;
        } catch (SQLiteException e2) {
            if (this.f40193c) {
                e2.printStackTrace();
            }
        }
        return removed;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized boolean mo42179b() {
        boolean removed;
        removed = false;
        try {
            this.f40192b.beginTransaction();
            this.f40192b.execSQL("DELETE FROM requests");
            this.f40192b.setTransactionSuccessful();
        } catch (SQLiteException e) {
            if (this.f40193c) {
                e.printStackTrace();
            }
        }
        try {
            this.f40192b.endTransaction();
            removed = true;
        } catch (SQLiteException e2) {
            if (this.f40193c) {
                e2.printStackTrace();
            }
        }
        return removed;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized boolean mo42173a(long id, int priority) {
        boolean updated;
        updated = false;
        try {
            this.f40192b.beginTransaction();
            SQLiteDatabase sQLiteDatabase = this.f40192b;
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE requests SET _priority = ");
            sb.append(priority);
            sb.append(" WHERE ");
            sb.append("_id");
            sb.append(" = ");
            sb.append(id);
            sQLiteDatabase.execSQL(sb.toString());
            this.f40192b.setTransactionSuccessful();
        } catch (SQLiteException e) {
            if (this.f40193c) {
                e.printStackTrace();
            }
        }
        try {
            this.f40192b.endTransaction();
            updated = true;
        } catch (SQLiteException e2) {
            if (this.f40193c) {
                e2.printStackTrace();
            }
        }
        return updated;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007d, code lost:
        if (r1 != null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008d, code lost:
        if (r1 != null) goto L_0x007f;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo42186e(long r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.f40192b     // Catch:{ SQLiteException -> 0x0039 }
            r1.beginTransaction()     // Catch:{ SQLiteException -> 0x0039 }
            android.database.sqlite.SQLiteDatabase r1 = r5.f40192b     // Catch:{ SQLiteException -> 0x0039 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0039 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x0039 }
            java.lang.String r3 = "UPDATE requests SET _status = 900, _error = -1 WHERE _id = "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x0039 }
            r2.append(r6)     // Catch:{ SQLiteException -> 0x0039 }
            java.lang.String r3 = " AND "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x0039 }
            java.lang.String r3 = "_status"
            r2.append(r3)     // Catch:{ SQLiteException -> 0x0039 }
            java.lang.String r3 = " = "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x0039 }
            r3 = 904(0x388, float:1.267E-42)
            r2.append(r3)     // Catch:{ SQLiteException -> 0x0039 }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteException -> 0x0039 }
            r1.execSQL(r2)     // Catch:{ SQLiteException -> 0x0039 }
            android.database.sqlite.SQLiteDatabase r1 = r5.f40192b     // Catch:{ SQLiteException -> 0x0039 }
            r1.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x0039 }
            goto L_0x0041
        L_0x0037:
            r6 = move-exception
            goto L_0x0098
        L_0x0039:
            r1 = move-exception
            boolean r2 = r5.f40193c     // Catch:{ all -> 0x0037 }
            if (r2 == 0) goto L_0x0041
            r1.printStackTrace()     // Catch:{ all -> 0x0037 }
        L_0x0041:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.f40192b     // Catch:{ SQLiteException -> 0x0085 }
            r2.endTransaction()     // Catch:{ SQLiteException -> 0x0085 }
            android.database.sqlite.SQLiteDatabase r2 = r5.f40192b     // Catch:{ SQLiteException -> 0x0085 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0085 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0085 }
            java.lang.String r4 = "SELECT _id FROM requests WHERE _id = "
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0085 }
            r3.append(r6)     // Catch:{ SQLiteException -> 0x0085 }
            java.lang.String r4 = " AND "
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0085 }
            java.lang.String r4 = "_status"
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0085 }
            java.lang.String r4 = " = "
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0085 }
            r4 = 900(0x384, float:1.261E-42)
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0085 }
            java.lang.String r3 = r3.toString()     // Catch:{ SQLiteException -> 0x0085 }
            r4 = 0
            android.database.Cursor r2 = r2.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x0085 }
            r1 = r2
            if (r1 == 0) goto L_0x007d
            int r2 = r1.getCount()     // Catch:{ SQLiteException -> 0x0085 }
            if (r2 <= 0) goto L_0x007d
            r0 = 1
        L_0x007d:
            if (r1 == 0) goto L_0x0090
        L_0x007f:
            r1.close()     // Catch:{ all -> 0x0037 }
            goto L_0x0090
        L_0x0083:
            r2 = move-exception
            goto L_0x0092
        L_0x0085:
            r2 = move-exception
            boolean r3 = r5.f40193c     // Catch:{ all -> 0x0083 }
            if (r3 == 0) goto L_0x008d
            r2.printStackTrace()     // Catch:{ all -> 0x0083 }
        L_0x008d:
            if (r1 == 0) goto L_0x0090
            goto L_0x007f
        L_0x0090:
            monitor-exit(r5)
            return r0
        L_0x0092:
            if (r1 == 0) goto L_0x0097
            r1.close()     // Catch:{ all -> 0x0037 }
        L_0x0097:
            throw r2     // Catch:{ all -> 0x0037 }
        L_0x0098:
            monitor-exit(r5)
            goto L_0x009b
        L_0x009a:
            throw r6
        L_0x009b:
            goto L_0x009a
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p314k.p315a.C13154a.mo42186e(long):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0081, code lost:
        if (r1 != null) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0091, code lost:
        if (r1 != null) goto L_0x0083;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo42176a(long r6, java.lang.String r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.f40192b     // Catch:{ SQLiteException -> 0x003b }
            r1.beginTransaction()     // Catch:{ SQLiteException -> 0x003b }
            android.database.sqlite.SQLiteDatabase r1 = r5.f40192b     // Catch:{ SQLiteException -> 0x003b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x003b }
            r2.<init>()     // Catch:{ SQLiteException -> 0x003b }
            java.lang.String r3 = "UPDATE requests SET _url = "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x003b }
            java.lang.String r3 = android.database.DatabaseUtils.sqlEscapeString(r8)     // Catch:{ SQLiteException -> 0x003b }
            r2.append(r3)     // Catch:{ SQLiteException -> 0x003b }
            java.lang.String r3 = " WHERE "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x003b }
            java.lang.String r3 = "_id"
            r2.append(r3)     // Catch:{ SQLiteException -> 0x003b }
            java.lang.String r3 = " = "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x003b }
            r2.append(r6)     // Catch:{ SQLiteException -> 0x003b }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteException -> 0x003b }
            r1.execSQL(r2)     // Catch:{ SQLiteException -> 0x003b }
            android.database.sqlite.SQLiteDatabase r1 = r5.f40192b     // Catch:{ SQLiteException -> 0x003b }
            r1.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x003b }
            goto L_0x0043
        L_0x0039:
            r6 = move-exception
            goto L_0x009c
        L_0x003b:
            r1 = move-exception
            boolean r2 = r5.f40193c     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x0043
            r1.printStackTrace()     // Catch:{ all -> 0x0039 }
        L_0x0043:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.f40192b     // Catch:{ SQLiteException -> 0x0089 }
            r2.endTransaction()     // Catch:{ SQLiteException -> 0x0089 }
            android.database.sqlite.SQLiteDatabase r2 = r5.f40192b     // Catch:{ SQLiteException -> 0x0089 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0089 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0089 }
            java.lang.String r4 = "SELECT _id FROM requests WHERE _id = "
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0089 }
            r3.append(r6)     // Catch:{ SQLiteException -> 0x0089 }
            java.lang.String r4 = " AND "
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0089 }
            java.lang.String r4 = "_url"
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0089 }
            java.lang.String r4 = " = "
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0089 }
            java.lang.String r4 = android.database.DatabaseUtils.sqlEscapeString(r8)     // Catch:{ SQLiteException -> 0x0089 }
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0089 }
            java.lang.String r3 = r3.toString()     // Catch:{ SQLiteException -> 0x0089 }
            r4 = 0
            android.database.Cursor r2 = r2.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x0089 }
            r1 = r2
            if (r1 == 0) goto L_0x0081
            int r2 = r1.getCount()     // Catch:{ SQLiteException -> 0x0089 }
            if (r2 <= 0) goto L_0x0081
            r0 = 1
        L_0x0081:
            if (r1 == 0) goto L_0x0094
        L_0x0083:
            r1.close()     // Catch:{ all -> 0x0039 }
            goto L_0x0094
        L_0x0087:
            r2 = move-exception
            goto L_0x0096
        L_0x0089:
            r2 = move-exception
            boolean r3 = r5.f40193c     // Catch:{ all -> 0x0087 }
            if (r3 == 0) goto L_0x0091
            r2.printStackTrace()     // Catch:{ all -> 0x0087 }
        L_0x0091:
            if (r1 == 0) goto L_0x0094
            goto L_0x0083
        L_0x0094:
            monitor-exit(r5)
            return r0
        L_0x0096:
            if (r1 == 0) goto L_0x009b
            r1.close()     // Catch:{ all -> 0x0039 }
        L_0x009b:
            throw r2     // Catch:{ all -> 0x0039 }
        L_0x009c:
            monitor-exit(r5)
            goto L_0x009f
        L_0x009e:
            throw r6
        L_0x009f:
            goto L_0x009e
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p314k.p315a.C13154a.mo42176a(long, java.lang.String):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized Cursor mo42178b(long id) {
        SQLiteDatabase sQLiteDatabase;
        StringBuilder sb;
        try {
            sQLiteDatabase = this.f40192b;
            sb = new StringBuilder();
            sb.append("SELECT * FROM requests WHERE _id = ");
            sb.append(id);
        } catch (SQLiteException e) {
            if (this.f40193c) {
                e.printStackTrace();
            }
            return null;
        }
        return sQLiteDatabase.rawQuery(sb.toString(), null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public synchronized Cursor mo42181c() {
        try {
        } catch (SQLiteException e) {
            if (this.f40193c) {
                e.printStackTrace();
            }
            return null;
        }
        return this.f40192b.rawQuery("SELECT * FROM requests", null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized Cursor mo42168a(int status) {
        SQLiteDatabase sQLiteDatabase;
        StringBuilder sb;
        try {
            sQLiteDatabase = this.f40192b;
            sb = new StringBuilder();
            sb.append("SELECT * FROM requests WHERE _status = ");
            sb.append(status);
        } catch (SQLiteException e) {
            if (this.f40193c) {
                e.printStackTrace();
            }
            return null;
        }
        return sQLiteDatabase.rawQuery(sb.toString(), null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public synchronized Cursor mo42187f() {
        Cursor cursor = this.f40192b.rawQuery("SELECT * FROM requests WHERE _status = 900 AND _priority = 601 LIMIT 1", null);
        if (cursor != null && cursor.getCount() > 0) {
            return cursor;
        }
        if (cursor != null) {
            cursor.close();
        }
        return this.f40192b.rawQuery("SELECT * FROM requests WHERE _status = 900 LIMIT 1", null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public synchronized boolean mo42188g() {
        boolean hasPending;
        Cursor cursor = this.f40192b.rawQuery("SELECT _id FROM requests WHERE _status = 900 LIMIT 1", null);
        hasPending = false;
        if (cursor != null && cursor.getCount() > 0) {
            hasPending = true;
        }
        if (cursor != null) {
            cursor.close();
        }
        return hasPending;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public synchronized void mo42189h() {
        try {
            this.f40192b.beginTransaction();
            this.f40192b.execSQL("UPDATE requests SET _status = 900 WHERE _status = 901");
            this.f40192b.setTransactionSuccessful();
        } catch (SQLiteException e) {
            if (this.f40193c) {
                e.printStackTrace();
            }
        }
        try {
            this.f40192b.endTransaction();
        } catch (SQLiteException e2) {
            if (this.f40193c) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo42170a() {
        Cursor cursor = this.f40192b.rawQuery("SELECT _id, _file_path FROM requests WHERE _status = 903", null);
        if (cursor != null) {
            if (cursor.getCount() < 1) {
                cursor.close();
                return;
            }
            try {
                this.f40192b.beginTransaction();
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    String destinationUri = cursor.getString(cursor.getColumnIndex("_file_path"));
                    if (destinationUri != null && !C13178t.m43106e(destinationUri)) {
                        long id = cursor.getLong(cursor.getColumnIndex("_id"));
                        SQLiteDatabase sQLiteDatabase = this.f40192b;
                        StringBuilder sb = new StringBuilder();
                        sb.append("UPDATE requests SET _status = 904, _error = -111 WHERE _id = ");
                        sb.append(id);
                        sQLiteDatabase.execSQL(sb.toString());
                    }
                    cursor.moveToNext();
                }
                this.f40192b.setTransactionSuccessful();
            } catch (SQLiteException e) {
                if (this.f40193c) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                cursor.close();
                throw th;
            }
            try {
                this.f40192b.endTransaction();
            } catch (SQLiteException e2) {
                if (this.f40193c) {
                    e2.printStackTrace();
                }
            }
            cursor.close();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo42171a(boolean enabled) {
        this.f40193c = enabled;
    }
}
