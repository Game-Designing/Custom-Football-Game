package com.crashlytics.android.p126c;

import android.app.Activity;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import com.crashlytics.android.p124a.C6378b;
import com.crashlytics.android.p124a.C6401x;
import com.crashlytics.android.p126c.C6519ta.C6520a;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;
import p024io.fabric.sdk.android.p348a.p350b.C13854m.C13855a;
import p024io.fabric.sdk.android.p348a.p350b.C13854m.C13856b;
import p024io.fabric.sdk.android.p348a.p350b.C13859p;
import p024io.fabric.sdk.android.p348a.p350b.C13868y;
import p024io.fabric.sdk.android.p348a.p352d.C13882a;
import p024io.fabric.sdk.android.p348a.p353e.C13891e;
import p024io.fabric.sdk.android.p348a.p353e.C13902p;
import p024io.fabric.sdk.android.p348a.p353e.C13903q;
import p024io.fabric.sdk.android.p348a.p353e.C13905s;
import p024io.fabric.sdk.android.p348a.p353e.C13909v;
import p024io.fabric.sdk.android.services.network.C13971g;

/* renamed from: com.crashlytics.android.c.U */
/* compiled from: CrashlyticsController */
class C6452U {

    /* renamed from: a */
    static final FilenameFilter f11564a = new C6408B("BeginSession");

    /* renamed from: b */
    static final FilenameFilter f11565b = new C6435L();

    /* renamed from: c */
    static final FileFilter f11566c = new C6437M();

    /* renamed from: d */
    static final Comparator<File> f11567d = new C6439N();

    /* renamed from: e */
    static final Comparator<File> f11568e = new C6441O();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final Pattern f11569f = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");

    /* renamed from: g */
    private static final Map<String, String> f11570g = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");

