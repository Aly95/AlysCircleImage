# AlysCircleImage

implementation 'com.github.Aly95:AlysCircleImage:1.1'

The library comes with two functions, showImage(imageId: Int, imageSize: Float) and addStroke(strokeColour: Int, strokeWidth: Float)

In order to use the library, first add AlysCircleImageView in xml, then in an Activity/Fragment, call show_image() on the CircleView

Example:

circle_image.showImage(R.drawable.custom_image, 60f) circle_image.addStroke(Colour.BLACK, 2f)

<com.example.circularimage.AlysCircleImageView android:id="@+id/circle_image"
app:default_radius="64"/>

Notes:

default_radius should be half the image height/width addStroke defaults to Colour.WHITE and 2f for colour and size respectively

GitHub projects require the following to work:

Project gradle file:

allprojects { repositories { maven { url 'https://jitpack.io' } } }

repositories { mavenCentral() }
