package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.entity.ItemOwner;
import hello.repository.ItemOwnerRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@RequiredArgsConstructor
@Component
@Slf4j
public class Command implements CommandLineRunner {
    private final ItemOwnerRepository repository;
    private final ObjectMapper objectMapper;
    private final EntityManager entityManager;

    @SneakyThrows
    @Override
    @Transactional
    public void run(String... args) {
        log.debug("run");
        repository.saveAndFlush(ItemOwner.builder()
                .id(1L)
                .j(objectMapper.valueToTree(
                        Map.of("foo", "bar")))
                .build());
        entityManager.clear();
        ItemOwner obj = repository.getReferenceById(1L);
        log.info("value {}", objectMapper.writeValueAsString(obj.getJ()));
    }
}
