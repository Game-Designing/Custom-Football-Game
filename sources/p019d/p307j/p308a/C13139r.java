package p019d.p307j.p308a;

import android.content.Context;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.services.C10917d;
import com.liulishuo.filedownloader.services.C10917d.C10918a;
import com.liulishuo.filedownloader.services.C10920f.C10921a;
import p019d.p307j.p308a.p313e.C13119f;

/* renamed from: d.j.a.r */
/* compiled from: FileDownloadServiceProxy */
public class C13139r implements C13066A {

    /* renamed from: a */
    private C10918a f40172a;

    /* renamed from: b */
    private final C13066A f40173b;

    /* renamed from: d.j.a.r$a */
    /* compiled from: FileDownloadServiceProxy */
    private static final class C13140a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C13139r f40174a = new C13139r();
    }

    /* renamed from: c */
    public static C13139r m42869c() {
        return C13140a.f40174a;
    }

    /* renamed from: a */
    public static C10921a m42868a() {
        if (m42869c().f40173b instanceof C13141s) {
            return (C10921a) m42869c().f40173b;
        }
        return null;
    }

    private C13139r() {
        this.f40173b = C13119f.m42785a().f40143d ? new C13141s() : new C13142t();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo42138a(C10918a initCustomMaker) {
        this.f40172a = initCustomMaker;
    }

    /* renamed from: b */
    public C10917d mo42139b() {
        return new C10917d(this.f40172a);
    }

    /* renamed from: a */
    public boolean mo41967a(String url, String path, boolean pathAsDirectory, int callbackProgressTimes, int callbackProgressMinIntervalMillis, int autoRetryTimes, boolean forceReDownload, FileDownloadHeader header, boolean isWifiRequired) {
        return this.f40173b.mo41967a(url, path, pathAsDirectory, callbackProgressTimes, callbackProgressMinIntervalMillis, autoRetryTimes, forceReDownload, header, isWifiRequired);
    }

    /* renamed from: b */
    public boolean mo41968b(int id) {
        return this.f40173b.mo41968b(id);
    }

    /* renamed from: a */
    public byte mo41966a(int id) {
        return this.f40173b.mo41966a(id);
    }

    /* renamed from: k */
    public void mo41970k() {
        this.f40173b.mo41970k();
    }

    public boolean isConnected() {
        return this.f40173b.isConnected();
    }

    /* renamed from: a */
    public void mo35749a(Context context) {
        this.f40173b.mo35749a(context);
    }

    /* renamed from: a */
    public void mo35750a(Context context, Runnable connectedRunnable) {
        this.f40173b.mo35750a(context, connectedRunnable);
    }

    /* renamed from: c */
    public boolean mo41969c(int id) {
        return this.f40173b.mo41969c(id);
    }
}
