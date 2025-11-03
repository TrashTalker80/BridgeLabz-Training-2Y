import java.util.ArrayList;

public class SensorDataLogger {
    private static ArrayList<Double> dataStore = new ArrayList<>();
    
    public static void logTemperature(double temperature) {
        dataStore.add(temperature);
    }
    
    public static void logTemperature(Double temperature) {
        dataStore.add(temperature);
    }
    
    public static double getLastReading() {
        if (dataStore.isEmpty()) {
            return 0.0;
        }
        return dataStore.get(dataStore.size() - 1);
    }
    
    public static void main(String[] args) {
        double primitiveSensor1 = 25.5;
        Double wrapperSensor2 = 30.2;
        double primitiveSensor3 = 28.7;
        
        logTemperature(primitiveSensor1);
        logTemperature(wrapperSensor2);
        logTemperature(primitiveSensor3);
        
        System.out.println("All logged temperatures:");
        for (Double temp : dataStore) {
            System.out.println(temp + "°C");
        }
        
        System.out.println("\nLast reading: " + getLastReading() + "°C");
    }
}
