package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//커넥션 툴 방식, 커넥션을 여러개 만들어놓고 각각 할당시키기
	@Test
	public void testConn() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","book_ex","book_ex");
			log.info("connect: " + conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
