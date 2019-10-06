package p005cm.aptoide.analytics.implementation;

import java.util.List;
import p005cm.aptoide.analytics.implementation.data.Event;
import p026rx.C0117M;
import p026rx.C0120S;

/* renamed from: cm.aptoide.analytics.implementation.EventsPersistence */
public interface EventsPersistence {
    C0120S<List<Event>> getAll();

    C0117M remove(List<Event> list);

    C0117M save(Event event);

    C0117M save(List<Event> list);
}
