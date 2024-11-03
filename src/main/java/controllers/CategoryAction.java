package controllers;

import java.util.List;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Category;
import services.CategoryService;


public class CategoryAction extends Action {

    private CategoryService categoryService = new CategoryService();
    

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	System.out.println("Executing CategoryAction");
    	
        String action = request.getParameter("action");

        if ("add".equalsIgnoreCase(action)) {
        	System.out.println("add action");
            return addCategory(request, mapping);
        } else if ("edit".equalsIgnoreCase(action)) {
         	System.out.println("edit action");
            return editCategory(request, mapping);
        } else if ("delete".equalsIgnoreCase(action)) {
         	System.out.println("delete action");
            return deleteCategory(request, mapping);
        } else {
         	System.out.println("else action");
            return listCategories(request, mapping);
        }
    }

    private ActionForward listCategories(HttpServletRequest request, ActionMapping mapping) {
    	
        System.out.println("listCategories action");
        
        List<Category> categories = categoryService.getAllCategories();
        
        System.out.println("Categories: " + categories);

        request.setAttribute("categories", categories);
        
        return mapping.findForward("category");
    }
    
    private ActionForward addCategory(HttpServletRequest request, ActionMapping mapping) {
     	System.out.println("addCategory action");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Category category = new Category(name, description);
        categoryService.addCategory(category);
        return listCategories(request, mapping);
    }

    private ActionForward editCategory(HttpServletRequest request, ActionMapping mapping) {
     	System.out.println("editCategory action");
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Category category = new Category(id, name, description);
        categoryService.updateCategory(category);
        return listCategories(request, mapping);
    }

    private ActionForward deleteCategory(HttpServletRequest request, ActionMapping mapping) {
     	System.out.println("deleteCategory action");
        Long id = Long.parseLong(request.getParameter("id"));
        categoryService.deleteCategory(id);
        return listCategories(request, mapping);
    }
//
//    private ActionForward listCategories(HttpServletRequest request, ActionMapping mapping) {
//     	System.out.println("listCategories action");
//        request.setAttribute("categories", categoryService.getAllCategories());
//        return mapping.findForward("category");
//    }
}
