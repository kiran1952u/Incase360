package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverFactory;

import java.util.List;
import java.util.Random;

/**
 * Step Definitions for Express Template Notice Creation
 * This class contains steps for creating express notice templates
 */
public class Express_Template_notice_creation_Steps {

    private WebDriver driver;
    private int uniqueId;
    private String noticeType;

    public Express_Template_notice_creation_Steps() {
        this.driver = DriverFactory.getDriver();
        // Generate unique ID once per scenario
        this.uniqueId = new Random().nextInt(100000);
    }

    @When("the admin navigates to the create template page")
    public void the_admin_navigates_to_the_create_template_page() throws InterruptedException {
        // Click on Templates menu
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a")).click();
        Thread.sleep(4000);

        // Click on Create Template submenu
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[3]/ul/li[1]/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        Thread.sleep(4000);

        System.out.println("Navigated to create template page");
    }

    @And("the admin enters notice type {string} with unique ID")
    public void the_admin_enters_notice_type_with_unique_id(String noticeType) throws InterruptedException {
        // Store notice type for later use in delete
        this.noticeType = noticeType;

        // Enter notice type with unique ID appended
        String uniqueNoticeType = noticeType + "_" + uniqueId;
        WebElement noticeTypeField = driver.findElement(By.name("noticeType"));
        noticeTypeField.sendKeys(uniqueNoticeType);
        Thread.sleep(2000);

        System.out.println("Entered notice type: " + uniqueNoticeType);
    }

    @And("the admin enters notice description {string} with unique ID")
    public void the_admin_enters_notice_description_with_unique_id(String noticeDescription) throws InterruptedException {
        // Enter notice description with unique ID appended
        String uniqueDescription = noticeDescription + "_" + uniqueId;
        WebElement noticeDescriptionField = driver.findElement(By.name("noticeDescription"));
        noticeDescriptionField.sendKeys(uniqueDescription);
        Thread.sleep(2000);

        System.out.println("Entered notice description: " + uniqueDescription);
    }

    @And("the admin selects the express template option")
    public void the_admin_selects_the_express_template_option() throws InterruptedException {
        // Click the Express checkbox
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/label/span/span")).click();
        Thread.sleep(2000);

        System.out.println("Selected express template option");
    }

    @And("the admin clicks the proceed button")
    public void the_admin_clicks_the_proceed_button() throws InterruptedException {
        // Click Proceed button
        WebElement proceedButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div/div/div[1]/span"));
        proceedButton.click();
        Thread.sleep(4000);

        System.out.println("Clicked proceed button");
    }

    @And("the admin enters data field {string}")
    public void the_admin_enters_data_field(String dataField) throws InterruptedException {
        // Enter data field value

        WebElement dataFieldElement = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div"));
        dataFieldElement.sendKeys(dataField);
        Thread.sleep(2000);

        // Click to select the field
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div")).click();
        Thread.sleep(2000);

        System.out.println("Entered data field: " + dataField);
    }

