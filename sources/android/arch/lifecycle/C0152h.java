package android.arch.lifecycle;

import android.arch.lifecycle.C0148d.C0000a;
import android.arch.lifecycle.C0148d.C0149b;
import android.arch.lifecycle.LifecycleRegistry.ObserverWithState;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import p002b.p041a.p042a.p044b.C1146a;

/* renamed from: android.arch.lifecycle.h */
/* compiled from: LifecycleRegistry */
public class C0152h extends C0148d {

    /* renamed from: a */
    private C1146a<C0150e, C0153a> f213a = new C1146a<>();

    /* renamed from: b */
    private C0149b f214b;

    /* renamed from: c */
    private final WeakReference<C0001f> f215c;

    /* renamed from: d */
    private int f216d = 0;

    /* renamed from: e */
    private boolean f217e = false;

    /* renamed from: f */
    private boolean f218f = false;

    /* renamed from: g */
    private ArrayList<C0149b> f219g = new ArrayList<>();

    /* renamed from: android.arch.lifecycle.h$a */
    /* compiled from: LifecycleRegistry */
    static class C0153a {

        /* renamed from: a */
        C0149b f220a;

        /* renamed from: b */
        GenericLifecycleObserver f221b;

        C0153a(C0150e observer, C0149b initialState) {
            this.f221b = C0155j.m859a((Object) observer);
            this.f220a = initialState;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo3756a(C0001f owner, C0000a event) {
            C0149b newState = C0152h.m841a(event);
            this.f220a = C0152h.m842a(this.f220a, newState);
            this.f221b.mo3724a(owner, event);
            this.f220a = newState;
        }
    }

    public C0152h(C0001f provider) {
        this.f215c = new WeakReference<>(provider);
        this.f214b = C0149b.INITIALIZED;
    }

    /* renamed from: a */
    public void mo3754a(C0149b state) {
        m849c(state);
    }

    /* renamed from: b */
    public void mo3755b(C0000a event) {
        m849c(m841a(event));
    }

    /* renamed from: c */
    private void m849c(C0149b next) {
        if (this.f214b != next) {
            this.f214b = next;
            if (this.f217e || this.f216d != 0) {
                this.f218f = true;
                return;
            }
            this.f217e = true;
            m850d();
            this.f217e = false;
        }
    }

    /* renamed from: b */
    private boolean m846b() {
        boolean z = true;
        if (this.f213a.size() == 0) {
            return true;
        }
        C0149b eldestObserverState = ((C0153a) this.f213a.mo8756a().getValue()).f220a;
        C0149b newestObserverState = ((C0153a) this.f213a.mo8758c().getValue()).f220a;
        if (!(eldestObserverState == newestObserverState && this.f214b == newestObserverState)) {
            z = false;
        }
        return z;
    }

    /* renamed from: c */
    private C0149b m847c(C0150e observer) {
        Entry<LifecycleObserver, ObserverWithState> previous = this.f213a.mo8752b(observer);
        C0149b parentState = null;
        C0149b siblingState = previous != null ? ((C0153a) previous.getValue()).f220a : null;
        if (!this.f219g.isEmpty()) {
            ArrayList<C0149b> arrayList = this.f219g;
            parentState = (C0149b) arrayList.get(arrayList.size() - 1);
        }
        return m842a(m842a(this.f214b, siblingState), parentState);
    }

    /* renamed from: a */
    public void mo3751a(C0150e observer) {
        C0149b bVar = this.f214b;
        C0149b bVar2 = C0149b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = C0149b.INITIALIZED;
        }
        C0153a statefulObserver = new C0153a(observer, bVar2);
        if (((C0153a) this.f213a.mo8751b(observer, statefulObserver)) == null) {
            C0001f lifecycleOwner = (C0001f) this.f215c.get();
            if (lifecycleOwner != null) {
                boolean isReentrance = this.f216d != 0 || this.f217e;
                C0149b targetState = m847c(observer);
                this.f216d++;
                while (statefulObserver.f220a.compareTo(targetState) < 0 && this.f213a.contains(observer)) {
                    m851d(statefulObserver.f220a);
                    statefulObserver.mo3756a(lifecycleOwner, m852e(statefulObserver.f220a));
                    m848c();
                    targetState = m847c(observer);
                }
                if (!isReentrance) {
                    m850d();
                }
                this.f216d--;
            }
        }
    }

