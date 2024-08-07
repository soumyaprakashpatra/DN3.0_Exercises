//This is the proxy class that implements the `Image` interface and holds a reference to `RealImage`.
//It implements lazy initialization by only loading the real image when it is first needed (i.e., when `display()` is called for the first time).
//It caches the `RealImage` instance to avoid loading the image again on subsequent calls to `display()`.

public class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
