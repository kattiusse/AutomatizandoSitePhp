import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteLogin {
	@Test
	public void loginCadastroSucesso() {
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
		// cliquei em usuários
		driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div/div/a[2]")).click();
		// verifiquei se está na pagina usuarios
		Assert.assertEquals("Usuários", driver.findElement(By.className("mt-4")).getText());
		// cliquei no botão adicionar
		driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div[1]/button/a")).click();
		// inserindo usuário
		driver.findElement(By.name("nome")).sendKeys("Bianca Lima");
		driver.findElement(By.name("login")).sendKeys("bianca.lima4");
		driver.findElement(By.name("email")).sendKeys("biakattiusselima@htm.com");
		WebElement element = driver.findElement(
				By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div/form/div[2]/div[2]/div/select"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Usuário");
		Assert.assertEquals("Usuário", combo.getFirstSelectedOption().getText());
		driver.findElement(By.name("senha")).sendKeys("123456");
		driver.findElement(By.name("confirm_senha")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div/form/div[4]/button"))
				.click();
		// cadastro com sucesso
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
	public void loginCadastroSemSucesso() {
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
		// cliquei em usuários
		driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div/div/a[2]")).click();
		// verifiquei se está na pagina usuarios
		Assert.assertEquals("Usuários", driver.findElement(By.className("mt-4")).getText());
		// cliquei no botão adicionar
		driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div[1]/button/a")).click();
		// inserindo usuário
		driver.findElement(By.name("nome")).sendKeys("Bianca Lima");
		driver.findElement(By.name("login")).sendKeys("bianca.lima4");
		driver.findElement(By.name("email")).sendKeys("biakattiusselima@hotm.com");
		WebElement element = driver.findElement(
				By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div/form/div[2]/div[2]/div/select"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Usuário");
		Assert.assertEquals("Usuário", combo.getFirstSelectedOption().getText());
		driver.findElement(By.name("senha")).sendKeys("123456");
		driver.findElement(By.name("confirm_senha")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/div/form/div[4]/button"))
				.click();
		// cadastro com sucesso
		String actualMsg = driver.findElement(By.xpath("/html/body/div/div[2]/main/div/div[1]"))
				.getAttribute("innerHTML");
		String errorMsg = "Já existe um usuário com esse login";
		if (actualMsg.contains(errorMsg)) {
			Assert.assertTrue(errorMsg, true);
		} else {
			Assert.assertTrue(errorMsg, false);
		driver.quit();
		}
	}

}