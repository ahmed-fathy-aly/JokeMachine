package com.ahmed.jokemachine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import builditbigger.R;
import butterknife.ButterKnife;
import butterknife.OnClick;
import enterprises.wayne.jokeshower.ShowJokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements JokeTask.Callback {



    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);

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
