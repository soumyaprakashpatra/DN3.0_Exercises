//Define a Product Class:
//Create a class Computer with attributes like CPU, RAM, Storage, etc.
//Create a static nested Builder class inside Computer with methods to set each attribute.
//Provide a `build()` method in the Builder class that returns an instance of Computer.
//Ensure that the Computer class has a private constructor that takes the Builder as a parameter.

public class Computer {
    // Attributes of the Computer
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;
    private String powerSupply;
    private String coolingSystem;

    // Private constructor to enforce the use of the Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.powerSupply = builder.powerSupply;
        this.coolingSystem = builder.coolingSystem;
    }

    // Getters for the attributes
    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return storage;
    }

    public String getGPU() {
        return GPU;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public String getCoolingSystem() {
        return coolingSystem;
    }

    // Static nested Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;
        private String powerSupply;
        private String coolingSystem;

        // Builder methods for setting attributes
        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Builder setCoolingSystem(String coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }

        // Build method to create an instance of Computer
        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", GPU=" + GPU +
               ", powerSupply=" + powerSupply + ", coolingSystem=" + coolingSystem + "]";
    }
}
