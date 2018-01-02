package moneycalculator;

import moneycalculator.control.CalculateCommand;
import moneycalculator.persistence.CurrencyListLoader;
import moneycalculator.persistence.ExchangeRateLoader;
import moneycalculator.persistence.RestExchangeRateLoader;
import moneycalculator.persistence.files.FilesCurrencyListLoader;

public class Main {

    public static void main(String[] args) {
        CurrencyListLoader currencyLoader = new FilesCurrencyListLoader("currencies");
        ExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
        MainFrame mainFrame = new MainFrame(currencyLoader.currencies());
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), exchangeRateLoader));
    } 
}
