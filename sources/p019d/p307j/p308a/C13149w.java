package p019d.p307j.p308a;

import android.content.Context;
import com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask;
import com.liulishuo.filedownloader.services.C10917d.C10918a;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import p019d.p307j.p308a.C13079a.C13081b;
import p019d.p307j.p308a.p310b.C13095f;
import p019d.p307j.p308a.p313e.C13113c;
import p019d.p307j.p308a.p313e.C13117d;
import p019d.p307j.p308a.p313e.C13121g;

/* renamed from: d.j.a.w */
/* compiled from: FileDownloader */
public class C13149w {

    /* renamed from: a */
    private static final Object f40185a = new Object();

    /* renamed from: b */
    private static final Object f40186b = new Object();

    /* renamed from: c */
    private Runnable f40187c;

    /* renamed from: d */
    private C13068C f40188d;

    /* renamed from: e */
    private C13067B f40189e;

    /* renamed from: d.j.a.w$a */
    /* compiled from: FileDownloader */
    private static final class C13150a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C13149w f40190a = new C13149w();
    }

    /* renamed from: a */
    public static void m42915a(Context context, C10918a maker) {
        if (C13117d.f40139a) {
            C13117d.m42778a(C13149w.class, "init Downloader", new Object[0]);
        }
        C13113c.m42769a(context);
        C13139r.m42869c().mo42138a(maker);
    }

    /* renamed from: b */
    public static C13149w m42916b() {
        return C13150a.f40190a;
    }

    /* renamed from: a */
    public C13079a mo42157a(String url) {
        return new C13103d(url);
    }

    /* renamed from: a */
    public boolean mo42162a(C13130l listener, boolean isSerial) {
        boolean z;
        if (listener == null) {
            C13117d.m42783e(this, "Tasks with the listener can't start, because the listener provided is null: [null, %B]", Boolean.valueOf(isSerial));
            return false;
        }
        if (isSerial) {
            z = mo42165d().mo41977a(listener);
        } else {
            z = mo42165d().mo41979b(listener);
        }
        return z;
    }

    /* renamed from: a */
    public void mo42160a(C13130l listener) {
        C13144u.m42902b().mo42144a(listener);
        Iterator it = C13128k.m42819b().mo42101a(listener).iterator();
        while (it.hasNext()) {
            ((C13081b) it.next()).mo42043F().pause();
        }
    }

    /* renamed from: f */
    public void mo42167f() {
        C13144u.m42902b().mo42142a();
        for (C13081b task : C13128k.m42819b().mo42105a()) {
            task.mo42043F().pause();
        }
        if (C13139r.m42869c().isConnected()) {
            C13139r.m42869c().mo41970k();
            return;
        }
        if (this.f40187c == null) {
            this.f40187c = new C13148v(this);
        }
        C13139r.m42869c().mo35750a(C13113c.m42768a(), this.f40187c);
    }

    /* renamed from: a */
    public int mo42155a(int id) {
        List<IRunningTask> taskList = C13128k.m42819b().mo42109c(id);
        if (taskList == null || taskList.isEmpty()) {
            C13117d.m42783e(this, "request pause but not exist %d", Integer.valueOf(id));
            return 0;
        }
        Iterator it = taskList.iterator();
        while (it.hasNext()) {
            ((C13081b) it.next()).mo42043F().pause();
        }
        return taskList.size();
    }

    /* renamed from: a */
    public boolean mo42161a(int id, String targetFilePath) {
        mo42155a(id);
        if (!C13139r.m42869c().mo41969c(id)) {
            return false;
        }
        File intermediateFile = new File(C13121g.m42808g(targetFilePath));
        if (intermediateFile.exists()) {
            intermediateFile.delete();
        }
        File targetFile = new File(targetFilePath);
        if (targetFile.exists()) {
            targetFile.delete();
        }
        return true;
    }

    /* renamed from: b */
    public byte mo42163b(int id, String path) {
        byte status;
        C13081b task = C13128k.m42819b().mo42106b(id);
        if (task == null) {
            status = C13139r.m42869c().mo41966a(id);
        } else {
            status = task.mo42043F().getStatus();
        }
        if (path == null || status != 0 || !C13121g.m42802c(C13113c.m42768a()) || !new File(path).exists()) {
            return status;
        }
        return -3;
    }

    /* renamed from: a */
    public int mo42156a(int id, C13130l listener) {
        C13081b task = C13128k.m42819b().mo42106b(id);
        if (task == null) {
            return 0;
        }
        task.mo42043F().mo42011a(listener);
        return task.mo42043F().getId();
    }

    /* renamed from: a */
    public void mo42158a() {
        if (!mo42166e()) {
            C13139r.m42869c().mo35749a(C13113c.m42768a());
        }
    }

    /* renamed from: e */
    public boolean mo42166e() {
        return C13139r.m42869c().isConnected();
    }

    /* renamed from: a */
    public void mo42159a(C13122f listener) {
        C13124h.m42817a().mo42065a("event.service.connect.changed", (C13095f) listener);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C13068C mo42165d() {
        if (this.f40188d == null) {
            synchronized (f40185a) {
                if (this.f40188d == null) {
                    this.f40188d = new C13076I();
                }
            }
        }
        return this.f40188d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C13067B mo42164c() {
        if (this.f40189e == null) {
            synchronized (f40186b) {
                if (this.f40189e == null) {
                    this.f40189e = new C13073F();
                    mo42159a((C13122f) this.f40189e);
                }
            }
        }
        return this.f40189e;
    }
}
