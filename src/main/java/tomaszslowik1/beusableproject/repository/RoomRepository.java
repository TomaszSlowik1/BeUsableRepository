package tomaszslowik1.beusableproject.repository;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public interface RoomRepository {
    List<Integer> getGuestsList();
}