package p320f.p321a.p322a.p324b;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import p320f.p321a.C13805u;
import p320f.p321a.C13805u.C13808c;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p325b.C13195c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.a.b.c */
/* compiled from: HandlerScheduler */
final class C13189c extends C13805u {

    /* renamed from: b */
    private final Handler f40289b;

    /* renamed from: f.a.a.b.c$a */
    /* compiled from: HandlerScheduler */
    private static final class C13190a extends C13808c {

        /* renamed from: a */
        private final Handler f40290a;

        /* renamed from: b */
        private volatile boolean f40291b;

        C13190a(Handler handler) {
            this.f40290a = handler;
        }

        /* renamed from: a */
        public C13194b mo42243a(Runnable run, long delay, TimeUnit unit) {
            if (run == null) {
                throw new NullPointerException("run == null");
            } else if (unit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.f40291b) {
                return C13195c.m43130a();
            } else {
                C13191b scheduled = new C13191b(this.f40290a, C13774a.m43831a(run));
                Message message = Message.obtain(this.f40290a, scheduled);
                message.obj = this;
                this.f40290a.sendMessageDelayed(message, unit.toMillis(delay));
                if (!this.f40291b) {
                    return scheduled;
                }
                this.f40290a.removeCallbacks(scheduled);
                return C13195c.m43130a();
            }
        }

        public void dispose() {
            this.f40291b = true;
            this.f40290a.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: f.a.a.b.c$b */
    /* compiled from: HandlerScheduler */
    private static final class C13191b implements Runnable, C13194b {

        /* renamed from: a */
        private final Handler f40292a;

        /* renamed from: b */
        private final Runnable f40293b;

        /* renamed from: c */
        private volatile boolean f40294c;

        C13191b(Handler handler, Runnable delegate) {
            this.f40292a = handler;
            this.f40293b = delegate;
        }

        public void run() {
            try {
                this.f40293b.run();
            } catch (Throwable t) {
                C13774a.m43836b(t);
            }
        }

        public void dispose() {
            this.f40294c = true;
            this.f40292a.removeCallbacks(this);
        }
    }

    C13189c(Handler handler) {
        this.f40289b = handler;
    }

    /* renamed from: a */
    public C13194b mo42241a(Runnable run, long delay, TimeUnit unit) {
        if (run == null) {
            throw new NullPointerException("run == null");
        } else if (unit != null) {
            C13191b scheduled = new C13191b(this.f40289b, C13774a.m43831a(run));
            this.f40289b.postDelayed(scheduled, unit.toMillis(delay));
            return scheduled;
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    /* renamed from: a */
    public C13808c mo42242a() {
        return new C13190a(this.f40289b);
    }
}
