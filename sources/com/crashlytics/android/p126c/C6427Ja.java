package com.crashlytics.android.p126c;

import com.crashlytics.android.core.Report;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;
import p024io.fabric.sdk.android.p348a.p350b.C13850j;

/* renamed from: com.crashlytics.android.c.Ja */
/* compiled from: ReportUploader */
class C6427Ja {

    /* renamed from: a */
    static final Map<String, String> f11519a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final short[] f11520b = {10, 20, 30, 60, 120, 300};

    /* renamed from: c */
    private final Object f11521c = new Object();

    /* renamed from: d */
    private final C6495ia f11522d;

    /* renamed from: e */
    private final String f11523e;

    /* renamed from: f */
    private final C6430c f11524f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C6429b f11525g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Thread f11526h;

    /* renamed from: com.crashlytics.android.c.Ja$a */
    /* compiled from: ReportUploader */
    static final class C6428a implements C6431d {
        C6428a() {
        }

        /* renamed from: a */
        public boolean mo19456a() {
            return true;
        }
    }

    /* renamed from: com.crashlytics.android.c.Ja$b */
    /* compiled from: ReportUploader */
    interface C6429b {
        /* renamed from: a */
        boolean mo19457a();
    }

    /* renamed from: com.crashlytics.android.c.Ja$c */
    /* compiled from: ReportUploader */
    interface C6430c {
        /* renamed from: a */
        File[] mo19458a();

        /* renamed from: b */
        File[] mo19459b();

        /* renamed from: c */
        File[] mo19460c();
    }

    /* renamed from: com.crashlytics.android.c.Ja$d */
    /* compiled from: ReportUploader */
    interface C6431d {
        /* renamed from: a */
        boolean mo19456a();
    }

    /* renamed from: com.crashlytics.android.c.Ja$e */
    /* compiled from: ReportUploader */
    private class C6432e extends C13850j {

        /* renamed from: a */
        private final float f11527a;

        /* renamed from: b */
        private final C6431d f11528b;

        C6432e(float delay, C6431d sendCheck) {
            this.f11527a = delay;
            this.f11528b = sendCheck;
        }

