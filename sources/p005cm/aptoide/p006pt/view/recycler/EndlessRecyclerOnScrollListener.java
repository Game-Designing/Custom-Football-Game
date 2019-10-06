package p005cm.aptoide.p006pt.view.recycler;

import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0988n;
import java.util.LinkedList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7EndlessResponse;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.Endless;
import p005cm.aptoide.p006pt.view.recycler.displayable.ProgressBarDisplayable;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener */
public class EndlessRecyclerOnScrollListener extends C0988n {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BaseAdapter adapter;
    private final boolean bypassCache;
    private final boolean bypassServerCache;
    private boolean endCallbackCalled;
    private final ErrorRequestListener errorRequestListener;
    private boolean firstCallbackCalled;
    private int firstVisibleItem;
    private int lastTotal;
    private boolean loading;
    private final MultiLangPatch multiLangPatch;
    private int offset;
    private C0128a onEndOfListReachedListener;
    private final List<OnEndlessFinish> onEndlessFinishList;
    private BooleanAction onFirstLoadListener;
    private RecyclerViewPositionHelper recyclerViewPositionHelper;
    private boolean stableData = false;
    private C0137ja subscription;
    private C0129b successRequestListener;
    private int total;
    private int totalItemCount;
    private C0044V7<? extends BaseV7EndlessResponse, ? extends Endless> v7request;
    private int visibleItemCount;
    private final int visibleThreshold;

    /* renamed from: cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener$BooleanAction */
    public interface BooleanAction<T extends BaseV7Response> {
        boolean call(T t);
    }

