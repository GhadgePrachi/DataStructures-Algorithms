package datastructures.strings.medium;

public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(IP);
        } else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(IP);
        } else {
            return "Neither";
        }
    }

    public String validateIPv4(String str) {
        String[] sequences = str.split("\\.", -1);
        for (String sequence : sequences) {
            if (sequence.length() == 0 || sequence.length() > 3) {
                return "Neither";
            }
            if (sequence.charAt(0) == '0' && sequence.length() != 1) {
                return "Neither";
            }
            for (char ch : sequence.toCharArray()) {
                if (!Character.isDigit(ch)) return "Neither";
            }
            if (Integer.parseInt(sequence) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String validateIPv6(String str) {
        String[] sequences = str.split(":", -1);
        String hexadecimalDigits = "0123456789abcdefABCDEF";
        for (String sequence : sequences) {
            if (sequence.length() == 0 || sequence.length() > 4) {
                return "Neither";
            }
            for (Character ch : sequence.toCharArray()) {
                if (hexadecimalDigits.indexOf(ch) == -1) return "Neither";
            }
        }
        return "IPv6";
    }
}
