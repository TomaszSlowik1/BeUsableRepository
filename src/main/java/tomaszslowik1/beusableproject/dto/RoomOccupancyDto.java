package tomaszslowik1.beusableproject.dto;

import lombok.*;

import java.math.BigDecimal;

@Value
@Builder
public class RoomOccupancyDto {

    Integer premiumUsage;

    Integer economyUsage;

    BigDecimal premiumGain;

    BigDecimal economyGain;

}
