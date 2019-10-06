package p024io.realm.internal;

import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p024io.realm.C14001L;
import p024io.realm.CompactOnLaunchCallback;
import p024io.realm.internal.Collection.C7301d;
import p024io.realm.internal.Collection.Iterator;
import p024io.realm.internal.android.AndroidRealmNotifier;
import p024io.realm.internal.android.C7319a;

/* renamed from: io.realm.internal.SharedRealm */
public final class SharedRealm implements Closeable, C7333h {

    /* renamed from: a */
    private static final long f14223a = nativeGetFinalizerPtr();

    /* renamed from: b */
    private static volatile File f14224b;

    /* renamed from: c */
    private final List<WeakReference<C7340m>> f14225c = new CopyOnWriteArrayList();

    /* renamed from: d */
    public final List<WeakReference<Collection>> f14226d = new CopyOnWriteArrayList();

    /* renamed from: e */
    public final List<WeakReference<C7301d>> f14227e = new ArrayList();

    /* renamed from: f */
    public final RealmNotifier f14228f;

    /* renamed from: g */
    public final C7314a f14229g;

    /* renamed from: h */
    private final C7313c f14230h;

    /* renamed from: i */
    private final C14001L f14231i;

    /* renamed from: j */
    private final long f14232j;

    /* renamed from: k */
    private long f14233k;

    /* renamed from: l */
    final C7332g f14234l;

    /* renamed from: io.realm.internal.SharedRealm$a */
    public enum C7311a {
        FULL(0),
        MEM_ONLY(1);
        

        /* renamed from: d */
        final int f14238d;

        private C7311a(int value) {
            this.f14238d = value;
        }
    }

    /* renamed from: io.realm.internal.SharedRealm$b */
    private enum C7312b {
        SCHEMA_MODE_AUTOMATIC(0),
        SCHEMA_MODE_READONLY(1),
        SCHEMA_MODE_RESET_FILE(2),
        SCHEMA_MODE_ADDITIVE(3),
        SCHEMA_MODE_MANUAL(4);
        

        /* renamed from: g */
        final byte f14245g;

        private C7312b(byte value) {
            this.f14245g = value;
        }

        /* renamed from: e */
        public byte mo23637e() {
            return this.f14245g;
        }
    }

    /* renamed from: io.realm.internal.SharedRealm$c */
    public interface C7313c {
        /* renamed from: a */
        void mo23638a(long j);
    }

    private static native void nativeBeginTransaction(long j);

    private static native void nativeCancelTransaction(long j);

    private static native void nativeCloseConfig(long j);

    private static native void nativeCloseSharedRealm(long j);

    private static native void nativeCommitTransaction(long j);

    private static native long nativeCreateConfig(String str, byte[] bArr, byte b, boolean z, boolean z2, long j, boolean z3, boolean z4, CompactOnLaunchCallback compactOnLaunchCallback, String str2, String str3, String str4, String str5, boolean z5, String str6);

    private static native long nativeCreateTable(long j, String str);

    private static native long nativeGetFinalizerPtr();

    private static native long nativeGetSharedRealm(long j, RealmNotifier realmNotifier);

    private static native long nativeGetTable(long j, String str);

    private static native long nativeGetVersion(long j);

    private static native boolean nativeHasTable(long j, String str);

    private static native void nativeInit(String str);

    private static native boolean nativeIsClosed(long j);

    private static native boolean nativeIsInTransaction(long j);

    private static native long nativeReadGroup(long j);

    private static native void nativeRemoveTable(long j, String str);

    private static native void nativeSetAutoRefresh(long j, boolean z);

    private static native void nativeSetVersion(long j, long j2);

    private static native void nativeUpdateSchema(long j, long j2, long j3);

