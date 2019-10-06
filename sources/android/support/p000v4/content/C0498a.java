package android.support.p000v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.p000v4.p037os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import p002b.p003c.p053g.p061f.C1275s;

/* renamed from: android.support.v4.content.a */
/* compiled from: AsyncTaskLoader */
public abstract class C0498a<D> extends C0511c<D> {

    /* renamed from: j */
    private final Executor f1639j;

    /* renamed from: k */
    volatile C0499a f1640k;

    /* renamed from: l */
    volatile C0499a f1641l;

    /* renamed from: m */
    long f1642m;

    /* renamed from: n */
    long f1643n;

    /* renamed from: o */
    Handler f1644o;

    /* renamed from: android.support.v4.content.a$a */
    /* compiled from: AsyncTaskLoader */
    final class C0499a extends C0522j<Void, Void, D> implements Runnable {

        /* renamed from: k */
        private final CountDownLatch f1645k = new CountDownLatch(1);

        /* renamed from: l */
        boolean f1646l;

        C0499a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public D mo5271a(Void... params) {
            try {
                return C0498a.this.mo5270u();
            } catch (OperationCanceledException ex) {
                if (mo5321a()) {
                    return null;
                }
                throw ex;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo5274c(D data) {
            try {
                C0498a.this.mo5263b(this, data);
            } finally {
                this.f1645k.countDown();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo5273b(D data) {
            try {
                C0498a.this.mo5261a(this, data);
            } finally {
                this.f1645k.countDown();
            }
        }

        public void run() {
            this.f1646l = false;
            C0498a.this.mo5268s();
        }
    }

    /* renamed from: t */
    public abstract D mo5269t();

    public C0498a(Context context) {
        this(context, C0522j.f1691c);
    }

    private C0498a(Context context, Executor executor) {
        super(context);
        this.f1643n = -10000;
        this.f1639j = executor;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo5266j() {
        super.mo5266j();
        mo5295b();
        this.f1640k = new C0499a<>();
        mo5268s();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public boolean mo5265h() {
        if (this.f1640k == null) {
            return false;
        }
        if (!this.f1666e) {
            this.f1669h = true;
        }
        if (this.f1641l != null) {
            if (this.f1640k.f1646l) {
                this.f1640k.f1646l = false;
                this.f1644o.removeCallbacks(this.f1640k);
            }
            this.f1640k = null;
            return false;
        } else if (this.f1640k.f1646l) {
            this.f1640k.f1646l = false;
            this.f1644o.removeCallbacks(this.f1640k);
            this.f1640k = null;
            return false;
        } else {
            boolean cancelled = this.f1640k.mo5322a(false);
            if (cancelled) {
                this.f1641l = this.f1640k;
                mo5267r();
            }
            this.f1640k = null;
            return cancelled;
        }
    }

    /* renamed from: c */
    public void mo5264c(D d) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public void mo5268s() {
        if (this.f1641l == null && this.f1640k != null) {
            if (this.f1640k.f1646l) {
                this.f1640k.f1646l = false;
                this.f1644o.removeCallbacks(this.f1640k);
            }
            if (this.f1642m <= 0 || SystemClock.uptimeMillis() >= this.f1643n + this.f1642m) {
                this.f1640k.mo5319a(this.f1639j, null);
            } else {
                this.f1640k.f1646l = true;
                this.f1644o.postAtTime(this.f1640k, this.f1643n + this.f1642m);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5261a(C0499a task, D data) {
        mo5264c(data);
        if (this.f1641l == task) {
            mo5306o();
            this.f1643n = SystemClock.uptimeMillis();
            this.f1641l = null;
            mo5297d();
            mo5268s();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo5263b(C0499a task, D data) {
        if (this.f1640k != task) {
            mo5261a(task, data);
        } else if (mo5299f()) {
            mo5264c(data);
        } else {
            mo5296c();
            this.f1643n = SystemClock.uptimeMillis();
            this.f1640k = null;
            mo5294b(data);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public D mo5270u() {
        return mo5269t();
    }

    /* renamed from: r */
    public void mo5267r() {
    }

    /* renamed from: a */
    public void mo5262a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.mo5262a(prefix, fd, writer, args);
        String str = " waiting=";
        if (this.f1640k != null) {
            writer.print(prefix);
            writer.print("mTask=");
            writer.print(this.f1640k);
            writer.print(str);
            writer.println(this.f1640k.f1646l);
        }
        if (this.f1641l != null) {
            writer.print(prefix);
            writer.print("mCancellingTask=");
            writer.print(this.f1641l);
            writer.print(str);
            writer.println(this.f1641l.f1646l);
        }
        if (this.f1642m != 0) {
            writer.print(prefix);
            writer.print("mUpdateThrottle=");
            C1275s.m5989a(this.f1642m, writer);
            writer.print(" mLastLoadCompleteTime=");
            C1275s.m5988a(this.f1643n, SystemClock.uptimeMillis(), writer);
            writer.println();
        }
    }
}
