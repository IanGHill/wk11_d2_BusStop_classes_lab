import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BusTest {

  private Bus bus;
  private Person person;
  private ArrayList<Person> queue;
  private BusStop busStop;

  @Before
  public void before(){
    bus = new Bus("Leith", 3);
    person = new Person();
    busStop = new BusStop("Princes Street");
  }

  @Test
  public void numPassengers(){
    assertEquals(0, bus.getNumPassengers());
  }

  @Test
  public void canAddPassenger(){
    bus.addPassenger(person);
    assertEquals(1, bus.getNumPassengers());
  }

  @Test
  public void cantAddPassenger(){
    bus.addPassenger(person);
    bus.addPassenger(person);
    bus.addPassenger(person);
    bus.addPassenger(person);
    assertEquals(3, bus.getNumPassengers());
  }

  @Test
  public void canRemovePassenger(){
    bus.addPassenger(person);
    bus.removePassenger(person);
    assertEquals(0, bus.getNumPassengers());
  }

  @Test
  public void canPickUpPassengers(){
    busStop.addPerson(person);
    busStop.addPerson(person);
    bus.pickUp(busStop, person);
    assertEquals(1, bus.getNumPassengers());
    assertEquals(1, busStop.getQueueCount());
  }
}
