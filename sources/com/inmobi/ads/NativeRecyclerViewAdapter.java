package com.inmobi.ads;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

public class NativeRecyclerViewAdapter extends C0970a<C10325a> implements C10434ax {

    /* renamed from: a */
    private static final String f31352a = NativeRecyclerViewAdapter.class.getSimpleName();

    /* renamed from: b */
    private final C10406ao f31353b;

    /* renamed from: c */
    private C10419au f31354c;

    /* renamed from: d */
    private SparseArray<WeakReference<View>> f31355d;

    /* renamed from: e */
    private boolean f31356e = false;

    /* renamed from: com.inmobi.ads.NativeRecyclerViewAdapter$a */
    class C10325a extends C1000w {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public ViewGroup f31358b;

        C10325a(View view) {
            super(view);
            this.f31358b = (ViewGroup) view;
        }
    }

    NativeRecyclerViewAdapter(C10406ao aoVar, C10419au auVar) {
        this.f31353b = aoVar;
        this.f31354c = auVar;
        this.f31355d = new SparseArray<>();
    }

    public C10325a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C10325a(new FrameLayout(this.f31354c.mo34126a()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        if (r1 == null) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(com.inmobi.ads.NativeRecyclerViewAdapter.C10325a r5, int r6) {
        /*
            r4 = this;
            com.inmobi.ads.ao r0 = r4.f31353b
            com.inmobi.ads.am r0 = r0.mo34103a(r6)
            android.util.SparseArray<java.lang.ref.WeakReference<android.view.View>> r1 = r4.f31355d
            java.lang.Object r1 = r1.get(r6)
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            if (r1 == 0) goto L_0x0018
            java.lang.Object r1 = r1.get()
            android.view.View r1 = (android.view.View) r1
            if (r1 != 0) goto L_0x0020
        L_0x0018:
            android.view.ViewGroup r1 = r5.f31358b
            android.view.ViewGroup r1 = r4.buildScrollableView(r6, r1, r0)
        L_0x0020:
            if (r1 == 0) goto L_0x0045
            int r0 = r4.getItemCount()
            int r0 = r0 + -1
            if (r6 == r0) goto L_0x0034
            android.view.ViewGroup r0 = r5.f31358b
            r2 = 16
            r3 = 0
            r0.setPadding(r3, r3, r2, r3)
        L_0x0034:
            android.view.ViewGroup r5 = r5.f31358b
            r5.addView(r1)
            android.util.SparseArray<java.lang.ref.WeakReference<android.view.View>> r5 = r4.f31355d
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r1)
            r5.put(r6, r0)
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.NativeRecyclerViewAdapter.onBindViewHolder(com.inmobi.ads.NativeRecyclerViewAdapter$a, int):void");
    }

    public void onViewRecycled(C10325a aVar) {
        aVar.f31358b.removeAllViews();
        super.onViewRecycled(aVar);
    }

    public ViewGroup buildScrollableView(int i, ViewGroup viewGroup, C10402am amVar) {
        ViewGroup a = this.f31354c.mo34127a(viewGroup, amVar);
        this.f31354c.mo34129b(a, amVar);
        a.setLayoutParams(NativeViewFactory.m33742a((C10400ak) amVar, viewGroup));
        return a;
    }

    public int getItemCount() {
        return this.f31353b.mo34105b();
    }

    public void destroy() {
        this.f31356e = true;
    }
}
