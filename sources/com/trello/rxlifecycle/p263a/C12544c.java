package com.trello.rxlifecycle.p263a;

import com.trello.rxlifecycle.OutsideLifecycleException;
import p026rx.p027b.C0132p;

/* renamed from: com.trello.rxlifecycle.a.c */
/* compiled from: RxLifecycleAndroid */
class C12544c implements C0132p<C12542a, C12542a> {
    C12544c() {
    }

    /* renamed from: a */
    public C12542a call(C12542a lastEvent) {
        switch (C12546e.f39008a[lastEvent.ordinal()]) {
            case 1:
                return C12542a.DESTROY;
            case 2:
                return C12542a.STOP;
            case 3:
                return C12542a.PAUSE;
            case 4:
                return C12542a.STOP;
            case 5:
                return C12542a.DESTROY;
            case 6:
                throw new OutsideLifecycleException("Cannot bind to Activity lifecycle when outside of it.");
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Binding to ");
                sb.append(lastEvent);
                sb.append(" not yet implemented");
                throw new UnsupportedOperationException(sb.toString());
        }
    }
}
