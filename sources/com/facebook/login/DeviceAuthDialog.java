package com.facebook.login;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.app.C0478k;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.C6534A;
import com.facebook.C6665h;
import com.facebook.C6787r;
import com.facebook.C6813x;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.common.C6656b;
import com.facebook.common.C6657c;
import com.facebook.common.C6658d;
import com.facebook.common.C6659e;
import com.facebook.internal.C6694S.C6696b;
import com.facebook.internal.C6697T;
import com.facebook.login.LoginClient.Request;
import com.facebook.p127a.C6647y;
import com.facebook.p131b.p132a.C6652b;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p005cm.aptoide.p006pt.BuildConfig;

public class DeviceAuthDialog extends C0478k {

    /* renamed from: a */
    private View f12353a;

    /* renamed from: b */
    private TextView f12354b;

    /* renamed from: c */
    private TextView f12355c;

    /* renamed from: d */
    private DeviceAuthMethodHandler f12356d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AtomicBoolean f12357e = new AtomicBoolean();

    /* renamed from: f */
    private volatile C6813x f12358f;

    /* renamed from: g */
    private volatile ScheduledFuture f12359g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile RequestState f12360h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Dialog f12361i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f12362j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f12363k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Request f12364l = null;

    private static class RequestState implements Parcelable {
        public static final Creator<RequestState> CREATOR = new C6765j();

        /* renamed from: a */
        private String f12365a;

        /* renamed from: b */
        private String f12366b;

        /* renamed from: c */
        private String f12367c;

        /* renamed from: d */
        private long f12368d;

        /* renamed from: e */
        private long f12369e;

        RequestState() {
        }

        /* renamed from: a */
        public String mo20012a() {
            return this.f12365a;
        }

        /* renamed from: d */
        public String mo20019d() {
            return this.f12366b;
        }

        /* renamed from: b */
        public void mo20017b(String userCode) {
            this.f12366b = userCode;
            this.f12365a = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", new Object[]{userCode});
        }

        /* renamed from: c */
        public String mo20018c() {
            return this.f12367c;
        }

        /* renamed from: a */
        public void mo20014a(String requestCode) {
            this.f12367c = requestCode;
        }

        /* renamed from: b */
        public long mo20015b() {
            return this.f12368d;
        }

        /* renamed from: a */
        public void mo20013a(long interval) {
            this.f12368d = interval;
        }

        /* renamed from: b */
        public void mo20016b(long lastPoll) {
            this.f12369e = lastPoll;
        }

        protected RequestState(Parcel in) {
            this.f12365a = in.readString();
            this.f12366b = in.readString();
            this.f12367c = in.readString();
            this.f12368d = in.readLong();
            this.f12369e = in.readLong();
        }

        /* renamed from: e */
        public boolean mo20021e() {
            boolean z = false;
            if (this.f12369e == 0) {
                return false;
            }
            if ((new Date().getTime() - this.f12369e) - (this.f12368d * 1000) < 0) {
                z = true;
            }
            return z;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.f12365a);
            dest.writeString(this.f12366b);
            dest.writeString(this.f12367c);
            dest.writeLong(this.f12368d);
            dest.writeLong(this.f12369e);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        this.f12356d = (DeviceAuthMethodHandler) ((C6779x) ((FacebookActivity) getActivity()).mo19656a()).mo20126d().mo20051d();
        if (savedInstanceState != null) {
            RequestState requestState = (RequestState) savedInstanceState.getParcelable("request_state");
            if (requestState != null) {
                m13629a(requestState);
            }
        }
        return view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        this.f12361i = new Dialog(getActivity(), C6659e.com_facebook_auth_dialog);
        this.f12361i.setContentView(mo20010b(C6652b.m13276b() && !this.f12363k));
        return this.f12361i;
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (!this.f12362j) {
            mo20011b();
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (this.f12360h != null) {
            outState.putParcelable("request_state", this.f12360h);
        }
    }

    public void onDestroy() {
        this.f12362j = true;
        this.f12357e.set(true);
        super.onDestroy();
        if (this.f12358f != null) {
            this.f12358f.cancel(true);
        }
        if (this.f12359g != null) {
            this.f12359g.cancel(true);
        }
    }

