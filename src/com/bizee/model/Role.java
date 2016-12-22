package com.bizee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Role")
public class Role implements Serializable{
	
	

		private static final long serialVersionUID = -723583058586873479L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "Roleid")
		private Integer roleId;
		
		@Column(name="Rolename")
		private String roleName;

		public Integer getRoleId() {
			return roleId;
		}

		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}

		public String getRoleName() {
			return roleName;
		}

		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}

		@Override
		public String toString() {
			return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
		}

}
