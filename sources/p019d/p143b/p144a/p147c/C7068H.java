package p019d.p143b.p144a.p147c;

import android.content.Context;
import android.net.Uri;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.H */
public class C7068H {

    /* renamed from: a */
    private final String f13220a = "FileManager";

    /* renamed from: b */
    private final C7142c f13221b;

    /* renamed from: c */
    private final C7262l f13222c;

    /* renamed from: d */
    private final Object f13223d;

    C7068H(C7267q qVar) {
        this.f13221b = (C7142c) qVar;
        this.f13222c = qVar.mo23049b();
        this.f13223d = new Object();
    }

    /* renamed from: a */
    private long m14711a(long j) {
        return j / 1048576;
    }

    /* renamed from: a */
    private void m14712a(long j, Context context) {
        C7262l lVar;
        String str;
        long c = (long) m14717c();
        String str2 = "FileManager";
        if (c == -1) {
            lVar = this.f13222c;
            str = "Cache has no maximum size set; skipping drop...";
        } else if (m14711a(j) > c) {
            this.f13222c.mo22918c(str2, "Cache has exceeded maximum size; dropping...");
            m14720g(context);
            this.f13221b.mo23061f().mo22861a("cache_drop_count");
            return;
        } else {
            lVar = this.f13222c;
            str = "Cache is present but under size limit; not dropping...";
        }
        lVar.mo22918c(str2, str);
    }

    /* renamed from: a */
    private boolean m14713a() {
        return ((Boolean) this.f13221b.mo23039a(C7196pb.f13784_a)).booleanValue();
    }

