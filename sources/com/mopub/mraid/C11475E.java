package com.mopub.mraid;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

/* renamed from: com.mopub.mraid.E */
/* compiled from: MraidVideoViewController */
class C11475E implements OnErrorListener {

    /* renamed from: a */
    final /* synthetic */ MraidVideoViewController f35475a;

    C11475E(MraidVideoViewController this$0) {
        this.f35475a = this$0;
    }

    public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        this.f35475a.f35540f.setVisibility(0);
        this.f35475a.mo36930b(false);
        return false;
    }
}
