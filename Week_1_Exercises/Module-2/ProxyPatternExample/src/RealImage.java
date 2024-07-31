//This is the real subject class that implements the `Image` interface.
//It simulates loading an image from a remote server in the `loadImageFromDisk()` method.
//The `display()` method displays the image.

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}
