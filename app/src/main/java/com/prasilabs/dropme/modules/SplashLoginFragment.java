package com.prasilabs.dropme.modules;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.prasilabs.dropme.R;
import com.prasilabs.dropme.constants.PermisionConstant;
import com.prasilabs.dropme.core.CoreFragment;
import com.prasilabs.dropme.datamodels.CDropMeUser;
import com.prasilabs.dropme.debug.ConsoleLog;
import com.prasilabs.dropme.modules.splashLogin.SplashLoginPresenter;
import com.prasilabs.dropme.utils.ViewUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by prasi on 26/5/16.
 */
public class SplashLoginFragment extends CoreFragment<SplashLoginPresenter> implements SplashLoginPresenter.LoginCallBack, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ResultCallback<People.LoadPeopleResult>
{
    private static final String TAG = SplashLoginFragment.class.getSimpleName();

    private SplashLoginPresenter splashLoginPresenter = new SplashLoginPresenter();
    private static final int RC_SIGN_IN = 0;
    private static final int RC_SIGN_IN_SUCCESS = -1;
    private static ProgressDialog progressDialog;
    private CallbackManager callbackManager;

    private GoogleApiClient mGoogleApiClient;


    @BindView(R.id.splash_layout)
    LinearLayout splashLayout;
    @BindView(R.id.login_layout)
    LinearLayout loginLayout;
    @BindView(R.id.fb_btn)
    LoginButton fbButton;

