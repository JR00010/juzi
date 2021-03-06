package web.spring.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("web.spring")
@PropertySource("classpath:web/test-dve.propertis")
public class ElconfigDve {
	@Value("I Love You!") //1
	private String normal;
	@Value("#{systemProperties['os.name']}") //2
	private String osName;
	@Value("#{ T(java.lang.Math).random() * 100.0 }") //3
	private double randomNumber;
	@Value("#{demoService.another}") //4
	private String fromAnother;
	@Value("classpath:web/test.txt") //5
	private Resource testFile;
	@Value("http://www.baidu.com") //6
	private Resource testUrl;
	@Value("${book.name}") //7
	private String bookName;
	@Value("${jdbc.url}") //7
	private String url;
	@Autowired
	private Environment environment; //7
	@Bean //7
	public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	public void outputResource() {
		try {
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(randomNumber);
			System.out.println(fromAnother);
			System.out.println(IOUtils.toString(testFile.getInputStream()));
			System.out.println(IOUtils.toString(testUrl.getInputStream()));
			System.out.println(bookName);
			System.out.println(environment.getProperty("book.author"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getNormal() {
		return normal;
	}
	public void setNormal(String normal) {
		this.normal = normal;
	}
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public double getRandomNumber() {
		return randomNumber;
	}
	public void setRandomNumber(double randomNumber) {
		this.randomNumber = randomNumber;
	}
	public String getFromAnother() {
		return fromAnother;
	}
	public void setFromAnother(String fromAnother) {
		this.fromAnother = fromAnother;
	}
	public Resource getTestFile() {
		return testFile;
	}
	public void setTestFile(Resource testFile) {
		this.testFile = testFile;
	}
	public Resource getTestUrl() {
		return testUrl;
	}
	public void setTestUrl(Resource testUrl) {
		this.testUrl = testUrl;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Environment getEnvironment() {
		return environment;
	}
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}

