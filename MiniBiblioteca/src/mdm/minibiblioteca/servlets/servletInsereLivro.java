package mdm.minibiblioteca.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mdm.minibiblioteca.dao.LivroDao;
import mdm.minibiblioteca.models.Livro;

/**
 * Servlet implementation class servletInsereLivro
 */
@WebServlet("/servletInsereLivro")
public class servletInsereLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Livro li;
	private String nextPage;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletInsereLivro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.nextPage = "http://localhost:8080/MiniBiblioteca/index.jsp";
			li = new Livro(Integer.parseInt(request.getParameter("idInsert")), request.getParameter("autorInsert"), request.getParameter("tituloInsert"));
			LivroDao.salvaLivro(li);
			System.out.println("Salvou o livro no banco");
			response.sendRedirect(this.nextPage);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Deu erro ao salvar o livro no banco!");
			e.printStackTrace();
		}
	}

}
