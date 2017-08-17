package mdm.minibiblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mdm.minibiblioteca.models.Livro;
import mdm.minibiblioteca.dao.utils.ConexaoUtils;

public class LivroDao {
	
	public static void salvaLivro(Livro li) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = ConexaoUtils.criarConexao();
		String sql = "INSERT INTO livro(id, autor, titulo) VALUES(?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, li.getId());
		ps.setString(2, li.getAutor());
		ps.setString(3, li.getTitulo());

		ps.executeUpdate();
		
		ConexaoUtils.fecharConexao(conn);
	}
	
	
	public static List<Livro> listaLivros() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		List<Livro> livros = new ArrayList<Livro>();
		Connection conn = ConexaoUtils.criarConexao();
		Statement stmt = null; 
		String sql = "SELECT * FROM livro;";
		stmt = conn.createStatement();
		ResultSet rs =  stmt.executeQuery(sql);
		while(rs.next()) {
			Livro li = new Livro(rs.getInt("id"), rs.getString("autor"), rs.getString("titulo"));
			livros.add(li);
		}
		ConexaoUtils.fecharConexao(conn);
		return livros;	
	}
	
	public static void updateLivro(Livro li) throws SQLException {
		Connection conn = null;
		try {
			conn = ConexaoUtils.criarConexao();
			PreparedStatement ps = null;
			String sql = "UPDATE livro set id=?, autor=?, titulo=? WHERE id=?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, li.getId());
			ps.setString(2, li.getAutor());
			ps.setString(3, li.getTitulo());
			ps.setInt(4, li.getId());
			
			ps.executeUpdate();
			System.out.println("Alterado com sucesso");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Deu falha ao alterar");
		}		
		ConexaoUtils.fecharConexao(conn);
	}
	
	
	public static void deleteLivro(Livro li) throws SQLException {
		Connection conn = null;
		try {
			PreparedStatement ps = null;
			conn = ConexaoUtils.criarConexao();
			String sql = "DELETE FROM livro WHERE id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, li.getId());
			ps.executeUpdate();
			System.out.println("Deletado com sucesso");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Deu erro ao deletar");
		}
		ConexaoUtils.fecharConexao(conn);
	}
	
	
	
	

}
