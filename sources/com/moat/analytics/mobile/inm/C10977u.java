package com.moat.analytics.mobile.inm;

import android.media.MediaPlayer;
import android.view.View;
import com.mopub.mobileads.VastIconXmlManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.inm.u */
class C10977u extends C10947h implements NativeVideoTracker {

    /* renamed from: m */
    private WeakReference<MediaPlayer> f33558m;

    C10977u(String str) {
        super(str);
        String str2 = "NativeVideoTracker";
        C10969p.m36113a(3, str2, (Object) this, "In initialization method.");
        if (str == null || str.isEmpty()) {
            StringBuilder sb = new StringBuilder("PartnerCode is ");
            sb.append(str == null ? "null" : "empty");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder("NativeDisplayTracker creation problem, ");
            sb3.append(sb2);
            C10969p.m36114a("[ERROR] ", 3, str2, this, sb3.toString());
            this.f33421a = new C10960m(sb2);
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(mo35886a());
        sb4.append(" created");
        C10969p.m36116a("[SUCCESS] ", sb4.toString());
    }

    /* renamed from: a */
    private void m36142a(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.getCurrentPosition();
            } catch (Exception e) {
                throw new C10960m("Playback has already completed");
            }
        } else {
            throw new C10960m("Null player instance");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo35886a() {
        return "NativeVideoTracker";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35890a(List<String> list) {
        if (!mo35925n()) {
            list.add("Player is null");
        }
        super.mo35890a(list);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public Map<String, Object> mo35908i() {
        MediaPlayer mediaPlayer = (MediaPlayer) this.f33558m.get();
        HashMap hashMap = new HashMap();
        hashMap.put("width", Integer.valueOf(mediaPlayer.getVideoWidth()));
        hashMap.put("height", Integer.valueOf(mediaPlayer.getVideoHeight()));
        hashMap.put(VastIconXmlManager.DURATION, Integer.valueOf(mediaPlayer.getDuration()));
        return hashMap;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public boolean mo35925n() {
        WeakReference<MediaPlayer> weakReference = this.f33558m;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public Integer mo35926o() {
        return Integer.valueOf(((MediaPlayer) this.f33558m.get()).getCurrentPosition());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public boolean mo35928q() {
        return ((MediaPlayer) this.f33558m.get()).isPlaying();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public Integer mo35929r() {
        return Integer.valueOf(((MediaPlayer) this.f33558m.get()).getDuration());
    }

    public boolean trackVideoAd(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
        try {
            mo35892c();
            mo35894d();
            m36142a(mediaPlayer);
            this.f33558m = new WeakReference<>(mediaPlayer);
            return super.mo35906a(map, view);
        } catch (Exception e) {
            C10960m.m36077a(e);
            String a = C10960m.m36075a("trackVideoAd", e);
            TrackerListener trackerListener = this.f33424d;
            if (trackerListener != null) {
                trackerListener.onTrackingFailedToStart(a);
            }
            C10969p.m36113a(3, "NativeVideoTracker", (Object) this, a);
            StringBuilder sb = new StringBuilder();
            sb.append(mo35886a());
            sb.append(" ");
            sb.append(a);
            C10969p.m36116a("[ERROR] ", sb.toString());
            return false;
        }
    }
}
