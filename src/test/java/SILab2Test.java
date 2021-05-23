import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class SILab2Test {
    private List<Time> createList(Time...elems){
        return new ArrayList<>(Arrays.asList(elems));
    }
    @Test
    void multipleConditionsTest(){
    RuntimeException exception;
    //  if (hr < 0 || hr > 24)     TX,FT,FF
    exception=assertThrows(RuntimeException.class, ()->SILab2.function(createList(new Time(-3,15,18), new Time(8,15,18))));
    assertTrue(exception.getMessage().contains("The hours are smaller than the minimum"));

    exception=assertThrows(RuntimeException.class, ()->SILab2.function(createList(new Time(25,15,18))));
    assertTrue(exception.getMessage().contains("The hours are grater than the maximum"));

    assertEquals(Arrays.asList(18918, 29718, 36918),SILab2.function(createList(new Time(5,15,18),new Time(8,15,18),new Time(10,15,18))));


        //if (min < 0 || min > 59)     TX,FT,FF
    exception=assertThrows(RuntimeException.class, ()->SILab2.function(createList(new Time(15, -8,30),new Time(18,-6,25))));
    assertTrue(exception.getMessage().contains("The minutes are not valid!"));

    exception=assertThrows(RuntimeException.class, ()->SILab2.function(createList(new Time(15, 80,30),new Time(18,100,25))));
    assertTrue(exception.getMessage().contains("The minutes are not valid!"));

    assertEquals(Arrays.asList(29898),SILab2.function(createList(new Time(8,18,18))));


        //if (sec >= 0 && sec <= 59)     FX, TF, TT
    exception=assertThrows(RuntimeException.class, ()->SILab2.function(createList(new Time(13,15,-10))));
    assertTrue(exception.getMessage().contains("The seconds are not valid"));

    exception=assertThrows(RuntimeException.class, ()->SILab2.function(createList(new Time(13,15,100))));
    assertTrue(exception.getMessage().contains("The seconds are not valid"));

    assertEquals(Arrays.asList(29898),SILab2.function(createList(new Time(8,18,18))));


        //if (hr == 24 && min == 0 && sec == 0)     FXX-nemozi, TFX, TTF, TTT
        /* exception=assertThrows(RuntimeException.class, ()->SILab2.function(createList(new Time(0,35,58))));
        assertTrue(exception.getMessage().contains("The time is greater than the maximum"));*/

    exception=assertThrows(RuntimeException.class, ()->SILab2.function(createList(new Time(24,35,58))));
    assertTrue(exception.getMessage().contains("The time is greater than the maximum"));

    exception=assertThrows(RuntimeException.class, ()->SILab2.function(createList(new Time(24,0,58))));
    assertTrue(exception.getMessage().contains("The time is greater than the maximum"));

    assertEquals(Arrays.asList(86400), SILab2.function(createList(new Time(24, 0, 0))));

        }
    @Test
    void everyBranchTest(){
        RuntimeException exception;

        assertEquals(Arrays.asList(18918),SILab2.function(createList(new Time(5,15,18))));
        assertEquals(Arrays.asList(86400), SILab2.function(createList(new Time(24,0,0))));

        exception=assertThrows(RuntimeException.class, ()->SILab2.function(createList(new Time(-1,18,15))));
        assertTrue(exception.getMessage().contains("The hours are smaller than the minimum"));

        exception=assertThrows(RuntimeException.class, ()->SILab2.function(createList(new Time(28,18,18))));
        assertTrue(exception.getMessage().contains("The hours are grater than the maximum"));

        exception=assertThrows(RuntimeException.class, ()->SILab2.function(createList(new Time(20, -1,18),new Time(18,-6,25))));
        assertTrue(exception.getMessage().contains("The minutes are not valid!"));

        exception=assertThrows(RuntimeException.class, ()->SILab2.function(createList(new Time(20,5,-8),new Time(20,5,100))));
        assertTrue(exception.getMessage().contains("The seconds are not valid"));

        exception=assertThrows(RuntimeException.class, ()->SILab2.function(createList(new Time(24,15,15))));
        assertTrue(exception.getMessage().contains("The time is greater than the maximum"));
    }
}