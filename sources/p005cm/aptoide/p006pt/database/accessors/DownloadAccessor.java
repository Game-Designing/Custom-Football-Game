package p005cm.aptoide.p006pt.database.accessors;

import java.util.List;
import java.util.concurrent.Callable;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.schedulers.RealmSchedulers;
import p024io.realm.C13990F;
import p024io.realm.C14047ca;
import p024io.realm.C14052da;
import p024io.realm.C14064ia;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.database.accessors.DownloadAccessor */
public class DownloadAccessor extends SimpleAccessor<Download> {
    public DownloadAccessor(Database db) {
        super(db, Download.class);
    }

    public C0120S<List<Download>> getAll() {
        return this.database.getAll(Download.class);
    }

    public C0120S<Download> get(long downloadId) {
        return this.database.get(Download.class, "appId", Long.valueOf(downloadId));
    }

    public C0120S<Download> get(String md5) {
        return this.database.get(Download.class, "md5", md5);
    }

    @Deprecated
    public void delete(long downloadId) {
        C0120S.m633a((Callable<? extends T>) new C2739K<Object>(this, downloadId)).mo3634b(RealmSchedulers.getScheduler()).mo3626a((C0129b<? super T>) C2741L.f5948a, (C0129b<Throwable>) C2731G.f5935a);
    }

    /* renamed from: a */
    public /* synthetic */ Object mo11646a(long downloadId) throws Exception {
        this.database.delete(Download.class, "appId", Long.valueOf(downloadId));
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ void m7386a(Object o) {
    }

    public void delete(String md5) {
        C0120S.m633a((Callable<? extends T>) new C2754S<Object>(this, md5)).mo3634b(RealmSchedulers.getScheduler()).mo3626a((C0129b<? super T>) C2727E.f5929a, (C0129b<Throwable>) C2749P.f5956a);
    }

    /* renamed from: a */
    public /* synthetic */ Object mo11647a(String md5) throws Exception {
        this.database.delete(Download.class, "md5", md5);
        return null;
    }

    /* renamed from: b */
    static /* synthetic */ void m7389b(Object o) {
    }

    public void save(Download download) {
        this.database.insert(download);
    }

    public void save(List<Download> download) {
        this.database.insertAll(download);
    }

    /* renamed from: c */
    public /* synthetic */ C13990F mo11651c() throws Exception {
        return this.database.get();
    }

    public C0120S<List<Download>> getRunningDownloads() {
        return C0120S.m633a((Callable<? extends T>) new C2745N<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) C2747O.f5954a).mo3643c(RealmSchedulers.getScheduler()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2733H<Object,Object>(this)).mo3634b(RealmSchedulers.getScheduler()).mo3616a(Schedulers.m776io());
    }

    /* renamed from: b */
    static /* synthetic */ C0120S m7388b(C13990F realm) {
        C14047ca c = realm.mo43540c(Download.class);
        String str = "overallDownloadStatus";
        c.mo43669a(str, Integer.valueOf(5));
        c.mo43685d();
        c.mo43669a(str, Integer.valueOf(4));
        c.mo43685d();
        c.mo43669a(str, Integer.valueOf(13));
        return c.mo43681b().mo43707c();
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo11652c(C14052da data) {
        return this.database.mo940f(data);
    }

    /* renamed from: b */
    public /* synthetic */ C13990F mo11649b() throws Exception {
        return this.database.get();
    }

    public C0120S<List<Download>> getInQueueSortedDownloads() {
        return C0120S.m633a((Callable<? extends T>) new C2737J<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) C2756T.f5964a).mo3643c(RealmSchedulers.getScheduler()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2729F<Object,Object>(this)).mo3634b(RealmSchedulers.getScheduler()).mo3616a(Schedulers.m776io());
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m7384a(C13990F realm) {
        C14047ca c = realm.mo43540c(Download.class);
        c.mo43669a("overallDownloadStatus", Integer.valueOf(13));
        return c.mo43677a("timeStamp", C14064ia.ASCENDING).mo43707c();
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo11650b(C14052da data) {
        return this.database.mo940f(data);
    }

    /* renamed from: a */
    public /* synthetic */ C13990F mo11645a() throws Exception {
        return this.database.get();
    }

    public C0120S<List<Download>> getAllSorted(C14064ia sort) {
        return C0120S.m633a((Callable<? extends T>) new C2751Q<Object>(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2735I<Object,Object>(sort)).mo3643c(RealmSchedulers.getScheduler()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2743M<Object,Object>(this)).mo3634b(RealmSchedulers.getScheduler()).mo3616a(Schedulers.m776io());
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo11648a(C14052da data) {
        return this.database.mo940f(data);
    }

    public C0120S<List<Download>> getAsList(String md5) {
        return this.database.getAsList(Download.class, "md5", md5);
    }
}
