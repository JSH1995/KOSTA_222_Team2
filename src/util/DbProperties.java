package util;

/**
 * DB설정 정보를상수필드로 관리
 * */
public interface DbProperties {
    public static final String DRIVER_NAME ="oracle.jdbc.driver.OracleDriver";
    String URL="jdbc:oracle:thin:@moviement.c7vnh8cytupl.us-east-2.rds.amazonaws.com:1521:ORCL";
    String USER_ID="admin";
    String USER_PASS="admin123";
    
}
