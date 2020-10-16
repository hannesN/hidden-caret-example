package carettest;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		layout.addStandaloneView(View.ID, false, IPageLayout.LEFT, 0.5f, layout.getEditorArea());
	}

}
