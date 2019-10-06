package com.liulishuo.filedownloader.services;

import com.liulishuo.filedownloader.model.C10912b;
import com.liulishuo.filedownloader.model.C10913c;
import java.io.File;
import java.util.List;
import p019d.p307j.p308a.C13072E;
import p019d.p307j.p308a.p313e.C13113c.C13114a;
import p019d.p307j.p308a.p313e.C13113c.C13116c;
import p019d.p307j.p308a.p313e.C13117d;
import p019d.p307j.p308a.p313e.C13121g;

/* renamed from: com.liulishuo.filedownloader.services.h */
/* compiled from: FileDownloadMgr */
class C10923h implements C13072E {

    /* renamed from: a */
    private final C10922g f33367a;

    /* renamed from: b */
    private final C10925j f33368b;

    /* renamed from: c */
    private final C13116c f33369c;

    /* renamed from: d */
    private final C13114a f33370d;

    public C10923h(C10917d params) {
        this.f33367a = params.mo35772b();
        this.f33368b = new C10925j(params.mo35774d());
        this.f33369c = params.mo35773c();
        this.f33370d = params.mo35771a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a3, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f5  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo35797a(java.lang.String r21, java.lang.String r22, boolean r23, int r24, int r25, int r26, boolean r27, com.liulishuo.filedownloader.model.FileDownloadHeader r28, boolean r29) {
        /*
            r20 = this;
            r13 = r20
            r0 = r21
            r14 = r22
            r15 = r23
            monitor-enter(r20)
            boolean r1 = p019d.p307j.p308a.p313e.C13117d.f40139a     // Catch:{ all -> 0x0124 }
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0022
            java.lang.String r1 = "request start the task with url(%s) path(%s) isDirectory(%B)"
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0124 }
            r5[r3] = r0     // Catch:{ all -> 0x0124 }
            r5[r4] = r14     // Catch:{ all -> 0x0124 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r23)     // Catch:{ all -> 0x0124 }
            r5[r2] = r6     // Catch:{ all -> 0x0124 }
            p019d.p307j.p308a.p313e.C13117d.m42778a(r13, r1, r5)     // Catch:{ all -> 0x0124 }
        L_0x0022:
            int r1 = p019d.p307j.p308a.p313e.C13121g.m42787a(r21, r22, r23)     // Catch:{ all -> 0x0124 }
            r12 = r1
            com.liulishuo.filedownloader.services.g r1 = r13.f33367a     // Catch:{ all -> 0x0124 }
            com.liulishuo.filedownloader.model.b r1 = r1.mo35757a(r12)     // Catch:{ all -> 0x0124 }
            if (r15 != 0) goto L_0x0063
            if (r1 != 0) goto L_0x0063
            java.lang.String r5 = p019d.p307j.p308a.p313e.C13121g.m42807f(r22)     // Catch:{ all -> 0x0124 }
            int r5 = p019d.p307j.p308a.p313e.C13121g.m42787a(r0, r5, r4)     // Catch:{ all -> 0x0124 }
            com.liulishuo.filedownloader.services.g r6 = r13.f33367a     // Catch:{ all -> 0x0124 }
            com.liulishuo.filedownloader.model.b r6 = r6.mo35757a(r5)     // Catch:{ all -> 0x0124 }
            r1 = r6
            if (r1 == 0) goto L_0x0063
            java.lang.String r6 = r1.mo35735h()     // Catch:{ all -> 0x0124 }
            boolean r6 = r14.equals(r6)     // Catch:{ all -> 0x0124 }
            if (r6 == 0) goto L_0x0063
            boolean r6 = p019d.p307j.p308a.p313e.C13117d.f40139a     // Catch:{ all -> 0x0124 }
            if (r6 == 0) goto L_0x0063
            java.lang.String r6 = "task[%d] find model by dirCaseId[%d]"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0124 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0124 }
            r2[r3] = r7     // Catch:{ all -> 0x0124 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0124 }
            r2[r4] = r7     // Catch:{ all -> 0x0124 }
            p019d.p307j.p308a.p313e.C13117d.m42778a(r13, r6, r2)     // Catch:{ all -> 0x0124 }
        L_0x0063:
            boolean r2 = p019d.p307j.p308a.p313e.C13113c.m42770a(r12, r1, r13, r4)     // Catch:{ all -> 0x0124 }
            if (r2 == 0) goto L_0x007c
            boolean r2 = p019d.p307j.p308a.p313e.C13117d.f40139a     // Catch:{ all -> 0x0124 }
            if (r2 == 0) goto L_0x007a
            java.lang.String r2 = "has already started download %d"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0124 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0124 }
            r4[r3] = r5     // Catch:{ all -> 0x0124 }
            p019d.p307j.p308a.p313e.C13117d.m42778a(r13, r2, r4)     // Catch:{ all -> 0x0124 }
        L_0x007a:
            monitor-exit(r20)
            return
        L_0x007c:
            if (r1 == 0) goto L_0x0083
            java.lang.String r2 = r1.mo35735h()     // Catch:{ all -> 0x0124 }
            goto L_0x0088
        L_0x0083:
            r2 = 0
            java.lang.String r2 = p019d.p307j.p308a.p313e.C13121g.m42791a(r14, r15, r2)     // Catch:{ all -> 0x0124 }
        L_0x0088:
            r11 = r2
            r10 = r27
            boolean r2 = p019d.p307j.p308a.p313e.C13113c.m42771a(r12, r11, r10, r4)     // Catch:{ all -> 0x0124 }
            if (r2 == 0) goto L_0x00a4
            boolean r2 = p019d.p307j.p308a.p313e.C13117d.f40139a     // Catch:{ all -> 0x0124 }
            if (r2 == 0) goto L_0x00a2
            java.lang.String r2 = "has already completed downloading %d"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0124 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0124 }
            r4[r3] = r5     // Catch:{ all -> 0x0124 }
            p019d.p307j.p308a.p313e.C13117d.m42778a(r13, r2, r4)     // Catch:{ all -> 0x0124 }
        L_0x00a2:
            monitor-exit(r20)
            return
        L_0x00a4:
            if (r1 == 0) goto L_0x00d3
            byte r2 = r1.mo35734g()     // Catch:{ all -> 0x0124 }
            r3 = -2
            if (r2 == r3) goto L_0x00b4
            byte r2 = r1.mo35734g()     // Catch:{ all -> 0x0124 }
            r3 = -1
            if (r2 != r3) goto L_0x00d3
        L_0x00b4:
            int r2 = r1.mo35730d()     // Catch:{ all -> 0x0124 }
            if (r2 == r12) goto L_0x00ce
            com.liulishuo.filedownloader.services.g r2 = r13.f33367a     // Catch:{ all -> 0x0124 }
            int r3 = r1.mo35730d()     // Catch:{ all -> 0x0124 }
            r2.remove(r3)     // Catch:{ all -> 0x0124 }
            r1.mo35721a(r12)     // Catch:{ all -> 0x0124 }
            r1.mo35724a(r14, r15)     // Catch:{ all -> 0x0124 }
            r2 = 1
            r9 = r1
            r16 = r2
            goto L_0x00f3
        L_0x00ce:
            r2 = 0
            r9 = r1
            r16 = r2
            goto L_0x00f3
        L_0x00d3:
            if (r1 != 0) goto L_0x00db
            com.liulishuo.filedownloader.model.b r2 = new com.liulishuo.filedownloader.model.b     // Catch:{ all -> 0x0124 }
            r2.<init>()     // Catch:{ all -> 0x0124 }
            r1 = r2
        L_0x00db:
            r1.mo35731d(r0)     // Catch:{ all -> 0x0124 }
            r1.mo35724a(r14, r15)     // Catch:{ all -> 0x0124 }
            r1.mo35721a(r12)     // Catch:{ all -> 0x0124 }
            r2 = 0
            r1.mo35722a(r2)     // Catch:{ all -> 0x0124 }
            r1.mo35726b(r2)     // Catch:{ all -> 0x0124 }
            r1.mo35720a(r4)     // Catch:{ all -> 0x0124 }
            r2 = 1
            r9 = r1
            r16 = r2
        L_0x00f3:
            if (r16 == 0) goto L_0x00fa
            com.liulishuo.filedownloader.services.g r1 = r13.f33367a     // Catch:{ all -> 0x0124 }
            r1.mo35758a(r9)     // Catch:{ all -> 0x0124 }
        L_0x00fa:
            com.liulishuo.filedownloader.services.j r8 = r13.f33368b     // Catch:{ all -> 0x0124 }
            com.liulishuo.filedownloader.services.i r7 = new com.liulishuo.filedownloader.services.i     // Catch:{ all -> 0x0124 }
            d.j.a.e.c$c r3 = r13.f33369c     // Catch:{ all -> 0x0124 }
            d.j.a.e.c$a r4 = r13.f33370d     // Catch:{ all -> 0x0124 }
            com.liulishuo.filedownloader.services.g r6 = r13.f33367a     // Catch:{ all -> 0x0124 }
            r1 = r7
            r2 = r20
            r5 = r9
            r0 = r7
            r7 = r26
            r14 = r8
            r8 = r28
            r17 = r9
            r9 = r25
            r10 = r24
            r18 = r11
            r11 = r27
            r19 = r12
            r12 = r29
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0124 }
            r14.mo35819a(r0)     // Catch:{ all -> 0x0124 }
            monitor-exit(r20)
            return
        L_0x0124:
            r0 = move-exception
            monitor-exit(r20)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.services.C10923h.mo35797a(java.lang.String, java.lang.String, boolean, int, int, int, boolean, com.liulishuo.filedownloader.model.FileDownloadHeader, boolean):void");
    }

    /* renamed from: a */
    public boolean mo35800a(String url, String path) {
        return mo35806e(C13121g.m42797b(url, path));
    }

    /* renamed from: e */
    public boolean mo35806e(int id) {
        return mo35799a(this.f33367a.mo35757a(id));
    }

    /* renamed from: a */
    public static boolean m35879a(int id, C10912b model) {
        return m35880a(id, model, null);
    }

    /* renamed from: a */
    public static boolean m35880a(int id, C10912b model, Boolean outputStreamSupportSeek) {
        if (model == null) {
            if (C13117d.f40139a) {
                C13117d.m42778a(C10923h.class, "can't continue %d model == null", Integer.valueOf(id));
            }
            return false;
        } else if (model.mo35736i() != null) {
            return m35881a(id, model, model.mo35736i(), outputStreamSupportSeek);
        } else {
            if (C13117d.f40139a) {
                C13117d.m42778a(C10923h.class, "can't continue %d temp path == null", Integer.valueOf(id));
            }
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m35881a(int id, C10912b model, String path, Boolean outputStreamSupportSeek) {
        String str = path;
        if (str != null) {
            File file = new File(str);
            boolean isExists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (isExists && !isDirectory) {
                long fileLength = file.length();
                if (model.mo35733f() == 0) {
                    if (!C13117d.f40139a) {
                        return false;
                    }
                    C13117d.m42778a(C10923h.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(id));
                    return false;
                } else if (fileLength < model.mo35733f() || (model.mo35737j() != -1 && (fileLength > model.mo35737j() || model.mo35733f() >= model.mo35737j()))) {
                    if (!C13117d.f40139a) {
                        return false;
                    }
                    C13117d.m42778a(C10923h.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(id), Long.valueOf(fileLength), Long.valueOf(model.mo35733f()), Long.valueOf(model.mo35737j()));
                    return false;
                } else if (outputStreamSupportSeek == null || outputStreamSupportSeek.booleanValue() || model.mo35737j() != fileLength) {
                    return true;
                } else {
                    if (!C13117d.f40139a) {
                        return false;
                    }
                    C13117d.m42778a(C10923h.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(id));
                    return false;
                }
            } else if (!C13117d.f40139a) {
                return false;
            } else {
                C13117d.m42778a(C10923h.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(id), Boolean.valueOf(isExists), Boolean.valueOf(isDirectory));
                return false;
            }
        } else if (!C13117d.f40139a) {
            return false;
        } else {
            C13117d.m42778a(C10923h.class, "can't continue %d path = null", Integer.valueOf(id));
            return false;
        }
    }

    /* renamed from: f */
    public boolean mo35807f(int id) {
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "request pause the task %d", Integer.valueOf(id));
        }
        if (this.f33367a.mo35757a(id) == null) {
            return false;
        }
        this.f33368b.mo35818a(id);
        return true;
    }

    /* renamed from: c */
    public void mo35804c() {
        List<Integer> list = this.f33368b.mo35820b();
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "pause all tasks %d", Integer.valueOf(list.size()));
        }
        for (Integer id : list) {
            mo35807f(id.intValue());
        }
    }

