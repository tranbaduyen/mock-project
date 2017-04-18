package form;

import org.apache.struts.action.ActionForm;

public class AjaxNhanVatSuKienForm extends ActionForm{

	private int id;

	private int type;
	
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
	
	
}
