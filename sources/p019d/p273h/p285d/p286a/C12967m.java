package p019d.p273h.p285d.p286a;

import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: d.h.d.a.m */
/* compiled from: ViewVisibilityParameters */
class C12967m {

    /* renamed from: a */
    private HashMap<String, Boolean> f39911a = new C12966l(this);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f39912b = 4;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f39913c = 4;

    C12967m() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41819a(String keyToUpdate, int newVisibilityState, boolean isShownValueToUpdate) {
        boolean z = true;
        if (this.f39911a.containsKey(keyToUpdate)) {
            this.f39911a.put(keyToUpdate, Boolean.valueOf(newVisibilityState == 0));
        }
        String str = "isShown";
        this.f39911a.put(str, Boolean.valueOf(isShownValueToUpdate));
        if ((!((Boolean) this.f39911a.get("isWindowVisible")).booleanValue() && !((Boolean) this.f39911a.get("isVisible")).booleanValue()) || !((Boolean) this.f39911a.get(str)).booleanValue()) {
            z = false;
        }
        this.f39911a.put("isViewVisible", Boolean.valueOf(z));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo41818a() {
        return new JSONObject(this.f39911a);
    }
}
