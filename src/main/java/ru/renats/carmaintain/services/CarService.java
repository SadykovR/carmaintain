package ru.renats.carmaintain.services;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import ru.renats.carmaintain.entities.Car;

/**
 * todo write javadoc!
 *
 * @author SadykovRI
 * @since 13.10.2021
 */
@Service
public interface CarService extends PagingAndSortingRepository<Car, Long> {

}
