package calcu;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/calcu"})
public class ServletCalcula extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        double resultado= 0;
        
        int numA= Integer.parseInt(request.getParameter("numA"));
        int numB= Integer.parseInt(request.getParameter("numB"));
        if(request.getParameter("suma") != null){
            resultado= numA + numB;
        }else{
            if(request.getParameter("resta") != null){
                resultado= numA - numB;
            }else{
                if(request.getParameter("multiplica") != null){
                    resultado= numA * numB;
                }else{
                    if(request.getParameter("divide") != null){
                        resultado= numA/numB;
                    }
                }
            }
                    
        }
        
        PrintWriter out = new PrintWriter(response.getOutputStream());
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet SevletCalcula</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>El resultado es: " +resultado+ " </h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
