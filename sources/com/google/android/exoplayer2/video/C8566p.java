package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p182a.C8106d;
import com.google.android.exoplayer2.util.C8514e;

/* renamed from: com.google.android.exoplayer2.video.p */
/* compiled from: VideoRendererEventListener */
public interface C8566p {

    /* renamed from: com.google.android.exoplayer2.video.p$a */
    /* compiled from: VideoRendererEventListener */
    public static final class C8567a {

        /* renamed from: a */
        private final Handler f18993a;

        /* renamed from: b */
        private final C8566p f18994b;

        public C8567a(Handler handler, C8566p listener) {
            Handler handler2;
            if (listener != null) {
                C8514e.m20486a(handler);
                handler2 = handler;
            } else {
                handler2 = null;
            }
            this.f18993a = handler2;
            this.f18994b = listener;
        }

        /* renamed from: b */
        public void mo26226b(C8106d decoderCounters) {
            if (this.f18994b != null) {
                this.f18993a.post(new C8551e(this, decoderCounters));
            }
        }

        /* renamed from: d */
        public /* synthetic */ void mo26229d(C8106d decoderCounters) {
            this.f18994b.mo26215b(decoderCounters);
        }

        /* renamed from: a */
        public void mo26221a(String decoderName, long initializedTimestampMs, long initializationDurationMs) {
            if (this.f18994b != null) {
                Handler handler = this.f18993a;
                C8550d dVar = new C8550d(this, decoderName, initializedTimestampMs, initializationDurationMs);
                handler.post(dVar);
            }
        }

        /* renamed from: b */
        public /* synthetic */ void mo26227b(String decoderName, long initializedTimestampMs, long initializationDurationMs) {
            this.f18994b.mo26214a(decoderName, initializedTimestampMs, initializationDurationMs);
        }

        /* renamed from: a */
        public void mo26219a(Format format) {
            if (this.f18994b != null) {
                this.f18993a.post(new C8547a(this, format));
            }
        }

        /* renamed from: b */
        public /* synthetic */ void mo26225b(Format format) {
            this.f18994b.mo26212a(format);
        }

        /* renamed from: a */
        public void mo26217a(int droppedFrameCount, long elapsedMs) {
            if (this.f18994b != null) {
                this.f18993a.post(new C8553g(this, droppedFrameCount, elapsedMs));
            }
        }

        /* renamed from: b */
        public /* synthetic */ void mo26223b(int droppedFrameCount, long elapsedMs) {
            this.f18994b.mo26210a(droppedFrameCount, elapsedMs);
        }

        /* renamed from: b */
        public void mo26222b(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
            if (this.f18994b != null) {
                Handler handler = this.f18993a;
                C8549c cVar = new C8549c(this, width, height, unappliedRotationDegrees, pixelWidthHeightRatio);
                handler.post(cVar);
            }
        }

        /* renamed from: a */
        public /* synthetic */ void mo26216a(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
            this.f18994b.mo26209a(width, height, unappliedRotationDegrees, pixelWidthHeightRatio);
        }

        /* renamed from: b */
        public void mo26224b(Surface surface) {
            if (this.f18994b != null) {
                this.f18993a.post(new C8548b(this, surface));
            }
        }

        /* renamed from: a */
        public /* synthetic */ void mo26218a(Surface surface) {
            this.f18994b.mo26211a(surface);
        }

        /* renamed from: a */
        public void mo26220a(C8106d counters) {
            if (this.f18994b != null) {
                this.f18993a.post(new C8552f(this, counters));
            }
        }

        /* renamed from: c */
        public /* synthetic */ void mo26228c(C8106d counters) {
            counters.mo25029a();
            this.f18994b.mo26213a(counters);
        }
    }

    /* renamed from: a */
    void mo26209a(int i, int i2, int i3, float f);

    /* renamed from: a */
    void mo26210a(int i, long j);

    /* renamed from: a */
    void mo26211a(Surface surface);

    /* renamed from: a */
    void mo26212a(Format format);

    /* renamed from: a */
    void mo26213a(C8106d dVar);

    /* renamed from: a */
    void mo26214a(String str, long j, long j2);

    /* renamed from: b */
    void mo26215b(C8106d dVar);
}
