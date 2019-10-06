package com.google.android.exoplayer2.p183b.p187d;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p183b.C8260g;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8263j;
import com.google.android.exoplayer2.p183b.C8267n;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.b.d.e */
/* compiled from: OggExtractor */
public class C8188e implements C8260g {

    /* renamed from: a */
    public static final C8263j f17064a = C8182a.f17043a;

    /* renamed from: b */
    private C8262i f17065b;

    /* renamed from: c */
    private C8194k f17066c;

    /* renamed from: d */
    private boolean f17067d;

    /* renamed from: b */
    static /* synthetic */ C8260g[] m18826b() {
        return new C8260g[]{new C8188e()};
    }

    /* renamed from: a */
    public boolean mo25204a(C8261h input) throws IOException, InterruptedException {
        try {
            return m18825b(input);
        } catch (ParserException e) {
            return false;
        }
    }

    /* renamed from: a */
    public void mo25203a(C8262i output) {
        this.f17065b = output;
    }

    /* renamed from: a */
    public void mo25202a(long position, long timeUs) {
        C8194k kVar = this.f17066c;
        if (kVar != null) {
            kVar.mo25276a(position, timeUs);
        }
    }

    /* renamed from: a */
    public void mo25201a() {
    }

    /* renamed from: a */
    public int mo25200a(C8261h input, C8267n seekPosition) throws IOException, InterruptedException {
        if (this.f17066c == null) {
            if (m18825b(input)) {
                input.mo25239a();
            } else {
                throw new ParserException("Failed to determine bitstream type");
            }
        }
        if (!this.f17067d) {
            C8272q trackOutput = this.f17065b.mo25351a(0, 1);
            this.f17065b.mo25353g();
            this.f17066c.mo25277a(this.f17065b, trackOutput);
            this.f17067d = true;
        }
        return this.f17066c.mo25274a(input, seekPosition);
    }

    /* renamed from: b */
    private boolean m18825b(C8261h input) throws IOException, InterruptedException {
        C8190g header = new C8190g();
        if (!header.mo25273a(input, true) || (header.f17075c & 2) != 2) {
            return false;
        }
        int length = Math.min(header.f17082j, 8);
        C8535t scratch = new C8535t(length);
        input.mo25241a(scratch.f18861a, 0, length);
        m18824a(scratch);
        if (C8186d.m18811b(scratch)) {
            this.f17066c = new C8186d();
        } else {
            m18824a(scratch);
            if (C8198m.m18871c(scratch)) {
                this.f17066c = new C8198m();
            } else {
                m18824a(scratch);
                if (!C8192i.m18845b(scratch)) {
                    return false;
                }
                this.f17066c = new C8192i();
            }
        }
        return true;
    }

    /* renamed from: a */
    private static C8535t m18824a(C8535t scratch) {
        scratch.mo26118e(0);
        return scratch;
    }
}
