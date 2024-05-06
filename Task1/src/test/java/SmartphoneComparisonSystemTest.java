import org.example.Smartphone;
import org.example.SmartphoneComparisonSystem;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class SmartphoneComparisonSystemTest {

    @Test
    void testAddSmartphone() {
        SmartphoneComparisonSystem system = new SmartphoneComparisonSystem();
        Smartphone smartphone = new Smartphone("Samsung", "Galaxy S21", 999.99);
        system.addSmartphone(smartphone);
        assertTrue(system.getSmartphones().contains(smartphone));
    }

    @Test
    void testSaveAndLoadToFile() {
        SmartphoneComparisonSystem system1 = new SmartphoneComparisonSystem();
        system1.addSmartphone(new Smartphone("Apple", "iPhone 13", 1099.99));
        system1.addSmartphone(new Smartphone("Google", "Pixel 6", 899.99));

        // Save to file
        system1.saveToFile("CompileInfo.txt");

        // Load from file
        SmartphoneComparisonSystem system2 = new SmartphoneComparisonSystem();
        system2.loadFromFile("CompileInfo.txt");

        assertEquals(system1.getSmartphones(), system2.getSmartphones());
    }
}