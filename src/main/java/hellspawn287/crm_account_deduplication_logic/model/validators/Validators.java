package hellspawn287.crm_account_deduplication_logic.model.validators;

/**
 * Bazuje na wiki: https://pl.wikibooks.org/wiki/Kody_%C5%BAr%C3%B3d%C5%82owe/Implementacja_NIP
 */
public class Validators {
    public static boolean isNIPValid(String nip) {
        if (nip.length() == 13) {
            nip = nip.replaceAll("-", "");
        }
        if (nip.length() != 10) {
            return false;
        }
        int[] weights = {6, 5, 7, 2, 3, 4, 5, 6, 7};
        try {
            int sum = 0;
            for (int i = 0; i < weights.length; ++i) {
                sum += Integer.parseInt(nip.substring(i, i + 1)) * weights[i];
            }
            return (sum % 11) == Integer.parseInt(nip.substring(9, 10));
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
