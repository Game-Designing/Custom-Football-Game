package p019d.p307j.p308a.p313e;

import android.annotation.SuppressLint;
import android.content.Context;
import com.liulishuo.filedownloader.message.C10904d;
import com.liulishuo.filedownloader.message.C10907e;
import com.liulishuo.filedownloader.model.C10912b;
import com.liulishuo.filedownloader.services.C10922g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import p019d.p307j.p308a.C13072E;
import p019d.p307j.p308a.p309a.C13084a;
import p019d.p307j.p308a.p312d.C13105a;

/* renamed from: d.j.a.e.c */
/* compiled from: FileDownloadHelper */
public class C13113c {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    private static Context f40138a;

    /* renamed from: d.j.a.e.c$a */
    /* compiled from: FileDownloadHelper */
    public interface C13114a {
        C13084a create(String str) throws IOException;
    }

    /* renamed from: d.j.a.e.c$b */
    /* compiled from: FileDownloadHelper */
    public interface C13115b {
        /* renamed from: a */
        C10922g mo42093a();
    }

    /* renamed from: d.j.a.e.c$c */
    /* compiled from: FileDownloadHelper */
    public interface C13116c {
        /* renamed from: a */
        C13105a mo42090a(File file) throws FileNotFoundException;

        /* renamed from: a */
        boolean mo42091a();
    }

    /* renamed from: a */
    public static void m42769a(Context context) {
        f40138a = context;
    }

    /* renamed from: a */
    public static Context m42768a() {
        return f40138a;
    }

    /* renamed from: a */
    public static boolean m42771a(int id, String path, boolean forceReDownload, boolean flowDirectly) {
        if (!forceReDownload && path != null) {
            File file = new File(path);
            if (file.exists()) {
                C10904d.m35756a().mo35705a(C10907e.m35763a(id, file, flowDirectly));
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m42770a(int id, C10912b model, C13072E monitor, boolean flowDirectly) {
        if (!monitor.mo35799a(model)) {
            return false;
        }
        C10904d.m35756a().mo35705a(C10907e.m35762a(id, model.mo35733f(), model.mo35737j(), flowDirectly));
        return true;
    }
}
