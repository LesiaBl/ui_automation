package project.projects;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project.web_elements.FrontEndLocators;
import scripts.Base;
import utils.DropdownHandler;
import utils.Waiter;

public class Project3_FrontEnd extends Base {
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-3");
        project3Page = new FrontEndLocators();
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-3
    Validate that the "One way" radio button is displayed enabled and selected by default
    Validate that the "Round trip" radio button is displayed enabled and not selected by default
    Validate that the "Cabin Class" label and dropdown are displayed
    Validate that the "From" label and dropdown are displayed
    Validate that the "To" label and dropdown are displayed
    Validate that the "Depart" label and date picker is displayed
    Validate that the "Return" label and date picker is displayed and disabled
    Validate that the "Number of passengers" label and dropdown are displayed and 1 is the default
    Validate that the "Passenger 1" category label and dropdown are displayed and "Adult (16-64)" is the default
    Validate that the "BOOK" button is displayed and enabled
     */
    @Test(priority = 1)
    public void  validateTheDefaultBookYourTrip(){

        Assert.assertTrue(project3Page.oneWayButton.isDisplayed());
        Assert.assertTrue(project3Page.oneWayButton.isEnabled());
        Assert.assertTrue(project3Page.oneWayButton.isSelected());
        Assert.assertTrue(project3Page.roundTripButton.isDisplayed());
        Assert.assertTrue(project3Page.roundTripButton.isEnabled());
        Assert.assertFalse(project3Page.roundTripButton.isSelected());
        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropDown.isDisplayed());
        Assert.assertTrue(project3Page.fromLabel.isDisplayed());
        Assert.assertTrue(project3Page.fromDropDown.isDisplayed());
        Assert.assertTrue(project3Page.toLabel.isDisplayed());
        Assert.assertTrue(project3Page.toDropDown.isDisplayed());
        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.departDatePicker.isDisplayed());
        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isEnabled());
        Assert.assertTrue(project3Page.numberOfPassengerLabel.isDisplayed());
        Assert.assertTrue(project3Page.numberOfPassengerDropDown.isDisplayed());
        Assert.assertEquals(project3Page.numberOfPassengerDropDown.getAttribute("value"),"1");
        Assert.assertTrue(project3Page.passengerOneLabel.isDisplayed());
        Assert.assertTrue(project3Page.passengerOneDropDown.isDisplayed());
        Assert.assertEquals(project3Page.passengerOneDropDown.getText(),"Adult (16-64)");
        Assert.assertTrue(project3Page.bookButton.isDisplayed());
        Assert.assertTrue(project3Page.bookButton.isEnabled());


    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-3
    Click on the "Round trip" radio button and validate it is selected
    Validate that the "One way" radio button is not selected
    Validate that the "Cabin Class" label and dropdown are displayed
    Validate that the "From" label and dropdown are displayed
    Validate that the "To" label and dropdown are displayed
    Validate that the "Depart" label and date picker is displayed
    Validate that the "Return" label and date picker is displayed
    Validate that the "Number of passengers" label and dropdown are displayed and 1 is the default
    Validate that the "Passenger 1" label and dropdown are displayed and "Adult (16-64)" is the default
    Validate that the "BOOK" button is displayed and enabled
     */
    @Test(priority = 2)
    public void validateTheBookYourTripFormWhenRoundTripIsSelected(){
        project3Page.roundTripButton.click();

        Assert.assertFalse(project3Page.oneWayButton.isSelected());
        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropDown.isDisplayed());
        Assert.assertTrue(project3Page.fromLabel.isDisplayed());
        Assert.assertTrue(project3Page.fromDropDown.isDisplayed());
        Assert.assertTrue(project3Page.toLabel.isDisplayed());
        Assert.assertTrue(project3Page.toDropDown.isDisplayed());
        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.departDatePicker.isDisplayed());
        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isEnabled());
        Assert.assertTrue(project3Page.numberOfPassengerLabel.isDisplayed());


        Assert.assertTrue(project3Page.numberOfPassengerDropDown.isDisplayed());
        Assert.assertEquals(project3Page.numberOfPassengerDropDown.getAttribute("value"),"1");
        Assert.assertTrue(project3Page.passengerOneLabel.isDisplayed());
        Assert.assertTrue(project3Page.passengerOneDropDown.isDisplayed());
        Assert.assertEquals(project3Page.passengerOneDropDown.getText(),"Adult (16-64)");
        Assert.assertTrue(project3Page.bookButton.isDisplayed());
        Assert.assertTrue(project3Page.bookButton.isEnabled());
    }
    /*
    Select the "One way" radio button
    Select "Business" for the "Cabin Class" dropdown
    Select "Illinois" for the "From" dropdown
    Select "Florida" for the "To" dropdown
    Select the next week for the "Depart"
    Select "1" for the "Number of passengers" dropdown
    Select "Senior (65+)" for the Passenger 1 dropdown
    Click on the "BOOK" button
    Validate the booking information displayed below
    DEPART
    IL to FL
    {dynamic date}
    Number of passengers: 1
    Passenger 1: Senior (65+)
    Cabin Class: Business
     */

    @Test(priority = 3)
    public void validateTheBookingFor1PassengerAndOneWay(){

        project3Page.oneWayButton.click();

        project3Page.cabinClassList.get(2).click();

        //fromState.get()
        //project3Page.fromState
        DropdownHandler.selectByVisibleText(project3Page.fromStateSelect, "Illinois");
        Waiter.pause(5);

        DropdownHandler.selectByVisibleText(project3Page.toStateSelect,"Florida");

        project3Page.month.sendKeys("6");
        project3Page.day.sendKeys("18");
        project3Page.year.sendKeys("2023");

        DropdownHandler.selectByIndex(project3Page.numberOfPassengerSelect,0);
        DropdownHandler.selectByVisibleText(project3Page.passengerOneSelect,"Senior (65+)");

        project3Page.bookButton.click();

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertEquals(project3Page.fromToConfirm.getText(),"IL to FL");

        String [] expectedResults = {"Sun Jun 18 2023","Number of Passengers: 1","Passenger 1: Senior (65+)","Cabin class: Business"};

        for (int i = 0; i < project3Page.dateOfFlightConfirm.size(); i++) {
            Assert.assertEquals(project3Page.dateOfFlightConfirm.get(i).getText(),expectedResults[i]);
        }
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-3
    Select the "Round trip" radio button
    Select "First" for the "Cabin Class" dropdown
    Select "California" for the "From" dropdown
    Select "Illinois" for the "To" dropdown
    Select the next week for the "Depart"
    Select the next month for the "Return"
    Select "1" for the "Number of passengers" dropdown
    Select "Adult (16-64)" for the Passenger 1 dropdown
    Click on the "BOOK" button
    Validate the booking information displayed below
     */
    @Test(priority = 4)
    public void validateTheBookingFor1PassengerAndRoundTrip(){
        project3Page.roundTripButton.click();

        project3Page.cabinClassList.get(3).click();

        //fromState.get()
        //project3Page.fromState
        DropdownHandler.selectByVisibleText(project3Page.fromStateSelect, "California");
        Waiter.pause(5);

        DropdownHandler.selectByVisibleText(project3Page.toStateSelect,"Illinois");

        project3Page.month.sendKeys("6");
        project3Page.day.sendKeys("18");
        project3Page.year.sendKeys("2023");

        project3Page.monthReturn.sendKeys("7");
        project3Page.dayReturn.sendKeys("18");
        project3Page.yearReturn.sendKeys("2023");


        DropdownHandler.selectByIndex(project3Page.numberOfPassengerSelect,0);
        DropdownHandler.selectByVisibleText(project3Page.passengerOneSelect,"Adult (16-64)");

        project3Page.bookButton.click();

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertEquals(project3Page.fromToConfirm.getText(),"CA to IL");
        Assert.assertEquals(project3Page.returnFrom.getText(),"IL to CA");

        String [] expectedResults = {"Sun Jun 18 2023", "Tue Jul 18 2023","Number of Passengers: 1","Passenger 1: Adult (16-64)","Cabin class: First"};

        for (int i = 0; i < project3Page.dateOfFlightConfirm.size(); i++) {
            Assert.assertEquals(project3Page.dateOfFlightConfirm.get(i).getText(),expectedResults[i]);
        }

        Assert.assertEquals(project3Page.returnConfirmDate.getText(),"Tue Jul 18 2023");
    }

    @Test(priority = 5)
    public void validateTheBookingFor2PassengerAndOneWay(){
        project3Page.oneWayButton.click();

        project3Page.cabinClassList.get(1).click();

        //fromState.get()
        //project3Page.fromState
        DropdownHandler.selectByVisibleText(project3Page.fromStateSelect, "New York");
        Waiter.pause(5);

        DropdownHandler.selectByVisibleText(project3Page.toStateSelect,"Texas");

        project3Page.month.sendKeys("6");
        project3Page.day.sendKeys("13");
        project3Page.year.sendKeys("2023");

        DropdownHandler.selectByIndex(project3Page.numberOfPassengerSelect,1);
        DropdownHandler.selectByVisibleText(project3Page.passengerOneSelect,"Adult (16-64)");
        DropdownHandler.selectByVisibleText(project3Page.passengerTwoSelect,"Child (2-11)");

        project3Page.bookButton.click();

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertEquals(project3Page.fromToConfirm.getText(),"NY to TX");


        String [] expectedResults = {"Tue Jun 13 2023","Number of Passengers: 2","Passenger 1: Adult (16-64)","Passenger 2: Child (2-11)","Cabin class: Premium Economy"};

        for (int i = 0; i < project3Page.dateOfFlightConfirm.size(); i++) {
            Assert.assertEquals(project3Page.dateOfFlightConfirm.get(i).getText(),expectedResults[i]);
        }


    }
}