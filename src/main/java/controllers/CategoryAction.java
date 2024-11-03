package controllers;

import models.Category;
import services.CategoryService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CategoryAction extends Action {

    private CategoryService categoryService = new CategoryService();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");

        if ("add".equalsIgnoreCase(action)) {
            return addCategory(request, mapping);
        } else if ("edit".equalsIgnoreCase(action)) {
            return editCategory(request, mapping);
        } else if ("delete".equalsIgnoreCase(action)) {
            return deleteCategory(request, mapping);
        } else {
            return listCategories(request, mapping);
        }
    }

    private ActionForward addCategory(HttpServletRequest request, ActionMapping mapping) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Category category = new Category(name, description);
        categoryService.addCategory(category);
        return listCategories(request, mapping);
    }

    private ActionForward editCategory(HttpServletRequest request, ActionMapping mapping) {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Category category = new Category(id, name, description);
        categoryService.updateCategory(category);
        return listCategories(request, mapping);
    }

    private ActionForward deleteCategory(HttpServletRequest request, ActionMapping mapping) {
        Long id = Long.parseLong(request.getParameter("id"));
        categoryService.deleteCategory(id);
        return listCategories(request, mapping);
    }

    private ActionForward listCategories(HttpServletRequest request, ActionMapping mapping) {
        request.setAttribute("categories", categoryService.getAllCategories());
        return mapping.findForward("category");
    }
}
