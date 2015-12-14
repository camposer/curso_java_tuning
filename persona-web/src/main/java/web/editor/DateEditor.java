package web.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateEditor extends PropertyEditorSupport {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Date fecha = null;
		
		try {
			fecha = sdf.parse(text);
		} catch (ParseException e) { }
		
		setValue(fecha);
	}

	@Override
	public String getAsText() {
		String text = null;
		
		try {
			text = sdf.format(getValue());
		} catch (Exception e) { }
		
		return text;
	}
}
