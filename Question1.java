package task22;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Question1 {

	public static void main(String[] args) throws IOException {

		// Open the chrome driver using the Webdriver

		WebDriver driver = new ChromeDriver();

		// Maximize the window

		driver.manage().window().maximize();

		// Navigate to the URL
		driver.get("https://phptravels.com/demo/");

		// Explict wait using the WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Locating the first name text box and sending keys
		WebElement firstName = driver.findElement(By.xpath("//input[@name='first_name']"));

		wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys("Santhosh");

		// Locating the Last Name text box and sending keys
		WebElement lastName = driver.findElement(By.xpath("//input[@name='last_name']"));

		wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys("Kumar");

		// Locating the business name and sending the keys
		WebElement businessName = driver.findElement(By.xpath("//input[@name='business_name']"));

		wait.until(ExpectedConditions.visibilityOf(businessName)).sendKeys("Test Technologies");

		// Locating the email id and sending the keys
		WebElement emailId = driver.findElement(By.xpath("//input[@name='email']"));

		wait.until(ExpectedConditions.visibilityOf(emailId)).sendKeys("tvsanthoshsony@gmail.com");

		// Locating the number1 & number2 & storing in string variable
		String captcha_Number1 = driver.findElement(By.id("numb1")).getText();

		String captcha_Number2 = driver.findElement(By.id("numb2")).getText();

		// Converting the string into integer
		int digit1 = Integer.parseInt(captcha_Number1);

		int digit2 = Integer.parseInt(captcha_Number2);

		// Sum of the digits

		int digit_Result = digit1 + digit2;

		// Converting the integer to string
		String captcha_Result = Integer.toString(digit_Result);

		// Locating the captcha sum text box and sending the result key
		WebElement captcha_Key = driver.findElement(By.id("number"));

		wait.until(ExpectedConditions.visibilityOf(captcha_Key)).sendKeys(captcha_Result);

		// Locating the sumbit button and clicking on it.
		WebElement sumbit = driver.findElement(By.xpath("//button[@id='demo']"));

		wait.until(ExpectedConditions.visibilityOf(sumbit)).click();

		// Locating the submission page

		WebElement submissionMessage = driver.findElement(By.xpath("//strong[text()=' Thank you!']"));

		wait.until(ExpectedConditions.visibilityOf(submissionMessage));

		WebElement textMessage = driver.findElement(By.xpath("//p[@class='text-center cw']"));

		wait.until(ExpectedConditions.visibilityOf(textMessage));

		// Verfying the message in submssion page

		if (submissionMessage.getText().contains("Thank you")) {
			System.out.println("Form is sucessfully submitted :" + textMessage.getText());
		} else {
			System.out.println("Submission is failed");
		}

		// Taking the screenshot of the page
		File capture = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File store = new File("C:\\Users\\santh\\eclipse-workspace\\SampleProject\\target\\phptravels_Screenshot.png");

		FileUtils.copyFile(capture, store);

		// close the browser

		driver.close();

	}

}

//Output:
//Form is sucessfully submitted :We have sent your demo credentials to your email please check your email to test demo website. if message not found inbox please check spam folder
