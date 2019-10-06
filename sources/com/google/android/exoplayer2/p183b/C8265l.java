package com.google.android.exoplayer2.p183b;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.C8353h;
import com.google.android.exoplayer2.metadata.id3.C8353h.C8354a;
import com.google.android.exoplayer2.util.C8535t;
import java.io.EOFException;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.b.l */
/* compiled from: Id3Peeker */
public final class C8265l {

    /* renamed from: a */
    private final C8535t f17495a = new C8535t(10);

    /* renamed from: a */
    public Metadata mo25357a(C8261h input, C8354a id3FramePredicate) throws IOException, InterruptedException {
        int peekedId3Bytes = 0;
        Metadata metadata = null;
        while (true) {
            try {
                input.mo25241a(this.f17495a.f18861a, 0, 10);
                this.f17495a.mo26118e(0);
                if (this.f17495a.mo26134t() != C8353h.f18112b) {
                    break;
                }
                this.f17495a.mo26120f(3);
                int framesLength = this.f17495a.mo26130p();
                int tagLength = framesLength + 10;
                if (metadata == null) {
                    byte[] id3Data = new byte[tagLength];
                    System.arraycopy(this.f17495a.f18861a, 0, id3Data, 0, 10);
                    input.mo25241a(id3Data, 10, framesLength);
                    metadata = new C8353h(id3FramePredicate).mo25596a(id3Data, tagLength);
                } else {
                    input.mo25240a(framesLength);
                }
                peekedId3Bytes += tagLength;
            } catch (EOFException e) {
            }
        }
        input.mo25239a();
        input.mo25240a(peekedId3Bytes);
        return metadata;
    }
}
