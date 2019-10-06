package com.inmobi.rendering.mraid;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import com.inmobi.commons.p217a.C10619a;
import com.inmobi.rendering.RenderView;

@SuppressLint({"ClickableViewAccessibility"})
public final class MraidMediaProcessor {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final String f32909f = MraidMediaProcessor.class.getSimpleName();

    /* renamed from: a */
    public RenderView f32910a;

    /* renamed from: b */
    public MediaRenderView f32911b;

    /* renamed from: c */
    public RingerModeChangeReceiver f32912c;

    /* renamed from: d */
    public C10776a f32913d;

    /* renamed from: e */
    public HeadphonesPluggedChangeReceiver f32914e;

    public final class HeadphonesPluggedChangeReceiver extends BroadcastReceiver {

        /* renamed from: b */
        private String f32919b;

        public HeadphonesPluggedChangeReceiver(String str) {
            this.f32919b = str;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                    boolean z = false;
                    int intExtra = intent.getIntExtra("state", 0);
                    MraidMediaProcessor.f32909f;
                    MraidMediaProcessor mraidMediaProcessor = MraidMediaProcessor.this;
                    String str = this.f32919b;
                    if (1 == intExtra) {
                        z = true;
                    }
                    MraidMediaProcessor.m35336b(mraidMediaProcessor, str, z);
                }
            }
        }
    }

    public final class RingerModeChangeReceiver extends BroadcastReceiver {

        /* renamed from: b */
        private String f32921b;

        public RingerModeChangeReceiver(String str) {
            this.f32921b = str;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if ("android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("android.media.EXTRA_RINGER_MODE", 2);
                    MraidMediaProcessor.f32909f;
                    MraidMediaProcessor.m35333a(MraidMediaProcessor.this, this.f32921b, 2 != intExtra);
                }
            }
        }
    }

    /* renamed from: com.inmobi.rendering.mraid.MraidMediaProcessor$a */
    public final class C10776a extends ContentObserver {

        /* renamed from: b */
        private Context f32923b;

        /* renamed from: c */
        private int f32924c = -1;

        /* renamed from: d */
        private String f32925d;

        public C10776a(String str, Context context, Handler handler) {
            super(handler);
            this.f32925d = str;
            this.f32923b = context;
        }

        public final void onChange(boolean z) {
            super.onChange(z);
            Context context = this.f32923b;
            if (context != null) {
                int streamVolume = ((AudioManager) context.getSystemService("audio")).getStreamVolume(3);
                if (streamVolume != this.f32924c) {
                    this.f32924c = streamVolume;
                    MraidMediaProcessor.m35332a(MraidMediaProcessor.this, this.f32925d, streamVolume);
                }
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m35332a(MraidMediaProcessor mraidMediaProcessor, String str, int i) {
        RenderView renderView = mraidMediaProcessor.f32910a;
        if (renderView != null) {
            StringBuilder sb = new StringBuilder("fireDeviceVolumeChangeEvent(");
            sb.append(i);
            sb.append(");");
            renderView.mo34556a(str, sb.toString());
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m35333a(MraidMediaProcessor mraidMediaProcessor, String str, boolean z) {
        RenderView renderView = mraidMediaProcessor.f32910a;
        if (renderView != null) {
            StringBuilder sb = new StringBuilder("fireDeviceMuteChangeEvent(");
            sb.append(z);
            sb.append(");");
            renderView.mo34556a(str, sb.toString());
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m35336b(MraidMediaProcessor mraidMediaProcessor, String str, boolean z) {
        RenderView renderView = mraidMediaProcessor.f32910a;
        if (renderView != null) {
            StringBuilder sb = new StringBuilder("fireHeadphonePluggedEvent(");
            sb.append(z);
            sb.append(");");
            renderView.mo34556a(str, sb.toString());
        }
    }

    public MraidMediaProcessor(RenderView renderView) {
        this.f32910a = renderView;
    }

    /* renamed from: a */
    public static boolean m35334a() {
        Context b = C10619a.m34839b();
        if (b == null || 2 == ((AudioManager) b.getSystemService("audio")).getRingerMode()) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public final void mo34776b() {
        Context b = C10619a.m34839b();
        if (b != null) {
            RingerModeChangeReceiver ringerModeChangeReceiver = this.f32912c;
            if (ringerModeChangeReceiver != null) {
                b.unregisterReceiver(ringerModeChangeReceiver);
                this.f32912c = null;
            }
        }
    }

    /* renamed from: c */
    public final void mo34777c() {
        Context b = C10619a.m34839b();
        if (!(b == null || this.f32913d == null)) {
            b.getContentResolver().unregisterContentObserver(this.f32913d);
            this.f32913d = null;
        }
    }

    /* renamed from: d */
    public static boolean m35337d() {
        Context b = C10619a.m34839b();
        if (b == null) {
            return false;
        }
        return ((AudioManager) b.getSystemService("audio")).isWiredHeadsetOn();
    }

    /* renamed from: e */
    public final void mo34778e() {
        Context b = C10619a.m34839b();
        if (b != null) {
            HeadphonesPluggedChangeReceiver headphonesPluggedChangeReceiver = this.f32914e;
            if (headphonesPluggedChangeReceiver != null) {
                b.unregisterReceiver(headphonesPluggedChangeReceiver);
                this.f32914e = null;
            }
        }
    }
}
