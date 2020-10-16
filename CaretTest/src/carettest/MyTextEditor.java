package carettest;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

public class MyTextEditor extends org.eclipse.ui.editors.text.TextEditor {

	@Override
	protected void doSetInput(IEditorInput input) throws CoreException {
		// TODO Auto-generated method stub
		super.doSetInput(input);
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		View browserView = (View) site.getPage().getViews()[0];
		browserView.register(this);

	}

	@Override
	protected void initializeEditor() {
		// TODO Auto-generated method stub
		super.initializeEditor();
	}
}
