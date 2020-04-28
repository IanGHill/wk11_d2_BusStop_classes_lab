import java.util.ArrayList;

public class Bus {
  private String destination;
  private int capacity;
  private ArrayList<Person> passengers;

  public Bus(String destination, int capacity) {
    this.destination = destination;
    this.capacity = capacity;
    this.passengers = new ArrayList<Person>();
  }

  public int getNumPassengers() {
    return this.passengers.size();
  }

  public void addPassenger(Person person) {
    if (getNumPassengers() < this.capacity) {
      this.passengers.add(person);
    }
  }

  public void removePassenger(Person person) {
    this.passengers.remove(0);
  }

  public void pickUp(BusStop busStop, Person person) {
    if (busStop.getQueueCount() > 0){
      for (int i =0; i < busStop.getQueueCount(); i++) {
        if (getNumPassengers() < this.capacity) {
          this.passengers.add(person);
          busStop.removePerson();
        }
      }
    }
  }
}
