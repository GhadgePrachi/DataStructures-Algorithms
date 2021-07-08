package algorithms.recursion.medium;

import java.util.ArrayList;

public class CheckIPAddress {
    public ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> ipAddresses = new ArrayList<>();
        getIPAddresses(string,0,3,new StringBuilder(),ipAddresses);
        return ipAddresses;
    }

    public static void getIPAddresses(String string,int index,int dotCount,StringBuilder currentIPAddress,ArrayList<String> ipAddresses){
        //Invalid states
        if(index >= string.length() || dotCount < 0) {
            return;
        }

        //Handle last i.e fourth sequence
        if (dotCount == 0) {
            String sequence = string.substring(index);
            if (checkValid(sequence)){
                currentIPAddress.append(sequence);
                ipAddresses.add(currentIPAddress.toString());
            }
        } else {
            //Handle first three sequences
            for (int endIndex = index + 1; endIndex < Math.min(string.length(),index+4); endIndex++){
                String sequence = string.substring(index,endIndex);
                if (checkValid(sequence)){
                    int len = currentIPAddress.length();
                    currentIPAddress.append(sequence);
                    currentIPAddress.append('.');
                    getIPAddresses(string, endIndex,dotCount-1,currentIPAddress,ipAddresses);
                    currentIPAddress.delete(len, currentIPAddress.length());
                }
            }
        }
    }

    public ArrayList<String> validIPAddressesOptimal(String string) {
        ArrayList<String> ipAddresses = new ArrayList<>();
        for (int i = 1; i < Math.min(string.length(), 4); i++){
            String[] currentIPAddress = new String[]{"", "", "", ""};

            //First sequence
            currentIPAddress[0] = string.substring(0,i);
            if (!checkValid(currentIPAddress[0]))
                continue;

            //Second Sequence
            for (int j = i+1; j < i + Math.min(string.length()-i,4); j++){
                currentIPAddress[1] = string.substring(i,j);
                if (!checkValid(currentIPAddress[1]))
                    continue;

                //Thirds and Fourth Sequence
                for (int k = j+1; k < j + Math.min(string.length()-j,4); k++){
                    currentIPAddress[2] = string.substring(j,k);
                    currentIPAddress[3] = string.substring(k);
                    if (checkValid(currentIPAddress[2]) && checkValid(currentIPAddress[3]))
                        ipAddresses.add(join(currentIPAddress));
                }
            }
        }
        return ipAddresses;
    }

    public static boolean checkValid(String sequence){
        int val = Integer.parseInt(sequence);
        if (val > 255) {
            return false;
        }
        return sequence.length() == Integer.toString(val).length();
    }

    public static String join(String[] strings){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++){
            sb.append(strings[i]);
            if (i < strings.length-1)
                sb.append(".");
        }
        return sb.toString();
    }
}
