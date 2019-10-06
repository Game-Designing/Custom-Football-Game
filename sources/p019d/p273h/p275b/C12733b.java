package p019d.p273h.p275b;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: d.h.b.b */
/* compiled from: EventData */
public class C12733b {

    /* renamed from: a */
    private int f39058a = -1;

    /* renamed from: b */
    private long f39059b = -1;

    /* renamed from: c */
    private JSONObject f39060c;

    public C12733b(int eventId, long timeStamp, JSONObject additionalData) {
        this.f39058a = eventId;
        this.f39059b = timeStamp;
        if (additionalData == null) {
            this.f39060c = new JSONObject();
        } else {
            this.f39060c = additionalData;
        }
    }

    public C12733b(int eventId, JSONObject additionalData) {
        this.f39058a = eventId;
        this.f39059b = System.currentTimeMillis();
        if (additionalData == null) {
            this.f39060c = new JSONObject();
        } else {
            this.f39060c = additionalData;
        }
    }

    /* renamed from: c */
    public int mo41158c() {
        return this.f39058a;
    }

    /* renamed from: d */
    public long mo41159d() {
        return this.f39059b;
    }

    /* renamed from: a */
    public String mo41154a() {
        return this.f39060c.toString();
    }

    /* renamed from: b */
    public JSONObject mo41157b() {
        return this.f39060c;
    }

    /* renamed from: a */
    public void mo41155a(int eventId) {
        this.f39058a = eventId;
    }

    /* renamed from: a */
    public void mo41156a(String key, Object value) {
        try {
            this.f39060c.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
