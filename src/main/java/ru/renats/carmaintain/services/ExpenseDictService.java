package ru.renats.carmaintain.services;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.renats.carmaintain.entities.ExpenseDict;

/**
 * todo write javadoc!
 *
 * @author SadykovRI
 * @since 16.10.2021
 */

public interface ExpenseDictService extends JpaRepository<ExpenseDict, Long> {


}
