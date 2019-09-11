package turknet.reactnative;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.wireless.ambeentutil.Ambeent;
import android.util.Log;

public class AmbeentModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private final Ambeent ambeent;

    public AmbeentModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;

        this.ambeent = new Ambeent(reactContext);
    }

    @Override
    public String getName() {
        return "Ambeent";
    }

    @ReactMethod
    public void sense(Boolean discoverNetwork, Boolean measureSpeed, Boolean detectRouterModel) {
        Double bw = this.ambeent.sense(discoverNetwork, measureSpeed, detectRouterModel);
        Log.d("react-native-ambeent", String.valueOf(bw));
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }
}
