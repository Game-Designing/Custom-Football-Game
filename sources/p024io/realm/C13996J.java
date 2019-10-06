package p024io.realm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p024io.realm.exceptions.RealmFileException;
import p024io.realm.exceptions.RealmFileException.Kind;
import p024io.realm.internal.C7324b;
import p024io.realm.internal.C7335j;
import p024io.realm.internal.Util;

/* renamed from: io.realm.J */
/* compiled from: RealmCache */
final class C13996J {

    /* renamed from: a */
    private static final List<WeakReference<C13996J>> f42391a = new LinkedList();

    /* renamed from: b */
    private static final Collection<C13996J> f42392b = new ConcurrentLinkedQueue();

    /* renamed from: c */
    private final EnumMap<C13998b, C13999c> f42393c;

    /* renamed from: d */
    private final String f42394d;

    /* renamed from: e */
    private C14001L f42395e;

    /* renamed from: f */
    private final C7324b[] f42396f = new C7324b[4];

    /* renamed from: g */
    private final AtomicBoolean f42397g;

    /* renamed from: io.realm.J$a */
    /* compiled from: RealmCache */
    interface C13997a {
        /* renamed from: a */
        void mo43558a(int i);
    }

    /* renamed from: io.realm.J$b */
    /* compiled from: RealmCache */
    private enum C13998b {
        TYPED_REALM,
        DYNAMIC_REALM;

        /* renamed from: a */
        static C13998b m44577a(Class<? extends C14048d> clazz) {
            if (clazz == C13990F.class) {
                return TYPED_REALM;
            }
            if (clazz == C14061h.class) {
                return DYNAMIC_REALM;
            }
            throw new IllegalArgumentException("The type of Realm class must be Realm or DynamicRealm.");
        }
    }

    /* renamed from: io.realm.J$c */
    /* compiled from: RealmCache */
    private static class C13999c {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final ThreadLocal<C14048d> f42401a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final ThreadLocal<Integer> f42402b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f42403c;

        private C13999c() {
            this.f42401a = new ThreadLocal<>();
            this.f42402b = new ThreadLocal<>();
            this.f42403c = 0;
        }
    }

    private C13996J(String path) {
        this.f42397g = new AtomicBoolean(false);
        this.f42394d = path;
        this.f42393c = new EnumMap<>(C13998b.class);
        for (C13998b type : C13998b.values()) {
            this.f42393c.put(type, new C13999c());
        }
    }

    /* renamed from: a */
    private static C13996J m44561a(String realmPath, boolean createIfNotExist) {
        C13996J cacheToReturn = null;
        synchronized (f42391a) {
            Iterator<WeakReference<RealmCache>> it = f42391a.iterator();
            while (it.hasNext()) {
                C13996J cache = (C13996J) ((WeakReference) it.next()).get();
                if (cache == null) {
                    it.remove();
                } else if (cache.f42394d.equals(realmPath)) {
                    cacheToReturn = cache;
                }
            }
            if (cacheToReturn == null && createIfNotExist) {
                cacheToReturn = new C13996J(realmPath);
                f42391a.add(new WeakReference(cacheToReturn));
            }
        }
        return cacheToReturn;
    }

