//Test the Builder Implementation:
//Create a test class to demonstrate the creation of different configurations of Computer using the Builder pattern.

public class BuilderPatternTest {
    public static void main(String[] args) {
        // Create different configurations of Computer using the Builder pattern
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setPowerSupply("750W")
                .setCoolingSystem("Liquid Cooling")
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setPowerSupply("500W")
                .build();

        Computer budgetPC = new Computer.Builder()
                .setCPU("AMD Ryzen 5")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();

        // Print the configurations
        System.out.println(gamingPC);
        System.out.println(officePC);
        System.out.println(budgetPC);
    }
}
