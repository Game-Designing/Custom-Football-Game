package p019d.p307j.p308a;

import android.os.IBinder;
import android.os.RemoteException;
import com.liulishuo.filedownloader.message.C10904d;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.services.C10914a;
import com.liulishuo.filedownloader.services.FileDownloadService.SeparateProcessService;
import p019d.p307j.p308a.p311c.C13097a;
import p019d.p307j.p308a.p311c.C13097a.C13098a;
import p019d.p307j.p308a.p311c.C13100b;
import p019d.p307j.p308a.p311c.C13100b.C13101a;
import p019d.p307j.p308a.p313e.C13110a;

/* renamed from: d.j.a.t */
/* compiled from: FileDownloadServiceUIGuard */
class C13142t extends C10914a<C13143a, C13100b> {

    /* renamed from: d.j.a.t$a */
    /* compiled from: FileDownloadServiceUIGuard */
    protected static class C13143a extends C13098a {
        protected C13143a() {
        }

        /* renamed from: a */
        public void mo42070a(MessageSnapshot snapshot) throws RemoteException {
            C10904d.m35756a().mo35705a(snapshot);
        }
    }

    C13142t() {
        super(SeparateProcessService.class);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C13143a m42892a() {
        return new C13143a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C13100b m42891a(IBinder service) {
        return C13101a.m42671a(service);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo35751a(C13100b service, C13143a fileDownloadServiceCallback) throws RemoteException {
        service.mo35785b((C13097a) fileDownloadServiceCallback);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35753b(C13100b service, C13143a fileDownloadServiceCallback) throws RemoteException {
        service.mo35781a((C13097a) fileDownloadServiceCallback);
    }

    /* renamed from: a */
    public boolean mo41967a(String url, String path, boolean pathAsDirectory, int callbackProgressTimes, int callbackProgressMinIntervalMillis, int autoRetryTimes, boolean forceReDownload, FileDownloadHeader header, boolean isWifiRequired) {
        if (!isConnected()) {
            return C13110a.m42763a(url, path, pathAsDirectory);
        }
        try {
            ((C13100b) mo35752b()).mo35782a(url, path, pathAsDirectory, callbackProgressTimes, callbackProgressMinIntervalMillis, autoRetryTimes, forceReDownload, header, isWifiRequired);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public boolean mo41968b(int id) {
        if (!isConnected()) {
            return C13110a.m42765c(id);
        }
        try {
            return ((C13100b) mo35752b()).mo35786b(id);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public byte mo41966a(int id) {
        if (!isConnected()) {
            return C13110a.m42764b(id);
        }
        byte status = 0;
        try {
            status = ((C13100b) mo35752b()).mo35777a(id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return status;
    }

    /* renamed from: k */
    public void mo41970k() {
        if (!isConnected()) {
            C13110a.m42760a();
            return;
        }
        try {
            ((C13100b) mo35752b()).mo35791k();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public boolean mo41969c(int id) {
        if (!isConnected()) {
            return C13110a.m42762a(id);
        }
        try {
            return ((C13100b) mo35752b()).mo35787c(id);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
