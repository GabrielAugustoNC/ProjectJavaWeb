<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="mdm.minibiblioteca.dao.LivroDao" import="java.util.List"
    import="mdm.minibiblioteca.models.Livro"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Crud com JavaEE</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">
      <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
            <li role="presentation"><a href="#">Home</a></li>
            <li role="presentation"><a href="#" data-toggle="modal" data-target="#modalInsert">Cadastrar Livro</a></li>
          </ul>
        </nav>
        <h3 class="text-muted">Crud com JavaEE</h3>
      </div>

      <div class="jumbotron"> <!--  DIV QUE MOSTRA A LISTA DO BANCO -->
        <center><h2>Livros Cadastrados</h2></center> 
        <!-- Tabela que renderiza os dados do Banco -->
        <div class="table-responsive">
          <table class="table">
            <thead>
              <tr>
                <th>Código do Livro</th>
                <th>Nome do Autor</th>
                <th>Titulo do Livro</th>
              </tr>
            </thead>
            <tbody>
              
              <%
              List<Livro> lista = LivroDao.listaLivros();
              int cont = 1;
              for(Livro livro : lista ) {
            	out.write("<tr>");
            	out.write("<td data-id='"+livro.getId()+"'>"+ livro.getId() +"</td>");
            	out.write("<td data-autor='"+livro.getAutor()+"'>"+ livro.getAutor() +"</td>");
            	out.write("<td data-titulo='"+livro.getTitulo()+"'>"+ livro.getTitulo() +"</td>");
            	out.write("<td><button type='button' class='btn btn-warning .btn-xs' name='btnAlterar' id='btnAlterar' data-toggle='modal' data-target='#modalAlterar'>Alterar</button></td>");
            	out.write("<td><button type='button' class='btn btn-danger .btn-xs' name='btnExcluir' id='btnExcluir' data-toggle='modal' data-target='#modalDelete'>Excluir</button></td>");
            	out.write("</tr>");
            	cont++;
              }	
              %>
            </tbody>
          </table>
        </div>
      </div>


      <!-- Modal INSERT -->
      <div class="modal fade" id="modalInsert" role="dialog">
        <div class="modal-dialog modal-lg">
          <div class="modal-content">
            <!-- Cabecalho do modal -->
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Inserir Livro</h4>
            </div>
            <!-- Corpo do modal -->
            <div class="modal-body">
              <!-- Formulario que vai cuidar de imputar os dadados para o back-end -->
              <form action="servletInsereLivro" method="get">
                <div class="form-group">
                  <label for="idInsert">Código do Livro</label>
                  <input type="text" class="form-control" name="idInsert" id="idInsert">
                </div>
                <div class="form-group">
                  <label for="autorInsert">Nome do Autor</label>
                  <input type="text" class="form-control" name="autorInsert" id="autorInsert">
                </div>
                <div class="form-group">
                  <label for="tituloInsert">Nome do Livro</label>
                  <input type="text" class="form-control" name="tituloInsert" id="tituloInsert">
                </div>
                
              </div>
            <!-- Footer do modal -->
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
              <button type="submit" class="btn btn-success" name="btnSalvar" id="btnSalvar">Salvar</button></td>
            </div>
            </form>
          </div>
        </div>
      </div>



      <!-- Modal ALTERAR -->
      <div class="modal fade" id="modalAlterar" role="dialog">
        <div class="modal-dialog modal-lg">
          <div class="modal-content">
            <!-- Cabecalho do modal -->
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Alterar Livro</h4>
            </div>
            <!-- Corpo do modal -->
            <div class="modal-body">
              <!-- Formulario que vai cuidar de imputar os dadados para o back-end -->
              <form action="servletUpdateLivro" method="get">
                <div class="form-group">
                  <label for="idAlterar">Código do Livro</label>
                  <input type="text" class="form-control" name="idUpdate" id="idUpdate">
                </div>
                <div class="form-group">
                  <label for="autorAlterar">Nome do Autor</label>
                  <input type="text" class="form-control" name="autorUpdate" id="autorUpdate">
                </div>
                <div class="form-group">
                  <label for="tituloAlterar">Nome do Livro</label>
                  <input type="text" class="form-control" name="tituloUpdate" id="tituloUpdate">
                </div>
                
              </div>
            <!-- Footer do modal -->
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
              <button type="submit" class="btn btn-success" name="btnUpdateSalvar" id="btnUpdateSalvar">Salvar</button></td>
            </div>
            </form>
          </div>
        </div>
      </div>


      <!-- Modal DELETE -->
      <div class="modal fade" id="modalDelete" role="dialog">
        <div class="modal-dialog modal-lg">
          <div class="modal-content">
            <!-- Cabecalho do modal -->
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Excluir Livro</h4>
            </div>
            <!-- Corpo do modal -->
            <div class="modal-body">
              <!-- Formulario que vai cuidar de imputar os dadados para o back-end -->
              <form action="servletDeleteLivro" method="get">
                <div class="form-group">
                  <label for="idDelete">Código do Livro</label>
                  <input type="text" class="form-control" name="idDelete" id="idDelete" readonly>
                </div>
                <div class="form-group">
                  <label for="autorDelete">Nome do Autor</label>
                  <input type="text" class="form-control" name="autorDelete" id="autorDelete" readonly>
                </div>
                <div class="form-group">
                  <label for="tituloDelete">Nome do Livro</label>
                  <input type="text" class="form-control" name="tituloDelete" id="tituloDelete" readonly>
                </div>
             </div>
	            <!-- Footer do modal -->
	         <div class="modal-footer">
	         	<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
	            <button type="submit" class="btn btn-success">Confirmar</button></td>
	         </div>
            </form>
          </div>
        </div>
      </div>
      

      <footer class="footer">
        <p>&copy; Desenvolvido por Maycon de Moraes</p>
      </footer>

    </div> <!-- /container -->


    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>

<!-- Script que organiza a logica que comunica com o backend -->
<script type="text/javascript">
  
// Recupera o valor da linha com jquery para o modal alterar
$(function(){
    $(document).on('click', '#btnAlterar', function(e) {
        e.preventDefault;
        var id = $(this).closest('tr').find('td[data-id]').data('id');
        var autor = $(this).closest('tr').find('td[data-autor]').data('autor');
        var titulo = $(this).closest('tr').find('td[data-titulo]').data('titulo');
        
        $('#idUpdate').val(id);
        $('#autorUpdate').val(autor);
        $('#tituloUpdate').val(titulo);
    });
});


// Recupera o valor da linha com jquery para o modal delete
$(function(){
    $(document).on('click', '#btnExcluir', function(e) {
        e.preventDefault;
        var id = $(this).closest('tr').find('td[data-id]').data('id');
        var autor = $(this).closest('tr').find('td[data-autor]').data('autor');
        var titulo = $(this).closest('tr').find('td[data-titulo]').data('titulo');
        
        $('#idDelete').val(id);
        $('#autorDelete').val(autor);
        $('#tituloDelete').val(titulo);
    });
});
</script>

