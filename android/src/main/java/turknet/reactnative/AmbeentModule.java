package turknet.reactnative;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.wireless.ambeentutil.Ambeent;
import android.util.Log;
import java.lang.Exception;

public class AmbeentModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private final Ambeent ambeent;

    public AmbeentModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "Ambeent";
    }

    @ReactMethod
    public void init(
        String companyID,
        String customerID,
        Promise promise
    ) {

        if (this.ambeent != null) {
            promise.resolve();
            return;
        }
        
        try {
            this.ambeent = new Ambeent(this.reactContext, companyID, customerID);
            Log.d("react-native-ambeent", "initilized with companyID: " + companyID + " customerID:" + customerID);
            promise.resolve();
        } catch (Exception e) {
            promise.reject("E_AMBEENT_ERROR", e);
        }

    }

    @ReactMethod
    public void sense(
        Boolean discoverNetwork,
        Boolean measureSpeed,
        Boolean detectRouterModel,
        Promise promise
    ) {
        if (this.ambeent == null) {
            promise.reject("E_AMBEENT_NOT_INITIALIZED");
            return;
        }

        try {
            Double bw = this.ambeent.sense(discoverNetwork, measureSpeed, detectRouterModel);
            Log.d("react-native-ambeent", String.valueOf(bw));
            promise.resolve(bw);
        } catch (Exception e) {
            promise.reject("E_AMBEENT_ERROR", e);
        }
    }

}
