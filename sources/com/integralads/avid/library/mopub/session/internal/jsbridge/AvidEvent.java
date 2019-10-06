package com.integralads.avid.library.mopub.session.internal.jsbridge;

import org.json.JSONObject;

public class AvidEvent {
    private JSONObject data;
    private int tag;
    private String type;

    public AvidEvent() {
    }

    public AvidEvent(int tag2, String type2, JSONObject data2) {
        this.tag = tag2;
        this.type = type2;
        this.data = data2;
    }

    public AvidEvent(int tag2, String type2) {
        this(tag2, type2, null);
    }

    public int getTag() {
        return this.tag;
    }

    public void setTag(int tag2) {
        this.tag = tag2;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type2) {
        this.type = type2;
    }

    public JSONObject getData() {
        return this.data;
    }

    public void setData(JSONObject data2) {
        this.data = data2;
    }
}
