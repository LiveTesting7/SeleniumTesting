package com.bse;

import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Actions action;
	public static JavascriptExecutor javascriptExecutor;
	public static Alert alert;
	public static Robot robot;

	public void launchBrowser() {

//	    WebDriverManager.chromedriver().driverVersion("116.0.5845.96").setup();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Kiran\\eclipse-workspace\\Maven_Intro_Installation\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public void firefoxLaunchBrowser() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

	}

	public void EdgeBrowser() {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static void refreshWindow() {
		driver.navigate().refresh();
	}

	public static void urlLaunching(String url) {
		driver.get(url);
	}

	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String pageUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	public static void sendText(WebElement ele, String text) {
		ele.sendKeys(text);
	}

	public static void clickElement(WebElement ele) {
		ele.click();

	}

	public static void closeBrowser() {
		driver.quit();

	}

	public static void closeTab() {
		driver.close();

	}

	public static void screenshot(String filePathName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(filePathName);
		FileUtils.copyFile(screenshotAs, file);

	}

	public static void moveElement(WebElement ele) {

		action = new Actions(driver);
		action.moveToElement(ele).perform();

	}

	public static void dragDrop(WebElement drag, WebElement drop) {
		action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform();

	}

	public static void doubleClick(WebElement ele) {
		action = new Actions(driver);
		action.doubleClick(ele).perform();

	}

	public static void rightClick(WebElement ele) {
		action = new Actions(driver);
		action.contextClick(ele).perform();

	}

	public static void javaScriptClick(WebElement ele) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", ele);

	}

	public static void javaScriptSetValue(WebElement ele, String text) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].setAttribute('value','" + text + "')", ele);

	}

	public static Object javaScriptGetValue(WebElement ele, String text) {
		javascriptExecutor = (JavascriptExecutor) driver;
		Object executeScript = javascriptExecutor
				.executeScript("return arguments[0].getAttribute('value','" + text + "')", ele);
		return executeScript;
	}

	public static void javaScriptScrollTextBottom(WebElement ele) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", ele);

	}

	public static void javaScriptScrollTextTop(WebElement ele) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)", ele);

	}

	public static void alertAccept() {

		alert = driver.switchTo().alert();
		alert.accept();

	}

	public static void alertDismiss(WebElement ele) {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public static String alertGetText() {
		alert = driver.switchTo().alert();
		String text = alert.getText();

		return text;
	}

	public static void alertSendText(String text) {
		alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}

	public static void switchFrame(WebElement selectorText) {
		driver.switchTo().frame(selectorText);

	}

	public static void windowHandle() throws InterruptedException {
		String primary = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String Secondary : windowHandles) {
			if (Secondary != primary) {
				driver.switchTo().window(Secondary);
			}
		}

	}

	public static void keyDown(int times) throws InterruptedException {

		for (int i = 0; i < times; i++) {
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void excelRead(String workBookName, String sheetName, int rowNo, int cellNo) throws IOException {
		File file = new File("C:\\Users\\Kiran\\eclipse-workspace\\DataDriven_framework\\Excel\\" + workBookName);

		// Read the file
		FileInputStream fileInputStream = new FileInputStream(file);

		// Read.xlsx file
		Workbook xssfWorkbook = new XSSFWorkbook(fileInputStream);

		// To fetch the sheet
		Sheet sheet = xssfWorkbook.getSheet(sheetName);

		// To fetch the all column values

		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int cellType = cell.getCellType();
		if (cellType == 1) {
			String stringCellValue = cell.getStringCellValue();
			System.out.println(stringCellValue);

		} else if (DateUtil.isCellDateFormatted(cell)) {

			Date dateCellValue = cell.getDateCellValue();

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
			String format = dateFormat.format(dateCellValue);
			System.out.println(format);

		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			String valueOf = String.valueOf(l);
			System.out.println(valueOf);

		}

	}

	public static void createNewExcelFile(String sheetName) throws IOException {
		File file = new File("C:\\Users\\Kiran\\eclipse-workspace\\DataDriven_framework\\Excel\\Sample3.xlsx");
		Workbook workbook = new XSSFWorkbook();
		Sheet createSheet = workbook.createSheet(sheetName);
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		System.out.println(createSheet);
	}

	public static void createCell(String sheetName, int rowNo, int cellNo, String value) throws IOException {

		File file = new File("C:\\Users\\Kiran\\eclipse-workspace\\DataDriven_framework\\Excel\\Sample3.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
		Sheet createSheet = xssfWorkbook.getSheet(sheetName);
		Row getRow = createSheet.getRow(rowNo);
		Cell createCell = getRow.createCell(cellNo);
		createCell.setCellValue(value);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		xssfWorkbook.write(fileOutputStream);

	}

	public static void createRow(String sheetName, int rowNo, int cellNo, String value) throws IOException {

		File file = new File("C:\\Users\\Kiran\\eclipse-workspace\\DataDriven_framework\\Excel\\Sample3.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
		Sheet getSheet = xssfWorkbook.getSheet(sheetName);
		Row getRow = getSheet.createRow(rowNo);
		Cell createCell = getRow.createCell(cellNo);
		createCell.setCellValue(value);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		xssfWorkbook.write(fileOutputStream);

	}
}
