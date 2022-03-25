package contacts.controller.verification;


import org.junit.Assert;
import org.junit.Test;

public class InputVerificationTest {

    @Test
    public void itShouldReturnTrueWhenPhoneNumberValid() {
        // Given
        String phoneNumber ="+0 (123) 456-789-ABcd";
        // When
        // Then
        Assert.assertTrue(InputVerification.isPhoneNumberValid(phoneNumber));

    }

    @Test
    public void itShouldReturnTrueWhenPhoneNumberHasNotPlus() {
        // Given
        String phoneNumber ="0 (123) 456-789-ABcd";
        // When
        // Then
        Assert.assertTrue(InputVerification.isPhoneNumberValid(phoneNumber));

    }

    @Test
    public void itShouldReturnTrueWhenPhoneNumberHasNoParenthesis() {
        // Given
        String phoneNumber ="0 123 456-789-ABcd";
        // When
        // Then
        Assert.assertTrue(InputVerification.isPhoneNumberValid(phoneNumber));

    }

    @Test
    public void itShouldReturnTrueWhenPhoneNumberHasNoFirstGroup() {
        // Given
        String phoneNumber ="(123) 456-789-ABcd";
        // When
        // Then
        Assert.assertTrue(InputVerification.isPhoneNumberValid(phoneNumber));

    }

    @Test
    public void itShouldReturnFalseWhenPhoneNumberHasNoSpace() {
        // Given
        String phoneNumber ="+0(123)456-789-9999";
        // When
        // Then
        Assert.assertFalse(InputVerification.isPhoneNumberValid(phoneNumber));

    }

    @Test
    public void itShouldReturnFalseWhenPhoneNumberHasNoLastGroup() {
        // Given
        String phoneNumber ="+0(123)";
        // When
        // Then
        Assert.assertFalse(InputVerification.isPhoneNumberValid(phoneNumber));

    }

    @Test
    public void itShouldReturnFalseWhenPhoneNumberHasTwoPareOfParenthesis() {
        // Given
        String phoneNumber ="+0 (123) (456-789-9999)";
        // When
        // Then
        Assert.assertFalse(InputVerification.isPhoneNumberValid(phoneNumber));

    }
}