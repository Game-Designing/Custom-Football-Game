package com.integralads.avid.library.mopub.walking;

import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.walking.async.AvidAsyncTask.StateProvider;
import com.integralads.avid.library.mopub.walking.async.AvidAsyncTaskQueue;
import com.integralads.avid.library.mopub.walking.async.AvidCleanupAsyncTask;
import com.integralads.avid.library.mopub.walking.async.AvidEmptyPublishAsyncTask;
import com.integralads.avid.library.mopub.walking.async.AvidPublishAsyncTask;
import java.util.HashSet;
import org.json.JSONObject;

public class AvidStatePublisher implements StateProvider {
    private final AvidAdSessionRegistry adSessionRegistry;
    private JSONObject previousState;
    private final AvidAsyncTaskQueue taskQueue;

    public AvidStatePublisher(AvidAdSessionRegistry adSessionRegistry2, AvidAsyncTaskQueue taskQueue2) {
        this.adSessionRegistry = adSessionRegistry2;
        this.taskQueue = taskQueue2;
    }

    public void publishState(JSONObject state, HashSet<String> sessionIds, double timestamp) {
        AvidAsyncTaskQueue avidAsyncTaskQueue = this.taskQueue;
        AvidPublishAsyncTask avidPublishAsyncTask = new AvidPublishAsyncTask(this, this.adSessionRegistry, sessionIds, state, timestamp);
        avidAsyncTaskQueue.submitTask(avidPublishAsyncTask);
    }

    public void publishEmptyState(JSONObject emptyState, HashSet<String> sessionIds, double timestamp) {
        AvidAsyncTaskQueue avidAsyncTaskQueue = this.taskQueue;
        AvidEmptyPublishAsyncTask avidEmptyPublishAsyncTask = new AvidEmptyPublishAsyncTask(this, this.adSessionRegistry, sessionIds, emptyState, timestamp);
        avidAsyncTaskQueue.submitTask(avidEmptyPublishAsyncTask);
    }

    public void cleanupCache() {
        this.taskQueue.submitTask(new AvidCleanupAsyncTask(this));
    }

    public JSONObject getPreviousState() {
        return this.previousState;
    }

    public void setPreviousState(JSONObject previousState2) {
        this.previousState = previousState2;
    }
}
