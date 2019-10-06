package p024io.realm;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import p024io.realm.C13990F.C13991a;
import p024io.realm.exceptions.RealmException;
import p024io.realm.exceptions.RealmFileException;
import p024io.realm.exceptions.RealmFileException.Kind;
import p024io.realm.internal.C7342n;
import p024io.realm.internal.C7346q;
import p024io.realm.internal.SharedRealm.C7311a;
import p024io.realm.internal.Util;
import p024io.realm.internal.p157b.C7325a;
import p024io.realm.internal.p157b.C7326b;
import p024io.realm.p355a.C14037p;
import p024io.realm.p355a.C14039q;

/* renamed from: io.realm.L */
/* compiled from: RealmConfiguration */
public class C14001L {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Object f42404a = C13990F.m44506B();

    /* renamed from: b */
    protected static final C7346q f42405b;

    /* renamed from: c */
    private static Boolean f42406c;

    /* renamed from: d */
    private final File f42407d;

    /* renamed from: e */
    private final String f42408e;

    /* renamed from: f */
    private final String f42409f;

    /* renamed from: g */
    private final String f42410g;

    /* renamed from: h */
    private final byte[] f42411h;

    /* renamed from: i */
    private final long f42412i;

    /* renamed from: j */
    private final C14020X f42413j;

    /* renamed from: k */
    private final boolean f42414k;

    /* renamed from: l */
    private final C7311a f42415l;

    /* renamed from: m */
    private final C7346q f42416m;

    /* renamed from: n */
    private final C14039q f42417n;

    /* renamed from: o */
    private final C13991a f42418o;

    /* renamed from: p */
    private final boolean f42419p;

    /* renamed from: q */
    private final CompactOnLaunchCallback f42420q;

    /* renamed from: io.realm.L$a */
    /* compiled from: RealmConfiguration */
    public static class C14002a {

        /* renamed from: a */
        private File f42421a;

        /* renamed from: b */
        private String f42422b;

        /* renamed from: c */
        private String f42423c;

        /* renamed from: d */
        private byte[] f42424d;

        /* renamed from: e */
        private long f42425e;

        /* renamed from: f */
        private C14020X f42426f;

        /* renamed from: g */
        private boolean f42427g;

        /* renamed from: h */
        private C7311a f42428h;

        /* renamed from: i */
        private HashSet<Object> f42429i;

        /* renamed from: j */
        private HashSet<Class<? extends C0105Y>> f42430j;

        /* renamed from: k */
        private C14039q f42431k;

        /* renamed from: l */
        private C13991a f42432l;

        /* renamed from: m */
        private boolean f42433m;

        /* renamed from: n */
        private CompactOnLaunchCallback f42434n;

        public C14002a() {
            this(C14048d.f42562a);
        }

        C14002a(Context context) {
            this.f42429i = new HashSet<>();
            this.f42430j = new HashSet<>();
            if (context != null) {
                C7342n.m16192a(context);
                m44606a(context);
                return;
            }
            throw new IllegalStateException("Call `Realm.init(Context)` before creating a RealmConfiguration");
        }

        /* renamed from: a */
        private void m44606a(Context context) {
            this.f42421a = context.getFilesDir();
            this.f42422b = "default.realm";
            this.f42424d = null;
            this.f42425e = 0;
            this.f42426f = null;
            this.f42427g = false;
            this.f42428h = C7311a.FULL;
            this.f42433m = false;
            this.f42434n = null;
            if (C14001L.f42404a != null) {
                this.f42429i.add(C14001L.f42404a);
            }
        }

        /* renamed from: a */
        public C14002a mo43582a(String filename) {
            if (filename == null || filename.isEmpty()) {
                throw new IllegalArgumentException("A non-empty filename must be provided");
            }
            this.f42422b = filename;
            return this;
        }

        /* renamed from: a */
        public C14002a mo43580a(long schemaVersion) {
            if (schemaVersion >= 0) {
                this.f42425e = schemaVersion;
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Realm schema version numbers must be 0 (zero) or higher. Yours was: ");
            sb.append(schemaVersion);
            throw new IllegalArgumentException(sb.toString());
        }

        /* renamed from: a */
        public C14002a mo43581a(C14020X migration) {
            if (migration != null) {
                this.f42426f = migration;
                return this;
            }
            throw new IllegalArgumentException("A non-null migration must be provided");
        }

        /* renamed from: a */
        public C14001L mo43583a() {
            if (this.f42433m) {
                if (this.f42432l != null) {
                    throw new IllegalStateException("This Realm is marked as read-only. Read-only Realms cannot use initialData(Realm.Transaction).");
                } else if (this.f42423c == null) {
                    throw new IllegalStateException("Only Realms provided using 'assetFile(path)' can be marked read-only. No such Realm was provided.");
                } else if (this.f42427g) {
                    throw new IllegalStateException("'deleteRealmIfMigrationNeeded()' and read-only Realms cannot be combined");
                } else if (this.f42434n != null) {
                    throw new IllegalStateException("'compactOnLaunch()' and read-only Realms cannot be combined");
                }
            }
            if (this.f42431k == null && C14001L.m44588p()) {
                this.f42431k = new C14037p();
            }
            File file = this.f42421a;
            String str = this.f42422b;
            String a = C14001L.m44587a(new File(file, str));
            String str2 = this.f42423c;
            byte[] bArr = this.f42424d;
            long j = this.f42425e;
            C14020X x = this.f42426f;
            boolean z = this.f42427g;
            C7311a aVar = this.f42428h;
            C7346q a2 = C14001L.m44585a(this.f42429i, this.f42430j);
            C14039q qVar = this.f42431k;
            C13991a aVar2 = this.f42432l;
            C13991a aVar3 = aVar2;
            C14001L l = new C14001L(file, str, a, str2, bArr, j, x, z, aVar, a2, qVar, aVar3, this.f42433m, this.f42434n);
            return l;
        }
    }