    /* renamed from: h */
    private static final String[] f11571h = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};

    /* renamed from: i */
    private final AtomicInteger f11572i = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C6472aa f11573j;

    /* renamed from: k */
    private final C6512q f11574k;

    /* renamed from: l */
    private final C13971g f11575l;

    /* renamed from: m */
    private final C13868y f11576m;

    /* renamed from: n */
    private final C6411Ca f11577n;

    /* renamed from: o */
    private final C13882a f11578o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final C6471a f11579p;

    /* renamed from: q */
    private final C6459g f11580q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final C6519ta f11581r;

    /* renamed from: s */
    private final C6430c f11582s;

    /* renamed from: t */
    private final C6429b f11583t;

    /* renamed from: u */
    private final C6509oa f11584u;

    /* renamed from: v */
    private final C6442Oa f11585v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public final String f11586w;

    /* renamed from: x */
    private final C6476b f11587x;

    /* renamed from: y */
    private final C6401x f11588y;

    /* renamed from: z */
    private C6488ga f11589z;

    /* renamed from: com.crashlytics.android.c.U$a */
    /* compiled from: CrashlyticsController */
    private static class C6453a implements FilenameFilter {
        private C6453a() {
        }

        /* synthetic */ C6453a(C6408B x0) {
            this();
        }

        public boolean accept(File file, String fileName) {
            return !C6452U.f11565b.accept(file, fileName) && C6452U.f11569f.matcher(fileName).matches();
        }
    }

    /* renamed from: com.crashlytics.android.c.U$b */
    /* compiled from: CrashlyticsController */
    private interface C6454b {
        /* renamed from: a */
        void mo19431a(C6491h hVar) throws Exception;
    }

    /* renamed from: com.crashlytics.android.c.U$c */
    /* compiled from: CrashlyticsController */
    private static final class C6455c implements C6490b {
        private C6455c() {
        }

        /* synthetic */ C6455c(C6408B x0) {
            this();
        }

        /* renamed from: a */
        public C13909v mo19499a() {
            return C13905s.m44193b().mo43313a();
        }
    }

    /* renamed from: com.crashlytics.android.c.U$d */
    /* compiled from: CrashlyticsController */
    static class C6456d implements FilenameFilter {

        /* renamed from: a */
        private final String f11590a;

        public C6456d(String s) {
            this.f11590a = s;
        }

        public boolean accept(File dir, String filename) {
            return filename.contains(this.f11590a) && !filename.endsWith(".cls_temp");
        }
    }

    /* renamed from: com.crashlytics.android.c.U$e */
    /* compiled from: CrashlyticsController */
    private interface C6457e {
        /* renamed from: a */
        void mo19445a(FileOutputStream fileOutputStream) throws Exception;
    }

    /* renamed from: com.crashlytics.android.c.U$f */
    /* compiled from: CrashlyticsController */
    static class C6458f implements FilenameFilter {
        C6458f() {
        }

        public boolean accept(File file, String fileName) {
            return C6487g.f11648a.accept(file, fileName) || fileName.contains("SessionMissingBinaryImages");
        }
    }

    /* renamed from: com.crashlytics.android.c.U$g */
    /* compiled from: CrashlyticsController */
    private static final class C6459g implements C6520a {

        /* renamed from: a */
        private final C13882a f11591a;

        public C6459g(C13882a rootFileStore) {
            this.f11591a = rootFileStore;
        }

        /* renamed from: a */
        public File mo19501a() {
            File logFileDir = new File(this.f11591a.mo43292a(), "log-files");
            if (!logFileDir.exists()) {
                logFileDir.mkdirs();
            }
            return logFileDir;
        }
    }

    /* renamed from: com.crashlytics.android.c.U$h */
    /* compiled from: CrashlyticsController */
    private static final class C6460h implements C6431d {

        /* renamed from: a */
        private final C0102l f11592a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final C6411Ca f11593b;

        /* renamed from: c */
        private final C13902p f11594c;

        public C6460h(C0102l kit, C6411Ca preferenceManager, C13902p promptData) {
            this.f11592a = kit;
            this.f11593b = preferenceManager;
            this.f11594c = promptData;
        }

        /* renamed from: a */
        public boolean mo19456a() {
            Activity activity = this.f11592a.mo3309s().mo43334a();
            if (activity == null || activity.isFinishing()) {
                return true;
            }
            C6504n dialog = C6504n.m12743a(activity, this.f11594c, new C6466V(this));
            activity.runOnUiThread(new C6467W(this, dialog));
            C13920f.m44245e().mo43326c("CrashlyticsCore", "Waiting for user opt-in.");
            dialog.mo19583a();
            return dialog.mo19584b();
        }
    }

    /* renamed from: com.crashlytics.android.c.U$i */
    /* compiled from: CrashlyticsController */
    private final class C6461i implements C6430c {
        private C6461i() {
        }

        /* synthetic */ C6461i(C6452U x0, C6408B x1) {
            this();
        }

        /* renamed from: c */
        public File[] mo19460c() {
            return C6452U.this.mo19493h();
        }

        /* renamed from: b */
        public File[] mo19459b() {
            return C6452U.this.mo19490e().listFiles();
        }

        /* renamed from: a */
        public File[] mo19458a() {
            return C6452U.this.mo19494i();
        }
    }

    /* renamed from: com.crashlytics.android.c.U$j */
    /* compiled from: CrashlyticsController */
    private final class C6462j implements C6429b {
        private C6462j() {
        }

        /* synthetic */ C6462j(C6452U x0, C6408B x1) {
            this();
        }

        /* renamed from: a */
        public boolean mo19457a() {
            return C6452U.this.mo19492g();
        }
    }

    /* renamed from: com.crashlytics.android.c.U$k */
    /* compiled from: CrashlyticsController */
    private static final class C6463k implements Runnable {

        /* renamed from: a */
        private final Context f11597a;

        /* renamed from: b */
        private final C6424Ia f11598b;

        /* renamed from: c */
        private final C6427Ja f11599c;

        public C6463k(Context context, C6424Ia report, C6427Ja reportUploader) {
            this.f11597a = context;
            this.f11598b = report;
            this.f11599c = reportUploader;
        }

        public void run() {
            if (C13852l.m44045b(this.f11597a)) {
                C13920f.m44245e().mo43326c("CrashlyticsCore", "Attempting to send crash report at time of crash...");
                this.f11599c.mo19454a(this.f11598b);
            }
        }
    }

    /* renamed from: com.crashlytics.android.c.U$l */
    /* compiled from: CrashlyticsController */
    static class C6464l implements FilenameFilter {

        /* renamed from: a */
        private final String f11600a;

        public C6464l(String sessionId) {
            this.f11600a = sessionId;
        }

        public boolean accept(File file, String fileName) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f11600a);
            sb.append(".cls");
            boolean z = false;
            if (fileName.equals(sb.toString())) {
                return false;
            }
            if (fileName.contains(this.f11600a) && !fileName.endsWith(".cls_temp")) {
                z = true;
            }
            return z;
        }
    }

    C6452U(C6472aa crashlyticsCore, C6512q backgroundWorker, C13971g httpRequestFactory, C13868y idManager, C6411Ca preferenceManager, C13882a fileStore, C6471a appData, C6446Qa unityVersionProvider, C6476b appMeasurementEventListenerRegistrar, C6401x firebaseAnalyticsLogger) {
        C13882a aVar = fileStore;
        this.f11573j = crashlyticsCore;
        this.f11574k = backgroundWorker;
        this.f11575l = httpRequestFactory;
        this.f11576m = idManager;
        this.f11577n = preferenceManager;
        this.f11578o = aVar;
        this.f11579p = appData;
        this.f11586w = unityVersionProvider.mo19462a();
        this.f11587x = appMeasurementEventListenerRegistrar;
        this.f11588y = firebaseAnalyticsLogger;
        Context context = crashlyticsCore.mo3307i();
        this.f11580q = new C6459g(aVar);
        this.f11581r = new C6519ta(context, this.f11580q);
        this.f11582s = new C6461i(this, null);
        this.f11583t = new C6462j(this, null);
        this.f11584u = new C6509oa(context);
        this.f11585v = new C6527wa(Opcodes.ACC_ABSTRACT, new C6422Ha(10));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19481a(UncaughtExceptionHandler defaultHandler, boolean firebaseCrashlyticsClientFlag) {
        mo19496k();
        this.f11589z = new C6488ga(new C6443P(this), new C6455c(null), firebaseCrashlyticsClientFlag, defaultHandler);
        Thread.setDefaultUncaughtExceptionHandler(this.f11589z);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo19478a(C6490b settingsDataProvider, Thread thread, Throwable ex, boolean firebaseCrashlyticsClientFlag) {
        StringBuilder sb = new StringBuilder();
        sb.append("Crashlytics is handling uncaught exception \"");
        sb.append(ex);
        sb.append("\" from thread ");
        sb.append(thread.getName());
        C13920f.m44245e().mo43326c("CrashlyticsCore", sb.toString());
        this.f11584u.mo19591a();
        Date time = new Date();
        C6512q qVar = this.f11574k;
        C6445Q q = new C6445Q(this, time, thread, ex, settingsDataProvider, firebaseCrashlyticsClientFlag);
        qVar.mo19602b(q);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19475a(float delay, C13909v settingsData) {
        if (settingsData == null) {
            C13920f.m44245e().mo43321a("CrashlyticsCore", "Could not send reports. Settings are not available.");
            return;
        }
        C13891e eVar = settingsData.f42191a;
        new C6427Ja(this.f11579p.f11611a, m12509a(eVar.f42144d, eVar.f42145e), this.f11582s, this.f11583t).mo19453a(delay, m12559c(settingsData) ? new C6460h(this.f11573j, this.f11577n, settingsData.f42193c) : new C6428a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19477a(long timestamp, String msg) {
        this.f11574k.mo19601a((Callable<T>) new C6448S<T>(this, timestamp, msg));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19482a(Thread thread, Throwable ex) {
        this.f11574k.mo19600a((Runnable) new C6450T(this, new Date(), thread, ex));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19483a(Map<String, String> keyData) {
        this.f11574k.mo19601a((Callable<T>) new C6514r<T>(this, keyData));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo19496k() {
        this.f11574k.mo19601a((Callable<T>) new C6516s<T>(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public String m12572o() {
        File[] sessionBeginFiles = m12574q();
        if (sessionBeginFiles.length > 0) {
            return m12511a(sessionBeginFiles[0]);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public String m12573p() {
        File[] sessionBeginFiles = m12574q();
        if (sessionBeginFiles.length > 1) {
            return m12511a(sessionBeginFiles[1]);
        }
        return null;
    }

    /* renamed from: a */
    static String m12511a(File sessionFile) {
        return sessionFile.getName().substring(0, 35);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo19487b(C13903q sessionSettingsData) {
        return ((Boolean) this.f11574k.mo19602b(new C6518t(this, sessionSettingsData))).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m12570m() throws Exception {
        Date startedAt = new Date();
        String sessionIdentifier = new C6483e(this.f11576m).toString();
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append("Opening a new session with ID ");
        sb.append(sessionIdentifier);
        e.mo43326c("CrashlyticsCore", sb.toString());
        m12533a(sessionIdentifier, startedAt);
        m12562d(sessionIdentifier);
        m12567f(sessionIdentifier);
        m12565e(sessionIdentifier);
        this.f11581r.mo19609a(sessionIdentifier);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19479a(C13903q sessionSettingsData) throws Exception {
        m12525a(sessionSettingsData, false);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Incorrect type for immutable var: ssa=boolean, code=int, for r8v0, types: [boolean, int] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m12525a(p024io.fabric.sdk.android.p348a.p353e.C13903q r7, int r8) throws java.lang.Exception {
        /*
            r6 = this;
            r0 = r8
            int r1 = r0 + 8
            r6.m12547b(r1)
            java.io.File[] r1 = r6.m12574q()
            int r2 = r1.length
            java.lang.String r3 = "CrashlyticsCore"
            if (r2 > r0) goto L_0x0019
            io.fabric.sdk.android.o r2 = p024io.fabric.sdk.android.C13920f.m44245e()
            java.lang.String r4 = "No open sessions to be closed."
            r2.mo43326c(r3, r4)
            return
        L_0x0019:
            r2 = r1[r0]
            java.lang.String r2 = m12511a(r2)
            r6.m12569g(r2)
            if (r7 != 0) goto L_0x002e
            io.fabric.sdk.android.o r4 = p024io.fabric.sdk.android.C13920f.m44245e()
            java.lang.String r5 = "Unable to close session. Settings are not loaded."
            r4.mo43326c(r3, r5)
            return
        L_0x002e:
            int r3 = r7.f42177c
            r6.m12537a(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.p126c.C6452U.m12525a(io.fabric.sdk.android.a.e.q, boolean):void");
    }

    /* renamed from: a */
    private void m12537a(File[] sessionBeginFiles, int beginIndex, int maxLoggedExceptionsCount) {
        String str = "CrashlyticsCore";
        C13920f.m44245e().mo43326c(str, "Closing open sessions.");
        for (int i = beginIndex; i < sessionBeginFiles.length; i++) {
            File sessionBeginFile = sessionBeginFiles[i];
            String sessionIdentifier = m12511a(sessionBeginFile);
            C13929o e = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Closing session: ");
            sb.append(sessionIdentifier);
            e.mo43326c(str, sb.toString());
            m12526a(sessionBeginFile, sessionIdentifier, maxLoggedExceptionsCount);
        }
    }

    /* renamed from: a */
    private void m12520a(C6487g fos) {
        if (fos != null) {
            try {
                fos.mo19545a();
            } catch (IOException ex) {
                C13920f.m44245e().mo43325b("CrashlyticsCore", "Error closing session file stream in the presence of an exception", ex);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12535a(Set<File> files) {
        for (File f : files) {
            m12557c(f);
        }
    }

    /* renamed from: c */
    private void m12557c(File f) {
        if (f.isDirectory()) {
            for (File s : f.listFiles()) {
                m12557c(s);
            }
        }
        f.delete();
    }

    /* renamed from: a */
    private void m12529a(String sessionId) {
        for (File file : m12560c(sessionId)) {
            file.delete();
        }
    }

    /* renamed from: c */
    private File[] m12560c(String sessionId) {
        return m12543a((FilenameFilter) new C6464l(sessionId));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public File[] mo19493h() {
        List<File> completeSessionFiles = new LinkedList<>();
        Collections.addAll(completeSessionFiles, m12541a(mo19488c(), f11565b));
        Collections.addAll(completeSessionFiles, m12541a(mo19491f(), f11565b));
        Collections.addAll(completeSessionFiles, m12541a(mo19489d(), f11565b));
        return (File[]) completeSessionFiles.toArray(new File[completeSessionFiles.size()]);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public File[] mo19494i() {
        return m12542a(f11566c);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public File[] mo19495j() {
        return m12543a(f11564a);
    }

    /* renamed from: q */
    private File[] m12574q() {
        File[] sessionBeginFiles = mo19495j();
        Arrays.sort(sessionBeginFiles, f11567d);
        return sessionBeginFiles;
    }

    /* renamed from: a */
    private File[] m12542a(FileFilter filter) {
        return m12555b(mo19489d().listFiles(filter));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public File[] m12543a(FilenameFilter filter) {
        return m12541a(mo19489d(), filter);
    }

    /* renamed from: a */
    private File[] m12541a(File directory, FilenameFilter filter) {
        return m12555b(directory.listFiles(filter));
    }

    /* renamed from: b */
    private File[] m12554b(File directory) {
        return m12555b(directory.listFiles());
    }

    /* renamed from: b */
    private File[] m12555b(File[] files) {
        return files == null ? new File[0] : files;
    }

    /* renamed from: a */
    private void m12530a(String sessionId, int limit) {
        File d = mo19489d();
        StringBuilder sb = new StringBuilder();
        sb.append(sessionId);
        sb.append("SessionEvent");
        C6451Ta.m12508a(d, new C6456d(sb.toString()), limit, f11568e);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19476a(int maxCompleteSessionsCount) {
        int remaining = maxCompleteSessionsCount;
        int remaining2 = remaining - C6451Ta.m12507a(mo19488c(), remaining, f11568e);
        C6451Ta.m12508a(mo19489d(), f11565b, remaining2 - C6451Ta.m12507a(mo19491f(), remaining2, f11568e), f11568e);
    }

    /* renamed from: b */
    private void m12547b(int maxOpenSessionCount) {
        Set<String> sessionIdsToKeep = new HashSet<>();
        File[] beginSessionFiles = m12574q();
        int count = Math.min(maxOpenSessionCount, beginSessionFiles.length);
        for (int i = 0; i < count; i++) {
            sessionIdsToKeep.add(m12511a(beginSessionFiles[i]));
        }
        this.f11581r.mo19610a(sessionIdsToKeep);
        m12538a(m12543a((FilenameFilter) new C6453a(null)), sessionIdsToKeep);
    }

    /* renamed from: a */
    private void m12538a(File[] files, Set<String> sessionIdsToKeep) {
        for (File sessionPartFile : files) {
            String fileName = sessionPartFile.getName();
            Matcher matcher = f11569f.matcher(fileName);
            String str = "CrashlyticsCore";
            if (!matcher.matches()) {
                C13929o e = C13920f.m44245e();
                StringBuilder sb = new StringBuilder();
                sb.append("Deleting unknown file: ");
                sb.append(fileName);
                e.mo43326c(str, sb.toString());
                sessionPartFile.delete();
            } else if (!sessionIdsToKeep.contains(matcher.group(1))) {
                C13929o e2 = C13920f.m44245e();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Trimming session file: ");
                sb2.append(fileName);
                e2.mo43326c(str, sb2.toString());
                sessionPartFile.delete();
            }
        }
    }

    /* renamed from: a */
    private File[] m12544a(String sessionId, File[] nonFatalFiles, int maxLoggedExceptionsCount) {
        if (nonFatalFiles.length <= maxLoggedExceptionsCount) {
            return nonFatalFiles;
        }
        C13920f.m44245e().mo43326c("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(maxLoggedExceptionsCount)}));
        m12530a(sessionId, maxLoggedExceptionsCount);
        StringBuilder sb = new StringBuilder();
        sb.append(sessionId);
        sb.append("SessionEvent");
        return m12543a((FilenameFilter) new C6456d(sb.toString()));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo19486b() {
        this.f11574k.mo19600a((Runnable) new C6522u(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19484a(File[] invalidFiles) {
        String str;
        File[] a;
        Set<String> invalidSessionIds = new HashSet<>();
        int length = invalidFiles.length;
        int i = 0;
        while (true) {
            str = "CrashlyticsCore";
            if (i >= length) {
                break;
            }
            File invalidFile = invalidFiles[i];
            C13929o e = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Found invalid session part file: ");
            sb.append(invalidFile);
            e.mo43326c(str, sb.toString());
            invalidSessionIds.add(m12511a(invalidFile));
            i++;
        }
        if (!invalidSessionIds.isEmpty()) {
            File invalidFilesDir = mo19490e();
            if (!invalidFilesDir.exists()) {
                invalidFilesDir.mkdir();
            }
            for (File sessionFile : m12543a(new C6524v(this, invalidSessionIds))) {
                C13929o e2 = C13920f.m44245e();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Moving session file: ");
                sb2.append(sessionFile);
                e2.mo43326c(str, sb2.toString());
                if (!sessionFile.renameTo(new File(invalidFilesDir, sessionFile.getName()))) {
                    C13929o e3 = C13920f.m44245e();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Could not move session file. Deleting ");
                    sb3.append(sessionFile);
                    e3.mo43326c(str, sb3.toString());
                    sessionFile.delete();
                }
            }
            m12575r();
        }
    }

    /* renamed from: r */
    private void m12575r() {
        File invalidFilesDir = mo19490e();
        if (invalidFilesDir.exists()) {
            File[] oldInvalidFiles = m12541a(invalidFilesDir, (FilenameFilter) new C6458f());
            Arrays.sort(oldInvalidFiles, Collections.reverseOrder());
            Set<String> sessionIdsToKeep = new HashSet<>();
            for (int i = 0; i < oldInvalidFiles.length && sessionIdsToKeep.size() < 4; i++) {
                sessionIdsToKeep.add(m12511a(oldInvalidFiles[i]));
            }
            m12538a(m12554b(invalidFilesDir), sessionIdsToKeep);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12514a(Context context, File latestDir, String previousSessionId) throws IOException {
        File file = latestDir;
        String str = previousSessionId;
        byte[] minidump = C6533za.m12808b(latestDir);
        byte[] metadata = C6533za.m12805a(latestDir);
        byte[] binaryImages = C6533za.m12806a(file, context);
        String str2 = "CrashlyticsCore";
        if (minidump == null || minidump.length == 0) {
            C13929o e = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("No minidump data found in directory ");
            sb.append(file);
            e.mo43321a(str2, sb.toString());
            return;
        }
        m12558c(str, "<native-crash: minidump>");
        byte[] sessionMetadata = m12553b(str, "BeginSession.json");
        byte[] appMetadata = m12553b(str, "SessionApp.json");
        byte[] deviceMetadata = m12553b(str, "SessionDevice.json");
        byte[] osMetadata = m12553b(str, "SessionOS.json");
        byte[] userMetadata = C6533za.m12810c(new C6525va(mo19489d()).mo19617b(str));
        C6519ta previousSessionLogManager = new C6519ta(this.f11573j.mo3307i(), this.f11580q, str);
        byte[] logs = previousSessionLogManager.mo19612c();
        previousSessionLogManager.mo19606a();
        byte[] keys = C6533za.m12810c(new C6525va(mo19489d()).mo19615a(str));
        C6519ta taVar = previousSessionLogManager;
        File nativeSessionDirectory = new File(this.f11578o.mo43292a(), str);
        if (!nativeSessionDirectory.mkdir()) {
            C13920f.m44245e().mo43326c(str2, "Couldn't create native sessions directory");
            return;
        }
        m12552b(minidump, new File(nativeSessionDirectory, "minidump"));
        m12552b(metadata, new File(nativeSessionDirectory, "metadata"));
        m12552b(binaryImages, new File(nativeSessionDirectory, "binaryImages"));
        m12552b(sessionMetadata, new File(nativeSessionDirectory, "session"));
        m12552b(appMetadata, new File(nativeSessionDirectory, "app"));
        m12552b(deviceMetadata, new File(nativeSessionDirectory, "device"));
        m12552b(osMetadata, new File(nativeSessionDirectory, "os"));
        m12552b(userMetadata, new File(nativeSessionDirectory, "user"));
        m12552b(logs, new File(nativeSessionDirectory, "logs"));
        m12552b(keys, new File(nativeSessionDirectory, "keys"));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19485a(C6482da ndkData) {
        if (ndkData == null) {
            return true;
        }
        return ((Boolean) this.f11574k.mo19602b(new C6526w(this, ndkData))).booleanValue();
    }

    /* renamed from: b */
    private void m12552b(byte[] content, File path) throws IOException {
        if (content != null && content.length > 0) {
            m12536a(content, path);
        }
    }

    /* renamed from: a */
    private void m12536a(byte[] bytes, File path) throws IOException {
        GZIPOutputStream gos = null;
        try {
            gos = new GZIPOutputStream(new FileOutputStream(path));
            gos.write(bytes);
            gos.finish();
        } finally {
            C13852l.m44035a((Closeable) gos);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12551b(Date time, Thread thread, Throwable ex) {
        String str = "CrashlyticsCore";
        String str2 = "Failed to close fatal exception file output stream.";
        String str3 = "Failed to flush to session begin file.";
        C6487g fos = null;
        C6491h cos = null;
        try {
            String currentSessionId = m12572o();
            if (currentSessionId == null) {
                C13920f.m44245e().mo43325b(str, "Tried to write a fatal exception while no session was open.", null);
                C13852l.m44037a((Flushable) null, str3);
                C13852l.m44036a((Closeable) null, str2);
                return;
            }
            m12558c(currentSessionId, ex.getClass().getName());
            File d = mo19489d();
            StringBuilder sb = new StringBuilder();
            sb.append(currentSessionId);
            sb.append("SessionCrash");
            fos = new C6487g(d, sb.toString());
            cos = C6491h.m12688a((OutputStream) fos);
            m12523a(cos, time, thread, ex, "crash", true);
            C13852l.m44037a((Flushable) cos, str3);
            C13852l.m44036a((Closeable) fos, str2);
        } catch (Exception e) {
            C13920f.m44245e().mo43325b(str, "An error occurred in the fatal exception logger", e);
        } catch (Throwable th) {
            C13852l.m44037a((Flushable) cos, str3);
            C13852l.m44036a((Closeable) fos, str2);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12534a(Date time, Thread thread, Throwable ex) {
        C6491h cos;
        C6491h cos2;
        String str = "Failed to close non-fatal file output stream.";
        String str2 = "Failed to flush to non-fatal file.";
        String currentSessionId = m12572o();
        String str3 = "CrashlyticsCore";
        if (currentSessionId == null) {
            C13920f.m44245e().mo43325b(str3, "Tried to write a non-fatal exception while no session was open.", null);
            return;
        }
        m12563d(currentSessionId, ex.getClass().getName());
        C6487g fos = null;
        C6491h cos3 = null;
        try {
            C13929o e = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Crashlytics is logging non-fatal exception \"");
            sb.append(ex);
            sb.append("\" from thread ");
            sb.append(thread.getName());
            e.mo43326c(str3, sb.toString());
            String counterString = C13852l.m44042b(this.f11572i.getAndIncrement());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(currentSessionId);
            sb2.append("SessionEvent");
            sb2.append(counterString);
            C6487g fos2 = new C6487g(mo19489d(), sb2.toString());
            try {
                cos = C6491h.m12688a((OutputStream) fos2);
                cos2 = cos;
            } catch (Exception e2) {
                e = e2;
                fos = fos2;
                try {
                    C13920f.m44245e().mo43325b(str3, "An error occurred in the non-fatal exception logger", e);
                    C13852l.m44037a((Flushable) cos3, str2);
                    C13852l.m44036a((Closeable) fos, str);
                    C6487g gVar = fos;
                    C6491h hVar = cos3;
                    m12530a(currentSessionId, 64);
                } catch (Throwable th) {
                    th = th;
                    C13852l.m44037a((Flushable) cos3, str2);
                    C13852l.m44036a((Closeable) fos, str);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fos = fos2;
                C13852l.m44037a((Flushable) cos3, str2);
                C13852l.m44036a((Closeable) fos, str);
                throw th;
            }
            try {
                m12523a(cos, time, thread, ex, "error", false);
                C13852l.m44037a((Flushable) cos2, str2);
                C13852l.m44036a((Closeable) fos2, str);
            } catch (Exception e3) {
                e = e3;
                cos3 = cos2;
                fos = fos2;
                C13920f.m44245e().mo43325b(str3, "An error occurred in the non-fatal exception logger", e);
                C13852l.m44037a((Flushable) cos3, str2);
                C13852l.m44036a((Closeable) fos, str);
                C6487g gVar2 = fos;
                C6491h hVar2 = cos3;
                m12530a(currentSessionId, 64);
            } catch (Throwable th3) {
                th = th3;
                cos3 = cos2;
                fos = fos2;
                C13852l.m44037a((Flushable) cos3, str2);
                C13852l.m44036a((Closeable) fos, str);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            C13920f.m44245e().mo43325b(str3, "An error occurred in the non-fatal exception logger", e);
            C13852l.m44037a((Flushable) cos3, str2);
            C13852l.m44036a((Closeable) fos, str);
            C6487g gVar22 = fos;
            C6491h hVar22 = cos3;
            m12530a(currentSessionId, 64);
        }
        try {
            m12530a(currentSessionId, 64);
        } catch (Exception e5) {
            C13920f.m44245e().mo43325b(str3, "An error occurred when trimming non-fatal files.", e5);
        }
    }

    /* renamed from: a */
    private void m12531a(String sessionId, String tag, C6454b writeAction) throws Exception {
        String str = "Failed to close session ";
        String str2 = "Failed to flush to session ";
        String str3 = " file.";
        FileOutputStream fos = null;
        C6491h cos = null;
        try {
            File d = mo19489d();
            StringBuilder sb = new StringBuilder();
            sb.append(sessionId);
            sb.append(tag);
            fos = new C6487g(d, sb.toString());
            cos = C6491h.m12688a((OutputStream) fos);
            writeAction.mo19431a(cos);
        } finally {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(tag);
            sb2.append(str3);
            C13852l.m44037a((Flushable) cos, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(tag);
            sb3.append(str3);
            C13852l.m44036a((Closeable) fos, sb3.toString());
        }
    }

    /* renamed from: a */
    private void m12532a(String sessionId, String tag, C6457e writeAction) throws Exception {
        String str = " file.";
        String str2 = "Failed to close ";
        FileOutputStream fos = null;
        try {
            File d = mo19489d();
            StringBuilder sb = new StringBuilder();
            sb.append(sessionId);
            sb.append(tag);
            fos = new FileOutputStream(new File(d, sb.toString()));
            writeAction.mo19445a(fos);
        } finally {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(tag);
            sb2.append(str);
            C13852l.m44036a((Closeable) fos, sb2.toString());
        }
    }

    /* renamed from: b */
    private byte[] m12553b(String sessionId, String tag) {
        File d = mo19489d();
        StringBuilder sb = new StringBuilder();
        sb.append(sessionId);
        sb.append(tag);
        return C6533za.m12810c(new File(d, sb.toString()));
    }

    /* renamed from: a */
    private void m12533a(String sessionId, Date startedAt) throws Exception {
        String str = sessionId;
        String format = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{this.f11573j.mo2536w()});
        long time = startedAt.getTime() / 1000;
        C6528x xVar = new C6528x(this, str, format, time);
        m12531a(sessionId, "BeginSession", (C6454b) xVar);
        C6532z zVar = new C6532z(this, str, format, time);
        m12532a(sessionId, "BeginSession.json", (C6457e) zVar);
    }

    /* renamed from: d */
    private void m12562d(String sessionId) throws Exception {
        String appIdentifier = this.f11576m.mo43261c();
        C6471a aVar = this.f11579p;
        String versionCode = aVar.f11615e;
        String versionName = aVar.f11616f;
        String str = appIdentifier;
        String str2 = versionCode;
        String str3 = versionName;
        String d = this.f11576m.mo43262d();
        int id = C13859p.m44071a(this.f11579p.f11613c).getId();
        C6406A a = new C6406A(this, str, str2, str3, d, id);
        m12531a(sessionId, "SessionApp", (C6454b) a);
        C6412D d2 = new C6412D(this, str, str2, str3, d, id);
        m12532a(sessionId, "SessionApp.json", (C6457e) d2);
    }

    /* renamed from: f */
    private void m12567f(String sessionId) throws Exception {
        boolean isRooted = C13852l.m44061m(this.f11573j.mo3307i());
        m12531a(sessionId, "SessionOS", (C6454b) new C6414E(this, isRooted));
        m12532a(sessionId, "SessionOS.json", (C6457e) new C6418G(this, isRooted));
    }

    /* renamed from: e */
    private void m12565e(String sessionId) throws Exception {
        String str = sessionId;
        Context context = this.f11573j.mo3307i();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int arch = C13852l.m44018a();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long totalRam = C13852l.m44041b();
        long diskSpace = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean isEmulator = C13852l.m44060l(context);
        Map<DeviceIdentifierType, String> ids = this.f11576m.mo43263e();
        int state = C13852l.m44054f(context);
        int i = arch;
        int i2 = availableProcessors;
        long j = totalRam;
        long j2 = diskSpace;
        boolean z = isEmulator;
        Map map = ids;
        Context context2 = context;
        C6421H h = r0;
        int i3 = state;
        C6421H h2 = new C6421H(this, i, i2, j, j2, z, map, i3);
        m12531a(str, "SessionDevice", (C6454b) h);
        C6426J j3 = new C6426J(this, i, i2, j, j2, z, map, i3);
        m12532a(str, "SessionDevice.json", (C6457e) j3);
    }

    /* renamed from: g */
    private void m12569g(String sessionId) throws Exception {
        m12531a(sessionId, "SessionUser", (C6454b) new C6433K(this, m12545b(sessionId)));
    }

    /* renamed from: a */
    private void m12523a(C6491h cos, Date time, Thread thread, Throwable ex, String eventType, boolean includeAllThreads) throws Exception {
        Thread[] threads;
        Map<String, String> attributes;
        C6444Pa trimmedEx = new C6444Pa(ex, this.f11585v);
        Context context = this.f11573j.mo3307i();
        long eventTime = time.getTime() / 1000;
        Float batteryLevel = C13852l.m44053e(context);
        int batteryVelocity = C13852l.m44020a(context, this.f11584u.mo19593c());
        boolean proximityEnabled = C13852l.m44055g(context);
        int orientation = context.getResources().getConfiguration().orientation;
        long usedRamBytes = C13852l.m44041b() - C13852l.m44021a(context);
        long diskUsedBytes = C13852l.m44022a(Environment.getDataDirectory().getPath());
        RunningAppProcessInfo runningAppProcessInfo = C13852l.m44024a(context.getPackageName(), context);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] exceptionStack = trimmedEx.f11544c;
        String buildId = this.f11579p.f11612b;
        String appIdentifier = this.f11576m.mo43261c();
        if (includeAllThreads) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threads2 = new Thread[allStackTraces.size()];
            int i = 0;
            for (Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                threads2[i] = (Thread) entry.getKey();
                linkedList.add(this.f11585v.mo19452a((StackTraceElement[]) entry.getValue()));
                i++;
            }
            threads = threads2;
        } else {
            threads = new Thread[0];
        }
        if (!C13852l.m44040a(context, "com.crashlytics.CollectCustomKeys", true)) {
            attributes = new TreeMap<>();
        } else {
            Map<String, String> attributes2 = this.f11573j.mo19512C();
            if (attributes2 == null || attributes2.size() <= 1) {
                attributes = attributes2;
            } else {
                attributes = new TreeMap<>(attributes2);
            }
        }
        String buildId2 = buildId;
        StackTraceElement[] stackTraceElementArr = exceptionStack;
        LinkedList linkedList2 = linkedList;
        C6436La.m12485a(cos, eventTime, eventType, trimmedEx, thread, exceptionStack, threads, (List<StackTraceElement[]>) linkedList, attributes, this.f11581r, runningAppProcessInfo, orientation, appIdentifier, buildId2, batteryLevel, batteryVelocity, proximityEnabled, usedRamBytes, diskUsedBytes);
    }

    /* renamed from: a */
    private void m12526a(File sessionBeginFile, String sessionId, int maxLoggedExceptionsCount) {
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append("Collecting session parts for ID ");
        sb.append(sessionId);
        String str = "CrashlyticsCore";
        e.mo43326c(str, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(sessionId);
        sb2.append("SessionCrash");
        File[] fatalFiles = m12543a((FilenameFilter) new C6456d(sb2.toString()));
        boolean hasFatal = fatalFiles != null && fatalFiles.length > 0;
        C13920f.m44245e().mo43326c(str, String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{sessionId, Boolean.valueOf(hasFatal)}));
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sessionId);
        sb3.append("SessionEvent");
        File[] nonFatalFiles = m12543a((FilenameFilter) new C6456d(sb3.toString()));
        boolean hasNonFatal = nonFatalFiles != null && nonFatalFiles.length > 0;
        C13920f.m44245e().mo43326c(str, String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{sessionId, Boolean.valueOf(hasNonFatal)}));
        if (hasFatal || hasNonFatal) {
            m12527a(sessionBeginFile, sessionId, m12544a(sessionId, nonFatalFiles, maxLoggedExceptionsCount), hasFatal ? fatalFiles[0] : null);
        } else {
            C13929o e2 = C13920f.m44245e();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("No events present for session ID ");
            sb4.append(sessionId);
            e2.mo43326c(str, sb4.toString());
        }
        C13929o e3 = C13920f.m44245e();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Removing session part files for ID ");
        sb5.append(sessionId);
        e3.mo43326c(str, sb5.toString());
        m12529a(sessionId);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0081, code lost:
        if (0 != 0) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0083, code lost:
        m12520a(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0087, code lost:
        p024io.fabric.sdk.android.p348a.p350b.C13852l.m44036a((java.io.Closeable) r10, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b8, code lost:
        if (1 == 0) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c6  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12527a(java.io.File r19, java.lang.String r20, java.io.File[] r21, java.io.File r22) {
        /*
            r18 = this;
            r1 = r18
            r2 = r20
            r3 = r22
            java.lang.String r4 = "CrashlyticsCore"
            java.lang.String r5 = "Failed to close CLS file"
            java.lang.String r6 = "Error flushing session file stream"
            r0 = 1
            if (r3 == 0) goto L_0x0011
            r7 = 1
            goto L_0x0012
        L_0x0011:
            r7 = 0
        L_0x0012:
            r8 = 0
            if (r7 == 0) goto L_0x001a
            java.io.File r9 = r18.mo19488c()
            goto L_0x001e
        L_0x001a:
            java.io.File r9 = r18.mo19491f()
        L_0x001e:
            boolean r10 = r9.exists()
            if (r10 != 0) goto L_0x0027
            r9.mkdirs()
        L_0x0027:
            r10 = 0
            r11 = 0
            com.crashlytics.android.c.g r12 = new com.crashlytics.android.c.g     // Catch:{ Exception -> 0x0097, all -> 0x0091 }
            r12.<init>(r9, r2)     // Catch:{ Exception -> 0x0097, all -> 0x0091 }
            r10 = r12
            com.crashlytics.android.c.h r12 = com.crashlytics.android.p126c.C6491h.m12688a(r10)     // Catch:{ Exception -> 0x0097, all -> 0x0091 }
            r11 = r12
            io.fabric.sdk.android.o r12 = p024io.fabric.sdk.android.C13920f.m44245e()     // Catch:{ Exception -> 0x0097, all -> 0x0091 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0097, all -> 0x0091 }
            r13.<init>()     // Catch:{ Exception -> 0x0097, all -> 0x0091 }
            java.lang.String r14 = "Collecting SessionStart data for session ID "
            r13.append(r14)     // Catch:{ Exception -> 0x0097, all -> 0x0091 }
            r13.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0091 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0097, all -> 0x0091 }
            r12.mo43326c(r4, r13)     // Catch:{ Exception -> 0x0097, all -> 0x0091 }
            r12 = r19
            m12521a(r11, r12)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
            r13 = 4
            java.util.Date r14 = new java.util.Date     // Catch:{ Exception -> 0x008f, all -> 0x008d }
            r14.<init>()     // Catch:{ Exception -> 0x008f, all -> 0x008d }
            long r14 = r14.getTime()     // Catch:{ Exception -> 0x008f, all -> 0x008d }
            r16 = 1000(0x3e8, double:4.94E-321)
            long r14 = r14 / r16
            r11.mo19555b(r13, r14)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
            r13 = 5
            r11.mo19557b(r13, r7)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
            r13 = 11
            r11.mo19567g(r13, r0)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
            r0 = 12
            r13 = 3
            r11.mo19561d(r0, r13)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
            r1.m12522a(r11, r2)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
            r13 = r21
            m12524a(r11, r13, r2)     // Catch:{ Exception -> 0x008b }
            if (r7 == 0) goto L_0x007e
            m12521a(r11, r3)     // Catch:{ Exception -> 0x008b }
        L_0x007e:
            p024io.fabric.sdk.android.p348a.p350b.C13852l.m44037a(r11, r6)
            if (r8 == 0) goto L_0x0087
        L_0x0083:
            r1.m12520a(r10)
            goto L_0x00bb
        L_0x0087:
            p024io.fabric.sdk.android.p348a.p350b.C13852l.m44036a(r10, r5)
            goto L_0x00bb
        L_0x008b:
            r0 = move-exception
            goto L_0x009c
        L_0x008d:
            r0 = move-exception
            goto L_0x0094
        L_0x008f:
            r0 = move-exception
            goto L_0x009a
        L_0x0091:
            r0 = move-exception
            r12 = r19
        L_0x0094:
            r13 = r21
            goto L_0x00bd
        L_0x0097:
            r0 = move-exception
            r12 = r19
        L_0x009a:
            r13 = r21
        L_0x009c:
            io.fabric.sdk.android.o r14 = p024io.fabric.sdk.android.C13920f.m44245e()     // Catch:{ all -> 0x00bc }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bc }
            r15.<init>()     // Catch:{ all -> 0x00bc }
            java.lang.String r3 = "Failed to write session file for session ID: "
            r15.append(r3)     // Catch:{ all -> 0x00bc }
            r15.append(r2)     // Catch:{ all -> 0x00bc }
            java.lang.String r3 = r15.toString()     // Catch:{ all -> 0x00bc }
            r14.mo43325b(r4, r3, r0)     // Catch:{ all -> 0x00bc }
            r8 = 1
            p024io.fabric.sdk.android.p348a.p350b.C13852l.m44037a(r11, r6)
            if (r8 == 0) goto L_0x0087
            goto L_0x0083
        L_0x00bb:
            return
        L_0x00bc:
            r0 = move-exception
        L_0x00bd:
            p024io.fabric.sdk.android.p348a.p350b.C13852l.m44037a(r11, r6)
            if (r8 == 0) goto L_0x00c6
            r1.m12520a(r10)
            goto L_0x00c9
        L_0x00c6:
            p024io.fabric.sdk.android.p348a.p350b.C13852l.m44036a(r10, r5)
        L_0x00c9:
            goto L_0x00cb
        L_0x00ca:
            throw r0
        L_0x00cb:
            goto L_0x00ca
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.p126c.C6452U.m12527a(java.io.File, java.lang.String, java.io.File[], java.io.File):void");
    }

    /* renamed from: a */
    private static void m12524a(C6491h cos, File[] nonFatalFiles, String sessionId) {
        String str = "CrashlyticsCore";
        Arrays.sort(nonFatalFiles, C13852l.f42030d);
        for (File nonFatalFile : nonFatalFiles) {
            try {
                C13920f.m44245e().mo43326c(str, String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{sessionId, nonFatalFile.getName()}));
                m12521a(cos, nonFatalFile);
            } catch (Exception e) {
                C13920f.m44245e().mo43325b(str, "Error writting non-fatal to session.", e);
            }
        }
    }

    /* renamed from: a */
    private void m12522a(C6491h cos, String sessionId) throws IOException {
        String[] strArr;
        for (String tag : f11571h) {
            StringBuilder sb = new StringBuilder();
            sb.append(sessionId);
            sb.append(tag);
            sb.append(".cls");
            File[] sessionPartFiles = m12543a((FilenameFilter) new C6456d(sb.toString()));
            String str = " data for session ID ";
            String str2 = "CrashlyticsCore";
            if (sessionPartFiles.length == 0) {
                C13929o e = C13920f.m44245e();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Can't find ");
                sb2.append(tag);
                sb2.append(str);
                sb2.append(sessionId);
                e.mo43325b(str2, sb2.toString(), null);
            } else {
                C13929o e2 = C13920f.m44245e();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Collecting ");
                sb3.append(tag);
                sb3.append(str);
                sb3.append(sessionId);
                e2.mo43326c(str2, sb3.toString());
                m12521a(cos, sessionPartFiles[0]);
            }
        }
    }

    /* renamed from: a */
    private static void m12521a(C6491h cos, File file) throws IOException {
        String str = "Failed to close file input stream.";
        if (!file.exists()) {
            C13929o e = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Tried to include a file that doesn't exist: ");
            sb.append(file.getName());
            e.mo43325b("CrashlyticsCore", sb.toString(), null);
            return;
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            m12528a((InputStream) fis, cos, (int) file.length());
        } finally {
            C13852l.m44036a((Closeable) fis, str);
        }
    }

    /* renamed from: a */
    private static void m12528a(InputStream inStream, C6491h cos, int bufferLength) throws IOException {
        byte[] buffer = new byte[bufferLength];
        int offset = 0;
        while (offset < buffer.length) {
            int read = inStream.read(buffer, offset, buffer.length - offset);
            int numRead = read;
            if (read < 0) {
                break;
            }
            offset += numRead;
        }
        cos.mo19551a(buffer);
    }

    /* renamed from: b */
    private C6447Ra m12545b(String sessionId) {
        if (mo19492g()) {
            return new C6447Ra(this.f11573j.mo19515G(), this.f11573j.mo19516H(), this.f11573j.mo19514F());
        }
        return new C6525va(mo19489d()).mo19618c(sessionId);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo19492g() {
        C6488ga gaVar = this.f11589z;
        return gaVar != null && gaVar.mo19547a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public File mo19489d() {
        return this.f11578o.mo43292a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public File mo19488c() {
        return new File(mo19489d(), "fatal-sessions");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public File mo19491f() {
        return new File(mo19489d(), "nonfatal-sessions");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public File mo19490e() {
        return new File(mo19489d(), "invalidClsFiles");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19480a(C13909v settingsData) {
        if (settingsData.f42194d.f42163e) {
            boolean breadcrumbsRegistered = this.f11587x.mo19527a();
            C13929o e = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Registered Firebase Analytics event listener for breadcrumbs: ");
            sb.append(breadcrumbsRegistered);
            e.mo43326c("CrashlyticsCore", sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public void mo19497l() {
        this.f11584u.mo19592b();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m12559c(C13909v settingsData) {
        boolean z = false;
        if (settingsData == null) {
            return false;
        }
        if (settingsData.f42194d.f42159a && !this.f11577n.mo19444a()) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private C6495ia m12509a(String reportsUrl, String ndkReportsUrl) {
        String overriddenHost = C13852l.m44043b(this.f11573j.mo3307i(), "com.crashlytics.ApiEndpoint");
        return new C6496j(new C6501la(this.f11573j, overriddenHost, reportsUrl, this.f11575l), new C6531ya(this.f11573j, overriddenHost, ndkReportsUrl, this.f11575l));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12550b(C13909v settingsData) {
        if (settingsData == null) {
            C13920f.m44245e().mo43321a("CrashlyticsCore", "Cannot send reports. Settings are unavailable.");
            return;
        }
        Context context = this.f11573j.mo3307i();
        C13891e eVar = settingsData.f42191a;
        C6427Ja reportUploader = new C6427Ja(this.f11579p.f11611a, m12509a(eVar.f42144d, eVar.f42145e), this.f11582s, this.f11583t);
        for (File finishedSessionFile : mo19493h()) {
            this.f11574k.mo19600a((Runnable) new C6463k(context, new C6438Ma(finishedSessionFile, f11570g), reportUploader));
        }
    }

    /* renamed from: d */
    private static void m12563d(String sessionId, String exceptionName) {
        C6378b answers = (C6378b) C13920f.m44237a(C6378b.class);
        if (answers == null) {
            C13920f.m44245e().mo43326c("CrashlyticsCore", "Answers is not available");
        } else {
            answers.mo19379a(new C13856b(sessionId, exceptionName));
        }
    }

    /* renamed from: c */
    private static void m12558c(String sessionId, String exceptionName) {
        C6378b answers = (C6378b) C13920f.m44237a(C6378b.class);
        if (answers == null) {
            C13920f.m44245e().mo43326c("CrashlyticsCore", "Answers is not available");
        } else {
            answers.mo19378a(new C13855a(sessionId, exceptionName));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12513a(long timestamp) {
        String str = "CrashlyticsCore";
        if (m12571n()) {
            C13920f.m44245e().mo43326c(str, "Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return;
        }
        if (this.f11588y != null) {
            C13920f.m44245e().mo43326c(str, "Logging Crashlytics event to Firebase");
            Bundle params = new Bundle();
            params.putInt("_r", 1);
            params.putInt("fatal", 1);
            params.putLong("timestamp", timestamp);
            this.f11588y.mo19414a("clx", "_ae", params);
        } else {
            C13920f.m44245e().mo43326c(str, "Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
        }
    }

    /* renamed from: n */
    private boolean m12571n() {
        try {
            Class cls = Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
