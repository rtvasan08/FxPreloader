/*******************************************************************************
 * Copyright (c) 2014 Thirumalaivasan Rajasekaran.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *      Thirumalaivasan Rajasekaran - initial API and implementation
 ******************************************************************************/
package com.bugfix.fxpreloader;

import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Thirumalaivasan Rajasekaran
 *
 */
public class SamplePreloader extends Preloader{
	
	ProgressBar bar;
    Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
        stage.setScene(createPreloaderScene());        
        stage.show();
	}
 
    private Scene createPreloaderScene() {
        bar = new ProgressBar();
        BorderPane p = new BorderPane();
        p.setCenter(bar);
        return new Scene(p, 300, 150);        
    }
    
    @Override
    public void handleProgressNotification(ProgressNotification pn) {
        bar.setProgress(pn.getProgress());
    }
 
    @Override
    public void handleStateChangeNotification(StateChangeNotification evt) {
        if (evt.getType() == StateChangeNotification.Type.BEFORE_START) {
            stage.hide();
        }
    }    

}
