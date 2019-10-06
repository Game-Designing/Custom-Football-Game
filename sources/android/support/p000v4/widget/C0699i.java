package android.support.p000v4.widget;

/* renamed from: android.support.v4.widget.i */
/* compiled from: ContentLoadingProgressBar */
class C0699i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ContentLoadingProgressBar f2055a;

    C0699i(ContentLoadingProgressBar this$0) {
        this.f2055a = this$0;
    }

    public void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.f2055a;
        contentLoadingProgressBar.f1881c = false;
        if (!contentLoadingProgressBar.f1882d) {
            contentLoadingProgressBar.f1879a = System.currentTimeMillis();
            this.f2055a.setVisibility(0);
        }
    }
}
