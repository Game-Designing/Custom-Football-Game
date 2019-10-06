package p026rx.p390c.p391a;

import p026rx.C14972ha;
import p026rx.Single;
import p026rx.exceptions.C14927a;

/* renamed from: rx.c.a.Fb */
/* compiled from: SingleOperatorOnErrorResumeNext */
class C14578Fb extends C14972ha<T> {

    /* renamed from: b */
    final /* synthetic */ C14972ha f43433b;

    /* renamed from: c */
    final /* synthetic */ C14582Gb f43434c;

    C14578Fb(C14582Gb gb, C14972ha haVar) {
        this.f43434c = gb;
        this.f43433b = haVar;
    }

    /* renamed from: a */
    public void mo45712a(T value) {
        this.f43433b.mo45712a(value);
    }

    public void onError(Throwable error) {
        try {
            ((Single) this.f43434c.f43442b.call(error)).mo3691a(this.f43433b);
        } catch (Throwable innerError) {
            C14927a.m46674a(innerError, this.f43433b);
        }
    }
}
