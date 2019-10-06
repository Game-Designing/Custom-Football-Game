package com.bumptech.glide.load.p111b;

import com.bumptech.glide.C6001h;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p109a.C6042d;
import com.bumptech.glide.load.p109a.C6042d.C6043a;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.p106g.C6000c;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.g */
/* compiled from: DataUrlLoader */
public final class C6101g<Model, Data> implements C6128u<Model, Data> {

    /* renamed from: a */
    private final C6102a<Data> f10775a;

    /* renamed from: com.bumptech.glide.load.b.g$a */
    /* compiled from: DataUrlLoader */
    public interface C6102a<Data> {
        /* renamed from: a */
        Class<Data> mo18919a();

        /* renamed from: a */
        void mo18920a(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;
    }

    /* renamed from: com.bumptech.glide.load.b.g$b */
    /* compiled from: DataUrlLoader */
    private static final class C6103b<Data> implements C6042d<Data> {

        /* renamed from: a */
        private final String f10776a;

        /* renamed from: b */
        private final C6102a<Data> f10777b;

        /* renamed from: c */
        private Data f10778c;

        C6103b(String dataUri, C6102a<Data> reader) {
            this.f10776a = dataUri;
            this.f10777b = reader;
        }

        /* renamed from: a */
        public void mo18853a(C6001h priority, C6043a<? super Data> callback) {
            try {
                this.f10778c = this.f10777b.decode(this.f10776a);
                callback.mo18868a(this.f10778c);
            } catch (IllegalArgumentException e) {
                callback.mo18867a((Exception) e);
            }
        }

        /* renamed from: b */
        public void mo18854b() {
            try {
                this.f10777b.mo18920a(this.f10778c);
            } catch (IOException e) {
            }
        }

        public void cancel() {
        }

        /* renamed from: a */
        public Class<Data> mo18847a() {
            return this.f10777b.mo18919a();
        }

        /* renamed from: c */
        public C6031a mo18855c() {
            return C6031a.LOCAL;
        }
    }

    /* renamed from: com.bumptech.glide.load.b.g$c */
    /* compiled from: DataUrlLoader */
    public static final class C6104c<Model> implements C6130v<Model, InputStream> {

        /* renamed from: a */
        private final C6102a<InputStream> f10779a = new C6105h(this);

        /* renamed from: a */
        public C6128u<Model, InputStream> mo18893a(C6136y multiFactory) {
            return new C6101g(this.f10779a);
        }
    }

    public C6101g(C6102a<Data> dataDecoder) {
        this.f10775a = dataDecoder;
    }

    /* renamed from: a */
    public C6129a<Data> mo18889a(Model model, int width, int height, C6349k options) {
        return new C6129a<>(new C6000c(model), new C6103b(model.toString(), this.f10775a));
    }

    /* renamed from: a */
    public boolean mo18891a(Model model) {
        return model.toString().startsWith("data:image");
    }
}
