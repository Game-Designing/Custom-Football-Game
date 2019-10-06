package p024io.fabric.sdk.android.p348a.p350b;

import java.io.File;
import java.util.Comparator;

/* renamed from: io.fabric.sdk.android.a.b.k */
/* compiled from: CommonUtils */
class C13851k implements Comparator<File> {
    C13851k() {
    }

    /* renamed from: a */
    public int compare(File file0, File file1) {
        return (int) (file0.lastModified() - file1.lastModified());
    }
}
