package p005cm.aptoide.analytics.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import p005cm.aptoide.analytics.AnalyticsLogger;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.data.Event;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0126V;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.analytics.implementation.AptoideBiAnalytics */
public class AptoideBiAnalytics {
    private static final String TAG = AptoideBiAnalytics.class.getSimpleName();
    private final CrashLogger crashReport;
    private final AnalyticsLogger debugLogger;
    private final long initialDelay;
    private final EventsPersistence persistence;
    private final long sendInterval;
    private final AptoideBiEventService service;
    private final SessionPersistence sessionPersistence;
    private final C0136c subscriptions;
    private final C0126V timerScheduler;

    public AptoideBiAnalytics(EventsPersistence persistence2, SessionPersistence sessionPersistence2, AptoideBiEventService service2, C0136c subscriptions2, C0126V timerScheduler2, long initialDelay2, long sendInterval2, CrashLogger crashReport2, AnalyticsLogger debugLogger2) {
        this.persistence = persistence2;
        this.sessionPersistence = sessionPersistence2;
        this.service = service2;
        this.subscriptions = subscriptions2;
        this.timerScheduler = timerScheduler2;
        this.sendInterval = sendInterval2;
        this.initialDelay = initialDelay2;
        this.crashReport = crashReport2;
        this.debugLogger = debugLogger2;
    }

    public void log(String eventName, Map<String, Object> data, Action action, String context) {
        EventsPersistence eventsPersistence = this.persistence;
        Event event = new Event(eventName, data, action, context, System.currentTimeMillis());
        eventsPersistence.save(event).mo3588a((C0128a) C1343c.f4240a, (C0129b<? super Throwable>) new C1345e<Object>(this));
    }

    /* renamed from: a */
    static /* synthetic */ void m6134a() {
    }

    /* renamed from: a */
    public /* synthetic */ void mo9365a(Throwable throwable) {
        AnalyticsLogger analyticsLogger = this.debugLogger;
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("cannot save the event due to ");
        sb.append(throwable.getMessage());
        analyticsLogger.logWarningDebug(str, sb.toString());
    }

    public long getTimestamp() {
        return this.sessionPersistence.getTimestamp();
    }

    public void saveTimestamp(long timestamp) {
        this.sessionPersistence.saveSessionTimestamp(timestamp);
    }

    public void setup() {
        this.subscriptions.mo3713a(C0120S.m628a(this.initialDelay, this.sendInterval, TimeUnit.MILLISECONDS, this.timerScheduler).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C1351k<Object,Object>(this)).mo3653d((C0132p<? super T, Boolean>) C1341a.f4238a).mo3663g((C0132p<? super T, ? extends C0117M>) new C1344d<Object,Object>(this)).mo3621a((C0129b<? super Throwable>) new C1352l<Object>(this)).mo3662g().mo3670j());
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo9364a(Long time) {
        return this.persistence.getAll().mo3647d();
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m6136d(List events) {
        return Boolean.valueOf(events.size() > 0);
    }

    /* renamed from: e */
    public /* synthetic */ C0117M mo9368e(List events) {
        return sendEvents(new ArrayList(events));
    }

    /* renamed from: b */
    public /* synthetic */ void mo9366b(Throwable throwable) {
        this.crashReport.log(throwable);
    }

    private C0117M sendEvents(List<Event> events) {
        return this.persistence.remove(events).mo3597b(events).mo3696c().mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) new C1349i<Object,Object>(events)).mo3669j(new C1342b(this)).mo3675m().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) C1350j.f4247a).mo3675m().mo3653d((C0132p<? super T, Boolean>) C1347g.f4244a).mo3663g((C0132p<? super T, ? extends C0117M>) new C1346f<Object,Object>(this)).mo3673l();
    }

    /* renamed from: a */
    static /* synthetic */ Iterable m6130a(List events, List __) {
        return events;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo9363a(Event event) {
        return this.service.send(event).mo3604f().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) C1348h.f4245a).mo3611a(Event.class).mo3671k(new C1354m(event));
    }

    /* renamed from: c */
    public /* synthetic */ C0117M mo9367c(List failedEvents) {
        return this.persistence.save(failedEvents);
    }
}
