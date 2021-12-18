package ru.renats.carmaintain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.renats.carmaintain.FormValidator;
import ru.renats.carmaintain.entities.Car;
import ru.renats.carmaintain.entities.Expense;
import ru.renats.carmaintain.entities.ExpenseDict;
import ru.renats.carmaintain.services.CarService;
import ru.renats.carmaintain.services.ExpenseDictService;
import ru.renats.carmaintain.services.ExpenseService;

import java.util.List;
import java.util.Map;

/**
 * todo write javadoc!
 *
 * @author SadykovRI
 * @since 16.10.2021
 */
@RestController
@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private CarService carService;

    @Autowired
    private ExpenseDictService expenseDictService;

    @Autowired
    FormValidator expenseFormValidator;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public ExpenseController() {
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(expenseFormValidator);
    }

    /**
     * Get all car expenses data
     */
    @RequestMapping("/allexpenses")
    public ModelAndView getAllExpenses(Map<String, Object> model) {
        List<Expense> expenses = expenseService.findAllSorted();
        model.put("expenses", expenses);
        return new ModelAndView("expensesview", model);
    }

    //todo разобраться с пагинацией
    @RequestMapping("/allexpensesp")
    public Page<Expense> getAllExpensesPageable(Pageable pageable) {
        return expenseService.findAllPaging(pageable);
    }

    @RequestMapping(value = "/getexpense", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView show(@RequestParam int id, Map<String, Object> model) {
        Expense exp = expenseService.findById((long) id).orElseThrow();
        model.put("exp", exp);
        return new ModelAndView("expenseview", model);
    }

    @RequestMapping(value = "/getexpense/edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam int id, Map<String, Object> model) {
        Expense exp = expenseService.findById((long) id).orElseThrow();
        List<Car> carList = (List<Car>) carService.findAll();
        List<ExpenseDict> expensesDict = expenseDictService.findAll();
        model.put("exp", exp);
        model.put("carList", carList);
        model.put("expensesDictList", expensesDict);
        return new ModelAndView("expenseedit", model);
    }

    @RequestMapping(value = "/allexpenses", method = RequestMethod.POST)
    public ModelAndView saveOrUpdateExpense(@ModelAttribute("exp") @Validated Expense exp,
                                            BindingResult result, Model model,
                                            final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/error");
            return modelAndView;
        } else {

            // Add message to flash scope
            redirectAttributes.addFlashAttribute("css", "success");
            if (exp.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "Expense added successfully!");
            } else {
                redirectAttributes.addFlashAttribute("msg", "Expense updated successfully!");
            }

            expenseService.save(exp);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/allexpenses");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/getexpense/delete", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView deleteUser(@RequestParam int id, final RedirectAttributes redirectAttributes) {
        expenseService.deleteById((long) id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "expense is deleted!");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/allexpenses");
        return modelAndView;

    }

    @RequestMapping(value = "/allexpenses/add", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView add(Map<String, Object> model) {
        Expense exp = new Expense();
        List<Car> carList = (List<Car>) carService.findAll();
        List<ExpenseDict> expensesDict = expenseDictService.findAll();
        model.put("exp", exp);
        model.put("carList", carList);
        model.put("expensesDictList", expensesDict);
        return new ModelAndView("expenseedit", model);
    }

}
