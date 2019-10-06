package com.facebook.internal;

/* renamed from: com.facebook.internal.I */
/* compiled from: NativeProtocol */
class C6677I implements Runnable {
    C6677I() {
    }

    public void run() {
        try {
            for (C6683e appInfo : C6678J.f12192b) {
                appInfo.m13368a(true);
            }
        } finally {
            C6678J.f12195e.set(false);
        }
    }
}
