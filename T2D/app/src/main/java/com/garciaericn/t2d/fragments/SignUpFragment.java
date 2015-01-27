package com.garciaericn.t2d.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.garciaericn.t2d.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/27/15.
 */
public class SignUpFragment extends Fragment implements View.OnClickListener{

    private SignUpFragmentCallbacks mListener;

    private EditText emailField;
    private EditText passwordField;

    public SignUpFragment() {
        // Mandatory empty constructor
    }

    public static SignUpFragment newInstance() {
        return new SignUpFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        setButtonClickListeners(view);


        emailField = (EditText) view.findViewById(R.id.signUpEmail);
        passwordField = (EditText) view.findViewById(R.id.signUpPassword);


        return view;
    }

    private void setButtonClickListeners(View view) {
        Button signUp = (Button) view.findViewById(R.id.button_sign_up);
        signUp.setOnClickListener(this);
        Button logIn = (Button) view.findViewById(R.id.button_log_in);
        logIn.setOnClickListener(this);
        Button signUpWithFacebook = (Button) view.findViewById(R.id.button_facebook_log_in);
        signUpWithFacebook.setOnClickListener(this);
        Button signUpWithTwitter = (Button) view.findViewById(R.id.button_twitter_log_in);
        signUpWithTwitter.setOnClickListener(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (SignUpFragmentCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement SignUpFragmentCallbacks");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_log_in: {
                // Load login fragment
                break;
            }
            case R.id.button_sign_up: {
                // Create user and log in
                signUp(emailField.getText().toString(), passwordField.getText().toString());
                break;
            }
            case R.id.signUpEmail: {
                // Pull up dropdown to select for user accounts.
                break;
            }
            case R.id.button_facebook_log_in: {
                mListener.facebookSignUp();
                break;
            }
            case R.id.button_twitter_log_in: {
                break;
            }
        }
    }

    private void signUp(String userEmail, String password) {

        ParseUser user = new ParseUser();
        user.setUsername(userEmail);
        user.setPassword(password);
        user.setEmail(userEmail);

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                    Toast.makeText(getActivity(), "Sign in successful", Toast.LENGTH_SHORT).show();
                    getFragmentManager().beginTransaction()
                            .replace(R.id.list_container, DevicesCardViewFragment.newInstance())
                            .commit();
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    Toast.makeText(getActivity(), "Something went wrong...please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public interface SignUpFragmentCallbacks {
        public void facebookSignUp();
    }
}
