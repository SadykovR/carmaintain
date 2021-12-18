package ru.renats.carmaintain.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * todo write javadoc!
 *
 * @author SadykovRI
 * @since 16.10.2021
 */
@Entity
@Table(name = "expense")
@ToString
public class Expense {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Getter
    @Setter
    private Long id;


    @ManyToOne
    @JoinColumn(name = "car_id")
    @Setter
    @Getter
    private Car car;
    @OneToOne(/*cascade = CascadeType.ALL*/)
    @JoinColumn(name = "expense_dict_id", referencedColumnName = "id")
    private ExpenseDict expenseDict;

    @Getter
    @Setter
    private String comment;


    public ExpenseDict getExpenseDict() {
        return expenseDict;
    }

    public void setExpenseDict(ExpenseDict expenseDict) {
        this.expenseDict = expenseDict;
    }

    public boolean isNew() {
        return (this.id == null);
    }

}
