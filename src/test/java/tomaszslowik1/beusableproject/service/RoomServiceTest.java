package tomaszslowik1.beusableproject.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tomaszslowik1.beusableproject.dto.RoomOccupancyDto;
import tomaszslowik1.beusableproject.repository.RoomRepository;
import tomaszslowik1.beusableproject.repository.RoomRepositoryJsonMock;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class RoomServiceTest {

    private RoomService roomService;

    @BeforeEach
    void setUp() {
        RoomRepository roomRepository = new RoomRepositoryJsonMock();
        roomService = new RoomServiceImpl(roomRepository);
    }

    @Test
    void calculateRoomOccupancy1(){
        RoomOccupancyDto result = roomService.calculateRoomOccupancy(3,3);
        assertEquals(3, result.getPremiumUsage());
        assertEquals(3, result.getEconomyUsage());
        assertEquals(BigDecimal.valueOf(738), result.getPremiumGain());
        assertEquals(BigDecimal.valueOf(167.99), result.getEconomyGain());
    }
    @Test
    void calculateRoomOccupancy2(){
        RoomOccupancyDto result = roomService.calculateRoomOccupancy(7,5);
        assertEquals(6, result.getPremiumUsage());
        assertEquals(4, result.getEconomyUsage());
        assertEquals(BigDecimal.valueOf(1054), result.getPremiumGain());
        assertEquals(BigDecimal.valueOf(189.99), result.getEconomyGain());
    }

    @Test
    void calculateRoomOccupancy3(){
        RoomOccupancyDto result = roomService.calculateRoomOccupancy(2,7);
        assertEquals(2, result.getPremiumUsage());
        assertEquals(4, result.getEconomyUsage());
        assertEquals(BigDecimal.valueOf(583), result.getPremiumGain());
        assertEquals(BigDecimal.valueOf(189.99), result.getEconomyGain());
    }

    @Test
    void calculateRoomOccupancy4(){
        RoomOccupancyDto result = roomService.calculateRoomOccupancy(7,1);
        assertEquals(7, result.getPremiumUsage());
        assertEquals(1, result.getEconomyUsage());
        assertEquals(BigDecimal.valueOf(1153), result.getPremiumGain());
        assertEquals(BigDecimal.valueOf(45.99), result.getEconomyGain());
    }

}
