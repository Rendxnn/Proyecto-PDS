public class Sensor {

    public boolean entrada(int senal, int senal2) {
        if (senal > senal2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean salida(int senal, int senal2) {
        if (senal2 > senal) {
            return true;
        } else {
            return true;
        }
    }
}