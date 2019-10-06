package com.trello.rxlifecycle.p263a;

import com.trello.rxlifecycle.OutsideLifecycleException;
import p026rx.p027b.C0132p;

/* renamed from: com.trello.rxlifecycle.a.d */
/* compiled from: RxLifecycleAndroid */
class C12545d implements C0132p<C12543b, C12543b> {
    C12545d() {
    }

    /* renamed from: a */
    public C12543b call(C12543b lastEvent) {
        switch (C12546e.f39009b[lastEvent.ordinal()]) {
            case 1:
                return C12543b.DETACH;
            case 2:
                return C12543b.DESTROY;
            case 3:
                return C12543b.DESTROY_VIEW;
            case 4:
                return C12543b.STOP;
            case 5:
                return C12543b.PAUSE;
            case 6:
                return C12543b.STOP;
            case 7:
                return C12543b.DESTROY_VIEW;
            case 8:
                return C12543b.DESTROY;
            case 9:
                return C12543b.DETACH;
            case 10:
                throw new OutsideLifecycleException("Cannot bind to Fragment lifecycle when outside of it.");
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Binding to ");
                sb.append(lastEvent);
                sb.append(" not yet implemented");
                throw new UnsupportedOperationException(sb.toString());
        }
    }
}
