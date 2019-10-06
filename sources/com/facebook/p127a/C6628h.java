package com.facebook.p127a;

import android.content.Context;
import com.facebook.C6787r;
import com.facebook.internal.C6709b;
import java.util.HashMap;
import java.util.Set;

/* renamed from: com.facebook.a.h */
/* compiled from: AppEventCollection */
class C6628h {

    /* renamed from: a */
    private final HashMap<C6593b, C6562B> f12066a = new HashMap<>();

    /* renamed from: a */
    public synchronized void mo19825a(C6560A persistedEvents) {
        if (persistedEvents != null) {
            for (C6593b accessTokenAppIdPair : persistedEvents.mo19738a()) {
                C6562B sessionEventsState = m13187b(accessTokenAppIdPair);
                for (C6625g appEvent : persistedEvents.mo19741b(accessTokenAppIdPair)) {
                    sessionEventsState.mo19744a(appEvent);
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo19826a(C6593b accessTokenAppIdPair, C6625g appEvent) {
        m13187b(accessTokenAppIdPair).mo19744a(appEvent);
    }

    /* renamed from: b */
    public synchronized Set<C6593b> mo19827b() {
        return this.f12066a.keySet();
    }

    /* renamed from: a */
    public synchronized C6562B mo19824a(C6593b accessTokenAppIdPair) {
        return (C6562B) this.f12066a.get(accessTokenAppIdPair);
    }

    /* renamed from: a */
    public synchronized int mo19823a() {
        int count;
        count = 0;
        for (C6562B sessionEventsState : this.f12066a.values()) {
            count += sessionEventsState.mo19742a();
        }
        return count;
    }

    /* renamed from: b */
    private synchronized C6562B m13187b(C6593b accessTokenAppId) {
        C6562B eventsState;
        eventsState = (C6562B) this.f12066a.get(accessTokenAppId);
        if (eventsState == null) {
            Context context = C6787r.m13815e();
            eventsState = new C6562B(C6709b.m13508a(context), C6638q.m13213a(context));
        }
        this.f12066a.put(accessTokenAppId, eventsState);
        return eventsState;
    }
}
