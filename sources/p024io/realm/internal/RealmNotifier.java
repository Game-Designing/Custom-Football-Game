package p024io.realm.internal;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import p024io.realm.C14000K;
import p024io.realm.internal.C7336k.C7337a;
import p024io.realm.internal.C7336k.C7338b;

@Keep
/* renamed from: io.realm.internal.RealmNotifier */
public abstract class RealmNotifier implements Closeable {
    private final C7337a<C7310a> onChangeCallBack = new C7343o(this);
    private C7336k<C7310a> realmObserverPairs = new C7336k<>();
    /* access modifiers changed from: private */
    public SharedRealm sharedRealm;
    private List<Runnable> transactionCallbacks = new ArrayList();

    /* renamed from: io.realm.internal.RealmNotifier$a */
    private static class C7310a<T> extends C7338b<T, C14000K<T>> {
        public C7310a(T observer, C14000K<T> listener) {
            super(observer, listener);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m15928a(T observer) {
            if (observer != null) {
                ((C14000K) this.f14319b).mo43559a(observer);
            }
        }
    }

    public abstract boolean post(Runnable runnable);

    protected RealmNotifier(SharedRealm sharedRealm2) {
        this.sharedRealm = sharedRealm2;
    }

    /* access modifiers changed from: 0000 */
    public void didChange() {
        this.realmObserverPairs.mo23780a(this.onChangeCallBack);
        if (!this.transactionCallbacks.isEmpty()) {
            List<Runnable> callbacks = this.transactionCallbacks;
            this.transactionCallbacks = new ArrayList();
            for (Runnable runnable : callbacks) {
                runnable.run();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void beforeNotify() {
        this.sharedRealm.mo23632h();
    }

    public void close() {
        removeAllChangeListeners();
    }

    public <T> void addChangeListener(T observer, C14000K<T> realmChangeListener) {
        this.realmObserverPairs.mo23781a(new C7310a(observer, realmChangeListener));
    }

    public <E> void removeChangeListener(E observer, C14000K<E> realmChangeListener) {
        this.realmObserverPairs.mo23783a(observer, realmChangeListener);
    }

    public <E> void removeChangeListeners(E observer) {
        this.realmObserverPairs.mo23782a((Object) observer);
    }

    private void removeAllChangeListeners() {
        this.realmObserverPairs.mo23779a();
    }

    public void addTransactionCallback(Runnable runnable) {
        this.transactionCallbacks.add(runnable);
    }

    public int getListenersListSize() {
        return this.realmObserverPairs.mo23785c();
    }
}
