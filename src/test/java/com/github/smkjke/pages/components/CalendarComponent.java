package com.github.smkjke.pages.components;

import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {

    public CalendarComponent setDate(int day, String month, String year) {
        $x(".//select[contains(@class,'react-datepicker__month-select')]").selectOptionByValue(month);
        $x(".//select[contains(@class,'react-datepicker__year-select')]").selectOptionByValue(year);
        $x(String.format(".//div[contains(@class,'react-datepicker__day react-datepicker__day--0%d')]", day)).click();
        return this;
    }

}
