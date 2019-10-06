package p019d.p273h.p276c.p282f;

import android.app.Activity;
import org.json.JSONObject;

/* renamed from: d.h.c.f.ha */
/* compiled from: RewardedVideoAdapterApi */
public interface C12875ha {
    void fetchRewardedVideo(JSONObject jSONObject);

    void initRewardedVideo(Activity activity, String str, String str2, JSONObject jSONObject, C12885ma maVar);

    boolean isRewardedVideoAvailable(JSONObject jSONObject);

    void showRewardedVideo(JSONObject jSONObject, C12885ma maVar);
}
