package p002b.p003c.p004f;

import java.io.File;
import java.io.FileFilter;

/* renamed from: b.c.f.b */
/* compiled from: MultiDexExtractor */
class C0025b implements FileFilter {

    /* renamed from: a */
    final /* synthetic */ String f26a;

    C0025b(String str) {
        this.f26a = str;
    }

    public boolean accept(File pathname) {
        String name = pathname.getName();
        return !name.startsWith(this.f26a) && !name.equals("MultiDex.lock");
    }
}
