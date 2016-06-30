package com.prasilabs.dropme.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import com.prasilabs.dropme.R;
import com.prasilabs.dropme.core.CoreActivity;
import com.prasilabs.dropme.core.CorePresenter;
import com.prasilabs.dropme.customs.FragmentNavigator;
import com.prasilabs.dropme.modules.splashLogin.views.SplashLoginFragment;

import butterknife.BindView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends CoreActivity
{
    @BindView(R.id.container)
    FrameLayout frameLayout;

    private SplashLoginFragment splashLoginFragment;

    public static void openSplashActivity(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashLoginFragment = SplashLoginFragment.getInstance();

        if(getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }

        FragmentNavigator.navigateToFragment(this, splashLoginFragment, false, frameLayout.getId());
    }

    @Override
    protected CorePresenter setCorePresenter() {
        return null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(splashLoginFragment != null)
        {
            splashLoginFragment.onActivityResult(requestCode, resultCode, data);
        }
    }
}