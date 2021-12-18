package ru.renats.carmaintain;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.renats.carmaintain.entities.Expense;

/**
 * todo write javadoc!
 *
 * @author SadykovRI
 * @since 17.10.2021
 */
@Component
public class FormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Expense.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Expense exp = (Expense) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comment", "NotEmpty.expenseForm.name");
    }

}