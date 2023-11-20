package tomaszslowik1.beusableproject.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomOccupancyDto {

    private Integer premiumUsage;

    private Integer economyUsage;

    private BigDecimal premiumGain;

    private BigDecimal economyGain;
}
