
public class PictureDemo {
    public static void main(String[] args) {
        Picture pic = new Picture();
        pic.load("queen-mary.png");
        pic.scale(200, 200);
        pic.move(20, 20);
        pic.border(10);
    }
}
