package com.google.android.exoplayer2.audio;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p182a.C8106d;
import com.google.android.exoplayer2.util.C8514e;

/* renamed from: com.google.android.exoplayer2.audio.l */
/* compiled from: AudioRendererEventListener */
public interface C8128l {

    /* renamed from: com.google.android.exoplayer2.audio.l$a */
    /* compiled from: AudioRendererEventListener */
    public static final class C8129a {

        /* renamed from: a */
        private final Handler f16679a;

        /* renamed from: b */
        private final C8128l f16680b;

        public C8129a(Handler handler, C8128l listener) {
            Handler handler2;
            if (listener != null) {
                C8514e.m20486a(handler);
                handler2 = handler;
            } else {
                handler2 = null;
            }
            this.f16679a = handler2;
            this.f16680b = listener;
        }

        /* renamed from: b */
        public void mo25108b(C8106d decoderCounters) {
            if (this.f16680b != null) {
                this.f16679a.post(new C8117c(this, decoderCounters));
            }
        }

        /* renamed from: d */
        public /* synthetic */ void mo25111d(C8106d decoderCounters) {
            this.f16680b.mo25097a(decoderCounters);
        }

        /* renamed from: a */
        public void mo25104a(String decoderName, long initializedTimestampMs, long initializationDurationMs) {
            if (this.f16680b != null) {
                Handler handler = this.f16679a;
                C8116b bVar = new C8116b(this, decoderName, initializedTimestampMs, initializationDurationMs);
                handler.post(bVar);
            }
        }

        /* renamed from: b */
        public /* synthetic */ void mo25109b(String decoderName, long initializedTimestampMs, long initializationDurationMs) {
            this.f16680b.mo25098a(decoderName, initializedTimestampMs, initializationDurationMs);
        }

        /* renamed from: a */
        public void mo25102a(Format format) {
            if (this.f16680b != null) {
                this.f16679a.post(new C8115a(this, format));
            }
        }

        /* renamed from: b */
        public /* synthetic */ void mo25107b(Format format) {
            this.f16680b.mo25096a(format);
        }

        /* renamed from: a */
        public void mo25101a(int bufferSize, long bufferSizeMs, long elapsedSinceLastFeedMs) {
            if (this.f16680b != null) {
                Handler handler = this.f16679a;
                C8120f fVar = new C8120f(this, bufferSize, bufferSizeMs, elapsedSinceLastFeedMs);
                handler.post(fVar);
            }
        }

        /* renamed from: b */
        public /* synthetic */ void mo25106b(int bufferSize, long bufferSizeMs, long elapsedSinceLastFeedMs) {
            this.f16680b.mo25095a(bufferSize, bufferSizeMs, elapsedSinceLastFeedMs);
        }

        /* renamed from: a */
        public void mo25103a(C8106d counters) {
            if (this.f16680b != null) {
                this.f16679a.post(new C8119e(this, counters));
            }
        }

        /* renamed from: c */
        public /* synthetic */ void mo25110c(C8106d counters) {
            counters.mo25029a();
            this.f16680b.mo25099b(counters);
        }

        /* renamed from: a */
        public void mo25100a(int audioSessionId) {
            if (this.f16680b != null) {
                this.f16679a.post(new C8118d(this, audioSessionId));
            }
        }

        /* renamed from: b */
        public /* synthetic */ void mo25105b(int audioSessionId) {
            this.f16680b.mo25094a(audioSessionId);
        }
    }

    /* renamed from: a */
    void mo25094a(int i);

    /* renamed from: a */
    void mo25095a(int i, long j, long j2);

    /* renamed from: a */
    void mo25096a(Format format);

    /* renamed from: a */
    void mo25097a(C8106d dVar);

    /* renamed from: a */
    void mo25098a(String str, long j, long j2);

    /* renamed from: b */
    void mo25099b(C8106d dVar);
}
