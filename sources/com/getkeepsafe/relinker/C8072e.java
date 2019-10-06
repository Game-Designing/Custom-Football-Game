package com.getkeepsafe.relinker;

import android.content.Context;
import android.util.Log;
import com.getkeepsafe.relinker.C8065b.C8066a;
import com.getkeepsafe.relinker.C8065b.C8067b;
import com.getkeepsafe.relinker.C8065b.C8068c;
import com.getkeepsafe.relinker.C8065b.C8069d;
import com.getkeepsafe.relinker.p181a.C8060f;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.getkeepsafe.relinker.e */
/* compiled from: ReLinkerInstance */
public class C8072e {

    /* renamed from: a */
    protected final Set<String> f16437a;

    /* renamed from: b */
    protected final C8067b f16438b;

    /* renamed from: c */
    protected final C8066a f16439c;

    /* renamed from: d */
    protected boolean f16440d;

    /* renamed from: e */
    protected boolean f16441e;

    /* renamed from: f */
    protected C8069d f16442f;

    protected C8072e() {
        this(new C8073f(), new C8050a());
    }

    protected C8072e(C8067b libraryLoader, C8066a libraryInstaller) {
        this.f16437a = new HashSet();
        if (libraryLoader == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        } else if (libraryInstaller != null) {
            this.f16438b = libraryLoader;
            this.f16439c = libraryInstaller;
        } else {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
    }

    /* renamed from: a */
    public void mo24902a(Context context, String library) {
        mo24904a(context, library, (String) null, (C8068c) null);
    }

    /* renamed from: a */
    public void mo24904a(Context context, String library, String version, C8068c listener) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (!C8074g.m18192a(library)) {
            mo24906a("Beginning load of %s...", library);
            if (listener == null) {
                m18179c(context, library, version);
                return;
            }
            C8070c cVar = new C8070c(this, context, library, version, listener);
            new Thread(cVar).start();
        } else {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m18179c(Context context, String library, String version) {
        if (!this.f16437a.contains(library) || this.f16440d) {
            try {
                this.f16438b.mo24891a(library);
                this.f16437a.add(library);
                mo24906a("%s (%s) was loaded normally!", library, version);
            } catch (UnsatisfiedLinkError e) {
                mo24906a("Loading the library normally failed: %s", Log.getStackTraceString(e));
                mo24906a("%s (%s) was not loaded normally, re-linking...", library, version);
                File workaroundFile = mo24907b(context, library, version);
                if (!workaroundFile.exists() || this.f16440d) {
                    if (this.f16440d) {
                        mo24906a("Forcing a re-link of %s (%s)...", library, version);
                    }
                    mo24903a(context, library, version);
                    this.f16439c.mo24878a(context, this.f16438b.mo24892a(), this.f16438b.mo24893b(library), workaroundFile, this);
                }
                try {
                    if (this.f16441e) {
                        for (String dependency : new C8060f(workaroundFile).mo24886b()) {
                            mo24902a(context, this.f16438b.mo24894c(dependency));
                        }
                    }
                } catch (IOException e2) {
                }
                this.f16438b.mo24895d(workaroundFile.getAbsolutePath());
                this.f16437a.add(library);
                mo24906a("%s (%s) was re-linked!", library, version);
            }
        } else {
            mo24906a("%s already loaded previously!", library);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public File mo24901a(Context context) {
        return context.getDir("lib", 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public File mo24907b(Context context, String library, String version) {
        String libName = this.f16438b.mo24893b(library);
        if (C8074g.m18192a(version)) {
            return new File(mo24901a(context), libName);
        }
        File a = mo24901a(context);
        StringBuilder sb = new StringBuilder();
        sb.append(libName);
        sb.append(".");
        sb.append(version);
        return new File(a, sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24903a(Context context, String library, String currentVersion) {
        File workaroundDir = mo24901a(context);
        File workaroundFile = mo24907b(context, library, currentVersion);
        File[] existingFiles = workaroundDir.listFiles(new C8071d(this, this.f16438b.mo24893b(library)));
        if (existingFiles != null) {
            for (File file : existingFiles) {
                if (this.f16440d || !file.getAbsolutePath().equals(workaroundFile.getAbsolutePath())) {
                    file.delete();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo24906a(String format, Object... args) {
        mo24905a(String.format(Locale.US, format, args));
    }

    /* renamed from: a */
    public void mo24905a(String message) {
        C8069d dVar = this.f16442f;
        if (dVar != null) {
            dVar.log(message);
        }
    }
}
