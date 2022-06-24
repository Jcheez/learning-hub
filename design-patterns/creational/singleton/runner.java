public class runner {
    public static void main(String[] args) {
        Settings s = Settings.instance();
        System.out.println(s.currentVolume()); // 50
        s.setVolume(75);
        System.out.println(s.currentVolume()); // 75

        Settings s2 = Settings.instance();
        System.out.println(s2.currentVolume()); // 75
    }
}
