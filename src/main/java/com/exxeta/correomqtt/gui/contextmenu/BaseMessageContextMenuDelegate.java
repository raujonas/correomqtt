package com.exxeta.correomqtt.gui.contextmenu;

import com.exxeta.correomqtt.gui.model.MessagePropertiesDTO;

public interface BaseMessageContextMenuDelegate extends BaseObjectContextMenuDelegate {
    void showDetailsInSeparateWindow(MessagePropertiesDTO messageDTO);
    void setUpToForm(MessagePropertiesDTO messageDTO);
}
