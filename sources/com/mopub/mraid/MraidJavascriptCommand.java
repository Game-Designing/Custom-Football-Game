package com.mopub.mraid;

public enum MraidJavascriptCommand {
    CLOSE("close"),
    EXPAND("expand"),
    USE_CUSTOM_CLOSE("usecustomclose"),
    OPEN("open"),
    RESIZE("resize"),
    SET_ORIENTATION_PROPERTIES("setOrientationProperties"),
    PLAY_VIDEO("playVideo"),
    STORE_PICTURE("storePicture"),
    CREATE_CALENDAR_EVENT("createCalendarEvent"),
    UNSPECIFIED("");
    

    /* renamed from: b */
    private final String f35532b;

    private MraidJavascriptCommand(String javascriptString) {
        this.f35532b = javascriptString;
    }

    /* renamed from: a */
    static MraidJavascriptCommand m38034a(String string) {
        MraidJavascriptCommand[] values;
        for (MraidJavascriptCommand command : values()) {
            if (command.f35532b.equals(string)) {
                return command;
            }
        }
        return UNSPECIFIED;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo37677e() {
        return this.f35532b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo37676a(PlacementType placementType) {
        return false;
    }
}
