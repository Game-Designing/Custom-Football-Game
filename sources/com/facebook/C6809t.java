package com.facebook;

import com.facebook.GraphRequest.C6545b;
import com.facebook.internal.C6676H;
import com.facebook.internal.C6694S;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.t */
/* compiled from: GraphRequest */
class C6809t implements C6545b {

    /* renamed from: a */
    final /* synthetic */ C6545b f12523a;

    /* renamed from: b */
    final /* synthetic */ GraphRequest f12524b;

    C6809t(GraphRequest this$0, C6545b bVar) {
        this.f12524b = this$0;
        this.f12523a = bVar;
    }

    /* renamed from: a */
    public void mo9460a(C6817z response) {
        JSONObject responseObject = response.mo20228b();
        JSONObject debug = responseObject != null ? responseObject.optJSONObject("__debug__") : null;
        JSONArray debugMessages = debug != null ? debug.optJSONArray("messages") : null;
        if (debugMessages != null) {
            for (int i = 0; i < debugMessages.length(); i++) {
                JSONObject debugMessageObject = debugMessages.optJSONObject(i);
                String debugMessage = debugMessageObject != null ? debugMessageObject.optString("message") : null;
                String debugMessageType = debugMessageObject != null ? debugMessageObject.optString("type") : null;
                String debugMessageLink = debugMessageObject != null ? debugMessageObject.optString("link") : null;
                if (!(debugMessage == null || debugMessageType == null)) {
                    C6537C behavior = C6537C.GRAPH_API_DEBUG_INFO;
                    if (debugMessageType.equals("warning")) {
                        behavior = C6537C.GRAPH_API_DEBUG_WARNING;
                    }
                    if (!C6694S.m13436b(debugMessageLink)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(debugMessage);
                        sb.append(" Link: ");
                        sb.append(debugMessageLink);
                        debugMessage = sb.toString();
                    }
                    C6676H.m13322a(behavior, GraphRequest.f11802a, debugMessage);
                }
            }
        }
        C6545b bVar = this.f12523a;
        if (bVar != null) {
            bVar.mo9460a(response);
        }
    }
}
