package com.moat.analytics.mobile.iro;

import android.media.MediaPlayer;
import android.view.View;
import com.mopub.mobileads.VastIconXmlManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.iro.q */
final class C11048q extends C11024g implements NativeVideoTracker {

    /* renamed from: ͺ */
    private WeakReference<MediaPlayer> f33775;

    C11048q(String str) {
        super(str);
        String str2 = "NativeVideoTracker";
        C11011b.m36234(3, str2, this, "In initialization method.");
        if (str == null || str.isEmpty()) {
            StringBuilder sb = new StringBuilder("PartnerCode is ");
            sb.append(str == null ? "null" : "empty");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder("NativeDisplayTracker creation problem, ");
            sb3.append(sb2);
            String sb4 = sb3.toString();
            C11011b.m36234(3, str2, this, sb4);
            C11011b.m36232("[ERROR] ", sb4);
            this.f33652 = new C11043o(sb2);
        }
        C11011b.m36232("[SUCCESS] ", "NativeVideoTracker created");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱˊ */
    public final boolean mo36093() {
        WeakReference<MediaPlayer> weakReference = this.f33775;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ */
    public final String mo36057() {
        return "NativeVideoTracker";
    }

    public final boolean trackVideoAd(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
        try {
            mo36058();
            mo36061();
            if (mediaPlayer != null) {
                mediaPlayer.getCurrentPosition();
                this.f33775 = new WeakReference<>(mediaPlayer);
                return super.mo36071(map, view);
            }
            throw new C11043o("Null player instance");
        } catch (Exception e) {
            throw new C11043o("Playback has already completed");
        } catch (Exception e2) {
            C11043o.m36351(e2);
            String r2 = C11043o.m36350("trackVideoAd", e2);
            TrackerListener trackerListener = this.f33650;
            if (trackerListener != null) {
                trackerListener.onTrackingFailedToStart(r2);
            }
            C11011b.m36234(3, "NativeVideoTracker", this, r2);
            StringBuilder sb = new StringBuilder("NativeVideoTracker ");
            sb.append(r2);
            C11011b.m36232("[ERROR] ", sb.toString());
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋॱ */
    public final Integer mo36092() {
        return Integer.valueOf(((MediaPlayer) this.f33775.get()).getCurrentPosition());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱˎ */
    public final boolean mo36094() {
        return ((MediaPlayer) this.f33775.get()).isPlaying();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ʻॱ */
    public final Integer mo36090() {
        return Integer.valueOf(((MediaPlayer) this.f33775.get()).getDuration());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ */
    public final void mo36062(List<String> list) throws C11043o {
        WeakReference<MediaPlayer> weakReference = this.f33775;
        if (!((weakReference == null || weakReference.get() == null) ? false : true)) {
            list.add("Player is null");
        }
        super.mo36062(list);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊॱ */
    public final Map<String, Object> mo36069() throws C11043o {
        MediaPlayer mediaPlayer = (MediaPlayer) this.f33775.get();
        HashMap hashMap = new HashMap();
        hashMap.put("width", Integer.valueOf(mediaPlayer.getVideoWidth()));
        hashMap.put("height", Integer.valueOf(mediaPlayer.getVideoHeight()));
        hashMap.put(VastIconXmlManager.DURATION, Integer.valueOf(mediaPlayer.getDuration()));
        return hashMap;
    }
}
