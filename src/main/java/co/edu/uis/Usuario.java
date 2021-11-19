package co.edu.uis;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
    private @Id @GeneratedValue Long id;
    private String name;
    private String lang;
    
    
    public Usuario() {
    	
    }
    
	/**
	 * @param id
	 * @param name
	 * @param lang
	 */
	public Usuario(String name, String lang) {
		this.name = name;
		this.lang = lang;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}
	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}
    
    @Override
    public boolean equals(Object o) {
    	if (this==o) return true;
    	
    	if(!(o instanceof Usuario)) return false;
    	
    	Usuario u = (Usuario) o;
    	
    	return (comparar(u));
    }
    
    private boolean comparar (Usuario u) {
    	if(u.id==this.id && u.lang== this.lang && u.name==this.name) {
    		return true;
    	}
    	return false;
    }
}
