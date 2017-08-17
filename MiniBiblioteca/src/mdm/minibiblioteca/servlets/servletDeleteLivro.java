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
 * Servlet implementation class servletDeleteLivro
 */
@WebServlet("/servletDeleteLivro")
public class servletDeleteLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Livro li;
	private String nextPage;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletDeleteLivro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.nextPage = "http://localhost:8080/MiniBiblioteca/index.jsp";
			this.li = new Livro(Integer.parseInt(request.getParameter("idDelete")), request.getParameter("autorDelete"), request.getParameter("tituloDelete")); 
			LivroDao.deleteLivro(li);
			response.sendRedirect(this.nextPage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
