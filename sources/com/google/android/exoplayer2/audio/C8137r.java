package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;

/* renamed from: com.google.android.exoplayer2.audio.r */
/* compiled from: DefaultAudioSink */
class C8137r extends Thread {

    /* renamed from: a */
    final /* synthetic */ AudioTrack f16729a;

    /* renamed from: b */
    final /* synthetic */ DefaultAudioSink f16730b;

    C8137r(DefaultAudioSink this$0, AudioTrack audioTrack) {
        this.f16730b = this$0;
        this.f16729a = audioTrack;
    }

    public void run() {
        this.f16729a.release();
    }
}
