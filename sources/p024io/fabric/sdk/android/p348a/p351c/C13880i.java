package p024io.fabric.sdk.android.p348a.p351c;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p024io.fabric.sdk.android.p348a.p350b.C13832C;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;

/* renamed from: io.fabric.sdk.android.a.c.i */
/* compiled from: QueueFileEventStorage */
public class C13880i implements C13875d {

    /* renamed from: a */
    private final Context f42102a;

    /* renamed from: b */
    private final File f42103b;

    /* renamed from: c */
    private final String f42104c;

    /* renamed from: d */
    private final File f42105d;

    /* renamed from: e */
    private C13832C f42106e = new C13832C(this.f42105d);

    /* renamed from: f */
    private File f42107f;

    /* renamed from: a */
    public OutputStream mo43290a(File file) throws IOException {
        throw null;
    }

    public C13880i(Context context, File workingDirectory, String workingFileName, String targetDirectoryName) throws IOException {
        this.f42102a = context;
        this.f42103b = workingDirectory;
        this.f42104c = targetDirectoryName;
        this.f42105d = new File(this.f42103b, workingFileName);
        m44140e();
    }

    /* renamed from: e */
    private void m44140e() {
        this.f42107f = new File(this.f42103b, this.f42104c);
        if (!this.f42107f.exists()) {
            this.f42107f.mkdirs();
        }
    }

    /* renamed from: a */
    public void mo43285a(byte[] data) throws IOException {
        this.f42106e.mo43205a(data);
    }

    /* renamed from: a */
    public int mo43281a() {
        return this.f42106e.mo43211d();
    }

    /* renamed from: a */
    public void mo43283a(String targetName) throws IOException {
        this.f42106e.close();
        m44139a(this.f42105d, new File(this.f42107f, targetName));
        this.f42106e = new C13832C(this.f42105d);
    }

    /* renamed from: a */
    private void m44139a(File sourceFile, File targetFile) throws IOException {
        String str = "Failed to close output stream";
        String str2 = "Failed to close file input stream";
        OutputStream fos = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(sourceFile);
            fos = mo43290a(targetFile);
            C13852l.m44038a((InputStream) fis, fos, new byte[Opcodes.ACC_ABSTRACT]);
        } finally {
            C13852l.m44036a((Closeable) fis, str2);
            C13852l.m44036a((Closeable) fos, str);
            sourceFile.delete();
        }
    }

    /* renamed from: a */
    public List<File> mo43282a(int maxBatchSize) {
        List<File> batch = new ArrayList<>();
        for (File file : this.f42107f.listFiles()) {
            batch.add(file);
            if (batch.size() >= maxBatchSize) {
                break;
            }
        }
        return batch;
    }

    /* renamed from: a */
    public void mo43284a(List<File> files) {
        for (File file : files) {
            C13852l.m44049c(this.f42102a, String.format("deleting sent analytics file %s", new Object[]{file.getName()}));
            file.delete();
        }
    }

    /* renamed from: b */
    public List<File> mo43287b() {
        return Arrays.asList(this.f42107f.listFiles());
    }

    /* renamed from: d */
    public void mo43289d() {
        try {
            this.f42106e.close();
        } catch (IOException e) {
        }
        this.f42105d.delete();
    }

    /* renamed from: c */
    public boolean mo43288c() {
        return this.f42106e.mo43208b();
    }

    /* renamed from: a */
    public boolean mo43286a(int newEventSizeInBytes, int maxByteSizePerFile) {
        return this.f42106e.mo43207a(newEventSizeInBytes, maxByteSizePerFile);
    }
}
