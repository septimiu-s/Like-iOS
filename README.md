# Like-iOS
[![](https://jitpack.io/v/ssepty10/Like-iOS.svg)](https://jitpack.io/#ssepty10/Like-iOS)
## How to import the library in your project:

#### Step 1. 
  Add the JitPack repository to your your root build.gradle at the end of repositories:
  
      	allprojects {
		        repositories {
			        ...
			        maven { url 'https://jitpack.io' }
		        }
	}
        
#### Step 2.
  Add the dependency inside your build.gradle(app module) & the Google Material dependency to be able to use the BottomSheetDialogFragment
  
	    dependencies {
            implementation 'com.github.ssepty10:Like-iOS:VERSION'
            implementation 'com.google.android.material:material:VERSION'
	    }
  
## USAGE

#### Example:

<img src="https://user-images.githubusercontent.com/41394271/73343012-75596600-4288-11ea-9d98-0290007ed1a3.png" width="360" height="720">

#### Step 1. 
Declare and implement your OnSelectionListener
```
private val mOnSelectionListener = object : LikeiOS.OnSelectionListener {
        override fun onSelection(option: String) {
            TODO: what will happen when an option is press - option = text from the option pressed
        }
```

#### Step 2. 
Create the builder and show it!
```
LikeiOS.Builder()
                .fragmentManager(supportFragmentManager)
                .listener(mOnSelectionListener)
                .title("Select option")
                .addItem("Hello 1")
                .addItem("Hello 2", true)
                .addItem("Hello 3")
                .buildAndShow()
```
