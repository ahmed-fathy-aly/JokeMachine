package com.ahmed.jokemachine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import builditbigger.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import enterprises.wayne.jokeshower.ShowJokeActivity;

import static builditbigger.R.id.adView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements JokeTask.Callback {

    @BindView(R.id.adView)
    AdView adView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);


        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);
        return root;
    }

    @OnClick(R.id.button_tell_joke)
    public void onClick() {
        new JokeTask(this).execute();
    }

    @Override
    public void onResult(String str) {
        if (!isAdded())
            return;
        startActivity(ShowJokeActivity.getIntent(getContext(), str));
    }
}
