package p005cm.aptoide.p006pt.account.view.store;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.p000v4.app.C0014p;
import android.support.p001v7.app.C0019n;
import android.support.p001v7.app.C0760a;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jakewharton.rxrelay.PublishRelay;
import com.trello.rxlifecycle.p263a.C12543b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.parceler.C14377B;
import p005cm.aptoide.accountmanager.SocialLink;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.view.ImagePickerErrorHandler;
import p005cm.aptoide.p006pt.account.view.ImagePickerPresenter;
import p005cm.aptoide.p006pt.account.view.exception.InvalidImageException;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannelType;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p005cm.aptoide.p006pt.presenter.CompositePresenter;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.utils.GenericDialogs;
import p005cm.aptoide.p006pt.utils.GenericDialogs.EResponse;
import p005cm.aptoide.p006pt.view.BackButtonFragment;
import p005cm.aptoide.p006pt.view.CustomTextInputLayout;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p005cm.aptoide.p006pt.view.custom.DividerItemDecoration;
import p005cm.aptoide.p006pt.view.dialog.ImagePickerDialog;
import p005cm.aptoide.p006pt.view.dialog.ImagePickerDialog.Builder;
import p019d.p022i.p023b.C0100e;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.account.view.store.ManageStoreFragment */
public class ManageStoreFragment extends BackButtonFragment implements ManageStoreView, NotBottomNavigationView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String EXTRA_GO_TO_HOME = "go_to_home";
    private static final String EXTRA_STORE_MODEL = "store_model";
    private static final float SPACE_BETWEEN = 0.0f;
    private static final float STROKE_SIZE = 0.04f;
    private Button cancelChangesButton;
    private TextView chooseStoreNameTitle;
    private ManageStoreViewModel currentModel;
    private ImagePickerDialog dialogFragment;
    private ImageView facebookEndRowIcon;
    private View facebookRow;
    private TextView facebookText;
    private RelativeLayout facebookTextAndPlus;
    private EditText facebookUser;
    private CustomTextInputLayout facebookUsernameWrapper;
    private boolean goToHome;
    private ImagePickerErrorHandler imagePickerErrorHandler;
    @Inject
    ImagePickerPresenter imagePickerPresenter;
    @Inject
    ManageStorePresenter manageStorePresenter;
    @Inject
    ScreenOrientationManager orientationManager;
    private Button saveDataButton;
    private View selectStoreImageButton;
    private LinearLayout socialChannels;
    private List<SocialChannelType> storeDeleteLinksList;
    private EditText storeDescription;
    private ImageView storeImage;
    private EditText storeName;
    @Inject
    String theme;
    private ThemeSelectorViewAdapter themeSelectorAdapter;
    private RecyclerView themeSelectorView;
    private Toolbar toolbar;
    private ImageView twitchEndRowIcon;
    private View twitchRow;
    private TextView twitchText;
    private RelativeLayout twitchTextAndPlus;
    private EditText twitchUser;
    private CustomTextInputLayout twitchUsernameWrapper;
    private ImageView twitterEndRowIcon;
    private View twitterRow;
    private TextView twitterText;
    private RelativeLayout twitterTextAndPlus;
    private EditText twitterUser;
    private CustomTextInputLayout twitterUsernameWrapper;
    private ProgressDialog waitDialog;
    private ImageView youtubeEndRowIcon;
    private View youtubeRow;
    private TextView youtubeText;
    private RelativeLayout youtubeTextAndPlus;
    private EditText youtubeUser;
    private CustomTextInputLayout youtubeUsernameWrapper;

    /* renamed from: cm.aptoide.pt.account.view.store.ManageStoreFragment$1 */
    static /* synthetic */ class C15241 {

        /* renamed from: $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$store$Store$SocialChannelType */
        static final /* synthetic */ int[] f4463xeddf8529 = new int[SocialChannelType.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-6442785659687610051L, "cm/aptoide/pt/account/view/store/ManageStoreFragment$1", 10);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                f4463xeddf8529[SocialChannelType.FACEBOOK.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            $jacocoInit[8] = true;
                        }
                    }
                }
            }
            f4463xeddf8529[SocialChannelType.TWITCH.ordinal()] = 2;
            $jacocoInit[3] = true;
            f4463xeddf8529[SocialChannelType.TWITTER.ordinal()] = 3;
            $jacocoInit[5] = true;
            f4463xeddf8529[SocialChannelType.YOUTUBE.ordinal()] = 4;
            $jacocoInit[7] = true;
            $jacocoInit[9] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8163250560354121766L, "cm/aptoide/pt/account/view/store/ManageStoreFragment", 371);
        $jacocoData = probes;
        return probes;
    }

    public ManageStoreFragment() {
        $jacocoInit()[0] = true;
    }

    public static ManageStoreFragment newInstance(ManageStoreViewModel storeModel, boolean goToHome2) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = new Bundle();
        $jacocoInit[1] = true;
        args.putParcelable(EXTRA_STORE_MODEL, C14377B.m45944a(storeModel));
        $jacocoInit[2] = true;
        args.putBoolean(EXTRA_GO_TO_HOME, goToHome2);
        $jacocoInit[3] = true;
        ManageStoreFragment fragment = new ManageStoreFragment();
        $jacocoInit[4] = true;
        fragment.setArguments(args);
        $jacocoInit[5] = true;
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[6] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[7] = true;
        this.currentModel = (ManageStoreViewModel) C14377B.m45945a(getArguments().getParcelable(EXTRA_STORE_MODEL));
        $jacocoInit[8] = true;
        this.goToHome = getArguments().getBoolean(EXTRA_GO_TO_HOME, true);
        $jacocoInit[9] = true;
        Builder viewRes = new Builder(getContext()).setViewRes(C1375R.layout.dialog_choose_avatar_source);
        $jacocoInit[10] = true;
        Builder title = viewRes.setTitle(C1375R.string.upload_dialog_title);
        $jacocoInit[11] = true;
        Builder negativeButton = title.setNegativeButton(C1375R.string.cancel);
        $jacocoInit[12] = true;
        Builder cameraButton = negativeButton.setCameraButton(C1375R.C1376id.button_camera);
        $jacocoInit[13] = true;
        Builder galleryButton = cameraButton.setGalleryButton(C1375R.C1376id.button_gallery);
        $jacocoInit[14] = true;
        this.dialogFragment = galleryButton.build();
        $jacocoInit[15] = true;
        this.imagePickerErrorHandler = new ImagePickerErrorHandler(getContext());
        $jacocoInit[16] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[17] = true;
        bindViews(view);
        $jacocoInit[18] = true;
        setupToolbarTitle();
        $jacocoInit[19] = true;
        setupThemeSelector();
        $jacocoInit[20] = true;
        setupViewsDefaultDataUsingCurrentModel();
        $jacocoInit[21] = true;
        registerSocialEditTextClickListeners();
        $jacocoInit[22] = true;
        registerSocialFocusChangeListeners();
        $jacocoInit[23] = true;
        attachPresenters();
        $jacocoInit[24] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[25] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[26] = true;
        ScreenTagHistory build = ScreenTagHistory.Builder.build(simpleName);
        $jacocoInit[27] = true;
        return build;
    }

    private void registerSocialFocusChangeListeners() {
        boolean[] $jacocoInit = $jacocoInit();
        this.facebookUser.setOnFocusChangeListener(new C1535i(this));
        $jacocoInit[28] = true;
        this.twitchUser.setOnFocusChangeListener(new C1533g(this));
        $jacocoInit[29] = true;
        this.twitterUser.setOnFocusChangeListener(new C1532f(this));
        $jacocoInit[30] = true;
        this.youtubeUser.setOnFocusChangeListener(new C1540n(this));
        $jacocoInit[31] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9787a(View v, boolean focus) {
        boolean[] $jacocoInit = $jacocoInit();
        changeSocialRowTextAndAppearance(this.facebookUser, this.facebookText, C1375R.style.Aptoide_TextView_Regular_XS_Facebook, this.facebookTextAndPlus, this.facebookUsernameWrapper, C1375R.string.facebook, SocialChannelType.FACEBOOK);
        $jacocoInit[370] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo9792b(View v, boolean focus) {
        boolean[] $jacocoInit = $jacocoInit();
        changeSocialRowTextAndAppearance(this.twitchUser, this.twitchText, C1375R.style.Aptoide_TextView_Regular_XS_Twitch, this.twitchTextAndPlus, this.twitchUsernameWrapper, C1375R.string.twitch, SocialChannelType.TWITCH);
        $jacocoInit[369] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9796c(View v, boolean focus) {
        boolean[] $jacocoInit = $jacocoInit();
        changeSocialRowTextAndAppearance(this.twitterUser, this.twitterText, C1375R.style.Aptoide_TextView_Regular_XS_Twitter, this.twitterTextAndPlus, this.twitterUsernameWrapper, C1375R.string.twitter, SocialChannelType.TWITTER);
        $jacocoInit[368] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo9799d(View v, boolean focus) {
        boolean[] $jacocoInit = $jacocoInit();
        changeSocialRowTextAndAppearance(this.youtubeUser, this.youtubeText, C1375R.style.Aptoide_TextView_Regular_XS_Youtube, this.youtubeTextAndPlus, this.youtubeUsernameWrapper, C1375R.string.youtube, SocialChannelType.YOUTUBE);
        $jacocoInit[367] = true;
    }

    private void registerSocialEditTextClickListeners() {
        boolean[] $jacocoInit = $jacocoInit();
        this.facebookRow.setOnClickListener(new C1530d(this));
        $jacocoInit[32] = true;
        this.twitchRow.setOnClickListener(new C1528b(this));
        $jacocoInit[33] = true;
        this.twitterRow.setOnClickListener(new C1539m(this));
        $jacocoInit[34] = true;
        this.youtubeRow.setOnClickListener(new C1538l(this));
        $jacocoInit[35] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9786a(View __) {
        boolean[] $jacocoInit = $jacocoInit();
        showEditTextHideTextView(this.facebookTextAndPlus, this.facebookUsernameWrapper, this.facebookUser);
        $jacocoInit[366] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo9791b(View __) {
        boolean[] $jacocoInit = $jacocoInit();
        showEditTextHideTextView(this.twitchTextAndPlus, this.twitchUsernameWrapper, this.twitchUser);
        $jacocoInit[365] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9795c(View __) {
        boolean[] $jacocoInit = $jacocoInit();
        showEditTextHideTextView(this.twitterTextAndPlus, this.twitterUsernameWrapper, this.twitterUser);
        $jacocoInit[364] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo9798d(View __) {
        boolean[] $jacocoInit = $jacocoInit();
        showEditTextHideTextView(this.youtubeTextAndPlus, this.youtubeUsernameWrapper, this.youtubeUser);
        $jacocoInit[363] = true;
    }

    public void loadImage(String pictureUri) {
        boolean[] $jacocoInit = $jacocoInit();
        loadImageStateless(pictureUri);
        $jacocoInit[36] = true;
        this.currentModel.setNewAvatar(true);
        $jacocoInit[37] = true;
    }

    public C0120S<DialogInterface> dialogCameraSelected() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<DialogInterface> cameraSelected = this.dialogFragment.cameraSelected();
        $jacocoInit[38] = true;
        return cameraSelected;
    }

    public C0120S<DialogInterface> dialogGallerySelected() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<DialogInterface> gallerySelected = this.dialogFragment.gallerySelected();
        $jacocoInit[39] = true;
        return gallerySelected;
    }

    public void showImagePickerDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialogFragment.show();
        $jacocoInit[40] = true;
    }

    public void showIconPropertiesError(InvalidImageException exception) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S showIconPropertiesError = this.imagePickerErrorHandler.showIconPropertiesError(exception);
        LifecycleEvent lifecycleEvent = LifecycleEvent.PAUSE;
        $jacocoInit[41] = true;
        C0120S a = showIconPropertiesError.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(lifecycleEvent));
        C1527a aVar = C1527a.f4465a;
        C1536j jVar = C1536j.f4474a;
        $jacocoInit[42] = true;
        a.mo3626a((C0129b<? super T>) aVar, (C0129b<Throwable>) jVar);
        $jacocoInit[43] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6282a(EResponse __) {
        $jacocoInit()[362] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6283a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[360] = true;
        instance.log(err);
        $jacocoInit[361] = true;
    }

    public C0120S<Void> selectStoreImageClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.selectStoreImageButton);
        $jacocoInit[44] = true;
        return a;
    }

    public void dismissLoadImageDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialogFragment.dismiss();
        $jacocoInit[45] = true;
    }

    public void loadImageStateless(String pictureUri) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreTheme storeTheme = StoreTheme.get(this.theme);
        $jacocoInit[46] = true;
        int color = storeTheme.getPrimaryColor();
        $jacocoInit[47] = true;
        ImageLoader with = ImageLoader.with(getActivity());
        ImageView imageView = this.storeImage;
        $jacocoInit[48] = true;
        with.loadWithShadowCircleTransform(pictureUri, imageView, getResources().getColor(color), SPACE_BETWEEN, STROKE_SIZE);
        $jacocoInit[49] = true;
        this.currentModel.setPictureUri(pictureUri);
        $jacocoInit[50] = true;
    }

    public C0120S<ManageStoreViewModel> saveDataClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.saveDataButton);
        C1529c cVar = new C1529c(this);
        $jacocoInit[51] = true;
        C0120S j = a.mo3669j(cVar);
        C1541o oVar = new C1541o(this);
        $jacocoInit[52] = true;
        C0120S<ManageStoreViewModel> b = j.mo3636b((C0129b<? super T>) oVar);
        $jacocoInit[53] = true;
        return b;
    }

    /* renamed from: b */
    public /* synthetic */ ManageStoreViewModel mo9790b(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        ManageStoreViewModel updateAndGetStoreModel = updateAndGetStoreModel();
        $jacocoInit[359] = true;
        return updateAndGetStoreModel;
    }

    /* renamed from: b */
    public /* synthetic */ void mo9793b(ManageStoreViewModel __) {
        boolean[] $jacocoInit = $jacocoInit();
        hideKeyboard();
        $jacocoInit[358] = true;
    }

    public C0120S<ManageStoreViewModel> cancelClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.cancelChangesButton);
        C1531e eVar = new C1531e(this);
        $jacocoInit[54] = true;
        C0120S j = a.mo3669j(eVar);
        C1537k kVar = new C1537k(this);
        $jacocoInit[55] = true;
        C0120S<ManageStoreViewModel> b = j.mo3636b((C0129b<? super T>) kVar);
        $jacocoInit[56] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ ManageStoreViewModel mo9785a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        ManageStoreViewModel manageStoreViewModel = this.currentModel;
        $jacocoInit[357] = true;
        return manageStoreViewModel;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9788a(ManageStoreViewModel __) {
        boolean[] $jacocoInit = $jacocoInit();
        hideKeyboard();
        $jacocoInit[356] = true;
    }

    public void showWaitProgressBar() {
        boolean[] $jacocoInit = $jacocoInit();
        this.orientationManager.lock();
        $jacocoInit[57] = true;
        ProgressDialog progressDialog = this.waitDialog;
        if (progressDialog == null) {
            $jacocoInit[58] = true;
        } else if (progressDialog.isShowing()) {
            $jacocoInit[59] = true;
        } else {
            $jacocoInit[60] = true;
            this.waitDialog.show();
            $jacocoInit[61] = true;
        }
        $jacocoInit[62] = true;
    }

    public void dismissWaitProgressBar() {
        boolean[] $jacocoInit = $jacocoInit();
        this.orientationManager.unlock();
        $jacocoInit[63] = true;
        ProgressDialog progressDialog = this.waitDialog;
        if (progressDialog == null) {
            $jacocoInit[64] = true;
        } else if (!progressDialog.isShowing()) {
            $jacocoInit[65] = true;
        } else {
            $jacocoInit[66] = true;
            this.waitDialog.dismiss();
            $jacocoInit[67] = true;
        }
        $jacocoInit[68] = true;
    }

    public void showFacebookError(String error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.facebookUsernameWrapper.setErrorEnabled(true);
        $jacocoInit[69] = true;
        this.facebookUsernameWrapper.setError(error);
        $jacocoInit[70] = true;
        this.facebookRow.performClick();
        $jacocoInit[71] = true;
    }

    public void showTwitterError(String error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.twitterUsernameWrapper.setErrorEnabled(true);
        $jacocoInit[72] = true;
        this.twitterUsernameWrapper.setError(error);
        $jacocoInit[73] = true;
        this.twitterRow.performClick();
        $jacocoInit[74] = true;
    }

    public void showTwitchError(String error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.twitchUsernameWrapper.setErrorEnabled(true);
        $jacocoInit[75] = true;
        this.twitchUsernameWrapper.setError(error);
        $jacocoInit[76] = true;
        this.twitchRow.performClick();
        $jacocoInit[77] = true;
    }

    public void showYoutubeError(String error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.youtubeUsernameWrapper.setErrorEnabled(true);
        $jacocoInit[78] = true;
        this.youtubeUsernameWrapper.setError(error);
        $jacocoInit[79] = true;
        this.youtubeRow.performClick();
        $jacocoInit[80] = true;
    }

    public void showError(String errorMessage) {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1624a((View) this.socialChannels, (CharSequence) errorMessage, 0);
        $jacocoInit[81] = true;
        a.mo4690h();
        $jacocoInit[82] = true;
    }

    public void showSuccessMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1624a((View) this.socialChannels, (CharSequence) getString(C1375R.string.done), 0);
        $jacocoInit[83] = true;
        a.mo4690h();
        $jacocoInit[84] = true;
    }

    private void showEditTextHideTextView(RelativeLayout relativeLayout, CustomTextInputLayout customTextInputLayout, EditText editText) {
        boolean[] $jacocoInit = $jacocoInit();
        relativeLayout.setVisibility(8);
        $jacocoInit[85] = true;
        customTextInputLayout.setVisibility(0);
        $jacocoInit[86] = true;
        editText.requestFocus();
        $jacocoInit[87] = true;
        showKeyboard(editText);
        $jacocoInit[88] = true;
    }

    private void changeSocialRowTextAndAppearance(EditText editText, TextView textView, int style, RelativeLayout relativeLayout, CustomTextInputLayout customTextInputLayout, int socialNetworkName, SocialChannelType socialChannelType) {
        boolean[] $jacocoInit = $jacocoInit();
        if (editText.hasFocus()) {
            $jacocoInit[89] = true;
        } else {
            $jacocoInit[90] = true;
            Editable text = editText.getText();
            $jacocoInit[91] = true;
            String obj = text.toString();
            $jacocoInit[92] = true;
            if (!obj.isEmpty()) {
                $jacocoInit[93] = true;
                Editable text2 = editText.getText();
                $jacocoInit[94] = true;
                String obj2 = text2.toString();
                $jacocoInit[95] = true;
                textView.setText(obj2);
                $jacocoInit[96] = true;
                setTextViewAppearance(C1375R.style.Aptoide_TextView_Regular_S_BlackAlpha, textView);
                $jacocoInit[97] = true;
            } else {
                String pojoUrl = getUrl(socialChannelType);
                if (pojoUrl != null) {
                    $jacocoInit[98] = true;
                    textView.setText(removeBaseUrl(pojoUrl));
                    $jacocoInit[99] = true;
                    setTextViewAppearance(C1375R.style.Aptoide_TextView_Regular_S_BlackAlpha, textView);
                    $jacocoInit[100] = true;
                } else {
                    textView.setText(getString(socialNetworkName));
                    $jacocoInit[101] = true;
                    setTextViewAppearance(style, textView);
                    $jacocoInit[102] = true;
                }
            }
            relativeLayout.setVisibility(0);
            $jacocoInit[103] = true;
            customTextInputLayout.setVisibility(8);
            $jacocoInit[104] = true;
        }
        $jacocoInit[105] = true;
    }

    private String getUrl(SocialChannelType channelType) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[106] = true;
        for (SocialLink channel : this.currentModel.getSocialLinks()) {
            $jacocoInit[107] = true;
            SocialChannelType type = channel.getType();
            $jacocoInit[108] = true;
            if (type.equals(channelType)) {
                $jacocoInit[109] = true;
                String url = channel.getUrl();
                $jacocoInit[110] = true;
                return url;
            }
            $jacocoInit[111] = true;
        }
        $jacocoInit[112] = true;
        return null;
    }

    private void setTextViewAppearance(int resId, TextView textView) {
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT < 23) {
            $jacocoInit[113] = true;
            textView.setTextAppearance(getContext(), resId);
            $jacocoInit[114] = true;
        } else {
            textView.setTextAppearance(resId);
            $jacocoInit[115] = true;
        }
        $jacocoInit[116] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View inflate = inflater.inflate(C1375R.layout.fragment_manage_store, container, false);
        $jacocoInit[117] = true;
        return inflate;
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState == null) {
            $jacocoInit[118] = true;
        } else {
            try {
                $jacocoInit[119] = true;
                this.currentModel = (ManageStoreViewModel) C14377B.m45945a(savedInstanceState.getParcelable(EXTRA_STORE_MODEL));
                $jacocoInit[120] = true;
            } catch (NullPointerException e) {
                $jacocoInit[121] = true;
                this.currentModel = new ManageStoreViewModel();
                $jacocoInit[122] = true;
            }
            this.goToHome = savedInstanceState.getBoolean(EXTRA_GO_TO_HOME, true);
            $jacocoInit[123] = true;
        }
        $jacocoInit[124] = true;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        $jacocoInit[125] = true;
        outState.putParcelable(EXTRA_STORE_MODEL, C14377B.m45944a(this.currentModel));
        $jacocoInit[126] = true;
        outState.putBoolean(EXTRA_GO_TO_HOME, this.goToHome);
        $jacocoInit[127] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        dismissWaitProgressBar();
        ImagePickerDialog imagePickerDialog = this.dialogFragment;
        if (imagePickerDialog == null) {
            $jacocoInit[128] = true;
        } else {
            $jacocoInit[129] = true;
            imagePickerDialog.dismiss();
            this.dialogFragment = null;
            $jacocoInit[130] = true;
        }
        hideKeyboard();
        $jacocoInit[131] = true;
        clearSocialEditTextClickListeners();
        $jacocoInit[132] = true;
        clearSocialFocusListeners();
        $jacocoInit[133] = true;
        super.onDestroyView();
        $jacocoInit[134] = true;
    }

    private void clearSocialFocusListeners() {
        boolean[] $jacocoInit = $jacocoInit();
        this.facebookUser.setOnFocusChangeListener(null);
        $jacocoInit[135] = true;
        this.twitchUser.setOnFocusChangeListener(null);
        $jacocoInit[136] = true;
        this.twitterUser.setOnFocusChangeListener(null);
        $jacocoInit[137] = true;
        this.youtubeUser.setOnFocusChangeListener(null);
        this.facebookUser = null;
        this.twitchUser = null;
        this.twitterUser = null;
        this.youtubeUser = null;
        $jacocoInit[138] = true;
    }

    private void clearSocialEditTextClickListeners() {
        boolean[] $jacocoInit = $jacocoInit();
        this.facebookRow.setOnClickListener(null);
        $jacocoInit[139] = true;
        this.twitchRow.setOnClickListener(null);
        $jacocoInit[140] = true;
        this.twitterRow.setOnClickListener(null);
        $jacocoInit[141] = true;
        this.youtubeRow.setOnClickListener(null);
        this.facebookRow = null;
        this.twitchRow = null;
        this.twitterRow = null;
        this.youtubeRow = null;
        $jacocoInit[142] = true;
    }

    public void hideKeyboard() {
        boolean[] $jacocoInit = $jacocoInit();
        super.hideKeyboard();
        $jacocoInit[143] = true;
    }

    private void attachPresenters() {
        boolean[] $jacocoInit = $jacocoInit();
        Presenter[] presenterArr = {this.imagePickerPresenter, this.manageStorePresenter};
        $jacocoInit[144] = true;
        CompositePresenter compositePresenter = new CompositePresenter(Arrays.asList(presenterArr));
        $jacocoInit[145] = true;
        attachPresenter(compositePresenter);
        $jacocoInit[146] = true;
    }

    public void setupThemeSelector() {
        boolean[] $jacocoInit = $jacocoInit();
        RecyclerView recyclerView = this.themeSelectorView;
        $jacocoInit[147] = true;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 0, false);
        $jacocoInit[148] = true;
        recyclerView.setLayoutManager(linearLayoutManager);
        $jacocoInit[149] = true;
        PublishRelay<StoreTheme> storeThemePublishRelay = C0100e.m565o();
        $jacocoInit[150] = true;
        this.themeSelectorAdapter = new ThemeSelectorViewAdapter(storeThemePublishRelay, StoreTheme.getThemesFromVersion(8));
        $jacocoInit[151] = true;
        this.themeSelectorView.setAdapter(this.themeSelectorAdapter);
        $jacocoInit[152] = true;
        C0120S storeThemeSelection = this.themeSelectorAdapter.storeThemeSelection();
        C1534h hVar = new C1534h(this);
        $jacocoInit[153] = true;
        C0120S b = storeThemeSelection.mo3636b((C0129b<? super T>) hVar);
        C12543b bVar = C12543b.DESTROY_VIEW;
        $jacocoInit[154] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(bVar));
        $jacocoInit[155] = true;
        a.mo3670j();
        $jacocoInit[156] = true;
        this.themeSelectorView.mo7527a((C0980h) new DividerItemDecoration(getContext(), 8.0f, 3));
        $jacocoInit[157] = true;
        this.themeSelectorAdapter.selectTheme(this.currentModel.getStoreTheme());
        $jacocoInit[158] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9789a(StoreTheme storeTheme) {
        boolean[] $jacocoInit = $jacocoInit();
        this.currentModel.setStoreTheme(storeTheme);
        $jacocoInit[355] = true;
    }

    public void setupToolbarTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        this.toolbar.setTitle((CharSequence) getViewTitle(this.currentModel));
        $jacocoInit[159] = true;
        ((C0019n) getActivity()).setSupportActionBar(this.toolbar);
        $jacocoInit[160] = true;
        C0760a actionBar = ((C0019n) getActivity()).getSupportActionBar();
        $jacocoInit[161] = true;
        actionBar.mo6153d(false);
        $jacocoInit[162] = true;
        actionBar.mo6147a(this.toolbar.getTitle());
        $jacocoInit[163] = true;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        this.chooseStoreNameTitle = (TextView) view.findViewById(C1375R.C1376id.create_store_choose_name_title);
        $jacocoInit[164] = true;
        this.selectStoreImageButton = view.findViewById(C1375R.C1376id.create_store_image_action);
        $jacocoInit[165] = true;
        this.storeImage = (ImageView) view.findViewById(C1375R.C1376id.create_store_image);
        $jacocoInit[166] = true;
        this.storeName = (EditText) view.findViewById(C1375R.C1376id.create_store_name);
        $jacocoInit[167] = true;
        this.storeDescription = (EditText) view.findViewById(C1375R.C1376id.edit_store_description);
        $jacocoInit[168] = true;
        this.cancelChangesButton = (Button) view.findViewById(C1375R.C1376id.create_store_skip);
        $jacocoInit[169] = true;
        this.saveDataButton = (Button) view.findViewById(C1375R.C1376id.create_store_action);
        $jacocoInit[170] = true;
        this.themeSelectorView = (RecyclerView) view.findViewById(C1375R.C1376id.theme_selector);
        $jacocoInit[171] = true;
        this.socialChannels = (LinearLayout) view.findViewById(C1375R.C1376id.edit_store_social_channels);
        $jacocoInit[172] = true;
        this.facebookRow = view.findViewById(C1375R.C1376id.edit_store_facebook);
        $jacocoInit[173] = true;
        this.facebookTextAndPlus = (RelativeLayout) view.findViewById(C1375R.C1376id.edit_store_facebook_text_plus_wrapper);
        $jacocoInit[174] = true;
        this.facebookUsernameWrapper = (CustomTextInputLayout) view.findViewById(C1375R.C1376id.edit_store_facebook_username_wrapper);
        $jacocoInit[175] = true;
        this.facebookUser = (EditText) view.findViewById(C1375R.C1376id.edit_store_facebook_username);
        $jacocoInit[176] = true;
        this.facebookText = (TextView) view.findViewById(C1375R.C1376id.edit_store_facebook_title);
        $jacocoInit[177] = true;
        this.facebookEndRowIcon = (ImageView) view.findViewById(C1375R.C1376id.edit_store_facebook_plus);
        $jacocoInit[178] = true;
        this.twitchEndRowIcon = (ImageView) view.findViewById(C1375R.C1376id.edit_store_twitch_plus);
        $jacocoInit[179] = true;
        this.twitchTextAndPlus = (RelativeLayout) view.findViewById(C1375R.C1376id.edit_store_twitch_text_plus_wrapper);
        $jacocoInit[180] = true;
        this.twitchUsernameWrapper = (CustomTextInputLayout) view.findViewById(C1375R.C1376id.edit_store_twitch_username_wrapper);
        $jacocoInit[181] = true;
        this.twitchUser = (EditText) view.findViewById(C1375R.C1376id.edit_store_twitch_username);
        $jacocoInit[182] = true;
        this.twitchText = (TextView) view.findViewById(C1375R.C1376id.edit_store_twitch_title);
        $jacocoInit[183] = true;
        this.twitchRow = view.findViewById(C1375R.C1376id.edit_store_twitch);
        $jacocoInit[184] = true;
        this.twitterRow = view.findViewById(C1375R.C1376id.edit_store_twitter);
        $jacocoInit[185] = true;
        this.twitterTextAndPlus = (RelativeLayout) view.findViewById(C1375R.C1376id.edit_store_twitter_text_plus_wrapper);
        $jacocoInit[186] = true;
        this.twitterUsernameWrapper = (CustomTextInputLayout) view.findViewById(C1375R.C1376id.edit_store_twitter_username_wrapper);
        $jacocoInit[187] = true;
        this.twitterUser = (EditText) view.findViewById(C1375R.C1376id.edit_store_twitter_username);
        $jacocoInit[188] = true;
        this.twitterText = (TextView) view.findViewById(C1375R.C1376id.edit_store_twitter_title);
        $jacocoInit[189] = true;
        this.twitterEndRowIcon = (ImageView) view.findViewById(C1375R.C1376id.edit_store_twitter_plus);
        $jacocoInit[190] = true;
        this.youtubeRow = view.findViewById(C1375R.C1376id.edit_store_youtube);
        $jacocoInit[191] = true;
        this.youtubeTextAndPlus = (RelativeLayout) view.findViewById(C1375R.C1376id.edit_store_youtube_text_plus_wrapper);
        $jacocoInit[192] = true;
        this.youtubeUsernameWrapper = (CustomTextInputLayout) view.findViewById(C1375R.C1376id.edit_store_youtube_username_wrapper);
        $jacocoInit[193] = true;
        this.youtubeUser = (EditText) view.findViewById(C1375R.C1376id.edit_store_youtube_username);
        $jacocoInit[194] = true;
        this.youtubeText = (TextView) view.findViewById(C1375R.C1376id.edit_store_youtube_title);
        $jacocoInit[195] = true;
        this.youtubeEndRowIcon = (ImageView) view.findViewById(C1375R.C1376id.edit_store_youtube_plus);
        $jacocoInit[196] = true;
        C0014p activity = getActivity();
        $jacocoInit[197] = true;
        Context applicationContext = getActivity().getApplicationContext();
        $jacocoInit[198] = true;
        String string = applicationContext.getString(C1375R.string.please_wait_upload);
        $jacocoInit[199] = true;
        this.waitDialog = GenericDialogs.createGenericPleaseWaitDialog(activity, string);
        $jacocoInit[200] = true;
        this.toolbar = (Toolbar) view.findViewById(C1375R.C1376id.toolbar);
        $jacocoInit[201] = true;
    }

    private ManageStoreViewModel updateAndGetStoreModel() {
        boolean[] $jacocoInit = $jacocoInit();
        ManageStoreViewModel manageStoreViewModel = this.currentModel;
        Editable text = this.storeName.getText();
        $jacocoInit[202] = true;
        String obj = text.toString();
        Editable text2 = this.storeDescription.getText();
        $jacocoInit[203] = true;
        String obj2 = text2.toString();
        $jacocoInit[204] = true;
        ManageStoreViewModel.update(manageStoreViewModel, obj, obj2);
        this.currentModel = manageStoreViewModel;
        $jacocoInit[205] = true;
        this.currentModel.setStoreTheme(this.themeSelectorAdapter.getSelectedTheme());
        $jacocoInit[206] = true;
        this.currentModel.setSocialDelLinks(checkLinksToDelete());
        $jacocoInit[207] = true;
        this.currentModel.setSocialLinks(getStoreLinks());
        ManageStoreViewModel manageStoreViewModel2 = this.currentModel;
        $jacocoInit[208] = true;
        return manageStoreViewModel2;
    }

    private List<SocialChannelType> checkLinksToDelete() {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeDeleteLinksList = new ArrayList();
        $jacocoInit[209] = true;
        List<SocialLink> socialLinks = this.currentModel.getSocialLinks();
        $jacocoInit[210] = true;
        $jacocoInit[211] = true;
        for (SocialLink socialLink : socialLinks) {
            $jacocoInit[212] = true;
            setStoreDeleteLinksList(socialLink);
            $jacocoInit[213] = true;
        }
        List<SocialChannelType> list = this.storeDeleteLinksList;
        $jacocoInit[214] = true;
        return list;
    }

    private void setStoreDeleteLinksList(SocialLink socialLink) {
        boolean[] $jacocoInit = $jacocoInit();
        String url = socialLink.getUrl();
        $jacocoInit[215] = true;
        if (url.isEmpty()) {
            $jacocoInit[216] = true;
        } else {
            $jacocoInit[217] = true;
            SocialChannelType type = socialLink.getType();
            SocialChannelType socialChannelType = SocialChannelType.FACEBOOK;
            $jacocoInit[218] = true;
            if (!type.equals(socialChannelType)) {
                $jacocoInit[219] = true;
            } else {
                Editable text = this.facebookUser.getText();
                $jacocoInit[220] = true;
                String obj = text.toString();
                $jacocoInit[221] = true;
                if (!obj.isEmpty()) {
                    $jacocoInit[222] = true;
                } else {
                    $jacocoInit[223] = true;
                    this.storeDeleteLinksList.add(SocialChannelType.FACEBOOK);
                    $jacocoInit[224] = true;
                }
            }
            SocialChannelType type2 = socialLink.getType();
            SocialChannelType socialChannelType2 = SocialChannelType.TWITCH;
            $jacocoInit[225] = true;
            if (!type2.equals(socialChannelType2)) {
                $jacocoInit[226] = true;
            } else {
                Editable text2 = this.twitchUser.getText();
                $jacocoInit[227] = true;
                String obj2 = text2.toString();
                $jacocoInit[228] = true;
                if (!obj2.isEmpty()) {
                    $jacocoInit[229] = true;
                } else {
                    $jacocoInit[230] = true;
                    this.storeDeleteLinksList.add(SocialChannelType.TWITCH);
                    $jacocoInit[231] = true;
                }
            }
            SocialChannelType type3 = socialLink.getType();
            SocialChannelType socialChannelType3 = SocialChannelType.TWITTER;
            $jacocoInit[232] = true;
            if (!type3.equals(socialChannelType3)) {
                $jacocoInit[233] = true;
            } else {
                Editable text3 = this.twitterUser.getText();
                $jacocoInit[234] = true;
                String obj3 = text3.toString();
                $jacocoInit[235] = true;
                if (!obj3.isEmpty()) {
                    $jacocoInit[236] = true;
                } else {
                    $jacocoInit[237] = true;
                    this.storeDeleteLinksList.add(SocialChannelType.TWITTER);
                    $jacocoInit[238] = true;
                }
            }
            SocialChannelType type4 = socialLink.getType();
            SocialChannelType socialChannelType4 = SocialChannelType.YOUTUBE;
            $jacocoInit[239] = true;
            if (!type4.equals(socialChannelType4)) {
                $jacocoInit[240] = true;
            } else {
                Editable text4 = this.youtubeUser.getText();
                $jacocoInit[241] = true;
                String obj4 = text4.toString();
                $jacocoInit[242] = true;
                if (!obj4.isEmpty()) {
                    $jacocoInit[243] = true;
                } else {
                    $jacocoInit[244] = true;
                    this.storeDeleteLinksList.add(SocialChannelType.YOUTUBE);
                    $jacocoInit[245] = true;
                }
            }
        }
        $jacocoInit[246] = true;
    }

    private List<SocialLink> getStoreLinks() {
        boolean[] $jacocoInit = $jacocoInit();
        List<SocialLink> storeLinksList = new ArrayList<>();
        $jacocoInit[247] = true;
        Editable text = this.facebookUser.getText();
        $jacocoInit[248] = true;
        String obj = text.toString();
        $jacocoInit[249] = true;
        if (TextUtils.isEmpty(obj)) {
            $jacocoInit[250] = true;
        } else {
            SocialChannelType socialChannelType = SocialChannelType.FACEBOOK;
            EditText editText = this.facebookUser;
            $jacocoInit[251] = true;
            Editable text2 = editText.getText();
            $jacocoInit[252] = true;
            String obj2 = text2.toString();
            $jacocoInit[253] = true;
            SocialLink socialLink = new SocialLink(socialChannelType, setSocialChannelUrl(socialChannelType, obj2));
            $jacocoInit[254] = true;
            storeLinksList.add(socialLink);
            $jacocoInit[255] = true;
        }
        Editable text3 = this.twitchUser.getText();
        $jacocoInit[256] = true;
        String obj3 = text3.toString();
        $jacocoInit[257] = true;
        if (TextUtils.isEmpty(obj3)) {
            $jacocoInit[258] = true;
        } else {
            SocialChannelType socialChannelType2 = SocialChannelType.TWITCH;
            EditText editText2 = this.twitchUser;
            $jacocoInit[259] = true;
            Editable text4 = editText2.getText();
            $jacocoInit[260] = true;
            String obj4 = text4.toString();
            $jacocoInit[261] = true;
            SocialLink socialLink2 = new SocialLink(socialChannelType2, setSocialChannelUrl(socialChannelType2, obj4));
            $jacocoInit[262] = true;
            storeLinksList.add(socialLink2);
            $jacocoInit[263] = true;
        }
        Editable text5 = this.twitterUser.getText();
        $jacocoInit[264] = true;
        String obj5 = text5.toString();
        $jacocoInit[265] = true;
        if (TextUtils.isEmpty(obj5)) {
            $jacocoInit[266] = true;
        } else {
            SocialChannelType socialChannelType3 = SocialChannelType.TWITTER;
            EditText editText3 = this.twitterUser;
            $jacocoInit[267] = true;
            Editable text6 = editText3.getText();
            $jacocoInit[268] = true;
            String obj6 = text6.toString();
            $jacocoInit[269] = true;
            SocialLink socialLink3 = new SocialLink(socialChannelType3, setSocialChannelUrl(socialChannelType3, obj6));
            $jacocoInit[270] = true;
            storeLinksList.add(socialLink3);
            $jacocoInit[271] = true;
        }
        Editable text7 = this.youtubeUser.getText();
        $jacocoInit[272] = true;
        String obj7 = text7.toString();
        $jacocoInit[273] = true;
        if (TextUtils.isEmpty(obj7)) {
            $jacocoInit[274] = true;
        } else {
            SocialChannelType socialChannelType4 = SocialChannelType.YOUTUBE;
            EditText editText4 = this.youtubeUser;
            $jacocoInit[275] = true;
            Editable text8 = editText4.getText();
            $jacocoInit[276] = true;
            String obj8 = text8.toString();
            $jacocoInit[277] = true;
            SocialLink socialLink4 = new SocialLink(socialChannelType4, setSocialChannelUrl(socialChannelType4, obj8));
            $jacocoInit[278] = true;
            storeLinksList.add(socialLink4);
            $jacocoInit[279] = true;
        }
        if (storeLinksList.isEmpty()) {
            $jacocoInit[280] = true;
            List<SocialLink> emptyList = Collections.emptyList();
            $jacocoInit[281] = true;
            return emptyList;
        }
        $jacocoInit[282] = true;
        return storeLinksList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String setSocialChannelUrl(p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannelType r5, java.lang.String r6) {
        /*
            r4 = this;
            boolean[] r0 = $jacocoInit()
            int[] r1 = p005cm.aptoide.p006pt.account.view.store.ManageStoreFragment.C15241.f4463xeddf8529
            int r2 = r5.ordinal()
            r1 = r1[r2]
            r2 = 1
            if (r1 == r2) goto L_0x002c
            r3 = 2
            if (r1 == r3) goto L_0x0027
            r3 = 3
            if (r1 == r3) goto L_0x0022
            r3 = 4
            if (r1 == r3) goto L_0x001d
            r1 = 283(0x11b, float:3.97E-43)
            r0[r1] = r2
            goto L_0x007c
        L_0x001d:
            r1 = 286(0x11e, float:4.01E-43)
            r0[r1] = r2
            goto L_0x0068
        L_0x0022:
            r1 = 285(0x11d, float:4.0E-43)
            r0[r1] = r2
            goto L_0x0054
        L_0x0027:
            r1 = 284(0x11c, float:3.98E-43)
            r0[r1] = r2
            goto L_0x0040
        L_0x002c:
            java.util.regex.Pattern r1 = android.util.Patterns.WEB_URL
            java.util.regex.Matcher r1 = r1.matcher(r6)
            r3 = 287(0x11f, float:4.02E-43)
            r0[r3] = r2
            boolean r1 = r1.matches()
            if (r1 == 0) goto L_0x00f1
            r1 = 288(0x120, float:4.04E-43)
            r0[r1] = r2
        L_0x0040:
            java.util.regex.Pattern r1 = android.util.Patterns.WEB_URL
            java.util.regex.Matcher r1 = r1.matcher(r6)
            r3 = 291(0x123, float:4.08E-43)
            r0[r3] = r2
            boolean r1 = r1.matches()
            if (r1 == 0) goto L_0x00d7
            r1 = 292(0x124, float:4.09E-43)
            r0[r1] = r2
        L_0x0054:
            java.util.regex.Pattern r1 = android.util.Patterns.WEB_URL
            java.util.regex.Matcher r1 = r1.matcher(r6)
            r3 = 295(0x127, float:4.13E-43)
            r0[r3] = r2
            boolean r1 = r1.matches()
            if (r1 == 0) goto L_0x00bd
            r1 = 296(0x128, float:4.15E-43)
            r0[r1] = r2
        L_0x0068:
            java.util.regex.Pattern r1 = android.util.Patterns.WEB_URL
            java.util.regex.Matcher r1 = r1.matcher(r6)
            r3 = 299(0x12b, float:4.19E-43)
            r0[r3] = r2
            boolean r1 = r1.matches()
            if (r1 == 0) goto L_0x00a3
            r1 = 300(0x12c, float:4.2E-43)
            r0[r1] = r2
        L_0x007c:
            java.lang.String r1 = "http"
            boolean r1 = r6.contains(r1)
            if (r1 != 0) goto L_0x009e
            r1 = 303(0x12f, float:4.25E-43)
            r0[r1] = r2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "https://"
            r1.append(r3)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r3 = 304(0x130, float:4.26E-43)
            r0[r3] = r2
            return r1
        L_0x009e:
            r1 = 305(0x131, float:4.27E-43)
            r0[r1] = r2
            return r6
        L_0x00a3:
            r1 = 301(0x12d, float:4.22E-43)
            r0[r1] = r2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "https://www.youtube.com/"
            r1.append(r3)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r3 = 302(0x12e, float:4.23E-43)
            r0[r3] = r2
            return r1
        L_0x00bd:
            r1 = 297(0x129, float:4.16E-43)
            r0[r1] = r2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "https://twitter.com/"
            r1.append(r3)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r3 = 298(0x12a, float:4.18E-43)
            r0[r3] = r2
            return r1
        L_0x00d7:
            r1 = 293(0x125, float:4.1E-43)
            r0[r1] = r2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "https://go.twitch.tv/"
            r1.append(r3)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r3 = 294(0x126, float:4.12E-43)
            r0[r3] = r2
            return r1
        L_0x00f1:
            r1 = 289(0x121, float:4.05E-43)
            r0[r1] = r2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "https://www.facebook.com/"
            r1.append(r3)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r3 = 290(0x122, float:4.06E-43)
            r0[r3] = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.account.view.store.ManageStoreFragment.setSocialChannelUrl(cm.aptoide.pt.dataprovider.model.v7.store.Store$SocialChannelType, java.lang.String):java.lang.String");
    }

    private void setupViewsDefaultDataUsingCurrentModel() {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeName.setText(this.currentModel.getStoreName());
        $jacocoInit[306] = true;
        if (!this.currentModel.storeExists()) {
            $jacocoInit[307] = true;
            this.chooseStoreNameTitle.setText(C1375R.string.create_store_name);
            $jacocoInit[308] = true;
        } else {
            TextView textView = this.chooseStoreNameTitle;
            $jacocoInit[309] = true;
            String formattedString = StringU.getFormattedString(C1375R.string.description, getResources(), new Object[0]);
            $jacocoInit[310] = true;
            textView.setText(formattedString);
            $jacocoInit[311] = true;
            this.storeName.setVisibility(8);
            $jacocoInit[312] = true;
            this.storeDescription.setVisibility(0);
            $jacocoInit[313] = true;
            this.storeDescription.setText(this.currentModel.getStoreDescription());
            $jacocoInit[314] = true;
            this.socialChannels.setVisibility(0);
            $jacocoInit[315] = true;
            setSocialChannelsUserNames();
            $jacocoInit[316] = true;
            loadImageStateless(this.currentModel.getPictureUri());
            $jacocoInit[317] = true;
            this.saveDataButton.setText(C1375R.string.save_edit_store);
            $jacocoInit[318] = true;
            this.cancelChangesButton.setText(C1375R.string.cancel);
            $jacocoInit[319] = true;
        }
        $jacocoInit[320] = true;
    }

    private void setSocialChannelsUserNames() {
        boolean[] $jacocoInit = $jacocoInit();
        List<SocialLink> storeLinksList = this.currentModel.getSocialLinks();
        $jacocoInit[321] = true;
        if (storeLinksList.isEmpty()) {
            $jacocoInit[322] = true;
        } else {
            $jacocoInit[323] = true;
            $jacocoInit[324] = true;
            for (SocialLink storeLinks : storeLinksList) {
                $jacocoInit[326] = true;
                SocialChannelType type = storeLinks.getType();
                SocialChannelType socialChannelType = SocialChannelType.FACEBOOK;
                $jacocoInit[327] = true;
                if (type.equals(socialChannelType)) {
                    $jacocoInit[328] = true;
                    setStoreSocialSentUrl(storeLinks, this.facebookText, this.facebookEndRowIcon, this.facebookUser);
                    $jacocoInit[329] = true;
                } else {
                    SocialChannelType type2 = storeLinks.getType();
                    SocialChannelType socialChannelType2 = SocialChannelType.TWITCH;
                    $jacocoInit[330] = true;
                    if (type2.equals(socialChannelType2)) {
                        $jacocoInit[331] = true;
                        setStoreSocialSentUrl(storeLinks, this.twitchText, this.twitchEndRowIcon, this.twitchUser);
                        $jacocoInit[332] = true;
                    } else {
                        SocialChannelType type3 = storeLinks.getType();
                        SocialChannelType socialChannelType3 = SocialChannelType.TWITTER;
                        $jacocoInit[333] = true;
                        if (type3.equals(socialChannelType3)) {
                            $jacocoInit[334] = true;
                            setStoreSocialSentUrl(storeLinks, this.twitterText, this.twitterEndRowIcon, this.twitterUser);
                            $jacocoInit[335] = true;
                        } else {
                            SocialChannelType type4 = storeLinks.getType();
                            SocialChannelType socialChannelType4 = SocialChannelType.YOUTUBE;
                            $jacocoInit[336] = true;
                            if (!type4.equals(socialChannelType4)) {
                                $jacocoInit[337] = true;
                            } else {
                                $jacocoInit[338] = true;
                                setStoreSocialSentUrl(storeLinks, this.youtubeText, this.youtubeEndRowIcon, this.youtubeUser);
                                $jacocoInit[339] = true;
                            }
                        }
                    }
                }
                $jacocoInit[340] = true;
            }
            $jacocoInit[325] = true;
        }
        $jacocoInit[341] = true;
    }

    private void setStoreSocialSentUrl(SocialLink storeLinks, TextView textView, ImageView imageView, EditText editText) {
        boolean[] $jacocoInit = $jacocoInit();
        setTextViewAppearance(C1375R.style.Aptoide_TextView_Regular_S_BlackAlpha, textView);
        $jacocoInit[342] = true;
        textView.setText(removeBaseUrl(storeLinks.getUrl()));
        $jacocoInit[343] = true;
        editText.setText(removeBaseUrl(storeLinks.getUrl()));
        $jacocoInit[344] = true;
        imageView.setImageDrawable(getResources().getDrawable(C1375R.drawable.edit_store_link_check));
        $jacocoInit[345] = true;
    }

    private String removeBaseUrl(String url) {
        boolean[] $jacocoInit = $jacocoInit();
        String[] splitUrl = url.split("/");
        String str = splitUrl[splitUrl.length - 1];
        $jacocoInit[346] = true;
        return str;
    }

    private String getViewTitle(ManageStoreViewModel storeModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!storeModel.storeExists()) {
            $jacocoInit[347] = true;
            String string = getString(C1375R.string.create_store_title);
            $jacocoInit[348] = true;
            return string;
        }
        String string2 = getString(C1375R.string.edit_store_title);
        $jacocoInit[349] = true;
        return string2;
    }

    private void showKeyboard(EditText editText) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[350] = true;
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService("input_method");
        if (imm == null) {
            $jacocoInit[351] = true;
        } else {
            $jacocoInit[352] = true;
            imm.showSoftInput(editText, 2);
            $jacocoInit[353] = true;
        }
        $jacocoInit[354] = true;
    }
}
