package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p109a.C6044e;
import com.bumptech.glide.p107h.C6024i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p002b.p003c.p053g.p061f.C1269m;

/* renamed from: com.bumptech.glide.load.engine.B */
/* compiled from: LoadPath */
public class C6233B<Data, ResourceType, Transcode> {

    /* renamed from: a */
    private final Class<Data> f11004a;

    /* renamed from: b */
    private final C1269m<List<Throwable>> f11005b;

    /* renamed from: c */
    private final List<? extends C6319k<Data, ResourceType, Transcode>> f11006c;

    /* renamed from: d */
    private final String f11007d;

    public C6233B(Class<Data> dataClass, Class<ResourceType> resourceClass, Class<Transcode> transcodeClass, List<C6319k<Data, ResourceType, Transcode>> decodePaths, C1269m<List<Throwable>> listPool) {
        this.f11004a = dataClass;
        this.f11005b = listPool;
        C6024i.m11267a(decodePaths);
        this.f11006c = decodePaths;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed LoadPath{");
        sb.append(dataClass.getSimpleName());
        String str = "->";
        sb.append(str);
        sb.append(resourceClass.getSimpleName());
        sb.append(str);
        sb.append(transcodeClass.getSimpleName());
        sb.append("}");
        this.f11007d = sb.toString();
    }

    /* renamed from: a */
    public C6236E<Transcode> mo19098a(C6044e<Data> rewinder, C6349k options, int width, int height, C6320a<ResourceType> decodeCallback) throws GlideException {
        Object a = this.f11005b.mo9148a();
        C6024i.m11264a(a);
        List<Throwable> throwables = (List) a;
        try {
            return m11883a(rewinder, options, width, height, decodeCallback, throwables);
        } finally {
            this.f11005b.mo9149a(throwables);
        }
    }

    /* renamed from: a */
    private C6236E<Transcode> m11883a(C6044e<Data> rewinder, C6349k options, int width, int height, C6320a<ResourceType> decodeCallback, List<Throwable> exceptions) throws GlideException {
        List<Throwable> list = exceptions;
        int size = this.f11006c.size();
        C6236E<Transcode> e = null;
        for (int i = 0; i < size; i++) {
            try {
                e = ((C6319k) this.f11006c.get(i)).mo19271a(rewinder, width, height, options, decodeCallback);
            } catch (GlideException e2) {
                list.add(e2);
            }
            if (e != null) {
                break;
            }
        }
        if (e != null) {
            return e;
        }
        throw new GlideException(this.f11007d, (List<Throwable>) new ArrayList<Throwable>(list));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoadPath{decodePaths=");
        sb.append(Arrays.toString(this.f11006c.toArray()));
        sb.append('}');
        return sb.toString();
    }
}
