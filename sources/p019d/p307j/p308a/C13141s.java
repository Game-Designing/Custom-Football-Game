package p019d.p307j.p308a;

import android.content.Context;
import android.content.Intent;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.services.C10920f;
import com.liulishuo.filedownloader.services.C10920f.C10921a;
import com.liulishuo.filedownloader.services.FileDownloadService.SharedMainProcessService;
import java.util.ArrayList;
import java.util.List;
import p019d.p307j.p308a.p310b.C13091c;
import p019d.p307j.p308a.p310b.C13091c.C13092a;
import p019d.p307j.p308a.p313e.C13110a;

/* renamed from: d.j.a.s */
/* compiled from: FileDownloadServiceSharedTransmit */
class C13141s implements C13066A, C10921a {

    /* renamed from: a */
    private static final Class<?> f40175a = SharedMainProcessService.class;

    /* renamed from: b */
    private final ArrayList<Runnable> f40176b = new ArrayList<>();

    /* renamed from: c */
    private C10920f f40177c;

    C13141s() {
    }

    /* renamed from: a */
    public boolean mo41967a(String url, String path, boolean pathAsDirectory, int callbackProgressTimes, int callbackProgressMinIntervalMillis, int autoRetryTimes, boolean forceReDownload, FileDownloadHeader header, boolean isWifiRequired) {
        if (!isConnected()) {
            return C13110a.m42763a(url, path, pathAsDirectory);
        }
        this.f40177c.mo35782a(url, path, pathAsDirectory, callbackProgressTimes, callbackProgressMinIntervalMillis, autoRetryTimes, forceReDownload, header, isWifiRequired);
        return true;
    }

    /* renamed from: b */
    public boolean mo41968b(int id) {
        if (!isConnected()) {
            return C13110a.m42765c(id);
        }
        return this.f40177c.mo35786b(id);
    }

    /* renamed from: a */
    public byte mo41966a(int id) {
        if (!isConnected()) {
            return C13110a.m42764b(id);
        }
        return this.f40177c.mo35777a(id);
    }

    /* renamed from: k */
    public void mo41970k() {
        if (!isConnected()) {
            C13110a.m42760a();
        } else {
            this.f40177c.mo35791k();
        }
    }

    public boolean isConnected() {
        return this.f40177c != null;
    }

    /* renamed from: a */
    public void mo35749a(Context context) {
        mo35750a(context, null);
    }

    /* renamed from: a */
    public void mo35750a(Context context, Runnable connectedRunnable) {
        if (connectedRunnable != null && !this.f40176b.contains(connectedRunnable)) {
            this.f40176b.add(connectedRunnable);
        }
        context.startService(new Intent(context, f40175a));
    }

    /* renamed from: c */
    public boolean mo41969c(int id) {
        if (!isConnected()) {
            return C13110a.m42762a(id);
        }
        return this.f40177c.mo35787c(id);
    }

    /* renamed from: a */
    public void mo35794a(C10920f handler) {
        this.f40177c = handler;
        List<Runnable> runnableList = (List) this.f40176b.clone();
        this.f40176b.clear();
        for (Runnable runnable : runnableList) {
            runnable.run();
        }
        C13124h.m42817a().mo42064a(new C13091c(C13092a.connected, f40175a));
    }

    public void onDisconnected() {
        this.f40177c = null;
        C13124h.m42817a().mo42064a(new C13091c(C13092a.disconnected, f40175a));
    }
}
