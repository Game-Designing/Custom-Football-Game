package p019d.p307j.p308a;

import com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p019d.p307j.p308a.C13079a.C13081b;
import p019d.p307j.p308a.p313e.C13117d;

/* renamed from: d.j.a.k */
/* compiled from: FileDownloadList */
public class C13128k {

    /* renamed from: a */
    private final ArrayList<C13081b> f40155a;

    /* renamed from: d.j.a.k$a */
    /* compiled from: FileDownloadList */
    private static final class C13129a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C13128k f40156a = new C13128k();
    }

    /* renamed from: b */
    public static C13128k m42819b() {
        return C13129a.f40156a;
    }

    private C13128k() {
        this.f40155a = new ArrayList<>();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo42108c() {
        return this.f40155a.size();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo42099a(int id) {
        int size = 0;
        synchronized (this.f40155a) {
            Iterator it = this.f40155a.iterator();
            while (it.hasNext()) {
                if (((C13081b) it.next()).mo42044a(id)) {
                    size++;
                }
            }
        }
        return size;
    }

    /* renamed from: b */
    public C13081b mo42106b(int id) {
        synchronized (this.f40155a) {
            Iterator it = this.f40155a.iterator();
            while (it.hasNext()) {
                C13081b task = (C13081b) it.next();
                if (task.mo42044a(id)) {
                    return task;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public List<C13081b> mo42111d(int id) {
        List<IRunningTask> list = new ArrayList<>();
        synchronized (this.f40155a) {
            Iterator it = this.f40155a.iterator();
            while (it.hasNext()) {
                C13081b task = (C13081b) it.next();
                if (task.mo42044a(id) && !task.mo42042E()) {
                    byte status = task.mo42043F().getStatus();
                    if (!(status == 0 || status == 10)) {
                        list.add(task);
                    }
                }
            }
        }
        return list;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public List<C13081b> mo42109c(int id) {
        List<IRunningTask> list = new ArrayList<>();
        synchronized (this.f40155a) {
            Iterator it = this.f40155a.iterator();
            while (it.hasNext()) {
                C13081b task = (C13081b) it.next();
                if (task.mo42044a(id) && !task.mo42042E()) {
                    list.add(task);
                }
            }
        }
        return list;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo42110c(C13081b download) {
        return this.f40155a.isEmpty() || !this.f40155a.contains(download);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<C13081b> mo42101a(C13130l listener) {
        List<IRunningTask> targetList = new ArrayList<>();
        synchronized (this.f40155a) {
            Iterator it = this.f40155a.iterator();
            while (it.hasNext()) {
                C13081b task = (C13081b) it.next();
                if (task.mo42047b(listener)) {
                    targetList.add(task);
                }
            }
        }
        return targetList;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<C13081b> mo42100a(int attachKey, C13130l listener) {
        List<IRunningTask> targetList = new ArrayList<>();
        synchronized (this.f40155a) {
            Iterator it = this.f40155a.iterator();
            while (it.hasNext()) {
                C13081b task = (C13081b) it.next();
                if (task.mo42043F().mo42006A() == listener && !task.mo42043F().mo42017e()) {
                    task.mo42046b(attachKey);
                    targetList.add(task);
                }
            }
        }
        return targetList;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C13081b[] mo42105a() {
        C13081b[] bVarArr;
        synchronized (this.f40155a) {
            bVarArr = (C13081b[]) this.f40155a.toArray(new C13081b[this.f40155a.size()]);
        }
        return bVarArr;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo42103a(List<C13081b> destination) {
        synchronized (this.f40155a) {
            Iterator it = this.f40155a.iterator();
            while (it.hasNext()) {
                C13081b iRunningTask = (C13081b) it.next();
                if (!destination.contains(iRunningTask)) {
                    destination.add(iRunningTask);
                }
            }
            this.f40155a.clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        if (r8.f40155a.size() != 0) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        p019d.p307j.p308a.p313e.C13117d.m42782d(r8, "remove %s left %d %d", r9, java.lang.Byte.valueOf(r0), java.lang.Integer.valueOf(r8.f40155a.size()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        if (r3 == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        r1 = r9.mo42052v().mo41994i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        if (r0 == -4) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        if (r0 == -3) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004a, code lost:
        if (r0 == -2) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        if (r0 == -1) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
        r1.mo42120b(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        r1.mo42127f(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        r1.mo42130i(com.liulishuo.filedownloader.message.C10907e.m35764a(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        r1.mo42129h(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
        p019d.p307j.p308a.p313e.C13117d.m42780b(r8, "remove error, not exist: %s %d", r9, java.lang.Byte.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (p019d.p307j.p308a.p313e.C13117d.f40139a == false) goto L_0x0039;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo42104a(p019d.p307j.p308a.C13079a.C13081b r9, com.liulishuo.filedownloader.message.MessageSnapshot r10) {
        /*
            r8 = this;
            byte r0 = r10.mo35687k()
            java.util.ArrayList<d.j.a.a$b> r1 = r8.f40155a
            monitor-enter(r1)
            r2 = 0
            java.util.ArrayList<d.j.a.a$b> r3 = r8.f40155a     // Catch:{ all -> 0x007a }
            boolean r3 = r3.remove(r9)     // Catch:{ all -> 0x007a }
            monitor-exit(r1)     // Catch:{ all -> 0x0075 }
            boolean r1 = p019d.p307j.p308a.p313e.C13117d.f40139a
            r4 = 1
            r5 = 2
            if (r1 == 0) goto L_0x0039
            java.util.ArrayList<d.j.a.a$b> r1 = r8.f40155a
            int r1 = r1.size()
            if (r1 != 0) goto L_0x0039
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r9
            java.lang.Byte r6 = java.lang.Byte.valueOf(r0)
            r1[r4] = r6
            java.util.ArrayList<d.j.a.a$b> r6 = r8.f40155a
            int r6 = r6.size()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r1[r5] = r6
            java.lang.String r6 = "remove %s left %d %d"
            p019d.p307j.p308a.p313e.C13117d.m42782d(r8, r6, r1)
        L_0x0039:
            if (r3 == 0) goto L_0x0065
            d.j.a.D$a r1 = r9.mo42052v()
            d.j.a.z r1 = r1.mo41994i()
            r2 = -4
            if (r0 == r2) goto L_0x0060
            r2 = -3
            if (r0 == r2) goto L_0x0058
            r2 = -2
            if (r0 == r2) goto L_0x0054
            r2 = -1
            if (r0 == r2) goto L_0x0050
            goto L_0x0064
        L_0x0050:
            r1.mo42120b(r10)
            goto L_0x0064
        L_0x0054:
            r1.mo42127f(r10)
            goto L_0x0064
        L_0x0058:
            com.liulishuo.filedownloader.message.MessageSnapshot r2 = com.liulishuo.filedownloader.message.C10907e.m35764a(r10)
            r1.mo42130i(r2)
            goto L_0x0064
        L_0x0060:
            r1.mo42129h(r10)
        L_0x0064:
            goto L_0x0074
        L_0x0065:
            java.lang.Object[] r1 = new java.lang.Object[r5]
            r1[r2] = r9
            java.lang.Byte r2 = java.lang.Byte.valueOf(r0)
            r1[r4] = r2
            java.lang.String r2 = "remove error, not exist: %s %d"
            p019d.p307j.p308a.p313e.C13117d.m42780b(r8, r2, r1)
        L_0x0074:
            return r3
        L_0x0075:
            r2 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
            goto L_0x007b
        L_0x007a:
            r3 = move-exception
        L_0x007b:
            monitor-exit(r1)     // Catch:{ all -> 0x007d }
            throw r3
        L_0x007d:
            r3 = move-exception
            goto L_0x007b
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p307j.p308a.C13128k.mo42104a(d.j.a.a$b, com.liulishuo.filedownloader.message.MessageSnapshot):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo42102a(C13081b task) {
        if (!task.mo42043F().mo42017e()) {
            task.mo42053z();
        }
        if (task.mo42052v().mo41994i().mo42121b()) {
            mo42107b(task);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo42107b(C13081b task) {
        if (!task.mo42040B()) {
            synchronized (this.f40155a) {
                if (this.f40155a.contains(task)) {
                    C13117d.m42783e(this, "already has %s", task);
                } else {
                    task.mo42050r();
                    this.f40155a.add(task);
                    if (C13117d.f40139a) {
                        C13117d.m42782d(this, "add list in all %s %d %d", task, Byte.valueOf(task.mo42043F().getStatus()), Integer.valueOf(this.f40155a.size()));
                    }
                }
            }
        }
    }
}
