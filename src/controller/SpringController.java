package controller;

import javax.annotation.Resource;

import model.Unit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import view.AddForm;
import view.SearchForm;
import view.ViewForm;
import database.Dao;

@Controller
public class SpringController {

   @Resource
   private Dao dao;

   @RequestMapping(value = "/search", method = RequestMethod.GET)
   public String viewSearch(@RequestParam(value = "searchString", required = false) String searchString, ModelMap mm) {
      mm.clear();
      
      if (searchString == null || searchString.equals("")) {
         mm.addAttribute("searchResults", dao.findAllUnits());
      } else {
         mm.addAttribute("searchResults", dao.search(searchString));
      }
      
      mm.addAttribute("searchForm", new SearchForm());

      return "search";
   }
   @RequestMapping(value = "/search", method = RequestMethod.POST)
   public String doSearch(@ModelAttribute("search") SearchForm search, ModelMap mm) {
      mm.clear();
      mm.addAttribute("searchString", search.getSearchString());

      return "redirect:/search";
   }

   @RequestMapping(value = "/view/{code}", method = RequestMethod.GET)
   public String viewUnit(@PathVariable("code") String code, ModelMap mm) {
      mm.clear();

      Unit unit = dao.findUnitByCode(code);
      
      ViewForm viewForm = new ViewForm();
      viewForm.setUnit(unit);
      viewForm.setSubUnitCodes(dao.getSubUnitCodes(unit.getId().toString()));
      viewForm.setSuperUnitName("");
      viewForm.setSuperUnitCode("");

      if(unit.getSuper_unit_id() != null) {
         Unit superunit = dao.findUnitById(unit.getSuper_unit_id());
         mm.addAttribute("superUnitName", superunit.getName());
         mm.addAttribute("superUnitCode", superunit.getCode());
      }
      
      mm.addAttribute("viewForm", viewForm);

      return "view";
   }

   @RequestMapping(value = "/addForm", method = RequestMethod.GET)
   public String viewAdd(ModelMap mm) {
      mm.clear();

      mm.addAttribute("unitList", dao.findAllUnits());

      return "add";
   }
   @RequestMapping(value = "/addForm", method = RequestMethod.POST)
   public String addUnit(AddForm addForm) {
      
      Unit unit  = new Unit();
      unit.setName(addForm.getName());
      unit.setCode(addForm.getCode());

      if(!addForm.getSuperUnitCode().equals("")) {
         unit.setSuper_unit_id(dao.findUnitByCode(addForm.getSuperUnitCode()).getId());
      } else {
         unit.setSuper_unit_id(null);
      }

      dao.addItem(unit);

      return "redirect:/search";
   }

   @RequestMapping(value="/delete/{code}")
   public String deleteUnit(@PathVariable("code") String code) {
      dao.deleteUnitByCode(code);
      return "redirect:/search";
   }

   @RequestMapping(value="/admin/clearData")
   public String deleteAll() {
      dao.deleteAll();
      return "redirect:/search";
   }

   @RequestMapping(value = "/")
   public String index() {
      return "redirect:/search";
   }
}
