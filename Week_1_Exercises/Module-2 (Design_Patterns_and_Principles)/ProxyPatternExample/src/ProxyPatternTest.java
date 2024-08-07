//This class tests the Proxy pattern implementation.
//It demonstrates the use of `ProxyImage` to load and display images.
//The first call to `display()` on each `ProxyImage` instance will load the image from the "disk" (simulating loading from a remote server), 
//while subsequent calls will use the cached `RealImage` instance.

public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Images will be loaded from disk
        image1.display();
        System.out.println("");

        // Images will not be loaded from disk
        image1.display();
        System.out.println("");

        // Images will be loaded from disk
        image2.display();
        System.out.println("");

        // Images will not be loaded from disk
        image2.display();
    }
}