    static {
        Object obj = f42404a;
        if (obj != null) {
            C7346q mediator = m44584a(obj.getClass().getCanonicalName());
            if (mediator.mo23756c()) {
                f42405b = mediator;
                return;
            }
            throw new ExceptionInInitializerError("RealmTransformer doesn't seem to be applied. Please update the project configuration to use the Realm Gradle plugin. See https://realm.io/news/android-installation-change/");
        }
        f42405b = null;
    }

    protected C14001L(File realmDirectory, String realmFileName, String canonicalPath, String assetFilePath, byte[] key, long schemaVersion, C14020X migration, boolean deleteRealmIfMigrationNeeded, C7311a durability, C7346q schemaMediator, C14039q rxObservableFactory, C13991a initialDataTransaction, boolean readOnly, CompactOnLaunchCallback compactOnLaunch) {
        this.f42407d = realmDirectory;
        this.f42408e = realmFileName;
        this.f42409f = canonicalPath;
        this.f42410g = assetFilePath;
        this.f42411h = key;
        this.f42412i = schemaVersion;
        this.f42413j = migration;
        this.f42414k = deleteRealmIfMigrationNeeded;
        this.f42415l = durability;
        this.f42416m = schemaMediator;
        this.f42417n = rxObservableFactory;
        this.f42418o = initialDataTransaction;
        this.f42419p = readOnly;
        this.f42420q = compactOnLaunch;
    }

    /* renamed from: i */
    public File mo43569i() {
        return this.f42407d;
    }

    /* renamed from: j */
    public String mo43570j() {
        return this.f42408e;
    }

