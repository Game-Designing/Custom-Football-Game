package com.bumptech.glide;

import com.bumptech.glide.load.C6229d;
import com.bumptech.glide.load.C6230e;
import com.bumptech.glide.load.C6350l;
import com.bumptech.glide.load.C6351m;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.C6233B;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.C6319k;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.p109a.C6044e;
import com.bumptech.glide.load.p109a.C6044e.C6045a;
import com.bumptech.glide.load.p109a.C6047g;
import com.bumptech.glide.load.p111b.C6128u;
import com.bumptech.glide.load.p111b.C6130v;
import com.bumptech.glide.load.p111b.C6131w;
import com.bumptech.glide.load.p113c.p119f.C6225e;
import com.bumptech.glide.load.p113c.p119f.C6226f;
import com.bumptech.glide.p102e.C5957a;
import com.bumptech.glide.p102e.C5959b;
import com.bumptech.glide.p102e.C5960c;
import com.bumptech.glide.p102e.C5961d;
import com.bumptech.glide.p102e.C5962e;
import com.bumptech.glide.p102e.C5964f;
import com.bumptech.glide.p107h.p108a.C6008d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p002b.p003c.p053g.p061f.C1269m;

public class Registry {

    /* renamed from: a */
    private final C6131w f10331a = new C6131w(this.f10340j);

    /* renamed from: b */
    private final C5957a f10332b = new C5957a();

    /* renamed from: c */
    private final C5962e f10333c = new C5962e();

    /* renamed from: d */
    private final C5964f f10334d = new C5964f();

    /* renamed from: e */
    private final C6047g f10335e = new C6047g();

    /* renamed from: f */
    private final C6226f f10336f = new C6226f();

    /* renamed from: g */
    private final C5959b f10337g = new C5959b();

    /* renamed from: h */
    private final C5961d f10338h = new C5961d();

    /* renamed from: i */
    private final C5960c f10339i = new C5960c();

