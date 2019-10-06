package com.bumptech.glide.p107h.p108a;

/* renamed from: com.bumptech.glide.h.a.g */
/* compiled from: StateVerifier */
public abstract class C6015g {

    /* renamed from: com.bumptech.glide.h.a.g$a */
    /* compiled from: StateVerifier */
    private static class C6016a extends C6015g {

        /* renamed from: a */
        private volatile boolean f10648a;

        C6016a() {
            super();
        }

        /* renamed from: b */
        public void mo18795b() {
            if (this.f10648a) {
                throw new IllegalStateException("Already released");
            }
        }

        /* renamed from: a */
        public void mo18794a(boolean isRecycled) {
            this.f10648a = isRecycled;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo18794a(boolean z);

    /* renamed from: b */
    public abstract void mo18795b();

    /* renamed from: a */
    public static C6015g m11235a() {
        return new C6016a();
    }

    private C6015g() {
    }
}
