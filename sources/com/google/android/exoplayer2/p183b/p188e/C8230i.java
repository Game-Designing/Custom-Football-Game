package com.google.android.exoplayer2.p183b.p188e;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8217b;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8218c;
import com.google.android.exoplayer2.text.p190a.C8416a;
import com.google.android.exoplayer2.util.C8535t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.RemoteControlWriter;

/* renamed from: com.google.android.exoplayer2.b.e.i */
/* compiled from: DefaultTsPayloadReaderFactory */
public final class C8230i implements C8218c {

    /* renamed from: a */
    private final int f17273a;

    /* renamed from: b */
    private final List<Format> f17274b;

    public C8230i(int flags) {
        this(flags, Collections.singletonList(Format.m18243a(null, "application/cea-608", 0, null)));
    }

    public C8230i(int flags, List<Format> closedCaptionFormats) {
        this.f17273a = flags;
        this.f17274b = closedCaptionFormats;
    }

    /* renamed from: a */
    public SparseArray<C8215G> mo25296a() {
        return new SparseArray<>();
    }

    /* renamed from: a */
    public C8215G mo25297a(int streamType, C8217b esInfo) {
        if (streamType == 2) {
            return new C8246u(new C8234m(m19004b(esInfo)));
        }
        if (streamType == 3 || streamType == 4) {
            return new C8246u(new C8244s(esInfo.f17204b));
        }
        C8215G g = null;
        if (streamType == 15) {
            if (!m19003a(2)) {
                g = new C8246u(new C8229h(false, esInfo.f17204b));
            }
            return g;
        } else if (streamType == 17) {
            if (!m19003a(2)) {
                g = new C8246u(new C8243r(esInfo.f17204b));
            }
            return g;
        } else if (streamType == 21) {
            return new C8246u(new C8242q());
        } else {
            if (streamType == 27) {
                if (!m19003a(4)) {
                    g = new C8246u(new C8237o(m19002a(esInfo), m19003a(1), m19003a(8)));
                }
                return g;
            } else if (streamType == 36) {
                return new C8246u(new C8240p(m19002a(esInfo)));
            } else {
                if (streamType == 89) {
                    return new C8246u(new C8232k(esInfo.f17205c));
                }
                if (streamType != 138) {
                    if (streamType != 129) {
                        if (streamType != 130) {
                            if (streamType == 134) {
                                if (!m19003a(16)) {
                                    g = new C8206A(new C8208C());
                                }
                                return g;
                            } else if (streamType != 135) {
                                return null;
                            }
                        } else if (m19003a(64)) {
                            return null;
                        }
                    }
                    return new C8246u(new C8227f(esInfo.f17204b));
                }
                return new C8246u(new C8231j(esInfo.f17204b));
            }
        }
    }

    /* renamed from: a */
    private C8207B m19002a(C8217b esInfo) {
        return new C8207B(m19005c(esInfo));
    }

    /* renamed from: b */
    private C8221I m19004b(C8217b esInfo) {
        return new C8221I(m19005c(esInfo));
    }

    /* renamed from: c */
    private List<Format> m19005c(C8217b esInfo) {
        int accessibilityChannel;
        String mimeType;
        if (m19003a(32)) {
            return this.f17274b;
        }
        C8535t scratchDescriptorData = new C8535t(esInfo.f17206d);
        List<Format> closedCaptionFormats = this.f17274b;
        while (scratchDescriptorData.mo26104a() > 0) {
            int nextDescriptorPosition = scratchDescriptorData.mo26113c() + scratchDescriptorData.mo26131q();
            if (scratchDescriptorData.mo26131q() == 134) {
                closedCaptionFormats = new ArrayList<>();
                int numberOfServices = scratchDescriptorData.mo26131q() & 31;
                for (int i = 0; i < numberOfServices; i++) {
                    String language = scratchDescriptorData.mo26112b(3);
                    int captionTypeByte = scratchDescriptorData.mo26131q();
                    boolean isWideAspectRatio = false;
                    boolean isDigital = (captionTypeByte & 128) != 0;
                    if (isDigital) {
                        mimeType = "application/cea-708";
                        accessibilityChannel = captionTypeByte & 63;
                    } else {
                        mimeType = "application/cea-608";
                        accessibilityChannel = 1;
                    }
                    byte flags = (byte) scratchDescriptorData.mo26131q();
                    scratchDescriptorData.mo26120f(1);
                    List<byte[]> initializationData = null;
                    if (isDigital) {
                        if ((flags & RemoteControlWriter.BLOCK_CMDDUMP) != 0) {
                            isWideAspectRatio = true;
                        }
                        initializationData = C8416a.m20010a(isWideAspectRatio);
                    }
                    byte b = flags;
                    int i2 = captionTypeByte;
                    closedCaptionFormats.add(Format.m18251a(null, mimeType, null, -1, 0, language, accessibilityChannel, null, Long.MAX_VALUE, initializationData));
                }
            }
            scratchDescriptorData.mo26118e(nextDescriptorPosition);
        }
        return closedCaptionFormats;
    }

    /* renamed from: a */
    private boolean m19003a(int flag) {
        return (this.f17273a & flag) != 0;
    }
}
