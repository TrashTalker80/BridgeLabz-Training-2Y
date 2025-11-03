import java.util.ArrayList;

public class StudentMarksReport {
    public static void main(String[] args) {
        Object[] inputs = {"85", 95, Integer.valueOf(88), "null", "92", "invalid", 78};
        
        ArrayList<Integer> validMarks = new ArrayList<>();
        
        for (Object input : inputs) {
            try {
                Integer mark = null;
                
                if (input instanceof String) {
                    String strInput = (String) input;
                    if (!strInput.equals("null")) {
                        mark = Integer.parseInt(strInput);
                    }
                } else if (input instanceof Integer) {
                    mark = (Integer) input;
                }
                
                if (mark != null) {
                    validMarks.add(mark);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry ignored: " + input);
            }
        }
        
        if (validMarks.isEmpty()) {
            System.out.println("No valid marks found.");
            return;
        }
        
        int sum = 0;
        for (Integer mark : validMarks) {
            sum += mark;
        }
        double average = (double) sum / validMarks.size();
        
        System.out.println("Valid marks count: " + validMarks.size());
        System.out.println("Average marks: " + average);
    }
}
