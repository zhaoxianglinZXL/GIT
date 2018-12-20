package com.weina;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class TestJunit {
	@Test
	public void say() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
	    String rootPath=this.getClass().getResource("/generatorConfig.xml").getFile().toString();   
	    System.out.println(rootPath);
		List<String> warnings = new ArrayList<String>();  
        boolean overwrite = true;  
        File configFile = new File(rootPath); 
        ConfigurationParser cp = new ConfigurationParser(warnings);  
        Configuration config = cp.parseConfiguration(configFile);  
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);  
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);  
        myBatisGenerator.generate(null);  
        System.out.println("maven项目配置成功");
	}
	
}
