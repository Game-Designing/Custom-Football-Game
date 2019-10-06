package p024io.fabric.sdk.android.p348a.p351c;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: io.fabric.sdk.android.a.c.h */
/* compiled from: GZIPQueueFileEventStorage */
public class C13879h extends C13880i {
    public C13879h(Context context, File workingDirectory, String workingFileName, String targetDirectoryName) throws IOException {
        super(context, workingDirectory, workingFileName, targetDirectoryName);
    }

    /* renamed from: a */
    public OutputStream mo43290a(File targetFile) throws IOException {
        return new GZIPOutputStream(new FileOutputStream(targetFile));
    }
}
