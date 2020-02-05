package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

import com.wireless.ambeentutil.Ambeent;

import android.util.Log;
import java.util.Arrays;
import java.lang.Exception;

public class ReactNativeAmbeentModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public ReactNativeAmbeentModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "ReactNativeAmbeent";
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Promise promise) {
        Log.d("react-native-ambeent",
                "Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
        promise.resolve("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }

    @ReactMethod
    public void sense(String companyID, String customerID, Boolean discoverNetwork, Boolean measureSpeed,
            Boolean detectRouterModel, Promise promise) {

        Log.d("react-native-ambeent", "sense method invoked with the following parameters");
        Log.d("react-native-ambeent", "companyID: " + companyID + " customerID:" + customerID);

        try {
            Ambeent ambeent = new Ambeent(this.reactContext, companyID, customerID);
            int[] bw = ambeent.sense(discoverNetwork, measureSpeed, detectRouterModel);
            String senseResult = Arrays.toString(bw);

            Log.d("react-native-ambeent", "sense result" + senseResult);
            promise.resolve(senseResult);
        } catch (Exception e) {
            promise.reject("E_AMBEENT_ERROR", e);
        }
    }
}
