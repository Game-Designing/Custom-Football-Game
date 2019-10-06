package p005cm.aptoide.analytics.implementation.data;

import java.util.Map;
import p005cm.aptoide.analytics.AnalyticsManager.Action;

/* renamed from: cm.aptoide.analytics.implementation.data.Event */
public class Event {
    private final Action action;
    private final String context;
    private final Map<String, Object> data;
    private final String eventName;
    private final long timeStamp;

    public Event(String eventName2, Map<String, Object> data2, Action action2, String context2, long timeStamp2) {
        this.eventName = eventName2;
        this.data = data2;
        this.action = action2;
        this.context = context2;
        this.timeStamp = timeStamp2;
    }

    public int hashCode() {
        int hashCode = this.eventName.hashCode() * 31;
        Map<String, Object> map = this.data;
        int result = (((((hashCode + (map != null ? map.hashCode() : 0)) * 31) + this.action.hashCode()) * 31) + this.context.hashCode()) * 31;
        long j = this.timeStamp;
        return result + ((int) (j ^ (j >>> 32)));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Event)) {
            return false;
        }
        Event event = (Event) o;
        if (this.timeStamp != event.timeStamp || !this.eventName.equals(event.eventName)) {
            return false;
        }
        Map<String, Object> map = this.data;
        if (map == null ? event.data != null : !map.equals(event.data)) {
            return false;
        }
        if (this.action != event.action) {
            return false;
        }
        return this.context.equals(event.context);
    }

    public String getEventName() {
        return this.eventName;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public Action getAction() {
        return this.action;
    }

    public String getContext() {
        return this.context;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }
}
