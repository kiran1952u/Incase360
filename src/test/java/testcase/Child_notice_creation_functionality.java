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
import utilities.Login_functionality;

public class Child_notice_creation_functionality {

    private static final Logger log = LoggerFactory.getLogger(Standard_Template_notice_creation.class);

    @Test(dataProvider = "userData")
    public void Addnewnotice(String noticeType, String noticeDescription ,String noticetemplate) throws InterruptedException {
        // Set up ChromeDriver with options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        Login_functionality test = new Login_functionality();
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
        noticeTemplateField.sendKeys(noticetemplate);
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
                {"Test_font_test8", "Test_font_test9","संदर्भ: Notice ID --notice_ID--\t\t                                   दिनांक: --date_of_notice-- \n" +
                        "\n" +
                        "सेवा में,   \n" +
                        "\t\t\t\t\t\t\t\n" +
                        "--Full_name_of_primary_respondent-- \n" +
                        "--Status_of_primary_respondent-- \n" +
                        "--Full_address_of_primary_respondent-- \n" +
                        "--Email_ID_of_primary_respondent-- \n" +
                        "--WhatsApp_of_primary_respondent--; \n" +
                        "\n" +
                        "--Coborrower_one--\n" +
                        "--Coborrower_one_email--, --Coborrower_one_mobile--\t\n" +
                        "\n" +
                        "--Coborrower_two--\n" +
                        "--Coborrower_two_email--, --Coborrower_two_mobile--\n" +
                        "\n" +
                        "--Coborrower_three--\n" +
                        "--Coborrower_three_email--, --Coborrower_three_mobile--\n" +
                        "\n" +
                        "--Details_of_other_respondent--\n" +
                        "--Email_ID_of_other_respondent--\n" +
                        "--WhatsApp_of_other_respondent--\n" +
                        "\n" +
                        "\t\t                     विषयः   वर्तमान बकाया राशि  एवं मांग पत्र।\n" +
                        "                                  \tसंदर्भ:   ऋण अनुबंध संख्या: --agreement_number--, ऋण तिथि: --disbursal_date-- \n" +
                        "श्रीमान/श्रीमती,\n" +
                        "\n" +
                        "आपने नए/पुराने वाहन/संपत्ति  --vehicle_equipment_asset_description--,  की खरीद के लिए बैंक से ऋण लिया है और एक ऋण अनुबंध संख्या  --agreement_number--, दिनांक --disbursal_date-- को  निष्पादित किया है । तदनुसार, आपने  --vehicle_equipment_asset_description--,  , इंजन नं. --engine_no--, चास्सिस संख्या --chassis_no--, पंजीकरण संख्या --registration_no--, की खरीदारी  हमारे द्वारा वितरित ऋण राशि से की है।\n" +
                        "\n" +
                        "उक्त समझौते के नियमों और शर्तों के अनुसार, आप हमसे किसी भी अनुवर्ती कार्रवाई के बिना नियत तिथि पर किश्तों का भुगतान करने के लिए बाध्य हैं। अनुबंध की शर्तों के विपरीत, आपने समान मासिक किश्तों के भुगतान में चूक की है। \n" +
                        "\n" +
                        "हम आपको सूचित करते हैं कि आप  रु. --total_outstanding_amount--/- जो दिनांक --outstanding_as_on-- तक  देय  है, उसका भुगतान करने के लिए उत्तरदायी  हैं।  इसके अलावा, आप अनुबंध की शर्तों के अनुसार, बकाया  राशि का भुगतान होने तक अतिरिक्त ब्याज शुल्क और अन्य शुल्कों के लिए भी उत्तरदायी हैं। आपसे अनुरोध है कि इस नोटिस की तिथि से 7 दिनों के भीतर हमारे कार्यालय में उक्त राशि का भुगतान करें। अन्यथा बैंक आपके विरुद्ध उचित कार्रवाई शुरू करने के लिए बाध्य होगा, जिसमें संविदात्मक (भुगतान साधन विफलता कार्रवाई) (यदि कोई हो) और/या संपत्ति/वाहन  को वापस लेने की कार्रवाई शामिल है  और उसकी सभी लागतों और परिणामों के लिए आप जिम्मेदार होंगे।\n" +
                        "\n" +
                        "कृपया यह भी सुनिश्चित करें कि भविष्य के सभी भुगतान समझौते की पारस्परिक रूप से सहमत पुनर्भुगतान अनुसूची के अनुसार समय पर किए जाएं।\n" +
                        "\n" +
                        "किसी भी प्रश्न या भुगतान के लिए आप हमारे ईमेल आईडी :  reach4loan@indusind.com , अथवा  टोल फ्री नंबर: 18001023333 पर संपर्क कर सकते हैं। \n" +
                        "\n" +
                        "धन्यवाद सहित\n" +
                        "इंडसइंड बैंक लिमिटेड\n" +
                        "अधिकृत हस्ताक्षरकर्ता\n" +
                        "\n" +
                        "\n"},
//                {"Test_font_test10", "Test_font_test11"},
//                {"Test_font_test12", "Test_font_test13"},
//                {"Test_font_test14", "Test_font_test15"},
//                {"Test_font_test16", "Test_font_test17"}
//
        };
    }
}
