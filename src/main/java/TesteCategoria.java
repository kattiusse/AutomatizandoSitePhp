import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCategoria {
	@Test
	public void CategoriaSucesso() {
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
		driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div/div/a[3]")).click();
		// verifiquei se está na pagina categorias
		Assert.assertEquals("Categorias", driver.findElement(By.className("mt-4")).getText());
		driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div[1]/button/a")).click();
		driver.findElement(By.name("nome")).sendKeys("Vodka");
		driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div/form/div[2]/button"))
				.click();
		String actualMsg = driver.findElement(By.xpath("//html/body/div/div[2]/main/div/div[1]"))
				.getAttribute("innerHTML");
		String correctMsg = "Cadastro realizado com sucesso";
		if (actualMsg.contains(correctMsg)) {
			Assert.assertTrue(correctMsg, true);
		} else {
			Assert.assertTrue(correctMsg, false);
		}
		driver.quit();

	}
		
	@Test
	public void CategoriaSemSucesso() {
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
		driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div/div/a[3]")).click();
		// verifiquei se está na pagina categorias
		Assert.assertEquals("Categorias", driver.findElement(By.className("mt-4")).getText());
		driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div[1]/button/a")).click();
		driver.findElement(By.name("nome")).sendKeys("Vodka");
		driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div/form/div[2]/button"))
				.click();
		String actualMsg = driver.findElement(By.xpath("//html/body/div/div[2]/main/div/div[1]"))
				.getAttribute("innerHTML");
		String correctMsg = "Já existe uma categoria com esse nome";
		if (actualMsg.contains(correctMsg)) {
			Assert.assertTrue(correctMsg, true);
		} else {
			Assert.assertTrue(correctMsg, false);
		}
		driver.quit();
	}
	
}
