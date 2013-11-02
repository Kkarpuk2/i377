package model;

import javax.persistence.*;

@Entity
public class Unit {

   @Id
   @SequenceGenerator(name = "my_seq", sequenceName = "seq1", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
   private Long id;
   
   private String name;
   private String code;
   private Long super_unit_id;

   public Long getId() {
      return id;
   }
   public void setId(Long id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getCode() {
      return code;
   }
   public void setCode(String code) {
      this.code = code;
   }
   public Long getSuper_unit_id() {
      return super_unit_id;
   }
   public void setSuper_unit_id(Long super_unit_id) {
      this.super_unit_id = super_unit_id;
   }
   @Override
   public String toString() {
      return "\nUnit [id=" + id + ", name=" + name + ", code=" + code
            + ", super_unit_id=" + super_unit_id + "]";
   }
}