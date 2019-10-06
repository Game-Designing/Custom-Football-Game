package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@KeepForSdk
public final class DynamiteModule {

    /* renamed from: a */
    private static Boolean f20344a;

    /* renamed from: b */
    private static zzi f20345b;

    /* renamed from: c */
    private static zzk f20346c;

    /* renamed from: d */
    private static String f20347d;

    /* renamed from: e */
    private static int f20348e = -1;

    /* renamed from: f */
    private static final ThreadLocal<C8728a> f20349f = new ThreadLocal<>();

    /* renamed from: g */
    private static final zza f20350g = new C8730a();
    @KeepForSdk

    /* renamed from: h */
    public static final VersionPolicy f20351h = new C8731b();
    @KeepForSdk

    /* renamed from: i */
    public static final VersionPolicy f20352i = new C8732c();
    @KeepForSdk

    /* renamed from: j */
    public static final VersionPolicy f20353j = new C8733d();
    @KeepForSdk

    /* renamed from: k */
    public static final VersionPolicy f20354k = new C8734e();
    @KeepForSdk

    /* renamed from: l */
    public static final VersionPolicy f20355l = new C8735f();

    /* renamed from: m */
    private static final VersionPolicy f20356m = new C8736g();

    /* renamed from: n */
    private final Context f20357n;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    @KeepForSdk
    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, C8730a aVar) {
            this(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, C8730a aVar) {
            this(str, th);
        }
    }

    public interface VersionPolicy {

        public interface zza {
            /* renamed from: a */
            int mo27986a(Context context, String str);

            /* renamed from: a */
            int mo27987a(Context context, String str, boolean z) throws LoadingException;
        }

        public static class zzb {

            /* renamed from: a */
            public int f20358a = 0;

            /* renamed from: b */
            public int f20359b = 0;

            /* renamed from: c */
            public int f20360c = 0;
        }

        /* renamed from: a */
        zzb mo27985a(Context context, String str, zza zza2) throws LoadingException;
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule$a */
    private static class C8728a {

        /* renamed from: a */
        public Cursor f20361a;

        private C8728a() {
        }

        /* synthetic */ C8728a(C8730a aVar) {
            this();
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule$b */
    private static class C8729b implements zza {

        /* renamed from: a */
        private final int f20362a;

        /* renamed from: b */
        private final int f20363b = 0;

        public C8729b(int i, int i2) {
            this.f20362a = i;
        }

        /* renamed from: a */
        public final int mo27987a(Context context, String str, boolean z) {
            return 0;
        }

        /* renamed from: a */
        public final int mo27986a(Context context, String str) {
            return this.f20362a;
        }
    }

    @KeepForSdk
    /* renamed from: a */
    public static DynamiteModule m22215a(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        zzb a;
        String str2 = ":";
        String str3 = "DynamiteModule";
        C8728a aVar = (C8728a) f20349f.get();
        C8728a aVar2 = new C8728a(null);
        f20349f.set(aVar2);
        try {
            a = versionPolicy.mo27985a(context, str, f20350g);
            int i = a.f20358a;
            int i2 = a.f20359b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(str2);
            sb.append(i);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(str2);
            sb.append(i2);
            Log.i(str3, sb.toString());
            if (a.f20360c == 0 || ((a.f20360c == -1 && a.f20358a == 0) || (a.f20360c == 1 && a.f20359b == 0))) {
                int i3 = a.f20358a;
                int i4 = a.f20359b;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i3);
                sb2.append(" and remote version is ");
                sb2.append(i4);
                sb2.append(".");
                throw new LoadingException(sb2.toString(), (C8730a) null);
            } else if (a.f20360c == -1) {
                DynamiteModule c = m22224c(context, str);
                Cursor cursor = aVar2.f20361a;
                if (cursor != null) {
                    cursor.close();
                }
                f20349f.set(aVar);
                return c;
            } else if (a.f20360c == 1) {
                DynamiteModule a2 = m22216a(context, str, a.f20359b);
                Cursor cursor2 = aVar2.f20361a;
                if (cursor2 != null) {
                    cursor2.close();
                }
                f20349f.set(aVar);
                return a2;
            } else {
                int i5 = a.f20360c;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i5);
                throw new LoadingException(sb3.toString(), (C8730a) null);
            }
        } catch (LoadingException e) {
            String str4 = "Failed to load remote module: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
            if (a.f20358a == 0 || versionPolicy.mo27985a(context, str, new C8729b(a.f20358a, 0)).f20360c != -1) {
                throw new LoadingException("Remote load failed. No local fallback found.", e, null);
            }
            DynamiteModule c2 = m22224c(context, str);
            Cursor cursor3 = aVar2.f20361a;
            if (cursor3 != null) {
                cursor3.close();
            }
            f20349f.set(aVar);
            return c2;
        } catch (Throwable th) {
            Cursor cursor4 = aVar2.f20361a;
            if (cursor4 != null) {
                cursor4.close();
            }
            f20349f.set(aVar);
            throw th;
        }
    }

    @KeepForSdk
    /* renamed from: a */
    public static int m22213a(Context context, String str) {
        String str2 = "DynamiteModule";
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            String valueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e(str2, sb2.toString());
            return 0;
        } catch (ClassNotFoundException e) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w(str2, sb3.toString());
            return 0;
        } catch (Exception e2) {
            String str3 = "Failed to load module descriptor class: ";
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e(str2, valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c5 A[SYNTHETIC, Splitter:B:59:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ec A[Catch:{ LoadingException -> 0x00ca, Throwable -> 0x00f4 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0037=Splitter:B:19:0x0037, B:36:0x007e=Splitter:B:36:0x007e} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m22214a(android.content.Context r8, java.lang.String r9, boolean r10) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ Throwable -> 0x00f4 }
            java.lang.Boolean r1 = f20344a     // Catch:{ all -> 0x00f1 }
            if (r1 != 0) goto L_0x00be
            android.content.Context r1 = r8.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x0095, IllegalAccessException -> 0x0093, NoSuchFieldException -> 0x0091 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0095, IllegalAccessException -> 0x0093, NoSuchFieldException -> 0x0091 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r2 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r2 = r2.getName()     // Catch:{ ClassNotFoundException -> 0x0095, IllegalAccessException -> 0x0093, NoSuchFieldException -> 0x0091 }
            java.lang.Class r1 = r1.loadClass(r2)     // Catch:{ ClassNotFoundException -> 0x0095, IllegalAccessException -> 0x0093, NoSuchFieldException -> 0x0091 }
            java.lang.String r2 = "sClassLoader"
            java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch:{ ClassNotFoundException -> 0x0095, IllegalAccessException -> 0x0093, NoSuchFieldException -> 0x0091 }
            monitor-enter(r1)     // Catch:{ ClassNotFoundException -> 0x0095, IllegalAccessException -> 0x0093, NoSuchFieldException -> 0x0091 }
            r3 = 0
            java.lang.Object r4 = r2.get(r3)     // Catch:{ all -> 0x008e }
            java.lang.ClassLoader r4 = (java.lang.ClassLoader) r4     // Catch:{ all -> 0x008e }
            if (r4 == 0) goto L_0x003a
            java.lang.ClassLoader r2 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x008e }
            if (r4 != r2) goto L_0x0032
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x008e }
            goto L_0x008b
        L_0x0032:
            m22218a(r4)     // Catch:{ LoadingException -> 0x0036 }
            goto L_0x0037
        L_0x0036:
            r2 = move-exception
        L_0x0037:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x008e }
            goto L_0x008b
        L_0x003a:
            java.lang.String r4 = "com.google.android.gms"
            android.content.Context r5 = r8.getApplicationContext()     // Catch:{ all -> 0x008e }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x008e }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x008e }
            if (r4 == 0) goto L_0x0054
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x008e }
            r2.set(r3, r4)     // Catch:{ all -> 0x008e }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x008e }
            goto L_0x008b
        L_0x0054:
            int r4 = m22223c(r8, r9, r10)     // Catch:{ LoadingException -> 0x0081 }
            java.lang.String r5 = f20347d     // Catch:{ LoadingException -> 0x0081 }
            if (r5 == 0) goto L_0x007e
            java.lang.String r5 = f20347d     // Catch:{ LoadingException -> 0x0081 }
            boolean r5 = r5.isEmpty()     // Catch:{ LoadingException -> 0x0081 }
            if (r5 == 0) goto L_0x0065
            goto L_0x007e
        L_0x0065:
            com.google.android.gms.dynamite.h r5 = new com.google.android.gms.dynamite.h     // Catch:{ LoadingException -> 0x0081 }
            java.lang.String r6 = f20347d     // Catch:{ LoadingException -> 0x0081 }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x0081 }
            r5.<init>(r6, r7)     // Catch:{ LoadingException -> 0x0081 }
            m22218a(r5)     // Catch:{ LoadingException -> 0x0081 }
            r2.set(r3, r5)     // Catch:{ LoadingException -> 0x0081 }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ LoadingException -> 0x0081 }
            f20344a = r5     // Catch:{ LoadingException -> 0x0081 }
            monitor-exit(r1)     // Catch:{ all -> 0x008e }
            monitor-exit(r0)     // Catch:{ all -> 0x00f1 }
            return r4
        L_0x007e:
            monitor-exit(r1)     // Catch:{ all -> 0x008e }
            monitor-exit(r0)     // Catch:{ all -> 0x00f1 }
            return r4
        L_0x0081:
            r4 = move-exception
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x008e }
            r2.set(r3, r4)     // Catch:{ all -> 0x008e }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x008e }
        L_0x008b:
            monitor-exit(r1)     // Catch:{ all -> 0x008e }
            r1 = r2
            goto L_0x00bc
        L_0x008e:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008e }
            throw r2     // Catch:{ ClassNotFoundException -> 0x0095, IllegalAccessException -> 0x0093, NoSuchFieldException -> 0x0091 }
        L_0x0091:
            r1 = move-exception
            goto L_0x0096
        L_0x0093:
            r1 = move-exception
            goto L_0x0096
        L_0x0095:
            r1 = move-exception
        L_0x0096:
            java.lang.String r2 = "DynamiteModule"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00f1 }
            java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00f1 }
            int r3 = r3.length()     // Catch:{ all -> 0x00f1 }
            int r3 = r3 + 30
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
            r4.<init>(r3)     // Catch:{ all -> 0x00f1 }
            java.lang.String r3 = "Failed to load module via V2: "
            r4.append(r3)     // Catch:{ all -> 0x00f1 }
            r4.append(r1)     // Catch:{ all -> 0x00f1 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00f1 }
            android.util.Log.w(r2, r1)     // Catch:{ all -> 0x00f1 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00f1 }
        L_0x00bc:
            f20344a = r1     // Catch:{ all -> 0x00f1 }
        L_0x00be:
            monitor-exit(r0)     // Catch:{ all -> 0x00f1 }
            boolean r0 = r1.booleanValue()     // Catch:{ Throwable -> 0x00f4 }
            if (r0 == 0) goto L_0x00ec
            int r8 = m22223c(r8, r9, r10)     // Catch:{ LoadingException -> 0x00ca }
            return r8
        L_0x00ca:
            r9 = move-exception
            java.lang.String r10 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version: "
            java.lang.String r9 = r9.getMessage()     // Catch:{ Throwable -> 0x00f4 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Throwable -> 0x00f4 }
            int r1 = r9.length()     // Catch:{ Throwable -> 0x00f4 }
            if (r1 == 0) goto L_0x00e2
            java.lang.String r9 = r0.concat(r9)     // Catch:{ Throwable -> 0x00f4 }
            goto L_0x00e7
        L_0x00e2:
            java.lang.String r9 = new java.lang.String     // Catch:{ Throwable -> 0x00f4 }
            r9.<init>(r0)     // Catch:{ Throwable -> 0x00f4 }
        L_0x00e7:
            android.util.Log.w(r10, r9)     // Catch:{ Throwable -> 0x00f4 }
            r8 = 0
            return r8
        L_0x00ec:
            int r8 = m22220b(r8, r9, r10)     // Catch:{ Throwable -> 0x00f4 }
            return r8
        L_0x00f1:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00f1 }
            throw r9     // Catch:{ Throwable -> 0x00f4 }
        L_0x00f4:
            r9 = move-exception
            com.google.android.gms.common.util.CrashUtils.m22085a(r8, r9)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.m22214a(android.content.Context, java.lang.String, boolean):int");
    }

    /* renamed from: b */
    private static int m22220b(Context context, String str, boolean z) {
        String str2 = "DynamiteModule";
        zzi a = m22217a(context);
        if (a == null) {
            return 0;
        }
        try {
            if (a.mo27993ta() >= 2) {
                return a.mo27989a(ObjectWrapper.m22188a(context), str, z);
            }
            Log.w(str2, "IDynamite loader version < 2, falling back to getModuleVersion2");
            return a.mo27991b(ObjectWrapper.m22188a(context), str, z);
        } catch (RemoteException e) {
            String str3 = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b8  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m22223c(android.content.Context r8, java.lang.String r9, boolean r10) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            if (r10 == 0) goto L_0x000d
            java.lang.String r8 = "api_force_staging"
            goto L_0x000f
        L_0x000d:
            java.lang.String r8 = "api"
        L_0x000f:
            java.lang.String r10 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            int r10 = r10.length()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            int r2 = r2.length()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r2.<init>(r10)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r2.append(r8)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r2.append(r9)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.lang.String r8 = r2.toString()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            if (r8 == 0) goto L_0x008b
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            if (r9 == 0) goto L_0x008b
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            if (r9 <= 0) goto L_0x0085
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch:{ all -> 0x0082 }
            f20347d = r1     // Catch:{ all -> 0x0082 }
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch:{ all -> 0x0082 }
            if (r1 < 0) goto L_0x006f
            int r1 = r8.getInt(r1)     // Catch:{ all -> 0x0082 }
            f20348e = r1     // Catch:{ all -> 0x0082 }
        L_0x006f:
            monitor-exit(r10)     // Catch:{ all -> 0x0082 }
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$a> r10 = f20349f     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            java.lang.Object r10 = r10.get()     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            com.google.android.gms.dynamite.DynamiteModule$a r10 = (com.google.android.gms.dynamite.DynamiteModule.C8728a) r10     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            if (r10 == 0) goto L_0x0085
            android.database.Cursor r1 = r10.f20361a     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            if (r1 != 0) goto L_0x0085
            r10.f20361a = r8     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            r8 = r0
            goto L_0x0085
        L_0x0082:
            r9 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0082 }
            throw r9     // Catch:{ Exception -> 0x009e, all -> 0x009a }
        L_0x0085:
            if (r8 == 0) goto L_0x008a
            r8.close()
        L_0x008a:
            return r9
        L_0x008b:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r9 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            throw r9     // Catch:{ Exception -> 0x009e, all -> 0x009a }
        L_0x009a:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto L_0x00b6
        L_0x009e:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x00a7
        L_0x00a3:
            r8 = move-exception
            goto L_0x00b6
        L_0x00a5:
            r8 = move-exception
            r9 = r0
        L_0x00a7:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00b4 }
            if (r10 == 0) goto L_0x00ac
            throw r8     // Catch:{ all -> 0x00b4 }
        L_0x00ac:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00b4 }
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch:{ all -> 0x00b4 }
            throw r10     // Catch:{ all -> 0x00b4 }
        L_0x00b4:
            r8 = move-exception
            r0 = r9
        L_0x00b6:
            if (r0 == 0) goto L_0x00bb
            r0.close()
        L_0x00bb:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.m22223c(android.content.Context, java.lang.String, boolean):int");
    }

    @KeepForSdk
    /* renamed from: b */
    public static int m22219b(Context context, String str) {
        return m22214a(context, str, false);
    }

    /* renamed from: c */
    private static DynamiteModule m22224c(Context context, String str) {
        String valueOf = String.valueOf(str);
        String str2 = "Selected local version of ";
        Log.i("DynamiteModule", valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        return new DynamiteModule(context.getApplicationContext());
    }

    /* renamed from: a */
    private static DynamiteModule m22216a(Context context, String str, int i) throws LoadingException {
        Boolean bool;
        IObjectWrapper iObjectWrapper;
        try {
            synchronized (DynamiteModule.class) {
                bool = f20344a;
            }
            if (bool == null) {
                throw new LoadingException("Failed to determine which loading route to use.", (C8730a) null);
            } else if (bool.booleanValue()) {
                return m22221b(context, str, i);
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i);
                Log.i("DynamiteModule", sb.toString());
                zzi a = m22217a(context);
                if (a != null) {
                    if (a.mo27993ta() >= 2) {
                        iObjectWrapper = a.mo27992b(ObjectWrapper.m22188a(context), str, i);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        iObjectWrapper = a.mo27990a(ObjectWrapper.m22188a(context), str, i);
                    }
                    if (ObjectWrapper.m22187H(iObjectWrapper) != null) {
                        return new DynamiteModule((Context) ObjectWrapper.m22187H(iObjectWrapper));
                    }
                    throw new LoadingException("Failed to load remote module.", (C8730a) null);
                }
                throw new LoadingException("Failed to create IDynamiteLoader.", (C8730a) null);
            }
        } catch (RemoteException e) {
            throw new LoadingException("Failed to load remote module.", e, null);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Throwable th) {
            CrashUtils.m22085a(context, th);
            throw new LoadingException("Failed to load remote module.", th, null);
        }
    }

    /* renamed from: a */
    private static zzi m22217a(Context context) {
        zzi zzi;
        synchronized (DynamiteModule.class) {
            if (f20345b != null) {
                zzi zzi2 = f20345b;
                return zzi2;
            } else if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            } else {
                try {
                    IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                    if (iBinder == null) {
                        zzi = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                        if (queryLocalInterface instanceof zzi) {
                            zzi = (zzi) queryLocalInterface;
                        } else {
                            zzi = new zzj(iBinder);
                        }
                    }
                    if (zzi != null) {
                        f20345b = zzi;
                        return zzi;
                    }
                } catch (Exception e) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            }
        }
        return null;
    }

    @KeepForSdk
    /* renamed from: a */
    public final Context mo27983a() {
        return this.f20357n;
    }

    /* renamed from: b */
    private static DynamiteModule m22221b(Context context, String str, int i) throws LoadingException, RemoteException {
        zzk zzk;
        IObjectWrapper iObjectWrapper;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            zzk = f20346c;
        }
        if (zzk != null) {
            C8728a aVar = (C8728a) f20349f.get();
            if (aVar == null || aVar.f20361a == null) {
                throw new LoadingException("No result cursor", (C8730a) null);
            }
            Context applicationContext = context.getApplicationContext();
            Cursor cursor = aVar.f20361a;
            ObjectWrapper.m22188a(null);
            if (m22222b().booleanValue()) {
                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                iObjectWrapper = zzk.mo27995b(ObjectWrapper.m22188a(applicationContext), str, i, ObjectWrapper.m22188a(cursor));
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                iObjectWrapper = zzk.mo27994a(ObjectWrapper.m22188a(applicationContext), str, i, ObjectWrapper.m22188a(cursor));
            }
            Context context2 = (Context) ObjectWrapper.m22187H(iObjectWrapper);
            if (context2 != null) {
                return new DynamiteModule(context2);
            }
            throw new LoadingException("Failed to get module context", (C8730a) null);
        }
        throw new LoadingException("DynamiteLoaderV2 was not cached.", (C8730a) null);
    }

    /* renamed from: b */
    private static Boolean m22222b() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(f20348e >= 2);
        }
        return valueOf;
    }

    /* renamed from: a */
    private static void m22218a(ClassLoader classLoader) throws LoadingException {
        zzk zzk;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzk = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzk) {
                    zzk = (zzk) queryLocalInterface;
                } else {
                    zzk = new zzl(iBinder);
                }
            }
            f20346c = zzk;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, null);
        }
    }

    @KeepForSdk
    /* renamed from: a */
    public final IBinder mo27984a(String str) throws LoadingException {
        try {
            return (IBinder) this.f20357n.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String str2 = "Failed to instantiate module class: ";
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e, null);
        }
    }

    private DynamiteModule(Context context) {
        Preconditions.m21857a(context);
        this.f20357n = context;
    }
}
