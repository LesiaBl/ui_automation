package projects;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scrips.Base;
import utils.Waiter;

import java.util.List;


public class Project1_ContactUsPage extends Base {

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/project-1");

    }
    /**
     * Test Case 01 - Validate the Contact Us information
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the heading is “Contact Us”
     * Validate the address is “2860 S River Rd Suite 350, Des Plaines IL 60018”
     * Validate the email is “info@techglobalschool.com"
     * Validate the phone number is “(773) 257-3010”
     */
    /**
     * @Test public void validateTheContactInformation(){
     * WebElement heading = driver.findElement(By.cssSelector("h1[class='is-size-2']"));
     * WebElement address = driver.findElement(By.cssSelector("div[class^='mb-5'] p[id='address']"));
     * /**
     * IF WE USE CSS PARENT TO CHILD WE PUT ONE OF ALL TAGS IF XPATH ONE OF THE SIBLING TAG
     * using cssSelector we can move to other siblings tag in parent by using   tagName:nth-child(tagNameNumber)
     * XPATH //div[starts-with(@class, 'mb-5')]/p[1]
     * div[class^='mb-5'] p:nth-child(2)
     * <p>
     * WebElement email = driver.findElement(By.cssSelector("div[class^='mb-5'] p:nth-child(3)"));//Xpath //div[@class='mb-5']//p[2]
     * WebElement phoneNumber = driver.findElement(By.cssSelector("div[class='mb-5'] p:nth-child(4)"));//Xpath//div[@class='mb-5']//p[3]
     * <p>
     * Assert.assertEquals(heading.getText(),"Contact Us");
     * Assert.assertEquals(address.getText(),"2860 S River Rd Suite 350, Des Plaines IL 60018");
     * Assert.assertEquals(email.getText(),"info@techglobalschool.com");
     * Assert.assertEquals(phoneNumber.getText(),"(773) 257-3010");
     * <p>
     * }
     */


    @Test(priority = 1)//faster
    public void validateTheContactInformationList() {
        WebElement heading = driver.findElement(By.cssSelector("div[class='mb-5'] h1:nth-child(1)"));
        Assert.assertEquals(heading.getText(), "Contact Us");

        List<WebElement> info = driver.findElements(By.xpath("//div[@class='mb-5']//p"));
        String[] expectedText = {"2860 S River Rd Suite 350, Des Plaines IL 60018", "info@techglobalschool.com", "(773) 257-3010"};

        for (int i = 0; i < info.size(); i++) {
            Assert.assertEquals(info.get(i).getText(), expectedText[i]);
        }
    }

    /**
     * Test Case 02 - Validate the Full name input box
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Full name input box is displayed
     * Validate that the Full name input box is required
     * Validate that the label of the Full name input box is “Full name”
     * Validate that the placeholder of the Full name input box is “Enter your name”
     * <p>
     * div[class='field']  label:nth-child(1)
     */
    //Okan reported about already
    //I went with actual
    //input box actual"Full name" -->required=true  required"Full name"
    @Test(priority = 2)
    public void validateFullNameInputBox() {
        WebElement fullNameBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(1) input"));
        WebElement label = driver.findElement(By.cssSelector("label[for='name']"));

        Assert.assertTrue(fullNameBox.isDisplayed());
        Assert.assertTrue(fullNameBox.isDisplayed(), "Enter your full name");
        Assert.assertTrue(true, fullNameBox.getAttribute("required"));//assert required fill out ---> true or false, detAttribute

        Assert.assertEquals(label.getText(), "Full name *");
    }

    /**
     * div[class='field']>label 1of5
     * //div[@class='field']/./label
     * div[class='field'] label:nth-child(1)1of7
     * //div[@class='field']//label[1]
     * Test Case 03 - Validate the Gender radio button
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the label is “Gender”
     * Validate that the Gender is required
     * Validate the options are “Female”, “Male” and “Prefer not to disclose”
     * Validate the options are clickable and not selected
     * Click on the “Male” option and validate it is selected while the others are not selected
     * Click on the “Female” option and validate it is selected while the others are not selected
     */
    //label
    //expected         actual
    //"Gender"         "Gender *"
    //                  ^^^ - required = true
    @Test(priority = 3)
    public void validateTheGenderRadioButton() {
        WebElement fullNameBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(2) label[class='label']"));


        //* Validate the label is “Gender”     displayed & getText   _required
        Assert.assertTrue(fullNameBox.isDisplayed());
        Assert.assertEquals(fullNameBox.getText(), "Gender *");
        List<WebElement> genderSelection = driver.findElements(By.cssSelector("label[class*='radio']"));

        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));

        String[] expectedText = {"Male", "Female", "Prefer not to disclose"};
        Assert.assertEquals(radioButtons.get(0).getAttribute("required"), "true");

        for (int i = 0; i < expectedText.length; i++) {
            Assert.assertTrue(radioButtons.get(i).isDisplayed());
            Assert.assertEquals(genderSelection.get(i).getText(), expectedText[i]);
            Assert.assertTrue(radioButtons.get(i).isEnabled());
            Assert.assertFalse(radioButtons.get(i).isSelected());
        }
        genderSelection.get(1).click();
        Assert.assertTrue(radioButtons.get(1).isSelected());

        for (int i = 0; i < radioButtons.size(); i++) {
            if (i == 1) continue;
            Assert.assertFalse(radioButtons.get(i).isSelected());
        }

        genderSelection.get(0).click();
        Assert.assertTrue(radioButtons.get(0).isSelected());
        for (int i = 1; i < radioButtons.size(); i++) {
            Assert.assertFalse(radioButtons.get(i).isSelected());
        }
    }

    /**Test Case 04 - Validate the Address input box
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Address input box is displayed
     * Validate that the Address input box is not required
     * Validate that the label of the Address input box is “Address”
     * Validate that the placeholder of the Address input box is “Enter your address*”
     */
    //placeholder
    //expected                         actual
    //"Enter your address*"            "Enter your address"
    //                                   ^^^ none of the inputs required "*"
    @Test(priority = 4)
    public void validateTheAddressInputBox() {
        WebElement addressBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(3)  label"));
        WebElement inputAddressBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(3) [class='input']"));

        //Label used for click only
        //input for display text  enable

        Assert.assertTrue(inputAddressBox.isDisplayed());
        Assert.assertNull( addressBox.getAttribute("required"));
        Assert.assertEquals(addressBox.getText(), "Address");
        Assert.assertEquals(inputAddressBox.getAttribute("placeholder"), "Enter your address");




    }

    /**
     * Test Case 05 - Validate the Email input box
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Email input box is displayed
     * Validate that the Email input box is required
     * Validate that the label of the Email input box is “Email”
     * Validate that the placeholder of the Email input box is “Enter your email”
     */

    //label
    //expected        actual
    //"Email"         "Email *"
    //                  ^^^ - email contains attributes
    //                  required what means that the label
    //                  must have "*" for end-user friendly purposes
    @Test(priority = 5)
    public void validateEmailInputBox() {
        WebElement inputEmailBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(4) input"));
        Assert.assertTrue(inputEmailBox.isDisplayed());
        Assert.assertTrue(true, inputEmailBox.getAttribute("required"));

        WebElement labelEmailBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(4) label"));

        Assert.assertEquals(labelEmailBox.getText(), "Email *");
        Assert.assertEquals(inputEmailBox.getAttribute("placeholder"), "Enter your email");
    }

    /**
     * Test Case 06 - Validate the Phone input box
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Phone input box is displayed
     * Validate that the Phone input box is not required
     * Validate that the label of the Phone input box is “Phone”
     * Validate that the placeholder of the Address input box is “Enter your phone number”
     *///                                    ^^Phone
    @Test(priority = 6)
    public void validatePhoneInputBox() {
        WebElement phoneInputBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(5) input"));
        Assert.assertTrue(phoneInputBox.isDisplayed());
        Assert.assertFalse(false, phoneInputBox.getAttribute("required"));

        WebElement labelPhone = driver.findElement(By.cssSelector("div[class='field']:nth-child(5) label"));
        Assert.assertEquals(labelPhone.getText(), "Phone");

        Assert.assertEquals(phoneInputBox.getAttribute("placeholder"), "Enter your phone number");
    }

    /**
     * Test Case 07 - Validate the Message text area
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Message text area is displayed
     * Validate that the Message text area is not required
     * Validate that the label of the Message text area is “Message”
     * Validate that the placeholder of the Message text area is “Type your message here…”
     */

    @Test(priority = 7)
    public void validateTheMessageTextArea() {
        WebElement textArea = driver.findElement(By.cssSelector(".textarea"));
        Assert.assertTrue(textArea.isDisplayed());
        Assert.assertFalse(false, textArea.getAttribute("required"));

        WebElement label = driver.findElement(By.cssSelector("div[class='field']:nth-child(6) label"));

        Assert.assertEquals(label.getText(), "Message");
        Assert.assertEquals(textArea.getAttribute("placeholder"), "Type your message here...");

    }

    /**
     * Test Case 08 - Validate the Consent checkbox
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the label is “I give my consent to be contacted.”
     * Validate that the Consent checkbox is required
     * Validate that the Consent checkbox is clickable
     * Click on the “I give my consent to be contacted.” checkbox and validate it is selected
     * Click on the “I give my consent to be contacted.” checkbox again and validate it is not selected
     */

    @Test(priority = 8)
    public void validateTheConsentCheckbox() {
        WebElement selectedCheckbox = driver.findElement(By.cssSelector(".checkbox"));

       WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));

        Assert.assertTrue(checkbox.isDisplayed());
        Assert.assertEquals(selectedCheckbox.getText(), "I give my consent to be contacted.");
        Assert.assertTrue(true, checkbox.getAttribute("required"));
        Assert.assertTrue(checkbox.isEnabled());

        selectedCheckbox.click();
        Assert.assertTrue(checkbox.isSelected());
        selectedCheckbox.click();
        Assert.assertFalse(checkbox.isSelected());

    }

    /**
     * Test Case 09 - Validate the SUBMIT button
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the “SUBMIT” button is displayed
     * Validate the “SUBMIT” button is clickable
     * Validate that the button text is “SUBMIT”
     */
    @Test(priority = 9)
    public void validateTheSubmitButton() {
        WebElement button = driver.findElement(By.cssSelector("button[class*='is-link']"));
        Assert.assertTrue(button.isDisplayed());
        Assert.assertTrue(button.isEnabled());
        Assert.assertEquals(button.getText(), "SUBMIT");
    }

    /**
    static WebElement fullNameBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(1) input"));
    static List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
    static WebElement inputAddressBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(3) [class='input']"));
    static WebElement inputEmailBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(4) input"));
    static WebElement phoneInputBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(5) input"));
    static WebElement textArea = driver.findElement(By.cssSelector(".textarea"));
    static WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
    static WebElement submitButton = driver.findElement(By.cssSelector("button[class*='is-link']"));
     */

    /**
     * Test Case 10 - Validate the form submission
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Enter a first name
     * Select a gender
     * Enter an address
     * Enter an email
     * Enter a phone number
     * Enter a message
     * Select the “I give my consent to be contacted.” checkbox
     * Click on the “SUBMIT” button
     * Validate the form message “Thanks for submitting!” is displayed under the “SUBMIT” button
     */
    @Test(priority = 10)
    public void validateTheFormSubmission() {
        Faker faker = new Faker();

        WebElement fullNameBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(1) input"));
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        WebElement inputAddressBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(3) [class='input']"));
        WebElement inputEmailBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(4) input"));
        WebElement phoneInputBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(5) input"));
        WebElement textArea = driver.findElement(By.cssSelector(".textarea"));
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[class*='is-link']"));

        fullNameBox.sendKeys(faker.name().fullName());
        radioButtons.get(1).click();
         inputAddressBox.sendKeys(faker.address().fullAddress());
        inputEmailBox.sendKeys("email@gmail.com");
        phoneInputBox.sendKeys(faker.phoneNumber().cellPhone());
        textArea.sendKeys(faker.gameOfThrones().dragon());
        checkbox.click();
        submitButton.submit();

        WebElement validateMessage = driver.findElement(By.cssSelector(".mt-5"));
        Assert.assertEquals(validateMessage.getText(), "Thanks for submitting!");
        Waiter.pause(5);
    }


}
