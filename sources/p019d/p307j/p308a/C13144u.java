package p019d.p307j.p308a;

import com.liulishuo.filedownloader.message.C10904d;
import com.liulishuo.filedownloader.message.C10904d.C10906b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import p019d.p307j.p308a.C13069D.C13071b;
import p019d.p307j.p308a.p313e.C13111b;
import p019d.p307j.p308a.p313e.C13117d;

/* renamed from: d.j.a.u */
/* compiled from: FileDownloadTaskLauncher */
class C13144u {

    /* renamed from: a */
    private final C13146b f40178a = new C13146b();

    /* renamed from: d.j.a.u$a */
    /* compiled from: FileDownloadTaskLauncher */
    private static class C13145a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C13144u f40179a = new C13144u();

        static {
            C10904d.m35756a().mo35706a((C10906b) new C13074G());
        }
    }

    /* renamed from: d.j.a.u$b */
    /* compiled from: FileDownloadTaskLauncher */
    private static class C13146b {

        /* renamed from: a */
        private ThreadPoolExecutor f40180a;

        /* renamed from: b */
        private LinkedBlockingQueue<Runnable> f40181b;

        public C13146b() {
            m42908b();
        }

        /* renamed from: a */
        public void mo42147a(C13071b taskStarter) {
            this.f40180a.execute(new C13147c(taskStarter));
        }

        /* renamed from: b */
        public void mo42149b(C13071b starter) {
            this.f40181b.remove(starter);
        }

        /* renamed from: a */
        public void mo42148a(C13130l listener) {
            if (listener == null) {
                C13117d.m42783e(this, "want to expire by listener, but the listener provided is null", new Object[0]);
                return;
            }
            List<Runnable> needPauseList = new ArrayList<>();
            Iterator it = this.f40181b.iterator();
            while (it.hasNext()) {
                Runnable runnable = (Runnable) it.next();
                C13147c launchTaskRunnable = (C13147c) runnable;
                if (launchTaskRunnable.mo42151a(listener)) {
                    launchTaskRunnable.mo42150a();
                    needPauseList.add(runnable);
                }
            }
            if (!needPauseList.isEmpty()) {
                if (C13117d.f40139a) {
                    C13117d.m42778a(this, "expire %d tasks with listener[%s]", Integer.valueOf(needPauseList.size()), listener);
                }
                for (Runnable runnable2 : needPauseList) {
                    this.f40180a.remove(runnable2);
                }
            }
        }

        /* renamed from: a */
        public void mo42146a() {
            if (C13117d.f40139a) {
                C13117d.m42778a(this, "expire %d tasks", Integer.valueOf(this.f40181b.size()));
            }
            this.f40180a.shutdownNow();
            m42908b();
        }

        /* renamed from: b */
        private void m42908b() {
            this.f40181b = new LinkedBlockingQueue<>();
            this.f40180a = C13111b.m42767a(3, this.f40181b, "LauncherTask");
        }
    }

    /* renamed from: d.j.a.u$c */
    /* compiled from: FileDownloadTaskLauncher */
    private static class C13147c implements Runnable {

        /* renamed from: a */
        private final C13071b f40182a;

        /* renamed from: b */
        private boolean f40183b = false;

        C13147c(C13071b taskStarter) {
            this.f40182a = taskStarter;
        }

        public void run() {
            if (!this.f40183b) {
                this.f40182a.start();
            }
        }

        /* renamed from: a */
        public boolean mo42151a(C13130l listener) {
            C13071b bVar = this.f40182a;
            return bVar != null && bVar.mo41995a(listener);
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || obj == this.f40182a;
        }

        /* renamed from: a */
        public void mo42150a() {
            this.f40183b = true;
        }
    }

    C13144u() {
    }

    /* renamed from: b */
    public static C13144u m42902b() {
        return C13145a.f40179a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized void mo42145b(C13071b taskStarter) {
        this.f40178a.mo42147a(taskStarter);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo42142a() {
        this.f40178a.mo42146a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo42143a(C13071b taskStarter) {
        this.f40178a.mo42149b(taskStarter);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo42144a(C13130l lis) {
        this.f40178a.mo42148a(lis);
    }
}
