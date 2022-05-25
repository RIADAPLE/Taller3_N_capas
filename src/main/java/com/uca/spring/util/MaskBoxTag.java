package com.uca.spring.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaskBoxTag extends SimpleTagSupport {

    private String id;
    private String name;
    private String tabindex;
    private String required;
    private String readonly;
    private String mask;
    private String value;

    @Override
    public void doTag() throws JspException, IOException {
        StringBuilder scriptBuilder = new StringBuilder();
        try {
            scriptBuilder.append(" <input type=\"text\" ");
            
            if (id != null && !id.trim().equals("")) {
                scriptBuilder.append("id=\"").append(id).append("\" ");
            }
            
            if (mask != null && !mask.trim().equals("")) {
                scriptBuilder.append(" data-masked data-inputmask=\"'mask': '").append(mask).append("'\" ");
            }

            if (name != null && !name.trim().equals("")) {
                scriptBuilder.append(" name=\"").append(name).append("\"");
            }

            if (required != null && required.trim().equals("true")) {
                scriptBuilder.append(" required=\"").append(required).append("\" ");
            }

            if (tabindex != null && !tabindex.trim().equals("")) {
                scriptBuilder.append(" tabindex=\"").append(tabindex).append("\" ");
            }

            if (readonly != null && readonly.trim().equals("true")) {
                scriptBuilder.append(" readonly=\"true\" ");
            }
            
             if (value != null && !value.trim().equals("")) {
                scriptBuilder.append(" value=\"").append(value).append("\"");
            }

            scriptBuilder.append(" class=\"form-control\" >\n");
            scriptBuilder.append("<script>\n");
            scriptBuilder.append("$('#"+id+"').inputmask();\n");
            scriptBuilder.append("</script>\n");
            getJspContext().getOut().write(scriptBuilder.toString());

        } catch (Exception ex) {
            getJspContext().getOut().write("error textbox");
        }
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTabindex() {
		return tabindex;
	}

	public void setTabindex(String tabindex) {
		this.tabindex = tabindex;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}


