import { NativeModules } from 'react-native';

const { Ambeent: AmbeentNativeModule } = NativeModules;

const Ambeent = {

    init() {
        return AmbeentNativeModule.init(companyID, customerID);
    },

    sense({
        discoverNetwork = true,
        measureSpeed = true,
        detectRouterModel = true,
    } = {}) {
        return AmbeentNativeModule.sense(discoverNetwork, measureSpeed, detectRouterModel);
    }
};


/*
discoverNetwork = true; // This should be true, if you want to scan the n etwork.
boolean measureSpeed = true; // This should be true, if you want to make measure ments.
boolean detectRouterModel = true; // This should be true, if you want to detect R outer Model.
double bw = sense(discoverNetwork, measureSpeed, detectRouterModel);
*/

export default Ambeent;
