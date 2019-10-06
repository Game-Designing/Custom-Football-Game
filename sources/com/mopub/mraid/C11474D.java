package com.mopub.mraid;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/* renamed from: com.mopub.mraid.D */
/* compiled from: MraidVideoViewController */
class C11474D implements OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ MraidVideoViewController f35474a;

    C11474D(MraidVideoViewController this$0) {
        this.f35474a = this$0;
    }

    public void onCompletion(MediaPlayer mp) {
        this.f35474a.f35540f.setVisibility(0);
        this.f35474a.mo36928a(true);
    }
}
