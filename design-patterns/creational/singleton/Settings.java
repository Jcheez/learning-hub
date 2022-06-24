public class Settings {
    private int volume = 50;
    private boolean wifi = false;
    private boolean batterySaver = false;

    private static Settings instance = null;

    private Settings() {
        System.out.println("Settings is being initalised");
    }

    public static Settings instance() {
        if (Settings.instance == null) {
            Settings.instance = new Settings();
        }
        return Settings.instance;
    }

    public void setVolume(int newVolume) {
        if (newVolume > 100) {
            System.out.println("Maximum volume is 100");
            return;
        } else if (newVolume < 0) {
            System.out.println("Minimum volume is 0");
            return;
        }
        this.volume = newVolume;
    }

    public void toggleWifi() {
        this.wifi = !this.wifi;
    }

    public void toggleBatterySaver() {
        this.batterySaver = !this.batterySaver;
    }

    public int currentVolume() {
        return this.volume;
    }

    public boolean isWifiOn() {
        return this.wifi;
    }

    public boolean isBatterySaverOn() {
        return this.batterySaver;
    }
}