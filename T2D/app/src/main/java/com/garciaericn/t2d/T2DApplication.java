package com.garciaericn.t2d;

import android.app.Application;
import android.util.Log;

import com.garciaericn.t2d.data.Device;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.text.ParseException;


/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/24/15.
 */
public class T2DApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Device.class);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "mlbATdfRQ2RMJmNaVjjDcIybrtKnlEmic94bBL6r", "20c54czHXPKcb4ErBfbQe9q9vE9kaf6zS0A4GeLA");


        ParsePush.subscribeInBackground("", new SaveCallback() {

            @Override
            public void done(com.parse.ParseException e) {
                if (e == null) {
                    Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
                } else {
                    Log.e("com.parse.push", "failed to subscribe for push", e);
                }

            }
        });
    }
}
