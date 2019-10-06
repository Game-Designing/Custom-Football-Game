package com.bumptech.glide.load.p111b;

import com.bumptech.glide.C6001h;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p109a.C6042d;
import com.bumptech.glide.load.p109a.C6042d.C6043a;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.p106g.C6000c;

/* renamed from: com.bumptech.glide.load.b.C */
/* compiled from: UnitModelLoader */
public class C6066C<Model> implements C6128u<Model, Model> {

    /* renamed from: a */
    private static final C6066C<?> f10744a = new C6066C<>();

    /* renamed from: com.bumptech.glide.load.b.C$a */
    /* compiled from: UnitModelLoader */
    public static class C6067a<Model> implements C6130v<Model, Model> {

        /* renamed from: a */
        private static final C6067a<?> f10745a = new C6067a<>();

        /* renamed from: a */
        public static <T> C6067a<T> m11418a() {
            return f10745a;
        }

        /* renamed from: a */
        public C6128u<Model, Model> mo18893a(C6136y multiFactory) {
            return C6066C.m11415a();
        }
    }

    /* renamed from: com.bumptech.glide.load.b.C$b */
    /* compiled from: UnitModelLoader */
    private static class C6068b<Model> implements C6042d<Model> {

        /* renamed from: a */
        private final Model f10746a;

        C6068b(Model resource) {
            this.f10746a = resource;
        }

        /* renamed from: a */
        public void mo18853a(C6001h priority, C6043a<? super Model> callback) {
            callback.mo18868a(this.f10746a);
        }

        /* renamed from: b */
        public void mo18854b() {
        }

        public void cancel() {
        }

        /* renamed from: a */
        public Class<Model> mo18847a() {
            return this.f10746a.getClass();
        }

        /* renamed from: c */
        public C6031a mo18855c() {
            return C6031a.LOCAL;
        }
    }

    /* renamed from: a */
    public static <T> C6066C<T> m11415a() {
        return f10744a;
    }

    /* renamed from: a */
    public C6129a<Model> mo18889a(Model model, int width, int height, C6349k options) {
        return new C6129a<>(new C6000c(model), new C6068b(model));
    }

    /* renamed from: a */
    public boolean mo18891a(Model model) {
        return true;
    }
}
