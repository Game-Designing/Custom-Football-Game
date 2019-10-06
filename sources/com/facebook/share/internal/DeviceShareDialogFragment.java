package com.facebook.share.internal;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.app.C0424G;
import android.support.p000v4.app.C0478k;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.C6534A;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.common.C6656b;
import com.facebook.common.C6657c;
import com.facebook.common.C6658d;
import com.facebook.common.C6659e;
import com.facebook.internal.C6697T;
import com.facebook.p131b.p132a.C6652b;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DeviceShareDialogFragment extends C0478k {

    /* renamed from: a */
    private static ScheduledThreadPoolExecutor f12490a;

    /* renamed from: b */
    private ProgressBar f12491b;

    /* renamed from: c */
    private TextView f12492c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Dialog f12493d;

    /* renamed from: e */
    private volatile RequestState f12494e;

    /* renamed from: f */
    private volatile ScheduledFuture f12495f;

    /* renamed from: g */
    private ShareContent f12496g;

    private static class RequestState implements Parcelable {
        public static final Creator<RequestState> CREATOR = new C6793d();

        /* renamed from: a */
        private String f12497a;

        /* renamed from: b */
        private long f12498b;

        RequestState() {
        }

        /* renamed from: b */
        public String mo20146b() {
            return this.f12497a;
        }

        /* renamed from: a */
        public void mo20145a(String userCode) {
            this.f12497a = userCode;
        }

        /* renamed from: a */
        public long mo20143a() {
            return this.f12498b;
        }

        /* renamed from: a */
        public void mo20144a(long expiresIn) {
            this.f12498b = expiresIn;
        }

        protected RequestState(Parcel in) {
            this.f12497a = in.readString();
            this.f12498b = in.readLong();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.f12497a);
            dest.writeLong(this.f12498b);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (savedInstanceState != null) {
            RequestState requestState = (RequestState) savedInstanceState.getParcelable("request_state");
            if (requestState != null) {
                m13836a(requestState);
            }
        }
        return view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        this.f12493d = new Dialog(getActivity(), C6659e.com_facebook_auth_dialog);
        View view = getActivity().getLayoutInflater().inflate(C6657c.com_facebook_device_auth_dialog_fragment, null);
        this.f12491b = (ProgressBar) view.findViewById(C6656b.progress_bar);
        this.f12492c = (TextView) view.findViewById(C6656b.confirmation_code);
        ((Button) view.findViewById(C6656b.cancel_button)).setOnClickListener(new C6790a(this));
        ((TextView) view.findViewById(C6656b.com_facebook_device_auth_instructions)).setText(Html.fromHtml(getString(C6658d.com_facebook_device_auth_instructions)));
        this.f12493d.setContentView(view);
        m13842e();
        return this.f12493d;
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (this.f12495f != null) {
            this.f12495f.cancel(true);
        }
        m13834a(-1, new Intent());
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (this.f12494e != null) {
            outState.putParcelable("request_state", this.f12494e);
        }
    }

    /* renamed from: a */
    private void m13834a(int resultCode, Intent data) {
        if (this.f12494e != null) {
            C6652b.m13274a(this.f12494e.mo20146b());
        }
        FacebookRequestError error = (FacebookRequestError) data.getParcelableExtra("error");
        if (error != null) {
            Toast.makeText(getContext(), error.mo19662c(), 0).show();
        }
        if (isAdded()) {
            Activity activity = getActivity();
            activity.setResult(resultCode, data);
            activity.finish();
        }
    }

    /* renamed from: b */
    private void m13839b() {
        if (isAdded()) {
            C0424G a = getFragmentManager().mo4909a();
            a.mo5043c(this);
            a.mo5032a();
        }
    }

    /* renamed from: a */
    public void mo20142a(ShareContent shareContent) {
        this.f12496g = shareContent;
    }

    /* renamed from: d */
    private Bundle m13841d() {
        ShareContent content = this.f12496g;
        if (content == null) {
            return null;
        }
        if (content instanceof ShareLinkContent) {
            return C6798h.m13862a((ShareLinkContent) content);
        }
        if (content instanceof ShareOpenGraphContent) {
            return C6798h.m13863a((ShareOpenGraphContent) content);
        }
        return null;
    }

    /* renamed from: e */
    private void m13842e() {
        Bundle parameters = m13841d();
        if (parameters == null || parameters.size() == 0) {
            m13835a(new FacebookRequestError(0, "", "Failed to get share content"));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(C6697T.m13459a());
        sb.append("|");
        sb.append(C6697T.m13465b());
        parameters.putString("access_token", sb.toString());
        parameters.putString("device_info", C6652b.m13273a());
        GraphRequest graphRequest = new GraphRequest(null, "device/share", parameters, C6534A.POST, new C6791b(this));
        graphRequest.mo19681c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13835a(FacebookRequestError error) {
        m13839b();
        Intent intent = new Intent();
        intent.putExtra("error", error);
        m13834a(-1, intent);
    }

    /* renamed from: c */
    private static synchronized ScheduledThreadPoolExecutor m13840c() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceShareDialogFragment.class) {
            if (f12490a == null) {
                f12490a = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = f12490a;
        }
        return scheduledThreadPoolExecutor;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13836a(RequestState currentRequestState) {
        this.f12494e = currentRequestState;
        this.f12492c.setText(currentRequestState.mo20146b());
        this.f12492c.setVisibility(0);
        this.f12491b.setVisibility(8);
        this.f12495f = m13840c().schedule(new C6792c(this), currentRequestState.mo20143a(), TimeUnit.SECONDS);
    }
}
