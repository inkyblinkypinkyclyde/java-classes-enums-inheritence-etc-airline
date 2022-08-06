import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
    Plane plane1;
    Plane plane2;
    Plane plane3;

    @Before
    public void before(){
        plane1 = new Plane(PlaneType.BIGPLANE);
        plane2 = new Plane(PlaneType.MEDIUMPLANE);
        plane3 = new Plane(PlaneType.TINYPLANE);
    }

    @Test
    public void canGetCapacityForBigPlane(){
        assertEquals(100, plane1.getCapacity());
    }

    @Test
    public void canGetMaxTakeOffWeightForBigPlane(){
        assertEquals(12500, plane1.getMaxTakeOffWeight());
    }

}