    /* renamed from: a */
    static <E extends C14048d> E m44562a(C14001L configuration, Class<E> realmClass) {
        return m44561a(configuration.mo43567h(), true).m44568b(configuration, realmClass);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0057 A[Catch:{ all -> 0x0054 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized <E extends p024io.realm.C14048d> E m44568b(p024io.realm.C14001L r5, java.lang.Class<E> r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.EnumMap<io.realm.J$b, io.realm.J$c> r0 = r4.f42393c     // Catch:{ all -> 0x00d4 }
            io.realm.J$b r1 = p024io.realm.C13996J.C13998b.m44577a(r6)     // Catch:{ all -> 0x00d4 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00d4 }
            io.realm.J$c r0 = (p024io.realm.C13996J.C13999c) r0     // Catch:{ all -> 0x00d4 }
            int r1 = r4.m44570d()     // Catch:{ all -> 0x00d4 }
            if (r1 != 0) goto L_0x005b
            m44565a(r5)     // Catch:{ all -> 0x00d4 }
            boolean r1 = r5.mo43577r()     // Catch:{ all -> 0x00d4 }
            r2 = 0
            io.realm.internal.SharedRealm r3 = p024io.realm.internal.SharedRealm.m15929a(r5)     // Catch:{ all -> 0x0054 }
            r2 = r3
            if (r1 != 0) goto L_0x0036
            io.realm.internal.j r3 = p024io.realm.internal.C7335j.m16148a()     // Catch:{ Throwable -> 0x002c }
            r3.mo23773a(r5)     // Catch:{ Throwable -> 0x002c }
            goto L_0x0036
        L_0x002a:
            r3 = move-exception
            goto L_0x0055
        L_0x002c:
            r3 = move-exception
            r2.close()     // Catch:{ all -> 0x002a }
            r2 = 0
            p024io.realm.C13990F.m44514a(r5)     // Catch:{ all -> 0x002a }
            throw r3     // Catch:{ all -> 0x002a }
        L_0x0036:
            boolean r3 = p024io.realm.internal.Table.m15961b(r2)     // Catch:{ all -> 0x0054 }
            if (r3 == 0) goto L_0x004c
            r2.mo23617a()     // Catch:{ all -> 0x002a }
            boolean r3 = p024io.realm.internal.Table.m15960a(r2)     // Catch:{ all -> 0x002a }
            if (r3 == 0) goto L_0x0049
            r2.mo23624c()     // Catch:{ all -> 0x002a }
            goto L_0x004c
        L_0x0049:
            r2.mo23623b()     // Catch:{ all -> 0x002a }
        L_0x004c:
            if (r2 == 0) goto L_0x0051
            r2.close()     // Catch:{ all -> 0x00d4 }
        L_0x0051:
            r4.f42395e = r5     // Catch:{ all -> 0x00d4 }
            goto L_0x005e
        L_0x0054:
            r3 = move-exception
        L_0x0055:
            if (r2 == 0) goto L_0x005a
            r2.close()     // Catch:{ all -> 0x00d4 }
        L_0x005a:
            throw r3     // Catch:{ all -> 0x00d4 }
        L_0x005b:
            r4.m44569b(r5)     // Catch:{ all -> 0x00d4 }
        L_0x005e:
            java.lang.ThreadLocal r1 = r0.f42401a     // Catch:{ all -> 0x00d4 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x00d4 }
            if (r1 != 0) goto L_0x00ad
            java.lang.Class<io.realm.F> r1 = p024io.realm.C13990F.class
            if (r6 != r1) goto L_0x0071
            io.realm.F r1 = p024io.realm.C13990F.m44507a(r4)     // Catch:{ all -> 0x00d4 }
            goto L_0x0079
        L_0x0071:
            java.lang.Class<io.realm.h> r1 = p024io.realm.C14061h.class
            if (r6 != r1) goto L_0x00a5
            io.realm.h r1 = p024io.realm.C14061h.m44874a(r4)     // Catch:{ all -> 0x00d4 }
        L_0x0079:
            java.lang.ThreadLocal r2 = r0.f42401a     // Catch:{ all -> 0x00d4 }
            r2.set(r1)     // Catch:{ all -> 0x00d4 }
            java.lang.ThreadLocal r2 = r0.f42402b     // Catch:{ all -> 0x00d4 }
            r3 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00d4 }
            r2.set(r3)     // Catch:{ all -> 0x00d4 }
            java.lang.Class<io.realm.F> r2 = p024io.realm.C13990F.class
            if (r6 != r2) goto L_0x00a1
            int r2 = r0.f42403c     // Catch:{ all -> 0x00d4 }
            if (r2 != 0) goto L_0x00a1
            io.realm.internal.b[] r2 = r4.f42396f     // Catch:{ all -> 0x00d4 }
            io.realm.ea r3 = r1.f42569h     // Catch:{ all -> 0x00d4 }
            io.realm.internal.b r3 = r3.mo43718b()     // Catch:{ all -> 0x00d4 }
            m44560a(r2, r3)     // Catch:{ all -> 0x00d4 }
        L_0x00a1:
            r0.f42403c = r0.f42403c + 1     // Catch:{ all -> 0x00d4 }
            goto L_0x00ad
        L_0x00a5:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00d4 }
            java.lang.String r2 = "The type of Realm class must be Realm or DynamicRealm."
            r1.<init>(r2)     // Catch:{ all -> 0x00d4 }
            throw r1     // Catch:{ all -> 0x00d4 }
        L_0x00ad:
            java.lang.ThreadLocal r1 = r0.f42402b     // Catch:{ all -> 0x00d4 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x00d4 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x00d4 }
            java.lang.ThreadLocal r2 = r0.f42402b     // Catch:{ all -> 0x00d4 }
            int r3 = r1.intValue()     // Catch:{ all -> 0x00d4 }
            int r3 = r3 + 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00d4 }
            r2.set(r3)     // Catch:{ all -> 0x00d4 }
            java.lang.ThreadLocal r2 = r0.f42401a     // Catch:{ all -> 0x00d4 }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x00d4 }
            io.realm.d r2 = (p024io.realm.C14048d) r2     // Catch:{ all -> 0x00d4 }
            monitor-exit(r4)
            return r2
        L_0x00d4:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p024io.realm.C13996J.m44568b(io.realm.L, java.lang.Class):io.realm.d");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b6, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo43555a(p024io.realm.C14048d r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = r8.mo43545j()     // Catch:{ all -> 0x00b7 }
            java.util.EnumMap<io.realm.J$b, io.realm.J$c> r1 = r7.f42393c     // Catch:{ all -> 0x00b7 }
            java.lang.Class r2 = r8.getClass()     // Catch:{ all -> 0x00b7 }
            io.realm.J$b r2 = p024io.realm.C13996J.C13998b.m44577a(r2)     // Catch:{ all -> 0x00b7 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x00b7 }
            io.realm.J$c r1 = (p024io.realm.C13996J.C13999c) r1     // Catch:{ all -> 0x00b7 }
            java.lang.ThreadLocal r2 = r1.f42402b     // Catch:{ all -> 0x00b7 }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x00b7 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x00b7 }
            r3 = 0
            if (r2 != 0) goto L_0x0027
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00b7 }
            r2 = r4
        L_0x0027:
            int r4 = r2.intValue()     // Catch:{ all -> 0x00b7 }
            r5 = 1
            if (r4 > 0) goto L_0x003c
            java.lang.String r4 = "%s has been closed already. refCount is %s"
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x00b7 }
            r6[r3] = r0     // Catch:{ all -> 0x00b7 }
            r6[r5] = r2     // Catch:{ all -> 0x00b7 }
            p024io.realm.log.RealmLog.m16238c(r4, r6)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r7)
            return
        L_0x003c:
            int r3 = r2.intValue()     // Catch:{ all -> 0x00b7 }
            int r3 = r3 - r5
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00b7 }
            r2 = r3
            int r3 = r2.intValue()     // Catch:{ all -> 0x00b7 }
            if (r3 != 0) goto L_0x00ae
            java.lang.ThreadLocal r3 = r1.f42402b     // Catch:{ all -> 0x00b7 }
            r4 = 0
            r3.set(r4)     // Catch:{ all -> 0x00b7 }
            java.lang.ThreadLocal r3 = r1.f42401a     // Catch:{ all -> 0x00b7 }
            r3.set(r4)     // Catch:{ all -> 0x00b7 }
            r1.f42403c = r1.f42403c - 1     // Catch:{ all -> 0x00b7 }
            int r3 = r1.f42403c     // Catch:{ all -> 0x00b7 }
            if (r3 < 0) goto L_0x0092
            boolean r3 = r8 instanceof p024io.realm.C13990F     // Catch:{ all -> 0x00b7 }
            if (r3 == 0) goto L_0x0073
            int r3 = r1.f42403c     // Catch:{ all -> 0x00b7 }
            if (r3 != 0) goto L_0x0073
            io.realm.internal.b[] r3 = r7.f42396f     // Catch:{ all -> 0x00b7 }
            java.util.Arrays.fill(r3, r4)     // Catch:{ all -> 0x00b7 }
        L_0x0073:
            r8.mo43694h()     // Catch:{ all -> 0x00b7 }
            int r3 = r7.m44570d()     // Catch:{ all -> 0x00b7 }
            if (r3 != 0) goto L_0x00b5
            r7.f42395e = r4     // Catch:{ all -> 0x00b7 }
            io.realm.L r3 = r8.mo43544i()     // Catch:{ all -> 0x00b7 }
            boolean r3 = r3.mo43576q()     // Catch:{ all -> 0x00b7 }
            io.realm.internal.j r3 = p024io.realm.internal.C7335j.m16149a(r3)     // Catch:{ all -> 0x00b7 }
            io.realm.L r4 = r8.mo43544i()     // Catch:{ all -> 0x00b7 }
            r3.mo23777e(r4)     // Catch:{ all -> 0x00b7 }
            goto L_0x00b5
        L_0x0092:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00b7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b7 }
            r4.<init>()     // Catch:{ all -> 0x00b7 }
            java.lang.String r5 = "Global reference counter of Realm"
            r4.append(r5)     // Catch:{ all -> 0x00b7 }
            r4.append(r0)     // Catch:{ all -> 0x00b7 }
            java.lang.String r5 = " got corrupted."
            r4.append(r5)     // Catch:{ all -> 0x00b7 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00b7 }
            r3.<init>(r4)     // Catch:{ all -> 0x00b7 }
            throw r3     // Catch:{ all -> 0x00b7 }
        L_0x00ae:
            java.lang.ThreadLocal r3 = r1.f42402b     // Catch:{ all -> 0x00b7 }
            r3.set(r2)     // Catch:{ all -> 0x00b7 }
        L_0x00b5:
            monitor-exit(r7)
            return
        L_0x00b7:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p024io.realm.C13996J.mo43555a(io.realm.d):void");
    }

    /* renamed from: b */
    private void m44569b(C14001L newConfiguration) {
        if (!this.f42395e.equals(newConfiguration)) {
            if (Arrays.equals(this.f42395e.mo43563e(), newConfiguration.mo43563e())) {
                C14020X newMigration = newConfiguration.mo43566g();
                C14020X oldMigration = this.f42395e.mo43566g();
                if (oldMigration == null || newMigration == null || !oldMigration.getClass().equals(newMigration.getClass()) || newMigration.equals(oldMigration)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Configurations cannot be different if used to open the same file. \nCached configuration: \n");
                    sb.append(this.f42395e);
                    sb.append("\n\nNew configuration: \n");
                    sb.append(newConfiguration);
                    throw new IllegalArgumentException(sb.toString());
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Configurations cannot be different if used to open the same file. The most likely cause is that equals() and hashCode() are not overridden in the migration class: ");
                sb2.append(newConfiguration.mo43566g().getClass().getCanonicalName());
                throw new IllegalArgumentException(sb2.toString());
            }
            throw new IllegalArgumentException("Wrong key used to decrypt Realm.");
        }
    }

    /* renamed from: a */
    static void m44566a(C14001L configuration, C13997a callback) {
        synchronized (f42391a) {
            C13996J cache = m44561a(configuration.mo43567h(), false);
            if (cache == null) {
                callback.mo43558a(0);
            } else {
                cache.m44564a(callback);
            }
        }
    }

    /* renamed from: a */
    private synchronized void m44564a(C13997a callback) {
        callback.mo43558a(m44570d());
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo43554a(p024io.realm.C13990F r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.EnumMap<io.realm.J$b, io.realm.J$c> r0 = r3.f42393c     // Catch:{ all -> 0x0024 }
            io.realm.J$b r1 = p024io.realm.C13996J.C13998b.TYPED_REALM     // Catch:{ all -> 0x0024 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0024 }
            io.realm.J$c r0 = (p024io.realm.C13996J.C13999c) r0     // Catch:{ all -> 0x0024 }
            java.lang.ThreadLocal r1 = r0.f42401a     // Catch:{ all -> 0x0024 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0017
            monitor-exit(r3)
            return
        L_0x0017:
            io.realm.internal.b[] r1 = r3.f42396f     // Catch:{ all -> 0x0024 }
            io.realm.internal.b r2 = r4.mo43530a(r1)     // Catch:{ all -> 0x0024 }
            if (r2 == 0) goto L_0x0022
            m44560a(r1, r2)     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r3)
            return
        L_0x0024:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p024io.realm.C13996J.mo43554a(io.realm.F):void");
    }

    /* renamed from: a */
    private static void m44565a(C14001L configuration) {
        if (configuration.mo43574n()) {
            m44567a(configuration.mo43560b(), new File(configuration.mo43569i(), configuration.mo43570j()));
        }
        String syncServerCertificateAssetName = C7335j.m16149a(configuration.mo43576q()).mo23774b(configuration);
        if (!Util.m16052a(syncServerCertificateAssetName)) {
            m44567a(syncServerCertificateAssetName, new File(C7335j.m16149a(configuration.mo43576q()).mo23775c(configuration)));
        }
    }

    /* renamed from: a */
    private static void m44567a(String assetFileName, File file) {
        if (!file.exists()) {
            IOException exceptionWhenClose = null;
            InputStream inputStream = null;
            FileOutputStream outputStream = null;
            try {
                inputStream = C14048d.f42562a.getAssets().open(assetFileName);
                if (inputStream != null) {
                    FileOutputStream outputStream2 = new FileOutputStream(file);
                    byte[] buf = new byte[Opcodes.ACC_SYNTHETIC];
                    while (true) {
                        int read = inputStream.read(buf);
                        int bytesRead = read;
                        if (read <= -1) {
                            break;
                        }
                        outputStream2.write(buf, 0, bytesRead);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            exceptionWhenClose = e;
                        }
                    }
                    try {
                        outputStream2.close();
                    } catch (IOException e2) {
                        if (exceptionWhenClose == null) {
                            exceptionWhenClose = e2;
                        }
                    }
                    if (exceptionWhenClose != null) {
                        throw new RealmFileException(Kind.ACCESS_ERROR, (Throwable) exceptionWhenClose);
                    }
                    return;
                }
                Kind kind = Kind.ACCESS_ERROR;
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid input stream to the asset file: ");
                sb.append(assetFileName);
                throw new RealmFileException(kind, sb.toString());
            } catch (IOException e3) {
                Kind kind2 = Kind.ACCESS_ERROR;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not resolve the path to the asset file: ");
                sb2.append(assetFileName);
                throw new RealmFileException(kind2, sb2.toString(), e3);
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        exceptionWhenClose = e4;
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e5) {
                        if (exceptionWhenClose == null) {
                            IOException exceptionWhenClose2 = e5;
                        }
                    }
                }
                throw th;
            }
        }
    }

    /* renamed from: a */
    static C7324b m44563a(C7324b[] array, long schemaVersion) {
        for (int i = array.length - 1; i >= 0; i--) {
            C7324b candidate = array[i];
            if (candidate != null && candidate.mo23742a() == schemaVersion) {
                return candidate;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static int m44560a(C7324b[] array, C7324b columnIndices) {
        long oldestSchemaVersion = Long.MAX_VALUE;
        int candidateIndex = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == null) {
                array[i] = columnIndices;
                return i;
            }
            C7324b target = array[i];
            if (target.mo23742a() <= oldestSchemaVersion) {
                oldestSchemaVersion = target.mo23742a();
                candidateIndex = i;
            }
        }
        array[candidateIndex] = columnIndices;
        return candidateIndex;
    }

    /* renamed from: a */
    public C14001L mo43553a() {
        return this.f42395e;
    }

    /* renamed from: b */
    public C7324b[] mo43556b() {
        return this.f42396f;
    }

    /* renamed from: d */
    private int m44570d() {
        int totalRefCount = 0;
        for (C13999c refAndCount : this.f42393c.values()) {
            totalRefCount += refAndCount.f42403c;
        }
        return totalRefCount;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo43557c() {
        if (!this.f42397g.getAndSet(true)) {
            f42392b.add(this);
        }
    }
}
