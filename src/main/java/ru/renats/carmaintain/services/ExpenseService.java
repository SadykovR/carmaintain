package ru.renats.carmaintain.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.renats.carmaintain.entities.Expense;

import java.util.List;

/**
 * todo write javadoc!
 *
 * @author SadykovRI
 * @since 16.10.2021
 */
public interface ExpenseService extends PagingAndSortingRepository<Expense, Long> {

    public default List<Expense> findAllSorted() {
        return (List<Expense>) findAll(Sort.by("id"));
    }

    public default Page<Expense> findAllPaging(Pageable pageable) {
        return findAll(pageable);
    }

}