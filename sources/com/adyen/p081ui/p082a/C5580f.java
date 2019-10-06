package com.adyen.p081ui.p082a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.adyen.p081ui.C5591b;
import com.adyen.p081ui.C5626c;
import com.adyen.p081ui.C5631d;
import com.adyen.p081ui.p084c.C5630c;
import java.util.List;
import p019d.p135a.p136a.p139c.C6889d;
import p019d.p135a.p136a.p142e.C6907g;

/* renamed from: com.adyen.ui.a.f */
/* compiled from: PaymentListAdapter */
public class C5580f extends ArrayAdapter<C6889d> {

    /* renamed from: a */
    private static final String f9394a = C5580f.class.getSimpleName();

    /* renamed from: b */
    private final Activity f9395b;

    /* renamed from: c */
    private final List<C6889d> f9396c;

    /* renamed from: d */
    private LayoutInflater f9397d;

    /* renamed from: com.adyen.ui.a.f$a */
    /* compiled from: PaymentListAdapter */
    private static class C5581a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public TextView f9398a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public ImageView f9399b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f9400c;

        private C5581a() {
        }

        /* synthetic */ C5581a(C5579e x0) {
            this();
        }
    }

    public C5580f(Activity context, List<C6889d> paymentMethods) {
        super(context, C5631d.payment_method_list, paymentMethods);
        Log.d(f9394a, "PaymentListAdapter()");
        this.f9395b = context;
        this.f9396c = paymentMethods;
        this.f9397d = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View getView(int position, View view, ViewGroup parent) {
        C5581a viewHolder;
        if (view == null) {
            viewHolder = new C5581a(null);
            view = this.f9397d.inflate(C5631d.payment_method_list, parent, false);
            viewHolder.f9398a = (TextView) view.findViewById(C5626c.paymentMethodName);
            viewHolder.f9399b = (ImageView) view.findViewById(C5626c.paymentMethodLogo);
            view.setTag(viewHolder);
        } else {
            viewHolder = (C5581a) view.getTag();
        }
        if (!(viewHolder == null || viewHolder.f9398a == null || viewHolder.f9399b == null)) {
            viewHolder.f9398a.setText(((C6889d) this.f9396c.get(position)).mo22331e());
            Bitmap defaultImage = null;
            if ("samsungpay".equals(((C6889d) this.f9396c.get(position)).mo22335h())) {
                defaultImage = BitmapFactory.decodeResource(this.f9395b.getResources(), C5591b.samsung_pay_vertical_logo_artwork_rgb_0623);
            } else {
                if ("androidpay".equals(((C6889d) this.f9396c.get(position)).mo22335h())) {
                    defaultImage = BitmapFactory.decodeResource(this.f9395b.getResources(), C5591b.android_pay_logo);
                }
            }
            String modifiedUrl = C5630c.m9930a((Context) this.f9395b, ((C6889d) this.f9396c.get(position)).mo22329c());
            viewHolder.f9400c = modifiedUrl;
            C6907g.m14048a(getContext(), new C5579e(this, viewHolder), modifiedUrl, defaultImage);
        }
        return view;
    }
}
