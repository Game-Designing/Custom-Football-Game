package com.bumptech.glide.load.p111b;

import com.bumptech.glide.C6001h;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.p109a.C6042d;
import com.bumptech.glide.load.p109a.C6042d.C6043a;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.p107h.C6024i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import p002b.p003c.p053g.p061f.C1269m;

/* renamed from: com.bumptech.glide.load.b.x */
/* compiled from: MultiModelLoader */
class C6134x<Model, Data> implements C6128u<Model, Data> {

    /* renamed from: a */
    private final List<C6128u<Model, Data>> f10821a;

    /* renamed from: b */
    private final C1269m<List<Throwable>> f10822b;

    /* renamed from: com.bumptech.glide.load.b.x$a */
    /* compiled from: MultiModelLoader */
    static class C6135a<Data> implements C6042d<Data>, C6043a<Data> {

        /* renamed from: a */
        private final List<C6042d<Data>> f10823a;

        /* renamed from: b */
        private final C1269m<List<Throwable>> f10824b;

        /* renamed from: c */
        private int f10825c = 0;

        /* renamed from: d */
        private C6001h f10826d;

        /* renamed from: e */
        private C6043a<? super Data> f10827e;

        /* renamed from: f */
        private List<Throwable> f10828f;

        C6135a(List<C6042d<Data>> fetchers, C1269m<List<Throwable>> throwableListPool) {
            this.f10824b = throwableListPool;
            C6024i.m11267a(fetchers);
            this.f10823a = fetchers;
        }

        /* renamed from: a */
        public void mo18853a(C6001h priority, C6043a<? super Data> callback) {
            this.f10826d = priority;
            this.f10827e = callback;
            this.f10828f = (List) this.f10824b.mo9148a();
            ((C6042d) this.f10823a.get(this.f10825c)).mo18853a(priority, this);
        }

        /* renamed from: b */
        public void mo18854b() {
            List<Throwable> list = this.f10828f;
            if (list != null) {
                this.f10824b.mo9149a(list);
            }
            this.f10828f = null;
            Iterator it = this.f10823a.iterator();
            while (it.hasNext()) {
                ((C6042d) it.next()).mo18854b();
            }
        }

        public void cancel() {
            Iterator it = this.f10823a.iterator();
            while (it.hasNext()) {
                ((C6042d) it.next()).cancel();
            }
        }

        /* renamed from: a */
        public Class<Data> mo18847a() {
            return ((C6042d) this.f10823a.get(0)).mo18847a();
        }

        /* renamed from: c */
        public C6031a mo18855c() {
            return ((C6042d) this.f10823a.get(0)).mo18855c();
        }

        /* renamed from: a */
        public void mo18868a(Data data) {
            if (data != null) {
                this.f10827e.mo18868a(data);
            } else {
                m11583d();
            }
        }

        /* renamed from: a */
        public void mo18867a(Exception e) {
            List<Throwable> list = this.f10828f;
            C6024i.m11264a(list);
            list.add(e);
            m11583d();
        }

        /* renamed from: d */
        private void m11583d() {
            if (this.f10825c < this.f10823a.size() - 1) {
                this.f10825c++;
                mo18853a(this.f10826d, this.f10827e);
                return;
            }
            C6024i.m11264a(this.f10828f);
            this.f10827e.mo18867a((Exception) new GlideException("Fetch failed", (List<Throwable>) new ArrayList<Throwable>(this.f10828f)));
        }
    }

    C6134x(List<C6128u<Model, Data>> modelLoaders, C1269m<List<Throwable>> exceptionListPool) {
        this.f10821a = modelLoaders;
        this.f10822b = exceptionListPool;
    }

    /* renamed from: a */
    public C6129a<Data> mo18889a(Model model, int width, int height, C6349k options) {
        C6344g sourceKey = null;
        int size = this.f10821a.size();
        List<DataFetcher<Data>> fetchers = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ModelLoader<Model, Data> modelLoader = (C6128u) this.f10821a.get(i);
            if (modelLoader.mo18891a(model)) {
                LoadData<Data> loadData = modelLoader.mo18889a(model, width, height, options);
                if (loadData != null) {
                    sourceKey = loadData.f10814a;
                    fetchers.add(loadData.f10816c);
                }
            }
        }
        if (fetchers.isEmpty() != 0 || sourceKey == null) {
            return null;
        }
        return new C6129a<>(sourceKey, new C6135a(fetchers, this.f10822b));
    }

    /* renamed from: a */
    public boolean mo18891a(Model model) {
        Iterator it = this.f10821a.iterator();
        while (it.hasNext()) {
            if (((C6128u) it.next()).mo18891a(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiModelLoader{modelLoaders=");
        sb.append(Arrays.toString(this.f10821a.toArray()));
        sb.append('}');
        return sb.toString();
    }
}
