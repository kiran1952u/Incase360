package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(dataProvider = "userData")
public class AddnewNotice {

    public void Addnewnotice(String noticeType, String noticeDescription) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://test.incase360.com/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.name("userName")).sendKeys("admin@incase360.com");
        driver.findElement(By.name("userPassword")).sendKeys("1WbFG0Z84@");
        Thread.sleep(3000);
        WebElement e = driver.findElement(By.id("captchaanswer"));
        System.out.println("This is the value" + e.getAttribute("innerHTML"));
        Thread.sleep(1000);
        driver.findElement(By.id("captcha")).sendKeys(e.getAttribute("innerHTML"));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/section/main/div/div/div/div/div/div/div/form/div[4]/div[2]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[4]/a")).click();
//        /html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[4]/a
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[4]/ul/li[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("noticeType")).sendKeys(noticeType);
        driver.findElement(By.name("noticeDescription")).sendKeys(noticeDescription);
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div/div/div[1]/span")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div")).sendKeys("KIRAN");
//        /html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div")).click();
//        /html/body/div[4]/div[2]/div/div/div
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[4]/div/div/div/div[1]/div[2]/div[1]/iframe")).sendKeys("Reference: ${notice_ID}\n" +
                "Date: ${date_of_LRN}\n" +
                "\n" +
                "EMAIL / WHATSAPP / SMS / RPAD\n" +
                "(WITHOUT PREJUDICE)\n" +
                "\n" +
                "To:       \n" +
                "\n" +
                "${Full_name_of_primary_respondent}\n" +
                "${Status_of_primary_respondent}\n" +
                "${Full_address_of_primary_respondent}\n" +
                "${Email_ID_of_primary_respondent}\n" +
                "${WhatsApp_of_primary_respondent};\n" +
                "\n" +
                "${Details_of_other_respondent}\n" +
                "${Email_of_other_respondent}\n" +
                "${WhatsApp_of_other_respondent}\n" +
                "\n" +
                "Re:       Loan agreement bearing number ${agreement_number}\n" +
                "\n" +
                "Sub:     Loan Recall Notice for payment of outstanding dues of Rs. ${total_outstanding_amount} and Notice under Section 21 of Arbitration and Conciliation Act, 1996\n" +
                "\n" +
                "Sir / Madam,\n" +
                "\n" +
                "On behalf of and upon instructions of my client, ${Claimant_organisation_name}, having its registered office at ${Claimant_registered_office}, (hereinafter referred to as ‘my client’), I address and serve upon you this statutory notice and state as under:\n" +
                "\n" +
                "That my client is a banking company within the meaning of the Banking Regulation Act, 1949, and and is engaged, inter alia, in the business of providing loan, finance, credit card facilities in accordance with the guidelines issued by the Reserve Bank of India from time to time.\n" +
                "That you approached my client seeking a ${Nature_of_agreement} loan for the purchase of vehicle / equipment / asset to be secured by hypothecation of such vehicle / equipment / asset in favour of my client by way of first and exclusive charge, and, on the basis of various documents, representation and information submitted by you, and after completion of requisite formalities, my client agreed to sanction the said loan facility, and accordingly, my client disbursed and you obtained a sum of Rs. ${Amount_of_loan} on ${disbursal_date} for the purchase of and by hypothecation by way of first and exclusive charge of vehicle / equipment / asset being ${vehicle_equipment_asset_description} bearing Engine No. ${engine_no}, Chassis No. ${chassis_no} and Registration No. ${registration_no} in accordance with the terms and conditions mentioned therein.\n" +
                "That, as per the loan agreement executed inter-se, you undertook to perform all the obligations stated therein, which included timely and regular payment of instalments, payment of interest and charges, at the rates specified in the loan documents.\n" +
                "That you committed an act of default by failing and neglecting to pay various amounts of instalments which fell due and payable in terms of the said agreement. As per the agreement, in the event of default, my client is entitled to call upon you to pay forthwith the outstanding balance of the loan together with interest, additional interest and other charges. In spite of repeated reminders, requests and follow-ups sent by my client to you for the settlement of outstanding dues under the loan facility, till date an outstanding amount of Rs. ${total_outstanding_amount} continues to remain overdue and pending. As per the agreement, my client is also entitled to take inspection of the vehicle / equipment / asset, and further, my client, through its officers, agents or nominees, shall have the right to take charge and / or possession of, seize, recover, receive and remove the said vehicle / equipment / asset and sell by auction or by private contract or tender, dispatch or consign for realization or otherwise dispose of or deal with the said vehicle / equipment / asset in the prescribed manner. Further, as per the agreement, you shall remain liable for any deficiency in the amount due to my client after adjustment of net proceeds of sale, realization, recovery and / or insurance claim.\n" +
                "That you are hereby called upon to forthwith pay to my client, the outstanding amount of Rs. ${total_outstanding_amount}, give inspection of the vehicle / equipment / asset, and, handover the peaceful possession of the vehicle / equipment / asset within 7 days from the date of receipt of this notice, failing which, my client shall be constrained to initiate appropriate legal proceedings including but not limited to civil and / or criminal proceedings and / or police complaint, entirely at your cost and consequences which could entail imprisonment, hefty fines, and attachment and sale of your property / asset.\n" +
                "That, as per the agreement, any dispute, controversy and / or claim shall be resolved by arbitration, and accordingly, with a view to provide each party full opportunity to present its case, fairly and conveniently, the use of an online dispute resolution (“ODR”) platform for conducting arbitration online administered by a neutral ODR institution was evaluated. After evaluating different ODR platforms and upon being satisfied that Presolv360, which is an independent ODR platform recognized and that provides complete administrative and technical support to the parties to conduct the proceedings online, and has no interest in the outcome of the dispute and there being no conflict of interest, the dispute shall be resolved by arbitration administered electronically by Presolv360 in accordance with its Dispute Resolution Rules (\"Rules\").\n" +
                "That the arbitration shall be before a sole arbitrator appointed under the Rules on behalf of all the parties. The juridical seat of arbitration shall be ${seat}, India and the language of arbitration shall be English. The law governing the arbitration proceedings shall be Indian law. The decision of the arbitrator shall be final and binding on the parties. Subject to the above, the competent courts at the seat shall have exclusive jurisdiction.\n" +
                "That the aforesaid proceedings shall be carried out electronically on Presolv360's platform (https://www.presolv360.com/) via your email address and / or mobile number i.e. ${Email_ID_of_primary_respondent} , ${WhatsApp_of_primary_respondent}.\n" +
                "That if any of the aforementioned details are incomplete or incorrect, or if you have anything to say in respect of the above, you are required to intimate my client within 7 days from the date of receipt of this notice.\n" +
                "That, in the event, you are interested in amicably settling this matter, you can use the link provided in the email / message.\n" +
                "\n" +
                "Copy of this notice is retained by my office for further action.\n" +
                "\n" +
                "Sincerely,\n" +
                "\n" +
                "${Name_of_advocate}\n" +
                "${Designation_of_advocate}\n" +
                "\n" +
                "${Notice_Signature}");
        Thread.sleep(5000);
        WebElement button = driver.findElement(By.xpath("//*[@id='layout-wrapper']/div[2]/div/div/div[2]/form/div[5]/label[2]/input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        WebElement fileInput = driver.findElement(By.xpath("//*[@id='layout-wrapper']/div[2]/div/div/div[2]/form/div[5]/label[2]/input"));

        // Provide the file path of the CSV file to be uploaded
        String csvFilePath = "D:\\UploadDATA\\Upload DATA FOR Notices\\Upload CSV DATA\\kiran_last_test\\kiran last test csv format\\kirantestdata.csv";

        // Use sendKeys() method to upload the CSV file
        fileInput.sendKeys(csvFilePath);
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by 500 pixels
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;

        // Scroll down by 500 pixels
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        JavascriptExecutor js3 = (JavascriptExecutor) driver;

        // Scroll down by 500 pixels
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/button")).click();

    }

    //
    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object[][]{
                {"Test_font_test4", "Test_font_tes5"},
//                {"Test_font_test6", "Test_font_test7"},
//

        };


    }
}