    /* renamed from: a */
    public void mo20009a(Request request) {
        this.f12364l = request;
        Bundle parameters = new Bundle();
        parameters.putString("scope", TextUtils.join(",", request.mo20071h()));
        String redirectUriString = request.mo20069f();
        if (redirectUriString != null) {
            parameters.putString("redirect_uri", redirectUriString);
        }
        String targetUserId = request.mo20068e();
        if (targetUserId != null) {
            parameters.putString("target_user_id", targetUserId);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(C6697T.m13459a());
        sb.append("|");
        sb.append(C6697T.m13465b());
        parameters.putString("access_token", sb.toString());
        parameters.putString("device_info", C6652b.m13273a());
        GraphRequest graphRequest = new GraphRequest(null, "device/login", parameters, C6534A.POST, new C6758c(this));
        graphRequest.mo19681c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13629a(RequestState currentRequestState) {
        this.f12360h = currentRequestState;
        this.f12354b.setText(currentRequestState.mo20019d());
        this.f12355c.setCompoundDrawablesWithIntrinsicBounds(null, new BitmapDrawable(getResources(), C6652b.m13275b(currentRequestState.mo20012a())), null, null);
        this.f12354b.setVisibility(0);
        this.f12353a.setVisibility(8);
        if (!this.f12363k && C6652b.m13277c(currentRequestState.mo20019d())) {
            new C6647y(getContext()).mo19850a("fb_smart_login_service");
        }
        if (currentRequestState.mo20021e()) {
            m13644e();
        } else {
            m13643d();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public View mo20010b(boolean isSmartLogin) {
        View view = getActivity().getLayoutInflater().inflate(mo20007a(isSmartLogin), null);
        this.f12353a = view.findViewById(C6656b.progress_bar);
        this.f12354b = (TextView) view.findViewById(C6656b.confirmation_code);
        ((Button) view.findViewById(C6656b.cancel_button)).setOnClickListener(new C6759d(this));
        this.f12355c = (TextView) view.findViewById(C6656b.com_facebook_device_auth_instructions);
        this.f12355c.setText(Html.fromHtml(getString(C6658d.com_facebook_device_auth_instructions)));
        return view;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo20007a(boolean isSmartLogin) {
        return isSmartLogin ? C6657c.com_facebook_smart_device_dialog_fragment : C6657c.com_facebook_device_auth_dialog_fragment;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m13643d() {
        this.f12360h.mo20016b(new Date().getTime());
        this.f12358f = m13640c().mo19681c();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m13644e() {
        this.f12359g = DeviceAuthMethodHandler.m13664e().schedule(new C6760e(this), this.f12360h.mo20015b(), TimeUnit.SECONDS);
    }

    /* renamed from: c */
    private GraphRequest m13640c() {
        Bundle parameters = new Bundle();
        parameters.putString("code", this.f12360h.mo20018c());
        GraphRequest graphRequest = new GraphRequest(null, "device/login_status", parameters, C6534A.POST, new C6761f(this));
        return graphRequest;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13634a(String userId, C6696b permissions, String accessToken, String name, Date expirationTime, Date dataAccessExpirationTime) {
        String message = getResources().getString(C6658d.com_facebook_smart_login_confirmation_title);
        String continueFormat = getResources().getString(C6658d.com_facebook_smart_login_confirmation_continue_as);
        String cancel = getResources().getString(C6658d.com_facebook_smart_login_confirmation_cancel);
        String continueText = String.format(continueFormat, new Object[]{name});
        Builder builder = new Builder(getContext());
        Builder cancelable = builder.setMessage(message).setCancelable(true);
        C6763h hVar = new C6763h(this, userId, permissions, accessToken, expirationTime, dataAccessExpirationTime);
        cancelable.setNegativeButton(continueText, hVar).setPositiveButton(cancel, new C6762g(this));
        builder.create().show();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13636a(String accessToken, Long expiresIn, Long dataAccessExpirationTime) {
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,permissions,name");
        Date date = null;
        Date expirationTime = expiresIn.longValue() != 0 ? new Date(new Date().getTime() + (expiresIn.longValue() * 1000)) : null;
        if (!(dataAccessExpirationTime.longValue() == 0 || dataAccessExpirationTime == null)) {
            date = new Date(dataAccessExpirationTime.longValue() * 1000);
        }
        Date dataAccessExpirationTimeDate = date;
        AccessToken accessToken2 = new AccessToken(accessToken, C6787r.m13816f(), BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID, null, null, null, null, expirationTime, null, dataAccessExpirationTimeDate);
        Date date2 = expirationTime;
        GraphRequest request = new GraphRequest(accessToken2, "me", parameters, C6534A.GET, new C6764i(this, accessToken, expirationTime, dataAccessExpirationTimeDate));
        request.mo19681c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13635a(String userId, C6696b permissions, String accessToken, Date expirationTime, Date dataAccessExpirationTime) {
        this.f12356d.mo20024a(accessToken, C6787r.m13816f(), userId, permissions.mo19910c(), permissions.mo19908a(), permissions.mo19909b(), C6665h.DEVICE_AUTH, expirationTime, null, dataAccessExpirationTime);
        this.f12361i.dismiss();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo20008a(FacebookException ex) {
        if (this.f12357e.compareAndSet(false, true)) {
            if (this.f12360h != null) {
                C6652b.m13274a(this.f12360h.mo20019d());
            }
            this.f12356d.mo20023a((Exception) ex);
            this.f12361i.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo20011b() {
        if (this.f12357e.compareAndSet(false, true)) {
            if (this.f12360h != null) {
                C6652b.m13274a(this.f12360h.mo20019d());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler = this.f12356d;
            if (deviceAuthMethodHandler != null) {
                deviceAuthMethodHandler.mo20027f();
            }
            this.f12361i.dismiss();
        }
    }
}
