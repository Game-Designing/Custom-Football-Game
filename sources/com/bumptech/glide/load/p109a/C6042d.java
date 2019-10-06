package com.bumptech.glide.load.p109a;

import com.bumptech.glide.C6001h;
import com.bumptech.glide.load.C6031a;

/* renamed from: com.bumptech.glide.load.a.d */
/* compiled from: DataFetcher */
public interface C6042d<T> {

    /* renamed from: com.bumptech.glide.load.a.d$a */
    /* compiled from: DataFetcher */
    public interface C6043a<T> {
        /* renamed from: a */
        void mo18867a(Exception exc);

        /* renamed from: a */
        void mo18868a(T t);
    }

    /* renamed from: a */
    Class<T> mo18847a();

    /* renamed from: a */
    void mo18853a(C6001h hVar, C6043a<? super T> aVar);

    /* renamed from: b */
    void mo18854b();

    /* renamed from: c */
    C6031a mo18855c();

    void cancel();
}
