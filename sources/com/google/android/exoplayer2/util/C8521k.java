package com.google.android.exoplayer2.util;

import android.os.Handler;
import com.google.android.exoplayer2.util.EventDispatcher.HandlerAndListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.google.android.exoplayer2.util.k */
/* compiled from: EventDispatcher */
public final class C8521k<T> {

    /* renamed from: a */
    private final CopyOnWriteArrayList<C8523b<T>> f18817a = new CopyOnWriteArrayList<>();

    /* renamed from: com.google.android.exoplayer2.util.k$a */
    /* compiled from: EventDispatcher */
    public interface C8522a<T> {
        /* renamed from: a */
        void mo25934a(T t);
    }

    /* renamed from: com.google.android.exoplayer2.util.k$b */
    /* compiled from: EventDispatcher */
    private static final class C8523b<T> {

        /* renamed from: a */
        private final Handler f18818a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final T f18819b;

        /* renamed from: c */
        private boolean f18820c;

        public C8523b(Handler handler, T eventListener) {
            this.f18818a = handler;
            this.f18819b = eventListener;
        }

        /* renamed from: a */
        public void mo26083a() {
            this.f18820c = true;
        }

        /* renamed from: a */
        public void mo26084a(C8522a<T> event) {
            this.f18818a.post(new C8510a(this, event));
        }

        /* renamed from: b */
        public /* synthetic */ void mo26085b(C8522a event) {
            if (!this.f18820c) {
                event.mo25934a(this.f18819b);
            }
        }
    }

    /* renamed from: a */
    public void mo26080a(Handler handler, T eventListener) {
        C8514e.m20488a((handler == null || eventListener == null) ? false : true);
        mo26082a(eventListener);
        this.f18817a.add(new C8523b(handler, eventListener));
    }

    /* renamed from: a */
    public void mo26082a(T eventListener) {
        Iterator it = this.f18817a.iterator();
        while (it.hasNext()) {
            HandlerAndListener<T> handlerAndListener = (C8523b) it.next();
            if (handlerAndListener.f18819b == eventListener) {
                handlerAndListener.mo26083a();
                this.f18817a.remove(handlerAndListener);
            }
        }
    }

    /* renamed from: a */
    public void mo26081a(C8522a<T> event) {
        Iterator it = this.f18817a.iterator();
        while (it.hasNext()) {
            ((C8523b) it.next()).mo26084a(event);
        }
    }
}