    /* renamed from: cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener$OnEndlessFinish */
    public interface OnEndlessFinish {
        void onEndlessFinish(EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener);
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3228249567853336347L, "cm/aptoide/pt/view/recycler/EndlessRecyclerOnScrollListener", 111);
        $jacocoData = probes;
        return probes;
    }

    public <T extends BaseV7EndlessResponse> EndlessRecyclerOnScrollListener(BaseAdapter baseAdapter, C0044V7<T, ? extends Endless> v7request2, C0129b<T> successRequestListener2, ErrorRequestListener errorRequestListener2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter = baseAdapter;
        this.v7request = v7request2;
        this.successRequestListener = successRequestListener2;
        this.errorRequestListener = errorRequestListener2;
        this.visibleThreshold = 6;
        this.bypassCache = false;
        this.onFirstLoadListener = null;
        this.onEndOfListReachedListener = null;
        this.endCallbackCalled = false;
        this.firstCallbackCalled = false;
        $jacocoInit[0] = true;
        this.multiLangPatch = new MultiLangPatch();
        $jacocoInit[1] = true;
        this.onEndlessFinishList = new LinkedList();
        this.bypassServerCache = false;
        $jacocoInit[2] = true;
    }

    public <T extends BaseV7EndlessResponse> EndlessRecyclerOnScrollListener(BaseAdapter baseAdapter, C0044V7<T, ? extends Endless> v7request2, C0129b<T> successRequestListener2, ErrorRequestListener errorRequestListener2, int visibleThreshold2, boolean bypassCache2, BooleanAction<T> onFirstLoadListener2, C0128a onEndOfListReachedListener2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[3] = true;
        this.multiLangPatch = new MultiLangPatch();
        $jacocoInit[4] = true;
        this.onEndlessFinishList = new LinkedList();
        this.adapter = baseAdapter;
        this.v7request = v7request2;
        this.successRequestListener = successRequestListener2;
        this.errorRequestListener = errorRequestListener2;
        this.visibleThreshold = visibleThreshold2;
        this.bypassCache = bypassCache2;
        this.onFirstLoadListener = onFirstLoadListener2;
        this.onEndOfListReachedListener = onEndOfListReachedListener2;
        this.endCallbackCalled = false;
        this.firstCallbackCalled = false;
        this.bypassServerCache = false;
        $jacocoInit[5] = true;
    }

    public <T extends BaseV7EndlessResponse> EndlessRecyclerOnScrollListener(BaseAdapter baseAdapter, C0044V7<T, ? extends Endless> v7request2, C0129b<T> successRequestListener2, ErrorRequestListener errorRequestListener2, boolean bypassCache2, boolean bypassServerCache2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter = baseAdapter;
        this.v7request = v7request2;
        this.successRequestListener = successRequestListener2;
        this.errorRequestListener = errorRequestListener2;
        this.bypassServerCache = bypassServerCache2;
        this.visibleThreshold = 6;
        this.bypassCache = bypassCache2;
        this.onFirstLoadListener = null;
        this.onEndOfListReachedListener = null;
        this.endCallbackCalled = false;
        this.firstCallbackCalled = false;
        $jacocoInit[6] = true;
        this.multiLangPatch = new MultiLangPatch();
        $jacocoInit[7] = true;
        this.onEndlessFinishList = new LinkedList();
        $jacocoInit[8] = true;
    }

    public EndlessRecyclerOnScrollListener(BaseAdapter baseAdapter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter = baseAdapter;
        this.v7request = null;
        this.successRequestListener = null;
        this.errorRequestListener = null;
        this.visibleThreshold = 0;
        this.bypassCache = false;
        this.onFirstLoadListener = null;
        this.onEndOfListReachedListener = null;
        this.endCallbackCalled = false;
        this.firstCallbackCalled = false;
        $jacocoInit[9] = true;
        this.multiLangPatch = new MultiLangPatch();
        $jacocoInit[10] = true;
        this.onEndlessFinishList = new LinkedList();
        this.bypassServerCache = false;
        $jacocoInit[11] = true;
    }

    public BaseAdapter getAdapter() {
        boolean[] $jacocoInit = $jacocoInit();
        BaseAdapter baseAdapter = this.adapter;
        $jacocoInit[12] = true;
        return baseAdapter;
    }

    public void addOnEndlessFinishListener(OnEndlessFinish onEndlessFinish) {
        boolean[] $jacocoInit = $jacocoInit();
        this.onEndlessFinishList.add(onEndlessFinish);
        $jacocoInit[13] = true;
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        super.onScrolled(recyclerView, dx, dy);
        if (this.recyclerViewPositionHelper != null) {
            $jacocoInit[14] = true;
        } else {
            $jacocoInit[15] = true;
            this.recyclerViewPositionHelper = RecyclerViewPositionHelper.createHelper(recyclerView);
            $jacocoInit[16] = true;
        }
        this.visibleItemCount = recyclerView.getChildCount();
        $jacocoInit[17] = true;
        int firstVisibleItemPosition = this.recyclerViewPositionHelper.findFirstVisibleItemPosition();
        if (firstVisibleItemPosition == -1) {
            i = 0;
            $jacocoInit[18] = true;
        } else {
            $jacocoInit[19] = true;
            i = firstVisibleItemPosition;
        }
        this.firstVisibleItem = i;
        $jacocoInit[20] = true;
        if (!shouldLoadMore()) {
            $jacocoInit[21] = true;
        } else {
            $jacocoInit[22] = true;
            onLoadMore(this.bypassCache, this.bypassServerCache);
            $jacocoInit[23] = true;
        }
        $jacocoInit[24] = true;
    }

    private boolean shouldLoadMore() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.loading) {
            $jacocoInit[25] = true;
        } else {
            RecyclerViewPositionHelper recyclerViewPositionHelper2 = this.recyclerViewPositionHelper;
            if (recyclerViewPositionHelper2 == null) {
                $jacocoInit[26] = true;
            } else {
                RecyclerView recyclerView = recyclerViewPositionHelper2.recyclerView;
                $jacocoInit[27] = true;
                if (!recyclerView.isAttachedToWindow()) {
                    $jacocoInit[28] = true;
                } else {
                    $jacocoInit[29] = true;
                    if (!isNearTheEndOfTheList()) {
                        $jacocoInit[30] = true;
                    } else {
                        $jacocoInit[31] = true;
                        if (!hasMoreElements()) {
                            $jacocoInit[32] = true;
                        } else {
                            $jacocoInit[33] = true;
                            z = true;
                            $jacocoInit[35] = true;
                            return z;
                        }
                    }
                }
            }
        }
        z = false;
        $jacocoInit[34] = true;
        $jacocoInit[35] = true;
        return z;
    }

    private boolean isNearTheEndOfTheList() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.totalItemCount - this.visibleItemCount < (this.firstVisibleItem + this.visibleThreshold) - 1) {
            $jacocoInit[36] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[37] = true;
        }
        $jacocoInit[38] = true;
        return z;
    }

    public void onLoadMore(boolean bypassCache2, boolean bypassServerCache2) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.loading) {
            $jacocoInit[39] = true;
        } else {
            this.loading = true;
            $jacocoInit[40] = true;
            this.adapter.addDisplayable(new ProgressBarDisplayable());
            C0044V7<? extends BaseV7EndlessResponse, ? extends Endless> v7 = this.v7request;
            if (v7 == null) {
                $jacocoInit[41] = true;
            } else {
                $jacocoInit[42] = true;
                C0120S observe = v7.observe(bypassCache2, bypassServerCache2);
                $jacocoInit[43] = true;
                C0120S a = observe.mo3616a(C14522a.m46170a());
                C5373i iVar = new C5373i(this);
                $jacocoInit[44] = true;
                C0120S b = a.mo3636b((C0129b<? super T>) iVar);
                C5372h hVar = new C5372h(this, bypassCache2);
                C5374j jVar = new C5374j(this);
                $jacocoInit[45] = true;
                this.subscription = b.mo3626a((C0129b<? super T>) hVar, (C0129b<Throwable>) jVar);
                $jacocoInit[46] = true;
            }
        }
        $jacocoInit[47] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17278a(BaseV7EndlessResponse response) {
        boolean[] $jacocoInit = $jacocoInit();
        popProgressBarDisplayable();
        $jacocoInit[109] = true;
        this.multiLangPatch.updateTotal(response);
        $jacocoInit[110] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17279a(boolean bypassCache2, BaseV7EndlessResponse response) {
        boolean[] $jacocoInit = $jacocoInit();
        handleLoadMoreResponseAfterWebRequest(bypassCache2, response);
        $jacocoInit[108] = true;
    }

    /* access modifiers changed from: private */
    public void handleLoadMoreErrorAfterWebRequest(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        error.printStackTrace();
        $jacocoInit[48] = true;
        popProgressBarDisplayable();
        $jacocoInit[49] = true;
        this.errorRequestListener.onError(error);
        this.loading = false;
        $jacocoInit[50] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleLoadMoreResponseAfterWebRequest(boolean r6, p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7EndlessResponse r7) {
        /*
            r5 = this;
            boolean[] r0 = $jacocoInit()
            boolean r1 = r7.hasData()
            r2 = 1
            if (r1 != 0) goto L_0x0010
            r1 = 51
            r0[r1] = r2
            goto L_0x0068
        L_0x0010:
            r1 = 52
            r0[r1] = r2
            boolean r1 = r7.hasStableTotal()
            r5.stableData = r1
            boolean r1 = r5.stableData
            if (r1 == 0) goto L_0x0037
            r1 = 53
            r0[r1] = r2
            int r1 = r7.getTotal()
            r5.total = r1
            r1 = 54
            r0[r1] = r2
            int r1 = r7.getNextSize()
            r5.offset = r1
            r1 = 55
            r0[r1] = r2
            goto L_0x0053
        L_0x0037:
            int r1 = r5.total
            int r3 = r7.getTotal()
            r5.lastTotal = r3
            int r1 = r1 + r3
            r5.total = r1
            r1 = 56
            r0[r1] = r2
            int r1 = r5.offset
            int r3 = r7.getNextSize()
            int r1 = r1 + r3
            r5.offset = r1
            r1 = 57
            r0[r1] = r2
        L_0x0053:
            cm.aptoide.pt.dataprovider.ws.v7.V7<? extends cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse, ? extends cm.aptoide.pt.dataprovider.ws.v7.Endless> r1 = r5.v7request
            cm.aptoide.pt.dataprovider.ws.RefreshBody r1 = r1.getBody()
            cm.aptoide.pt.dataprovider.ws.v7.Endless r1 = (p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.Endless) r1
            int r3 = r5.offset
            r4 = 58
            r0[r4] = r2
            r1.setOffset(r3)
            r1 = 59
            r0[r1] = r2
        L_0x0068:
            cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener$BooleanAction r1 = r5.onFirstLoadListener
            if (r1 != 0) goto L_0x0071
            r1 = 60
            r0[r1] = r2
            goto L_0x0079
        L_0x0071:
            boolean r3 = r5.firstCallbackCalled
            if (r3 == 0) goto L_0x0083
            r1 = 61
            r0[r1] = r2
        L_0x0079:
            rx.b.b r1 = r5.successRequestListener
            r1.call(r7)
            r1 = 67
            r0[r1] = r2
            goto L_0x00a5
        L_0x0083:
            r3 = 62
            r0[r3] = r2
            boolean r1 = r1.call(r7)
            if (r1 == 0) goto L_0x0092
            r1 = 63
            r0[r1] = r2
            goto L_0x009f
        L_0x0092:
            r1 = 64
            r0[r1] = r2
            rx.b.b r1 = r5.successRequestListener
            r1.call(r7)
            r1 = 65
            r0[r1] = r2
        L_0x009f:
            r5.firstCallbackCalled = r2
            r1 = 66
            r0[r1] = r2
        L_0x00a5:
            r1 = 0
            r5.loading = r1
            cm.aptoide.pt.view.recycler.RecyclerViewPositionHelper r1 = r5.recyclerViewPositionHelper
            if (r1 != 0) goto L_0x00b1
            r1 = 68
            r0[r1] = r2
            goto L_0x00bf
        L_0x00b1:
            r3 = 69
            r0[r3] = r2
            int r1 = r1.getItemCount()
            r5.totalItemCount = r1
            r1 = 70
            r0[r1] = r2
        L_0x00bf:
            boolean r1 = r5.hasMoreElements()
            if (r1 == 0) goto L_0x00ca
            r1 = 71
            r0[r1] = r2
            goto L_0x0108
        L_0x00ca:
            rx.b.a r1 = r5.onEndOfListReachedListener
            if (r1 != 0) goto L_0x00d3
            r1 = 72
            r0[r1] = r2
            goto L_0x00e9
        L_0x00d3:
            boolean r3 = r5.endCallbackCalled
            if (r3 == 0) goto L_0x00dc
            r1 = 73
            r0[r1] = r2
            goto L_0x00e9
        L_0x00dc:
            r3 = 74
            r0[r3] = r2
            r1.call()
            r5.endCallbackCalled = r2
            r1 = 75
            r0[r1] = r2
        L_0x00e9:
            java.util.List<cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener$OnEndlessFinish> r1 = r5.onEndlessFinishList
            if (r1 != 0) goto L_0x00f2
            r1 = 76
            r0[r1] = r2
            goto L_0x0108
        L_0x00f2:
            r3 = 77
            r0[r3] = r2
            java.util.Iterator r1 = r1.iterator()
            r3 = 78
            r0[r3] = r2
        L_0x00fe:
            boolean r3 = r1.hasNext()
            if (r3 != 0) goto L_0x0125
            r1 = 79
            r0[r1] = r2
        L_0x0108:
            boolean r1 = r5.shouldLoadMore()
            if (r1 != 0) goto L_0x0113
            r1 = 84
            r0[r1] = r2
            goto L_0x0120
        L_0x0113:
            r1 = 85
            r0[r1] = r2
            boolean r1 = r5.bypassServerCache
            r5.onLoadMore(r6, r1)
            r1 = 86
            r0[r1] = r2
        L_0x0120:
            r1 = 87
            r0[r1] = r2
            return
        L_0x0125:
            java.lang.Object r3 = r1.next()
            cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener$OnEndlessFinish r3 = (p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener.OnEndlessFinish) r3
            if (r3 != 0) goto L_0x0132
            r4 = 80
            r0[r4] = r2
            goto L_0x013d
        L_0x0132:
            r4 = 81
            r0[r4] = r2
            r3.onEndlessFinish(r5)
            r4 = 82
            r0[r4] = r2
        L_0x013d:
            r3 = 83
            r0[r3] = r2
            goto L_0x00fe
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener.handleLoadMoreResponseAfterWebRequest(boolean, cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse):void");
    }

    private void popProgressBarDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.adapter.getItemCount() <= 0) {
            $jacocoInit[88] = true;
        } else {
            BaseAdapter baseAdapter = this.adapter;
            $jacocoInit[89] = true;
            int itemCount = baseAdapter.getItemCount() - 1;
            $jacocoInit[90] = true;
            if (!(baseAdapter.getDisplayable(itemCount) instanceof ProgressBarDisplayable)) {
                $jacocoInit[91] = true;
            } else {
                $jacocoInit[92] = true;
                this.adapter.popDisplayable();
                $jacocoInit[93] = true;
            }
        }
        $jacocoInit[94] = true;
    }

    /* access modifiers changed from: protected */
    public boolean hasMoreElements() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = false;
        if (this.stableData) {
            if (this.offset < this.total) {
                $jacocoInit[95] = true;
            } else {
                $jacocoInit[96] = true;
                $jacocoInit[99] = true;
                return z;
            }
        } else if (this.lastTotal != 0) {
            $jacocoInit[97] = true;
        } else {
            $jacocoInit[98] = true;
            $jacocoInit[99] = true;
            return z;
        }
        z = true;
        $jacocoInit[99] = true;
        return z;
    }

    public void removeListeners() {
        boolean[] $jacocoInit = $jacocoInit();
        this.onFirstLoadListener = null;
        this.onEndOfListReachedListener = null;
        this.successRequestListener = null;
        $jacocoInit[100] = true;
    }

    public void stopLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        C0137ja jaVar = this.subscription;
        if (jaVar == null) {
            $jacocoInit[101] = true;
        } else if (jaVar.isUnsubscribed()) {
            $jacocoInit[102] = true;
        } else {
            $jacocoInit[103] = true;
            this.subscription.unsubscribe();
            $jacocoInit[104] = true;
        }
        popProgressBarDisplayable();
        $jacocoInit[105] = true;
    }

    public void reset(C0044V7<? extends BaseV7EndlessResponse, ? extends Endless> v7request2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.v7request = v7request2;
        $jacocoInit[106] = true;
        this.multiLangPatch.updateOffset();
        this.offset = -1;
        this.total = 0;
        $jacocoInit[107] = true;
    }
}
