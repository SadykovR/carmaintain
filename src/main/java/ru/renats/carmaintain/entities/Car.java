package ru.renats.carmaintain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * car entity that represents
 *
 * @author SadykovRI
 * @since 13.10.2021
 */
@Entity
@Table(name = "car")
public class Car implements Serializable {

    private Long id;
    private String name;

    //    @OneToMany(mappedBy = "car", targetEntity=Expense.class, cascade= CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
//    @Column
//    @ElementCollection(targetClass=Expense.class)
    private List<Expense> expenses;

    public Car() {
    }

    /**
     * @return car's id.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "car_id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    /**
     * @return car name.
     */
    @Column(name = "name")
    public String getName() {
        return name;
    }

    /**
     * @param id_
     */
    public void setId(Long id_) {
        id = id_;
    }

    /**
     * @param name_ car name
     */
    public void setName(final String name_) {
        name = name_;
    }

    @OneToMany(mappedBy = "car", targetEntity = Expense.class, /*cascade= CascadeType.ALL,*/ fetch = FetchType.EAGER)
    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
