package ru.renats.carmaintain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * todo write javadoc!
 *
 * @author SadykovRI
 * @since 16.10.2021
 */
@Entity
@Table(name = "expense_dict")
public class ExpenseDict {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Getter
    @Setter
    Long id;

    @Setter
    @Getter
    String name;
//
//    @ManyToOne
//    @JoinColumn(name = "expense_id")
//    @Setter
//    @Getter
//    private Expense expense;

}