    /* renamed from: j */
    private final C1269m<List<Throwable>> f10340j = C6008d.m11220a();

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String message) {
            super(message);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object model) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find any ModelLoaders for model: ");
            sb.append(model);
            super(sb.toString());
        }

        public NoModelLoaderAvailableException(Class<?> modelClass, Class<?> dataClass) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find any ModelLoaders for model: ");
            sb.append(modelClass);
            sb.append(" and data: ");
            sb.append(dataClass);
            super(sb.toString());
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> resourceClass) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find result encoder for resource class: ");
            sb.append(resourceClass);
            sb.append(", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
            super(sb.toString());
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> dataClass) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find source encoder for data class: ");
            sb.append(dataClass);
            super(sb.toString());
        }
    }

    public Registry() {
        mo18520a(Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"}));
    }

    /* renamed from: a */
    public <Data> Registry mo18514a(Class<Data> dataClass, C6229d<Data> encoder) {
        this.f10332b.mo18656a(dataClass, encoder);
        return this;
    }

    /* renamed from: a */
    public <Data, TResource> Registry mo18518a(Class<Data> dataClass, Class<TResource> resourceClass, C6350l<Data, TResource> decoder) {
        mo18519a("legacy_append", dataClass, resourceClass, decoder);
        return this;
    }

    /* renamed from: a */
    public <Data, TResource> Registry mo18519a(String bucket, Class<Data> dataClass, Class<TResource> resourceClass, C6350l<Data, TResource> decoder) {
        this.f10333c.mo18666a(bucket, decoder, dataClass, resourceClass);
        return this;
    }

    /* renamed from: a */
    public final Registry mo18520a(List<String> buckets) {
        List<String> modifiedBuckets = new ArrayList<>(buckets);
        modifiedBuckets.add(0, "legacy_prepend_all");
        modifiedBuckets.add("legacy_append");
        this.f10333c.mo18667a(modifiedBuckets);
        return this;
    }

    /* renamed from: a */
    public <TResource> Registry mo18515a(Class<TResource> resourceClass, C6351m<TResource> encoder) {
        this.f10334d.mo18671a(resourceClass, encoder);
        return this;
    }

    /* renamed from: a */
    public Registry mo18512a(C6045a<?> factory) {
        this.f10335e.mo18874a(factory);
        return this;
    }

    /* renamed from: a */
    public <TResource, Transcode> Registry mo18517a(Class<TResource> resourceClass, Class<Transcode> transcodeClass, C6225e<TResource, Transcode> transcoder) {
        this.f10336f.mo19091a(resourceClass, transcodeClass, transcoder);
        return this;
    }

    /* renamed from: a */
    public Registry mo18513a(C6230e parser) {
        this.f10337g.mo18659a(parser);
        return this;
    }

    /* renamed from: a */
    public <Model, Data> Registry mo18516a(Class<Model> modelClass, Class<Data> dataClass, C6130v<Model, Data> factory) {
        this.f10331a.mo18954a(modelClass, dataClass, factory);
        return this;
    }

    /* renamed from: a */
    public <Data, TResource, Transcode> C6233B<Data, TResource, Transcode> mo18521a(Class<Data> dataClass, Class<TResource> resourceClass, Class<Transcode> transcodeClass) {
        C6233B<Data, TResource, Transcode> a = this.f10339i.mo18660a(dataClass, resourceClass, transcodeClass);
        if (this.f10339i.mo18662a(a)) {
            return null;
        }
        if (a == null) {
            List<DecodePath<Data, TResource, Transcode>> decodePaths = m10793c(dataClass, resourceClass, transcodeClass);
            if (decodePaths.isEmpty()) {
                a = null;
            } else {
                C6233B<Data, TResource, Transcode> b = new C6233B<>(dataClass, resourceClass, transcodeClass, decodePaths, this.f10340j);
                a = b;
            }
            this.f10339i.mo18661a(dataClass, resourceClass, transcodeClass, a);
        }
        return a;
    }

    /* renamed from: c */
    private <Data, TResource, Transcode> List<C6319k<Data, TResource, Transcode>> m10793c(Class<Data> dataClass, Class<TResource> resourceClass, Class<Transcode> transcodeClass) {
        Class<Data> cls = dataClass;
        List<DecodePath<Data, TResource, Transcode>> decodePaths = new ArrayList<>();
        for (Class<TResource> registeredResourceClass : this.f10333c.mo18668b(cls, resourceClass)) {
            for (Class<Transcode> registeredTranscodeClass : this.f10336f.mo19092b(registeredResourceClass, transcodeClass)) {
                Class cls2 = registeredTranscodeClass;
                C6319k kVar = new C6319k(dataClass, registeredResourceClass, registeredTranscodeClass, this.f10333c.mo18665a(cls, registeredResourceClass), this.f10336f.mo19090a(registeredResourceClass, registeredTranscodeClass), this.f10340j);
                decodePaths.add(kVar);
            }
        }
        Class<Transcode> cls3 = transcodeClass;
        return decodePaths;
    }

    /* renamed from: b */
    public <Model, TResource, Transcode> List<Class<?>> mo18526b(Class<Model> modelClass, Class<TResource> resourceClass, Class<Transcode> transcodeClass) {
        List<Class<?>> result = this.f10338h.mo18663a(modelClass, resourceClass);
        if (result == null) {
            result = new ArrayList<>();
            for (Class<?> dataClass : this.f10331a.mo18952a(modelClass)) {
                for (Class<?> registeredResourceClass : this.f10333c.mo18668b(dataClass, resourceClass)) {
                    if (!this.f10336f.mo19092b(registeredResourceClass, transcodeClass).isEmpty() && !result.contains(registeredResourceClass)) {
                        result.add(registeredResourceClass);
                    }
                }
            }
            this.f10338h.mo18664a(modelClass, resourceClass, Collections.unmodifiableList(result));
        }
        return result;
    }

    /* renamed from: b */
    public boolean mo18527b(C6236E<?> resource) {
        return this.f10334d.mo18670a(resource.mo18970c()) != null;
    }

    /* renamed from: a */
    public <X> C6351m<X> mo18522a(C6236E<X> resource) throws NoResultEncoderAvailableException {
        ResourceEncoder<X> resourceEncoder = this.f10334d.mo18670a(resource.mo18970c());
        if (resourceEncoder != null) {
            return resourceEncoder;
        }
        throw new NoResultEncoderAvailableException(resource.mo18970c());
    }

    /* renamed from: c */
    public <X> C6229d<X> mo18528c(X data) throws NoSourceEncoderAvailableException {
        Encoder<X> encoder = this.f10332b.mo18655a(data.getClass());
        if (encoder != null) {
            return encoder;
        }
        throw new NoSourceEncoderAvailableException(data.getClass());
    }

    /* renamed from: b */
    public <X> C6044e<X> mo18525b(X data) {
        return this.f10335e.mo18873a(data);
    }

    /* renamed from: a */
    public <Model> List<C6128u<Model, ?>> mo18524a(Model model) {
        List<ModelLoader<Model, ?>> result = this.f10331a.mo18953a(model);
        if (!result.isEmpty()) {
            return result;
        }
        throw new NoModelLoaderAvailableException(model);
    }

    /* renamed from: a */
    public List<C6230e> mo18523a() {
        List<ImageHeaderParser> result = this.f10337g.mo18658a();
        if (!result.isEmpty()) {
            return result;
        }
        throw new NoImageHeaderParserException();
    }
}
