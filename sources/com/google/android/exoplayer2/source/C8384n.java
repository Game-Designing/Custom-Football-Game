package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C8096B;
import com.google.android.exoplayer2.C8362o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p182a.C8107e;
import com.google.android.exoplayer2.p183b.C8181d;
import com.google.android.exoplayer2.p183b.C8260g;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8267n;
import com.google.android.exoplayer2.p183b.C8268o;
import com.google.android.exoplayer2.p183b.C8268o.C8269a;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.source.C8393q.C8394a;
import com.google.android.exoplayer2.source.C8398s.C8399a;
import com.google.android.exoplayer2.source.C8405u.C8407b;
import com.google.android.exoplayer2.trackselection.C8432h;
import com.google.android.exoplayer2.upstream.C8481d;
import com.google.android.exoplayer2.upstream.C8487i;
import com.google.android.exoplayer2.upstream.C8489j;
import com.google.android.exoplayer2.upstream.C8497q;
import com.google.android.exoplayer2.upstream.C8500t;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.C8454a;
import com.google.android.exoplayer2.upstream.Loader.C8455b;
import com.google.android.exoplayer2.upstream.Loader.C8457d;
import com.google.android.exoplayer2.upstream.Loader.C8458e;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8519i;
import com.google.android.exoplayer2.util.C8529q;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.source.n */
/* compiled from: ExtractorMediaPeriod */
final class C8384n implements C8393q, C8262i, C8454a<C8385a>, C8458e, C8407b {

    /* renamed from: A */
    private int f18215A;

    /* renamed from: B */
    private long f18216B;

    /* renamed from: C */
    private long f18217C;

    /* renamed from: D */
    private long f18218D;

    /* renamed from: E */
    private long f18219E;

    /* renamed from: F */
    private boolean f18220F;

    /* renamed from: G */
    private int f18221G;

    /* renamed from: H */
    private boolean f18222H;

    /* renamed from: I */
    private boolean f18223I;

    /* renamed from: a */
    private final Uri f18224a;

    /* renamed from: b */
    private final C8487i f18225b;

    /* renamed from: c */
    private final C8497q f18226c;

    /* renamed from: d */
    private final C8399a f18227d;

    /* renamed from: e */
    private final C8387c f18228e;

    /* renamed from: f */
    private final C8481d f18229f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final String f18230g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final long f18231h;

    /* renamed from: i */
    private final Loader f18232i = new Loader("Loader:ExtractorMediaPeriod");

    /* renamed from: j */
    private final C8386b f18233j;

    /* renamed from: k */
    private final C8519i f18234k;

    /* renamed from: l */
    private final Runnable f18235l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final Runnable f18236m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final Handler f18237n;

    /* renamed from: o */
    private C8394a f18238o;

    /* renamed from: p */
    private C8268o f18239p;

    /* renamed from: q */
    private C8405u[] f18240q;

    /* renamed from: r */
    private int[] f18241r;

    /* renamed from: s */
    private boolean f18242s;

    /* renamed from: t */
    private boolean f18243t;

    /* renamed from: u */
    private C8388d f18244u;

    /* renamed from: v */
    private boolean f18245v;

    /* renamed from: w */
    private int f18246w;

    /* renamed from: x */
    private boolean f18247x;

    /* renamed from: y */
    private boolean f18248y;

    /* renamed from: z */
    private boolean f18249z;

    /* renamed from: com.google.android.exoplayer2.source.n$a */
    /* compiled from: ExtractorMediaPeriod */
    final class C8385a implements C8457d {

        /* renamed from: a */
        private final Uri f18250a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final C8500t f18251b;

        /* renamed from: c */
        private final C8386b f18252c;

        /* renamed from: d */
        private final C8262i f18253d;

        /* renamed from: e */
        private final C8519i f18254e;

        /* renamed from: f */
        private final C8267n f18255f = new C8267n();

