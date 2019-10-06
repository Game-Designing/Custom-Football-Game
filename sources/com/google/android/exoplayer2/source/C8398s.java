package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.C8275d;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.C8395r.C8396a;
import com.google.android.exoplayer2.upstream.C8489j;
import com.google.android.exoplayer2.util.C8514e;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.google.android.exoplayer2.source.s */
/* compiled from: MediaSourceEventListener */
public interface C8398s {

    /* renamed from: com.google.android.exoplayer2.source.s$a */
    /* compiled from: MediaSourceEventListener */
    public static final class C8399a {

        /* renamed from: a */
        public final int f18293a;

        /* renamed from: b */
        public final C8396a f18294b;

        /* renamed from: c */
        private final CopyOnWriteArrayList<C8400a> f18295c;

        /* renamed from: d */
        private final long f18296d;

        /* renamed from: com.google.android.exoplayer2.source.s$a$a */
        /* compiled from: MediaSourceEventListener */
        private static final class C8400a {

            /* renamed from: a */
            public final Handler f18297a;

            /* renamed from: b */
            public final C8398s f18298b;
        }

        public C8399a() {
            this(new CopyOnWriteArrayList(), 0, null, 0);
        }

        private C8399a(CopyOnWriteArrayList<C8400a> listenerAndHandlers, int windowIndex, C8396a mediaPeriodId, long mediaTimeOffsetMs) {
            this.f18295c = listenerAndHandlers;
            this.f18293a = windowIndex;
            this.f18294b = mediaPeriodId;
            this.f18296d = mediaTimeOffsetMs;
        }

        /* renamed from: a */
        public C8399a mo25735a(int windowIndex, C8396a mediaPeriodId, long mediaTimeOffsetMs) {
            C8399a aVar = new C8399a(this.f18295c, windowIndex, mediaPeriodId, mediaTimeOffsetMs);
            return aVar;
        }

        /* renamed from: a */
        public void mo25736a() {
            C8396a aVar = this.f18294b;
            C8514e.m20486a(aVar);
            C8396a mediaPeriodId = aVar;
            Iterator it = this.f18295c.iterator();
            while (it.hasNext()) {
                C8400a listenerAndHandler = (C8400a) it.next();
                m19912a(listenerAndHandler.f18297a, (Runnable) new C8376g(this, listenerAndHandler.f18298b, mediaPeriodId));
            }
        }

        /* renamed from: a */
        public /* synthetic */ void mo25741a(C8398s listener, C8396a mediaPeriodId) {
            listener.mo25727a(this.f18293a, mediaPeriodId);
        }

        /* renamed from: b */
        public void mo25748b() {
            C8396a aVar = this.f18294b;
            C8514e.m20486a(aVar);
            C8396a mediaPeriodId = aVar;
            Iterator it = this.f18295c.iterator();
            while (it.hasNext()) {
                C8400a listenerAndHandler = (C8400a) it.next();
                m19912a(listenerAndHandler.f18297a, (Runnable) new C8379j(this, listenerAndHandler.f18298b, mediaPeriodId));
            }
        }

        /* renamed from: b */
        public /* synthetic */ void mo25750b(C8398s listener, C8396a mediaPeriodId) {
            listener.mo25733c(this.f18293a, mediaPeriodId);
        }

        /* renamed from: a */
        public void mo25745a(C8489j dataSpec, int dataType, int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaStartTimeUs, long mediaEndTimeUs, long elapsedRealtimeMs) {
            C8401b bVar = new C8401b(dataSpec, dataSpec.f18714a, Collections.emptyMap(), elapsedRealtimeMs, 0, 0);
            C8402c cVar = new C8402c(dataType, trackType, trackFormat, trackSelectionReason, trackSelectionData, m19911a(mediaStartTimeUs), m19911a(mediaEndTimeUs));
            mo25754c(bVar, cVar);
        }

        /* renamed from: c */
        public void mo25754c(C8401b loadEventInfo, C8402c mediaLoadData) {
            Iterator it = this.f18295c.iterator();
            while (it.hasNext()) {
                C8400a listenerAndHandler = (C8400a) it.next();
                m19912a(listenerAndHandler.f18297a, (Runnable) new C8378i(this, listenerAndHandler.f18298b, loadEventInfo, mediaLoadData));
            }
        }

        /* renamed from: c */
        public /* synthetic */ void mo25756c(C8398s listener, C8401b loadEventInfo, C8402c mediaLoadData) {
            listener.mo25728a(this.f18293a, this.f18294b, loadEventInfo, mediaLoadData);
        }

