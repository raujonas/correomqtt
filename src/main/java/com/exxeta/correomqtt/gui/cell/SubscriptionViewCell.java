package com.exxeta.correomqtt.gui.cell;

import com.exxeta.correomqtt.business.services.ConfigService;
import com.exxeta.correomqtt.gui.model.SubscriptionPropertiesDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

public class SubscriptionViewCell extends ListCell<SubscriptionPropertiesDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionViewCell.class);

    private final ListView<SubscriptionPropertiesDTO> listView;

    @SuppressWarnings("unused")
    @FXML
    private Label topicLabel;

    @SuppressWarnings("unused")
    @FXML
    private Label qosTag;

    @SuppressWarnings("unused")
    @FXML
    private CheckBox filterCheckbox;

    @SuppressWarnings("unused")
    @FXML
    private Pane mainNode;
    @FXML
    private ResourceBundle resources;

    private FXMLLoader loader;

    public SubscriptionViewCell(ListView<SubscriptionPropertiesDTO> listView) {
        this.listView = listView;
    }

    @Override
    protected void updateItem(SubscriptionPropertiesDTO subscriptionDTO, boolean empty) {
        super.updateItem(subscriptionDTO, empty);

        if (empty || subscriptionDTO == null) {
            setText(null);
            setGraphic(null);
        } else {

            if (loader == null) {
                try {
                    loader = new FXMLLoader(SubscriptionViewCell.class.getResource("subscriptionView.fxml"),
                            ResourceBundle.getBundle("com.exxeta.correomqtt.i18n", ConfigService.getInstance().getSettings().getCurrentLocale()));
                    loader.setController(this);
                    loader.load();

                } catch (Exception e) {
                    LOGGER.error("Exception rendering subscription:", e);
                    setText(resources.getString("commonRowCreationError"));
                    setGraphic(null);
                    return;
                }

            }
            mainNode.prefWidthProperty().bind(listView.widthProperty().subtract(20));
            setUpSubscription(subscriptionDTO);
            setText(null);
            setGraphic(mainNode);
        }
    }

    @SuppressWarnings("unused")
    @FXML
    public void onFilteredChanged(ActionEvent event) {
        getItem().setFiltered(filterCheckbox.isSelected());
    }

    private void setUpSubscription(SubscriptionPropertiesDTO subscriptionDTO) {
        topicLabel.setText(subscriptionDTO.getTopic());
        qosTag.setText(subscriptionDTO.getQos().toString());
        filterCheckbox.setSelected(subscriptionDTO.isFiltered());
    }

}
