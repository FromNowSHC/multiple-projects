package log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author shc
 * @date 2018-09-12
 **/
public class LogFour {

    private static Logger logger = Logger.getLogger(LogFour.class);

    public static void main(String[] args) throws Exception{
        PropertyConfigurator.configure("F:\\Code\\mycode\\multiple-projects\\java-research-code\\src\\log4j.properties");
        logger.setLevel(Level.DEBUG);
        logger.trace("跟踪信息");
        logger.debug("调试信息");
        logger.info("输出信息");
        logger.warn("警告信息");
        logger.error("错误信息");
        logger.fatal("致命信息");
    }
}
