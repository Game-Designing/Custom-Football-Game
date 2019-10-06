package p024io.realm.internal.async;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* renamed from: io.realm.internal.async.a */
/* compiled from: RealmThreadPoolExecutor */
class C7322a implements FileFilter {

    /* renamed from: a */
    final /* synthetic */ Pattern f14288a;

    C7322a(Pattern pattern) {
        this.f14288a = pattern;
    }

    public boolean accept(File file) {
        return this.f14288a.matcher(file.getName()).matches();
    }
}
