package p005cm.aptoide.p006pt.analytics.analytics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.data.Event;
import p005cm.aptoide.p006pt.database.realm.RealmEvent;

/* renamed from: cm.aptoide.pt.analytics.analytics.RealmEventMapper */
public class RealmEventMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ObjectMapper objectMapper;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3624114997044997061L, "cm/aptoide/pt/analytics/analytics/RealmEventMapper", 12);
        $jacocoData = probes;
        return probes;
    }

    public RealmEventMapper(ObjectMapper objectMapper2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.objectMapper = objectMapper2;
        $jacocoInit[0] = true;
    }

    public RealmEvent map(Event event) throws JsonProcessingException {
        boolean[] $jacocoInit = $jacocoInit();
        long timeStamp = event.getTimeStamp();
        String eventName = event.getEventName();
        Action action = event.getAction();
        $jacocoInit[1] = true;
        RealmEvent realmEvent = new RealmEvent(timeStamp, eventName, action.ordinal(), event.getContext(), this.objectMapper.writeValueAsString(event.getData()));
        $jacocoInit[2] = true;
        return realmEvent;
    }

    public List<Event> map(List<RealmEvent> realmEvents) throws IOException {
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList<Event> events = new ArrayList<>();
        $jacocoInit[3] = true;
        $jacocoInit[4] = true;
        for (RealmEvent realmEvent : realmEvents) {
            $jacocoInit[5] = true;
            String eventName = realmEvent.getEventName();
            ObjectMapper objectMapper2 = this.objectMapper;
            $jacocoInit[6] = true;
            Map map = (Map) objectMapper2.readValue(realmEvent.getData(), (TypeReference) new TypeReference<Map<String, Object>>(this) {
                private static transient /* synthetic */ boolean[] $jacocoData;
                final /* synthetic */ RealmEventMapper this$0;

                private static /* synthetic */ boolean[] $jacocoInit() {
                    boolean[] zArr = $jacocoData;
                    if (zArr != null) {
                        return zArr;
                    }
                    boolean[] probes = Offline.getProbes(-5846692583650636189L, "cm/aptoide/pt/analytics/analytics/RealmEventMapper$1", 1);
                    $jacocoData = probes;
                    return probes;
                }

                {
                    boolean[] $jacocoInit = $jacocoInit();
                    this.this$0 = this$0;
                    $jacocoInit[0] = true;
                }
            });
            $jacocoInit[7] = true;
            Action action = Action.values()[realmEvent.getAction()];
            String context = realmEvent.getContext();
            $jacocoInit[8] = true;
            Event event = new Event(eventName, map, action, context, realmEvent.getTimestamp());
            $jacocoInit[9] = true;
            events.add(event);
            $jacocoInit[10] = true;
        }
        $jacocoInit[11] = true;
        return events;
    }
}
