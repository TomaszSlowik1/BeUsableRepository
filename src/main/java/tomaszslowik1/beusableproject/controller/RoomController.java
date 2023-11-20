package tomaszslowik1.beusableproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tomaszslowik1.beusableproject.dto.RoomOccupancyDto;
import tomaszslowik1.beusableproject.service.RoomService;

@RestController
@RequestMapping(value = "/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping(value = "occupancy/{freePremiumRooms}/{freeEconomyRooms}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoomOccupancyDto> getRoomOccupancy(@PathVariable Integer freePremiumRooms, @PathVariable Integer freeEconomyRooms) {
        return ResponseEntity.ok(roomService.calculateRoomOccupancy(freePremiumRooms,freeEconomyRooms));
    }

}
