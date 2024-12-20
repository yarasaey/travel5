/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author icc
 */
// CustomerProfile.java
public class CustomerProfile {
    private String name;
    private String email;
    private String phoneNumber;
    private String preferences;
    private String address;

    // Private constructor accessible only via the Builder
    private CustomerProfile(CustomerBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.preferences = builder.preferences;
        this.address = builder.address;
    }

    // Static inner Builder class
    public static class CustomerBuilder {
        private String name;         // Required
        private String email;        // Required
        private String phoneNumber;  // Optional
        private String preferences;  // Optional
        private String address;      // Optional

        // Constructor with required parameters
        public CustomerBuilder(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public CustomerBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public CustomerBuilder preferences(String preferences) {
            this.preferences = preferences;
            return this;
        }

        public CustomerBuilder address(String address) {
            this.address = address;
            return this;
        }

        // Build method to create a CustomerProfile
        public CustomerProfile build() {
            return new CustomerProfile(this);
        }
    }

    @Override
    public String toString() {
        return "CustomerProfile [Name: " + name + ", Email: " + email + 
               ", Phone: " + phoneNumber + ", Preferences: " + preferences + 
               ", Address: " + address + "]";
    }
}

