package p005cm.aptoide.p006pt.sync.alarm;

import p005cm.aptoide.p006pt.sync.Sync;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.sync.alarm.b */
/* compiled from: lambda */
public final /* synthetic */ class C5103b implements C0128a {

    /* renamed from: a */
    private final /* synthetic */ AlarmSyncService f8826a;

    /* renamed from: b */
    private final /* synthetic */ boolean f8827b;

    /* renamed from: c */
    private final /* synthetic */ Sync f8828c;

    /* renamed from: d */
    private final /* synthetic */ int f8829d;

    public /* synthetic */ C5103b(AlarmSyncService alarmSyncService, boolean z, Sync sync, int i) {
        this.f8826a = alarmSyncService;
        this.f8827b = z;
        this.f8828c = sync;
        this.f8829d = i;
    }

    public final void call() {
        this.f8826a.mo16739a(this.f8827b, this.f8828c, this.f8829d);
    }
}
