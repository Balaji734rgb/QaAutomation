class BaseClass 
{
	public WebDriver driver;
	fileutils files=new FileUtils();
	PropertyData propert=new PropertyData();
	ExcelData ecxeldata =new ExcelData ();
	JavaUtils javautils=new JavaUtils();


	@BeforeSuite
		public void beforesuite(){
        ExtentReports.initReports();
		}
    @AfterSuite
	public void afterSuite(){
    ExtentReports.flushReports();
	}
@BeforeMethod
	public void configureBeforeMethod(){
    String browsername=fileUtils.readpropertyData(driver "browsername");
	if(browsername.equals("chrome"){
		Options option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		 driver=new Chromedriver(option);
	}
    else if(browsername.equals("firefox")
	{
		WebDriver driver=new Firefox(driver);
	}
     driver.mabnage.window.maximize();
	 driver.get(fileutils.readpropertydata(driver "url"));
	}
@AfterMethod
	public void configureAftermethod(ITestResults res){
    int status=res.getstatus();
	System.out.println(status);
	String status=res.getstausname();
if(status==2){
	ExtentReport.test.Fail(markuphelper.createlabel("<h1><b>  +"name"+ Test is fail some exception look into test ng report for the descption </h1></b>"))


}


	}

}


public class ExcelUtility
{

	public String readstringExcelvalue(WebDriver driver,String SheetName ,int RowNum,int cellNum){
		
    FileInputStream fis=new FileinputStream("./src/test/resourcess/TestData.xlxs");
	WorkBook workbook=WorkBookFactory.create(fis);
   String celldatavalue=workbook.getsheet(sheetname).getcellnum(cellnum).getrownum(rowNum).getStringcellvalue();
   workbookClose();
   return CellDatavalue();

	}
	public double readnumaricExcelvalue(WebDriver driver,int RowNum,String SheetName,int Cellnum){
		
Fileinputstream fis=new FileinputStream("./src/test/resources/TestData.xlsx");
Workbook workbook=WorkBookfactory.create(fis);
double Celldatavalue=workbook.getsheet(sheetname).getrow(RowNum).getcell(cellNum).getcelldataValue();
workBook.close();
return CellDataValue;

	}
}