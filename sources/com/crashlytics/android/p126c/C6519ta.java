package com.crashlytics.android.p126c;

import android.content.Context;
import java.io.File;
import java.util.Set;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;

/* renamed from: com.crashlytics.android.c.ta */
/* compiled from: LogFileManager */
class C6519ta {

    /* renamed from: a */
    private static final C6521b f11704a = new C6521b();

    /* renamed from: b */
    private final Context f11705b;

    /* renamed from: c */
    private final C6520a f11706c;

    /* renamed from: d */
    private C6513qa f11707d;

    /* renamed from: com.crashlytics.android.c.ta$a */
    /* compiled from: LogFileManager */
    public interface C6520a {
        /* renamed from: a */
        File mo19501a();
    }

    /* renamed from: com.crashlytics.android.c.ta$b */
    /* compiled from: LogFileManager */
    private static final class C6521b implements C6513qa {
        private C6521b() {
        }

        /* renamed from: a */
        public void mo19448a(long timestamp, String msg) {
        }

        /* renamed from: b */
        public C6481d mo19449b() {
            return null;
        }

        /* renamed from: c */
        public byte[] mo19450c() {
            return null;
        }

        /* renamed from: a */
        public void mo19447a() {
        }

        /* renamed from: d */
        public void mo19451d() {
        }
    }

    C6519ta(Context context, C6520a directoryProvider) {
        this(context, directoryProvider, null);
    }

    C6519ta(Context context, C6520a directoryProvider, String currentSessionId) {
        this.f11705b = context;
        this.f11706c = directoryProvider;
        this.f11707d = f11704a;
        mo19609a(currentSessionId);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo19609a(String sessionId) {
        this.f11707d.mo19447a();
        this.f11707d = f11704a;
        if (sessionId != null) {
            if (!C13852l.m44040a(this.f11705b, "com.crashlytics.CollectCustomLogs", true)) {
                C13920f.m44245e().mo43326c("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
            } else {
                mo19608a(m12774b(sessionId), 65536);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19607a(long timestamp, String msg) {
        this.f11707d.mo19448a(timestamp, msg);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C6481d mo19611b() {
        return this.f11707d.mo19449b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public byte[] mo19612c() {
        return this.f11707d.mo19450c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19606a() {
        this.f11707d.mo19451d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19610a(Set<String> sessionIdsToKeep) {
        File[] logFiles = this.f11706c.mo19501a().listFiles();
        if (logFiles != null) {
            for (File file : logFiles) {
                if (!sessionIdsToKeep.contains(m12773a(file))) {
                    file.delete();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19608a(File workingFile, int maxLogSize) {
        this.f11707d = new C6419Ga(workingFile, maxLogSize);
    }

    /* renamed from: b */
    private File m12774b(String sessionId) {
        StringBuilder sb = new StringBuilder();
        sb.append("crashlytics-userlog-");
        sb.append(sessionId);
        sb.append(".temp");
        return new File(this.f11706c.mo19501a(), sb.toString());
    }

    /* renamed from: a */
    private String m12773a(File workingFile) {
        String filename = workingFile.getName();
        int indexOfExtension = filename.lastIndexOf(".temp");
        if (indexOfExtension == -1) {
            return filename;
        }
        return filename.substring("crashlytics-userlog-".length(), indexOfExtension);
    }
}
