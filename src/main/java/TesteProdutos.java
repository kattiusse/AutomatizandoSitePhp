import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteProdutos {
	// @Before
	@Test
	public void testeProdutosSucesso() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Windows\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost/adega/templates/login.php");
		System.out.println(driver.getTitle());
		Assert.assertEquals("Adega Kachorro Preto", driver.getTitle());
		driver.findElement(By.name("email_login")).sendKeys("usuario.teste@gmail.com");
		driver.findElement(By.name("senha")).sendKeys("123456");
		driver.findElement(
				By.xpath("//*[@id=\"layoutAuthentication_content\"]/main/div/div/div/div/div[2]/form/div[3]/button"))
				.click();
		// verifiquei se entrou na pagina
		Assert.assertEquals("Adega Kachorro Preto", driver.findElement(By.className("mt-4")).getText());
		driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div/div/a[6]")).click();
		Assert.assertEquals("Produtos", driver.findElement(By.className("mt-4")).getText());
		driver.findElement(By.xpath("/html/body/div/div[2]/main/div/div/div/div/div[1]/button/a")).click();

		WebElement element = driver.findElement(
				By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div/form/div[1]/div[1]/div/select"));
		Select combo = new Select(element);
		combo.selectByValue("27");

		WebElement element1 = driver.findElement(
				By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div/form/div[1]/div[2]/div/select"));
		Select combo1 = new Select(element1);
		combo1.getOptions();
		combo1.selectByValue("6");
		driver.findElement(By.name("nome")).sendKeys("Cerveja Amstel");
		driver.findElement(By.name("descricao")).sendKeys("700ml");
		driver.findElement(By.name("quantidade")).sendKeys("5");
		driver.findElement(By.name("preco")).sendKeys("80,00");
		driver.findElement(By.xpath("/html/body/div/div[2]/main/div/div/div/div/div/form/div[2]/button")).click();

		String actualMsg = driver.findElement(By.xpath("//html/body/div/div[2]/main/div/div[1]"))
				.getAttribute("innerHTML");
		String correctMsg = "Cadastro realizado com sucesso";
		if (actualMsg.contains(correctMsg)) {
			Assert.assertTrue(correctMsg, true);
		} else {
			Assert.assertTrue(correctMsg, false);
		}
		;

		driver.quit();

	}
}
