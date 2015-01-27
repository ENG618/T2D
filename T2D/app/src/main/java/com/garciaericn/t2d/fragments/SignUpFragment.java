package com.garciaericn.t2d.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        return view;
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
            }
            case R.id.signUpEmail: {
                // Pull up dropdown to select for user accounts.
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
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    Toast.makeText(getActivity(), "Something went wrong...please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
