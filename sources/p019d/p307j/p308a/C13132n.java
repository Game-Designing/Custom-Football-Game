package p019d.p307j.p308a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import p019d.p307j.p308a.p313e.C13111b;

/* renamed from: d.j.a.n */
/* compiled from: FileDownloadMessageStation */
public class C13132n {

    /* renamed from: a */
    static int f40159a = 10;

    /* renamed from: b */
    static int f40160b = 5;

    /* renamed from: c */
    private final Executor f40161c;

    /* renamed from: d */
    private final Handler f40162d;

    /* renamed from: e */
    private final LinkedBlockingQueue<C13153z> f40163e;

    /* renamed from: f */
    private final Object f40164f;

    /* renamed from: g */
    private final ArrayList<C13153z> f40165g;

    /* renamed from: d.j.a.n$a */
    /* compiled from: FileDownloadMessageStation */
    private static final class C13133a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C13132n f40166a = new C13132n(null);
    }

    /* renamed from: d.j.a.n$b */
    /* compiled from: FileDownloadMessageStation */
    private static class C13134b implements Callback {
        private C13134b() {
        }

        /* synthetic */ C13134b(C13131m x0) {
            this();
        }

        public boolean handleMessage(Message msg) {
            int i = msg.what;
            if (i == 1) {
                ((C13153z) msg.obj).mo42124d();
            } else if (i == 2) {
                m42843a((ArrayList) msg.obj);
                C13132n.m42834a().m42838c();
            }
            return true;
        }

        /* renamed from: a */
        private void m42843a(ArrayList<C13153z> disposingList) {
            Iterator it = disposingList.iterator();
            while (it.hasNext()) {
                ((C13153z) it.next()).mo42124d();
            }
            disposingList.clear();
        }
    }

    /* synthetic */ C13132n(C13131m x0) {
        this();
    }

    /* renamed from: a */
    public static C13132n m42834a() {
        return C13133a.f40166a;
    }

    private C13132n() {
        this.f40161c = C13111b.m42766a(5, "BlockCompleted");
        this.f40164f = new Object();
        this.f40165g = new ArrayList<>();
        this.f40162d = new Handler(Looper.getMainLooper(), new C13134b(null));
        this.f40163e = new LinkedBlockingQueue<>();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo42115a(C13153z messenger) {
        mo42116a(messenger, false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo42116a(C13153z messenger, boolean immediately) {
        if (messenger.mo42119a()) {
            messenger.mo42124d();
        } else if (messenger.mo42123c()) {
            this.f40161c.execute(new C13131m(this, messenger));
        } else {
            if (!m42837b() && !this.f40163e.isEmpty()) {
                synchronized (this.f40164f) {
                    if (!this.f40163e.isEmpty()) {
                        Iterator it = this.f40163e.iterator();
                        while (it.hasNext()) {
                            m42839c((C13153z) it.next());
                        }
                    }
                    this.f40163e.clear();
                }
            }
            if (!m42837b() || immediately) {
                m42839c(messenger);
            } else {
                m42836b(messenger);
            }
        }
    }

    /* renamed from: c */
    private void m42839c(C13153z messenger) {
        Handler handler = this.f40162d;
        handler.sendMessage(handler.obtainMessage(1, messenger));
    }

    /* renamed from: b */
    private void m42836b(C13153z messenger) {
        synchronized (this.f40164f) {
            this.f40163e.offer(messenger);
        }
        m42838c();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0047, code lost:
        r0 = r6.f40162d;
        r0.sendMessageDelayed(r0.obtainMessage(2, r6.f40165g), (long) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m42838c() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f40164f
            monitor-enter(r0)
            r1 = 0
            java.util.ArrayList<d.j.a.z> r2 = r6.f40165g     // Catch:{ all -> 0x0055 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0055 }
            if (r2 != 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            return
        L_0x000e:
            java.util.concurrent.LinkedBlockingQueue<d.j.a.z> r2 = r6.f40163e     // Catch:{ all -> 0x0055 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x0018
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            return
        L_0x0018:
            boolean r2 = m42837b()     // Catch:{ all -> 0x0055 }
            if (r2 != 0) goto L_0x0027
            java.util.concurrent.LinkedBlockingQueue<d.j.a.z> r2 = r6.f40163e     // Catch:{ all -> 0x0055 }
            java.util.ArrayList<d.j.a.z> r3 = r6.f40165g     // Catch:{ all -> 0x0055 }
            r2.drainTo(r3)     // Catch:{ all -> 0x0055 }
            r1 = 0
            goto L_0x0046
        L_0x0027:
            int r1 = f40159a     // Catch:{ all -> 0x0055 }
            java.util.concurrent.LinkedBlockingQueue<d.j.a.z> r2 = r6.f40163e     // Catch:{ all -> 0x0058 }
            int r2 = r2.size()     // Catch:{ all -> 0x0058 }
            int r3 = f40160b     // Catch:{ all -> 0x0058 }
            int r2 = java.lang.Math.min(r2, r3)     // Catch:{ all -> 0x0058 }
            r3 = 0
        L_0x0036:
            if (r3 >= r2) goto L_0x0046
            java.util.ArrayList<d.j.a.z> r4 = r6.f40165g     // Catch:{ all -> 0x0058 }
            java.util.concurrent.LinkedBlockingQueue<d.j.a.z> r5 = r6.f40163e     // Catch:{ all -> 0x0058 }
            java.lang.Object r5 = r5.remove()     // Catch:{ all -> 0x0058 }
            r4.add(r5)     // Catch:{ all -> 0x0058 }
            int r3 = r3 + 1
            goto L_0x0036
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            android.os.Handler r0 = r6.f40162d
            r2 = 2
            java.util.ArrayList<d.j.a.z> r3 = r6.f40165g
            android.os.Message r2 = r0.obtainMessage(r2, r3)
            long r3 = (long) r1
            r0.sendMessageDelayed(r2, r3)
            return
        L_0x0055:
            r2 = move-exception
        L_0x0056:
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            throw r2
        L_0x0058:
            r2 = move-exception
            goto L_0x0056
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p307j.p308a.C13132n.m42838c():void");
    }

    /* renamed from: b */
    public static boolean m42837b() {
        return f40159a > 0;
    }
}
