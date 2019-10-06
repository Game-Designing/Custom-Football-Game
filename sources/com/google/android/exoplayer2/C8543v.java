package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.C8434i;

/* renamed from: com.google.android.exoplayer2.v */
/* compiled from: Player */
public interface C8543v {

    @Deprecated
    /* renamed from: com.google.android.exoplayer2.v$a */
    /* compiled from: Player */
    public static abstract class C8544a implements C8545b {
        /* renamed from: a */
        public /* synthetic */ void mo26156a() {
            C8568w.m20757a(this);
        }

        /* renamed from: a */
        public /* synthetic */ void mo26157a(int i) {
            C8568w.m20758a(this, i);
        }

        public void onTimelineChanged(C8098D timeline, Object manifest, int reason) {
            onTimelineChanged(timeline, manifest);
        }

        @Deprecated
        public void onTimelineChanged(C8098D timeline, Object manifest) {
        }
    }

    /* renamed from: com.google.android.exoplayer2.v$b */
    /* compiled from: Player */
    public interface C8545b {
        /* renamed from: a */
        void mo26156a();

        /* renamed from: a */
        void mo26157a(int i);

        void onLoadingChanged(boolean z);

        void onPlaybackParametersChanged(C8438u uVar);

        void onPlayerError(ExoPlaybackException exoPlaybackException);

        void onPlayerStateChanged(boolean z, int i);

        void onTimelineChanged(C8098D d, Object obj, int i);

        void onTracksChanged(TrackGroupArray trackGroupArray, C8434i iVar);
    }

    /* renamed from: a */
    void mo25469a();

    /* renamed from: a */
    void mo25470a(int i, long j);

    /* renamed from: a */
    void mo25180a(long j);

    /* renamed from: a */
    void mo25473a(C8545b bVar);

    /* renamed from: a */
    void mo25474a(boolean z);

    /* renamed from: b */
    void mo25476b(boolean z);

    long getCurrentPosition();

    long getDuration();

    /* renamed from: i */
    int mo25481i();

    /* renamed from: j */
    int mo25482j();

    /* renamed from: k */
    C8098D mo25483k();

    /* renamed from: l */
    boolean mo25484l();

    void stop();
}
