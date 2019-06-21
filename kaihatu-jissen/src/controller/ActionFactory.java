package controller;



@WebListener
public class ActionFactory implements ServletContextListener {

    private static ServletContext context;
    
    public static Action getAction(String servletPath) throws ServletException {
            
        Action action = null;
        String actionClassName = context.getInitParameter(servletPath);
        
        try {
            action = (Action)Class.forName(actionClassName)
                                       .getDeclaredConstructor().newInstance();
                
        } catch (InstantiationException | IllegalAccessException | 
                 ClassNotFoundException | NoSuchMethodException | 
                 InvocationTargetException e) {
                throw new ServletException(e);
        }
        
        return action;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
}