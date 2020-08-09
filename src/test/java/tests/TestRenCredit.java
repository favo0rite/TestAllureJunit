package tests;

import basetestsclass.BaseTestClass;
import org.junit.Test;

public class TestRenCredit extends BaseTestClass {

    @Test
    public void testRublesCurrency() {
        app.getStartPage().gotToMenu("Вклады")
                .clickCurrencyButton("Рубли")
                .fillSumContributionInput("300000")
                .fillMonthlyPaymentInput("50000")
                .selectTimeOfDeposit("6 месяцев")
                .clickCheckBoxMonthlyCapitalization()
                .assertField("Начислено %", "7 422,56" )
                .assertField("Пополнение", "250 000" )
                .assertField("К снятию", "557 422,56");


    }

    @Test
    public void testDollarsCurrency() {
        app.getStartPage().gotToMenu("Вклады")
                .clickCurrencyButton("Доллары США")
                .fillSumContributionInput("500000")
                .fillMonthlyPaymentInput("30000")
                .selectTimeOfDeposit("9 месяцев")
                .clickCheckBoxMonthlyCapitalization()
                .assertField("Начислено %", "1 382,24" )
                .assertField("Пополнение", "240 000" )
                .assertField("К снятию", "741 382,24");
    }
}
