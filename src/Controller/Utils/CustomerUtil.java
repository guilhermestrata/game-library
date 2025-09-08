package Controller.Utils;

public class CustomerUtil {
    public static boolean isValidDocument(String documentNumber){
        if (documentNumber == null) return false;

        documentNumber = documentNumber.replaceAll("\\D", "");

        if (documentNumber.length() != 11) return false;

        if (documentNumber.matches("(\\d)\\1{10}")) return false;

        try {
            int sum1 = 0, sum2 = 0;

            for (int i = 0; i < 9; i++) {
                int digit = Character.getNumericValue(documentNumber.charAt(i));
                sum1 += digit * (10 - i);
                sum2 += digit * (11 - i);
            }

            int check1 = 11 - (sum1 % 11);
            if (check1 >= 10) check1 = 0;

            sum2 += check1 * 2;

            int check2 = 11 - (sum2 % 11);
            if (check2 >= 10) check2 = 0;

            return check1 == Character.getNumericValue(documentNumber.charAt(9)) &&
                    check2 == Character.getNumericValue(documentNumber.charAt(10));
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static boolean isValidEmail(String email){
        if (email == null) return false;

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        return email.matches(emailRegex);
    }
}
