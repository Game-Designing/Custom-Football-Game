package p019d.p307j.p308a;

import com.liulishuo.filedownloader.BaseDownloadTask.FinishListener;
import com.liulishuo.filedownloader.message.C10907e;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.message.MessageSnapshot.C10900a;
import com.liulishuo.filedownloader.model.C10913c;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import p019d.p307j.p308a.C13069D.C13070a;
import p019d.p307j.p308a.C13069D.C13071b;
import p019d.p307j.p308a.C13079a.C13080a;
import p019d.p307j.p308a.C13079a.C13081b;
import p019d.p307j.p308a.C13079a.C13083d;
import p019d.p307j.p308a.p313e.C13117d;
import p019d.p307j.p308a.p313e.C13121g;

/* renamed from: d.j.a.e */
/* compiled from: DownloadTaskHunter */
public class C13108e implements C13069D, C13071b, C13070a, C13083d {

    /* renamed from: a */
    private C13153z f40120a;

    /* renamed from: b */
    private final Object f40121b;

    /* renamed from: c */
    private final C13109a f40122c;

    /* renamed from: d */
    private volatile byte f40123d = 0;

    /* renamed from: e */
    private Throwable f40124e = null;

    /* renamed from: f */
    private final C13152y f40125f;

    /* renamed from: g */
    private final C13151x f40126g;

    /* renamed from: h */
    private long f40127h;

    /* renamed from: i */
    private long f40128i;

    /* renamed from: j */
    private int f40129j;

    /* renamed from: k */
    private boolean f40130k;

    /* renamed from: l */
    private boolean f40131l;

    /* renamed from: m */
    private String f40132m;

    /* renamed from: n */
    private boolean f40133n = false;

    /* renamed from: d.j.a.e$a */
    /* compiled from: DownloadTaskHunter */
    interface C13109a {
        /* renamed from: a */
        void mo42080a(String str);

        /* renamed from: c */
        C13081b mo42081c();

        /* renamed from: p */
        FileDownloadHeader mo42082p();

        /* renamed from: x */
        ArrayList<C13080a> mo42084x();
    }

