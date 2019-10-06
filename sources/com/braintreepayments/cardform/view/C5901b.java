package com.braintreepayments.cardform.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p019d.p151c.p152a.p153a.C7276f;

/* renamed from: com.braintreepayments.cardform.view.b */
/* compiled from: ExpirationDateDialog */
class C5901b implements OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C7276f f10310a;

    /* renamed from: b */
    final /* synthetic */ C5906g f10311b;

    C5901b(C5906g this$0, C7276f fVar) {
        this.f10311b = this$0;
        this.f10310a = fVar;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        this.f10311b.f10327i = true;
        this.f10311b.f10329k = position;
        this.f10311b.m10786b();
        if (Integer.parseInt((String) C5906g.f10319a.get(position)) < this.f10311b.f10320b) {
            this.f10310a.mo23504a(Collections.singletonList(Integer.valueOf(0)));
        } else {
            this.f10310a.mo23504a((List<Integer>) new ArrayList<Integer>());
        }
    }
}
