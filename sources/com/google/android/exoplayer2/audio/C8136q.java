package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;

/* renamed from: com.google.android.exoplayer2.audio.q */
/* compiled from: DefaultAudioSink */
class C8136q extends Thread {

    /* renamed from: a */
    final /* synthetic */ AudioTrack f16727a;

    /* renamed from: b */
    final /* synthetic */ DefaultAudioSink f16728b;

    C8136q(DefaultAudioSink this$0, AudioTrack audioTrack) {
        this.f16728b = this$0;
        this.f16727a = audioTrack;
    }

    public void run() {
        try {
            this.f16727a.flush();
            this.f16727a.release();
        } finally {
            this.f16728b.f16616j.open();
        }
    }
}
