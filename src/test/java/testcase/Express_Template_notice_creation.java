package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Login_functionality_admin;

import java.util.Random;

public class Express_Template_notice_creation {

    private static final Logger log = LoggerFactory.getLogger(Standard_Template_notice_creation.class);

    @Test(dataProvider = "userData")
    public void test(String noticeType, String noticeDescription) throws InterruptedException {
        // Set up ChromeDriver with options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        Login_functionality_admin test = new Login_functionality_admin();
        test.Login(driver);
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
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/label/span/span")).click();
        // Proceed button
        WebElement proceedButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div/div/div[1]/span"));
        proceedButton.click();
        Thread.sleep(4000);

        // Data field
        WebElement dataField = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div"));
        dataField.sendKeys("KIRAN");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div")).click();

        WebElement noticeTemplateField = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[4]/div/div/div/div[1]/div[2]/div[1]/iframe"));
        noticeTemplateField.sendKeys("Reference: Notice ID ${notice_ID}\n" +
                "\n" +
                "Date: ${date_of_notice}\n" +
                "\n" +
                "\n" +
                "\n" +
                "EMAIL / WHATSAPP / SMS / RPAD\n" +
                "\n" +
                "(WITHOUT PREJUDICE)\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "To:\n" +
                "${Full_name_of_primary_respondent}\n" +
                "${Status_of_primary_respondent}\n" +
                "${Full_address_of_primary_respondent}\n" +
                "@if{Email_ID_of_primary_respondent!=empty}${Email_ID_of_primary_respondent}\n" +
                "@end{}${WhatsApp_of_primary_respondent};\n" +
                "\n" +
                "\n" +
                "coborrower_start\n" +
                "\n" +
                "${Coborrower_one}\n" +
                "${Coborrower_one_email} , ${Coborrower_one_mobile}\n" +
                "${Coborrower_two}\n" +
                "${Coborrower_two_email} , ${Coborrower_two_mobile}\n" +
                "${Coborrower_three}\n" +
                "${Coborrower_three_email} , ${Coborrower_three_mobile}\n" +
                "\n" +
                "coborrower_end\n" +
                "\n" +
                "other_respondent_start\n" +
                "\n" +
                "${Details_of_other_respondent}\n" +
                "${Email_ID_of_other_respondent}\n" +
                "${WhatsApp_of_other_respondent}\n" +
                "\n" +
                "other_respondent_end\n" +
                "\n" +
                "Re:       Loan account number ${agreement_number}\n" +
                "\n" +
                "Sub:     Loan Recall Notice for payment of outstanding dues of Rs. ${total_outstanding_amount} and Notice under Section 21 of Arbitration and Conciliation Act, 1996, in respect of loan bearing number ${agreement_number}\n" +
                "\n" +
                "Sir / Madam,\n" +
                "\n" +
                "On behalf of and upon instructions of my client, ${Claimant_organisation_name}, having its registered office at ${Claimant_registered_office}, (hereinafter referred to as ‘my client’), I address and serve upon you this notice and state as under:\n" +
                "\n" +
                "1.      That my client is a non - banking financial company, and is engaged, inter alia, in the business of providing loan, finance, credit card facilities in accordance with the guidelines issued by the Reserve Bank of India from time to time.\n" +
                "\n" +
                "2.      That you approached my client seeking a ${Nature_of_agreement} loan, and, on the basis of various documents, representation and information submitted by you, and after completion of requisite formalities, my client agreed to sanction the said loan facility, and accordingly, my client disbursed and you obtained a sum of Rs. ${Amount_of_loan} on ${disbursal_date} in accordance with the terms and conditions contained in the loan documents.\n" +
                "\n" +
                "3.      That, as per the loan agreement executed inter-se, you undertook to perform all the obligations stated therein, which included timely and regular payment of instalments, payment of interest and charges, at the rates specified in the loan documents.\n" +
                "\n" +
                "4.      That you committed an act of default by failing and neglecting to pay various amounts of instalments which fell due and payable in terms of the said agreement. As per the agreement, in the event of default, my client is entitled to call upon you to pay forthwith the outstanding balance of the loan together with interest, additional interest and other charges. In spite of repeated reminders, requests and follow-ups sent by my client to you for the settlement of outstanding dues under the loan facility, till date an outstanding amount of Rs. ${total_outstanding_amount} continues to remain overdue and pending.\n" +
                "\n" +
                "5.      That you are hereby called upon to forthwith pay to my client, the outstanding amount of Rs. ${total_outstanding_amount} within ${due_days_for_response} days from the date of receipt of this notice, failing which, my client shall be constrained to initiate appropriate legal proceedings including but not limited to civil and / or criminal proceedings and / or police complaint, entirely at your cost and consequences which could entail imprisonment, hefty fines, and attachment and sale of your property / asset.\n" +
                "\n" +
                "6.      That, as per the agreement, any dispute, controversy and / or claim shall be resolved by arbitration, and accordingly, in light of the amendments in the arbitration law and the judicial pronouncements regarding appointment of arbitrators, with a view to provide each party full opportunity to present its case fairly and conveniently, and in order to facilitate the conduct of arbitration proceedings, administrative assistance by a suitable service provider/centre/institution was evaluated.\n" +
                "\n" +
                "7.      For this purpose, the list of institutions offering Alternative Dispute Resolution (ADR) services including through Online Dispute Resolution (ODR) vide notification bearing F.No. A-60011/97/2018-Admn.III (LA) dated 18/09/2020 of the Law Ministry was considered. Considering the small value of the claim and safety and convenience of the parties, it would be beneficial to opt for an institution facilitating virtual proceedings with case management system, administrative assistance, etc. supported by its dispute resolution rules to ensure time and cost-efficient dispute resolution.\n" +
                "\n" +
                "8.      Presolv360 is one such neutral service provider/centre/institution included in the said list that provides administrative support to the parties, has no interest in the outcome of the dispute and there is no conflict of interest. From the details available on its website i.e. www.presolv360.com and the public domain, Presolv360 is a well-reputed dispute resolution institution that is empaneled with various Courts and has constituted an Advisory Council comprising of Justice U. U. Lalit, Former Chief Justice of India, Justice B. N. Srikrishna, Former Judge of the Supreme Court of India, and Justice Kannan Krishnamoorthy, Former Judge of the High Court of Punjab and Haryana.\n" +
                "\n" +
                "9.      Accordingly, upon your failure to comply with this notice, the dispute will be registered with Presolv360 for administering the arbitration proceedings on its virtual platform, and resolved by an independent, qualified arbitrator with the required competence, knowledge and expertise assigned from the broad-based panel of arbitrators.\n" +
                "\n" +
                "10.   That if any of the aforementioned details are incomplete or incorrect, or if you have anything to say in respect of the above, you are required to intimate my client within ${due_days_for_response} days from the date of receipt of this notice, failing which, it will be understood that the aforementioned details are correct and that you have waived your right to object to the above.\n" +
                "\n" +
                "11.   That, in the event, you are interested in amicably settling this matter, you are requested to contact my client’s manager ${contact_person_for_claimant} or can use the link provided in the email / message.\n" +
                "\n" +
                "Kindly ignore this statutory notice in case you have already cleared the aforesaid dues.\n" +
                "Copy of this notice is retained by my office for further action.\n" +
                "\n" +
                "Sincerely,\n" +
                "\n" +
                "${Name_of_advocate}\n" +
                "${Designation_of_advocate}\n" +
                "${Notice_Signature}");
        Thread.sleep(5000);
        WebElement button = driver.findElement(By.xpath("//*[@id='layout-wrapper']/div[2]/div/div/div[2]/form/div[5]/label[2]/input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        Thread.sleep(5000);
        WebElement fileInput = driver.findElement(By.xpath("//*[@id='layout-wrapper']/div[2]/div/div/div[2]/form/div[5]/label[2]/input"));
        String csvFilePath = "D:\\coborrower data with format\\MIS test DATA\\Format.csv";


        fileInput.sendKeys(csvFilePath);
        Thread.sleep(3000);

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
        Random random = new Random();
        int uniqueId = random.nextInt(100000);

        return new Object[][]{
                {"Dummy_express_notice_" + uniqueId, "Dummy_express_description_" + uniqueId},
                {"Test_notice_" + uniqueId + "_1", "Test_description_" + uniqueId + "_1"},
//                {"Test_notice_" + uniqueId + "_2", "Test_description_" + uniqueId + "_2"},
//                {"Test_notice_" + uniqueId + "_3", "Test_description_" + uniqueId + "_3"},
//                {"Test_notice_" + uniqueId + "_4", "Test_description_" + uniqueId + "_4"},
//                {"Test_notice_" + uniqueId + "_5", "Test_description_" + uniqueId + "_5"}
        };
    }
}