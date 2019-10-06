package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.TimelineStats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetHomeMeta;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.MyStore */
public class MyStore {
    private final GetHomeMeta getHomeMeta;
    private final TimelineStats timelineStats;

    public MyStore(TimelineStats timelineStats2, GetHomeMeta getHomeMeta2) {
        this.timelineStats = timelineStats2;
        this.getHomeMeta = getHomeMeta2;
    }

    public TimelineStats getTimelineStats() {
        return this.timelineStats;
    }

    public GetHomeMeta getGetHomeMeta() {
        return this.getHomeMeta;
    }

    public boolean isCreateStore() {
        return this.getHomeMeta == null;
    }
}
