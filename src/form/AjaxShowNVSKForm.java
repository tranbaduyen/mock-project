package form;

import org.apache.struts.action.ActionForm;

public class AjaxShowNVSKForm extends ActionForm{

	private int id;
	private int type;
	private int numPost;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getNumPost() {
		return numPost;
	}
	public void setNumPost(int numPost) {
		this.numPost = numPost;
	}
	

	
}
