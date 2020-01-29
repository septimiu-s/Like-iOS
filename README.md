# Like-iOS
(latest version 0.2.7)

How to use the library in your project:

Step 1. 
  Add the JitPack repository to your your root build.gradle at the end of repositories:
  
      	allprojects {
		        repositories {
			        ...
			        maven { url 'https://jitpack.io' }
		        }
	}
        
Step 2.
  Add the dependency inside your build.gradle(app module) & the Google Material dependency to be able to use the BottomSheetDialogFragment
  
	    dependencies {
            implementation 'com.github.ssepty10:Like-iOS:VERSION'
            implementation 'com.google.android.material:material:VERSION'
	    }
  