        /* renamed from: b */
        public void mo25752b(C8489j dataSpec, Uri uri, Map<String, List<String>> responseHeaders, int dataType, int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaStartTimeUs, long mediaEndTimeUs, long elapsedRealtimeMs, long loadDurationMs, long bytesLoaded) {
            C8401b bVar = new C8401b(dataSpec, uri, responseHeaders, elapsedRealtimeMs, loadDurationMs, bytesLoaded);
            C8402c cVar = new C8402c(dataType, trackType, trackFormat, trackSelectionReason, trackSelectionData, m19911a(mediaStartTimeUs), m19911a(mediaEndTimeUs));
            mo25749b(bVar, cVar);
        }

        /* renamed from: b */
        public void mo25749b(C8401b loadEventInfo, C8402c mediaLoadData) {
            Iterator it = this.f18295c.iterator();
            while (it.hasNext()) {
                C8400a listenerAndHandler = (C8400a) it.next();
                m19912a(listenerAndHandler.f18297a, (Runnable) new C8375f(this, listenerAndHandler.f18298b, loadEventInfo, mediaLoadData));
            }
        }

        /* renamed from: b */
        public /* synthetic */ void mo25751b(C8398s listener, C8401b loadEventInfo, C8402c mediaLoadData) {
            listener.mo25732b(this.f18293a, this.f18294b, loadEventInfo, mediaLoadData);
        }

        /* renamed from: a */
        public void mo25746a(C8489j dataSpec, Uri uri, Map<String, List<String>> responseHeaders, int dataType, int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaStartTimeUs, long mediaEndTimeUs, long elapsedRealtimeMs, long loadDurationMs, long bytesLoaded) {
            C8401b bVar = new C8401b(dataSpec, uri, responseHeaders, elapsedRealtimeMs, loadDurationMs, bytesLoaded);
            C8402c cVar = new C8402c(dataType, trackType, trackFormat, trackSelectionReason, trackSelectionData, m19911a(mediaStartTimeUs), m19911a(mediaEndTimeUs));
            mo25738a(bVar, cVar);
        }

        /* renamed from: a */
        public void mo25738a(C8401b loadEventInfo, C8402c mediaLoadData) {
            Iterator it = this.f18295c.iterator();
            while (it.hasNext()) {
                C8400a listenerAndHandler = (C8400a) it.next();
                m19912a(listenerAndHandler.f18297a, (Runnable) new C8373d(this, listenerAndHandler.f18298b, loadEventInfo, mediaLoadData));
            }
        }

        /* renamed from: a */
        public /* synthetic */ void mo25742a(C8398s listener, C8401b loadEventInfo, C8402c mediaLoadData) {
            listener.mo25734c(this.f18293a, this.f18294b, loadEventInfo, mediaLoadData);
        }

        /* renamed from: a */
        public void mo25747a(C8489j dataSpec, Uri uri, Map<String, List<String>> responseHeaders, int dataType, int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaStartTimeUs, long mediaEndTimeUs, long elapsedRealtimeMs, long loadDurationMs, long bytesLoaded, IOException error, boolean wasCanceled) {
            C8401b bVar = new C8401b(dataSpec, uri, responseHeaders, elapsedRealtimeMs, loadDurationMs, bytesLoaded);
            C8402c cVar = new C8402c(dataType, trackType, trackFormat, trackSelectionReason, trackSelectionData, m19911a(mediaStartTimeUs), m19911a(mediaEndTimeUs));
            mo25739a(bVar, cVar, error, wasCanceled);
        }

        /* renamed from: a */
        public void mo25739a(C8401b loadEventInfo, C8402c mediaLoadData, IOException error, boolean wasCanceled) {
            Iterator it = this.f18295c.iterator();
            while (it.hasNext()) {
                C8400a listenerAndHandler = (C8400a) it.next();
                C8398s listener = listenerAndHandler.f18298b;
                Handler handler = listenerAndHandler.f18297a;
                C8372c cVar = new C8372c(this, listener, loadEventInfo, mediaLoadData, error, wasCanceled);
                m19912a(handler, (Runnable) cVar);
            }
        }

        /* renamed from: a */
        public /* synthetic */ void mo25743a(C8398s listener, C8401b loadEventInfo, C8402c mediaLoadData, IOException error, boolean wasCanceled) {
            listener.mo25729a(this.f18293a, this.f18294b, loadEventInfo, mediaLoadData, error, wasCanceled);
        }

