package com.facebook.p127a.p130b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.facebook.C6787r;
import java.util.UUID;

/* renamed from: com.facebook.a.b.u */
/* compiled from: SessionInfo */
class C6617u {

    /* renamed from: a */
    private Long f12029a;

    /* renamed from: b */
    private Long f12030b;

    /* renamed from: c */
    private int f12031c;

    /* renamed from: d */
    private Long f12032d;

    /* renamed from: e */
    private C6619w f12033e;

    /* renamed from: f */
    private UUID f12034f;

    public C6617u(Long sessionStartTime, Long sessionLastEventTime) {
        this(sessionStartTime, sessionLastEventTime, UUID.randomUUID());
    }

    public C6617u(Long sessionStartTime, Long sessionLastEventTime, UUID sessionId) {
        this.f12029a = sessionStartTime;
        this.f12030b = sessionLastEventTime;
        this.f12034f = sessionId;
    }

    /* renamed from: h */
    public static C6617u m13154h() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(C6787r.m13815e());
        long startTime = sharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionStartTime", 0);
        long endTime = sharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionEndTime", 0);
        String sessionIDStr = sharedPreferences.getString("com.facebook.appevents.SessionInfo.sessionId", null);
        if (startTime == 0 || endTime == 0 || sessionIDStr == null) {
            return null;
        }
        C6617u sessionInfo = new C6617u(Long.valueOf(startTime), Long.valueOf(endTime));
        sessionInfo.f12031c = sharedPreferences.getInt("com.facebook.appevents.SessionInfo.interruptionCount", 0);
        sessionInfo.f12033e = C6619w.m13169b();
        sessionInfo.f12032d = Long.valueOf(System.currentTimeMillis());
        sessionInfo.f12034f = UUID.fromString(sessionIDStr);
        return sessionInfo;
    }

    /* renamed from: a */
    public static void m13153a() {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(C6787r.m13815e()).edit();
        editor.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
        editor.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
        editor.remove("com.facebook.appevents.SessionInfo.interruptionCount");
        editor.remove("com.facebook.appevents.SessionInfo.sessionId");
        editor.apply();
        C6619w.m13168a();
    }

    /* renamed from: e */
    public Long mo19809e() {
        return this.f12030b;
    }

    /* renamed from: a */
    public void mo19805a(Long sessionLastEventTime) {
        this.f12030b = sessionLastEventTime;
    }

    /* renamed from: c */
    public int mo19807c() {
        return this.f12031c;
    }

    /* renamed from: i */
    public void mo19812i() {
        this.f12031c++;
    }

    /* renamed from: b */
    public long mo19806b() {
        Long l = this.f12032d;
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    /* renamed from: d */
    public UUID mo19808d() {
        return this.f12034f;
    }

    /* renamed from: f */
    public long mo19810f() {
        if (this.f12029a != null) {
            Long l = this.f12030b;
            if (l != null) {
                return l.longValue() - this.f12029a.longValue();
            }
        }
        return 0;
    }

    /* renamed from: g */
    public C6619w mo19811g() {
        return this.f12033e;
    }

    /* renamed from: j */
    public void mo19813j() {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(C6787r.m13815e()).edit();
        editor.putLong("com.facebook.appevents.SessionInfo.sessionStartTime", this.f12029a.longValue());
        editor.putLong("com.facebook.appevents.SessionInfo.sessionEndTime", this.f12030b.longValue());
        editor.putInt("com.facebook.appevents.SessionInfo.interruptionCount", this.f12031c);
        editor.putString("com.facebook.appevents.SessionInfo.sessionId", this.f12034f.toString());
        editor.apply();
        C6619w wVar = this.f12033e;
        if (wVar != null) {
            wVar.mo19814c();
        }
    }
}
