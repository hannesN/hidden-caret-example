package carettest;

import javax.inject.Inject;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.ViewPart;

public class View extends ViewPart {
	public static final String ID = "CaretTest.view";

	@Inject
	IWorkbench workbench;

	private Browser browser;

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout());
		browser = new Browser(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(browser);
		browser.setUrl("https://www.free-freecell-solitaire.com/freecell.html");
	}

	@Override
	public void setFocus() {
		browser.setFocus();
	}

	public void register(TextEditor textEditor) {
		System.out.println("register view to editor");
		textEditor.addPropertyListener(new IPropertyListener() {

			@Override
			public void propertyChanged(Object source, int propId) {
				System.out.println("Refreshing");
				if (propId == TextEditor.PROP_DIRTY) {
					browser.refresh();
					((MyTextEditor) source).setFocus();
				}
			}
		});
	}

}