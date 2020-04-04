package tags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FormattedDate extends SimpleTagSupport {
	private String format;

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		try {
			SimpleDateFormat sd = new SimpleDateFormat(format);
			out.println(sd.format(new Date()));
		} catch (java.io.IOException ex) {
			throw new JspException(ex.getMessage());
		}
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
