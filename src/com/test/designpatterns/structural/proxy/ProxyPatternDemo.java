package com.test.designpatterns.structural.proxy;

/**
 * Sometimes we need the ability to control the access to an object. For example
 * if we need to use only a few methods of some costly objects we'll initialize
 * those objects when we need them entirely. Until that point we can use some
 * light objects exposing the same interface as the heavy objects. These light
 * objects are called proxies and they will instantiate those heavy objects when
 * they are really need and by then we'll use some light objects instead.
 * 
 * Consider for example an image viewer program. An image viewer program must be
 * able to list and display high resolution photo objects that are in a folder,
 * but how often do someone open a folder and view all the images inside.
 * Sometimes you will be looking for a particular photo, sometimes you will only
 * want to see an image name. The image viewer must be able to list all photo
 * objects, but the photo objects must not be loaded into memory until they are
 * required to be rendered.
 * 
 * e.g. session.load() which loads the proxy only and loads the object when it
 * is first accessed.
 * 
 * @author vigoel
 *
 */
public class ProxyPatternDemo {

	public static void main(String[] args) {

		// assuming that the user selects a folder that has 3 images
		// create the 3 images
		Image highResolutionImage1 = new ImageProxy("sample/veryHighResPhoto1.jpeg");
		Image highResolutionImage2 = new ImageProxy("sample/veryHighResPhoto2.jpeg");
		Image highResolutionImage3 = new ImageProxy("sample/veryHighResPhoto3.jpeg");

		// assume that the user clicks on Image one item in a list
		// this would cause the program to call showImage() for that image only
		// note that in this case only image one was loaded into memory
		highResolutionImage1.showImage();

		// consider using the high resolution image object directly
		Image highResolutionImageNoProxy1 = new HighResolutionImage("sample/veryHighResPhoto1.jpeg");
		Image highResolutionImageNoProxy2 = new HighResolutionImage("sample/veryHighResPhoto2.jpeg");
		Image highResolutionImageBoProxy3 = new HighResolutionImage("sample/veryHighResPhoto3.jpeg");

		// assume that the user selects image two item from images list
		highResolutionImageNoProxy2.showImage();

		// note that in this case all images have been loaded into memory
		// and not all have been actually displayed
		// this is a waste of memory resources
	}
}

/**
 * Subject Interface
 */
interface Image {

	public void showImage();

}

class HighResolutionImage implements Image {

	public HighResolutionImage(String imageFilePath) {

		loadImage(imageFilePath);
	}

	private void loadImage(String imageFilePath) {
		// load Image from disk into memory
		// this is heavy and costly operation
		System.out.println("Loading image: " + imageFilePath);
	}

	@Override
	public void showImage() {
		// Actual Image rendering logic
	}
}

class ImageProxy implements Image {

	/**
	 * Private Proxy data
	 */
	private String imageFilePath;

	/**
	 * Reference to RealSubject
	 */
	private Image proxifiedImage;

	public ImageProxy(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	@Override
	public void showImage() {

		// create the Image Object only when the image is required to be shown

		proxifiedImage = new HighResolutionImage(imageFilePath);

		// now call showImage on realSubject
		proxifiedImage.showImage();

	}
}