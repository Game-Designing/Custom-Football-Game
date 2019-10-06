package p024io.fabric.sdk.android.p348a.p351c;

import android.content.Context;
import io.fabric.sdk.android.services.events.EventsFilesManager.FileWithTimestamp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;
import p024io.fabric.sdk.android.p348a.p350b.C13857n;

/* renamed from: io.fabric.sdk.android.a.c.c */
/* compiled from: EventsFilesManager */
public abstract class C13873c<T> {

    /* renamed from: a */
    protected final Context f42093a;

    /* renamed from: b */
    protected final C13871a<T> f42094b;

    /* renamed from: c */
    protected final C13857n f42095c;

    /* renamed from: d */
    protected final C13875d f42096d;

    /* renamed from: e */
    private final int f42097e;

    /* renamed from: f */
    protected volatile long f42098f;

    /* renamed from: g */
    protected final List<C13876e> f42099g = new CopyOnWriteArrayList();

    /* renamed from: io.fabric.sdk.android.a.c.c$a */
    /* compiled from: EventsFilesManager */
    static class C13874a {

        /* renamed from: a */
        final File f42100a;

        /* renamed from: b */
        final long f42101b;

        public C13874a(File file, long timestamp) {
            this.f42100a = file;
            this.f42101b = timestamp;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract String mo19348c();

    public C13873c(Context context, C13871a<T> transform, C13857n currentTimeProvider, C13875d eventStorage, int defaultMaxFilesToKeep) throws IOException {
        this.f42093a = context.getApplicationContext();
        this.f42094b = transform;
        this.f42096d = eventStorage;
        this.f42095c = currentTimeProvider;
        this.f42098f = this.f42095c.mo43216a();
        this.f42097e = defaultMaxFilesToKeep;
    }

    /* renamed from: a */
    public void mo43276a(T event) throws IOException {
        byte[] eventBytes = this.f42094b.mo19373a(event);
        m44112a(eventBytes.length);
        this.f42096d.mo43285a(eventBytes);
    }

    /* renamed from: a */
    public void mo43275a(C13876e listener) {
        if (listener != null) {
            this.f42099g.add(listener);
        }
    }

    /* renamed from: g */
    public boolean mo43280g() throws IOException {
        boolean fileRolledOver = false;
        String targetFileName = null;
        if (!this.f42096d.mo43288c()) {
            targetFileName = mo19348c();
            this.f42096d.mo43283a(targetFileName);
            C13852l.m44033a(this.f42093a, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[]{targetFileName}));
            this.f42098f = this.f42095c.mo43216a();
            fileRolledOver = true;
        }
        m44113b(targetFileName);
        return fileRolledOver;
    }

    /* renamed from: a */
    private void m44112a(int newEventSizeInBytes) throws IOException {
        if (!this.f42096d.mo43286a(newEventSizeInBytes, mo19349e())) {
            C13852l.m44033a(this.f42093a, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.f42096d.mo43281a()), Integer.valueOf(newEventSizeInBytes), Integer.valueOf(mo19349e())}));
            mo43280g();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public int mo19350f() {
        return this.f42097e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public int mo19349e() {
        return 8000;
    }

    /* renamed from: b */
    private void m44113b(String rolledOverFile) {
        for (C13876e eventStorageRollOverListener : this.f42099g) {
            try {
                eventStorageRollOverListener.mo19398a(rolledOverFile);
            } catch (Exception e) {
                C13852l.m44034a(this.f42093a, "One of the roll over listeners threw an exception", (Throwable) e);
            }
        }
    }

    /* renamed from: d */
    public List<File> mo43279d() {
        return this.f42096d.mo43282a(1);
    }

    /* renamed from: a */
    public void mo43277a(List<File> files) {
        this.f42096d.mo43284a(files);
    }

    /* renamed from: a */
    public void mo43274a() {
        C13875d dVar = this.f42096d;
        dVar.mo43284a(dVar.mo43287b());
        this.f42096d.mo43289d();
    }

    /* renamed from: b */
    public void mo43278b() {
        List<File> allFiles = this.f42096d.mo43287b();
        int maxFiles = mo19350f();
        if (allFiles.size() > maxFiles) {
            int numberOfFilesToDelete = allFiles.size() - maxFiles;
            C13852l.m44049c(this.f42093a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(allFiles.size()), Integer.valueOf(maxFiles), Integer.valueOf(numberOfFilesToDelete)}));
            TreeSet<FileWithTimestamp> sortedFiles = new TreeSet<>(new C13872b(this));
            for (File file : allFiles) {
                sortedFiles.add(new C13874a(file, mo43273a(file.getName())));
            }
            ArrayList<File> toDelete = new ArrayList<>();
            Iterator it = sortedFiles.iterator();
            while (it.hasNext()) {
                toDelete.add(((C13874a) it.next()).f42100a);
                if (toDelete.size() == numberOfFilesToDelete) {
                    break;
                }
            }
            this.f42096d.mo43284a((List<File>) toDelete);
        }
    }

    /* renamed from: a */
    public long mo43273a(String fileName) {
        String[] fileNameParts = fileName.split("_");
        if (fileNameParts.length != 3) {
            return 0;
        }
        try {
            return Long.valueOf(fileNameParts[2]).longValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
