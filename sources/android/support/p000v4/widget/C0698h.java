package android.support.p000v4.widget;

/* renamed from: android.support.v4.widget.h */
/* compiled from: ContentLoadingProgressBar */
class C0698h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ContentLoadingProgressBar f2054a;

    C0698h(ContentLoadingProgressBar this$0) {
        this.f2054a = this$0;
    }

    public void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.f2054a;
        contentLoadingProgressBar.f1880b = false;
        contentLoadingProgressBar.f1879a = -1;
        contentLoadingProgressBar.setVisibility(8);
    }
}