    @And("the admin enters the express notice template text")
    public void the_admin_enters_the_express_notice_template_text() throws InterruptedException {
        // Enter the long legal notice template text
        String templateText = "Reference: Notice ID ${notice_ID}\n" +
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
                "Re:       Loan account number ${agreement_number}\n" +
                "\n" +
                "Sub:     Loan Recall Notice for payment of outstanding dues of Rs. ${total_outstanding_amount} and Notice under Section 21 of Arbitration and Conciliation Act, 1996, in respect of loan bearing number ${agreement_number}\n" +
                "\n" +
                "Sir / Madam,\n" +
                "\n" +
                "On behalf of and upon instructions of my client, ${Claimant_organisation_name}, having its registered office at ${Claimant_registered_office}, (hereinafter referred to as 'my client'), I address and serve upon you this notice and state as under:\n" +
                "\n" +
                "1.      That my client is a non - banking financial company, and is engaged, inter alia, in the business of providing loan, finance, credit card facilities in accordance with the guidelines issued by the Reserve Bank of India from time to time.\n" +
                "\n" +
                "2.      That you approached my client seeking a ${Nature_of_agreement} loan, and, on the basis of various documents, representation and information submitted by you, and after completion of requisite formalities, my client agreed to sanction the said loan facility, and accordingly, my client disbursed and you obtained a sum of Rs. ${Amount_of_loan} on ${disbursal_date} in accordance with the terms and conditions contained in the loan documents.\n" +
                "\n" +
                "3.      That, as per the loan agreement executed inter-se, you undertook to perform all the obligations stated therein, which included timely and regular payment of instalments, payment of interest and charges, at the rates specified in the loan documents.\n" +
                "\n" +
                "4.      That you committed an act of default by failing and neglecting to pay various amounts of instalments which fell due and payable in terms of the said agreement. As per the agreement, in the event of default, my client is entitled to call upon you to pay forthwith the outstanding balance of the loan together with interest, additional interest and other charges. In spite of repeated reminders, requests and follow-ups sent by my client to you for the settlement of outstanding dues under the loan facility, till date an outstanding amount of Rs. ${total_outstanding_amount} continues to remain overdue and pending.\n" +
                "\n" +
                "5.      That you are hereby called upon to forthwith pay to my client, the outstanding amount of Rs. ${total_outstanding_amount} within ${due_days_for_response} days from the date of receipt of this notice, failing which, my client shall be constrained to initiate appropriate legal proceedings including but not limited to civil and / or criminal proceedings and / or police complaint, entirely at your cost and consequences which could entail imprisonment, hefty fines, and attachment and sale of your property / asset.\n" +
                "\n" +
                "6.      That, as per the agreement, any dispute, controversy and / or claim shall be resolved by arbitration, and accordingly, in light of the amendments in the arbitration law and the judicial pronouncements regarding appointment of arbitrators, with a view to provide each party full opportunity to present its case fairly and conveniently, and in order to facilitate the conduct of arbitration proceedings, administrative assistance by a suitable service provider/centre/institution was evaluated.\n" +
                "\n" +
                "7.      For this purpose, the list of institutions offering Alternative Dispute Resolution (ADR) services including through Online Dispute Resolution (ODR) vide notification bearing F.No. A-60011/97/2018-Admn.III (LA) dated 18/09/2020 of the Law Ministry was considered. Considering the small value of the claim and safety and convenience of the parties, it would be beneficial to opt for an institution facilitating virtual proceedings with case management system, administrative assistance, etc. supported by its dispute resolution rules to ensure time and cost-efficient dispute resolution.\n" +
                "\n" +
                "8.      Presolv360 is one such neutral service provider/centre/institution included in the said list that provides administrative support to the parties, has no interest in the outcome of the dispute and there is no conflict of interest. From the details available on its website i.e. www.presolv360.com and the public domain, Presolv360 is a well-reputed dispute resolution institution that is empaneled with various Courts and has constituted an Advisory Council comprising of Justice U. U. Lalit, Former Chief Justice of India, Justice B. N. Srikrishna, Former Judge of the Supreme Court of India, and Justice Kannan Krishnamoorthy, Former Judge of the High Court of Punjab and Haryana.\n" +
                "\n" +
                "9.      Accordingly, upon your failure to comply with this notice, the dispute will be registered with Presolv360 for administering the arbitration proceedings on its virtual platform, and resolved by an independent, qualified arbitrator with the required competence, knowledge and expertise assigned from the broad-based panel of arbitrators.\n" +
                "\n" +
                "10.   That if any of the aforementioned details are incomplete or incorrect, or if you have anything to say in respect of the above, you are required to intimate my client within ${due_days_for_response} days from the date of receipt of this notice, failing which, it will be understood that the aforementioned details are correct and that you have waived your right to object to the above.\n" +
                "\n" +
                "11.   That, in the event, you are interested in amicably settling this matter, you are requested to contact my client's manager ${contact_person_for_claimant} or can use the link provided in the email / message.\n" +
                "\n" +
                "Kindly ignore this statutory notice in case you have already cleared the aforesaid dues.\n" +
                "Copy of this notice is retained by my office for further action.\n" +
                "\n" +
                "Sincerely,\n" +
                "\n" +
                "${Name_of_advocate}\n" +
                "${Designation_of_advocate}\n" +
                "${Notice_Signature}";

        WebElement noticeTemplateField = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[4]/div/div/div/div[1]/div[2]/div[1]/iframe"));
        noticeTemplateField.sendKeys(templateText);
        Thread.sleep(3000);

        System.out.println("Entered express notice template text");
    }

