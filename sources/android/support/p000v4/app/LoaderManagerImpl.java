package android.support.p000v4.app;

import android.arch.lifecycle.C0001f;
import android.arch.lifecycle.C0158m;
import android.arch.lifecycle.C0159n;
import android.arch.lifecycle.C0162q;
import android.arch.lifecycle.C0163r;
import android.arch.lifecycle.C0163r.C0164a;
import android.arch.lifecycle.C0165s;
import android.os.Bundle;
import android.os.Looper;
import android.support.p000v4.app.C0442W.C0443a;
import android.support.p000v4.content.C0511c;
import android.support.p000v4.content.C0511c.C0513b;
import android.support.v4.content.Loader;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import p002b.p003c.p053g.p061f.C1257f;
import p002b.p003c.p053g.p061f.C1274r;

/* renamed from: android.support.v4.app.LoaderManagerImpl */
class LoaderManagerImpl extends C0442W {

    /* renamed from: a */
    static boolean f1459a = false;

    /* renamed from: b */
    private final C0001f f1460b;

    /* renamed from: c */
    private final LoaderViewModel f1461c;

    /* renamed from: d */
    private boolean f1462d;

    /* renamed from: android.support.v4.app.LoaderManagerImpl$LoaderViewModel */
    static class LoaderViewModel extends C0162q {

        /* renamed from: a */
        private static final C0164a f1463a = new C0444X();

        /* renamed from: b */
        private C1274r<C0431a> f1464b = new C1274r<>();

        LoaderViewModel() {
        }

