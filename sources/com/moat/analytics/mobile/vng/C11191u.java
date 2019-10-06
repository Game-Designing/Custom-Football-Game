package com.moat.analytics.mobile.vng;

import android.media.MediaPlayer;
import android.view.View;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.vng.u */
class C11191u extends C11163h<MediaPlayer> implements NativeVideoTracker {
    C11191u(String str) {
        super(str);
        C11185p.m36817a(3, "NativeVideoTracker", (Object) this, "In initialization method.");
        StringBuilder sb = new StringBuilder();
        sb.append(mo36311a());
        sb.append(" created");
        C11185p.m36819a("[SUCCESS] ", sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo36311a() {
        return "NativeVideoTracker";
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public Map<String, Object> mo36332g() {
        MediaPlayer mediaPlayer = (MediaPlayer) this.f34056j.get();
        HashMap hashMap = new HashMap();
        hashMap.put("width", Integer.valueOf(mediaPlayer.getVideoWidth()));
        hashMap.put("height", Integer.valueOf(mediaPlayer.getVideoHeight()));
        hashMap.put(VastIconXmlManager.DURATION, Integer.valueOf(mediaPlayer.getDuration()));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public Integer mo36342j() {
        return Integer.valueOf(((MediaPlayer) this.f34056j.get()).getCurrentPosition());
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public boolean mo36343k() {
        return ((MediaPlayer) this.f34056j.get()).isPlaying();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public Integer mo36344l() {
        return Integer.valueOf(((MediaPlayer) this.f34056j.get()).getDuration());
    }

    /* renamed from: trackVideoAd */
    public boolean mo36330a(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
        StringBuilder sb;
        String str;
        String str2 = "[ERROR] ";
        String str3 = "NativeVideoTracker";
        if (mediaPlayer == null) {
            C11185p.m36817a(3, str3, (Object) this, "Null player instance. Not tracking.");
            sb = new StringBuilder();
            sb.append(mo36311a());
            str = " tracking didn't start, Null player instance";
        } else {
            try {
                mediaPlayer.getCurrentPosition();
                return super.mo36330a(map, mediaPlayer, view);
            } catch (Exception e) {
                C11185p.m36817a(3, str3, (Object) this, "Playback has already completed. Not tracking.");
                sb = new StringBuilder();
                sb.append(mo36311a());
                sb.append(" tracking didn't started for ");
                sb.append(mo36323e());
                str = ", playback has already completed";
            }
        }
        sb.append(str);
        C11185p.m36819a(str2, sb.toString());
        return false;
    }
}