    /* renamed from: e */
    public byte[] mo43563e() {
        byte[] bArr = this.f42411h;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    /* renamed from: m */
    public long mo43573m() {
        return this.f42412i;
    }

    /* renamed from: g */
    public C14020X mo43566g() {
        return this.f42413j;
    }

    /* renamed from: s */
    public boolean mo43578s() {
        return this.f42414k;
    }

    /* renamed from: d */
    public C7311a mo43562d() {
        return this.f42415l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public C7346q mo43572l() {
        return this.f42416m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public C13991a mo43565f() {
        return this.f42418o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public boolean mo43574n() {
        return !Util.m16052a(this.f42410g);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo43560b() {
        return this.f42410g;
    }

    /* renamed from: c */
    public CompactOnLaunchCallback mo43561c() {
        return this.f42420q;
    }

    /* renamed from: h */
    public String mo43567h() {
        return this.f42409f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public boolean mo43577r() {
        return new File(this.f42409f).exists();
    }

    /* renamed from: k */
    public C14039q mo43571k() {
        C14039q qVar = this.f42417n;
        if (qVar != null) {
            return qVar;
        }
        throw new UnsupportedOperationException("RxJava seems to be missing from the classpath. Remember to add it as a compile dependency. See https://realm.io/docs/java/latest/#rxjava for more details.");
    }

    /* renamed from: o */
    public boolean mo43575o() {
        return this.f42419p;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C14001L that = (C14001L) obj;
        if (this.f42412i != that.f42412i || this.f42414k != that.f42414k || !this.f42407d.equals(that.f42407d) || !this.f42408e.equals(that.f42408e) || !this.f42409f.equals(that.f42409f) || !Arrays.equals(this.f42411h, that.f42411h) || !this.f42415l.equals(that.f42415l)) {
            return false;
        }
        C14020X x = this.f42413j;
        if (x == null ? that.f42413j != null : !x.equals(that.f42413j)) {
            return false;
        }
        C14039q qVar = this.f42417n;
        if (qVar == null ? that.f42417n != null : !qVar.equals(that.f42417n)) {
            return false;
        }
        C13991a aVar = this.f42418o;
        if (aVar == null ? that.f42418o != null : !aVar.equals(that.f42418o)) {
            return false;
        }
        if (this.f42419p != that.f42419p) {
            return false;
        }
        CompactOnLaunchCallback compactOnLaunchCallback = this.f42420q;
        if (compactOnLaunchCallback == null ? that.f42420q == null : compactOnLaunchCallback.equals(that.f42420q)) {
            return this.f42416m.equals(that.f42416m);
        }
        return false;
    }

    public int hashCode() {
        int result = ((((this.f42407d.hashCode() * 31) + this.f42408e.hashCode()) * 31) + this.f42409f.hashCode()) * 31;
        byte[] bArr = this.f42411h;
        int i = 0;
        int result2 = (((result + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31) + ((int) this.f42412i)) * 31;
        C14020X x = this.f42413j;
        int result3 = (((((((result2 + (x != null ? x.hashCode() : 0)) * 31) + (this.f42414k ? 1 : 0)) * 31) + this.f42416m.hashCode()) * 31) + this.f42415l.hashCode()) * 31;
        C14039q qVar = this.f42417n;
        int result4 = (result3 + (qVar != null ? qVar.hashCode() : 0)) * 31;
        C13991a aVar = this.f42418o;
        int result5 = (((result4 + (aVar != null ? aVar.hashCode() : 0)) * 31) + (this.f42419p ? 1 : 0)) * 31;
        CompactOnLaunchCallback compactOnLaunchCallback = this.f42420q;
        if (compactOnLaunchCallback != null) {
            i = compactOnLaunchCallback.hashCode();
        }
        return result5 + i;
    }

    /* renamed from: a */
    protected static C7346q m44585a(Set<Object> modules, Set<Class<? extends C0105Y>> debugSchema) {
        if (debugSchema.size() > 0) {
            return new C7326b(f42405b, debugSchema);
        }
        if (modules.size() == 1) {
            return m44584a(modules.iterator().next().getClass().getCanonicalName());
        }
        C7346q[] mediators = new C7346q[modules.size()];
        int i = 0;
        for (Object module : modules) {
            mediators[i] = m44584a(module.getClass().getCanonicalName());
            i++;
        }
        return new C7325a(mediators);
    }

    /* renamed from: a */
    private static C7346q m44584a(String fullyQualifiedModuleClassName) {
        String str = "Could not create an instance of ";
        String[] moduleNameParts = fullyQualifiedModuleClassName.split("\\.");
        String moduleSimpleName = moduleNameParts[moduleNameParts.length - 1];
        String mediatorName = String.format(Locale.US, "io.realm.%s%s", new Object[]{moduleSimpleName, "Mediator"});
        try {
            Constructor<?> constructor = Class.forName(mediatorName).getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return (C7346q) constructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not find ");
            sb.append(mediatorName);
            throw new RealmException(sb.toString(), e);
        } catch (InvocationTargetException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(mediatorName);
            throw new RealmException(sb2.toString(), e2);
        } catch (InstantiationException e3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(mediatorName);
            throw new RealmException(sb3.toString(), e3);
        } catch (IllegalAccessException e4) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(mediatorName);
            throw new RealmException(sb4.toString(), e4);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("realmDirectory: ");
        stringBuilder.append(this.f42407d.toString());
        String str = "\n";
        stringBuilder.append(str);
        stringBuilder.append("realmFileName : ");
        stringBuilder.append(this.f42408e);
        stringBuilder.append(str);
        stringBuilder.append("canonicalPath: ");
        stringBuilder.append(this.f42409f);
        stringBuilder.append(str);
        stringBuilder.append("key: ");
        stringBuilder.append("[length: ");
        stringBuilder.append(this.f42411h == null ? 0 : 64);
        stringBuilder.append("]");
        stringBuilder.append(str);
        stringBuilder.append("schemaVersion: ");
        stringBuilder.append(Long.toString(this.f42412i));
        stringBuilder.append(str);
        stringBuilder.append("migration: ");
        stringBuilder.append(this.f42413j);
        stringBuilder.append(str);
        stringBuilder.append("deleteRealmIfMigrationNeeded: ");
        stringBuilder.append(this.f42414k);
        stringBuilder.append(str);
        stringBuilder.append("durability: ");
        stringBuilder.append(this.f42415l);
        stringBuilder.append(str);
        stringBuilder.append("schemaMediator: ");
        stringBuilder.append(this.f42416m);
        stringBuilder.append(str);
        stringBuilder.append("readOnly: ");
        stringBuilder.append(this.f42419p);
        stringBuilder.append(str);
        stringBuilder.append("compactOnLaunch: ");
        stringBuilder.append(this.f42420q);
        return stringBuilder.toString();
    }

    /* renamed from: p */
    static synchronized boolean m44588p() {
        boolean booleanValue;
        synchronized (C14001L.class) {
            if (f42406c == null) {
                try {
                    Class.forName("rx.S");
                    f42406c = Boolean.valueOf(true);
                } catch (ClassNotFoundException e) {
                    f42406c = Boolean.valueOf(false);
                }
            }
            booleanValue = f42406c.booleanValue();
        }
        return booleanValue;
    }

    /* renamed from: a */
    protected static String m44587a(File realmFile) {
        try {
            return realmFile.getCanonicalPath();
        } catch (IOException e) {
            Kind kind = Kind.ACCESS_ERROR;
            StringBuilder sb = new StringBuilder();
            sb.append("Could not resolve the canonical path to the Realm file: ");
            sb.append(realmFile.getAbsolutePath());
            throw new RealmFileException(kind, sb.toString(), e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public boolean mo43576q() {
        return false;
    }
}
