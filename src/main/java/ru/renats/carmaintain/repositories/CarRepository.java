package ru.renats.carmaintain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.renats.carmaintain.entities.Car;

/**
 * todo write javadoc!
 *
 * @author SadykovRI
 * @since 13.10.2021
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}

