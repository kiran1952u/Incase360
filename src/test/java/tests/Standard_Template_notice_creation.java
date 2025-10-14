package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Login_functionality_admin;

public class Standard_Template_notice_creation {

    private static final Logger log = LoggerFactory.getLogger(Standard_Template_notice_creation.class);
    @Test(dataProvider = "userData")
    public void Addnewnotice(String noticeType, String noticeDescription) throws InterruptedException {
        // Set up ChromeDriver with options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        Login_functionality_admin test = new Login_functionality_admin();
        test.loginTest(driver);
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[4]/a")).click();
        Thread.sleep(4000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[4]/ul/li[1]/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(4000);
        WebElement noticeTypeField = driver.findElement(By.name("noticeType"));
        noticeTypeField.sendKeys(noticeType);
        WebElement noticeDescriptionField = driver.findElement(By.name("noticeDescription"));
        noticeDescriptionField.sendKeys(noticeDescription);
        Thread.sleep(4000);

        // Proceed button
        WebElement proceedButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div/div/div[1]/span"));
        proceedButton.click();
        Thread.sleep(4000);

        // Data field
        WebElement dataField = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div"));
        dataField.sendKeys("KIRAN");
        Thread.sleep(4000);

        // Dropdown option
        WebElement dropdownOption = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div/label/span[1]/input"));
        dropdownOption.click();

        // Notice template
        WebElement noticeTemplateField = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[4]/div/div/div/div[1]/div[2]/div[1]/iframe"));
        noticeTemplateField.sendKeys("Reference: ${notice_ID}\n" + "Date: ${date_of_LRN}\n" + "\n" + "EMAIL / WHATSAPP / SMS / RPAD\n" + "(WITHOUT PREJUDICE)\n" + "\n" + "To:       \n" + "\n" + "${Full_name_of_primary_respondent}\n" + "${Status_of_primary_respondent}\n" + "${Full_address_of_primary_respondent}\n" + "${Email_ID_of_primary_respondent}\n" + "${WhatsApp_of_primary_respondent};\n" + "\n" + "${Details_of_other_respondent}\n" + "${Email_of_other_respondent}\n" + "${WhatsApp_of_other_respondent}\n" + "\n" + "Re:       Loan agreement bearing number ${agreement_number}\n" + "\n" + "Sub:     Loan Recall Notice for payment of outstanding dues of Rs. ${total_outstanding_amount} and Notice under Section 21 of Arbitration and Conciliation Act, 1996\n" + "\n" + "Sir / Madam,\n" + "\n" + "On behalf of and upon instructions of my client, ${Claimant_organisation_name}, having its registered office at ${Claimant_registered_office}, (hereinafter referred to as ‘my client’), I address and serve upon you this statutory notice and state as under:\n" + "\n" + "That my client is a banking company within the meaning of the Banking Regulation Act, 1949, and and is engaged, inter alia, in the business of providing loan, finance, credit card facilities in accordance with the guidelines issued by the Reserve Bank of India from time to time.\n" + "That you approached my client seeking a ${Nature_of_agreement} loan for the purchase of vehicle / equipment / asset to be secured by hypothecation of such vehicle / equipment / asset in favour of my client by way of first and exclusive charge, and, on the basis of various documents, representation and information submitted by you, and after completion of requisite formalities, my client agreed to sanction the said loan facility, and accordingly, my client disbursed and you obtained a sum of Rs. ${Amount_of_loan} on ${disbursal_date} for the purchase of and by hypothecation by way of first and exclusive charge of vehicle / equipment / asset being ${vehicle_equipment_asset_description} bearing Engine No. ${engine_no}, Chassis No. ${chassis_no} and Registration No. ${registration_no} in accordance with the terms and conditions mentioned therein.\n" + "That, as per the loan agreement executed inter-se, you undertook to perform all the obligations stated therein, which included timely and regular payment of instalments, payment of interest and charges, at the rates specified in the loan documents.\n" + "That you committed an act of default by failing and neglecting to pay various amounts of instalments which fell due and payable in terms of the said agreement. As per the agreement, in the event of default, my client is entitled to call upon you to pay forthwith the outstanding balance of the loan together with interest, additional interest and other charges. In spite of repeated reminders, requests and follow-ups sent by my client to you for the settlement of outstanding dues under the loan facility, till date an outstanding amount of Rs. ${total_outstanding_amount} continues to remain overdue and pending. As per the agreement, my client is also entitled to take inspection of the vehicle / equipment / asset, and further, my client, through its officers, agents or nominees, shall have the right to take charge and / or possession of, seize, recover, receive and remove the said vehicle / equipment / asset and sell by auction or by private contract or tender, dispatch or consign for realization or otherwise dispose of or deal with the said vehicle / equipment / asset in the prescribed manner. Further, as per the agreement, you shall remain liable for any deficiency in the amount due to my client after adjustment of net proceeds of sale, realization, recovery and / or insurance claim.\n" + "That you are hereby called upon to forthwith pay to my client, the outstanding amount of Rs. ${total_outstanding_amount}, give inspection of the vehicle / equipment / asset, and, handover the peaceful possession of the vehicle / equipment / asset within 7 days from the date of receipt of this notice, failing which, my client shall be constrained to initiate appropriate legal proceedings including but not limited to civil and / or criminal proceedings and / or police complaint, entirely at your cost and consequences which could entail imprisonment, hefty fines, and attachment and sale of your property / asset.\n" + "That, as per the agreement, any dispute, controversy and / or claim shall be resolved by arbitration, and accordingly, with a view to provide each party full opportunity to present its case, fairly and conveniently, the use of an online dispute resolution (“ODR”) platform for conducting arbitration online administered by a neutral ODR institution was evaluated. After evaluating different ODR platforms and upon being satisfied that Presolv360, which is an independent ODR platform recognized and that provides complete administrative and technical support to the parties to conduct the proceedings online, and has no interest in the outcome of the dispute and there being no conflict of interest, the dispute shall be resolved by arbitration administered electronically by Presolv360 in accordance with its Dispute Resolution Rules (\"Rules\").\n" + "That the arbitration shall be before a sole arbitrator appointed under the Rules on behalf of all the parties. The juridical seat of arbitration shall be ${seat}, India and the language of arbitration shall be English. The law governing the arbitration proceedings shall be Indian law. The decision of the sole arbitrator shall be final and binding on all the parties concerned. My client shall bear the cost of such arbitration subject to the final award on costs passed by the sole arbitrator.\n" + "By this notice, I hereby invoke arbitration under the provisions of Section 21 of the Arbitration and Conciliation Act, 1996, and call upon you to settle the dispute through arbitration conducted online by Presolv360.\n" + "You are hereby informed that my client reserves its right to take recourse to civil and / or criminal proceedings as per the provisions of law in force without prejudice to the arbitration proceedings and claim costs, charges, interest, loss and damages from you.\n" + "\n" + "The above notice is issued without prejudice to any other rights and / or remedies available to my client in law and equity.\n" + "\n" + "This is for your information and necessary action.\n" + "\n" + "Yours faithfully,\n" + "\n" + "Signature\n" + "Advocate / Legal Team\n" + "On behalf of ${Claimant_organisation_name}\n" + "\n" + "cc:\n" + "${cc_other_respondent}\n" + "${cc_Claimant_organisation_name}\n");
        Thread.sleep(5000);
        WebElement button = driver.findElement(By.xpath("//*[@id='layout-wrapper']/div[2]/div/div/div[2]/form/div[5]/label[2]/input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        WebElement fileInput = driver.findElement(By.xpath("//*[@id='layout-wrapper']/div[2]/div/div/div[2]/form/div[5]/label[2]/input"));


        String csvFilePath = "D:\\UploadDATA\\Upload DATA FOR Notices\\Upload CSV DATA\\kiran_last_test\\kiran last test csv format\\kirantestdata.csv";


        fileInput.sendKeys(csvFilePath);
        Thread.sleep(3000);
        JavascriptExecutor jsf = (JavascriptExecutor) driver;


        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;


        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        JavascriptExecutor js3 = (JavascriptExecutor) driver;


        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/button")).click();

    }

    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object[][]{
                {"Test_font_test8", "Test_font_test9"},
                {"Test_font_test10", "Test_font_test11"},
                {"Test_font_test12", "Test_font_test13"},
                {"Test_font_test14", "Test_font_test15"},
                {"Test_font_test16", "Test_font_test17"}

        };
    }
}
