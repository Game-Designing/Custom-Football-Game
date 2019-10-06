package p024io.fabric.sdk.android.p348a.p350b;

import java.io.IOException;
import java.io.InputStream;
import p024io.fabric.sdk.android.p348a.p350b.C13832C.C13835c;

/* renamed from: io.fabric.sdk.android.a.b.B */
/* compiled from: QueueFile */
class C13831B implements C13835c {

    /* renamed from: a */
    boolean f41989a = true;

    /* renamed from: b */
    final /* synthetic */ StringBuilder f41990b;

    /* renamed from: c */
    final /* synthetic */ C13832C f41991c;

    C13831B(C13832C this$0, StringBuilder sb) {
        this.f41991c = this$0;
        this.f41990b = sb;
    }

    /* renamed from: a */
    public void mo19446a(InputStream in, int length) throws IOException {
        if (this.f41989a) {
            this.f41989a = false;
        } else {
            this.f41990b.append(", ");
        }
        this.f41990b.append(length);
    }
}
