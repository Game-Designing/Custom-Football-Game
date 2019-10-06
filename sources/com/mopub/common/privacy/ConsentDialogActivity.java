package com.mopub.common.privacy;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.ConsentLogEvent;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.mobileads.MoPubErrorCode;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public class ConsentDialogActivity extends Activity {

    /* renamed from: a */
    C11267h f34437a;

    /* renamed from: b */
    private Runnable f34438b;

    /* renamed from: c */
    Handler f34439c;

    /* renamed from: d */
    ConsentStatus f34440d;

    /* renamed from: b */
    static void m37098b(Context context, String htmlData) {
        Preconditions.checkNotNull(context);
        if (TextUtils.isEmpty(htmlData)) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "ConsentDialogActivity htmlData can't be empty string.");
            MoPubLog.log(ConsentLogEvent.SHOW_FAILED, Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode()), MoPubErrorCode.INTERNAL_ERROR);
            return;
        }
        try {
            Intents.startActivity(context, m37095a(context, htmlData));
        } catch (ActivityNotFoundException | IntentNotResolvableException e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "ConsentDialogActivity not found - did you declare it in AndroidManifest.xml?");
            MoPubLog.log(ConsentLogEvent.SHOW_FAILED, Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode()), MoPubErrorCode.INTERNAL_ERROR);
        }
    }

    /* renamed from: a */
    static Intent m37095a(Context context, String htmlPageContent) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(htmlPageContent);
        Bundle extra = new Bundle();
        extra.putString("html-page-content", htmlPageContent);
        return Intents.getStartActivityIntent(context, ConsentDialogActivity.class, extra);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String htmlBody = getIntent().getStringExtra("html-page-content");
        if (TextUtils.isEmpty(htmlBody)) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Web page for ConsentDialogActivity is empty");
            MoPubLog.log(ConsentLogEvent.SHOW_FAILED, Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode()), MoPubErrorCode.INTERNAL_ERROR);
            finish();
            return;
        }
        requestWindowFeature(1);
        getWindow().addFlags(Opcodes.ACC_ABSTRACT);
        try {
            this.f34437a = new C11267h(this);
            this.f34437a.mo36776a((C11268a) new C11260a(this));
            this.f34438b = new C11261b(this);
            setContentView(this.f34437a);
            this.f34437a.mo36777a(htmlBody, new C11262c(this));
        } catch (RuntimeException e) {
            MoPubLog.log(SdkLogEvent.CUSTOM_WITH_THROWABLE, "Unable to create WebView", e);
            MoPubLog.log(ConsentLogEvent.SHOW_FAILED, Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode()), MoPubErrorCode.INTERNAL_ERROR);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f34439c = new Handler();
        this.f34439c.postDelayed(this.f34438b, 10000);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        MoPubLog.log(ConsentLogEvent.SHOW_SUCCESS, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        mo36669a(true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        PersonalInfoManager infoManager = MoPub.getPersonalInformationManager();
        if (infoManager != null) {
            ConsentStatus consentStatus = this.f34440d;
            if (consentStatus != null) {
                infoManager.mo36699a(consentStatus);
            }
        }
        super.onDestroy();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36669a(boolean visible) {
        Handler handler = this.f34439c;
        if (handler != null) {
            handler.removeCallbacks(this.f34438b);
        }
        C11267h hVar = this.f34437a;
        if (hVar != null) {
            hVar.setCloseVisible(visible);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37097a(ConsentStatus status) {
        Preconditions.checkNotNull(status);
        this.f34440d = status;
    }
}
