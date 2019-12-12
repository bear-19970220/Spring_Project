import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/11 20:02
 */
public class Log4jTest {

    Logger logger = Logger.getLogger(Log4jTest.class);

    @Test
    public void test() {
        logger.trace("trace 日志");
        logger.debug("bebug 日志");
        logger.info("info 日志");
        logger.warn("warn 日志");
        logger.error("error 日志");
        logger.fatal("fatal 日志");
//        ----------------------

    }


}