        /* renamed from: g */
        private volatile boolean f18256g;

        /* renamed from: h */
        private boolean f18257h = true;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public long f18258i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public C8489j f18259j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public long f18260k = -1;

        public C8385a(Uri uri, C8487i dataSource, C8386b extractorHolder, C8262i extractorOutput, C8519i loadCondition) {
            this.f18250a = uri;
            this.f18251b = new C8500t(dataSource);
            this.f18252c = extractorHolder;
            this.f18253d = extractorOutput;
            this.f18254e = loadCondition;
            C8489j jVar = new C8489j(uri, this.f18255f.f17510a, -1, C8384n.this.f18230g);
            this.f18259j = jVar;
        }

        /* renamed from: b */
        public void mo25715b() {
            this.f18256g = true;
        }

        /* renamed from: a */
        public void mo25714a() throws IOException, InterruptedException {
            int result = 0;
            while (result == 0 && !this.f18256g) {
                C8261h input = null;
                try {
                    long position = this.f18255f.f17510a;
                    C8489j jVar = new C8489j(this.f18250a, position, -1, C8384n.this.f18230g);
                    this.f18259j = jVar;
                    this.f18260k = this.f18251b.mo25917a(this.f18259j);
                    if (this.f18260k != -1) {
                        this.f18260k += position;
                    }
                    Uri uri = this.f18251b.getUri();
                    C8514e.m20486a(uri);
                    Uri uri2 = uri;
                    C8181d dVar = new C8181d(this.f18251b, position, this.f18260k);
                    C8181d dVar2 = dVar;
                    C8260g extractor = this.f18252c.mo25716a(dVar2, this.f18253d, uri2);
                    if (this.f18257h) {
                        extractor.mo25202a(position, this.f18258i);
                        this.f18257h = false;
                    }
                    while (result == 0 && !this.f18256g) {
                        this.f18254e.mo26077a();
                        result = extractor.mo25200a((C8261h) dVar2, this.f18255f);
                        if (dVar2.getPosition() > C8384n.this.f18231h + position) {
                            position = dVar2.getPosition();
                            this.f18254e.mo26078b();
                            C8384n.this.f18237n.post(C8384n.this.f18236m);
                        }
                    }
                    if (result == 1) {
                        result = 0;
                    } else {
                        this.f18255f.f17510a = dVar2.getPosition();
                    }
                    C8509F.m20450a((C8487i) this.f18251b);
                } catch (Throwable th) {
                    if (result != 1) {
                        if (input != null) {
                            this.f18255f.f17510a = input.getPosition();
                        }
                    }
                    C8509F.m20450a((C8487i) this.f18251b);
                    throw th;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m19860a(long position, long timeUs) {
            this.f18255f.f17510a = position;
            this.f18258i = timeUs;
            this.f18257h = true;
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.n$b */
    /* compiled from: ExtractorMediaPeriod */
    private static final class C8386b {

        /* renamed from: a */
        private final C8260g[] f18262a;

        /* renamed from: b */
        private C8260g f18263b;

        public C8386b(C8260g[] extractors) {
            this.f18262a = extractors;
        }

        /* renamed from: a */
        public C8260g mo25716a(C8261h input, C8262i output, Uri uri) throws IOException, InterruptedException {
            C8260g gVar = this.f18263b;
            if (gVar != null) {
                return gVar;
            }
            C8260g[] gVarArr = this.f18262a;
            int length = gVarArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                C8260g extractor = gVarArr[i];
                try {
                    if (extractor.mo25204a(input)) {
                        this.f18263b = extractor;
                        input.mo25239a();
                        break;
                    }
                    input.mo25239a();
                    i++;
                } catch (EOFException e) {
                } catch (Throwable th) {
                    input.mo25239a();
                    throw th;
                }
            }
            C8260g gVar2 = this.f18263b;
            if (gVar2 != null) {
                gVar2.mo25203a(output);
                return this.f18263b;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("None of the available extractors (");
            sb.append(C8509F.m20468b((Object[]) this.f18262a));
            sb.append(") could read the stream.");
            throw new UnrecognizedInputFormatException(sb.toString(), uri);
        }

        /* renamed from: a */
        public void mo25717a() {
            C8260g gVar = this.f18263b;
            if (gVar != null) {
                gVar.mo25201a();
                this.f18263b = null;
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.n$c */
    /* compiled from: ExtractorMediaPeriod */
    interface C8387c {
        /* renamed from: a */
        void mo25718a(long j, boolean z);
    }

    /* renamed from: com.google.android.exoplayer2.source.n$d */
    /* compiled from: ExtractorMediaPeriod */
    private static final class C8388d {

        /* renamed from: a */
        public final C8268o f18264a;

        /* renamed from: b */
        public final TrackGroupArray f18265b;

        /* renamed from: c */
        public final boolean[] f18266c;

        /* renamed from: d */
        public final boolean[] f18267d;

        /* renamed from: e */
        public final boolean[] f18268e;

        public C8388d(C8268o seekMap, TrackGroupArray tracks, boolean[] trackIsAudioVideoFlags) {
            this.f18264a = seekMap;
            this.f18265b = tracks;
            this.f18266c = trackIsAudioVideoFlags;
            int i = tracks.f18155b;
            this.f18267d = new boolean[i];
            this.f18268e = new boolean[i];
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.n$e */
    /* compiled from: ExtractorMediaPeriod */
    private final class C8389e implements C8408v {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final int f18269a;

        public C8389e(int track) {
            this.f18269a = track;
        }

        public boolean isReady() {
            return C8384n.this.mo25709a(this.f18269a);
        }

        /* renamed from: a */
        public void mo25697a() throws IOException {
            C8384n.this.mo25712i();
        }

        /* renamed from: a */
        public int mo25696a(C8362o formatHolder, C8107e buffer, boolean formatRequired) {
            return C8384n.this.mo25701a(this.f18269a, formatHolder, buffer, formatRequired);
        }

        /* renamed from: a */
        public int mo25695a(long positionUs) {
            return C8384n.this.mo25700a(this.f18269a, positionUs);
        }
    }

    public C8384n(Uri uri, C8487i dataSource, C8260g[] extractors, C8497q loadErrorHandlingPolicy, C8399a eventDispatcher, C8387c listener, C8481d allocator, String customCacheKey, int continueLoadingCheckIntervalBytes) {
        this.f18224a = uri;
        this.f18225b = dataSource;
        this.f18226c = loadErrorHandlingPolicy;
        this.f18227d = eventDispatcher;
        this.f18228e = listener;
        this.f18229f = allocator;
        this.f18230g = customCacheKey;
        this.f18231h = (long) continueLoadingCheckIntervalBytes;
        this.f18233j = new C8386b(extractors);
        this.f18234k = new C8519i();
        this.f18235l = new C8371b(this);
        this.f18236m = new C8367a(this);
        this.f18237n = new Handler();
        this.f18241r = new int[0];
        this.f18240q = new C8405u[0];
        this.f18219E = -9223372036854775807L;
        this.f18217C = -1;
        this.f18216B = -9223372036854775807L;
        this.f18246w = 1;
        eventDispatcher.mo25736a();
    }

    /* renamed from: h */
    public /* synthetic */ void mo25711h() {
        if (!this.f18223I) {
            C8394a aVar = this.f18238o;
            C8514e.m20486a(aVar);
            aVar.mo25491a(this);
        }
    }

    /* renamed from: j */
    public void mo25713j() {
        if (this.f18243t) {
            for (C8405u sampleQueue : this.f18240q) {
                sampleQueue.mo25779b();
            }
        }
        this.f18232i.mo25925a((C8458e) this);
        this.f18237n.removeCallbacksAndMessages(null);
        this.f18238o = null;
        this.f18223I = true;
        this.f18227d.mo25748b();
    }

    /* renamed from: f */
    public void mo25710f() {
        for (C8405u sampleQueue : this.f18240q) {
            sampleQueue.mo25787i();
        }
        this.f18233j.mo25717a();
    }

    /* renamed from: a */
    public void mo25686a(C8394a callback, long positionUs) {
        this.f18238o = callback;
        this.f18234k.mo26079c();
        m19828p();
    }

    /* renamed from: c */
    public void mo25690c() throws IOException {
        mo25712i();
    }

    /* renamed from: d */
    public TrackGroupArray mo25692d() {
        return m19825m().f18265b;
    }

    /* renamed from: a */
    public long mo25684a(C8432h[] selections, boolean[] mayRetainStreamFlags, C8408v[] streams, boolean[] streamResetFlags, long positionUs) {
        int i;
        boolean z;
        C8432h[] hVarArr = selections;
        C8408v[] vVarArr = streams;
        long positionUs2 = positionUs;
        C8388d preparedState = m19825m();
        TrackGroupArray tracks = preparedState.f18265b;
        boolean[] trackEnabledStates = preparedState.f18267d;
        int oldEnabledTrackCount = this.f18215A;
        int i2 = 0;
        while (true) {
            i = 0;
            z = true;
            if (i2 >= hVarArr.length) {
                break;
            }
            if (vVarArr[i2] != null && (hVarArr[i2] == null || !mayRetainStreamFlags[i2])) {
                int track = ((C8389e) vVarArr[i2]).f18269a;
                C8514e.m20490b(trackEnabledStates[track]);
                this.f18215A--;
                trackEnabledStates[track] = false;
                vVarArr[i2] = null;
            }
            i2++;
        }
        boolean seekRequired = this.f18247x == 0 ? positionUs2 != 0 : oldEnabledTrackCount == 0;
        int i3 = 0;
        while (i3 < hVarArr.length) {
            if (vVarArr[i3] == null && hVarArr[i3] != null) {
                C8432h selection = hVarArr[i3];
                C8514e.m20490b(selection.length() == z);
                C8514e.m20490b(selection.mo25833b(i) == 0);
                int track2 = tracks.mo25650a(selection.mo25834b());
                C8514e.m20490b(trackEnabledStates[track2] ^ z);
                this.f18215A += z ? 1 : 0;
                trackEnabledStates[track2] = z;
                vVarArr[i3] = new C8389e(track2);
                streamResetFlags[i3] = z;
                if (!seekRequired) {
                    C8405u sampleQueue = this.f18240q[track2];
                    sampleQueue.mo25788j();
                    seekRequired = sampleQueue.mo25775a(positionUs2, z, z) == -1 && sampleQueue.mo25782d() != 0;
                }
            }
            i3++;
            i = 0;
            z = true;
        }
        if (this.f18215A == 0) {
            int i4 = 0;
            this.f18220F = false;
            this.f18248y = false;
            if (this.f18232i.mo25926b()) {
                C8405u[] uVarArr = this.f18240q;
                int length = uVarArr.length;
                while (i4 < length) {
                    uVarArr[i4].mo25779b();
                    i4++;
                }
                this.f18232i.mo25923a();
            } else {
                C8405u[] uVarArr2 = this.f18240q;
                int length2 = uVarArr2.length;
                while (i4 < length2) {
                    uVarArr2[i4].mo25787i();
                    i4++;
                }
            }
        } else if (seekRequired) {
            positionUs2 = mo25682a(positionUs2);
            for (int i5 = 0; i5 < vVarArr.length; i5++) {
                if (vVarArr[i5] != null) {
                    streamResetFlags[i5] = true;
                }
            }
        }
        this.f18247x = true;
        return positionUs2;
    }

    /* renamed from: a */
    public void mo25685a(long positionUs, boolean toKeyframe) {
        if (!m19826n()) {
            boolean[] trackEnabledStates = m19825m().f18267d;
            int trackCount = this.f18240q.length;
            for (int i = 0; i < trackCount; i++) {
                this.f18240q[i].mo25780b(positionUs, toKeyframe, trackEnabledStates[i]);
            }
        }
    }

    /* renamed from: c */
    public void mo25691c(long positionUs) {
    }

    /* renamed from: b */
    public boolean mo25689b(long playbackPositionUs) {
        if (this.f18222H || this.f18220F || (this.f18243t && this.f18215A == 0)) {
            return false;
        }
        boolean continuedLoading = this.f18234k.mo26079c();
        if (!this.f18232i.mo25926b()) {
            m19828p();
            continuedLoading = true;
        }
        return continuedLoading;
    }

    /* renamed from: a */
    public long mo25681a() {
        if (this.f18215A == 0) {
            return Long.MIN_VALUE;
        }
        return mo25693e();
    }

    /* renamed from: b */
    public long mo25687b() {
        if (!this.f18249z) {
            this.f18227d.mo25753c();
            this.f18249z = true;
        }
        if (!this.f18248y || (!this.f18222H && m19823k() <= this.f18221G)) {
            return -9223372036854775807L;
        }
        this.f18248y = false;
        return this.f18218D;
    }

    /* renamed from: e */
    public long mo25693e() {
        boolean[] trackIsAudioVideoFlags = m19825m().f18266c;
        if (this.f18222H) {
            return Long.MIN_VALUE;
        }
        if (m19826n()) {
            return this.f18219E;
        }
        long largestQueuedTimestampUs = Long.MAX_VALUE;
        if (this.f18245v) {
            int trackCount = this.f18240q.length;
            for (int i = 0; i < trackCount; i++) {
                if (trackIsAudioVideoFlags[i] && !this.f18240q[i].mo25786h()) {
                    largestQueuedTimestampUs = Math.min(largestQueuedTimestampUs, this.f18240q[i].mo25781c());
                }
            }
        }
        if (largestQueuedTimestampUs == Long.MAX_VALUE) {
            largestQueuedTimestampUs = m19824l();
        }
        return largestQueuedTimestampUs == Long.MIN_VALUE ? this.f18218D : largestQueuedTimestampUs;
    }

    /* renamed from: a */
    public long mo25682a(long positionUs) {
        C8388d preparedState = m19825m();
        C8268o seekMap = preparedState.f18264a;
        boolean[] trackIsAudioVideoFlags = preparedState.f18266c;
        long positionUs2 = seekMap.mo25195d() ? positionUs : 0;
        this.f18248y = false;
        this.f18218D = positionUs2;
        if (m19826n()) {
            this.f18219E = positionUs2;
            return positionUs2;
        } else if (this.f18246w != 7 && m19816a(trackIsAudioVideoFlags, positionUs2)) {
            return positionUs2;
        } else {
            this.f18220F = false;
            this.f18219E = positionUs2;
            this.f18222H = false;
            if (this.f18232i.mo25926b()) {
                this.f18232i.mo25923a();
            } else {
                for (C8405u sampleQueue : this.f18240q) {
                    sampleQueue.mo25787i();
                }
            }
            return positionUs2;
        }
    }

    /* renamed from: a */
    public long mo25683a(long positionUs, C8096B seekParameters) {
        C8268o seekMap = m19825m().f18264a;
        if (!seekMap.mo25195d()) {
            return 0;
        }
        C8269a seekPoints = seekMap.mo25192a(positionUs);
        return C8509F.m20440a(positionUs, seekParameters, seekPoints.f17511a.f17516b, seekPoints.f17512b.f17516b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo25709a(int track) {
        return !m19829q() && (this.f18222H || this.f18240q[track].mo25785g());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo25712i() throws IOException {
        this.f18232i.mo25924a(this.f18226c.mo26031a(this.f18246w));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo25701a(int track, C8362o formatHolder, C8107e buffer, boolean formatRequired) {
        if (m19829q()) {
            return -3;
        }
        m19818b(track);
        int result = this.f18240q[track].mo25776a(formatHolder, buffer, formatRequired, this.f18222H, this.f18218D);
        if (result == -3) {
            m19820c(track);
        }
        return result;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo25700a(int track, long positionUs) {
        int skipCount;
        if (m19829q()) {
            return 0;
        }
        m19818b(track);
        C8405u sampleQueue = this.f18240q[track];
        if (!this.f18222H || positionUs <= sampleQueue.mo25781c()) {
            skipCount = sampleQueue.mo25775a(positionUs, true, true);
            if (skipCount == -1) {
                skipCount = 0;
            }
        } else {
            skipCount = sampleQueue.mo25774a();
        }
        if (skipCount == 0) {
            m19820c(track);
        }
        return skipCount;
    }

    /* renamed from: b */
    private void m19818b(int track) {
        C8388d preparedState = m19825m();
        boolean[] trackNotifiedDownstreamFormats = preparedState.f18268e;
        if (!trackNotifiedDownstreamFormats[track]) {
            Format trackFormat = preparedState.f18265b.mo25651a(track).mo25645a(0);
            this.f18227d.mo25737a(C8529q.m20545d(trackFormat.f16507g), trackFormat, 0, (Object) null, this.f18218D);
            trackNotifiedDownstreamFormats[track] = true;
        }
    }

    /* renamed from: c */
    private void m19820c(int track) {
        boolean[] trackIsAudioVideoFlags = m19825m().f18266c;
        if (this.f18220F && trackIsAudioVideoFlags[track] && !this.f18240q[track].mo25785g()) {
            this.f18219E = 0;
            this.f18220F = false;
            this.f18248y = true;
            this.f18218D = 0;
            this.f18221G = 0;
            for (C8405u sampleQueue : this.f18240q) {
                sampleQueue.mo25787i();
            }
            C8394a aVar = this.f18238o;
            C8514e.m20486a(aVar);
            aVar.mo25491a(this);
        }
    }

    /* renamed from: q */
    private boolean m19829q() {
        return this.f18248y || m19826n();
    }

    /* renamed from: a */
    public void mo25707a(C8385a loadable, long elapsedRealtimeMs, long loadDurationMs) {
        if (this.f18216B == -9223372036854775807L) {
            C8268o oVar = this.f18239p;
            C8514e.m20486a(oVar);
            C8268o seekMap = oVar;
            long largestQueuedTimestampUs = m19824l();
            this.f18216B = largestQueuedTimestampUs == Long.MIN_VALUE ? 0 : 10000 + largestQueuedTimestampUs;
            this.f18228e.mo25718a(this.f18216B, seekMap.mo25195d());
        }
        this.f18227d.mo25752b(loadable.f18259j, loadable.f18251b.mo26034c(), loadable.f18251b.mo26035d(), 1, -1, null, 0, null, loadable.f18258i, this.f18216B, elapsedRealtimeMs, loadDurationMs, loadable.f18251b.mo26033b());
        m19814a(loadable);
        this.f18222H = true;
        C8394a aVar = this.f18238o;
        C8514e.m20486a(aVar);
        aVar.mo25491a(this);
    }

    /* renamed from: a */
    public void mo25708a(C8385a loadable, long elapsedRealtimeMs, long loadDurationMs, boolean released) {
        this.f18227d.mo25746a(loadable.f18259j, loadable.f18251b.mo26034c(), loadable.f18251b.mo26035d(), 1, -1, null, 0, null, loadable.f18258i, this.f18216B, elapsedRealtimeMs, loadDurationMs, loadable.f18251b.mo26033b());
        if (!released) {
            m19814a(loadable);
            for (C8405u sampleQueue : this.f18240q) {
                sampleQueue.mo25787i();
            }
            if (this.f18215A > 0) {
                C8394a aVar = this.f18238o;
                C8514e.m20486a(aVar);
                aVar.mo25491a(this);
            }
        }
    }

    /* renamed from: a */
    public C8455b mo25703a(C8385a loadable, long elapsedRealtimeMs, long loadDurationMs, IOException error, int errorCount) {
        C8455b loadErrorAction;
        m19814a(loadable);
        long retryDelayMs = this.f18226c.mo26032a(this.f18246w, this.f18216B, error, errorCount);
        if (retryDelayMs == -9223372036854775807L) {
            loadErrorAction = Loader.f18610d;
            C8385a aVar = loadable;
        } else {
            int extractedSamplesCount = m19823k();
            loadErrorAction = m19815a(loadable, extractedSamplesCount) ? Loader.m20155a(extractedSamplesCount > this.f18221G, retryDelayMs) : Loader.f18609c;
        }
        this.f18227d.mo25747a(loadable.f18259j, loadable.f18251b.mo26034c(), loadable.f18251b.mo26035d(), 1, -1, null, 0, null, loadable.f18258i, this.f18216B, elapsedRealtimeMs, loadDurationMs, loadable.f18251b.mo26033b(), error, !loadErrorAction.mo25927a());
        return loadErrorAction;
    }

    /* renamed from: a */
    public C8272q mo25351a(int id, int type) {
        int trackCount = this.f18240q.length;
        for (int i = 0; i < trackCount; i++) {
            if (this.f18241r[i] == id) {
                return this.f18240q[i];
            }
        }
        C8405u trackOutput = new C8405u(this.f18229f);
        trackOutput.mo25777a((C8407b) this);
        this.f18241r = Arrays.copyOf(this.f18241r, trackCount + 1);
        this.f18241r[trackCount] = id;
        C8405u[] sampleQueues = (C8405u[]) Arrays.copyOf(this.f18240q, trackCount + 1);
        sampleQueues[trackCount] = trackOutput;
        C8509F.m20458a((T[]) sampleQueues);
        this.f18240q = sampleQueues;
        return trackOutput;
    }

    /* renamed from: g */
    public void mo25353g() {
        this.f18242s = true;
        this.f18237n.post(this.f18235l);
    }

    /* renamed from: a */
    public void mo25352a(C8268o seekMap) {
        this.f18239p = seekMap;
        this.f18237n.post(this.f18235l);
    }

    /* renamed from: a */
    public void mo25704a(Format format) {
        this.f18237n.post(this.f18235l);
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m19827o() {
        C8268o seekMap = this.f18239p;
        if (!this.f18223I && !this.f18243t && this.f18242s && seekMap != null) {
            C8405u[] uVarArr = this.f18240q;
            int length = uVarArr.length;
            int i = 0;
            while (i < length) {
                if (uVarArr[i].mo25783e() != null) {
                    i++;
                } else {
                    return;
                }
            }
            this.f18234k.mo26078b();
            int trackCount = this.f18240q.length;
            TrackGroup[] trackArray = new TrackGroup[trackCount];
            boolean[] trackIsAudioVideoFlags = new boolean[trackCount];
            this.f18216B = seekMap.mo25193b();
            int i2 = 0;
            while (true) {
                boolean isAudioVideo = true;
                if (i2 >= trackCount) {
                    break;
                }
                Format trackFormat = this.f18240q[i2].mo25783e();
                trackArray[i2] = new TrackGroup(trackFormat);
                String mimeType = trackFormat.f16507g;
                if (!C8529q.m20549h(mimeType) && !C8529q.m20547f(mimeType)) {
                    isAudioVideo = false;
                }
                trackIsAudioVideoFlags[i2] = isAudioVideo;
                this.f18245v |= isAudioVideo;
                i2++;
            }
            this.f18246w = (this.f18217C == -1 && seekMap.mo25193b() == -9223372036854775807L) ? 7 : 1;
            this.f18244u = new C8388d(seekMap, new TrackGroupArray(trackArray), trackIsAudioVideoFlags);
            this.f18243t = true;
            this.f18228e.mo25718a(this.f18216B, seekMap.mo25195d());
            C8394a aVar = this.f18238o;
            C8514e.m20486a(aVar);
            aVar.mo25488a(this);
        }
    }

    /* renamed from: m */
    private C8388d m19825m() {
        C8388d dVar = this.f18244u;
        C8514e.m20486a(dVar);
        return dVar;
    }

    /* renamed from: a */
    private void m19814a(C8385a loadable) {
        if (this.f18217C == -1) {
            this.f18217C = loadable.f18260k;
        }
    }

    /* renamed from: p */
    private void m19828p() {
        C8385a loadable = new C8385a(this.f18224a, this.f18225b, this.f18233j, this, this.f18234k);
        if (this.f18243t) {
            C8268o seekMap = m19825m().f18264a;
            C8514e.m20490b(m19826n());
            long j = this.f18216B;
            if (j == -9223372036854775807L || this.f18219E < j) {
                loadable.m19860a(seekMap.mo25192a(this.f18219E).f17511a.f17517c, this.f18219E);
                this.f18219E = -9223372036854775807L;
            } else {
                this.f18222H = true;
                this.f18219E = -9223372036854775807L;
                return;
            }
        }
        this.f18221G = m19823k();
        this.f18227d.mo25745a(loadable.f18259j, 1, -1, null, 0, null, loadable.f18258i, this.f18216B, this.f18232i.mo25922a(loadable, this, this.f18226c.mo26031a(this.f18246w)));
    }

    /* renamed from: a */
    private boolean m19815a(C8385a loadable, int currentExtractedSampleCount) {
        if (this.f18217C == -1) {
            C8268o oVar = this.f18239p;
            if (oVar == null || oVar.mo25193b() == -9223372036854775807L) {
                if (!this.f18243t || m19829q()) {
                    this.f18248y = this.f18243t;
                    this.f18218D = 0;
                    this.f18221G = 0;
                    for (C8405u sampleQueue : this.f18240q) {
                        sampleQueue.mo25787i();
                    }
                    loadable.m19860a(0, 0);
                    return true;
                }
                this.f18220F = true;
                return false;
            }
        }
        this.f18221G = currentExtractedSampleCount;
        return true;
    }

    /* renamed from: a */
    private boolean m19816a(boolean[] trackIsAudioVideoFlags, long positionUs) {
        int trackCount = this.f18240q.length;
        int i = 0;
        while (true) {
            boolean seekInsideQueue = true;
            if (i >= trackCount) {
                return true;
            }
            C8405u sampleQueue = this.f18240q[i];
            sampleQueue.mo25788j();
            if (sampleQueue.mo25775a(positionUs, true, false) == -1) {
                seekInsideQueue = false;
            }
            if (seekInsideQueue || (!trackIsAudioVideoFlags[i] && this.f18245v)) {
                i++;
            }
        }
        return false;
    }

    /* renamed from: k */
    private int m19823k() {
        int extractedSamplesCount = 0;
        for (C8405u sampleQueue : this.f18240q) {
            extractedSamplesCount += sampleQueue.mo25784f();
        }
        return extractedSamplesCount;
    }

    /* renamed from: l */
    private long m19824l() {
        long largestQueuedTimestampUs = Long.MIN_VALUE;
        for (C8405u sampleQueue : this.f18240q) {
            largestQueuedTimestampUs = Math.max(largestQueuedTimestampUs, sampleQueue.mo25781c());
        }
        return largestQueuedTimestampUs;
    }

    /* renamed from: n */
    private boolean m19826n() {
        return this.f18219E != -9223372036854775807L;
    }
}
