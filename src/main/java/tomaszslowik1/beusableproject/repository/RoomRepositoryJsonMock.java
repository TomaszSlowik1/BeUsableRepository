package tomaszslowik1.beusableproject.repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class RoomRepositoryJsonMock implements RoomRepository{
    @Override
    public List<Integer> getGuestsList()  {
        File file = new File(
                Objects.requireNonNull(this.getClass().getClassLoader().getResource("static/guests.json")).getFile()
        );
        ObjectMapper mapper = new ObjectMapper();
        Integer[] guestsArray;
        try {
            guestsArray = mapper.readValue(file, Integer[].class);
        } catch (IOException e) {
            return Collections.emptyList();
        }
        return new ArrayList<>(Arrays.asList(guestsArray));
    }
}
