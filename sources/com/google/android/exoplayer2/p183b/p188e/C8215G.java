package com.google.android.exoplayer2.p183b.p188e;

import android.support.p001v7.widget.LinearLayoutManager;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.util.C8506D;
import com.google.android.exoplayer2.util.C8535t;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.b.e.G */
/* compiled from: TsPayloadReader */
public interface C8215G {

    /* renamed from: com.google.android.exoplayer2.b.e.G$a */
    /* compiled from: TsPayloadReader */
    public static final class C8216a {

        /* renamed from: a */
        public final String f17200a;

        /* renamed from: b */
        public final int f17201b;

        /* renamed from: c */
        public final byte[] f17202c;

        public C8216a(String language, int type, byte[] initializationData) {
            this.f17200a = language;
            this.f17201b = type;
            this.f17202c = initializationData;
        }
    }

    /* renamed from: com.google.android.exoplayer2.b.e.G$b */
    /* compiled from: TsPayloadReader */
    public static final class C8217b {

        /* renamed from: a */
        public final int f17203a;

        /* renamed from: b */
        public final String f17204b;

        /* renamed from: c */
        public final List<C8216a> f17205c;

        /* renamed from: d */
        public final byte[] f17206d;

        public C8217b(int streamType, String language, List<C8216a> dvbSubtitleInfos, byte[] descriptorBytes) {
            List<C8216a> list;
            this.f17203a = streamType;
            this.f17204b = language;
            if (dvbSubtitleInfos == null) {
                list = Collections.emptyList();
            } else {
                list = Collections.unmodifiableList(dvbSubtitleInfos);
            }
            this.f17205c = list;
            this.f17206d = descriptorBytes;
        }
    }

    /* renamed from: com.google.android.exoplayer2.b.e.G$c */
    /* compiled from: TsPayloadReader */
    public interface C8218c {
        /* renamed from: a */
        SparseArray<C8215G> mo25296a();

        /* renamed from: a */
        C8215G mo25297a(int i, C8217b bVar);
    }

    /* renamed from: com.google.android.exoplayer2.b.e.G$d */
    /* compiled from: TsPayloadReader */
    public static final class C8219d {

        /* renamed from: a */
        private final String f17207a;

        /* renamed from: b */
        private final int f17208b;

        /* renamed from: c */
        private final int f17209c;

        /* renamed from: d */
        private int f17210d;

        /* renamed from: e */
        private String f17211e;

        public C8219d(int firstTrackId, int trackIdIncrement) {
            this(LinearLayoutManager.INVALID_OFFSET, firstTrackId, trackIdIncrement);
        }

        public C8219d(int programNumber, int firstTrackId, int trackIdIncrement) {
            String str;
            if (programNumber != Integer.MIN_VALUE) {
                StringBuilder sb = new StringBuilder();
                sb.append(programNumber);
                sb.append("/");
                str = sb.toString();
            } else {
                str = "";
            }
            this.f17207a = str;
            this.f17208b = firstTrackId;
            this.f17209c = trackIdIncrement;
            this.f17210d = LinearLayoutManager.INVALID_OFFSET;
        }

        /* renamed from: a */
        public void mo25298a() {
            int i = this.f17210d;
            this.f17210d = i == Integer.MIN_VALUE ? this.f17208b : i + this.f17209c;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f17207a);
            sb.append(this.f17210d);
            this.f17211e = sb.toString();
        }

        /* renamed from: c */
        public int mo25300c() {
            m18946d();
            return this.f17210d;
        }

        /* renamed from: b */
        public String mo25299b() {
            m18946d();
            return this.f17211e;
        }

        /* renamed from: d */
        private void m18946d() {
            if (this.f17210d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }

    /* renamed from: a */
    void mo25285a();

    /* renamed from: a */
    void mo25286a(C8506D d, C8262i iVar, C8219d dVar);

    /* renamed from: a */
    void mo25287a(C8535t tVar, int i) throws ParserException;
}
