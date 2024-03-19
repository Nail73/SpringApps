package org.example.controller;

import org.itsallcode.holidays.calculator.HolidayCalculator;
import org.itsallcode.holidays.calculator.HolidayCalculatorBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
public class VacationCalculatorController {

    private final HolidayCalculator holidayCalculator;

    public VacationCalculatorController() {
        this.holidayCalculator = new HolidayCalculatorBuilder()
                .withFixedHolidays()
                .build();
    }

    @GetMapping("/calculate")
    public BigDecimal calculateVacationPayment(
            @RequestParam("averageSalary") BigDecimal averageSalary,
            @RequestParam("vacationDays") int vacationDays,
            @RequestParam(value = "specificDates", required = false) List<LocalDate> specificDates) {

        BigDecimal vacationPayment = averageSalary.multiply(BigDecimal.valueOf(vacationDays));

        if (specificDates != null && !specificDates.isEmpty()) {
            for (LocalDate date : specificDates) {
                if (holidayCalculator.isHoliday(date)) {
                    vacationPayment = vacationPayment.subtract(averageSalary);
                }
            }
        }

        return vacationPayment;
    }
}