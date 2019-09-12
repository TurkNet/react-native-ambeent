import { NativeModules } from 'react-native';

const { Ambeent } = NativeModules;

export default {
    sense({
        discoverNetwork = true,
        measureSpeed = true,
        detectRouterModel = true,
    }) {
        return Ambeent.sense(discoverNetwork, measureSpeed, detectRouterModel);
    }
};


/*

discoverNetwork = true; // This should be true, if you want to scan the n etwork.
boolean measureSpeed = true; // This should be true, if you want to make measure ments.
boolean detectRouterModel = true; // This should be true, if you want to detect R outer Model.
double bw = sense(discoverNetwork, measureSpeed, detectRouterModel);
Log.d(TAG, bw);

*/
