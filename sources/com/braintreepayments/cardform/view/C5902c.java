package com.braintreepayments.cardform.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;
import p019d.p151c.p152a.p153a.C7276f;

/* renamed from: com.braintreepayments.cardform.view.c */
/* compiled from: ExpirationDateDialog */
class C5902c implements OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C7276f f10312a;

    /* renamed from: b */
    final /* synthetic */ C5906g f10313b;

    C5902c(C5906g this$0, C7276f fVar) {
        this.f10313b = this$0;
        this.f10312a = fVar;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        this.f10313b.f10328j = true;
        this.f10313b.f10330l = position;
        this.f10313b.m10786b();
        if (Integer.parseInt((String) this.f10313b.f10322d.get(position)) == this.f10313b.f10321c) {
            List<Integer> disabledMonths = new ArrayList<>();
            for (int i = 0; i < C5906g.f10319a.size(); i++) {
                if (Integer.parseInt((String) C5906g.f10319a.get(i)) < this.f10313b.f10320b) {
                    disabledMonths.add(Integer.valueOf(i));
                }
            }
            this.f10312a.mo23504a(disabledMonths);
            return;
        }
        this.f10312a.mo23504a((List<Integer>) new ArrayList<Integer>());
    }
}
