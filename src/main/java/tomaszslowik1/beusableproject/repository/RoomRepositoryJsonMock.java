package tomaszslowik1.beusableproject.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Repository
public class RoomRepositoryJsonMock implements RoomRepository{
    @Override
    public List<BigDecimal> getGuestsList()  {
        File file = new File(
                Objects.requireNonNull(this.getClass().getClassLoader().getResource("static/guests.json")).getFile()
        );
        ObjectMapper mapper = new ObjectMapper();
        BigDecimal[] guestsArray;
        try {
            guestsArray = mapper.readValue(file, BigDecimal[].class);
        } catch (IOException e) {
            return Collections.emptyList();
        }
        return new ArrayList<>(Arrays.asList(guestsArray));
    }
}
