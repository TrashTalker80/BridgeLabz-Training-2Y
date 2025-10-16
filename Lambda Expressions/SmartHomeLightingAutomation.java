import java.util.HashMap;
import java.util.Map;

interface LightBehavior {
    void activate();
}

public class SmartHomeLightingAutomation {
    public static void main(String[] args) {
        Map<String, LightBehavior> lightTriggers = new HashMap<>();
        
        lightTriggers.put("motion", () -> System.out.println("Motion detected: Turning on lights at 80% brightness"));
        
        lightTriggers.put("morning", () -> System.out.println("Morning time: Setting lights to warm white at 60% brightness"));
        
        lightTriggers.put("evening", () -> System.out.println("Evening time: Setting lights to cool white at 100% brightness"));
        
        lightTriggers.put("night", () -> System.out.println("Night time: Dimming lights to 20% brightness"));
        
        lightTriggers.put("voice_on", () -> System.out.println("Voice command 'lights on': Turning on all lights at 100% brightness"));
        
        lightTriggers.put("voice_off", () -> System.out.println("Voice command 'lights off': Turning off all lights"));
        
        lightTriggers.put("movie_mode", () -> System.out.println("Movie mode activated: Setting ambient lighting at 30% brightness"));
        
        System.out.println("Smart Home Lighting Automation System");
        System.out.println("=====================================\n");
        
        lightTriggers.get("motion").activate();
        lightTriggers.get("morning").activate();
        lightTriggers.get("evening").activate();
        lightTriggers.get("night").activate();
        lightTriggers.get("voice_on").activate();
        lightTriggers.get("voice_off").activate();
        lightTriggers.get("movie_mode").activate();
    }
}
