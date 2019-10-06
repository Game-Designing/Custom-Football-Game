package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.mopub.common.AdType;
import com.mopub.common.DataKeys;
import com.mopub.common.FullAdType;
import com.mopub.common.IntentActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Intents;
import com.mopub.common.util.Reflection;
import com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener;
import com.mopub.mraid.MraidVideoViewController;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public class MraidVideoPlayerActivity extends BaseVideoPlayerActivity implements BaseVideoViewControllerListener {

    /* renamed from: a */
    private BaseVideoViewController f34882a;

    /* renamed from: b */
    private long f34883b;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().addFlags(Opcodes.ACC_ABSTRACT);
        this.f34883b = m37507a(getIntent());
        try {
            this.f34882a = m37508a(savedInstanceState);
            this.f34882a.mo36934e();
        } catch (IllegalStateException e) {
            BaseBroadcastReceiver.broadcastAction(this, this.f34883b, IntentActions.ACTION_INTERSTITIAL_FAIL);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        BaseVideoViewController baseVideoViewController = this.f34882a;
        if (baseVideoViewController != null) {
            baseVideoViewController.mo36936g();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        BaseVideoViewController baseVideoViewController = this.f34882a;
        if (baseVideoViewController != null) {
            baseVideoViewController.mo36938h();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        BaseVideoViewController baseVideoViewController = this.f34882a;
        if (baseVideoViewController != null) {
            baseVideoViewController.mo36935f();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        BaseVideoViewController baseVideoViewController = this.f34882a;
        if (baseVideoViewController != null) {
            baseVideoViewController.mo36926a(outState);
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        BaseVideoViewController baseVideoViewController = this.f34882a;
        if (baseVideoViewController != null) {
            baseVideoViewController.mo36925a(newConfig);
        }
    }

    public void onBackPressed() {
        BaseVideoViewController baseVideoViewController = this.f34882a;
        if (baseVideoViewController != null && baseVideoViewController.backButtonEnabled()) {
            super.onBackPressed();
            this.f34882a.mo36933d();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        BaseVideoViewController baseVideoViewController = this.f34882a;
        if (baseVideoViewController != null) {
            baseVideoViewController.mo36924a(requestCode, resultCode, data);
        }
    }

    /* renamed from: a */
    private BaseVideoViewController m37508a(Bundle savedInstanceState) throws IllegalStateException {
        String clazz = getIntent().getStringExtra(BaseVideoPlayerActivity.VIDEO_CLASS_EXTRAS_KEY);
        if (FullAdType.VAST.equals(clazz)) {
            VastVideoViewController vastVideoViewController = new VastVideoViewController(this, getIntent().getExtras(), savedInstanceState, this.f34883b, this);
            return vastVideoViewController;
        } else if (AdType.MRAID.equals(clazz)) {
            return new MraidVideoViewController(this, getIntent().getExtras(), savedInstanceState, this);
        } else {
            if ("native".equals(clazz)) {
                Class[] constructorParameterClasses = {Context.class, Bundle.class, Bundle.class, BaseVideoViewControllerListener.class};
                Object[] constructorParameterValues = {this, getIntent().getExtras(), savedInstanceState, this};
                String str = "com.mopub.nativeads.NativeVideoViewController";
                String str2 = "Missing native video module";
                if (Reflection.classFound(str)) {
                    try {
                        return (BaseVideoViewController) Reflection.instantiateClassWithConstructor(str, BaseVideoViewController.class, constructorParameterClasses, constructorParameterValues);
                    } catch (Exception e) {
                        throw new IllegalStateException(str2);
                    }
                } else {
                    throw new IllegalStateException(str2);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unsupported video type: ");
                sb.append(clazz);
                throw new IllegalStateException(sb.toString());
            }
        }
    }

    public void onSetContentView(View view) {
        setContentView(view);
    }

    public void onSetRequestedOrientation(int requestedOrientation) {
        setRequestedOrientation(requestedOrientation);
    }

    public void onFinish() {
        finish();
    }

    public void onStartActivityForResult(Class<? extends Activity> clazz, int requestCode, Bundle extras) {
        if (clazz != null) {
            try {
                startActivityForResult(Intents.getStartActivityIntent(this, clazz, extras), requestCode);
            } catch (ActivityNotFoundException e) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("Activity ");
                sb.append(clazz.getName());
                sb.append(" not found. Did you declare it in your AndroidManifest.xml?");
                MoPubLog.log(sdkLogEvent, sb.toString());
            }
        }
    }

    /* renamed from: a */
    protected static long m37507a(Intent intent) {
        return intent.getLongExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, -1);
    }
}
