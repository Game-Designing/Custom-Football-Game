package com.integralads.avid.library.mopub.walking.async;

import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.walking.async.AvidAsyncTask.StateProvider;
import java.util.HashSet;
import org.json.JSONObject;

public abstract class AbstractAvidPublishAsyncTask extends AvidAsyncTask {
    protected final AvidAdSessionRegistry adSessionRegistry;
    protected final HashSet<String> sessionIds;
    protected final JSONObject state;
    protected final double timestamp;

    public AvidAdSessionRegistry getAdSessionRegistry() {
        return this.adSessionRegistry;
    }

    public HashSet<String> getSessionIds() {
        return this.sessionIds;
    }

    public JSONObject getState() {
        return this.state;
    }

    public double getTimestamp() {
        return this.timestamp;
    }

    public AbstractAvidPublishAsyncTask(StateProvider stateProvider, AvidAdSessionRegistry adSessionRegistry2, HashSet<String> sessionIds2, JSONObject state2, double timestamp2) {
        super(stateProvider);
        this.adSessionRegistry = adSessionRegistry2;
        this.sessionIds = new HashSet<>(sessionIds2);
        this.state = state2;
        this.timestamp = timestamp2;
    }
}
