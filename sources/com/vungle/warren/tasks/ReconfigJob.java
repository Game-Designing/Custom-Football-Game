package com.vungle.warren.tasks;

import android.os.Bundle;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;

public class ReconfigJob implements Job {
    public static final String TAG = ReconfigJob.class.getCanonicalName();
    private ReconfigCall reconfigCall;

    public interface ReconfigCall {
        void reConfigVungle();
    }

    public ReconfigJob(ReconfigCall reconfigCall2) {
        this.reconfigCall = reconfigCall2;
    }

    public static JobInfo makeJobInfo(String appID) {
        Bundle extras = new Bundle();
        extras.putString(InneractiveMediationDefs.REMOTE_KEY_APP_ID, appID);
        return new JobInfo(TAG).setExtras(extras).setUpdateCurrent(true).setPriority(4);
    }

    public int onRunJob(Bundle params, JobRunner jobRunner) {
        if (params.getString(InneractiveMediationDefs.REMOTE_KEY_APP_ID, null) == null) {
            return 1;
        }
        this.reconfigCall.reConfigVungle();
        return 0;
    }
}
