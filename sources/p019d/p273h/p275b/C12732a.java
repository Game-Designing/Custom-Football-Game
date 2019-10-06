package p019d.p273h.p275b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import android.util.Log;
import com.mopub.common.Constants;

/* renamed from: d.h.b.a */
/* compiled from: DataBaseEventsStorage */
public class C12732a extends SQLiteOpenHelper implements C12737f {

    /* renamed from: a */
    private static C12732a f39053a;

    /* renamed from: b */
    private final int f39054b = 4;

    /* renamed from: c */
    private final int f39055c = 400;

    /* renamed from: d */
    private final String f39056d = "DROP TABLE IF EXISTS events";

    /* renamed from: e */
    private final String f39057e = "CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )";

    public C12732a(Context context, String databaseName, int databaseVersion) {
        super(context, databaseName, null, databaseVersion);
    }

    /* renamed from: a */
    public static synchronized C12732a m41117a(Context context, String databaseName, int databaseVersion) {
        C12732a aVar;
        synchronized (C12732a.class) {
            if (f39053a == null) {
                f39053a = new C12732a(context, databaseName, databaseVersion);
            }
            aVar = f39053a;
        }
        return aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0068, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004d A[SYNTHETIC, Splitter:B:28:0x004d] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo41150a(java.util.List<p019d.p273h.p275b.C12733b> r7, java.lang.String r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 == 0) goto L_0x0067
            boolean r0 = r7.isEmpty()     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x000a
            goto L_0x0067
        L_0x000a:
            r0 = 0
            r1 = 1
            android.database.sqlite.SQLiteDatabase r1 = r6.m41116a(r1)     // Catch:{ Throwable -> 0x0042 }
            r0 = r1
            java.util.Iterator r1 = r7.iterator()     // Catch:{ Throwable -> 0x0042 }
        L_0x0015:
            boolean r2 = r1.hasNext()     // Catch:{ Throwable -> 0x0042 }
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r1.next()     // Catch:{ Throwable -> 0x0032, all -> 0x0030 }
            d.h.b.b r2 = (p019d.p273h.p275b.C12733b) r2     // Catch:{ Throwable -> 0x0032, all -> 0x0030 }
            android.content.ContentValues r3 = r6.m41115a(r2, r8)     // Catch:{ Throwable -> 0x0032, all -> 0x0030 }
            if (r0 == 0) goto L_0x002f
            if (r3 == 0) goto L_0x002f
            java.lang.String r4 = "events"
            r5 = 0
            r0.insert(r4, r5, r3)     // Catch:{ Throwable -> 0x0032, all -> 0x0030 }
        L_0x002f:
            goto L_0x0015
        L_0x0030:
            r1 = move-exception
            goto L_0x0058
        L_0x0032:
            r1 = move-exception
            goto L_0x0043
        L_0x0034:
            if (r0 == 0) goto L_0x0056
            boolean r1 = r0.isOpen()     // Catch:{ all -> 0x0064 }
            if (r1 == 0) goto L_0x0056
            r0.close()     // Catch:{ all -> 0x0064 }
            goto L_0x0056
        L_0x0040:
            r1 = move-exception
            goto L_0x0058
        L_0x0042:
            r1 = move-exception
        L_0x0043:
            java.lang.String r2 = "IronSource"
            java.lang.String r3 = "Exception while saving events: "
            android.util.Log.e(r2, r3, r1)     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0056
            boolean r1 = r0.isOpen()     // Catch:{ all -> 0x0064 }
            if (r1 == 0) goto L_0x0056
            r0.close()     // Catch:{ all -> 0x0064 }
        L_0x0056:
            monitor-exit(r6)
            return
        L_0x0058:
            if (r0 == 0) goto L_0x0063
            boolean r2 = r0.isOpen()     // Catch:{ all -> 0x0064 }
            if (r2 == 0) goto L_0x0063
            r0.close()     // Catch:{ all -> 0x0064 }
        L_0x0063:
            throw r1     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        L_0x0067:
            monitor-exit(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p275b.C12732a.mo41150a(java.util.List, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007a, code lost:
        if (r0.isOpen() != false) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007c, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009c, code lost:
        if (r0.isOpen() != false) goto L_0x007c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008d A[SYNTHETIC, Splitter:B:31:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0098  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.ArrayList<p019d.p273h.p275b.C12733b> mo41151b(java.lang.String r14) {
        /*
            r13 = this;
            monitor-enter(r13)
            r0 = 0
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00b8 }
            r2.<init>()     // Catch:{ all -> 0x00b8 }
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r13.m41116a(r3)     // Catch:{ Throwable -> 0x0082 }
            r0 = r4
            java.lang.String r8 = "type = ?"
            r4 = 1
            java.lang.String[] r9 = new java.lang.String[r4]     // Catch:{ Throwable -> 0x0082 }
            r9[r3] = r14     // Catch:{ Throwable -> 0x0082 }
            java.lang.String r12 = "timestamp ASC"
            java.lang.String r6 = "events"
            r7 = 0
            r10 = 0
            r11 = 0
            r5 = r0
            android.database.Cursor r3 = r5.query(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Throwable -> 0x0082 }
            r1 = r3
            int r3 = r1.getCount()     // Catch:{ Throwable -> 0x0082 }
            if (r3 <= 0) goto L_0x0069
            r1.moveToFirst()     // Catch:{ Throwable -> 0x0067, all -> 0x0065 }
        L_0x002b:
            boolean r3 = r1.isAfterLast()     // Catch:{ Throwable -> 0x0067, all -> 0x0065 }
            if (r3 != 0) goto L_0x0061
            java.lang.String r3 = "eventid"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Throwable -> 0x0067, all -> 0x0065 }
            int r3 = r1.getInt(r3)     // Catch:{ Throwable -> 0x0067, all -> 0x0065 }
            java.lang.String r4 = "timestamp"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ Throwable -> 0x0067, all -> 0x0065 }
            long r4 = r1.getLong(r4)     // Catch:{ Throwable -> 0x0067, all -> 0x0065 }
            java.lang.String r6 = "data"
            int r6 = r1.getColumnIndex(r6)     // Catch:{ Throwable -> 0x0067, all -> 0x0065 }
            java.lang.String r6 = r1.getString(r6)     // Catch:{ Throwable -> 0x0067, all -> 0x0065 }
            d.h.b.b r7 = new d.h.b.b     // Catch:{ Throwable -> 0x0067, all -> 0x0065 }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0067, all -> 0x0065 }
            r10.<init>(r6)     // Catch:{ Throwable -> 0x0067, all -> 0x0065 }
            r7.<init>(r3, r4, r10)     // Catch:{ Throwable -> 0x0067, all -> 0x0065 }
            r2.add(r7)     // Catch:{ Throwable -> 0x0067, all -> 0x0065 }
            r1.moveToNext()     // Catch:{ Throwable -> 0x0067, all -> 0x0065 }
            goto L_0x002b
        L_0x0061:
            r1.close()     // Catch:{ Throwable -> 0x0067, all -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r3 = move-exception
            goto L_0x00a1
        L_0x0067:
            r3 = move-exception
            goto L_0x0083
        L_0x0069:
            if (r1 == 0) goto L_0x0074
            boolean r3 = r1.isClosed()     // Catch:{ all -> 0x00b8 }
            if (r3 != 0) goto L_0x0074
            r1.close()     // Catch:{ all -> 0x00b8 }
        L_0x0074:
            if (r0 == 0) goto L_0x009f
            boolean r3 = r0.isOpen()     // Catch:{ all -> 0x00b8 }
            if (r3 == 0) goto L_0x009f
        L_0x007c:
            r0.close()     // Catch:{ all -> 0x00b8 }
            goto L_0x009f
        L_0x0080:
            r3 = move-exception
            goto L_0x00a1
        L_0x0082:
            r3 = move-exception
        L_0x0083:
            java.lang.String r4 = "IronSource"
            java.lang.String r5 = "Exception while loading events: "
            android.util.Log.e(r4, r5, r3)     // Catch:{ all -> 0x0080 }
            if (r1 == 0) goto L_0x0096
            boolean r3 = r1.isClosed()     // Catch:{ all -> 0x00b8 }
            if (r3 != 0) goto L_0x0096
            r1.close()     // Catch:{ all -> 0x00b8 }
        L_0x0096:
            if (r0 == 0) goto L_0x009f
            boolean r3 = r0.isOpen()     // Catch:{ all -> 0x00b8 }
            if (r3 == 0) goto L_0x009f
            goto L_0x007c
        L_0x009f:
            monitor-exit(r13)
            return r2
        L_0x00a1:
            if (r1 == 0) goto L_0x00ac
            boolean r4 = r1.isClosed()     // Catch:{ all -> 0x00b8 }
            if (r4 != 0) goto L_0x00ac
            r1.close()     // Catch:{ all -> 0x00b8 }
        L_0x00ac:
            if (r0 == 0) goto L_0x00b7
            boolean r4 = r0.isOpen()     // Catch:{ all -> 0x00b8 }
            if (r4 == 0) goto L_0x00b7
            r0.close()     // Catch:{ all -> 0x00b8 }
        L_0x00b7:
            throw r3     // Catch:{ all -> 0x00b8 }
        L_0x00b8:
            r14 = move-exception
            monitor-exit(r13)
            goto L_0x00bc
        L_0x00bb:
            throw r14
        L_0x00bc:
            goto L_0x00bb
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p275b.C12732a.mo41151b(java.lang.String):java.util.ArrayList");
    }

    /* renamed from: a */
    public synchronized void mo41149a(String type) {
        SQLiteDatabase db = null;
        String whereClause = "type = ?";
        String[] whereArgs = {type};
        try {
            db = m41116a(true);
            db.delete(Constants.VIDEO_TRACKING_EVENTS_KEY, whereClause, whereArgs);
            if (db != null) {
                if (db.isOpen()) {
                    db.close();
                }
            }
        } catch (Throwable e) {
            try {
                Log.e("IronSource", "Exception while clearing events: ", e);
                if (db != null) {
                    if (db.isOpen()) {
                        db.close();
                    }
                }
            } finally {
                if (db != null) {
                    if (db.isOpen()) {
                        db.close();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private ContentValues m41115a(C12733b event, String type) {
        if (event == null) {
            return null;
        }
        ContentValues values = new ContentValues(4);
        values.put("eventid", Integer.valueOf(event.mo41158c()));
        values.put("timestamp", Long.valueOf(event.mo41159d()));
        values.put("type", type);
        values.put("data", event.mo41154a());
        return values;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS events");
        onCreate(db);
    }

    /* renamed from: a */
    private synchronized SQLiteDatabase m41116a(boolean writable) throws Throwable {
        int count = 0;
        while (true) {
            if (writable) {
                try {
                    return getWritableDatabase();
                } catch (Throwable t) {
                    count++;
                    if (count < 4) {
                        SystemClock.sleep((long) (count * 400));
                    } else {
                        throw t;
                    }
                }
            } else {
                return getReadableDatabase();
            }
        }
    }
}
