package org.correomqtt.plugin.spi;

import javafx.scene.control.Menu;

public interface ToolsMenuHook extends BaseExtensionPoint {

    void onInstantiateToolsMenu(Menu toolsMenu, int indexToInsert);

}
