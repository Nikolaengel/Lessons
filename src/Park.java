public class Park {
    private String parkName;
    private Attraction[] attractions;

    public Park(String parkName, int numberOfAttractions) {
        this.parkName = parkName;
        this.attractions = new Attraction[numberOfAttractions];
    }

    public void addAttraction(int index, String name, String workingHours, double price) {
        if (index >= 0 && index < attractions.length) {
            attractions[index] = new Attraction(name, workingHours, price);
        } else {
            System.out.println("Invalid index");
        }
    }

    public void printAttractions() {
        System.out.println("Park Name: " + parkName);
        for (Attraction attraction : attractions) {
            if (attraction != null) {
                attraction.printInfo();
                System.out.println();
            }
        }
    }

    private class Attraction {
        private String name;
        private String workingHours;
        private double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Attraction Name: " + name);
            System.out.println("Working Hours: " + workingHours);
            System.out.println("Price: " + price);
        }
    }

    public static void main(String[] args) {
        Park park = new Park("Funland", 3);
        park.addAttraction(0, "Ferris Wheel", "10:00 - 20:00", 5.0);
        park.addAttraction(1, "Roller Coaster", "11:00 - 22:00", 7.5);
        park.addAttraction(2, "Haunted House", "12:00 - 23:00", 6.0);

        park.printAttractions();
    }
}

