package com.bumptech.glide.load.p111b;

import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p109a.C6042d;
import com.bumptech.glide.p107h.C6024i;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bumptech.glide.load.b.u */
/* compiled from: ModelLoader */
public interface C6128u<Model, Data> {

    /* renamed from: com.bumptech.glide.load.b.u$a */
    /* compiled from: ModelLoader */
    public static class C6129a<Data> {

        /* renamed from: a */
        public final C6344g f10814a;

        /* renamed from: b */
        public final List<C6344g> f10815b;

        /* renamed from: c */
        public final C6042d<Data> f10816c;

        public C6129a(C6344g sourceKey, C6042d<Data> fetcher) {
            this(sourceKey, Collections.emptyList(), fetcher);
        }

        public C6129a(C6344g sourceKey, List<C6344g> alternateKeys, C6042d<Data> fetcher) {
            C6024i.m11264a(sourceKey);
            this.f10814a = sourceKey;
            C6024i.m11264a(alternateKeys);
            this.f10815b = alternateKeys;
            C6024i.m11264a(fetcher);
            this.f10816c = fetcher;
        }
    }

    /* renamed from: a */
    C6129a<Data> mo18889a(Model model, int i, int i2, C6349k kVar);

    /* renamed from: a */
    boolean mo18891a(Model model);
}
