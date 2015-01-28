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
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/27/15.
 */
public class SignUpFragment extends Fragment implements View.OnClickListener{

    private SignUpFragmentCallbacks mListener;

    private AutoCompleteTextView emailField;
    private EditText passwordField;
    private Set<String> emailSet;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$", Pattern.CASE_INSENSITIVE);

    public SignUpFragment() {
        // Mandatory empty constructor
    }

    public static SignUpFragment newInstance() {
        return new SignUpFragment();
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
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        setButtonClickListeners(view);
        getAccouts();

        emailField = (AutoCompleteTextView) view.findViewById(R.id.signUpEmail);
        emailField.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, new ArrayList<String>(emailSet)));
        passwordField = (EditText) view.findViewById(R.id.signUpPassword);


        return view;
    }

    private void getAccouts() {
        AccountManager manager = (AccountManager) getActivity().getSystemService(Context.ACCOUNT_SERVICE);
        Account[] list = manager.getAccounts();

        for (Account account : list) {
            if (EMAIL_PATTERN.matcher(account.name).matches()) {
                emailSet.add(account.name);
            }
        }
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
                if (emailField.length() == 0) {
                    showToast("Please enter email");
                } else if (passwordField.length() == 0) {
                    showToast("Please enter password");
                } else {
                    signUp(emailField.getText().toString(), passwordField.getText().toString());
                }
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

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    private void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(emailField.getWindowToken(), 0);
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
                    // Hide keyboard
                    hideKeyboard();

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
