package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.Handler */
class Handler {
    String desc;
    Label end;
    Label handler;
    Handler next;
    Label start;
    int type;

    Handler() {
    }

    static Handler remove(Handler h, Label start2, Label end2) {
        if (h == null) {
            return null;
        }
        h.next = remove(h.next, start2, end2);
        int hstart = h.start.position;
        int hend = h.end.position;
        int s = start2.position;
        int e = end2 == null ? MoPubClientPositioning.NO_REPEAT : end2.position;
        if (s < hend && e > hstart) {
            if (s <= hstart) {
                if (e >= hend) {
                    h = h.next;
                } else {
                    h.start = end2;
                }
            } else if (e >= hend) {
                h.end = start2;
            } else {
                Handler g = new Handler();
                g.start = end2;
                g.end = h.end;
                g.handler = h.handler;
                g.desc = h.desc;
                g.type = h.type;
                g.next = h.next;
                h.end = start2;
                h.next = g;
            }
        }
        return h;
    }
}