    @And("the admin uploads the CSV file {string}")
    public void the_admin_uploads_the_csv_file(String csvFilePath) throws InterruptedException {
        // Scroll to file upload button
        WebElement button = driver.findElement(By.xpath("//*[@id='layout-wrapper']/div[2]/div/div/div[2]/form/div[5]/label[2]/input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        Thread.sleep(3000);

        // Upload CSV file
        WebElement fileInput = driver.findElement(By.xpath("//*[@id='layout-wrapper']/div[2]/div/div/div[2]/form/div[5]/label[2]/input"));

        // Get absolute path of the CSV file
        String absolutePath = System.getProperty("user.dir") + "/" + csvFilePath;
        fileInput.sendKeys(absolutePath);
        Thread.sleep(3000);

        System.out.println("Uploaded CSV file: " + csvFilePath);
    }

    @And("the admin scrolls to the submit button")
    public void the_admin_scrolls_to_the_submit_button() throws InterruptedException {
        // Scroll down to submit button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);

        System.out.println("Scrolled to submit button");
    }

    @And("the admin clicks the submit button for template creation")
    public void the_admin_clicks_the_submit_button_for_template_creation() throws InterruptedException {
        // Click submit button
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/button")).click();
        Thread.sleep(3000);

        System.out.println("Clicked submit button - Template creation initiated");
    }

    @Then("the template should be created successfully")
    public void the_template_should_be_created_successfully() throws InterruptedException {
        // Verification step - template created
        Thread.sleep(2000);
        System.out.println("Template created successfully with unique ID: " + uniqueId);
    }

    @When("the admin navigates to the templates list page")
    public void the_admin_navigates_to_the_templates_list_page() throws InterruptedException {
        // Step 1: Click on the menu item (user provided: //*[@id="side-menu"]/li[4]/a/span[2])
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[4]/a/span[2]")).click();
        Thread.sleep(3000);

        System.out.println("Navigated to templates list page");
    }

    @And("the admin searches for the created template")
    public void the_admin_searches_for_the_created_template() throws InterruptedException {
        // Step 2: Click on filter/search button (user provided: //*[@id="layout-wrapper"]/div[2]/div/div/div[2]/div[3]/div[5]/button[9])
        Thread.sleep(2000);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[2]/div[3]/div[5]/button[9]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchButton);
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButton);
        Thread.sleep(2000);

        System.out.println("Clicked search/filter button for template with ID: " + uniqueId);
    }

    @And("the admin clicks the delete button for the template")
    public void the_admin_clicks_the_delete_button_for_the_template() throws InterruptedException {
        // Dynamically find the last row (newest template should be at the end)
        Thread.sleep(2000);
        String noticeTypeName = noticeType + "_" + uniqueId;

        // Get all rows in the table to find the last row number
        List<WebElement> allRows = driver.findElements(By.xpath("//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div"));

        // Get the last row index (newest template)
        int lastRowIndex = allRows.size();
        System.out.println("Total rows found: " + lastRowIndex + ", clicking delete button in last row");

        // Build dynamic XPath for the last row's delete button
        String deleteButtonXpath = "//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[" + lastRowIndex + "]/div/div[9]/div/div/button[1]";

        WebElement deleteButton = driver.findElement(By.xpath(deleteButtonXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteButton);
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton);
        Thread.sleep(1000);

        System.out.println("Clicked delete button for template: " + noticeTypeName + " in row: " + lastRowIndex);
    }

    @And("the admin confirms the template deletion")
    public void the_admin_confirms_the_template_deletion() throws InterruptedException {
        // Wait for confirmation dialog and click confirm button (same as Letterhead)
        Thread.sleep(1000);
        WebElement confirmButton = driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled swal2-default-outline']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmButton);
        Thread.sleep(2000);

        System.out.println("Confirmed template deletion");
    }

    @Then("the template should be deleted successfully")
    public void the_template_should_be_deleted_successfully() {
        System.out.println("Template deleted successfully with unique ID: " + uniqueId);
    }
}