    /* renamed from: a */
    public boolean mo41990a(MessageSnapshot snapshot) {
        if (!C10913c.m35798a(getStatus(), snapshot.mo35687k())) {
            if (C13117d.f40139a) {
                C13117d.m42778a(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f40123d), Byte.valueOf(getStatus()), Integer.valueOf(m42738k()));
            }
            return false;
        }
        m42737e(snapshot);
        return true;
    }

    /* renamed from: b */
    public boolean mo41991b(MessageSnapshot snapshot) {
        int currentStatus = getStatus();
        int nextStatus = snapshot.mo35687k();
        if (-2 == currentStatus && C10913c.m35797a(nextStatus)) {
            if (C13117d.f40139a) {
                C13117d.m42778a(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(m42738k()));
            }
            return true;
        } else if (!C10913c.m35801b(currentStatus, nextStatus)) {
            if (C13117d.f40139a) {
                C13117d.m42778a(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f40123d), Byte.valueOf(getStatus()), Integer.valueOf(m42738k()));
            }
            return false;
        } else {
            m42737e(snapshot);
            return true;
        }
    }

    /* renamed from: d */
    public boolean mo41993d(MessageSnapshot snapshot) {
        if (!C10913c.m35799a(this.f40122c.mo42081c().mo42043F())) {
            return false;
        }
        m42737e(snapshot);
        return true;
    }

    /* renamed from: c */
    public boolean mo41992c(MessageSnapshot snapshot) {
        if (!this.f40122c.mo42081c().mo42043F().mo42034q() || snapshot.mo35687k() != -4 || getStatus() != 2) {
            return false;
        }
        m42737e(snapshot);
        return true;
    }

    /* renamed from: i */
    public C13153z mo41994i() {
        return this.f40120a;
    }

    /* renamed from: a */
    public MessageSnapshot mo41989a(Throwable cause) {
        this.f40123d = -1;
        this.f40124e = cause;
        return C10907e.m35765a(this.f40122c.mo42081c().mo42043F());
    }

    /* renamed from: e */
    private void m42737e(MessageSnapshot snapshot) {
        int sameStoreTaskCount;
        C13079a task = this.f40122c.mo42081c().mo42043F();
        byte status = snapshot.mo35687k();
        this.f40123d = status;
        this.f40130k = snapshot.mo35702m();
        if (status == -4) {
            this.f40125f.reset();
            int sameIdTaskCount = C13128k.m42819b().mo42099a(task.getId());
            if (sameIdTaskCount > 1 || !task.mo42034q()) {
                sameStoreTaskCount = 0;
            } else {
                sameStoreTaskCount = C13128k.m42819b().mo42099a(C13121g.m42797b(task.getUrl(), task.mo42037u()));
            }
            if (sameIdTaskCount + sameStoreTaskCount <= 1) {
                int currentStatus = C13139r.m42869c().mo41966a(task.getId());
                C13117d.m42783e(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(task.getId()), Integer.valueOf(currentStatus));
                if (C10913c.m35797a(currentStatus)) {
                    this.f40123d = 1;
                    this.f40128i = snapshot.mo35691g();
                    this.f40127h = snapshot.mo35697f();
                    this.f40125f.start();
                    this.f40120a.mo42118a(((C10900a) snapshot).mo35700a());
                    return;
                }
            }
            C13128k.m42819b().mo42104a(this.f40122c.mo42081c(), snapshot);
        } else if (status == -3) {
            this.f40133n = snapshot.mo35692o();
            this.f40127h = snapshot.mo35691g();
            this.f40128i = snapshot.mo35691g();
            this.f40125f.mo42059b(this.f40127h);
            C13128k.m42819b().mo42104a(this.f40122c.mo42081c(), snapshot);
        } else if (status == -2) {
        } else {
            if (status == -1) {
                this.f40124e = snapshot.mo35698l();
                this.f40127h = snapshot.mo35697f();
                this.f40125f.mo42059b(this.f40127h);
                C13128k.m42819b().mo42104a(this.f40122c.mo42081c(), snapshot);
            } else if (status == 1) {
                this.f40127h = snapshot.mo35697f();
                this.f40128i = snapshot.mo35691g();
                this.f40120a.mo42118a(snapshot);
            } else if (status == 2) {
                this.f40128i = snapshot.mo35691g();
                this.f40131l = snapshot.mo35696n();
                this.f40132m = snapshot.mo35694c();
                String filename = snapshot.mo35695d();
                if (filename != null) {
                    if (task.mo42035s() != null) {
                        C13117d.m42783e(this, "already has mFilename[%s], but assign mFilename[%s] again", task.mo42035s(), filename);
                    }
                    this.f40122c.mo42080a(filename);
                }
                this.f40125f.start();
                this.f40120a.mo42125d(snapshot);
            } else if (status == 3) {
                this.f40127h = snapshot.mo35697f();
                this.f40125f.mo42058a(snapshot.mo35697f());
                this.f40120a.mo42128g(snapshot);
            } else if (status == 5) {
                this.f40127h = snapshot.mo35697f();
                this.f40124e = snapshot.mo35698l();
                this.f40129j = snapshot.mo35699h();
                this.f40125f.reset();
                this.f40120a.mo42122c(snapshot);
            } else if (status == 6) {
                this.f40120a.mo42126e(snapshot);
            }
        }
    }

    public void onBegin() {
        if (C13136p.m42862b()) {
            C13136p.m42861a().mo42136c(this.f40122c.mo42081c().mo42043F());
        }
        if (C13117d.f40139a) {
            C13117d.m42782d(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(getStatus()));
        }
    }

    /* renamed from: j */
    public void mo42056j() {
        if (C13136p.m42862b() && getStatus() == 6) {
            C13136p.m42861a().mo42137d(this.f40122c.mo42081c().mo42043F());
        }
    }

    /* renamed from: e */
    public void mo42055e() {
        C13079a origin = this.f40122c.mo42081c().mo42043F();
        if (C13136p.m42862b()) {
            C13136p.m42861a().mo42135b(origin);
        }
        if (C13117d.f40139a) {
            C13117d.m42782d(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(getStatus()));
        }
        if (this.f40122c.mo42084x() != null) {
            ArrayList<FinishListener> listenersCopy = (ArrayList) this.f40122c.mo42084x().clone();
            int numListeners = listenersCopy.size();
            for (int i = 0; i < numListeners; i++) {
                ((C13080a) listenersCopy.get(i)).mo42000a(origin);
            }
        }
        C13149w.m42916b().mo42164c().mo41973c(this.f40122c.mo42081c());
    }

    C13108e(C13109a task, Object pauseLock) {
        this.f40121b = pauseLock;
        this.f40122c = task;
        C13088b monitor = new C13088b();
        this.f40125f = monitor;
        this.f40126g = monitor;
        this.f40120a = new C13135o(task.mo42081c(), this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        r0 = r8.f40122c.mo42081c();
        r1 = r0.mo42043F();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (p019d.p307j.p308a.C13136p.m42862b() == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        p019d.p307j.p308a.C13136p.m42861a().mo42134a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        if (p019d.p307j.p308a.p313e.C13117d.f40139a == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        p019d.p307j.p308a.p313e.C13117d.m42782d(r8, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", r1.getUrl(), r1.getPath(), r1.mo42006A(), r1.getTag());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0066, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        m42739l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
        r2 = false;
        p019d.p307j.p308a.C13128k.m42819b().mo42102a(r0);
        p019d.p307j.p308a.C13128k.m42819b().mo42104a(r0, mo41989a(r5));
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo41982c() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f40121b
            monitor-enter(r0)
            byte r1 = r8.f40123d     // Catch:{ all -> 0x009e }
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x009e }
            int r5 = r8.m42738k()     // Catch:{ all -> 0x009e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x009e }
            r2[r4] = r5     // Catch:{ all -> 0x009e }
            byte r4 = r8.f40123d     // Catch:{ all -> 0x009e }
            java.lang.Byte r4 = java.lang.Byte.valueOf(r4)     // Catch:{ all -> 0x009e }
            r2[r3] = r4     // Catch:{ all -> 0x009e }
            p019d.p307j.p308a.p313e.C13117d.m42783e(r8, r1, r2)     // Catch:{ all -> 0x009e }
            monitor-exit(r0)     // Catch:{ all -> 0x009e }
            return
        L_0x0025:
            r1 = 10
            r8.f40123d = r1     // Catch:{ all -> 0x009e }
            monitor-exit(r0)     // Catch:{ all -> 0x009e }
            d.j.a.e$a r0 = r8.f40122c
            d.j.a.a$b r0 = r0.mo42081c()
            d.j.a.a r1 = r0.mo42043F()
            boolean r5 = p019d.p307j.p308a.C13136p.m42862b()
            if (r5 == 0) goto L_0x0041
            d.j.a.p$a r5 = p019d.p307j.p308a.C13136p.m42861a()
            r5.mo42134a(r1)
        L_0x0041:
            boolean r5 = p019d.p307j.p308a.p313e.C13117d.f40139a
            if (r5 == 0) goto L_0x0066
            r5 = 4
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = r1.getUrl()
            r5[r4] = r6
            java.lang.String r6 = r1.getPath()
            r5[r3] = r6
            d.j.a.l r6 = r1.mo42006A()
            r5[r2] = r6
            r2 = 3
            java.lang.Object r6 = r1.getTag()
            r5[r2] = r6
            java.lang.String r2 = "call start Url[%s], Path[%s] Listener[%s], Tag[%s]"
            p019d.p307j.p308a.p313e.C13117d.m42782d(r8, r2, r5)
        L_0x0066:
            r2 = 1
            r8.m42739l()     // Catch:{ Throwable -> 0x006b }
            goto L_0x007f
        L_0x006b:
            r5 = move-exception
            r2 = 0
            d.j.a.k r6 = p019d.p307j.p308a.C13128k.m42819b()
            r6.mo42102a(r0)
            d.j.a.k r6 = p019d.p307j.p308a.C13128k.m42819b()
            com.liulishuo.filedownloader.message.MessageSnapshot r7 = r8.mo41989a(r5)
            r6.mo42104a(r0, r7)
        L_0x007f:
            if (r2 == 0) goto L_0x0088
            d.j.a.u r5 = p019d.p307j.p308a.C13144u.m42902b()
            r5.mo42145b(r8)
        L_0x0088:
            boolean r5 = p019d.p307j.p308a.p313e.C13117d.f40139a
            if (r5 == 0) goto L_0x009d
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r5 = r8.m42738k()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3[r4] = r5
            java.lang.String r4 = "the task[%d] has been into the launch pool."
            p019d.p307j.p308a.p313e.C13117d.m42782d(r8, r4, r3)
        L_0x009d:
            return
        L_0x009e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p307j.p308a.C13108e.mo41982c():void");
    }

    public boolean pause() {
        if (C10913c.m35800b(getStatus())) {
            if (C13117d.f40139a) {
                C13117d.m42778a(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(getStatus()), Integer.valueOf(this.f40122c.mo42081c().mo42043F().getId()));
            }
            return false;
        }
        this.f40123d = -2;
        C13081b runningTask = this.f40122c.mo42081c();
        C13079a origin = runningTask.mo42043F();
        C13144u.m42902b().mo42143a((C13071b) this);
        if (C13117d.f40139a) {
            C13117d.m42782d(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(m42738k()));
        }
        if (C13149w.m42916b().mo42166e()) {
            C13139r.m42869c().mo41968b(origin.getId());
        } else if (C13117d.f40139a) {
            C13117d.m42778a(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(origin.getId()));
        }
        this.f40125f.mo42059b(this.f40127h);
        C13128k.m42819b().mo42102a(runningTask);
        C13128k.m42819b().mo42104a(runningTask, C10907e.m35766b(origin));
        C13149w.m42916b().mo42164c().mo41973c(runningTask);
        return true;
    }

    public byte getStatus() {
        return this.f40123d;
    }

    /* renamed from: h */
    public int mo42060h() {
        return this.f40126g.mo42060h();
    }

    /* renamed from: b */
    public long mo41981b() {
        return this.f40127h;
    }

    /* renamed from: d */
    public long mo41983d() {
        return this.f40128i;
    }

    /* renamed from: f */
    public Throwable mo41984f() {
        return this.f40124e;
    }

    /* renamed from: a */
    public int mo41980a() {
        return this.f40129j;
    }

    /* renamed from: g */
    public boolean mo41986g() {
        return this.f40130k;
    }

    public void free() {
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "free the task %d, when the status is %d", Integer.valueOf(m42738k()), Byte.valueOf(this.f40123d));
        }
        this.f40123d = 0;
    }

    /* renamed from: l */
    private void m42739l() {
        File dir;
        C13079a origin = this.f40122c.mo42081c().mo42043F();
        if (origin.getPath() == null) {
            origin.setPath(C13121g.m42803d(origin.getUrl()));
            if (C13117d.f40139a) {
                C13117d.m42778a(this, "save Path is null to %s", origin.getPath());
            }
        }
        if (origin.mo42034q()) {
            dir = new File(origin.getPath());
        } else {
            String dirString = C13121g.m42807f(origin.getPath());
            if (dirString != null) {
                dir = new File(dirString);
            } else {
                throw new InvalidParameterException(C13121g.m42792a("the provided mPath[%s] is invalid, can't find its directory", origin.getPath()));
            }
        }
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    /* renamed from: k */
    private int m42738k() {
        return this.f40122c.mo42081c().mo42043F().getId();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        p019d.p307j.p308a.C13128k.m42819b().mo42102a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007d, code lost:
        if (p019d.p307j.p308a.p313e.C13113c.m42771a(r7.getId(), r7.mo42037u(), r7.mo42007D(), true) == false) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
        r0 = p019d.p307j.p308a.C13139r.m42869c().mo41967a(r7.getUrl(), r7.getPath(), r7.mo42034q(), r7.mo42032o(), r7.mo42028k(), r7.mo42030m(), r7.mo42007D(), r1.f40122c.mo42082p(), r7.mo42029l());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b1, code lost:
        if (r1.f40123d != -2) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b3, code lost:
        p019d.p307j.p308a.p313e.C13117d.m42783e(r1, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", java.lang.Integer.valueOf(m42738k()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c4, code lost:
        if (r0 == false) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c6, code lost:
        p019d.p307j.p308a.C13139r.m42869c().mo41968b(m42738k());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d1, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d2, code lost:
        if (r0 != false) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d8, code lost:
        if (r8.mo41971a(r6) != false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00da, code lost:
        r2 = mo41989a((java.lang.Throwable) new java.lang.RuntimeException("Occur Unknow Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ed, code lost:
        if (p019d.p307j.p308a.C13128k.m42819b().mo42110c(r6) == false) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ef, code lost:
        r8.mo41973c(r6);
        p019d.p307j.p308a.C13128k.m42819b().mo42102a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f9, code lost:
        p019d.p307j.p308a.C13128k.m42819b().mo42104a(r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0102, code lost:
        r8.mo41973c(r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
            r19 = this;
            r1 = r19
            byte r0 = r1.f40123d
            r2 = 2
            r3 = 10
            r4 = 0
            r5 = 1
            if (r0 == r3) goto L_0x0025
            java.lang.Object[] r0 = new java.lang.Object[r2]
            int r2 = r19.m42738k()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r4] = r2
            byte r2 = r1.f40123d
            java.lang.Byte r2 = java.lang.Byte.valueOf(r2)
            r0[r5] = r2
            java.lang.String r2 = "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d"
            p019d.p307j.p308a.p313e.C13117d.m42783e(r1, r2, r0)
            return
        L_0x0025:
            d.j.a.e$a r0 = r1.f40122c
            d.j.a.a$b r6 = r0.mo42081c()
            d.j.a.a r7 = r6.mo42043F()
            d.j.a.w r0 = p019d.p307j.p308a.C13149w.m42916b()
            d.j.a.B r8 = r0.mo42164c()
            boolean r0 = r8.mo41971a(r6)     // Catch:{ Throwable -> 0x0109 }
            if (r0 == 0) goto L_0x003e
            return
        L_0x003e:
            java.lang.Object r9 = r1.f40121b     // Catch:{ Throwable -> 0x0109 }
            monitor-enter(r9)     // Catch:{ Throwable -> 0x0109 }
            byte r0 = r1.f40123d     // Catch:{ all -> 0x0106 }
            if (r0 == r3) goto L_0x0060
            java.lang.String r0 = "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0106 }
            int r3 = r19.m42738k()     // Catch:{ all -> 0x0106 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0106 }
            r2[r4] = r3     // Catch:{ all -> 0x0106 }
            byte r3 = r1.f40123d     // Catch:{ all -> 0x0106 }
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)     // Catch:{ all -> 0x0106 }
            r2[r5] = r3     // Catch:{ all -> 0x0106 }
            p019d.p307j.p308a.p313e.C13117d.m42783e(r1, r0, r2)     // Catch:{ all -> 0x0106 }
            monitor-exit(r9)     // Catch:{ all -> 0x0106 }
            return
        L_0x0060:
            r0 = 11
            r1.f40123d = r0     // Catch:{ all -> 0x0106 }
            monitor-exit(r9)     // Catch:{ all -> 0x0106 }
            d.j.a.k r0 = p019d.p307j.p308a.C13128k.m42819b()     // Catch:{ Throwable -> 0x0109 }
            r0.mo42102a(r6)     // Catch:{ Throwable -> 0x0109 }
            int r0 = r7.getId()     // Catch:{ Throwable -> 0x0109 }
            java.lang.String r2 = r7.mo42037u()     // Catch:{ Throwable -> 0x0109 }
            boolean r3 = r7.mo42007D()     // Catch:{ Throwable -> 0x0109 }
            boolean r0 = p019d.p307j.p308a.p313e.C13113c.m42771a(r0, r2, r3, r5)     // Catch:{ Throwable -> 0x0109 }
            if (r0 == 0) goto L_0x0080
            return
        L_0x0080:
            d.j.a.r r9 = p019d.p307j.p308a.C13139r.m42869c()     // Catch:{ Throwable -> 0x0109 }
            java.lang.String r10 = r7.getUrl()     // Catch:{ Throwable -> 0x0109 }
            java.lang.String r11 = r7.getPath()     // Catch:{ Throwable -> 0x0109 }
            boolean r12 = r7.mo42034q()     // Catch:{ Throwable -> 0x0109 }
            int r13 = r7.mo42032o()     // Catch:{ Throwable -> 0x0109 }
            int r14 = r7.mo42028k()     // Catch:{ Throwable -> 0x0109 }
            int r15 = r7.mo42030m()     // Catch:{ Throwable -> 0x0109 }
            boolean r16 = r7.mo42007D()     // Catch:{ Throwable -> 0x0109 }
            d.j.a.e$a r0 = r1.f40122c     // Catch:{ Throwable -> 0x0109 }
            com.liulishuo.filedownloader.model.FileDownloadHeader r17 = r0.mo42082p()     // Catch:{ Throwable -> 0x0109 }
            boolean r18 = r7.mo42029l()     // Catch:{ Throwable -> 0x0109 }
            boolean r0 = r9.mo41967a(r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ Throwable -> 0x0109 }
            byte r2 = r1.f40123d     // Catch:{ Throwable -> 0x0109 }
            r3 = -2
            if (r2 != r3) goto L_0x00d2
            java.lang.String r2 = "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied"
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ Throwable -> 0x0109 }
            int r5 = r19.m42738k()     // Catch:{ Throwable -> 0x0109 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Throwable -> 0x0109 }
            r3[r4] = r5     // Catch:{ Throwable -> 0x0109 }
            p019d.p307j.p308a.p313e.C13117d.m42783e(r1, r2, r3)     // Catch:{ Throwable -> 0x0109 }
            if (r0 == 0) goto L_0x00d1
            d.j.a.r r2 = p019d.p307j.p308a.C13139r.m42869c()     // Catch:{ Throwable -> 0x0109 }
            int r3 = r19.m42738k()     // Catch:{ Throwable -> 0x0109 }
            r2.mo41968b(r3)     // Catch:{ Throwable -> 0x0109 }
        L_0x00d1:
            return
        L_0x00d2:
            if (r0 != 0) goto L_0x0102
            boolean r2 = r8.mo41971a(r6)     // Catch:{ Throwable -> 0x0109 }
            if (r2 != 0) goto L_0x0105
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ Throwable -> 0x0109 }
            java.lang.String r3 = "Occur Unknow Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."
            r2.<init>(r3)     // Catch:{ Throwable -> 0x0109 }
            com.liulishuo.filedownloader.message.MessageSnapshot r2 = r1.mo41989a(r2)     // Catch:{ Throwable -> 0x0109 }
            d.j.a.k r3 = p019d.p307j.p308a.C13128k.m42819b()     // Catch:{ Throwable -> 0x0109 }
            boolean r3 = r3.mo42110c(r6)     // Catch:{ Throwable -> 0x0109 }
            if (r3 == 0) goto L_0x00f9
            r8.mo41973c(r6)     // Catch:{ Throwable -> 0x0109 }
            d.j.a.k r3 = p019d.p307j.p308a.C13128k.m42819b()     // Catch:{ Throwable -> 0x0109 }
            r3.mo42102a(r6)     // Catch:{ Throwable -> 0x0109 }
        L_0x00f9:
            d.j.a.k r3 = p019d.p307j.p308a.C13128k.m42819b()     // Catch:{ Throwable -> 0x0109 }
            r3.mo42104a(r6, r2)     // Catch:{ Throwable -> 0x0109 }
            goto L_0x0105
        L_0x0102:
            r8.mo41973c(r6)     // Catch:{ Throwable -> 0x0109 }
        L_0x0105:
            goto L_0x0118
        L_0x0106:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0106 }
            throw r0     // Catch:{ Throwable -> 0x0109 }
        L_0x0109:
            r0 = move-exception
            r0.printStackTrace()
            d.j.a.k r2 = p019d.p307j.p308a.C13128k.m42819b()
            com.liulishuo.filedownloader.message.MessageSnapshot r3 = r1.mo41989a(r0)
            r2.mo42104a(r6, r3)
        L_0x0118:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p307j.p308a.C13108e.start():void");
    }

    /* renamed from: a */
    public boolean mo41995a(C13130l listener) {
        return this.f40122c.mo42081c().mo42043F().mo42006A() == listener;
    }
}
