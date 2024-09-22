package hello.repository;

import hello.entity.ItemOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOwnerRepository extends JpaRepository<ItemOwner, Long> {
}
