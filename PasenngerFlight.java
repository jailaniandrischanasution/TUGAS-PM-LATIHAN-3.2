public class PasenngerFlight{

    public static class Passenger {
        private String name;
        private Passenger next;

        public Passenger(String name) {
            this.name = name;
            this.next = null;
        }

        public String getName() {
            return name;
        }

        public void setNext(Passenger next) {
            this.next = next;
        }

        public Passenger getNext() {
            return next;
        }
    }

    public static class Flight {
        private Passenger head;

        public Flight() {
            this.head = null;
        }

        public void addPassenger(String name) {
            Passenger newPassenger = new Passenger(name);
            if (head == null) {
                head = newPassenger;
            } else {
                Passenger current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newPassenger);
            }
        }

        public void removePassenger(String name) {
            if (head == null) return;

            if (head.getName().equals(name)) {
                head = head.getNext();
                return;
            }

            Passenger current = head;
            while (current.getNext() != null) {
                if (current.getNext().getName().equals(name)) {
                    current.setNext(current.getNext().getNext());
                    return;
                }
                current = current.getNext();
            }
        }

        public void displayPassengers() {
            Passenger current = head;
            while (current != null) {
                System.out.println(current.getName());
                current = current.getNext();
            }
        }
    }

    public static void main(String[] args) {
        Flight flight = new Flight();
        String[] passengers = {"Chris", "Justin", "Travis", "Carter", "Jordan"};

        for (String name : passengers) {
            flight.addPassenger(name);
        }

        System.out.println("Daftar Penumpang:");
        flight.displayPassengers();

        flight.removePassenger("Travis");
        System.out.println("\nSetelah menghapus Travis:");
        flight.displayPassengers();
    }
}