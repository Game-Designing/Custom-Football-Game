package com.unity3d.services.monetization.placementcontent.core;

import java.util.HashMap;
import java.util.Map;

public class CustomEvent {
    private String category;
    private Map<String, Object> data;
    private String type;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String category;
        /* access modifiers changed from: private */
        public Map<String, Object> data;
        /* access modifiers changed from: private */
        public String type;

        private Builder() {
        }

        public Builder withCategory(String val) {
            this.category = val;
            return this;
        }

        public Builder withType(String val) {
            this.type = val;
            return this;
        }

        public Builder withData(Map<String, Object> val) {
            this.data = val;
            return this;
        }

        public Builder putAllData(Map<String, Object> vals) {
            Map<String, Object> map = this.data;
            if (map == null) {
                this.data = new HashMap(vals);
            } else {
                map.putAll(vals);
            }
            return this;
        }

        public Builder putData(String key, Object value) {
            if (this.data == null) {
                this.data = new HashMap();
            }
            this.data.put(key, value);
            return this;
        }

        public CustomEvent build() {
            return new CustomEvent(this);
        }
    }

    public CustomEvent() {
    }

    public CustomEvent(String type2) {
        this.type = type2;
    }

    public CustomEvent(String type2, Map<String, Object> data2) {
        this.type = type2;
        this.data = data2;
    }

    public CustomEvent(String category2, String type2, Map<String, Object> data2) {
        this.category = category2;
        this.type = type2;
        this.data = data2;
    }

    private CustomEvent(Builder builder) {
        setCategory(builder.category);
        setType(builder.type);
        setData(builder.data);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category2) {
        this.category = category2;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type2) {
        this.type = type2;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public void setData(Map<String, Object> data2) {
        this.data = data2;
    }
}
