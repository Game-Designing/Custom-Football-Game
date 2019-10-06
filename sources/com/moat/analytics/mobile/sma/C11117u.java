package com.moat.analytics.mobile.sma;

import android.media.MediaPlayer;
import android.view.View;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.sma.u */
class C11117u extends C11089h<MediaPlayer> implements NativeVideoTracker {
    C11117u(String str) {
        super(str);
        C11111p.m36577a(3, "NativeVideoTracker", (Object) this, "In initialization method.");
        StringBuilder sb = new StringBuilder();
        sb.append(mo36181a());
        sb.append(" created");
        C11111p.m36579a("[SUCCESS] ", sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo36181a() {
        return "NativeVideoTracker";
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public Map<String, Object> mo36197g() {
        MediaPlayer mediaPlayer = (MediaPlayer) this.f33869j.get();
        HashMap hashMap = new HashMap();
        hashMap.put("width", Integer.valueOf(mediaPlayer.getVideoWidth()));
        hashMap.put("height", Integer.valueOf(mediaPlayer.getVideoHeight()));
        hashMap.put(VastIconXmlManager.DURATION, Integer.valueOf(mediaPlayer.getDuration()));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public Integer mo36210m() {
        return Integer.valueOf(((MediaPlayer) this.f33869j.get()).getCurrentPosition());
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public boolean mo36211n() {
        return ((MediaPlayer) this.f33869j.get()).isPlaying();
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public Integer mo36212o() {
        return Integer.valueOf(((MediaPlayer) this.f33869j.get()).getDuration());
    }

    /* renamed from: trackVideoAd */
    public boolean mo36195a(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
        StringBuilder sb;
        String str;
        String str2 = "[ERROR] ";
        String str3 = "NativeVideoTracker";
        if (mediaPlayer == null) {
            C11111p.m36577a(3, str3, (Object) this, "Null player instance. Not tracking.");
            sb = new StringBuilder();
            sb.append(mo36181a());
            str = " tracking didn't start, Null player instance";
        } else {
            try {
                mediaPlayer.getCurrentPosition();
                return super.mo36195a(map, mediaPlayer, view);
            } catch (Exception e) {
                C11111p.m36577a(3, str3, (Object) this, "Playback has already completed. Not tracking.");
                sb = new StringBuilder();
                sb.append(mo36181a());
                sb.append(" tracking didn't started for ");
                sb.append(mo36188e());
                str = ", playback has already completed";
            }
        }
        sb.append(str);
        C11111p.m36579a(str2, sb.toString());
        return false;
    }
}
