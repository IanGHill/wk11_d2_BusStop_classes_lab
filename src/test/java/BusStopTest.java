import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {
  private BusStop busStop;
  private Person person;

  @Before
  public void before(){
    busStop = new BusStop("Princes Street");
    person = new Person();
  }

  @Test
  public void countPeopleInQueue(){
    assertEquals(0, busStop.getQueueCount());
  }

  @Test
  public void canAddPerson(){
    busStop.addPerson(person);
    assertEquals(1, busStop.getQueueCount());
  }

  @Test
  public void canRemovePerson(){
    busStop.addPerson(person);
    busStop.addPerson(person);
    busStop.removePerson();
    assertEquals(1, busStop.getQueueCount());
  }

}
