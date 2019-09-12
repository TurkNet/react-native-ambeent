# react-native-ambeent

## Getting started

`$ npm install react-native-ambeent --save`

### Mostly automatic installation

`$ react-native link react-native-ambeent`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-ambeent` and add `Ambeent.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libAmbeent.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import turknet.reactnative.AmbeentPackage;` to the imports at the top of the file
  - Add `new AmbeentPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-ambeent'
  	project(':react-native-ambeent').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-ambeent/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-ambeent')
  	```


## Usage
```javascript
import Ambeent from 'react-native-ambeent';

// TODO: What to do with the module?
Ambeent;
```
