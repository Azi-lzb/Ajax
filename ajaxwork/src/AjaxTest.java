import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet({"/query","/queryall"})
public class AjaxTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        String servletPath = req.getServletPath();
        resp.setContentType("application/json;charset=utf-8");
        if ("/query".equals(servletPath)){
            doQuery(req,resp);
        }else if ("/queryall".equals(servletPath)){
            System.out.println("query.jsp");
            List<Dept> deptList=null;
            try {
                deptList = Util.search();
            req.setAttribute("deptList",deptList);
            req.getRequestDispatcher("/query.jsp").forward(req,resp);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void doQuery(HttpServletRequest req, HttpServletResponse resp)  {
        try{PrintWriter writer = resp.getWriter();
        String no = req.getParameter("no");
        int realNo =  parseInt(no);
        Dept dept =null;
        dept = Util.search(realNo);
        ObjectMapper om=new ObjectMapper();
        String json = om.writeValueAsString(dept);
        writer.print(json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
