package lesson15.hw2;

public class GoogleAPI implements API {

    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room roomSearch = new Room(price, persons, city, hotel);
        int index = 0;
        for (Room room : rooms) {
            if (room != null &
                    room.getPrice() == price &&
                    room.getPersons() == persons &&
                    room.getCityName() == city &&
                    room.getHotelName() == hotel)
                index++;
        }

        Room[] rooms2 = new Room[index];
        index = 0;
        for (Room room : rooms)
            if (room != null &&
                    room.getPrice() == price &&
                    room.getPersons() == persons &&
                    room.getCityName() == city &&
                    room.getHotelName() == hotel) {
                rooms2[index] = room;
                index++;
            }
        return rooms2;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