    /* renamed from: c */
    private void m848c() {
        ArrayList<C0149b> arrayList = this.f219g;
        arrayList.remove(arrayList.size() - 1);
    }

    /* renamed from: d */
    private void m851d(C0149b state) {
        this.f219g.add(state);
    }

    /* renamed from: b */
    public void mo3752b(C0150e observer) {
        this.f213a.remove(observer);
    }

    /* renamed from: a */
    public C0149b mo3750a() {
        return this.f214b;
    }

    /* renamed from: a */
    static C0149b m841a(C0000a event) {
        switch (C0151g.f211a[event.ordinal()]) {
            case 1:
            case 2:
                return C0149b.CREATED;
            case 3:
            case 4:
                return C0149b.STARTED;
            case 5:
                return C0149b.RESUMED;
            case 6:
                return C0149b.DESTROYED;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected event value ");
                sb.append(event);
                throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: b */
    private static C0000a m844b(C0149b state) {
        int i = C0151g.f212b[state.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException();
        } else if (i == 2) {
            return C0000a.ON_DESTROY;
        } else {
            if (i == 3) {
                return C0000a.ON_STOP;
            }
            if (i == 4) {
                return C0000a.ON_PAUSE;
            }
            if (i != 5) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected state value ");
                sb.append(state);
                throw new IllegalArgumentException(sb.toString());
            }
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: e */
    private static C0000a m852e(C0149b state) {
        int i = C0151g.f212b[state.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return C0000a.ON_START;
            }
            if (i == 3) {
                return C0000a.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            } else if (i != 5) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected state value ");
                sb.append(state);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return C0000a.ON_CREATE;
    }

    /* renamed from: b */
    private void m845b(C0001f lifecycleOwner) {
        Iterator<Entry<LifecycleObserver, ObserverWithState>> ascendingIterator = this.f213a.mo8757b();
        while (ascendingIterator.hasNext() && !this.f218f) {
            Entry<LifecycleObserver, ObserverWithState> entry = (Entry) ascendingIterator.next();
            C0153a observer = (C0153a) entry.getValue();
            while (observer.f220a.compareTo(this.f214b) < 0 && !this.f218f && this.f213a.contains(entry.getKey())) {
                m851d(observer.f220a);
                observer.mo3756a(lifecycleOwner, m852e(observer.f220a));
                m848c();
            }
        }
    }

    /* renamed from: a */
    private void m843a(C0001f lifecycleOwner) {
        Iterator<Entry<LifecycleObserver, ObserverWithState>> descendingIterator = this.f213a.descendingIterator();
        while (descendingIterator.hasNext() && !this.f218f) {
            Entry<LifecycleObserver, ObserverWithState> entry = (Entry) descendingIterator.next();
            C0153a observer = (C0153a) entry.getValue();
            while (observer.f220a.compareTo(this.f214b) > 0 && !this.f218f && this.f213a.contains(entry.getKey())) {
                C0000a event = m844b(observer.f220a);
                m851d(m841a(event));
                observer.mo3756a(lifecycleOwner, event);
                m848c();
            }
        }
    }

    /* renamed from: d */
    private void m850d() {
        C0001f lifecycleOwner = (C0001f) this.f215c.get();
        if (lifecycleOwner == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!m846b()) {
            this.f218f = false;
            if (this.f214b.compareTo(((C0153a) this.f213a.mo8756a().getValue()).f220a) < 0) {
                m843a(lifecycleOwner);
            }
            Entry<LifecycleObserver, ObserverWithState> newest = this.f213a.mo8758c();
            if (!this.f218f && newest != null && this.f214b.compareTo(((C0153a) newest.getValue()).f220a) > 0) {
                m845b(lifecycleOwner);
            }
        }
        this.f218f = false;
    }

    /* renamed from: a */
    static C0149b m842a(C0149b state1, C0149b state2) {
        return (state2 == null || state2.compareTo(state1) >= 0) ? state1 : state2;
    }
}
