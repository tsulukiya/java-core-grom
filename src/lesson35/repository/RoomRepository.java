package lesson35.repository;

import lesson35.enums.UserType;
import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoomRepository extends ShareRepository {


    public Set<Room> findRoom(Filter filter, String pathToRoomDb, String pathToHotelDb) {
        @SuppressWarnings("unchecked")
        List<Room> roomSet = convertContentFromPathToList(pathToRoomDb);
        Set<Room> searchRooms = new HashSet<>();

        for (Room room : roomSet) {
            if (room.getNumberOfGuests() == filter.getNumberOfGuests() &&
                    room.getPrice() == filter.getPrice() &&
                    room.isBreakfastIncluded() == filter.isBreakfastIncluded() &&
                    room.isPetsAllowed() == filter.isPetsAllowed() &&
                    dateFormat(room.getDateAvailableFrom()).contains(dateFormat(filter.getDateAvailableFrom())) &&
                    checkHotelFields(room, pathToHotelDb)) {
                searchRooms.add(room);
            }
        }
        return searchRooms;
    }

    private boolean checkHotelFields(Room room, String path) {
        @SuppressWarnings("unchecked")
        List<Hotel> hotelList = new HotelRepository().convertContentFromPathToList(path); //todo: CHECK ERROR!!!!!!!!!
        for (Hotel hotel : hotelList) {
            if (hotel.getId() == room.getHotel().getId()) {
                return true;
            }
        }
        return false;
    }

    public Room addRoom(Room room, String pathToDb) {
        writeObjectToDb(room.toString(), pathToDb);
        return room;
    }

    public Room deleteRoom(long roomId, String path) {
        @SuppressWarnings("unchecked")
        List<Room> roomList = convertContentFromPathToList(path);
        Room roomDelete = null;
        deleteContentFromDb(path);
        for (Room room : roomList) {
            if (room.getId() != roomId) {
                writeObjectToDb(room.toString(), path);
            } else {
                roomDelete = room;
            }
        }
        return roomDelete;
    }

    @Override
    Room initObject(String[] mas) {
        return new Room(Long.parseLong(mas[0]), Integer.parseInt(mas[1]), Double.parseDouble(mas[2]),
                Boolean.valueOf(mas[3]), Boolean.valueOf(mas[4]), convertStringToDate(mas[5]),
                new Hotel(Long.parseLong(mas[6])));
    }

}

