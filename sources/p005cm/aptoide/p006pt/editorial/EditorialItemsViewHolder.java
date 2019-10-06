package p005cm.aptoide.p006pt.editorial;

import android.graphics.Rect;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.RecyclerView.C0988n;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.app.DownloadModel.DownloadState;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.editorial.EditorialEvent.Type;
import p005cm.aptoide.p006pt.home.SnapToStartHelper;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ScreenU;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.editorial.EditorialItemsViewHolder */
class EditorialItemsViewHolder extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Action action;
    private final Button actionButton;
    private final Button appCardButton = ((Button) this.appCardLayout.findViewById(C1375R.C1376id.appview_install_button));
    private final ImageView appCardImage;
    private final View appCardLayout;
    private final TextView appCardNameWithRating;
    private final TextView appCardRating;
    private final View appCardRatingLayout;
    private ImageView cancelDownload;
    private RelativeLayout cardInfoLayout;
    private int currentMediaPosition;
    private TextSwitcher descriptionSwitcher;
    private View downloadControlsLayout;
    private final C14963c<EditorialDownloadEvent> downloadEventListener;
    private LinearLayout downloadInfoLayout;
    private ProgressBar downloadProgressBar;
    private TextView downloadProgressValue;
    private TextView firstTitle;
    private ImageView image;
    private View itemText;
    private final LinearLayoutManager layoutManager;
    private View media;
    private MediaBundleAdapter mediaBundleAdapter;
    private boolean mediaDescriptionVisible;
    private RecyclerView mediaList;
    private TextView message;
    private final DecimalFormat oneDecimalFormat;
    private ImageView pauseDownload;
    private ImageView resumeDownload;
    private TextView secondaryTitle;
    private View title;
    private C14963c<EditorialEvent> uiEventListener;
    private ImageView videoThumbnail;
    private FrameLayout videoThumbnailContainer;

    /* renamed from: cm.aptoide.pt.editorial.EditorialItemsViewHolder$3 */
    static /* synthetic */ class C30733 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action = new int[Action.values().length];
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState = new int[DownloadState.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(3753908716440336023L, "cm/aptoide/pt/editorial/EditorialItemsViewHolder$3", 19);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.ACTIVE.ordinal()] = 1;
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
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.INDETERMINATE.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.PAUSE.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.COMPLETE.ordinal()] = 4;
            $jacocoInit[7] = true;
            try {
                $jacocoInit[9] = true;
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.UPDATE.ordinal()] = 1;
                $jacocoInit[10] = true;
            } catch (NoSuchFieldError e5) {
                try {
                    $jacocoInit[11] = true;
                } catch (NoSuchFieldError e6) {
                    try {
                        $jacocoInit[13] = true;
                    } catch (NoSuchFieldError e7) {
                        try {
                            $jacocoInit[15] = true;
                        } catch (NoSuchFieldError e8) {
                            $jacocoInit[17] = true;
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.INSTALL.ordinal()] = 2;
            $jacocoInit[12] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.OPEN.ordinal()] = 3;
            $jacocoInit[14] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.DOWNGRADE.ordinal()] = 4;
            $jacocoInit[16] = true;
            $jacocoInit[18] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4220012736472270485L, "cm/aptoide/pt/editorial/EditorialItemsViewHolder", 204);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ LinearLayoutManager access$000(EditorialItemsViewHolder x0) {
        boolean[] $jacocoInit = $jacocoInit();
        LinearLayoutManager linearLayoutManager = x0.layoutManager;
        $jacocoInit[202] = true;
        return linearLayoutManager;
    }

    static /* synthetic */ C14963c access$100(EditorialItemsViewHolder x0) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<EditorialEvent> cVar = x0.uiEventListener;
        $jacocoInit[203] = true;
        return cVar;
    }

    public EditorialItemsViewHolder(View view, DecimalFormat oneDecimalFormat2, C14963c<EditorialEvent> uiEventListener2, C14963c<EditorialDownloadEvent> downloadEventListener2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view);
        $jacocoInit[0] = true;
        this.itemText = view.findViewById(C1375R.C1376id.editorial_item_text);
        $jacocoInit[1] = true;
        this.title = view.findViewById(C1375R.C1376id.editorial_item_title);
        $jacocoInit[2] = true;
        this.firstTitle = (TextView) view.findViewById(C1375R.C1376id.editorial_item_first_title);
        $jacocoInit[3] = true;
        this.secondaryTitle = (TextView) view.findViewById(C1375R.C1376id.editorial_item_secondary_title);
        $jacocoInit[4] = true;
        this.message = (TextView) view.findViewById(C1375R.C1376id.editorial_item_message);
        $jacocoInit[5] = true;
        this.media = view.findViewById(C1375R.C1376id.editorial_item_media);
        $jacocoInit[6] = true;
        this.image = (ImageView) view.findViewById(C1375R.C1376id.editorial_image);
        $jacocoInit[7] = true;
        this.videoThumbnail = (ImageView) view.findViewById(C1375R.C1376id.editorial_video_thumbnail);
        $jacocoInit[8] = true;
        this.videoThumbnailContainer = (FrameLayout) view.findViewById(C1375R.C1376id.editorial_video_thumbnail_container);
        $jacocoInit[9] = true;
        this.descriptionSwitcher = (TextSwitcher) view.findViewById(C1375R.C1376id.editorial_image_description_switcher);
        $jacocoInit[10] = true;
        this.mediaList = (RecyclerView) view.findViewById(C1375R.C1376id.editoral_image_list);
        $jacocoInit[11] = true;
        this.appCardLayout = view.findViewById(C1375R.C1376id.app_cardview);
        $jacocoInit[12] = true;
        this.actionButton = (Button) view.findViewById(C1375R.C1376id.action_button);
        this.oneDecimalFormat = oneDecimalFormat2;
        this.uiEventListener = uiEventListener2;
        this.downloadEventListener = downloadEventListener2;
        $jacocoInit[13] = true;
        View view2 = this.appCardLayout;
        $jacocoInit[14] = true;
        this.appCardNameWithRating = (TextView) view2.findViewById(C1375R.C1376id.app_title_textview_with_rating);
        $jacocoInit[15] = true;
        this.appCardImage = (ImageView) this.appCardLayout.findViewById(C1375R.C1376id.app_icon_imageview);
        $jacocoInit[16] = true;
        this.appCardRating = (TextView) this.appCardLayout.findViewById(C1375R.C1376id.rating_label);
        $jacocoInit[17] = true;
        this.appCardRatingLayout = this.appCardLayout.findViewById(C1375R.C1376id.rating_layout);
        $jacocoInit[18] = true;
        this.mediaBundleAdapter = new MediaBundleAdapter(new ArrayList(), uiEventListener2);
        $jacocoInit[19] = true;
        this.cardInfoLayout = (RelativeLayout) view.findViewById(C1375R.C1376id.card_info_install_layout);
        $jacocoInit[20] = true;
        this.downloadControlsLayout = view.findViewById(C1375R.C1376id.install_controls_layout);
        $jacocoInit[21] = true;
        this.downloadInfoLayout = (LinearLayout) view.findViewById(C1375R.C1376id.appview_transfer_info);
        $jacocoInit[22] = true;
        this.downloadProgressBar = (ProgressBar) view.findViewById(C1375R.C1376id.appview_download_progress_bar);
        $jacocoInit[23] = true;
        this.downloadProgressValue = (TextView) view.findViewById(C1375R.C1376id.appview_download_progress_number);
        $jacocoInit[24] = true;
        this.cancelDownload = (ImageView) view.findViewById(C1375R.C1376id.appview_download_cancel_button);
        $jacocoInit[25] = true;
        this.resumeDownload = (ImageView) view.findViewById(C1375R.C1376id.appview_download_resume_download);
        $jacocoInit[26] = true;
        this.pauseDownload = (ImageView) view.findViewById(C1375R.C1376id.appview_download_pause_download);
        $jacocoInit[27] = true;
        this.layoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        $jacocoInit[28] = true;
        SnapToStartHelper snapToStartHelper = new SnapToStartHelper();
        $jacocoInit[29] = true;
        snapToStartHelper.attachToRecyclerView(this.mediaList);
        $jacocoInit[30] = true;
        Animation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        $jacocoInit[31] = true;
        fadeIn.setDuration(1000);
        $jacocoInit[32] = true;
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        $jacocoInit[33] = true;
        Animation fadeOut = alphaAnimation;
        fadeOut.setDuration(500);
        this.currentMediaPosition = -1;
        $jacocoInit[34] = true;
        this.descriptionSwitcher.setInAnimation(fadeIn);
        $jacocoInit[35] = true;
        this.descriptionSwitcher.setOutAnimation(fadeOut);
        $jacocoInit[36] = true;
        this.mediaList.mo7527a((C0980h) new C0980h(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ EditorialItemsViewHolder this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-4252818470151713762L, "cm/aptoide/pt/editorial/EditorialItemsViewHolder$1", 3);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, C0997t state) {
                boolean[] $jacocoInit = $jacocoInit();
                int margin = ScreenU.getPixelsForDip(6, view.getResources());
                $jacocoInit[1] = true;
                outRect.set(0, 0, margin, 0);
                $jacocoInit[2] = true;
            }
        });
        $jacocoInit[37] = true;
        this.mediaList.setLayoutManager(this.layoutManager);
        $jacocoInit[38] = true;
        this.mediaList.setAdapter(this.mediaBundleAdapter);
        $jacocoInit[39] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setVisibility(p005cm.aptoide.p006pt.editorial.EditorialContent r18, int r19, java.lang.Boolean r20) {
        /*
            r17 = this;
            r14 = r17
            boolean[] r15 = $jacocoInit()
            boolean r0 = r18.hasTitle()
            r16 = 1
            if (r0 == 0) goto L_0x0013
            r0 = 40
            r15[r0] = r16
            goto L_0x0022
        L_0x0013:
            boolean r0 = r18.hasMessage()
            if (r0 != 0) goto L_0x001e
            r0 = 41
            r15[r0] = r16
            goto L_0x003a
        L_0x001e:
            r0 = 42
            r15[r0] = r16
        L_0x0022:
            android.view.View r0 = r14.itemText
            r1 = 0
            r0.setVisibility(r1)
            r0 = 43
            r15[r0] = r16
            r17.manageTitleVisibility(r18, r19)
            r0 = 44
            r15[r0] = r16
            r17.manageMessageVisibility(r18)
            r0 = 45
            r15[r0] = r16
        L_0x003a:
            r17.manageMediaVisibility(r18, r19)
            r0 = 46
            r15[r0] = r16
            boolean r0 = r18.isPlaceHolderType()
            if (r0 != 0) goto L_0x004d
            r0 = 47
            r15[r0] = r16
            goto L_0x00df
        L_0x004d:
            r0 = 48
            r15[r0] = r16
            java.lang.String r1 = r18.getAppName()
            java.lang.String r2 = r18.getPackageName()
            r0 = 49
            r15[r0] = r16
            java.lang.String r3 = r18.getMd5sum()
            java.lang.String r4 = r18.getIcon()
            java.lang.String r5 = r18.getVerName()
            r0 = 50
            r15[r0] = r16
            int r6 = r18.getVerCode()
            java.lang.String r7 = r18.getPath()
            java.lang.String r8 = r18.getPathAlt()
            r0 = 51
            r15[r0] = r16
            cm.aptoide.pt.dataprovider.model.v7.Obb r9 = r18.getObb()
            long r10 = r18.getId()
            long r12 = r18.getSize()
            r0 = 52
            r15[r0] = r16
            r0 = r17
            r0.setPlaceHolderListeners(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12)
            r0 = 53
            r15[r0] = r16
            java.lang.String r0 = r18.getAppName()
            java.lang.String r1 = r18.getIcon()
            r2 = 54
            r15[r2] = r16
            float r2 = r18.getRating()
            r3 = 55
            r15[r3] = r16
            r14.setPlaceHolderInfo(r0, r1, r2)
            r0 = 56
            r15[r0] = r16
            boolean r0 = r20.booleanValue()
            if (r0 != 0) goto L_0x00bc
            r0 = 57
            r15[r0] = r16
            goto L_0x00df
        L_0x00bc:
            r0 = 58
            r15[r0] = r16
            android.view.View r0 = r14.appCardLayout
            r1 = 4
            r0.setVisibility(r1)
            r0 = 59
            r15[r0] = r16
            android.view.View r0 = r14.appCardLayout
            r1 = 1036831949(0x3dcccccd, float:0.1)
            r0.setScaleX(r1)
            r0 = 60
            r15[r0] = r16
            android.view.View r0 = r14.appCardLayout
            r0.setScaleY(r1)
            r0 = 61
            r15[r0] = r16
        L_0x00df:
            boolean r0 = r18.hasAction()
            if (r0 != 0) goto L_0x00ea
            r0 = 62
            r15[r0] = r16
            goto L_0x00f5
        L_0x00ea:
            r0 = 63
            r15[r0] = r16
            r17.manageActionVisibility(r18)
            r0 = 64
            r15[r0] = r16
        L_0x00f5:
            r0 = 65
            r15[r0] = r16
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.editorial.EditorialItemsViewHolder.setVisibility(cm.aptoide.pt.editorial.EditorialContent, int, java.lang.Boolean):void");
    }

    private void manageActionVisibility(EditorialContent editorialItem) {
        boolean[] $jacocoInit = $jacocoInit();
        this.actionButton.setText(editorialItem.getActionTitle());
        $jacocoInit[66] = true;
        this.actionButton.setVisibility(0);
        $jacocoInit[67] = true;
        this.actionButton.setOnClickListener(new C3232z(this, editorialItem));
        $jacocoInit[68] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13843a(EditorialContent editorialItem, View click) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<EditorialEvent> cVar = this.uiEventListener;
        Type type = Type.ACTION;
        $jacocoInit[199] = true;
        EditorialEvent editorialEvent = new EditorialEvent(type, editorialItem.getActionUrl());
        $jacocoInit[200] = true;
        cVar.onNext(editorialEvent);
        $jacocoInit[201] = true;
    }

    private void manageTitleVisibility(EditorialContent editorialItem, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!editorialItem.hasTitle()) {
            $jacocoInit[69] = true;
        } else {
            $jacocoInit[70] = true;
            this.title.setVisibility(0);
            if (position == 0) {
                $jacocoInit[71] = true;
                this.firstTitle.setText(editorialItem.getTitle());
                $jacocoInit[72] = true;
                this.firstTitle.setVisibility(0);
                $jacocoInit[73] = true;
            } else {
                this.secondaryTitle.setText(editorialItem.getTitle());
                $jacocoInit[74] = true;
                this.secondaryTitle.setVisibility(0);
                $jacocoInit[75] = true;
            }
        }
        $jacocoInit[76] = true;
    }

    private void manageMessageVisibility(EditorialContent editorialItem) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!editorialItem.hasMessage()) {
            $jacocoInit[77] = true;
        } else {
            $jacocoInit[78] = true;
            this.message.setText(editorialItem.getMessage());
            $jacocoInit[79] = true;
            this.message.setVisibility(0);
            $jacocoInit[80] = true;
        }
        $jacocoInit[81] = true;
    }

    public void manageDescriptionAnimationVisibility(int firstVisibleItem, List<EditorialMedia> media2) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.mediaDescriptionVisible) {
            $jacocoInit[82] = true;
        } else {
            $jacocoInit[83] = true;
            EditorialMedia editorialMedia = (EditorialMedia) media2.get(firstVisibleItem);
            $jacocoInit[84] = true;
            String descriptionText = editorialMedia.getDescription();
            if (this.currentMediaPosition == firstVisibleItem) {
                $jacocoInit[85] = true;
            } else {
                $jacocoInit[86] = true;
                this.descriptionSwitcher.setVisibility(0);
                $jacocoInit[87] = true;
                this.descriptionSwitcher.setText(descriptionText);
                this.currentMediaPosition = firstVisibleItem;
                $jacocoInit[88] = true;
            }
        }
        $jacocoInit[89] = true;
    }

    public void setAllDescriptionsVisible() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.mediaDescriptionVisible) {
            $jacocoInit[90] = true;
        } else {
            $jacocoInit[91] = true;
            int mediaPosition = 0;
            $jacocoInit[92] = true;
            while (mediaPosition < this.mediaBundleAdapter.getItemCount()) {
                RecyclerView recyclerView = this.mediaList;
                $jacocoInit[94] = true;
                MediaViewHolder mediaViewHolder = (MediaViewHolder) recyclerView.mo7544b(mediaPosition);
                if (mediaViewHolder == null) {
                    $jacocoInit[95] = true;
                } else {
                    $jacocoInit[96] = true;
                    mediaViewHolder.setDescriptionVisible();
                    this.mediaDescriptionVisible = true;
                    $jacocoInit[97] = true;
                }
                mediaPosition++;
                $jacocoInit[98] = true;
            }
            $jacocoInit[93] = true;
        }
        $jacocoInit[99] = true;
    }

    private void manageMediaVisibility(final EditorialContent editorialItem, final int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!editorialItem.hasMedia()) {
            $jacocoInit[100] = true;
        } else {
            $jacocoInit[101] = true;
            List<EditorialMedia> editorialMediaList = editorialItem.getMedia();
            $jacocoInit[102] = true;
            this.media.setVisibility(0);
            $jacocoInit[103] = true;
            if (editorialItem.hasListOfMedia()) {
                $jacocoInit[104] = true;
                this.mediaBundleAdapter.add(editorialMediaList);
                $jacocoInit[105] = true;
                this.mediaList.setVisibility(0);
                $jacocoInit[106] = true;
                if (!editorialItem.hasAnyMediaDescription()) {
                    $jacocoInit[107] = true;
                } else {
                    $jacocoInit[108] = true;
                    this.mediaList.mo7530a((C0988n) new C0988n(this) {
                        private static transient /* synthetic */ boolean[] $jacocoData;
                        final /* synthetic */ EditorialItemsViewHolder this$0;

                        private static /* synthetic */ boolean[] $jacocoInit() {
                            boolean[] zArr = $jacocoData;
                            if (zArr != null) {
                                return zArr;
                            }
                            boolean[] probes = Offline.getProbes(-8995592676682832292L, "cm/aptoide/pt/editorial/EditorialItemsViewHolder$2", 7);
                            $jacocoData = probes;
                            return probes;
                        }

                        {
                            boolean[] $jacocoInit = $jacocoInit();
                            this.this$0 = this$0;
                            $jacocoInit[0] = true;
                        }

                        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                            boolean[] $jacocoInit = $jacocoInit();
                            super.onScrolled(recyclerView, dx, dy);
                            $jacocoInit[1] = true;
                            C14963c access$100 = EditorialItemsViewHolder.access$100(this.this$0);
                            Type type = Type.MEDIA_LIST;
                            EditorialItemsViewHolder editorialItemsViewHolder = this.this$0;
                            $jacocoInit[2] = true;
                            int findFirstCompletelyVisibleItemPosition = EditorialItemsViewHolder.access$000(editorialItemsViewHolder).findFirstCompletelyVisibleItemPosition();
                            EditorialItemsViewHolder editorialItemsViewHolder2 = this.this$0;
                            $jacocoInit[3] = true;
                            int findLastCompletelyVisibleItemPosition = EditorialItemsViewHolder.access$000(editorialItemsViewHolder2).findLastCompletelyVisibleItemPosition();
                            int i = position;
                            EditorialContent editorialContent = editorialItem;
                            $jacocoInit[4] = true;
                            EditorialEvent editorialEvent = new EditorialEvent(type, findFirstCompletelyVisibleItemPosition, findLastCompletelyVisibleItemPosition, i, editorialContent.getMedia());
                            $jacocoInit[5] = true;
                            access$100.onNext(editorialEvent);
                            $jacocoInit[6] = true;
                        }
                    });
                    $jacocoInit[109] = true;
                }
            } else {
                EditorialMedia editorialMedia = (EditorialMedia) editorialMediaList.get(0);
                $jacocoInit[110] = true;
                if (!editorialMedia.hasDescription()) {
                    $jacocoInit[111] = true;
                } else {
                    $jacocoInit[112] = true;
                    this.descriptionSwitcher.setCurrentText(editorialMedia.getDescription());
                    $jacocoInit[113] = true;
                    this.descriptionSwitcher.setVisibility(0);
                    $jacocoInit[114] = true;
                }
                if (!editorialMedia.isImage()) {
                    $jacocoInit[115] = true;
                } else {
                    $jacocoInit[116] = true;
                    ImageLoader with = ImageLoader.with(this.itemView.getContext());
                    $jacocoInit[117] = true;
                    with.load(editorialMedia.getUrl(), this.image);
                    $jacocoInit[118] = true;
                    this.image.setVisibility(0);
                    $jacocoInit[119] = true;
                }
                if (!editorialMedia.isVideo()) {
                    $jacocoInit[120] = true;
                } else {
                    $jacocoInit[121] = true;
                    if (editorialMedia.getThumbnail() == null) {
                        $jacocoInit[122] = true;
                    } else {
                        $jacocoInit[123] = true;
                        ImageLoader with2 = ImageLoader.with(this.itemView.getContext());
                        $jacocoInit[124] = true;
                        with2.load(editorialMedia.getThumbnail(), this.videoThumbnail);
                        $jacocoInit[125] = true;
                    }
                    if (!editorialMedia.hasUrl()) {
                        $jacocoInit[126] = true;
                    } else {
                        $jacocoInit[127] = true;
                        this.videoThumbnailContainer.setVisibility(0);
                        $jacocoInit[128] = true;
                        this.videoThumbnailContainer.setOnClickListener(new C3075F(this, editorialMedia));
                        $jacocoInit[129] = true;
                    }
                }
            }
        }
        $jacocoInit[130] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13844a(EditorialMedia editorialMedia, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<EditorialEvent> cVar = this.uiEventListener;
        Type type = Type.MEDIA;
        $jacocoInit[196] = true;
        EditorialEvent editorialEvent = new EditorialEvent(type, editorialMedia.getUrl());
        $jacocoInit[197] = true;
        cVar.onNext(editorialEvent);
        $jacocoInit[198] = true;
    }

    private void setPlaceHolderInfo(String appName, String image2, float rating) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        ImageView imageView = this.appCardImage;
        $jacocoInit[131] = true;
        with.load(image2, imageView);
        $jacocoInit[132] = true;
        this.appCardImage.setVisibility(0);
        if (rating == 0.0f) {
            $jacocoInit[133] = true;
            this.appCardRating.setText(C1375R.string.appcardview_title_no_stars);
            $jacocoInit[134] = true;
        } else {
            this.appCardRating.setText(this.oneDecimalFormat.format((double) rating));
            $jacocoInit[135] = true;
        }
        this.appCardRatingLayout.setVisibility(0);
        $jacocoInit[136] = true;
        this.appCardNameWithRating.setText(appName);
        $jacocoInit[137] = true;
        this.appCardNameWithRating.setVisibility(0);
        $jacocoInit[138] = true;
        this.appCardLayout.setVisibility(0);
        $jacocoInit[139] = true;
    }

    public boolean isVisible(float screenHeight, float screenWidth) {
        boolean[] $jacocoInit = $jacocoInit();
        Rect placeHolderPosition = new Rect();
        $jacocoInit[140] = true;
        this.appCardLayout.getLocalVisibleRect(placeHolderPosition);
        int i = (int) screenWidth;
        int i2 = (int) screenHeight;
        View view = this.appCardLayout;
        $jacocoInit[141] = true;
        Rect screen = new Rect(0, 0, i, i2 - (view.getHeight() * 2));
        $jacocoInit[142] = true;
        boolean intersect = placeHolderPosition.intersect(screen);
        $jacocoInit[143] = true;
        return intersect;
    }

    public View getPlaceHolder() {
        boolean[] $jacocoInit = $jacocoInit();
        View view = this.appCardLayout;
        $jacocoInit[144] = true;
        return view;
    }

    public void setPlaceHolderDownloadingInfo(DownloadModel downloadModel) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadInfoLayout.setVisibility(0);
        $jacocoInit[145] = true;
        this.cardInfoLayout.setVisibility(8);
        $jacocoInit[146] = true;
        setDownloadState(downloadModel.getProgress(), downloadModel.getDownloadState());
        $jacocoInit[147] = true;
    }

    public void setPlaceHolderDefaultStateInfo(DownloadModel downloadModel, String update, String install, String open, String downgrade) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadInfoLayout.setVisibility(8);
        $jacocoInit[148] = true;
        this.cardInfoLayout.setVisibility(0);
        $jacocoInit[149] = true;
        setButtonText(downloadModel, update, install, open, downgrade);
        $jacocoInit[150] = true;
    }

    private void setButtonText(DownloadModel model, String update, String install, String open, String downgrade) {
        boolean[] $jacocoInit = $jacocoInit();
        this.action = model.getAction();
        $jacocoInit[151] = true;
        int i = C30733.$SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[this.action.ordinal()];
        if (i == 1) {
            this.appCardButton.setText(update);
            $jacocoInit[153] = true;
        } else if (i == 2) {
            this.appCardButton.setText(install);
            $jacocoInit[154] = true;
        } else if (i == 3) {
            this.appCardButton.setText(open);
            $jacocoInit[155] = true;
        } else if (i != 4) {
            $jacocoInit[152] = true;
        } else {
            this.appCardButton.setText(downgrade);
            $jacocoInit[156] = true;
        }
        $jacocoInit[157] = true;
    }

    private void setDownloadState(int progress, DownloadState downloadState) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutParams pauseShowing = new LayoutParams(-1, -1, 4.0f);
        $jacocoInit[158] = true;
        LayoutParams layoutParams = new LayoutParams(-1, -1, 2.0f);
        $jacocoInit[159] = true;
        LayoutParams pauseHidden = layoutParams;
        int i = C30733.$SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[downloadState.ordinal()];
        String str = "%";
        if (i == 1) {
            this.downloadProgressBar.setIndeterminate(false);
            $jacocoInit[161] = true;
            this.downloadProgressBar.setProgress(progress);
            $jacocoInit[162] = true;
            TextView textView = this.downloadProgressValue;
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(progress));
            sb.append(str);
            textView.setText(sb.toString());
            $jacocoInit[163] = true;
            this.pauseDownload.setVisibility(0);
            $jacocoInit[164] = true;
            this.cancelDownload.setVisibility(8);
            $jacocoInit[165] = true;
            this.resumeDownload.setVisibility(8);
            $jacocoInit[166] = true;
            this.downloadControlsLayout.setLayoutParams(pauseShowing);
            $jacocoInit[167] = true;
        } else if (i == 2) {
            this.downloadProgressBar.setIndeterminate(true);
            $jacocoInit[168] = true;
            this.pauseDownload.setVisibility(0);
            $jacocoInit[169] = true;
            this.cancelDownload.setVisibility(8);
            $jacocoInit[170] = true;
            this.resumeDownload.setVisibility(8);
            $jacocoInit[171] = true;
            this.downloadControlsLayout.setLayoutParams(pauseShowing);
            $jacocoInit[172] = true;
        } else if (i == 3) {
            this.downloadProgressBar.setIndeterminate(false);
            $jacocoInit[173] = true;
            this.downloadProgressBar.setProgress(progress);
            $jacocoInit[174] = true;
            TextView textView2 = this.downloadProgressValue;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.valueOf(progress));
            sb2.append(str);
            textView2.setText(sb2.toString());
            $jacocoInit[175] = true;
            this.pauseDownload.setVisibility(8);
            $jacocoInit[176] = true;
            this.cancelDownload.setVisibility(0);
            $jacocoInit[177] = true;
            this.resumeDownload.setVisibility(0);
            $jacocoInit[178] = true;
            this.downloadControlsLayout.setLayoutParams(pauseHidden);
            $jacocoInit[179] = true;
        } else if (i != 4) {
            $jacocoInit[160] = true;
        } else {
            this.downloadProgressBar.setIndeterminate(true);
            $jacocoInit[180] = true;
            this.pauseDownload.setVisibility(0);
            $jacocoInit[181] = true;
            this.cancelDownload.setVisibility(8);
            $jacocoInit[182] = true;
            this.resumeDownload.setVisibility(8);
            $jacocoInit[183] = true;
            this.downloadControlsLayout.setLayoutParams(pauseShowing);
            $jacocoInit[184] = true;
        }
        $jacocoInit[185] = true;
    }

    private void setPlaceHolderListeners(String appName, String packageName, String md5sum, String icon, String verName, int verCode, String path, String pathAlt, Obb obb, long id, long size) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageView imageView = this.cancelDownload;
        String str = appName;
        String str2 = packageName;
        String str3 = md5sum;
        String str4 = icon;
        String str5 = verName;
        int i = verCode;
        String str6 = path;
        String str7 = pathAlt;
        Obb obb2 = obb;
        C3052A a = r0;
        C3052A a2 = new C3052A(this, str, str2, str3, str4, str5, i, str6, str7, obb2, size);
        imageView.setOnClickListener(a);
        $jacocoInit[186] = true;
        ImageView imageView2 = this.resumeDownload;
        C3055B b = r0;
        C3055B b2 = new C3055B(this, str, str2, str3, str4, str5, i, str6, str7, obb2, size);
        imageView2.setOnClickListener(b);
        $jacocoInit[187] = true;
        ImageView imageView3 = this.pauseDownload;
        C3061D d = r0;
        C3061D d2 = new C3061D(this, str, str2, str3, str4, str5, i, str6, str7, obb2, size);
        imageView3.setOnClickListener(d);
        $jacocoInit[188] = true;
        Button button = this.appCardButton;
        C3058C c = r0;
        C3058C c2 = new C3058C(this, str, str2, str3, str4, str5, i, str6, str7, obb2, size);
        button.setOnClickListener(c);
        $jacocoInit[189] = true;
        this.appCardLayout.setOnClickListener(new C3064E(this, id, packageName));
        $jacocoInit[190] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13845a(String appName, String packageName, String md5sum, String icon, String verName, int verCode, String path, String pathAlt, Obb obb, long size, View click) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<EditorialDownloadEvent> cVar = this.downloadEventListener;
        EditorialDownloadEvent editorialDownloadEvent = r3;
        EditorialDownloadEvent editorialDownloadEvent2 = new EditorialDownloadEvent(Type.CANCEL, appName, packageName, md5sum, icon, verName, verCode, path, pathAlt, obb, size);
        cVar.onNext(editorialDownloadEvent);
        $jacocoInit[195] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo13846b(String appName, String packageName, String md5sum, String icon, String verName, int verCode, String path, String pathAlt, Obb obb, long size, View click) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<EditorialDownloadEvent> cVar = this.downloadEventListener;
        EditorialDownloadEvent editorialDownloadEvent = r3;
        EditorialDownloadEvent editorialDownloadEvent2 = new EditorialDownloadEvent(Type.RESUME, appName, packageName, md5sum, icon, verName, verCode, path, pathAlt, obb, size);
        cVar.onNext(editorialDownloadEvent);
        $jacocoInit[194] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo13847c(String appName, String packageName, String md5sum, String icon, String verName, int verCode, String path, String pathAlt, Obb obb, long size, View click) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<EditorialDownloadEvent> cVar = this.downloadEventListener;
        EditorialDownloadEvent editorialDownloadEvent = r3;
        EditorialDownloadEvent editorialDownloadEvent2 = new EditorialDownloadEvent(Type.PAUSE, appName, packageName, md5sum, icon, verName, verCode, path, pathAlt, obb, size);
        cVar.onNext(editorialDownloadEvent);
        $jacocoInit[193] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo13848d(String appName, String packageName, String md5sum, String icon, String verName, int verCode, String path, String pathAlt, Obb obb, long size, View click) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<EditorialDownloadEvent> cVar = this.downloadEventListener;
        Type type = Type.BUTTON;
        Action action2 = this.action;
        EditorialDownloadEvent editorialDownloadEvent = r3;
        EditorialDownloadEvent editorialDownloadEvent2 = new EditorialDownloadEvent(type, appName, packageName, md5sum, icon, verName, verCode, path, pathAlt, obb, action2, size);
        cVar.onNext(editorialDownloadEvent);
        $jacocoInit[192] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13842a(long id, String packageName, View click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.uiEventListener.onNext(new EditorialEvent(Type.APPCARD, id, packageName));
        $jacocoInit[191] = true;
    }
}
