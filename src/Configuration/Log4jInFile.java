package Configuration;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;

public class Log4jInFile {
	public static Logger LOG = Logger.getLogger(Log4jInFile.class);
	
	public static void LogFunction()
	{
		DateFormat df = new SimpleDateFormat("ddMMyy_HHmmss");
		Date dateobj = new Date();
		String subString = df.format(dateobj);
		String WSpath = System.getProperty("user.dir");
		String LogFilePath = WSpath + "\\Log4jReports\\LogReport_" + subString +".txt";
		
	     // creates pattern layout
        PatternLayout layout = new PatternLayout();
        String conversionPattern = "[%p] %d %c %M - %m%n";
        layout.setConversionPattern(conversionPattern);
		
        DailyRollingFileAppender appender = new DailyRollingFileAppender();
        appender.setFile(LogFilePath);
        appender.setLayout(layout);
		appender.setThreshold(Level.INFO);
		appender.activateOptions();
		
		LOG.addAppender(appender);
		File logfile = new File(LogFilePath);
		String FilePath = logfile.getAbsolutePath();
		System.out.println("Log file path: "+FilePath);
	}

}
