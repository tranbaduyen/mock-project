package form;

import org.apache.struts.action.ActionForm;

public class AjaxShowBinhLuanFrom extends ActionForm{

	private int id;
	private int type;
	private int numComment;
	
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
	public int getNumComment() {
		return numComment;
	}
	public void setNumComment(int numComment) {
		this.numComment = numComment;
	}
	
	
	
}
