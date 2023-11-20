package tomaszslowik1.beusableproject.service;

import tomaszslowik1.beusableproject.dto.RoomOccupancyDto;


public interface RoomService {

    RoomOccupancyDto calculateRoomOccupancy(Integer freePremiumRooms, Integer freeEconomyRooms);
}
