package p005cm.aptoide.p006pt.editorial;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.exception.NoNetworkConnectionException;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.EditorialCard;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.EditorialCard.Action;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.EditorialCard.Content;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.EditorialCard.Data;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.EditorialCard.Media;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App.Stats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App.Stats.Rating;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.File;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.Appearance;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.Caption;
import p005cm.aptoide.p006pt.editorial.EditorialViewModel.Error;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.editorial.EditorialService */
public class EditorialService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BodyInterceptor<BaseBody> bodyInterceptorPoolV7;
    private final Factory converterFactory;
    private boolean loading;
    private final OkHttpClient okHttpClient;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6000655479654317496L, "cm/aptoide/pt/editorial/EditorialService", 111);
        $jacocoData = probes;
        return probes;
    }

    public EditorialService(BodyInterceptor<BaseBody> bodyInterceptorPoolV72, OkHttpClient okHttpClient2, TokenInvalidator tokenInvalidator2, Factory converterFactory2, SharedPreferences sharedPreferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bodyInterceptorPoolV7 = bodyInterceptorPoolV72;
        this.okHttpClient = okHttpClient2;
        this.tokenInvalidator = tokenInvalidator2;
        this.converterFactory = converterFactory2;
        this.sharedPreferences = sharedPreferences2;
        $jacocoInit[0] = true;
    }

    public Single<EditorialViewModel> loadEditorialViewModel(String cardId) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.loading) {
            $jacocoInit[1] = true;
            Single<EditorialViewModel> a = Single.m734a(new EditorialViewModel(true));
            $jacocoInit[2] = true;
            return a;
        }
        EditorialRequest of = EditorialRequest.m7831of(cardId, this.bodyInterceptorPoolV7, this.okHttpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[3] = true;
        C0120S observe = of.observe();
        C3186lc lcVar = new C3186lc(this);
        $jacocoInit[4] = true;
        C0120S b = observe.mo3635b((C0128a) lcVar);
        C3174ic icVar = new C3174ic(this);
        $jacocoInit[5] = true;
        C0120S d = b.mo3652d((C0128a) icVar);
        C3182kc kcVar = new C3182kc(this);
        $jacocoInit[6] = true;
        C0120S c = d.mo3644c((C0128a) kcVar);
        C3170hc hcVar = new C3170hc(this, cardId);
        $jacocoInit[7] = true;
        C0120S f = c.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) hcVar);
        $jacocoInit[8] = true;
        Single n = f.mo3678n();
        C3178jc jcVar = new C3178jc(this);
        $jacocoInit[9] = true;
        Single<EditorialViewModel> f2 = n.mo3700f(jcVar);
        $jacocoInit[10] = true;
        return f2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13981a() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading = true;
        $jacocoInit[110] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo13982b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading = false;
        $jacocoInit[109] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo13983c() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading = false;
        $jacocoInit[108] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13980a(String cardId, EditorialCard editorialCard) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S mapEditorial = mapEditorial(editorialCard, cardId);
        $jacocoInit[107] = true;
        return mapEditorial;
    }

    /* renamed from: a */
    public /* synthetic */ EditorialViewModel mo13979a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialViewModel createErrorEditorialModel = createErrorEditorialModel(throwable);
        $jacocoInit[106] = true;
        return createErrorEditorialModel;
    }

    private EditorialViewModel createErrorEditorialModel(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof NoNetworkConnectionException) {
            $jacocoInit[11] = true;
            EditorialViewModel editorialViewModel = new EditorialViewModel(Error.NETWORK);
            $jacocoInit[12] = true;
            return editorialViewModel;
        }
        EditorialViewModel editorialViewModel2 = new EditorialViewModel(Error.GENERIC);
        $jacocoInit[13] = true;
        return editorialViewModel2;
    }

    private C0120S<EditorialViewModel> mapEditorial(EditorialCard editorialCard, String cardId) {
        EditorialContent bottomCardPlaceHolderContent;
        boolean[] $jacocoInit = $jacocoInit();
        if (editorialCard.isOk()) {
            $jacocoInit[14] = true;
            Data card = editorialCard.getData();
            $jacocoInit[15] = true;
            List<Content> contentList = card.getContent();
            $jacocoInit[16] = true;
            List<EditorialContent> editorialContentList = mapEditorialContent(contentList);
            $jacocoInit[17] = true;
            List<Integer> placeHolderPositions = getPlaceHolderPositions(editorialContentList);
            $jacocoInit[18] = true;
            List<EditorialContent> placeHolderContent = buildPlaceHolderContent(editorialContentList, placeHolderPositions);
            $jacocoInit[19] = true;
            if (placeHolderContent.isEmpty()) {
                $jacocoInit[20] = true;
            } else if (placeHolderContent.size() != 1) {
                $jacocoInit[21] = true;
            } else {
                $jacocoInit[22] = true;
                EditorialContent bottomCardPlaceHolderContent2 = (EditorialContent) placeHolderContent.get(0);
                $jacocoInit[23] = true;
                bottomCardPlaceHolderContent = bottomCardPlaceHolderContent2;
                $jacocoInit[24] = true;
                String type = card.getType();
                $jacocoInit[25] = true;
                EditorialViewModel editorialViewModel = buildEditorialViewModel(editorialContentList, card, placeHolderPositions, placeHolderContent, bottomCardPlaceHolderContent, cardId, type);
                $jacocoInit[26] = true;
                C0120S<EditorialViewModel> c = C0120S.m652c(editorialViewModel);
                $jacocoInit[27] = true;
                return c;
            }
            bottomCardPlaceHolderContent = null;
            $jacocoInit[24] = true;
            String type2 = card.getType();
            $jacocoInit[25] = true;
            EditorialViewModel editorialViewModel2 = buildEditorialViewModel(editorialContentList, card, placeHolderPositions, placeHolderContent, bottomCardPlaceHolderContent, cardId, type2);
            $jacocoInit[26] = true;
            C0120S<EditorialViewModel> c2 = C0120S.m652c(editorialViewModel2);
            $jacocoInit[27] = true;
            return c2;
        }
        C0120S<EditorialViewModel> a = C0120S.m631a((Throwable) new IllegalStateException("Could not obtain request from server."));
        $jacocoInit[28] = true;
        return a;
    }

    private List<EditorialContent> mapEditorialContent(List<Content> contentList) {
        boolean[] $jacocoInit = $jacocoInit();
        List<EditorialContent> editorialContentList = new ArrayList<>();
        if (contentList == null) {
            $jacocoInit[29] = true;
        } else {
            $jacocoInit[30] = true;
            int position = 0;
            $jacocoInit[31] = true;
            while (position < contentList.size()) {
                $jacocoInit[33] = true;
                Content content = (Content) contentList.get(position);
                $jacocoInit[34] = true;
                List<EditorialMedia> editorialMediaList = buildMediaList(content.getMedia());
                $jacocoInit[35] = true;
                App app = content.getApp();
                $jacocoInit[36] = true;
                Action action = content.getAction();
                $jacocoInit[37] = true;
                EditorialContent editorialContent = buildEditorialContent(content, editorialMediaList, app, action, position);
                $jacocoInit[38] = true;
                editorialContentList.add(editorialContent);
                position++;
                $jacocoInit[39] = true;
            }
            $jacocoInit[32] = true;
        }
        $jacocoInit[40] = true;
        return editorialContentList;
    }

    private List<Integer> getPlaceHolderPositions(List<EditorialContent> editorialContentList) {
        boolean[] $jacocoInit = $jacocoInit();
        List<Integer> placeHolderPositions = new ArrayList<>();
        if (editorialContentList == null) {
            $jacocoInit[41] = true;
        } else {
            $jacocoInit[42] = true;
            int contendIndex = 0;
            $jacocoInit[43] = true;
            while (contendIndex < editorialContentList.size()) {
                $jacocoInit[45] = true;
                EditorialContent editorialContent = (EditorialContent) editorialContentList.get(contendIndex);
                $jacocoInit[46] = true;
                if (!editorialContent.isPlaceHolderType()) {
                    $jacocoInit[47] = true;
                } else {
                    $jacocoInit[48] = true;
                    placeHolderPositions.add(Integer.valueOf(contendIndex));
                    $jacocoInit[49] = true;
                }
                contendIndex++;
                $jacocoInit[50] = true;
            }
            $jacocoInit[44] = true;
        }
        $jacocoInit[51] = true;
        return placeHolderPositions;
    }

    private List<EditorialContent> buildPlaceHolderContent(List<EditorialContent> editorialContentList, List<Integer> placeHolderPositions) {
        boolean[] $jacocoInit = $jacocoInit();
        List<EditorialContent> placeHolderContent = new ArrayList<>();
        $jacocoInit[52] = true;
        $jacocoInit[53] = true;
        for (Integer placeHolderPosition : placeHolderPositions) {
            $jacocoInit[54] = true;
            placeHolderContent.add(editorialContentList.get(placeHolderPosition.intValue()));
            $jacocoInit[55] = true;
        }
        $jacocoInit[56] = true;
        return placeHolderContent;
    }

    private List<EditorialMedia> buildMediaList(List<Media> mediaList) {
        boolean[] $jacocoInit = $jacocoInit();
        List<EditorialMedia> editorialMediaList = new ArrayList<>();
        if (mediaList == null) {
            $jacocoInit[57] = true;
        } else {
            $jacocoInit[58] = true;
            $jacocoInit[59] = true;
            for (Media media : mediaList) {
                $jacocoInit[61] = true;
                String type = media.getType();
                String description = media.getDescription();
                String thumbnail = media.getThumbnail();
                $jacocoInit[62] = true;
                EditorialMedia editorialMedia = new EditorialMedia(type, description, thumbnail, media.getImage());
                $jacocoInit[63] = true;
                editorialMediaList.add(editorialMedia);
                $jacocoInit[64] = true;
            }
            $jacocoInit[60] = true;
        }
        $jacocoInit[65] = true;
        return editorialMediaList;
    }

    private EditorialContent buildEditorialContent(Content content, List<EditorialMedia> editorialMediaList, App app, Action action, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (action == null) {
            $jacocoInit[66] = true;
        } else if (app == null) {
            $jacocoInit[67] = true;
        } else {
            $jacocoInit[68] = true;
            Store store = app.getStore();
            $jacocoInit[69] = true;
            File file = app.getFile();
            $jacocoInit[70] = true;
            String title = content.getTitle();
            String message = content.getMessage();
            $jacocoInit[71] = true;
            String type = content.getType();
            long id = app.getId();
            String name = app.getName();
            String icon = app.getIcon();
            Stats stats = app.getStats();
            $jacocoInit[72] = true;
            Rating rating = stats.getRating();
            $jacocoInit[73] = true;
            float avg = rating.getAvg();
            String packageName = app.getPackageName();
            long size = app.getSize();
            String graphic = app.getGraphic();
            Obb obb = app.getObb();
            $jacocoInit[74] = true;
            long id2 = store.getId();
            String name2 = store.getName();
            String vername = file.getVername();
            int vercode = file.getVercode();
            String path = file.getPath();
            $jacocoInit[75] = true;
            EditorialContent editorialContent = new EditorialContent(title, editorialMediaList, message, type, id, name, icon, avg, packageName, size, graphic, obb, id2, name2, vername, vercode, path, file.getPathAlt(), file.getMd5sum(), action.getTitle(), action.getUrl(), position);
            $jacocoInit[76] = true;
            return editorialContent;
        }
        if (app != null) {
            $jacocoInit[77] = true;
            Store store2 = app.getStore();
            $jacocoInit[78] = true;
            File file2 = app.getFile();
            $jacocoInit[79] = true;
            String title2 = content.getTitle();
            String message2 = content.getMessage();
            $jacocoInit[80] = true;
            String type2 = content.getType();
            long id3 = app.getId();
            String name3 = app.getName();
            String icon2 = app.getIcon();
            Stats stats2 = app.getStats();
            $jacocoInit[81] = true;
            Rating rating2 = stats2.getRating();
            $jacocoInit[82] = true;
            float avg2 = rating2.getAvg();
            String packageName2 = app.getPackageName();
            long size2 = app.getSize();
            String graphic2 = app.getGraphic();
            Obb obb2 = app.getObb();
            $jacocoInit[83] = true;
            long id4 = store2.getId();
            String name4 = store2.getName();
            String vername2 = file2.getVername();
            int vercode2 = file2.getVercode();
            String path2 = file2.getPath();
            $jacocoInit[84] = true;
            EditorialContent editorialContent2 = new EditorialContent(title2, editorialMediaList, message2, type2, id3, name3, icon2, avg2, packageName2, size2, graphic2, obb2, id4, name4, vername2, vercode2, path2, file2.getPathAlt(), file2.getMd5sum(), position);
            $jacocoInit[85] = true;
            return editorialContent2;
        } else if (action != null) {
            $jacocoInit[86] = true;
            String title3 = content.getTitle();
            String message3 = content.getMessage();
            $jacocoInit[87] = true;
            EditorialContent editorialContent3 = new EditorialContent(title3, editorialMediaList, message3, content.getType(), action.getTitle(), action.getUrl(), position);
            $jacocoInit[88] = true;
            return editorialContent3;
        } else {
            String title4 = content.getTitle();
            String message4 = content.getMessage();
            $jacocoInit[89] = true;
            EditorialContent editorialContent4 = new EditorialContent(title4, editorialMediaList, message4, content.getType(), position);
            $jacocoInit[90] = true;
            return editorialContent4;
        }
    }

    private EditorialViewModel buildEditorialViewModel(List<EditorialContent> editorialContentList, Data card, List<Integer> placeHolderPositions, List<EditorialContent> placeHolderContent, EditorialContent bottomCardPlaceHolderContent, String cardId, String groupId) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        if (card.getAppearance() != null) {
            Appearance appearance = card.getAppearance();
            $jacocoInit[91] = true;
            Caption caption = appearance.getCaption();
            $jacocoInit[92] = true;
            str = caption.getTheme();
            $jacocoInit[93] = true;
        } else {
            $jacocoInit[94] = true;
            str = "";
        }
        String captionColor = str;
        if (bottomCardPlaceHolderContent != null) {
            $jacocoInit[95] = true;
            String title = card.getTitle();
            String caption2 = card.getCaption();
            $jacocoInit[96] = true;
            String background = card.getBackground();
            $jacocoInit[97] = true;
            String appName = bottomCardPlaceHolderContent.getAppName();
            String icon = bottomCardPlaceHolderContent.getIcon();
            $jacocoInit[98] = true;
            long id = bottomCardPlaceHolderContent.getId();
            String packageName = bottomCardPlaceHolderContent.getPackageName();
            $jacocoInit[99] = true;
            String md5sum = bottomCardPlaceHolderContent.getMd5sum();
            int verCode = bottomCardPlaceHolderContent.getVerCode();
            $jacocoInit[100] = true;
            String verName = bottomCardPlaceHolderContent.getVerName();
            String path = bottomCardPlaceHolderContent.getPath();
            $jacocoInit[101] = true;
            String pathAlt = bottomCardPlaceHolderContent.getPathAlt();
            Obb obb = bottomCardPlaceHolderContent.getObb();
            $jacocoInit[102] = true;
            EditorialViewModel editorialViewModel = new EditorialViewModel(editorialContentList, title, caption2, background, placeHolderPositions, placeHolderContent, appName, icon, id, packageName, md5sum, verCode, verName, path, pathAlt, obb, true, cardId, groupId, bottomCardPlaceHolderContent.getSize(), captionColor);
            $jacocoInit[103] = true;
            return editorialViewModel;
        }
        String title2 = card.getTitle();
        String caption3 = card.getCaption();
        $jacocoInit[104] = true;
        EditorialViewModel editorialViewModel2 = new EditorialViewModel(editorialContentList, title2, caption3, card.getBackground(), placeHolderPositions, placeHolderContent, false, cardId, groupId, captionColor);
        $jacocoInit[105] = true;
        return editorialViewModel2;
    }
}