        /* renamed from: a */
        public void mo19461a() {
            try {
                m12463b();
            } catch (Exception e) {
                C13920f.m44245e().mo43325b("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            C6427Ja.this.f11526h = null;
        }

        /* renamed from: b */
        private void m12463b() {
            C13929o e = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Starting report processing in ");
            sb.append(this.f11527a);
            sb.append(" second(s)...");
            String str = "CrashlyticsCore";
            e.mo43326c(str, sb.toString());
            float f = this.f11527a;
            if (f > 0.0f) {
                try {
                    Thread.sleep((long) (f * 1000.0f));
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            List<Report> reports = C6427Ja.this.mo19455b();
            if (!C6427Ja.this.f11525g.mo19457a()) {
                if (reports.isEmpty() || this.f11528b.mo19456a()) {
                    int retryCount = 0;
                    while (!reports.isEmpty() && !C6427Ja.this.f11525g.mo19457a()) {
                        C13929o e3 = C13920f.m44245e();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Attempting to send ");
                        sb2.append(reports.size());
                        sb2.append(" report(s)");
                        e3.mo43326c(str, sb2.toString());
                        Iterator it = reports.iterator();
                        while (it.hasNext()) {
                            C6427Ja.this.mo19454a((C6424Ia) it.next());
                        }
                        reports = C6427Ja.this.mo19455b();
                        if (!reports.isEmpty()) {
                            int retryCount2 = retryCount + 1;
                            long interval = (long) C6427Ja.f11520b[Math.min(retryCount, C6427Ja.f11520b.length - 1)];
                            C13929o e4 = C13920f.m44245e();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Report submisson: scheduling delayed retry in ");
                            sb3.append(interval);
                            sb3.append(" seconds");
                            e4.mo43326c(str, sb3.toString());
                            try {
                                Thread.sleep(1000 * interval);
                                retryCount = retryCount2;
                            } catch (InterruptedException e5) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }
                    return;
                }
                C13929o e6 = C13920f.m44245e();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("User declined to send. Removing ");
                sb4.append(reports.size());
                sb4.append(" Report(s).");
                e6.mo43326c(str, sb4.toString());
                Iterator it2 = reports.iterator();
                while (it2.hasNext()) {
                    ((C6424Ia) it2.next()).remove();
                }
            }
        }
    }

    public C6427Ja(String apiKey, C6495ia createReportCall, C6430c reportFilesProvider, C6429b handlingExceptionCheck) {
        if (createReportCall != null) {
            this.f11522d = createReportCall;
            this.f11523e = apiKey;
            this.f11524f = reportFilesProvider;
            this.f11525g = handlingExceptionCheck;
            return;
        }
        throw new IllegalArgumentException("createReportCall must not be null.");
    }

    /* renamed from: a */
    public synchronized void mo19453a(float delay, C6431d sendCheck) {
        if (this.f11526h != null) {
            C13920f.m44245e().mo43326c("CrashlyticsCore", "Report upload has already been started.");
            return;
        }
        this.f11526h = new Thread(new C6432e(delay, sendCheck), "Crashlytics Report Uploader");
        this.f11526h.start();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19454a(C6424Ia report) {
        boolean removed = false;
        synchronized (this.f11521c) {
            try {
                boolean sent = this.f11522d.mo19575a(new C6493ha(this.f11523e, report));
                C13929o e = C13920f.m44245e();
                String str = "CrashlyticsCore";
                StringBuilder sb = new StringBuilder();
                sb.append("Crashlytics report upload ");
                sb.append(sent ? "complete: " : "FAILED: ");
                sb.append(report.mo19433b());
                e.mo43328d(str, sb.toString());
                if (sent) {
                    report.remove();
                    removed = true;
                }
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error occurred sending report ");
                sb2.append(report);
                C13920f.m44245e().mo43325b("CrashlyticsCore", sb2.toString(), e2);
            }
        }
        return removed;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public List<C6424Ia> mo19455b() {
        File[] clsFiles;
        File[] invalidClsFiles;
        File[] nativeReportFiles;
        C13920f.m44245e().mo43326c("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.f11521c) {
            clsFiles = this.f11524f.mo19460c();
            invalidClsFiles = this.f11524f.mo19459b();
            nativeReportFiles = this.f11524f.mo19458a();
        }
        List<Report> reports = new LinkedList<>();
        if (clsFiles != null) {
            for (File file : clsFiles) {
                C13929o e = C13920f.m44245e();
                StringBuilder sb = new StringBuilder();
                sb.append("Found crash report ");
                sb.append(file.getPath());
                e.mo43326c("CrashlyticsCore", sb.toString());
                reports.add(new C6438Ma(file));
            }
        }
        Map<String, List<File>> invalidSessionFiles = new HashMap<>();
        if (invalidClsFiles != null) {
            for (File invalidFile : invalidClsFiles) {
                String sessionId = C6452U.m12511a(invalidFile);
                if (!invalidSessionFiles.containsKey(sessionId)) {
                    invalidSessionFiles.put(sessionId, new LinkedList());
                }
                ((List) invalidSessionFiles.get(sessionId)).add(invalidFile);
            }
        }
        for (String key : invalidSessionFiles.keySet()) {
            C13929o e2 = C13920f.m44245e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Found invalid session: ");
            sb2.append(key);
            e2.mo43326c("CrashlyticsCore", sb2.toString());
            List<File> invalidFiles = (List) invalidSessionFiles.get(key);
            reports.add(new C6515ra(key, (File[]) invalidFiles.toArray(new File[invalidFiles.size()])));
        }
        if (nativeReportFiles != null) {
            for (File dir : nativeReportFiles) {
                reports.add(new C6407Aa(dir));
            }
        }
        if (reports.isEmpty()) {
            C13920f.m44245e().mo43326c("CrashlyticsCore", "No reports found.");
        }
        return reports;
    }
}