    /* renamed from: b */
    public long mo35801b(int id) {
        C10912b model = this.f33367a.mo35757a(id);
        if (model == null) {
            return 0;
        }
        return model.mo35733f();
    }

    /* renamed from: d */
    public long mo35805d(int id) {
        C10912b model = this.f33367a.mo35757a(id);
        if (model == null) {
            return 0;
        }
        return model.mo35737j();
    }

    /* renamed from: c */
    public byte mo35803c(int id) {
        C10912b model = this.f33367a.mo35757a(id);
        if (model == null) {
            return 0;
        }
        return model.mo35734g();
    }

    /* renamed from: b */
    public boolean mo35802b() {
        return this.f33368b.mo35817a() <= 0;
    }

    /* renamed from: g */
    public synchronized boolean mo35808g(int count) {
        return this.f33368b.mo35822c(count);
    }

    /* renamed from: a */
    public boolean mo35799a(C10912b model) {
        boolean isDownloading;
        if (model == null) {
            return false;
        }
        boolean isInPool = this.f33368b.mo35821b(model.mo35730d());
        if (C10913c.m35800b(model.mo35734g())) {
            if (isInPool) {
                isDownloading = true;
            } else {
                isDownloading = false;
            }
        } else if (isInPool) {
            isDownloading = true;
        } else {
            C13117d.m42780b(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(model.mo35730d()), Byte.valueOf(model.mo35734g()));
            isDownloading = false;
        }
        return isDownloading;
    }

    /* renamed from: a */
    public boolean mo35798a(int id) {
        if (id == 0) {
            C13117d.m42783e(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(id));
            return false;
        } else if (mo35806e(id)) {
            C13117d.m42783e(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(id));
            return false;
        } else {
            this.f33367a.remove(id);
            return true;
        }
    }

    /* renamed from: a */
    public void mo35796a() {
        this.f33367a.clear();
    }
}
