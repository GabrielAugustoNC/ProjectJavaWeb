package mdm.minibiblioteca.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mdm.minibiblioteca.dao.LivroDao;
import mdm.minibiblioteca.models.Livro;

/**
 * Servlet implementation class servletUpdateLivro
 */
@WebServlet("/servletUpdateLivro")
public class servletUpdateLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Livro li;
	private String nextPage;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletUpdateLivro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.nextPage = "http://localhost:8080/MiniBiblioteca/index.jsp";
			this.li = new Livro(Integer.parseInt(request.getParameter("idUpdate")), request.getParameter("autorUpdate"), request.getParameter("tituloUpdate")); 
			LivroDao.updateLivro(li);
			System.out.println("Livro alterado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao alterar o livro");
		}
		
		
		response.sendRedirect(this.nextPage);
	}

}
