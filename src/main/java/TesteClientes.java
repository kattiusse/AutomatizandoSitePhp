import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteClientes {
	@Test
	public void CadastroClienteSucesso() {
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
		driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div/div/a[4]")).click();
		
		Assert.assertEquals("Clientes", driver.findElement(By.className("mt-4")).getText());
		driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div[1]/button/a")).click();
		driver.findElement(By.name("nome")).sendKeys("Adega Santos");
		driver.findElement(By.name("email")).sendKeys("adegasantos@hmail.com");
		driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div/form/div[2]/button"))
				.click();
		String actualMsg = driver.findElement(By.xpath("/html/body/div/div[2]/main/div/div[1]"))
				.getAttribute("innerHTML");
		String errorMsg = "Cadastro realizado com sucesso";
		if (actualMsg.contains(errorMsg)) {
			Assert.assertTrue(errorMsg, true);
		} else {
			Assert.assertTrue(errorMsg, false);
		driver.quit();
		}
	}

	@Test
	public void CadastroClienteSemSucesso() {
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
		driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div/div/a[4]")).click();
		Assert.assertEquals("Clientes", driver.findElement(By.className("mt-4")).getText());
		driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div[1]/button/a")).click();
		driver.findElement(By.name("nome")).sendKeys("Adega Santos");
		driver.findElement(By.name("email")).sendKeys("aedgasantos@hmail.com");
		driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div/form/div[2]/button"))
				.click();
		String actualMsg = driver.findElement(By.xpath("/html/body/div/div[2]/main/div/div[1]"))
				.getAttribute("innerHTML");
		String errorMsg = "Já existe um cliente com esse email";
		if (actualMsg.contains(errorMsg)) {
			Assert.assertTrue(errorMsg, true);
		} else {
			Assert.assertTrue(errorMsg, false);
		}
		driver.quit();
	}
}
		