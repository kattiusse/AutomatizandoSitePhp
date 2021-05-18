import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFornecedores {
	@Test
	public void CadastroFornecedorSucesso() {
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
		driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div/div/a[5]")).click();
		Assert.assertEquals("Fornecedores", driver.findElement(By.className("mt-4")).getText());
		driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div[1]/button/a")).click();
		driver.findElement(By.name("razao_social")).sendKeys("Bebudss Ltdaa");
		driver.findElement(By.name("nome_fantasia")).sendKeys("Bebuda Sool");
		driver.findElement(By.name("cnpj")).sendKeys("58987456487858");
		driver.findElement(By.name("email")).sendKeys("bebidaus@sol.com");
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
		;

		driver.quit();

	}

	@Test
	public void CadastroFornecedorSemSucesso() {
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
		driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div/div/a[5]")).click();
		Assert.assertEquals("Fornecedores", driver.findElement(By.className("mt-4")).getText());
		driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div[1]/button/a")).click();
		driver.findElement(By.name("razao_social")).sendKeys("Bebidass Ltda");
		driver.findElement(By.name("nome_fantasia")).sendKeys("Bebidass Sosl");
		driver.findElement(By.name("cnpj")).sendKeys("33445830000178");
		driver.findElement(By.name("email")).sendKeys("bebidas@sool.com");
		driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div/form/div[2]/button"))
				.click();
		String actualMsg = driver.findElement(By.xpath("/html/body/div/div[2]/main/div/div[1]"))
				.getAttribute("innerHTML");
		String errorMsg = "Já existe um fornecedor com esse cnpj";
		if (actualMsg.contains(errorMsg)) {
			Assert.assertTrue(errorMsg, true);
		} else {
			Assert.assertTrue(errorMsg, false);
		}
		
		driver.quit();
	}
}
