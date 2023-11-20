package tomaszslowik1.beusableproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tomaszslowik1.beusableproject.dto.RoomOccupancyDto;
import tomaszslowik1.beusableproject.repository.RoomRepository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public RoomOccupancyDto calculateRoomOccupancy(Integer freePremiumRooms, Integer freeEconomyRooms)  {
        List<BigDecimal> guestsList = roomRepository.getGuestsList();

        BigDecimal premiumGain;
        Integer premiumUsage;
        BigDecimal economyGain;
        Integer economyUsage;

        Map<Boolean, List<BigDecimal>> partitionedGuestsList = divideIntoPremiumAndEconomy(guestsList);

        premiumGain = partitionedGuestsList.get(true).stream().limit(freePremiumRooms).reduce(BigDecimal.ZERO, BigDecimal::add);
        premiumUsage = freePremiumRooms >= partitionedGuestsList.get(true).size()
                ? partitionedGuestsList.get(true).size()
                : freePremiumRooms;
        freePremiumRooms = freePremiumRooms - premiumUsage;

        if(partitionedGuestsList.get(false).size() <= freeEconomyRooms){
            economyGain = partitionedGuestsList.get(false).stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            economyUsage = partitionedGuestsList.get(false).size();
        } else {
            Integer promotedToPremiumAmount = Math.min(partitionedGuestsList.get(false).size() - freeEconomyRooms, freePremiumRooms);

            premiumGain = premiumGain.add(partitionedGuestsList.get(false).stream().limit(promotedToPremiumAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
            premiumUsage = premiumUsage + promotedToPremiumAmount;

            economyGain = partitionedGuestsList.get(false).stream().skip(promotedToPremiumAmount).limit(freeEconomyRooms).reduce(BigDecimal.ZERO, BigDecimal::add);
            economyUsage = freeEconomyRooms;
        }

        return RoomOccupancyDto.builder()
                .premiumUsage(premiumUsage)
                .economyUsage(economyUsage)
                .premiumGain(premiumGain)
                .economyGain(economyGain)
                .build();
    }

    private Map<Boolean, List<BigDecimal>> divideIntoPremiumAndEconomy(List<BigDecimal> guestsList){
        Map<Boolean, List<BigDecimal>> partitionedGuestsList = guestsList.stream()
                .collect(Collectors.partitioningBy(guestPrice -> guestPrice.compareTo(BigDecimal.valueOf(100)) >= 0));

        partitionedGuestsList.values().forEach(list -> {
            Collections.sort(list);
            Collections.reverse(list);
        });
        return partitionedGuestsList;
    }
}
