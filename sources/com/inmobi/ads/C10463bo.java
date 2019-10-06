package com.inmobi.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.inmobi.ads.bo */
/* compiled from: ScrollableDeckFreeContainer */
class C10463bo extends NativeScrollableContainer {

    /* renamed from: a */
    private RecyclerView f31826a;

    /* renamed from: b */
    private boolean f31827b = false;

    public C10463bo(Context context) {
        super(context, 1);
    }

    /* renamed from: a */
    public final void mo33856a(C10402am amVar, C10434ax axVar, int i, int i2, C10326a aVar) {
        LayoutParams layoutParams = (LayoutParams) NativeViewFactory.m33742a(amVar.mo34098a(0), (ViewGroup) this);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(20);
            layoutParams.setMarginEnd(20);
        } else {
            layoutParams.setMargins(20, 0, 20, 0);
        }
        layoutParams.gravity = i2;
        this.f31826a = new RecyclerView(getContext());
        this.f31826a.setLayoutParams(new LayoutParams(-1, -1));
        this.f31826a.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        addView(this.f31826a);
        this.f31826a.setAdapter((NativeRecyclerViewAdapter) axVar);
    }
}
