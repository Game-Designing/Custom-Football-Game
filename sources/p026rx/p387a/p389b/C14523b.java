package p026rx.p387a.p389b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C0137ja;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0128a;
import p026rx.p029i.C14978f;
import p026rx.p387a.p388a.C14519a;
import p026rx.p387a.p388a.C14520b;
import p026rx.p400f.C14953x;

/* renamed from: rx.a.b.b */
/* compiled from: LooperScheduler */
class C14523b extends C0126V {

    /* renamed from: a */
    private final Handler f43340a;

    /* renamed from: rx.a.b.b$a */
    /* compiled from: LooperScheduler */
    static class C14524a extends C0127a {

        /* renamed from: a */
        private final Handler f43341a;

        /* renamed from: b */
        private final C14520b f43342b = C14519a.m46165a().mo45716b();

        /* renamed from: c */
        private volatile boolean f43343c;

        C14524a(Handler handler) {
            this.f43341a = handler;
        }

        public void unsubscribe() {
            this.f43343c = true;
            this.f43341a.removeCallbacksAndMessages(this);
        }

        public boolean isUnsubscribed() {
            return this.f43343c;
        }

        /* renamed from: a */
        public C0137ja mo3709a(C0128a action, long delayTime, TimeUnit unit) {
            if (this.f43343c) {
                return C14978f.m46782b();
            }
            C14525b scheduledAction = new C14525b(this.f43342b.mo45717a(action), this.f43341a);
            Message message = Message.obtain(this.f43341a, scheduledAction);
            message.obj = this;
            this.f43341a.sendMessageDelayed(message, unit.toMillis(delayTime));
            if (!this.f43343c) {
                return scheduledAction;
            }
            this.f43341a.removeCallbacks(scheduledAction);
            return C14978f.m46782b();
        }

        /* renamed from: a */
        public C0137ja mo3707a(C0128a action) {
            return mo3709a(action, 0, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: rx.a.b.b$b */
    /* compiled from: LooperScheduler */
    static final class C14525b implements Runnable, C0137ja {

        /* renamed from: a */
        private final C0128a f43344a;

        /* renamed from: b */
        private final Handler f43345b;

        /* renamed from: c */
        private volatile boolean f43346c;

        C14525b(C0128a action, Handler handler) {
            this.f43344a = action;
            this.f43345b = handler;
        }

        public void run() {
            IllegalStateException ie;
            try {
                this.f43344a.call();
            } catch (Throwable e) {
                if (e instanceof OnErrorNotImplementedException) {
                    ie = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e);
                } else {
                    ie = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", e);
                }
                C14953x.m46727c().mo46162b().mo46139a((Throwable) ie);
                Thread thread = Thread.currentThread();
                thread.getUncaughtExceptionHandler().uncaughtException(thread, ie);
            }
        }

        public void unsubscribe() {
            this.f43346c = true;
            this.f43345b.removeCallbacks(this);
        }

        public boolean isUnsubscribed() {
            return this.f43346c;
        }
    }

    C14523b(Looper looper) {
        this.f43340a = new Handler(looper);
    }

    public C0127a createWorker() {
        return new C14524a(this.f43340a);
    }
}