        /* renamed from: a */
        static LoaderViewModel m2223a(C0165s viewModelStore) {
            return (LoaderViewModel) new C0163r(viewModelStore, f1463a).mo3769a(LoaderViewModel.class);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5055a(int id, C0431a info) {
            this.f1464b.mo9178c(id, info);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public <D> C0431a<D> mo5054a(int id) {
            return (C0431a) this.f1464b.mo9175b(id);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5057b() {
            int size = this.f1464b.mo9174b();
            for (int index = 0; index < size; index++) {
                ((C0431a) this.f1464b.mo9182f(index)).mo5063g();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3768a() {
            super.mo3768a();
            int size = this.f1464b.mo9174b();
            for (int index = 0; index < size; index++) {
                ((C0431a) this.f1464b.mo9182f(index)).mo5059a(true);
            }
            this.f1464b.mo9171a();
        }

        /* renamed from: a */
        public void mo5056a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            if (this.f1464b.mo9174b() > 0) {
                writer.print(prefix);
                writer.println("Loaders:");
                StringBuilder sb = new StringBuilder();
                sb.append(prefix);
                sb.append("    ");
                String innerPrefix = sb.toString();
                for (int i = 0; i < this.f1464b.mo9174b(); i++) {
                    C0431a info = (C0431a) this.f1464b.mo9182f(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(this.f1464b.mo9180d(i));
                    writer.print(": ");
                    writer.println(info.toString());
                    info.mo5061a(innerPrefix, fd, writer, args);
                }
            }
        }
    }

    /* renamed from: android.support.v4.app.LoaderManagerImpl$a */
    public static class C0431a<D> extends C0158m<D> implements C0513b<D> {

        /* renamed from: k */
        private final int f1465k;

        /* renamed from: l */
        private final Bundle f1466l;

        /* renamed from: m */
        private final C0511c<D> f1467m;

        /* renamed from: n */
        private C0001f f1468n;

        /* renamed from: o */
        private C0432b<D> f1469o;

        /* renamed from: p */
        private C0511c<D> f1470p;

        C0431a(int id, Bundle args, C0511c<D> loader, C0511c<D> priorLoader) {
            this.f1465k = id;
            this.f1466l = args;
            this.f1467m = loader;
            this.f1470p = priorLoader;
            this.f1467m.mo5292a(id, this);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public C0511c<D> mo5062f() {
            return this.f1467m;
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo3737d() {
            if (LoaderManagerImpl.f1459a) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Starting: ");
                sb.append(this);
                Log.v("LoaderManager", sb.toString());
            }
            this.f1467m.mo5307p();
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public void mo3738e() {
            if (LoaderManagerImpl.f1459a) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Stopping: ");
                sb.append(this);
                Log.v("LoaderManager", sb.toString());
            }
            this.f1467m.mo5308q();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0511c<D> mo5058a(C0001f owner, C0443a<D> callback) {
            LoaderObserver<D> observer = new C0432b<>(this.f1467m, callback);
            mo3731a(owner, (C0159n<T>) observer);
            C0432b<D> bVar = this.f1469o;
            if (bVar != null) {
                mo3732a((C0159n<D>) bVar);
            }
            this.f1468n = owner;
            this.f1469o = observer;
            return this.f1467m;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: g */
        public void mo5063g() {
            C0001f lifecycleOwner = this.f1468n;
            LoaderObserver<D> observer = this.f1469o;
            if (lifecycleOwner != null && observer != null) {
                super.mo3732a((C0159n<T>) observer);
                mo3731a(lifecycleOwner, (C0159n<T>) observer);
            }
        }

        /* renamed from: a */
        public void mo3732a(C0159n<D> observer) {
            super.mo3732a(observer);
            this.f1468n = null;
            this.f1469o = null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0511c<D> mo5059a(boolean reset) {
            if (LoaderManagerImpl.f1459a) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Destroying: ");
                sb.append(this);
                Log.v("LoaderManager", sb.toString());
            }
            this.f1467m.mo5295b();
            this.f1467m.mo5291a();
            LoaderObserver<D> observer = this.f1469o;
            if (observer != null) {
                mo3732a((C0159n<D>) observer);
                if (reset) {
                    observer.mo5067b();
                }
            }
            this.f1467m.mo5293a((C0513b<D>) this);
            if ((observer == null || observer.mo5066a()) && !reset) {
                return this.f1467m;
            }
            this.f1467m.mo5305n();
            return this.f1470p;
        }

        /* renamed from: a */
        public void mo5060a(C0511c<D> cVar, D data) {
            String str = "LoaderManager";
            if (LoaderManagerImpl.f1459a) {
                StringBuilder sb = new StringBuilder();
                sb.append("onLoadComplete: ");
                sb.append(this);
                Log.v(str, sb.toString());
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                mo3735b(data);
                return;
            }
            if (LoaderManagerImpl.f1459a) {
                Log.w(str, "onLoadComplete was incorrectly called on a background thread");
            }
            mo3733a(data);
        }

        /* renamed from: b */
        public void mo3735b(D value) {
            super.mo3735b(value);
            C0511c<D> cVar = this.f1470p;
            if (cVar != null) {
                cVar.mo5305n();
                this.f1470p = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f1465k);
            sb.append(" : ");
            C1257f.m5913a(this.f1467m, sb);
            sb.append("}}");
            return sb.toString();
        }

        /* renamed from: a */
        public void mo5061a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            writer.print(prefix);
            writer.print("mId=");
            writer.print(this.f1465k);
            writer.print(" mArgs=");
            writer.println(this.f1466l);
            writer.print(prefix);
            writer.print("mLoader=");
            writer.println(this.f1467m);
            C0511c<D> cVar = this.f1467m;
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            String str = "  ";
            sb.append(str);
            cVar.mo5262a(sb.toString(), fd, writer, args);
            if (this.f1469o != null) {
                writer.print(prefix);
                writer.print("mCallbacks=");
                writer.println(this.f1469o);
                C0432b<D> bVar = this.f1469o;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(prefix);
                sb2.append(str);
                bVar.mo5065a(sb2.toString(), writer);
            }
            writer.print(prefix);
            writer.print("mData=");
            writer.println(mo5062f().mo5290a(mo3734b()));
            writer.print(prefix);
            writer.print("mStarted=");
            writer.println(mo3736c());
        }
    }

    /* renamed from: android.support.v4.app.LoaderManagerImpl$b */
    static class C0432b<D> implements C0159n<D> {

        /* renamed from: a */
        private final C0511c<D> f1471a;

        /* renamed from: b */
        private final C0443a<D> f1472b;

        /* renamed from: c */
        private boolean f1473c = false;

        C0432b(C0511c<D> loader, C0443a<D> callback) {
            this.f1471a = loader;
            this.f1472b = callback;
        }

        /* renamed from: a */
        public void mo3758a(D data) {
            if (LoaderManagerImpl.f1459a) {
                StringBuilder sb = new StringBuilder();
                sb.append("  onLoadFinished in ");
                sb.append(this.f1471a);
                sb.append(": ");
                sb.append(this.f1471a.mo5290a(data));
                Log.v("LoaderManager", sb.toString());
            }
            this.f1472b.mo5092a(this.f1471a, data);
            this.f1473c = true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo5066a() {
            return this.f1473c;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5067b() {
            if (this.f1473c) {
                if (LoaderManagerImpl.f1459a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("  Resetting: ");
                    sb.append(this.f1471a);
                    Log.v("LoaderManager", sb.toString());
                }
                this.f1472b.mo5091a(this.f1471a);
            }
        }

        public String toString() {
            return this.f1472b.toString();
        }

        /* renamed from: a */
        public void mo5065a(String prefix, PrintWriter writer) {
            writer.print(prefix);
            writer.print("mDeliveredData=");
            writer.println(this.f1473c);
        }
    }

    LoaderManagerImpl(C0001f lifecycleOwner, C0165s viewModelStore) {
        this.f1460b = lifecycleOwner;
        this.f1461c = LoaderViewModel.m2223a(viewModelStore);
    }

    /* renamed from: a */
    private <D> C0511c<D> m2219a(int id, Bundle args, C0443a<D> callback, C0511c<D> priorLoader) {
        try {
            this.f1462d = true;
            Loader<D> loader = callback.onCreateLoader(id, args);
            if (loader.getClass().isMemberClass()) {
                if (!Modifier.isStatic(loader.getClass().getModifiers())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Object returned from onCreateLoader must not be a non-static inner member class: ");
                    sb.append(loader);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            C0431a aVar = new C0431a(id, args, loader, priorLoader);
            try {
                if (f1459a) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("  Created new loader ");
                    sb2.append(aVar);
                    Log.v("LoaderManager", sb2.toString());
                }
                this.f1461c.mo5055a(id, aVar);
                this.f1462d = false;
                return aVar.mo5058a(this.f1460b, callback);
            } catch (Throwable th) {
                th = th;
                this.f1462d = false;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            this.f1462d = false;
            throw th;
        }
    }

    /* renamed from: a */
    public <D> C0511c<D> mo5050a(int id, Bundle args, C0443a<D> callback) {
        if (this.f1462d) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            LoaderInfo<D> info = this.f1461c.mo5054a(id);
            String str = "LoaderManager";
            if (f1459a) {
                StringBuilder sb = new StringBuilder();
                sb.append("initLoader in ");
                sb.append(this);
                sb.append(": args=");
                sb.append(args);
                Log.v(str, sb.toString());
            }
            if (info == null) {
                return m2219a(id, args, callback, null);
            }
            if (f1459a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Re-using existing loader ");
                sb2.append(info);
                Log.v(str, sb2.toString());
            }
            return info.mo5058a(this.f1460b, callback);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5051a() {
        this.f1461c.mo5057b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        C1257f.m5913a(this.f1460b, sb);
        sb.append("}}");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo5052a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        this.f1461c.mo5056a(prefix, fd, writer, args);
    }
}
