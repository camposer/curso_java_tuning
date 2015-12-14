package rest.editor;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) {
		try {
			long milliseconds = Long.parseLong(text);
			this.setValue(new Date(milliseconds));
		} catch (NumberFormatException e) {
		}
	}

	@Override
	public String getAsText() {
		Date date = (Date) this.getValue();
		return date != null ? Long.toString(date.getTime()) : "";
	}
}
