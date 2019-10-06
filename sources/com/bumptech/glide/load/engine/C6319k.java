package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6350l;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.p109a.C6044e;
import com.bumptech.glide.load.p113c.p119f.C6225e;
import com.bumptech.glide.p107h.C6024i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p002b.p003c.p053g.p061f.C1269m;

/* renamed from: com.bumptech.glide.load.engine.k */
/* compiled from: DecodePath */
public class C6319k<DataType, ResourceType, Transcode> {

    /* renamed from: a */
    private final Class<DataType> f11243a;

    /* renamed from: b */
    private final List<? extends C6350l<DataType, ResourceType>> f11244b;

    /* renamed from: c */
    private final C6225e<ResourceType, Transcode> f11245c;

    /* renamed from: d */
    private final C1269m<List<Throwable>> f11246d;

    /* renamed from: e */
    private final String f11247e;

    /* renamed from: com.bumptech.glide.load.engine.k$a */
    /* compiled from: DecodePath */
    interface C6320a<ResourceType> {
        /* renamed from: a */
        C6236E<ResourceType> mo19261a(C6236E<ResourceType> e);
    }

    public C6319k(Class<DataType> dataClass, Class<ResourceType> resourceClass, Class<Transcode> transcodeClass, List<? extends C6350l<DataType, ResourceType>> decoders, C6225e<ResourceType, Transcode> transcoder, C1269m<List<Throwable>> listPool) {
        this.f11243a = dataClass;
        this.f11244b = decoders;
        this.f11245c = transcoder;
        this.f11246d = listPool;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed DecodePath{");
        sb.append(dataClass.getSimpleName());
        String str = "->";
        sb.append(str);
        sb.append(resourceClass.getSimpleName());
        sb.append(str);
        sb.append(transcodeClass.getSimpleName());
        sb.append("}");
        this.f11247e = sb.toString();
    }

    /* renamed from: a */
    public C6236E<Transcode> mo19271a(C6044e<DataType> rewinder, int width, int height, C6349k options, C6320a<ResourceType> callback) throws GlideException {
        return this.f11245c.mo19089a(callback.mo19261a(m12168a(rewinder, width, height, options)), options);
    }

    /* renamed from: a */
    private C6236E<ResourceType> m12168a(C6044e<DataType> rewinder, int width, int height, C6349k options) throws GlideException {
        Object a = this.f11246d.mo9148a();
        C6024i.m11264a(a);
        List<Throwable> exceptions = (List) a;
        try {
            return m12169a(rewinder, width, height, options, exceptions);
        } finally {
            this.f11246d.mo9149a(exceptions);
        }
    }

    /* renamed from: a */
    private C6236E<ResourceType> m12169a(C6044e<DataType> rewinder, int width, int height, C6349k options, List<Throwable> exceptions) throws GlideException {
        C6236E<ResourceType> e = null;
        int size = this.f11244b.size();
        for (int i = 0; i < size; i++) {
            ResourceDecoder<DataType, ResourceType> decoder = (C6350l) this.f11244b.get(i);
            try {
                if (decoder.mo18973a(rewinder.mo18869a(), options)) {
                    e = decoder.mo18972a(rewinder.mo18869a(), width, height, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                String str = "DecodePath";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to decode data for ");
                    sb.append(decoder);
                    Log.v(str, sb.toString(), e2);
                }
                exceptions.add(e2);
            }
            if (e != null) {
                break;
            }
        }
        if (e != null) {
            return e;
        }
        throw new GlideException(this.f11247e, (List<Throwable>) new ArrayList<Throwable>(exceptions));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecodePath{ dataClass=");
        sb.append(this.f11243a);
        sb.append(", decoders=");
        sb.append(this.f11244b);
        sb.append(", transcoder=");
        sb.append(this.f11245c);
        sb.append('}');
        return sb.toString();
    }
}
