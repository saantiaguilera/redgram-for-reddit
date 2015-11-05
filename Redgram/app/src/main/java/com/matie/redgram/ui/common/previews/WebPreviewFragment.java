package com.matie.redgram.ui.common.previews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.matie.redgram.R;
import com.matie.redgram.data.models.main.items.PostItem;
import com.matie.redgram.ui.common.main.MainActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by matie on 2015-11-04.
 */
public class WebPreviewFragment extends BasePreviewFragment{

    public static final String MAIN_DATA = "web_preview_data";

    @InjectView(R.id.web_preview)
    WebView webView;
    @InjectView(R.id.top_banner_title)
    TextView topBannerTitle;
    @InjectView(R.id.close_fragment)
    ImageView closeFragment;

    PostItem postItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.webview_preview_fragment, container, false);
        ButterKnife.inject(this, view);

        //setup
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptEnabled(true);

        if(getArguments().containsKey(MAIN_DATA)){
            String data = getArguments().getString(MAIN_DATA);
            postItem = new Gson().fromJson(data, PostItem.class);
            webView.loadUrl(postItem.getUrl());
            topBannerTitle.setText(postItem.getTitle());
        }

        return view;
    }

    @Override public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void refreshPreview(Bundle bundle) {
        if(bundle.containsKey(MAIN_DATA)){
            String data = bundle.getString(MAIN_DATA);
            postItem = new Gson().fromJson(data, PostItem.class);
            //update if not equal to current URL
            if(!postItem.getUrl().equalsIgnoreCase(webView.getUrl()))
                webView.loadUrl(postItem.getUrl());
            if(!topBannerTitle.getText().toString().equalsIgnoreCase(postItem.getTitle()))
                topBannerTitle.setText(postItem.getTitle());
        }
    }

    @OnClick(R.id.close_fragment)
    public void OnCloseFragment(){
        MainActivity activity = (MainActivity)getContext();
        activity.hidePanel();
    }
}
