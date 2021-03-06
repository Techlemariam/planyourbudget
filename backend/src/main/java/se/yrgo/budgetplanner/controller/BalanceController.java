package se.yrgo.budgetplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.yrgo.budgetplanner.model.balance.Balance;
import se.yrgo.budgetplanner.model.balance.BalanceCategory;
import se.yrgo.budgetplanner.service.BalanceService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    @Autowired
    BalanceService balanceService;


    @GetMapping("/getall")
    List<Balance> getAllBalances() {
        return balanceService.getAll();
    }


    @GetMapping("/getbycategory/{balanceCategory}")
    List<Balance> getBalanceByCategory(@PathVariable BalanceCategory balanceCategory) {
        return balanceService.getAllByCategory(balanceCategory);
    }

    @GetMapping("/getlatestsavings")
    List<BigDecimal> getBalanceByCategory() {
        List<Balance> allSavingsObjects =  balanceService.getAllByCategory(BalanceCategory.SAVINGS);
        List<BigDecimal> allSavingsAmounts = new ArrayList<>();

        for (Balance b : allSavingsObjects) {
            allSavingsAmounts.add(b.getAmount());
        }

        return allSavingsAmounts;

    }

    @GetMapping("/getcurrent/{balanceCategory}")
        BigDecimal getCurrentBalance(@PathVariable BalanceCategory balanceCategory) {
                return balanceService.getCurrentBalance(balanceCategory);
    }




}
