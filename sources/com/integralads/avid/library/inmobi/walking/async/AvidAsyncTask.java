package com.integralads.avid.library.inmobi.walking.async;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public abstract class AvidAsyncTask extends AsyncTask<Object, Void, String> {
    private AvidAsyncTaskListener listener;
    protected final StateProvider stateProvider;

    public interface AvidAsyncTaskListener {
        void onTaskCompleted(AvidAsyncTask avidAsyncTask);
    }

    public interface StateProvider {
        JSONObject getPreviousState();

        void setPreviousState(JSONObject jSONObject);
    }

    public AvidAsyncTask(StateProvider stateProvider2) {
        this.stateProvider = stateProvider2;
    }

    public void setListener(AvidAsyncTaskListener avidAsyncTaskListener) {
        this.listener = avidAsyncTaskListener;
    }

    public AvidAsyncTaskListener getListener() {
        return this.listener;
    }

    public StateProvider getStateProvider() {
        return this.stateProvider;
    }

    public void start(ThreadPoolExecutor threadPoolExecutor) {
        if (VERSION.SDK_INT > 11) {
            executeOnExecutor(threadPoolExecutor, new Object[0]);
        } else {
            execute(new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        AvidAsyncTaskListener avidAsyncTaskListener = this.listener;
        if (avidAsyncTaskListener != null) {
            avidAsyncTaskListener.onTaskCompleted(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public String invokeDoInBackground() {
        return (String) doInBackground(new Object[0]);
    }

    /* access modifiers changed from: 0000 */
    public void invokeOnPostExecute(String str) {
        onPostExecute(str);
    }
}
