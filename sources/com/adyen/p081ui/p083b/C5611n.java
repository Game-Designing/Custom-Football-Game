package com.adyen.p081ui.p083b;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.adyen.p081ui.C5631d;
import com.adyen.p081ui.activities.CheckoutActivity;

/* renamed from: com.adyen.ui.b.n */
/* compiled from: LoadingScreenFragment */
public class C5611n extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(C5631d.loading_screen_fragment, container, false);
        if (getActivity() instanceof CheckoutActivity) {
            ((CheckoutActivity) getActivity()).mo17712a();
        }
        return fragmentView;
    }
}
