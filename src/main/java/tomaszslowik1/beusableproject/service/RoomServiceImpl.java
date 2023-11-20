package tomaszslowik1.beusableproject.service;

import tomaszslowik1.beusableproject.dto.RoomOccupancyDto;
import tomaszslowik1.beusableproject.repository.RoomRepository;

public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomOccupancyDto calculateRoomOccupancy(Integer freePremiumRooms, Integer freeEconomyRooms)  {
        throw new UnsupportedOperationException();
    }
}
