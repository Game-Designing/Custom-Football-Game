package com.unity3d.services.core.webview.bridge;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unity3d.services.core.log.DeviceLog;
import java.util.ArrayList;
import java.util.Arrays;

public class WebViewCallback implements Parcelable {
    public static final Creator<WebViewCallback> CREATOR = new Creator<WebViewCallback>() {
        public WebViewCallback createFromParcel(Parcel in) {
            return new WebViewCallback(in);
        }

        public WebViewCallback[] newArray(int size) {
            return new WebViewCallback[size];
        }
    };
    private String _callbackId;
    private int _invocationId;
    private boolean _invoked;

    public WebViewCallback(String callbackId, int invocationId) {
        this._callbackId = callbackId;
        this._invocationId = invocationId;
    }

    public WebViewCallback(Parcel in) {
        this._callbackId = in.readString();
        this._invoked = in.readByte() != 0;
        this._invocationId = in.readInt();
    }

    public void invoke(Object... params) {
        invoke(CallbackStatus.OK, null, params);
    }

    private void invoke(CallbackStatus status, Enum error, Object... params) {
        if (!this._invoked) {
            String str = this._callbackId;
            if (!(str == null || str.length() == 0)) {
                this._invoked = true;
                ArrayList<Object> paramList = new ArrayList<>();
                paramList.addAll(Arrays.asList(params));
                paramList.add(0, this._callbackId);
                Invocation invocation = Invocation.getInvocationById(this._invocationId);
                if (invocation == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Couldn't get batch with id: ");
                    sb.append(getInvocationId());
                    DeviceLog.error(sb.toString());
                    return;
                }
                invocation.setInvocationResponse(status, error, paramList.toArray());
            }
        }
    }

    public void error(Enum error, Object... params) {
        invoke(CallbackStatus.ERROR, error, params);
    }

    public int getInvocationId() {
        return this._invocationId;
    }

    public String getCallbackId() {
        return this._callbackId;
    }

    public int describeContents() {
        return 45678;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._callbackId);
        dest.writeByte(this._invoked ? (byte) 1 : 0);
        dest.writeInt(this._invocationId);
    }
}
