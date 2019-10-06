package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.ironsource.sdk.controller.C10877y.C10884f;
import com.ironsource.sdk.data.AdUnitsState;
import com.ironsource.sdk.data.C10895h;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p019d.p273h.p274a.C12725c;
import p019d.p273h.p285d.p287b.C12971c;
import p019d.p273h.p285d.p291e.C12980b;
import p019d.p273h.p285d.p292f.C12991g;
import p019d.p273h.p285d.p295h.C13003f;

public class ControllerActivity extends Activity implements C12991g, C10863la {

    /* renamed from: a */
    private static final String f32991a = ControllerActivity.class.getSimpleName();

    /* renamed from: b */
    public int f32992b = -1;

    /* renamed from: c */
    private C10877y f32993c;

    /* renamed from: d */
    private RelativeLayout f32994d;

    /* renamed from: e */
    private FrameLayout f32995e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f32996f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f32997g = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final Runnable f32998h = new C10844d(this);

    /* renamed from: i */
    final LayoutParams f32999i = new LayoutParams(-1, -1);

    /* renamed from: j */
    private boolean f33000j = false;

    /* renamed from: k */
    private String f33001k;

    /* renamed from: l */
    private AdUnitsState f33002l;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            C13003f.m42438c(f32991a, "onCreate");
            m35387i();
            m35388j();
            this.f32993c = C12971c.m42271a((Activity) this).mo41839b();
            this.f32993c.setId(1);
            this.f32993c.setOnWebViewControllerChangeListener(this);
            this.f32993c.setVideoEventsListener(this);
            Intent intent = getIntent();
            this.f33001k = intent.getStringExtra("productType");
            this.f32996f = intent.getBooleanExtra("immersive", false);
            if (this.f32996f) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new C10846e(this));
                runOnUiThread(this.f32998h);
            }
            if (!TextUtils.isEmpty(this.f33001k) && C10895h.OfferWall.toString().equalsIgnoreCase(this.f33001k)) {
                if (savedInstanceState != null) {
                    AdUnitsState state = (AdUnitsState) savedInstanceState.getParcelable("state");
                    if (state != null) {
                        this.f33002l = state;
                        this.f32993c.mo35458a(state);
                    }
                    finish();
                } else {
                    this.f33002l = this.f32993c.getSavedState();
                }
            }
            this.f32994d = new RelativeLayout(this);
            setContentView(this.f32994d, this.f32999i);
            this.f32995e = this.f32993c.getLayout();
            if (this.f32994d.findViewById(1) == null && this.f32995e.getParent() != null) {
                this.f33000j = true;
                finish();
            }
            m35389k();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    /* renamed from: k */
    private void m35389k() {
        Intent intent = getIntent();
        m35384b(intent.getStringExtra("orientation_set_flag"), intent.getIntExtra("rotation_set_flag", 0));
    }

    /* renamed from: b */
    private void m35384b(String orientation, int rotation) {
        if (orientation == null) {
            return;
        }
        if ("landscape".equalsIgnoreCase(orientation)) {
            m35392n();
        } else if ("portrait".equalsIgnoreCase(orientation)) {
            m35393o();
        } else if ("device".equalsIgnoreCase(orientation)) {
            if (C12725c.m41107l(this)) {
                setRequestedOrientation(1);
            }
        } else if (getRequestedOrientation() == -1) {
            setRequestedOrientation(4);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (!TextUtils.isEmpty(this.f33001k) && C10895h.OfferWall.toString().equalsIgnoreCase(this.f33001k)) {
            this.f33002l.mo35625c(true);
            outState.putParcelable("state", this.f33002l);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        C13003f.m42438c(f32991a, "onResume");
        this.f32994d.addView(this.f32995e, this.f32999i);
        C10877y yVar = this.f32993c;
        if (yVar != null) {
            yVar.mo35479c((Context) this);
            this.f32993c.mo35507m();
            this.f32993c.mo35472a(true, "main");
        }
        ((AudioManager) getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        C13003f.m42438c(f32991a, "onPause");
        ((AudioManager) getSystemService("audio")).abandonAudioFocus(null);
        C10877y yVar = this.f32993c;
        if (yVar != null) {
            yVar.mo35484d((Context) this);
            this.f32993c.mo35505k();
            this.f32993c.mo35472a(false, "main");
        }
        m35391m();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        String str = "onDestroy";
        C13003f.m42438c(f32991a, str);
        if (this.f33000j) {
            m35391m();
        }
        C10877y yVar = this.f32993c;
        if (yVar != null) {
            yVar.setState(C10884f.Gone);
            this.f32993c.mo35506l();
            this.f32993c.mo35480c(this.f33001k, str);
        }
    }

    /* renamed from: m */
    private void m35391m() {
        if (this.f32994d != null) {
            ViewGroup parent = (ViewGroup) this.f32995e.getParent();
            if (parent.findViewById(1) != null) {
                parent.removeView(this.f32995e);
            }
        }
    }

    /* renamed from: b */
    public void mo35357b() {
        finish();
    }

    /* renamed from: a */
    public void mo35354a(String orientation, int rotation) {
        m35384b(orientation, rotation);
    }

    /* renamed from: a */
    public boolean mo35356a() {
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        C13003f.m42438c(f32991a, "onBackPressed");
        if (!C12980b.m42339a().mo41856a(this)) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        C13003f.m42438c(f32991a, "onUserLeaveHint");
    }

    /* renamed from: i */
    private void m35387i() {
        requestWindowFeature(1);
    }

    /* renamed from: j */
    private void m35388j() {
        getWindow().setFlags(Opcodes.ACC_ABSTRACT, Opcodes.ACC_ABSTRACT);
    }

    /* renamed from: l */
    private void m35390l() {
        runOnUiThread(new C10848f(this));
    }

    /* renamed from: h */
    private void m35386h() {
        runOnUiThread(new C10850g(this));
    }

    /* renamed from: n */
    private void m35392n() {
        int rotation = C12725c.m41092c(this);
        C13003f.m42438c(f32991a, "setInitiateLandscapeOrientation");
        if (rotation == 0) {
            C13003f.m42438c(f32991a, "ROTATION_0");
            setRequestedOrientation(0);
        } else if (rotation == 2) {
            C13003f.m42438c(f32991a, "ROTATION_180");
            setRequestedOrientation(8);
        } else if (rotation == 3) {
            C13003f.m42438c(f32991a, "ROTATION_270 Right Landscape");
            setRequestedOrientation(8);
        } else if (rotation == 1) {
            C13003f.m42438c(f32991a, "ROTATION_90 Left Landscape");
            setRequestedOrientation(0);
        } else {
            C13003f.m42438c(f32991a, "No Rotation");
        }
    }

    /* renamed from: o */
    private void m35393o() {
        int rotation = C12725c.m41092c(this);
        C13003f.m42438c(f32991a, "setInitiatePortraitOrientation");
        if (rotation == 0) {
            C13003f.m42438c(f32991a, "ROTATION_0");
            setRequestedOrientation(1);
        } else if (rotation == 2) {
            C13003f.m42438c(f32991a, "ROTATION_180");
            setRequestedOrientation(9);
        } else if (rotation == 1) {
            C13003f.m42438c(f32991a, "ROTATION_270 Right Landscape");
            setRequestedOrientation(1);
        } else if (rotation == 3) {
            C13003f.m42438c(f32991a, "ROTATION_90 Left Landscape");
            setRequestedOrientation(1);
        } else {
            C13003f.m42438c(f32991a, "No Rotation");
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || !this.f32993c.mo35502h()) {
            if (this.f32996f && (keyCode == 25 || keyCode == 24)) {
                this.f32997g.removeCallbacks(this.f32998h);
                this.f32997g.postDelayed(this.f32998h, 500);
            }
            return super.onKeyDown(keyCode, event);
        }
        this.f32993c.mo35492g();
        return true;
    }

    public void setRequestedOrientation(int requestedOrientation) {
        if (this.f32992b != requestedOrientation) {
            String str = f32991a;
            StringBuilder sb = new StringBuilder();
            sb.append("Rotation: Req = ");
            sb.append(requestedOrientation);
            sb.append(" Curr = ");
            sb.append(this.f32992b);
            C13003f.m42438c(str, sb.toString());
            this.f32992b = requestedOrientation;
            super.setRequestedOrientation(requestedOrientation);
        }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (this.f32996f && hasFocus) {
            runOnUiThread(this.f32998h);
        }
    }

    /* renamed from: c */
    public void mo35358c() {
        mo35355a(true);
    }

    /* renamed from: d */
    public void mo35359d() {
        mo35355a(false);
    }

    /* renamed from: g */
    public void mo35362g() {
        mo35355a(true);
    }

    /* renamed from: e */
    public void mo35360e() {
        mo35355a(false);
    }

    /* renamed from: f */
    public void mo35361f() {
        mo35355a(false);
    }

    /* renamed from: a */
    public void mo35355a(boolean screenOn) {
        if (screenOn) {
            m35390l();
        } else {
            m35386h();
        }
    }
}