    public static SplashLoginFragment newInstance()
    {
        SplashLoginFragment splashLoginFragment = new SplashLoginFragment();
        return splashLoginFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getActivity()); //For facebook
        callbackManager = CallbackManager.Factory.create();
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Plus.API)
                .addScope(Plus.SCOPE_PLUS_LOGIN)
                .build();

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Connecting...");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        if(getFragmentView() == null)
        {
            setFragmentView(inflater.inflate(R.layout.fragment_splash_login, container,false));

            loginLayout.setVisibility(View.GONE);
            splashLayout.setVisibility(View.VISIBLE);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run()
                {
                    loginLayout.setVisibility(View.VISIBLE);
                    splashLayout.setVisibility(View.GONE);
                }
            },2000);

            fbButton.setFragment(this);
            fbButton.setReadPermissions(Arrays.asList("public_profile", "email", "user_friends", "user_likes", "user_about_me"));

            fbButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>()
            {
                @Override
                public void onSuccess(LoginResult loginResult)
                {
                    ConsoleLog.i(TAG, "on success fb");
                    AccessToken accessToken = loginResult.getAccessToken();

                    getFacebookLoginDetailsFromAccesToken(accessToken);

                }

                @Override
                public void onCancel()
                {
                    ViewUtil.t(getContext(), "Facebook Login cancelled");
                }

                @Override
                public void onError(FacebookException e)
                {
                    ConsoleLog.e(e);
                }
            });
        }

        return getFragmentView();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        try
        {
            ConsoleLog.i(TAG, "on activity result");
            ConsoleLog.i(TAG, "Result code is" + resultCode + ": Request Code is" + requestCode);
            if (requestCode == 0 && resultCode == 0)
            {
                progressDialog.dismiss();
            }
            if (requestCode == RC_SIGN_IN)
            {
                if (resultCode == RC_SIGN_IN_SUCCESS)
                {
                    if (!mGoogleApiClient.isConnecting())
                    {
                        mGoogleApiClient.connect();
                    }
                }
            }
            else
            {
                super.onActivityResult(requestCode, resultCode, data);
                callbackManager.onActivityResult(requestCode, resultCode, data);
            }
        }
        catch (NullPointerException e)
        {
            ConsoleLog.e(e);
        }
    }

    private void getFacebookLoginDetailsFromAccesToken(AccessToken accessToken)
    {
        GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response)
            {
                ConsoleLog.i(TAG, "graph req resp came");
                try
                {
                    JSONObject fbGraphObject = response.getJSONObject();
                    // JSONObject fbGraphObject = fbJsonData.getJSONObject("graphObject");
                    String fbId = fbGraphObject.getString("id");
                    //String fbUserName = "";
                    String fbEmail = fbGraphObject.getString("email");
                    String fbFirstName = fbGraphObject.getString("first_name");
                    String fbLastName = fbGraphObject.getString("last_name");
                    String fbGender = fbGraphObject.getString("gender");
                    String fbVerifiedEmail = fbGraphObject.getString("verified");

                    //TODO
                } catch (JSONException e) {
                   ConsoleLog.e(e);
                }
            }
        });

        request.executeAsync();
    }

    @OnClick(R.id.glogin_btn)
    protected void onGoogleClick()
    {
        readAccounts();
    }

    @OnClick(R.id.fb_cbtn)
    protected void fbClick()
    {
        fbButton.performClick();
    }

    @Override
    protected SplashLoginPresenter getCorePresenter()
    {
        return splashLoginPresenter;
    }

    @Override
    public void loginSuccess(CDropMeUser cDropMeUser)
    {

    }

    @Override
    public void Failed()
    {

    }

    @Override
    public void signupSuccess(long id)
    {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle)
    {
        ConsoleLog.i(TAG, "G+ onconnected");
        progressDialog.dismiss();

        Plus.PeopleApi.loadVisible(mGoogleApiClient, null).setResultCallback(this);

        if (Plus.PeopleApi.getCurrentPerson(mGoogleApiClient) != null)
        {
            Person currentPerson = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
            String gplusEmail = Plus.AccountApi.getAccountName(mGoogleApiClient);
            String id = currentPerson.getId();
            String personName = currentPerson.getDisplayName();
            String firstName = currentPerson.getName().getGivenName();
            String lastName = currentPerson.getName().getFamilyName();
            int gender = currentPerson.getGender(); //1 for female, 0 for male. 2 for others
            String sgender = null;
            if (gender == 0) {
                sgender = "male";
            } else if (gender == 1) {
                sgender = "female";
            } else {
                sgender = "others";
            }
            String picture = currentPerson.getImage().getUrl();
//            currentPerson.getCover().getCoverPhoto();

            String locale = currentPerson.getLanguage();
            String verifiedEmail = String.valueOf(currentPerson.isVerified());

            ConsoleLog.i(TAG, "email is : " + gplusEmail);

            Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
            mGoogleApiClient.disconnect();

        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult)
    {
        ConsoleLog.i(TAG, "connection resut is : " + connectionResult.getErrorCode() + " error msg is : " + connectionResult.getErrorMessage());
        if (connectionResult.hasResolution())
        {
            ConsoleLog.i(TAG, String.valueOf(connectionResult.getResolution()));
            // The user has already clicked 'sign-in' so we attempt to resolve all
            // errors until the user is signed in, or they cancel.
            try
            {
                connectionResult.startResolutionForResult(getActivity(), RC_SIGN_IN);
            }
            catch (IntentSender.SendIntentException e)
            {
                // The intent was canceled before it was sent.  Return to the default
                // state and attempt to connect to get an updated ConnectionResult.
                ConsoleLog.e(e);
            }
        }
    }

    @Override
    public void onResult(@NonNull People.LoadPeopleResult loadPeopleResult) {

    }

    public void readAccounts()
    {
        if (ActivityCompat.checkSelfPermission(getCoreActivity(), Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            getContactsPermissions();
        } else {
            connectToGooglePlus();
        }
    }

    private void getContactsPermissions()
    {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getCoreActivity(), Manifest.permission.GET_ACCOUNTS))
        {
            Snackbar.make(getFragmentView(), "Require access to Gmail to authenticate your account.",
                    Snackbar.LENGTH_LONG)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            requestPermissions(
                                    new String[]{Manifest.permission.GET_ACCOUNTS},
                                    PermisionConstant.REQUEST_READ_CONTACT);
                        }
                    })
                    .show();
        }
        else
        {
            requestPermissions(new String[]{Manifest.permission.GET_ACCOUNTS},
                    PermisionConstant.REQUEST_READ_CONTACT);
        }
    }

    private void connectToGooglePlus() {
        progressDialog.show();
        if (!mGoogleApiClient.isConnecting() && !mGoogleApiClient.isConnected()) {
            mGoogleApiClient.connect();
        } else if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.clearDefaultAccountAndReconnect();
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        //mGoogleApiClient.connect();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == PermisionConstant.REQUEST_READ_CONTACT) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Snackbar.make(getRootView(), R.string.permision_available_contacts,
//                        Snackbar.LENGTH_SHORT).show();
                readAccounts();
            } else {
                Snackbar.make(getFragmentView(), "No permision. cannot login",
                        Snackbar.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onStop()
    {
        super.onStop();
        if (mGoogleApiClient.isConnected())
        {
            mGoogleApiClient.disconnect();
        }

    }

}