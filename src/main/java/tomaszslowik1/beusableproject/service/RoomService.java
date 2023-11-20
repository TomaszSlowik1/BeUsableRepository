package tomaszslowik1.beusableproject.service;

import org.springframework.stereotype.Service;
import tomaszslowik1.beusableproject.dto.RoomOccupancyDto;

@Service
public interface RoomService {

    RoomOccupancyDto calculateRoomOccupancy(Integer freePremiumRooms, Integer freeEconomyRooms);
}
