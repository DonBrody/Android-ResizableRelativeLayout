# Android-ResizableRelativeLayout
Custom Android component that extends RelativeLayout, and provides children with the functionality needed to easily resize themselves on orientation change.

## Prerequisites
Make sure you have a version of Android Studio installed that supports Kotlin (3+ should be fine).

## Running the Demo
Just download the project, open it in Android Studio, connect to a virtual or physical device, and run it! There shouldn't be any further configuration required (unless you need to download build tools, etc., but Android Studio should prompt you to do that).

The demo is one activity (MainActivity.java). Below are screen shots of the activity in both portrait and landscape. Notice that in both orientations the demo form is 80% of the screen width. Clicking the submit button pops some toast to give you some feedback. The fields aren't connected to anything, nor do they check for a valid email or matching passwords. They're just there as an example of what you could use this component for.

<img height="300px" width="400px" src="https://s3.amazonaws.com/don-brody-images/ResizableForm+Landscape.jpg"/>&nbsp;&nbsp;&nbsp;&nbsp;<img height="400px" width="300px" src="https://s3.amazonaws.com/don-brody-images/ResizableForm+Portrait.jpg"/>

## How It Works
This is a very simple, 37 line component (including imports and comments). It's an abstract class that extends RelativeLayout, and hooks into the onSizeChanged callback. When size changes, it removes all child views and calls its one abstract method configureSelf. Child classes must re-render themselves when triggered by the configureSelf function call.

In order for this component to receive notification of onSizeChanged, you must add the following line to the manifest for each activity that utilizes this component:
```
android:configChanges="orientation|screenSize"
```
For example, the MainActivity for this demo project is declared in the manifest like this:
```
<activity
    android:name=".MainActivity"
    android:configChanges="orientation|screenSize">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
```

## Next Steps
Add the ResizableRelativeLayout to any (and hopefully all :) of your projects, extend it with any views you'd like, and enjoy!

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