    /* renamed from: a */
    public static void m15931a(File tempDirectory) {
        if (f14224b == null) {
            if (tempDirectory != null) {
                String temporaryDirectoryPath = tempDirectory.getAbsolutePath();
                if (tempDirectory.isDirectory() || tempDirectory.mkdirs() || tempDirectory.isDirectory()) {
                    String str = "/";
                    if (!temporaryDirectoryPath.endsWith(str)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(temporaryDirectoryPath);
                        sb.append(str);
                        temporaryDirectoryPath = sb.toString();
                    }
                    nativeInit(temporaryDirectoryPath);
                    f14224b = tempDirectory;
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("failed to create temporary directory: ");
                sb2.append(temporaryDirectoryPath);
                throw new IOException(sb2.toString());
            }
            throw new IllegalArgumentException("'tempDirectory' must not be null.");
        }
    }

    private SharedRealm(long nativeConfigPtr, C14001L configuration, C7313c schemaVersionListener) {
        C7314a capabilities = new C7319a();
        RealmNotifier realmNotifier = new AndroidRealmNotifier(this, capabilities);
        this.f14232j = nativeGetSharedRealm(nativeConfigPtr, realmNotifier);
        this.f14231i = configuration;
        this.f14229g = capabilities;
        this.f14228f = realmNotifier;
        this.f14230h = schemaVersionListener;
        this.f14234l = new C7332g();
        this.f14234l.mo23771a(this);
        this.f14233k = schemaVersionListener == null ? -1 : mo23631g();
        nativeSetAutoRefresh(this.f14232j, capabilities.mo23728a());
    }

    /* renamed from: a */
    public static SharedRealm m15929a(C14001L config) {
        return m15930a(config, null, false);
    }

    /* renamed from: a */
    public static SharedRealm m15930a(C14001L config, C7313c schemaVersionListener, boolean autoChangeNotifications) {
        C14001L l = config;
        Object[] syncUserConf = C7335j.m16148a().mo23776d(l);
        boolean z = false;
        String syncUserIdentifier = (String) syncUserConf[0];
        String syncRealmUrl = (String) syncUserConf[1];
        String syncRealmAuthUrl = (String) syncUserConf[2];
        String syncRefreshToken = (String) syncUserConf[3];
        boolean syncClientValidateSsl = Boolean.TRUE.equals(syncUserConf[4]);
        String syncSslTrustCertificatePath = (String) syncUserConf[5];
        String h = config.mo43567h();
        byte[] e = config.mo43563e();
        byte e2 = (syncRealmUrl != null ? C7312b.SCHEMA_MODE_ADDITIVE : C7312b.SCHEMA_MODE_MANUAL).mo23637e();
        if (config.mo43562d() == C7311a.MEM_ONLY) {
            z = true;
        }
        long nativeConfigPtr = nativeCreateConfig(h, e, e2, z, false, config.mo43573m(), true, autoChangeNotifications, config.mo43561c(), syncRealmUrl, syncRealmAuthUrl, syncUserIdentifier, syncRefreshToken, syncClientValidateSsl, syncSslTrustCertificatePath);
        try {
            C7335j.m16148a().mo23778f(l);
            try {
                SharedRealm sharedRealm = new SharedRealm(nativeConfigPtr, l, schemaVersionListener);
                nativeCloseConfig(nativeConfigPtr);
                return sharedRealm;
            } catch (Throwable th) {
                th = th;
                nativeCloseConfig(nativeConfigPtr);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            C7313c cVar = schemaVersionListener;
            nativeCloseConfig(nativeConfigPtr);
            throw th;
        }
    }

    /* renamed from: a */
    public void mo23617a() {
        mo23621a(false);
    }

    /* renamed from: a */
    public void mo23621a(boolean ignoreReadOnly) {
        if (ignoreReadOnly || !this.f14231i.mo43575o()) {
            mo23627d();
            m15932v();
            nativeBeginTransaction(this.f14232j);
            mo23634i();
            return;
        }
        throw new IllegalStateException("Write transactions cannot be used when a Realm is marked as read-only.");
    }

    /* renamed from: c */
    public void mo23624c() {
        nativeCommitTransaction(this.f14232j);
    }

    /* renamed from: b */
    public void mo23623b() {
        nativeCancelTransaction(this.f14232j);
    }

    /* renamed from: j */
    public boolean mo23636j() {
        return nativeIsInTransaction(this.f14232j);
    }

    /* renamed from: h */
    public void mo23633h(long schemaVersion) {
        nativeSetVersion(this.f14232j, schemaVersion);
    }

    /* renamed from: g */
    public long mo23631g() {
        return nativeGetVersion(this.f14232j);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public long mo23629e() {
        return nativeReadGroup(this.f14232j);
    }

    /* renamed from: c */
    public boolean mo23625c(String name) {
        return nativeHasTable(this.f14232j, name);
    }

    /* renamed from: b */
    public Table mo23622b(String name) {
        return new Table(this, nativeGetTable(this.f14232j, name));
    }

    /* renamed from: a */
    public Table mo23616a(String name) {
        return new Table(this, nativeCreateTable(this.f14232j, name));
    }

    /* renamed from: d */
    public void mo23628d(String name) {
        nativeRemoveTable(this.f14232j, name);
    }

    /* renamed from: f */
    public String mo23630f() {
        return this.f14231i.mo43567h();
    }

    public boolean isClosed() {
        return nativeIsClosed(this.f14232j);
    }

    /* renamed from: a */
    public void mo23619a(OsSchemaInfo schemaInfo, long version) {
        nativeUpdateSchema(this.f14232j, schemaInfo.getNativePtr(), version);
    }

    public void close() {
        RealmNotifier realmNotifier = this.f14228f;
        if (realmNotifier != null) {
            realmNotifier.close();
        }
        synchronized (this.f14234l) {
            nativeCloseSharedRealm(this.f14232j);
        }
    }

    public long getNativePtr() {
        return this.f14232j;
    }

    public long getNativeFinalizerPtr() {
        return f14223a;
    }

    /* renamed from: i */
    public void mo23634i() {
        if (this.f14230h != null) {
            long before = this.f14233k;
            long current = mo23631g();
            if (current != before) {
                this.f14233k = current;
                this.f14230h.mo23638a(current);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23618a(C7301d iterator) {
        this.f14227e.add(new WeakReference(iterator));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo23627d() {
        for (WeakReference<Iterator> iteratorRef : this.f14227e) {
            C7301d iterator = (C7301d) iteratorRef.get();
            if (iterator != null) {
                iterator.mo23572b();
            }
        }
        this.f14227e.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo23632h() {
        for (WeakReference<Iterator> iteratorRef : this.f14227e) {
            C7301d iterator = (C7301d) iteratorRef.get();
            if (iterator != null) {
                iterator.mo23573c();
            }
        }
        this.f14227e.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23620a(C7340m pendingRow) {
        for (WeakReference<PendingRow> ref : this.f14225c) {
            C7340m row = (C7340m) ref.get();
            if (row == null || row == pendingRow) {
                this.f14225c.remove(ref);
            }
        }
    }

    /* renamed from: v */
    private void m15932v() {
        for (WeakReference<PendingRow> ref : this.f14225c) {
            C7340m row = (C7340m) ref.get();
            if (row != null) {
                row.mo23788a();
            }
        }
        this.f14225c.clear();
    }
}
