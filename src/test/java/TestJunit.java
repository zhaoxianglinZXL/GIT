

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        System.out.println("Mabatis逆向生成成功项目配置成功");
	}
	
	/**
	 * 
	 * @作者：ZXL
	 * @时间：2018年11月7日 上午11:35:23
	 * @描述：多线程的使用 
	 */
	public static void main(String[] args) {
		
	}
	
	/**
	 * @作者：ZXL
	 * @时间：2018年11月23日 上午11:30:59
	 * @描述：连接数据库 jdbc
	 */
	public void getConnection(){
		String driver_url = "";
		String username = "";
		String userPassword="";
		String jdbcSql = "";
		try {
			Class.forName(driver_url);
			Connection conn = DriverManager.getConnection(jdbcSql, username, userPassword);
			PreparedStatement pst = conn.prepareStatement("");
			pst.setString(1,"");
			ResultSet rs =  pst.executeQuery();
			pst.executeUpdate();
			rs.close();
			pst.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
