export as namespace Ambeent;

export function init({
    companyID: string,
    customerID: string,
}): Promise;

export function sense(args: senseArgs): Promise;

export interface senseArgs {
    discoverNetwork?: Boolean,
    measureSpeed?: Boolean,
    detectRouterModel?: Boolean,
}
