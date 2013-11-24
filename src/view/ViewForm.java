package view;

import java.util.List;

import model.Unit;

public class ViewForm {
   
   private Unit unit;
   private String superUnitName;
   private String superUnitCode;
   private List<String> subUnitCodes;
   
   public Unit getUnit() {
      return unit;
   }

   public void setUnit(Unit unit) {
      this.unit = unit;
   }

   public String getSuperUnitName() {
      return superUnitName;
   }

   public void setSuperUnitName(String superUnitName) {
      this.superUnitName = superUnitName;
   }

   public String getSuperUnitCode() {
      return superUnitCode;
   }

   public void setSuperUnitCode(String superUnitCode) {
      this.superUnitCode = superUnitCode;
   }

   public List<String> getSubUnitCodes() {
      return subUnitCodes;
   }

   public void setSubUnitCodes(List<String> subUnitCodes) {
      this.subUnitCodes = subUnitCodes;
   }
   
}
