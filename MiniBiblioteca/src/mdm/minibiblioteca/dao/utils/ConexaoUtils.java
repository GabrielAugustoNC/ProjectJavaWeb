package mdm.minibiblioteca.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtils {

	public static Connection criarConexao()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver").newInstance(); // carrega na memoria o drive
		String stringConexao = "jdbc:mysql://127.0.0.1:3306/biblioteca?user=root&password=root"; // string de conexao com o
																								// banco
		Connection conn = DriverManager.getConnection(stringConexao); // instacia o objeto do mysql

		return conn; // retorna a conexão
	}

	public static void fecharConexao(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}

	}
}
