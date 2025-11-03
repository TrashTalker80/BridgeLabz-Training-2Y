public class WrapperToPrimitive {
    public static void main(String[] args) {
        Double wrapperValue = 45.67;
        
        double primitiveDouble = wrapperValue.doubleValue();
        int primitiveInt = wrapperValue.intValue();
        
        System.out.println("Wrapper value: " + wrapperValue);
        System.out.println("Primitive double: " + primitiveDouble);
        System.out.println("Primitive int (casted): " + primitiveInt);
    }
}