    /* renamed from: b */
    private long m14714b() {
        long longValue = ((Long) this.f13221b.mo23039a(C7196pb.f13789ab)).longValue();
        if (longValue < 0 || !m14713a()) {
            return -1;
        }
        return longValue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        if (r1 != null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r1 != null) goto L_0x0046;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005e A[SYNTHETIC, Splitter:B:34:0x005e] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x003b=Splitter:B:19:0x003b, B:26:0x004d=Splitter:B:26:0x004d} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:38:0x0065=Splitter:B:38:0x0065, B:30:0x005a=Splitter:B:30:0x005a} */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m14715b(java.io.ByteArrayOutputStream r5, java.io.File r6) {
        /*
            r4 = this;
            d.b.d.l r0 = r4.f13222c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Writing resource to filesystem: "
            r1.append(r2)
            java.lang.String r2 = r6.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "FileManager"
            r0.mo22918c(r2, r1)
            java.lang.Object r0 = r4.f13223d
            monitor-enter(r0)
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x004c, Throwable -> 0x003a }
            r2.<init>(r6)     // Catch:{ IOException -> 0x004c, Throwable -> 0x003a }
            r5.writeTo(r2)     // Catch:{ IOException -> 0x0035, Throwable -> 0x0032, all -> 0x002f }
            r5 = 1
            r2.close()     // Catch:{ Exception -> 0x002d }
            goto L_0x005a
        L_0x002d:
            r6 = move-exception
            goto L_0x005a
        L_0x002f:
            r5 = move-exception
            r1 = r2
            goto L_0x005c
        L_0x0032:
            r5 = move-exception
            r1 = r2
            goto L_0x003b
        L_0x0035:
            r5 = move-exception
            r1 = r2
            goto L_0x004d
        L_0x0038:
            r5 = move-exception
            goto L_0x005c
        L_0x003a:
            r5 = move-exception
        L_0x003b:
            d.b.d.l r6 = r4.f13222c     // Catch:{ all -> 0x0038 }
            java.lang.String r2 = "FileManager"
            java.lang.String r3 = "Unknown failure to write file."
            r6.mo22917b(r2, r3, r5)     // Catch:{ all -> 0x0038 }
            if (r1 == 0) goto L_0x0059
        L_0x0046:
            r1.close()     // Catch:{ Exception -> 0x004a }
            goto L_0x0059
        L_0x004a:
            r5 = move-exception
            goto L_0x0059
        L_0x004c:
            r5 = move-exception
        L_0x004d:
            d.b.d.l r6 = r4.f13222c     // Catch:{ all -> 0x0038 }
            java.lang.String r2 = "FileManager"
            java.lang.String r3 = "Unable to write data to file."
            r6.mo22917b(r2, r3, r5)     // Catch:{ all -> 0x0038 }
            if (r1 == 0) goto L_0x0059
            goto L_0x0046
        L_0x0059:
            r5 = 0
        L_0x005a:
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            return r5
        L_0x005c:
            if (r1 == 0) goto L_0x0065
            r1.close()     // Catch:{ Exception -> 0x0064 }
            goto L_0x0065
        L_0x0062:
            r5 = move-exception
            goto L_0x0066
        L_0x0064:
            r6 = move-exception
        L_0x0065:
            throw r5     // Catch:{ all -> 0x0062 }
        L_0x0066:
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            goto L_0x0069
        L_0x0068:
            throw r5
        L_0x0069:
            goto L_0x0068
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p147c.C7068H.m14715b(java.io.ByteArrayOutputStream, java.io.File):boolean");
    }

    /* renamed from: b */
    private boolean m14716b(File file) {
        boolean delete;
        C7262l lVar = this.f13222c;
        StringBuilder sb = new StringBuilder();
        sb.append("Removing file ");
        sb.append(file.getName());
        sb.append(" from filesystem...");
        lVar.mo22918c("FileManager", sb.toString());
        synchronized (this.f13223d) {
            try {
                delete = file.delete();
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to remove file ");
                sb2.append(file.getName());
                sb2.append(" from filesystem!");
                this.f13222c.mo22917b("FileManager", sb2.toString(), e);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return delete;
    }

    /* renamed from: c */
    private int m14717c() {
        int intValue = ((Integer) this.f13221b.mo23039a(C7196pb.f13794bb)).intValue();
        if (intValue < 0 || !m14713a()) {
            return -1;
        }
        return intValue;
    }

    /* renamed from: e */
    private File m14718e(Context context) {
        String str = "al";
        return mo22829a(context) ? new File(context.getExternalFilesDir(null), str) : new File(context.getCacheDir(), str);
    }

    /* renamed from: f */
    private long m14719f(Context context) {
        long j;
        boolean z;
        long b = m14714b();
        boolean z2 = b != -1;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        synchronized (this.f13223d) {
            j = 0;
            for (File file : mo22834b(context)) {
                if (!z2 || seconds - TimeUnit.MILLISECONDS.toSeconds(file.lastModified()) <= b) {
                    z = false;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("File ");
                    sb.append(file.getName());
                    sb.append(" has expired, removing...");
                    this.f13222c.mo22918c("FileManager", sb.toString());
                    m14716b(file);
                    z = true;
                }
                if (z) {
                    this.f13221b.mo23061f().mo22861a("cached_files_expired");
                } else {
                    j += file.length();
                }
            }
        }
        return j;
    }

    /* renamed from: g */
    private void m14720g(Context context) {
        synchronized (this.f13223d) {
            for (File b : mo22834b(context)) {
                m14716b(b);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0051, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0053, code lost:
        r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0055, code lost:
        r9 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0051 A[ExcHandler: Throwable (th java.lang.Throwable), Splitter:B:7:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0067 A[SYNTHETIC, Splitter:B:39:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0091 A[SYNTHETIC, Splitter:B:50:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b4 A[SYNTHETIC, Splitter:B:61:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00be A[SYNTHETIC, Splitter:B:69:0x00be] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:47:0x0070=Splitter:B:47:0x0070, B:58:0x009a=Splitter:B:58:0x009a, B:36:0x005c=Splitter:B:36:0x005c} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:73:0x00c5=Splitter:B:73:0x00c5, B:53:0x0096=Splitter:B:53:0x0096, B:20:0x0048=Splitter:B:20:0x0048, B:64:0x00b9=Splitter:B:64:0x00b9, B:42:0x006c=Splitter:B:42:0x006c, B:26:0x004f=Splitter:B:26:0x004f} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.ByteArrayOutputStream mo22824a(java.io.File r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            d.b.d.l r1 = r8.f13222c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Reading resource from filesystem: "
            r2.append(r3)
            java.lang.String r3 = r9.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "FileManager"
            r1.mo22918c(r3, r2)
            java.lang.Object r1 = r8.f13223d
            monitor-enter(r1)
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x006e, Throwable -> 0x005a, all -> 0x0057 }
            r2.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x006e, Throwable -> 0x005a, all -> 0x0057 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x0055, IOException -> 0x0053, Throwable -> 0x0051 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0055, IOException -> 0x0053, Throwable -> 0x0051 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x0055, IOException -> 0x0053, Throwable -> 0x0051 }
        L_0x0031:
            int r5 = r4.length     // Catch:{ FileNotFoundException -> 0x0055, IOException -> 0x0053, Throwable -> 0x0051 }
            r6 = 0
            int r5 = r2.read(r4, r6, r5)     // Catch:{ FileNotFoundException -> 0x0055, IOException -> 0x0053, Throwable -> 0x0051 }
            if (r5 < 0) goto L_0x004a
            r3.write(r4, r6, r5)     // Catch:{ Exception -> 0x003d, Throwable -> 0x0051 }
            goto L_0x0031
        L_0x003d:
            r9 = move-exception
            r3.close()     // Catch:{ Exception -> 0x0042, Throwable -> 0x0051 }
            goto L_0x0043
        L_0x0042:
            r9 = move-exception
        L_0x0043:
            r2.close()     // Catch:{ Exception -> 0x0047 }
            goto L_0x0048
        L_0x0047:
            r9 = move-exception
        L_0x0048:
            monitor-exit(r1)     // Catch:{ all -> 0x00c2 }
            return r0
        L_0x004a:
            r2.close()     // Catch:{ Exception -> 0x004e }
            goto L_0x004f
        L_0x004e:
            r9 = move-exception
        L_0x004f:
            monitor-exit(r1)     // Catch:{ all -> 0x00c2 }
            return r3
        L_0x0051:
            r9 = move-exception
            goto L_0x005c
        L_0x0053:
            r3 = move-exception
            goto L_0x0070
        L_0x0055:
            r9 = move-exception
            goto L_0x009a
        L_0x0057:
            r9 = move-exception
            r2 = r0
            goto L_0x00bc
        L_0x005a:
            r9 = move-exception
            r2 = r0
        L_0x005c:
            d.b.d.l r3 = r8.f13222c     // Catch:{ all -> 0x00bb }
            java.lang.String r4 = "FileManager"
            java.lang.String r5 = "Unknown failure to read file."
            r3.mo22917b(r4, r5, r9)     // Catch:{ all -> 0x00bb }
            if (r2 == 0) goto L_0x006c
            r2.close()     // Catch:{ Exception -> 0x006b }
            goto L_0x006c
        L_0x006b:
            r9 = move-exception
        L_0x006c:
            monitor-exit(r1)     // Catch:{ all -> 0x00c2 }
            return r0
        L_0x006e:
            r3 = move-exception
            r2 = r0
        L_0x0070:
            d.b.d.l r4 = r8.f13222c     // Catch:{ all -> 0x00bb }
            java.lang.String r5 = "FileManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bb }
            r6.<init>()     // Catch:{ all -> 0x00bb }
            java.lang.String r7 = "Failed to read file: "
            r6.append(r7)     // Catch:{ all -> 0x00bb }
            java.lang.String r9 = r9.getName()     // Catch:{ all -> 0x00bb }
            r6.append(r9)     // Catch:{ all -> 0x00bb }
            r6.append(r3)     // Catch:{ all -> 0x00bb }
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x00bb }
            r4.mo22918c(r5, r9)     // Catch:{ all -> 0x00bb }
            if (r2 == 0) goto L_0x0096
            r2.close()     // Catch:{ Exception -> 0x0095 }
            goto L_0x0096
        L_0x0095:
            r9 = move-exception
        L_0x0096:
            monitor-exit(r1)     // Catch:{ all -> 0x00c2 }
            return r0
        L_0x0098:
            r9 = move-exception
            r2 = r0
        L_0x009a:
            d.b.d.l r3 = r8.f13222c     // Catch:{ all -> 0x00bb }
            java.lang.String r4 = "FileManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bb }
            r5.<init>()     // Catch:{ all -> 0x00bb }
            java.lang.String r6 = "File not found. "
            r5.append(r6)     // Catch:{ all -> 0x00bb }
            r5.append(r9)     // Catch:{ all -> 0x00bb }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x00bb }
            r3.mo22920d(r4, r9)     // Catch:{ all -> 0x00bb }
            if (r2 == 0) goto L_0x00b9
            r2.close()     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00b9
        L_0x00b8:
            r9 = move-exception
        L_0x00b9:
            monitor-exit(r1)     // Catch:{ all -> 0x00c2 }
            return r0
        L_0x00bb:
            r9 = move-exception
        L_0x00bc:
            if (r2 == 0) goto L_0x00c5
            r2.close()     // Catch:{ Exception -> 0x00c4 }
            goto L_0x00c5
        L_0x00c2:
            r9 = move-exception
            goto L_0x00c6
        L_0x00c4:
            r0 = move-exception
        L_0x00c5:
            throw r9     // Catch:{ all -> 0x00c2 }
        L_0x00c6:
            monitor-exit(r1)     // Catch:{ all -> 0x00c2 }
            goto L_0x00c9
        L_0x00c8:
            throw r9
        L_0x00c9:
            goto L_0x00c8
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p147c.C7068H.mo22824a(java.io.File):java.io.ByteArrayOutputStream");
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r10v4, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r10v5, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r10v8 */
    /* JADX WARNING: type inference failed for: r10v10 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r10v19 */
    /* JADX WARNING: type inference failed for: r10v20 */
    /* JADX WARNING: type inference failed for: r10v21 */
    /* JADX WARNING: type inference failed for: r10v22 */
    /* JADX WARNING: type inference failed for: r10v23 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0163 A[SYNTHETIC, Splitter:B:103:0x0163] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x016a A[SYNTHETIC, Splitter:B:107:0x016a] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0144 A[SYNTHETIC, Splitter:B:84:0x0144] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x014b A[SYNTHETIC, Splitter:B:88:0x014b] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0152 A[SYNTHETIC, Splitter:B:92:0x0152] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x015c A[SYNTHETIC, Splitter:B:99:0x015c] */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.ByteArrayOutputStream mo22825a(java.lang.String r8, java.util.List<java.lang.String> r9, boolean r10) {
        /*
            r7 = this;
            java.lang.String r0 = "FileManager"
            r1 = 0
            if (r10 == 0) goto L_0x0022
            boolean r9 = p019d.p143b.p144a.p147c.C7209sc.m15480a(r8, r9)
            if (r9 != 0) goto L_0x0022
            d.b.d.l r9 = r7.f13222c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "Domain is not whitelisted, skipping precache for url: "
            r10.append(r2)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.mo22918c(r0, r8)
            return r1
        L_0x0022:
            d.b.a.c.c r9 = r7.f13221b
            d.b.a.c.rb<java.lang.Boolean> r10 = p019d.p143b.p144a.p147c.C7196pb.f13758Tb
            java.lang.Object r9 = r9.mo23039a(r10)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x004b
            java.lang.String r9 = "https://"
            boolean r10 = r8.contains(r9)
            if (r10 != 0) goto L_0x004b
            d.b.a.c.c r10 = r7.f13221b
            d.b.d.l r10 = r10.mo23049b()
            java.lang.String r2 = "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting..."
            r10.mo22913a(r0, r2)
            java.lang.String r10 = "http://"
            java.lang.String r8 = r8.replace(r10, r9)
        L_0x004b:
            d.b.d.l r9 = r7.f13222c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "Loading "
            r10.append(r2)
            r10.append(r8)
            java.lang.String r2 = "..."
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r9.mo22918c(r0, r10)
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0128, all -> 0x0124 }
            r9.<init>()     // Catch:{ IOException -> 0x0128, all -> 0x0124 }
            java.net.URL r10 = new java.net.URL     // Catch:{ IOException -> 0x0121, all -> 0x011e }
            r10.<init>(r8)     // Catch:{ IOException -> 0x0121, all -> 0x011e }
            java.net.URLConnection r10 = r10.openConnection()     // Catch:{ IOException -> 0x0121, all -> 0x011e }
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch:{ IOException -> 0x0121, all -> 0x011e }
            d.b.a.c.c r2 = r7.f13221b     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            d.b.a.c.rb<java.lang.Integer> r3 = p019d.p143b.p144a.p147c.C7196pb.f13907y     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            java.lang.Object r2 = r2.mo23039a(r3)     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            r10.setConnectTimeout(r2)     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            d.b.a.c.c r2 = r7.f13221b     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            d.b.a.c.rb<java.lang.Integer> r3 = p019d.p143b.p144a.p147c.C7196pb.f13664A     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            java.lang.Object r2 = r2.mo23039a(r3)     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            r10.setReadTimeout(r2)     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            r2 = 1
            r10.setDefaultUseCaches(r2)     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            r10.setUseCaches(r2)     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            r3 = 0
            r10.setAllowUserInteraction(r3)     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            r10.setInstanceFollowRedirects(r2)     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            int r2 = r10.getResponseCode()     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r2 < r4) goto L_0x010c
            r4 = 300(0x12c, float:4.2E-43)
            if (r2 < r4) goto L_0x00b3
            goto L_0x010c
        L_0x00b3:
            java.io.InputStream r2 = r10.getInputStream()     // Catch:{ IOException -> 0x011b, all -> 0x0119 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x010a }
        L_0x00bb:
            int r5 = r4.length     // Catch:{ IOException -> 0x010a }
            int r5 = r2.read(r4, r3, r5)     // Catch:{ IOException -> 0x010a }
            if (r5 < 0) goto L_0x00e0
            r9.write(r4, r3, r5)     // Catch:{ Exception -> 0x00c6 }
            goto L_0x00bb
        L_0x00c6:
            r8 = move-exception
            r9.close()     // Catch:{ Exception -> 0x00cb }
            goto L_0x00cc
        L_0x00cb:
            r8 = move-exception
        L_0x00cc:
            if (r2 == 0) goto L_0x00d3
            r2.close()     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00d3
        L_0x00d2:
            r8 = move-exception
        L_0x00d3:
            r9.close()     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00d8
        L_0x00d7:
            r8 = move-exception
        L_0x00d8:
            if (r10 == 0) goto L_0x00df
            r10.disconnect()     // Catch:{ Exception -> 0x00de }
            goto L_0x00df
        L_0x00de:
            r8 = move-exception
        L_0x00df:
            return r1
        L_0x00e0:
            d.b.d.l r3 = r7.f13222c     // Catch:{ IOException -> 0x010a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x010a }
            r4.<init>()     // Catch:{ IOException -> 0x010a }
            java.lang.String r5 = "Loaded resource at "
            r4.append(r5)     // Catch:{ IOException -> 0x010a }
            r4.append(r8)     // Catch:{ IOException -> 0x010a }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x010a }
            r3.mo22918c(r0, r4)     // Catch:{ IOException -> 0x010a }
            if (r2 == 0) goto L_0x00fd
            r2.close()     // Catch:{ Exception -> 0x00fc }
            goto L_0x00fd
        L_0x00fc:
            r8 = move-exception
        L_0x00fd:
            r9.close()     // Catch:{ Exception -> 0x0101 }
            goto L_0x0102
        L_0x0101:
            r8 = move-exception
        L_0x0102:
            if (r10 == 0) goto L_0x0109
            r10.disconnect()     // Catch:{ Exception -> 0x0108 }
            goto L_0x0109
        L_0x0108:
            r8 = move-exception
        L_0x0109:
            return r9
        L_0x010a:
            r3 = move-exception
            goto L_0x012c
        L_0x010c:
            r9.close()     // Catch:{ Exception -> 0x0110 }
            goto L_0x0111
        L_0x0110:
            r8 = move-exception
        L_0x0111:
            if (r10 == 0) goto L_0x0118
            r10.disconnect()     // Catch:{ Exception -> 0x0117 }
            goto L_0x0118
        L_0x0117:
            r8 = move-exception
        L_0x0118:
            return r1
        L_0x0119:
            r8 = move-exception
            goto L_0x015a
        L_0x011b:
            r3 = move-exception
            r2 = r1
            goto L_0x012c
        L_0x011e:
            r8 = move-exception
            r10 = r1
            goto L_0x015a
        L_0x0121:
            r3 = move-exception
            r10 = r1
            goto L_0x012b
        L_0x0124:
            r8 = move-exception
            r9 = r1
            r10 = r9
            goto L_0x015a
        L_0x0128:
            r3 = move-exception
            r9 = r1
            r10 = r9
        L_0x012b:
            r2 = r10
        L_0x012c:
            d.b.d.l r4 = r7.f13222c     // Catch:{ all -> 0x0158 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0158 }
            r5.<init>()     // Catch:{ all -> 0x0158 }
            java.lang.String r6 = "Error loading "
            r5.append(r6)     // Catch:{ all -> 0x0158 }
            r5.append(r8)     // Catch:{ all -> 0x0158 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0158 }
            r4.mo22917b(r0, r8, r3)     // Catch:{ all -> 0x0158 }
            if (r2 == 0) goto L_0x0149
            r2.close()     // Catch:{ Exception -> 0x0148 }
            goto L_0x0149
        L_0x0148:
            r8 = move-exception
        L_0x0149:
            if (r9 == 0) goto L_0x0150
            r9.close()     // Catch:{ Exception -> 0x014f }
            goto L_0x0150
        L_0x014f:
            r8 = move-exception
        L_0x0150:
            if (r10 == 0) goto L_0x0157
            r10.disconnect()     // Catch:{ Exception -> 0x0156 }
            goto L_0x0157
        L_0x0156:
            r8 = move-exception
        L_0x0157:
            return r1
        L_0x0158:
            r8 = move-exception
            r1 = r2
        L_0x015a:
            if (r1 == 0) goto L_0x0161
            r1.close()     // Catch:{ Exception -> 0x0160 }
            goto L_0x0161
        L_0x0160:
            r0 = move-exception
        L_0x0161:
            if (r9 == 0) goto L_0x0168
            r9.close()     // Catch:{ Exception -> 0x0167 }
            goto L_0x0168
        L_0x0167:
            r9 = move-exception
        L_0x0168:
            if (r10 == 0) goto L_0x016f
            r10.disconnect()     // Catch:{ Exception -> 0x016e }
            goto L_0x016f
        L_0x016e:
            r9 = move-exception
        L_0x016f:
            goto L_0x0171
        L_0x0170:
            throw r8
        L_0x0171:
            goto L_0x0170
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p147c.C7068H.mo22825a(java.lang.String, java.util.List, boolean):java.io.ByteArrayOutputStream");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public File mo22826a(String str, Context context, boolean z) {
        File file;
        if (!C7269s.m15819a(str)) {
            this.f13221b.mo23049b().mo22918c("FileManager", "Nothing to look up, skipping...");
            return null;
        }
        C7262l lVar = this.f13222c;
        StringBuilder sb = new StringBuilder();
        sb.append("Looking up cached resource: ");
        sb.append(str);
        lVar.mo22918c("FileManager", sb.toString());
        if (!mo22829a(context) && !z) {
            return null;
        }
        if (str.contains("icon")) {
            str = str.replace("/", "_").replace(".", "_");
        }
        synchronized (this.f13223d) {
            File e = m14718e(context);
            file = new File(e, str);
            try {
                e.mkdirs();
            } catch (Exception e2) {
                return null;
            }
        }
        return file;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo22827a(Context context, String str, String str2, List<String> list, boolean z, C7174k kVar) throws MalformedURLException {
        return mo22828a(context, str, str2, list, z, false, kVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo22828a(Context context, String str, String str2, List<String> list, boolean z, boolean z2, C7174k kVar) throws MalformedURLException {
        String str3 = "FileManager";
        if (!C7269s.m15819a(str)) {
            this.f13221b.mo23049b().mo22918c(str3, "Nothing to cache, skipping...");
            return null;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        if (C7269s.m15819a(lastPathSegment) && C7269s.m15819a(str2)) {
            StringBuilder sb = new StringBuilder();
            String str4 = str2;
            sb.append(str2);
            sb.append(lastPathSegment);
            lastPathSegment = sb.toString();
        }
        String str5 = lastPathSegment;
        Context context2 = context;
        File a = mo22826a(str5, context, false);
        if (!mo22832a(a, str, list, z, kVar)) {
            return null;
        }
        C7262l lVar = this.f13222c;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Caching succeeded for file ");
        sb2.append(str5);
        lVar.mo22918c(str3, sb2.toString());
        if (z2) {
            str5 = Uri.fromFile(a).toString();
        }
        return str5;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo22829a(Context context) {
        if (C7182m.m15321a("android.permission.WRITE_EXTERNAL_STORAGE", context)) {
            return true;
        }
        if (C7182m.m15328f() && !((Boolean) this.f13221b.mo23039a(C7196pb.f13800cc)).booleanValue()) {
            return true;
        }
        this.f13221b.mo23049b().mo22913a("FileManager", "Application lacks required WRITE_EXTERNAL_STORAGE manifest permission.");
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo22830a(ByteArrayOutputStream byteArrayOutputStream, File file) {
        if (file == null) {
            return false;
        }
        C7262l lVar = this.f13222c;
        StringBuilder sb = new StringBuilder();
        sb.append("Caching ");
        sb.append(file.getAbsolutePath());
        sb.append("...");
        String str = "FileManager";
        lVar.mo22918c(str, sb.toString());
        if (byteArrayOutputStream == null || byteArrayOutputStream.size() <= 0) {
            C7262l lVar2 = this.f13222c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No data for ");
            sb2.append(file.getAbsolutePath());
            lVar2.mo22913a(str, sb2.toString());
            return false;
        } else if (!m14715b(byteArrayOutputStream, file)) {
            C7262l lVar3 = this.f13222c;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to cache ");
            sb3.append(file.getAbsolutePath());
            lVar3.mo22916b(str, sb3.toString());
            return false;
        } else {
            C7262l lVar4 = this.f13222c;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Caching completed for ");
            sb4.append(file);
            lVar4.mo22918c(str, sb4.toString());
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo22831a(File file, String str, List<String> list, C7174k kVar) {
        return mo22832a(file, str, list, true, kVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo22832a(File file, String str, List<String> list, boolean z, C7174k kVar) {
        if (file == null || !file.exists() || file.isDirectory()) {
            ByteArrayOutputStream a = mo22825a(str, list, z);
            if (kVar != null) {
                kVar.mo23183a((long) a.size());
            }
            return mo22830a(a, file);
        }
        C7262l b = this.f13221b.mo23049b();
        StringBuilder sb = new StringBuilder();
        sb.append("File exists for ");
        sb.append(str);
        b.mo22918c("FileManager", sb.toString());
        if (kVar != null) {
            kVar.mo23185b(file.length());
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo22833a(String str, Context context) {
        boolean b;
        synchronized (this.f13223d) {
            b = mo22835b(str, context, false);
        }
        return b;
    }

    /* renamed from: b */
    public List<File> mo22834b(Context context) {
        List<File> asList;
        File e = m14718e(context);
        if (!e.isDirectory()) {
            return new ArrayList(0);
        }
        synchronized (this.f13223d) {
            asList = Arrays.asList(e.listFiles());
        }
        return asList;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo22835b(String str, Context context, boolean z) {
        boolean z2;
        synchronized (this.f13223d) {
            File a = mo22826a(str, context, z);
            z2 = a != null && a.exists() && !a.isDirectory();
        }
        return z2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo22836c(Context context) {
        String str = "FileManager";
        String str2 = ".nomedia";
        if (((Boolean) this.f13221b.mo23039a(C7196pb.f13805dc)).booleanValue()) {
            try {
                mo22826a(str2, context, false);
                File file = new File(m14718e(context), str2);
                if (file.exists()) {
                    return true;
                }
                C7262l b = this.f13221b.mo23049b();
                StringBuilder sb = new StringBuilder();
                sb.append("Dropping .nomedia file at ");
                sb.append(file.getAbsolutePath());
                b.mo22918c(str, sb.toString());
                return file.createNewFile();
            } catch (Exception e) {
                this.f13221b.mo23049b().mo22914a(str, "Failed to create nomedia file", e);
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo22837d(Context context) {
        try {
            if (!m14713a()) {
                return;
            }
            if (!this.f13221b.mo23065j()) {
                this.f13222c.mo22916b("FileManager", "Cannot empty file cache after SDK has completed initialization and ad loads are in progress!");
                return;
            }
            this.f13222c.mo22918c("FileManager", "Compacting cache...");
            synchronized (this.f13223d) {
                m14712a(m14719f(context), context);
            }
        } catch (Exception e) {
            this.f13222c.mo22917b("FileManager", "Caught exception while compacting cache!", e);
            this.f13221b.mo23026A().mo23251a(C7196pb.f13784_a, (Object) Boolean.valueOf(false));
            this.f13221b.mo23026A().mo23250a();
        }
    }
}
