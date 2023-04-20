/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Acesso;
import model.EmpresaDAO;
import model.Departamento;

/**
 *
 * @author eddie.mssantos
 */
@WebServlet(name = "Controle", urlPatterns = {"/Controle"})
public class Controle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String flag, mensagem = null;
        flag = request.getParameter("flag");

        if (flag.equals("login")) {
            String user, password;

            user = request.getParameter("usuario");
            password = request.getParameter("senha");
            EmpresaDAO dao = new EmpresaDAO();
            Acesso acesso = dao.validarLogin(user, password);
            if (acesso == null) {
                RequestDispatcher disp = request.getRequestDispatcher("Mensagens.jsp");
                disp.forward(request, response);
            } else {
                String nome, cargo, mensagemc;
                nome = acesso.getFuncionario().getNomeFuncionario();
                cargo = acesso.getFuncionario().getCargoFuncionario();
                mensagem = "Bem vindo " + nome;
                mensagemc = "" + cargo;
                request.setAttribute("m", mensagem);
                request.setAttribute("mc", mensagemc);
                if (cargo.equalsIgnoreCase("Gerente")) {
                    RequestDispatcher disp = request.getRequestDispatcher("AcessoGerente.jsp");
                    disp.forward(request, response);
                } else if (cargo.equalsIgnoreCase("Vendedor")) {
                    RequestDispatcher disp = request.getRequestDispatcher("AcessoVendedor.jsp");
                    disp.forward(request, response);
                } else {
                    RequestDispatcher disp = request.getRequestDispatcher("AcessoOutro.jsp");
                    disp.forward(request, response);
                }
            }

        } else if (flag.equals("cadastroDeparmanto")) {
            String id, nome, fone;

            id = request.getParameter("id");
            nome = request.getParameter("nome");
            fone = request.getParameter("fone");
            Departamento dep = new Departamento();
            dep.setIdDepartamento(id);
            dep.setNomeDepartamento(nome);
            dep.setFoneDepartamento(fone);

            int salvarDepartamento = new EmpresaDAO().salvarDepartamento(dep);
            {
                switch (salvarDepartamento) {
                    case 1: {
                        mensagem = "Tudo certo aqui, cadastro efetuado com Sucesso";
                        break;
                    }
                    case 2: {
                        mensagem = "Este Departamento já esta cadastrado";
                        break;
                    }
                    default: {
                        mensagem = "entre em contado com o ADM xxxxxxxx";
                        break;
                    }
                }
                request.setAttribute("m", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("Mensagens.jsp");
                disp.forward(request, response);
            }
        } else if (flag.equals("listarDepartamentos")) {
            List<Departamento> dep = new EmpresaDAO().listarDepartamentos();
            request.setAttribute("listaDepartamento", dep);
            RequestDispatcher disp = request.getRequestDispatcher("ListarDepartamento.jsp");
            disp.forward(request, response);

        } else if (flag.equalsIgnoreCase("consultarDeparmanto")) {
            String nome = request.getParameter("nome");
            EmpresaDAO dao = new EmpresaDAO();
            List<Departamento> departamentos = dao.consultarDepartamentos(nome);
            request.setAttribute("listaDepartamento", departamentos);
            RequestDispatcher disp = request.getRequestDispatcher("ListarDepartamento.jsp");
            disp.forward(request, response);

        } else if (flag.equalsIgnoreCase("excluirDepartamento")) {
            String idDep = request.getParameter("idDep");
            EmpresaDAO dao = new EmpresaDAO();
            int resultado = dao.excluirDepartamento(idDep);
            switch (resultado) {
                case 1:
                    mensagem = "Departamento excluído com sucesso";
                    break;
                case 2:
                    mensagem = "Departamento não existe";
                    break;
                default:
                    mensagem = "Erro ao tentar excluir o departamento";
                    break;
            }
            request.setAttribute("m", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("Mensagens.jsp");
            disp.forward(request, response);

        } else if (flag.equalsIgnoreCase("AlterarDeparmanto")) {
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String fone = request.getParameter("fone");
            EmpresaDAO dao = new EmpresaDAO();
            int resultado = dao.alterarDepartamento(id, nome, fone);
            if(resultado == 1){
                mensagem = "tudo Certo";
            }else{
                mensagem ="VISH nem te conto";
            }
            
            request.setAttribute("m", mensagem);
            RequestDispatcher disp =  request.getRequestDispatcher("Mensagens.jsp");
            disp.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
