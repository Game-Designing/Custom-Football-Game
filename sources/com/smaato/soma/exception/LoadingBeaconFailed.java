package com.smaato.soma.exception;

public class LoadingBeaconFailed extends Exception {
    public LoadingBeaconFailed(String detailMessage) {
        super(detailMessage);
    }

    public LoadingBeaconFailed(Throwable throwable) {
        super(throwable);
    }
}
