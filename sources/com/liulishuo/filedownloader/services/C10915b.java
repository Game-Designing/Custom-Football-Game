package com.liulishuo.filedownloader.services;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import com.liulishuo.filedownloader.model.C10912b;
import p019d.p307j.p308a.p313e.C13113c;
import p019d.p307j.p308a.p313e.C13117d;

/* renamed from: com.liulishuo.filedownloader.services.b */
/* compiled from: DefaultDatabaseImpl */
class C10915b implements C10922g {

    /* renamed from: a */
    private final SQLiteDatabase f33355a = new C10916c(C13113c.m42768a()).getWritableDatabase();

    /* renamed from: b */
    private final SparseArray<C10912b> f33356b = new SparseArray<>();

    public C10915b() {
        m35810a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x025f  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m35810a() {
        /*
            r26 = this;
            r1 = r26
            java.lang.String r2 = "delete %s"
            java.lang.String r3 = "filedownloader"
            java.lang.String r4 = "DELETE FROM %s WHERE %s IN (%s);"
            java.lang.String r5 = "refresh data %d , will delete: %d consume %d"
            java.lang.String r6 = ", "
            java.lang.String r7 = "_id"
            long r8 = java.lang.System.currentTimeMillis()
            android.database.sqlite.SQLiteDatabase r0 = r1.f33355a
            r10 = 0
            java.lang.String r11 = "SELECT * FROM filedownloader"
            android.database.Cursor r11 = r0.rawQuery(r11, r10)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r12 = r0
        L_0x0021:
            r15 = 1
            boolean r0 = r11.moveToNext()     // Catch:{ all -> 0x0223 }
            if (r0 == 0) goto L_0x01b9
            com.liulishuo.filedownloader.model.b r0 = new com.liulishuo.filedownloader.model.b     // Catch:{ all -> 0x0223 }
            r0.<init>()     // Catch:{ all -> 0x0223 }
            int r10 = r11.getColumnIndex(r7)     // Catch:{ all -> 0x0223 }
            int r10 = r11.getInt(r10)     // Catch:{ all -> 0x0223 }
            r0.mo35721a(r10)     // Catch:{ all -> 0x0223 }
            java.lang.String r10 = "url"
            int r10 = r11.getColumnIndex(r10)     // Catch:{ all -> 0x0223 }
            java.lang.String r10 = r11.getString(r10)     // Catch:{ all -> 0x0223 }
            r0.mo35731d(r10)     // Catch:{ all -> 0x0223 }
            java.lang.String r10 = "path"
            int r10 = r11.getColumnIndex(r10)     // Catch:{ all -> 0x0223 }
            java.lang.String r10 = r11.getString(r10)     // Catch:{ all -> 0x0223 }
            java.lang.String r13 = "pathAsDirectory"
            int r13 = r11.getColumnIndex(r13)     // Catch:{ all -> 0x0223 }
            short r13 = r11.getShort(r13)     // Catch:{ all -> 0x0223 }
            if (r13 != r15) goto L_0x005d
            r13 = 1
            goto L_0x005e
        L_0x005d:
            r13 = 0
        L_0x005e:
            r0.mo35724a(r10, r13)     // Catch:{ all -> 0x0223 }
            java.lang.String r10 = "status"
            int r10 = r11.getColumnIndex(r10)     // Catch:{ all -> 0x0223 }
            short r10 = r11.getShort(r10)     // Catch:{ all -> 0x0223 }
            byte r10 = (byte) r10     // Catch:{ all -> 0x0223 }
            r0.mo35720a(r10)     // Catch:{ all -> 0x0223 }
            java.lang.String r10 = "sofar"
            int r10 = r11.getColumnIndex(r10)     // Catch:{ all -> 0x0223 }
            long r14 = r11.getLong(r10)     // Catch:{ all -> 0x0223 }
            r0.mo35722a(r14)     // Catch:{ all -> 0x0223 }
            java.lang.String r10 = "total"
            int r10 = r11.getColumnIndex(r10)     // Catch:{ all -> 0x0223 }
            long r14 = r11.getLong(r10)     // Catch:{ all -> 0x0223 }
            r0.mo35726b(r14)     // Catch:{ all -> 0x0223 }
            java.lang.String r10 = "errMsg"
            int r10 = r11.getColumnIndex(r10)     // Catch:{ all -> 0x0223 }
            java.lang.String r10 = r11.getString(r10)     // Catch:{ all -> 0x0223 }
            r0.mo35727b(r10)     // Catch:{ all -> 0x0223 }
            java.lang.String r10 = "etag"
            int r10 = r11.getColumnIndex(r10)     // Catch:{ all -> 0x0223 }
            java.lang.String r10 = r11.getString(r10)     // Catch:{ all -> 0x0223 }
            r0.mo35723a(r10)     // Catch:{ all -> 0x0223 }
            java.lang.String r10 = "filename"
            int r10 = r11.getColumnIndex(r10)     // Catch:{ all -> 0x0223 }
            java.lang.String r10 = r11.getString(r10)     // Catch:{ all -> 0x0223 }
            r0.mo35729c(r10)     // Catch:{ all -> 0x0223 }
            byte r10 = r0.mo35734g()     // Catch:{ all -> 0x0223 }
            r14 = 0
            r13 = 3
            if (r10 == r13) goto L_0x00d6
            byte r13 = r0.mo35734g()     // Catch:{ all -> 0x0223 }
            r10 = 2
            if (r13 == r10) goto L_0x00d6
            byte r10 = r0.mo35734g()     // Catch:{ all -> 0x0223 }
            r13 = -1
            if (r10 == r13) goto L_0x00d6
            byte r10 = r0.mo35734g()     // Catch:{ all -> 0x0223 }
            r13 = 1
            if (r10 != r13) goto L_0x00da
            long r22 = r0.mo35733f()     // Catch:{ all -> 0x0223 }
            int r10 = (r22 > r14 ? 1 : (r22 == r14 ? 0 : -1))
            if (r10 <= 0) goto L_0x00da
        L_0x00d6:
            r10 = -2
            r0.mo35720a(r10)     // Catch:{ all -> 0x0223 }
        L_0x00da:
            java.lang.String r10 = r0.mo35735h()     // Catch:{ all -> 0x0223 }
            if (r10 != 0) goto L_0x00ee
            int r13 = r0.mo35730d()     // Catch:{ all -> 0x0223 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0223 }
            r12.add(r13)     // Catch:{ all -> 0x0223 }
            r10 = 0
            goto L_0x0021
        L_0x00ee:
            java.io.File r13 = new java.io.File     // Catch:{ all -> 0x0223 }
            r13.<init>(r10)     // Catch:{ all -> 0x0223 }
            byte r14 = r0.mo35734g()     // Catch:{ all -> 0x0223 }
            r15 = -2
            if (r14 != r15) goto L_0x015c
            int r14 = r0.mo35730d()     // Catch:{ all -> 0x0223 }
            java.lang.String r15 = r0.mo35732e()     // Catch:{ all -> 0x0223 }
            r21 = r10
            r10 = 0
            boolean r14 = com.liulishuo.filedownloader.services.C10923h.m35881a(r14, r0, r15, r10)     // Catch:{ all -> 0x0223 }
            if (r14 == 0) goto L_0x0157
            java.io.File r14 = new java.io.File     // Catch:{ all -> 0x0223 }
            java.lang.String r15 = r0.mo35736i()     // Catch:{ all -> 0x0223 }
            r14.<init>(r15)     // Catch:{ all -> 0x0223 }
            boolean r15 = r14.exists()     // Catch:{ all -> 0x0223 }
            if (r15 != 0) goto L_0x0152
            boolean r15 = r13.exists()     // Catch:{ all -> 0x0223 }
            if (r15 == 0) goto L_0x0152
            boolean r15 = r13.renameTo(r14)     // Catch:{ all -> 0x0223 }
            boolean r17 = p019d.p307j.p308a.p313e.C13117d.f40139a     // Catch:{ all -> 0x0223 }
            if (r17 == 0) goto L_0x014d
            java.lang.String r10 = "resume from the old no-temp-file architecture [%B], [%s]->[%s]"
            r20 = r5
            r24 = r13
            r13 = 3
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch:{ all -> 0x01b5 }
            java.lang.Boolean r25 = java.lang.Boolean.valueOf(r15)     // Catch:{ all -> 0x01b5 }
            r16 = 0
            r5[r16] = r25     // Catch:{ all -> 0x01b5 }
            java.lang.String r25 = r24.getPath()     // Catch:{ all -> 0x01b5 }
            r19 = 1
            r5[r19] = r25     // Catch:{ all -> 0x01b5 }
            java.lang.String r25 = r14.getPath()     // Catch:{ all -> 0x01b5 }
            r18 = 2
            r5[r18] = r25     // Catch:{ all -> 0x01b5 }
            p019d.p307j.p308a.p313e.C13117d.m42778a(r1, r10, r5)     // Catch:{ all -> 0x01b5 }
            goto L_0x0162
        L_0x014d:
            r20 = r5
            r24 = r13
            goto L_0x0162
        L_0x0152:
            r20 = r5
            r24 = r13
            goto L_0x0162
        L_0x0157:
            r20 = r5
            r24 = r13
            goto L_0x0162
        L_0x015c:
            r20 = r5
            r21 = r10
            r24 = r13
        L_0x0162:
            byte r5 = r0.mo35734g()     // Catch:{ all -> 0x01b5 }
            r10 = 1
            if (r5 != r10) goto L_0x017f
            long r14 = r0.mo35733f()     // Catch:{ all -> 0x01b5 }
            r22 = 0
            int r5 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r5 > 0) goto L_0x017f
            int r5 = r0.mo35730d()     // Catch:{ all -> 0x01b5 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x01b5 }
            r12.add(r5)     // Catch:{ all -> 0x01b5 }
            goto L_0x01b0
        L_0x017f:
            int r5 = r0.mo35730d()     // Catch:{ all -> 0x01b5 }
            boolean r5 = com.liulishuo.filedownloader.services.C10923h.m35879a(r5, r0)     // Catch:{ all -> 0x01b5 }
            if (r5 != 0) goto L_0x0195
            int r5 = r0.mo35730d()     // Catch:{ all -> 0x01b5 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x01b5 }
            r12.add(r5)     // Catch:{ all -> 0x01b5 }
            goto L_0x01b0
        L_0x0195:
            boolean r5 = r24.exists()     // Catch:{ all -> 0x01b5 }
            if (r5 == 0) goto L_0x01a7
            int r5 = r0.mo35730d()     // Catch:{ all -> 0x01b5 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x01b5 }
            r12.add(r5)     // Catch:{ all -> 0x01b5 }
            goto L_0x01b0
        L_0x01a7:
            android.util.SparseArray<com.liulishuo.filedownloader.model.b> r5 = r1.f33356b     // Catch:{ all -> 0x01b5 }
            int r10 = r0.mo35730d()     // Catch:{ all -> 0x01b5 }
            r5.put(r10, r0)     // Catch:{ all -> 0x01b5 }
        L_0x01b0:
            r5 = r20
            r10 = 0
            goto L_0x0021
        L_0x01b5:
            r0 = move-exception
            r5 = r20
            goto L_0x0224
        L_0x01b9:
            r20 = r5
            r11.close()
            android.content.Context r0 = p019d.p307j.p308a.p313e.C13113c.m42768a()
            p019d.p307j.p308a.p313e.C13121g.m42804d(r0)
            int r0 = r12.size()
            if (r0 <= 0) goto L_0x01f2
            java.lang.String r0 = android.text.TextUtils.join(r6, r12)
            boolean r5 = p019d.p307j.p308a.p313e.C13117d.f40139a
            if (r5 == 0) goto L_0x01dd
            r5 = 1
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r10 = 0
            r6[r10] = r0
            p019d.p307j.p308a.p313e.C13117d.m42778a(r1, r2, r6)
            goto L_0x01df
        L_0x01dd:
            r5 = 1
            r10 = 0
        L_0x01df:
            android.database.sqlite.SQLiteDatabase r2 = r1.f33355a
            r6 = 3
            java.lang.Object[] r14 = new java.lang.Object[r6]
            r14[r10] = r3
            r14[r5] = r7
            r3 = 2
            r14[r3] = r0
            java.lang.String r3 = p019d.p307j.p308a.p313e.C13121g.m42792a(r4, r14)
            r2.execSQL(r3)
        L_0x01f2:
            boolean r0 = p019d.p307j.p308a.p313e.C13117d.f40139a
            if (r0 == 0) goto L_0x0222
            r2 = 3
            java.lang.Object[] r0 = new java.lang.Object[r2]
            android.util.SparseArray<com.liulishuo.filedownloader.model.b> r2 = r1.f33356b
            int r2 = r2.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = 0
            r0[r3] = r2
            int r2 = r12.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = 1
            r0[r3] = r2
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r8
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r3 = 2
            r0[r3] = r2
            r5 = r20
            p019d.p307j.p308a.p313e.C13117d.m42778a(r1, r5, r0)
        L_0x0222:
            return
        L_0x0223:
            r0 = move-exception
        L_0x0224:
            r11.close()
            android.content.Context r10 = p019d.p307j.p308a.p313e.C13113c.m42768a()
            p019d.p307j.p308a.p313e.C13121g.m42804d(r10)
            int r10 = r12.size()
            if (r10 <= 0) goto L_0x025b
            java.lang.String r6 = android.text.TextUtils.join(r6, r12)
            boolean r10 = p019d.p307j.p308a.p313e.C13117d.f40139a
            if (r10 == 0) goto L_0x0246
            r10 = 1
            java.lang.Object[] r14 = new java.lang.Object[r10]
            r15 = 0
            r14[r15] = r6
            p019d.p307j.p308a.p313e.C13117d.m42778a(r1, r2, r14)
            goto L_0x0248
        L_0x0246:
            r10 = 1
            r15 = 0
        L_0x0248:
            android.database.sqlite.SQLiteDatabase r2 = r1.f33355a
            r13 = 3
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r15] = r3
            r14[r10] = r7
            r3 = 2
            r14[r3] = r6
            java.lang.String r3 = p019d.p307j.p308a.p313e.C13121g.m42792a(r4, r14)
            r2.execSQL(r3)
        L_0x025b:
            boolean r2 = p019d.p307j.p308a.p313e.C13117d.f40139a
            if (r2 == 0) goto L_0x0289
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            android.util.SparseArray<com.liulishuo.filedownloader.model.b> r3 = r1.f33356b
            int r3 = r3.size()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = 0
            r2[r4] = r3
            int r3 = r12.size()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = 1
            r2[r4] = r3
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r8
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r4 = 2
            r2[r4] = r3
            p019d.p307j.p308a.p313e.C13117d.m42778a(r1, r5, r2)
        L_0x0289:
            goto L_0x028b
        L_0x028a:
            throw r0
        L_0x028b:
            goto L_0x028a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.services.C10915b.m35810a():void");
    }

    /* renamed from: a */
    public C10912b mo35757a(int id) {
        return (C10912b) this.f33356b.get(id);
    }

    /* renamed from: c */
    public void mo35765c(C10912b downloadModel) {
        this.f33356b.put(downloadModel.mo35730d(), downloadModel);
        this.f33355a.insert("filedownloader", null, downloadModel.mo35741n());
    }

    /* renamed from: a */
    public void mo35758a(C10912b downloadModel) {
        if (downloadModel == null) {
            C13117d.m42783e(this, "update but model == null!", new Object[0]);
            return;
        }
        if (mo35757a(downloadModel.mo35730d()) != null) {
            this.f33356b.remove(downloadModel.mo35730d());
            this.f33356b.put(downloadModel.mo35730d(), downloadModel);
            ContentValues cv = downloadModel.mo35741n();
            this.f33355a.update("filedownloader", cv, "_id = ? ", new String[]{String.valueOf(downloadModel.mo35730d())});
        } else {
            mo35765c(downloadModel);
        }
    }

    public boolean remove(int id) {
        this.f33356b.remove(id);
        return this.f33355a.delete("filedownloader", "_id = ?", new String[]{String.valueOf(id)}) != 0;
    }

    public void clear() {
        this.f33356b.clear();
        this.f33355a.delete("filedownloader", null, null);
    }

    /* renamed from: a */
    public void mo35760a(C10912b model, long total, String etag, String filename) {
        model.mo35720a(2);
        ContentValues cv = new ContentValues();
        cv.put("status", Byte.valueOf(2));
        if (model.mo35737j() != total) {
            model.mo35726b(total);
            cv.put("total", Long.valueOf(total));
        }
        String oldEtag = model.mo35719a();
        if ((etag != null && !etag.equals(oldEtag)) || (oldEtag != null && !oldEtag.equals(etag))) {
            model.mo35723a(etag);
            cv.put("etag", etag);
        }
        if (model.mo35740m() && model.mo35728c() == null && filename != null) {
            model.mo35729c(filename);
            cv.put("filename", filename);
        }
        m35811a(model.mo35730d(), cv);
    }

    /* renamed from: b */
    public void mo35764b(C10912b model, long soFar) {
        model.mo35720a(3);
        model.mo35722a(soFar);
        ContentValues cv = new ContentValues();
        cv.put("status", Byte.valueOf(3));
        cv.put("sofar", Long.valueOf(soFar));
        m35811a(model.mo35730d(), cv);
    }

    /* renamed from: a */
    public void mo35762a(C10912b model, Throwable throwable, long sofar) {
        String errMsg = throwable.toString();
        model.mo35720a(-1);
        model.mo35727b(errMsg);
        model.mo35722a(sofar);
        ContentValues cv = new ContentValues();
        cv.put("errMsg", errMsg);
        cv.put("status", Byte.valueOf(-1));
        cv.put("sofar", Long.valueOf(sofar));
        m35811a(model.mo35730d(), cv);
    }

    /* renamed from: a */
    public void mo35761a(C10912b model, Throwable throwable) {
        String errMsg = throwable.toString();
        model.mo35720a(5);
        model.mo35727b(errMsg);
        ContentValues cv = new ContentValues();
        cv.put("errMsg", errMsg);
        cv.put("status", Byte.valueOf(5));
        m35811a(model.mo35730d(), cv);
    }

    /* renamed from: a */
    public void mo35759a(C10912b model, long total) {
        model.mo35720a(-3);
        model.mo35722a(total);
        model.mo35726b(total);
        ContentValues cv = new ContentValues();
        cv.put("status", Byte.valueOf(-3));
        cv.put("total", Long.valueOf(total));
        cv.put("sofar", Long.valueOf(total));
        m35811a(model.mo35730d(), cv);
    }

    /* renamed from: c */
    public void mo35766c(C10912b model, long sofar) {
        model.mo35720a(-2);
        model.mo35722a(sofar);
        ContentValues cv = new ContentValues();
        cv.put("status", Byte.valueOf(-2));
        cv.put("sofar", Long.valueOf(sofar));
        m35811a(model.mo35730d(), cv);
    }

    /* renamed from: b */
    public void mo35763b(C10912b model) {
        model.mo35720a(1);
        ContentValues cv = new ContentValues();
        cv.put("status", Byte.valueOf(1));
        m35811a(model.mo35730d(), cv);
    }

    /* renamed from: a */
    private void m35811a(int id, ContentValues cv) {
        this.f33355a.update("filedownloader", cv, "_id = ? ", new String[]{String.valueOf(id)});
    }
}