        /* renamed from: c */
        public void mo25753c() {
            C8396a aVar = this.f18294b;
            C8514e.m20486a(aVar);
            C8396a mediaPeriodId = aVar;
            Iterator it = this.f18295c.iterator();
            while (it.hasNext()) {
                C8400a listenerAndHandler = (C8400a) it.next();
                m19912a(listenerAndHandler.f18297a, (Runnable) new C8377h(this, listenerAndHandler.f18298b, mediaPeriodId));
            }
        }

        /* renamed from: c */
        public /* synthetic */ void mo25755c(C8398s listener, C8396a mediaPeriodId) {
            listener.mo25731b(this.f18293a, mediaPeriodId);
        }

        /* renamed from: a */
        public void mo25737a(int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaTimeUs) {
            C8402c cVar = new C8402c(1, trackType, trackFormat, trackSelectionReason, trackSelectionData, m19911a(mediaTimeUs), -9223372036854775807L);
            mo25740a(cVar);
        }

        /* renamed from: a */
        public void mo25740a(C8402c mediaLoadData) {
            Iterator it = this.f18295c.iterator();
            while (it.hasNext()) {
                C8400a listenerAndHandler = (C8400a) it.next();
                m19912a(listenerAndHandler.f18297a, (Runnable) new C8374e(this, listenerAndHandler.f18298b, mediaLoadData));
            }
        }

        /* renamed from: a */
        public /* synthetic */ void mo25744a(C8398s listener, C8402c mediaLoadData) {
            listener.mo25730a(this.f18293a, this.f18294b, mediaLoadData);
        }

        /* renamed from: a */
        private long m19911a(long mediaTimeUs) {
            long mediaTimeMs = C8275d.m19231b(mediaTimeUs);
            if (mediaTimeMs == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f18296d + mediaTimeMs;
        }

        /* renamed from: a */
        private void m19912a(Handler handler, Runnable runnable) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.s$b */
    /* compiled from: MediaSourceEventListener */
    public static final class C8401b {

        /* renamed from: a */
        public final C8489j f18299a;

        /* renamed from: b */
        public final Uri f18300b;

        /* renamed from: c */
        public final Map<String, List<String>> f18301c;

        /* renamed from: d */
        public final long f18302d;

        /* renamed from: e */
        public final long f18303e;

        /* renamed from: f */
        public final long f18304f;

        public C8401b(C8489j dataSpec, Uri uri, Map<String, List<String>> responseHeaders, long elapsedRealtimeMs, long loadDurationMs, long bytesLoaded) {
            this.f18299a = dataSpec;
            this.f18300b = uri;
            this.f18301c = responseHeaders;
            this.f18302d = elapsedRealtimeMs;
            this.f18303e = loadDurationMs;
            this.f18304f = bytesLoaded;
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.s$c */
    /* compiled from: MediaSourceEventListener */
    public static final class C8402c {

        /* renamed from: a */
        public final int f18305a;

        /* renamed from: b */
        public final int f18306b;

        /* renamed from: c */
        public final Format f18307c;

        /* renamed from: d */
        public final int f18308d;

        /* renamed from: e */
        public final Object f18309e;

        /* renamed from: f */
        public final long f18310f;

        /* renamed from: g */
        public final long f18311g;

        public C8402c(int dataType, int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaStartTimeMs, long mediaEndTimeMs) {
            this.f18305a = dataType;
            this.f18306b = trackType;
            this.f18307c = trackFormat;
            this.f18308d = trackSelectionReason;
            this.f18309e = trackSelectionData;
            this.f18310f = mediaStartTimeMs;
            this.f18311g = mediaEndTimeMs;
        }
    }

    /* renamed from: a */
    void mo25727a(int i, C8396a aVar);

    /* renamed from: a */
    void mo25728a(int i, C8396a aVar, C8401b bVar, C8402c cVar);

    /* renamed from: a */
    void mo25729a(int i, C8396a aVar, C8401b bVar, C8402c cVar, IOException iOException, boolean z);

    /* renamed from: a */
    void mo25730a(int i, C8396a aVar, C8402c cVar);

    /* renamed from: b */
    void mo25731b(int i, C8396a aVar);

    /* renamed from: b */
    void mo25732b(int i, C8396a aVar, C8401b bVar, C8402c cVar);

    /* renamed from: c */
    void mo25733c(int i, C8396a aVar);

    /* renamed from: c */
    void mo25734c(int i, C8396a aVar, C8401b bVar, C8402c cVar);
}
