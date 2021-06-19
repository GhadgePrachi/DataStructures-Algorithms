package algorithms.recursion.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class PhoneNumberMnemonicsTest {
    @Test
    public void testPhoneNumberMnemonicsSuccess() {
        String phoneNumber = "1905";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1w0j", "1w0k", "1w0l", "1x0j", "1x0k", "1x0l", "1y0j", "1y0k", "1y0l", "1z0j", "1z0k", "1z0l"));
        Assert.assertEquals(expected, new PhoneNumberMnemonics().phoneNumberMnemonics(phoneNumber));
    }
}
