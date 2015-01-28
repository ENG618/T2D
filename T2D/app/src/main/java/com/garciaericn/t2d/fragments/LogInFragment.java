package com.garciaericn.t2d.fragments;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.garciaericn.t2d.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/27/15.
 */
public class LogInFragment extends Fragment implements View.OnClickListener{

    private AutoCompleteTextView emailField;
    private EditText passwordField;
    private Set<String> emailSet;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$", Pattern.CASE_INSENSITIVE);
    private LoginFragmentCallbacks mListener;

    public LogInFragment() {
        //Mandatory empty constructor
    }

    public static LogInFragment newInstance() {
        return new LogInFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (emailSet == null) {
            emailSet = new HashSet<String>();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        setButtonClickListeners(view);
        getAccounts();

        emailField = (AutoCompleteTextView) view.findViewById(R.id.loginEmail);
        emailField.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, new ArrayList<String>(emailSet)));
        passwordField = (EditText) view.findViewById(R.id.loginPassword);


        return view;
    }

    private void getAccounts() {
        AccountManager manager = (AccountManager) getActivity().getSystemService(Context.ACCOUNT_SERVICE);
        Account[] list = manager.getAccounts();

        for (Account account : list) {
            if (EMAIL_PATTERN.matcher(account.name).matches()) {
                emailSet.add(account.name);
            }
        }
    }

    private void setButtonClickListeners(View view) {
        Button loginBtn = (Button) view.findViewById(R.id.button_login);
        loginBtn.setOnClickListener(this);
        Button signUpWithFacebook = (Button) view.findViewById(R.id.button_facebook_login);
        signUpWithFacebook.setOnClickListener(this);
        Button signUpWithTwitter = (Button) view.findViewById(R.id.button_twitter_login);
        signUpWithTwitter.setOnClickListener(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (LoginFragmentCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement SignUpFragmentCallbacks");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login: {
                if (emailField.length() == 0) {
                    showToast("Please enter email");
                } else if (passwordField.length() == 0) {
                    showToast("Please enter password");
                } else {
                    login(emailField.getText().toString(), passwordField.getText().toString());
                }
                break;
            }
        }
    }

    private void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(emailField.getWindowToken(), 0);
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    private void login(String userEmail, String password) {
        ParseUser.logInInBackground(userEmail, password, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    // Hooray! The user is logged in.
                    // Hide keyboard
                    hideKeyboard();

                    showToast("Login successful");
                    getFragmentManager().beginTransaction()
                            .replace(R.id.list_container, DevicesCardViewFragment.newInstance())
                            .commit();
                } else {
                    // Signup failed. Look at the ParseException to see what happened.
                }
            }
        });
    }

    public interface LoginFragmentCallbacks {
        public void facebookLogin();
    }
}
