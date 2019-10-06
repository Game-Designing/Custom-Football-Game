package com.vungle.warren;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import com.vungle.warren.presenter.AdvertisementPresenter;
import com.vungle.warren.presenter.LocalAdPresenter;
import com.vungle.warren.presenter.WebAdPresenter;
import java.io.File;

public class AdvertisementPresenterFactory {
    private static final String EXTRA_ADVERTISEMENT = "ADV_FACTORY_ADVERTISEMENT";
    private static final String TAG = AdvertisementPresenterFactory.class.getSimpleName();
    private Advertisement advertisement;
    private final Storage storage = Vungle._instance.storage;

    public AdvertisementPresenter getAdPresenter(String placementId, Bundle savedInstanceState, String userId) throws IllegalArgumentException, IllegalStateException {
        if (TextUtils.isEmpty(placementId)) {
            throw new IllegalArgumentException("Missing placementID! Cannot play advertisement.");
        } else if (this.storage == null || !Vungle.isInitialized()) {
            throw new IllegalStateException("Vungle SDK is not initialized");
        } else {
            Placement placement = (Placement) this.storage.load(placementId, Placement.class);
            if (placement != null) {
                if (savedInstanceState == null) {
                    this.advertisement = this.storage.findValidAdvertisementForPlacement(placementId);
                } else {
                    String adId = savedInstanceState.getString(EXTRA_ADVERTISEMENT);
                    if (!TextUtils.isEmpty(adId)) {
                        this.advertisement = (Advertisement) this.storage.load(adId, Advertisement.class);
                    }
                }
                if (!Vungle.canPlayAd(this.advertisement)) {
                    Log.e(TAG, "Advertisement is null or assets are missing");
                    return null;
                }
                File assetDir = this.storage.getAdvertisementAssetDirectory(this.advertisement.getId());
                if (assetDir.isDirectory()) {
                    int adType = this.advertisement.getAdType();
                    if (adType == 0) {
                        LocalAdPresenter localAdPresenter = new LocalAdPresenter(this.advertisement, placement, this.storage, assetDir, userId);
                        return localAdPresenter;
                    } else if (adType == 1) {
                        WebAdPresenter webAdPresenter = new WebAdPresenter(this.advertisement, placement, this.storage, assetDir, userId);
                        return webAdPresenter;
                    } else {
                        throw new IllegalArgumentException("No presenter available for ad type!");
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("No asset directory for ");
                    sb.append(placementId);
                    sb.append(" exists!");
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No placement for ID ");
                sb2.append(placementId);
                sb2.append(" found. Please use a valid placement ID");
                throw new IllegalArgumentException(sb2.toString());
            }
        }
    }

    public void saveState(Bundle bundle) {
        Advertisement advertisement2 = this.advertisement;
        bundle.putString(EXTRA_ADVERTISEMENT, advertisement2 == null ? null : advertisement2.getId());
    }
}
