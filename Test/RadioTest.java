package Test;

import org.junit.jupiter.api.Assertions.*;

import Model.IRadio;
import Model.Radio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RadioTest {

    IRadio miRadio = new Radio();
    @Test
    void defaultAM() {
        int result = miRadio.getAMActualStation();
        assertEquals(530, result);
    }

    @Test
    void defaultFM() {
        double result = miRadio.getFMActualStation();
        assertEquals(87.9, result);
    }

    @Test
    void defaultFrequence() {
        String result = miRadio.getFrequence();
        assertEquals("AM", result);
    }
    
}
