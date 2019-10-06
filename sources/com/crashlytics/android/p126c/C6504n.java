package com.crashlytics.android.p126c;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.concurrent.CountDownLatch;
import p024io.fabric.sdk.android.p348a.p353e.C13902p;

/* renamed from: com.crashlytics.android.c.n */
/* compiled from: CrashPromptDialog */
class C6504n {

    /* renamed from: a */
    private final C6506b f11676a;

    /* renamed from: b */
    private final Builder f11677b;

    /* renamed from: com.crashlytics.android.c.n$a */
    /* compiled from: CrashPromptDialog */
    interface C6505a {
        /* renamed from: a */
        void mo19504a(boolean z);
    }

    /* renamed from: com.crashlytics.android.c.n$b */
    /* compiled from: CrashPromptDialog */
    private static class C6506b {

        /* renamed from: a */
        private boolean f11678a;

        /* renamed from: b */
        private final CountDownLatch f11679b;

        private C6506b() {
            this.f11678a = false;
            this.f11679b = new CountDownLatch(1);
        }

        /* synthetic */ C6506b(C6498k x0) {
            this();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo19587a(boolean optIn) {
            this.f11678a = optIn;
            this.f11679b.countDown();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo19588b() {
            return this.f11678a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo19586a() {
            try {
                this.f11679b.await();
            } catch (InterruptedException e) {
            }
        }
    }

    /* renamed from: a */
    public static C6504n m12743a(Activity activity, C13902p promptData, C6505a alwaysSendCallback) {
        C6506b latch = new C6506b(null);
        C6511pa stringResolver = new C6511pa(activity, promptData);
        Builder builder = new Builder(activity);
        ScrollView scrollView = m12742a(activity, stringResolver.mo19597c());
        builder.setView(scrollView).setTitle(stringResolver.mo19599e()).setCancelable(false).setNeutralButton(stringResolver.mo19598d(), new C6498k(latch));
        if (promptData.f42171d) {
            builder.setNegativeButton(stringResolver.mo19596b(), new C6500l(latch));
        }
        if (promptData.f42173f) {
            builder.setPositiveButton(stringResolver.mo19595a(), new C6502m(alwaysSendCallback, latch));
        }
        return new C6504n(builder, latch);
    }

    /* renamed from: a */
    private static ScrollView m12742a(Activity activity, String message) {
        float density = activity.getResources().getDisplayMetrics().density;
        int textViewPadding = m12741a(density, 5);
        TextView textView = new TextView(activity);
        textView.setAutoLinkMask(15);
        textView.setText(message);
        textView.setTextAppearance(activity, 16973892);
        textView.setPadding(textViewPadding, textViewPadding, textViewPadding, textViewPadding);
        textView.setFocusable(false);
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setPadding(m12741a(density, 14), m12741a(density, 2), m12741a(density, 10), m12741a(density, 12));
        scrollView.addView(textView);
        return scrollView;
    }

    /* renamed from: a */
    private static int m12741a(float density, int dips) {
        return (int) (((float) dips) * density);
    }

    private C6504n(Builder dialog, C6506b latch) {
        this.f11676a = latch;
        this.f11677b = dialog;
    }

    /* renamed from: c */
    public void mo19585c() {
        this.f11677b.show();
    }

    /* renamed from: a */
    public void mo19583a() {
        this.f11676a.mo19586a();
    }

    /* renamed from: b */
    public boolean mo19584b() {
        return this.f11676a.mo19588b();
    }
}
