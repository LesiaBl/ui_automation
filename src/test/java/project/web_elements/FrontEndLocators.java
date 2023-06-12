package project.web_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class FrontEndLocators {

    public FrontEndLocators(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ("label [value=\"One way\"]"))
    public WebElement oneWayButton;

    @FindBy(css = ("label [value=\"Round trip\"] "))
    public WebElement roundTripButton;

    @FindBy(css = (".field:nth-child(2) label"))
    public WebElement cabinClassLabel;

    @FindBy(css = (".field:nth-child(2) option"))
    public WebElement cabinClassDropDown;

    @FindBy(css = (".field:nth-child(2) option"))
    public List<WebElement> cabinClassList;

    @FindBy(css = (".field:nth-child(3) label"))
    public WebElement fromLabel;

    @FindBy(css = (".field:nth-child(3) option"))
    public WebElement fromDropDown;

    @FindBy(css = (".field:nth-child(4) label"))
    public WebElement toLabel;

    @FindBy(css = (".field:nth-child(4) option"))
    public WebElement toDropDown;

    @FindBy(css = (".field:nth-child(5) label"))
    public WebElement departLabel;

    @FindBy(css = (".field:nth-child(5) .control"))
    public WebElement departDatePicker;

    @FindBy(css = (".field:nth-child(6) label"))
    public WebElement returnLabel;

    @FindBy(css = (".field:nth-child(6) .control"))
    public WebElement returnDatePicker;

    @FindBy(css = (".field:nth-child(7) label"))
    public WebElement numberOfPassengerLabel;

    @FindBy(css = (".field:nth-child(7) option"))
    public WebElement numberOfPassengerDropDown;

    @FindBy(css = (".field:nth-child(7) select"))
    public WebElement numberOfPassengerSelect;

    @FindBy(css = (".field:nth-child(8) label"))
    public WebElement passengerOneLabel;

    @FindBy(css = (".field:nth-child(8) option"))
    public WebElement passengerOneDropDown;

    @FindBy(css = (".field:nth-child(8) select"))
    public WebElement passengerOneSelect;

    @FindBy(css = (".field:nth-child(9) select"))
    public WebElement passengerTwoSelect;

    @FindBy(css = ("button[type='submit']"))
    public WebElement bookButton;



    @FindBy(css = (".field:nth-child(3) select"))
    public WebElement fromStateSelect;

    @FindBy(css = (".field:nth-child(4) select"))
    public WebElement toStateSelect;

    @FindBy(css = (".field:nth-child(5) .control input[name='month']"))
    public WebElement month;

    @FindBy(css = (".field:nth-child(5) .control input[name='day']"))
    public WebElement day;

    @FindBy(css = (".field:nth-child(5) .control input[name='year']"))
    public WebElement year;

    @FindBy(css = (".field:nth-child(6) .control input[name='month']"))
    public WebElement monthReturn;

    @FindBy(css = (".field:nth-child(6) .control input[name='day']"))
    public WebElement dayReturn;

    @FindBy(css = (".field:nth-child(6) .control input[name='year']"))
    public WebElement yearReturn;

    @FindBy(css = ("h1[class=is-underlined]"))
    public WebElement DepartLabel;

    @FindBy(css = (".ml-3 h3"))
    public WebElement fromToConfirm;

    @FindBy(css = (".ml-3 div:nth-child(2) h3"))
    public WebElement returnFrom;

    @FindBy(css = (".ml p"))
    public WebElement returnConfirmDate;



    @FindBy(css = (".ml-3 p"))
    public List<WebElement> dateOfFlightConfirm;

}