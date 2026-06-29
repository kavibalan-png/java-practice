// Camera Interface
interface Camera {
    void clickPhoto();
}

// MusicPlayer Interface
interface MusicPlayer {
    void playMusic();
}

// SmartPhone Class
class SmartPhone implements Camera, MusicPlayer {

    public void clickPhoto() {
        System.out.println("Photo clicked");
    }

    public void playMusic() {
        System.out.println("Playing music");
    }
}

// Main Class
public class MultipleInterfaces {
    public static void main(String[] args) {

        SmartPhone phone = new SmartPhone();

        phone.clickPhoto();
        phone.playMusic();
    }
}