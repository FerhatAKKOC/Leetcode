package InterviewCollection.company.Adyen;

import java.util.Date;
import java.util.GregorianCalendar;

public class LineParser {

    public static ReconciliationRecord parseLine(String inputLine) {
        final Date transactionDate = parseTransactionDate(inputLine.substring(0, 12));
        final String merchantId = inputLine.substring(12, 22);
        final String creditOrDebit = inputLine.substring(22, 23);
        final Long quantity = Long.parseLong(inputLine.substring(23, 41));
        final String currencyCode = inputLine.substring(41, 44);
        final String cardNumber = inputLine.substring(44, 64);
        final String expiry_month = inputLine.substring(64, 66);
        final String expiry_year = inputLine.substring(66, 70);
        System.out.println("Parsed reported transaction on '" + transactionDate + "' with cardNumber '" + cardNumber + "'.");
//        return new ReconciliationRecord.LineBuilder()
//                .setDate(transactionDate)
//                .setMerchantId(merchantId)
//                .setCreditOrDebit(creditOrDebit)
//                .setQuantity(quantity)
//                .setCurrencyCode(currencyCode)
//                .setCardNumber(cardNumber)
//                .setExpiryMonth(expiry_month)
//                .setExpiryYear(expiry_year)
//                .createLine();

        return null;
    }

    private static Date parseTransactionDate(String yymmddhhmmss) {

        int yyyy = Integer.parseInt(yymmddhhmmss.substring(0, 2)) + 2000;
        int mm = Integer.parseInt(yymmddhhmmss.substring(2, 4)) - 1;
        int dd = Integer.parseInt(yymmddhhmmss.substring(4, 6));
        int hh = Integer.parseInt(yymmddhhmmss.substring(6, 8));
        int mm2 = Integer.parseInt(yymmddhhmmss.substring(8, 10));
        int ss = Integer.parseInt(yymmddhhmmss.substring(10, 12));
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(yyyy, mm, dd, hh, mm2, ss);
        return gregorianCalendar.getTime();
    }

}
