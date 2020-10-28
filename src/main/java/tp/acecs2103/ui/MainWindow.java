package tp.acecs2103.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tp.acecs2103.commons.core.GuiSettings;
import tp.acecs2103.commons.core.LogsCenter;
import tp.acecs2103.commons.util.AppUtil;
import tp.acecs2103.logic.Logic;
import tp.acecs2103.logic.commands.CommandResult;
import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.logic.parser.exceptions.ParseException;

/**
 * The Main Window. Provides the basic application layout containing
 * a menu bar and space where other JavaFX elements can be placed.
 */
public class MainWindow extends UiPart<Stage> {

    private static final String FXML = "MainWindow.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());

    private Stage primaryStage;
    private Logic logic;

    // Independent Ui parts residing in this Ui container
    private CategoryPanel categoryPanel;
    private WeekDisplay weekDisplay;
    private CommandBox commandBox;
    private FeedbackBox feedbackBox;

    @FXML
    private StackPane weekDisplayPlaceholder;

    @FXML
    private HBox progressBarContainer;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private HBox categoryPanelPlaceholder;

    @FXML
    private StackPane commandBoxPlaceholder;

    @FXML
    private StackPane feedbackBoxPlaceholder;

    /**
     * Creates a {@code MainWindow} with the given {@code Stage} and {@code Logic}.
     */
    public MainWindow(Stage primaryStage, Logic logic) {
        super(FXML, primaryStage);

        // Set dependencies
        this.primaryStage = primaryStage;
        this.logic = logic;

        // Configure the UI
        setWindowDefaultSize(logic.getGuiSettings());
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Fills up all the placeholders of this window.
     */
    void fillInnerParts() {
        // TODO: change the method to get each category panel
        categoryPanel = new CategoryPanel(logic.getUiTaskList().getAdminList(), logic.getUiTaskList().getAdminWeekRange(), "Admin");
        categoryPanelPlaceholder.getChildren().add(categoryPanel.getRoot());
        categoryPanel = new CategoryPanel(logic.getUiTaskList().getTopicList(), logic.getUiTaskList().getTopicWeekRange(), "Topic");
        categoryPanelPlaceholder.getChildren().add(categoryPanel.getRoot());
        categoryPanel = new CategoryPanel(logic.getUiTaskList().getIpList(), logic.getUiTaskList().getIpWeekRange(), "Ip");
        categoryPanelPlaceholder.getChildren().add(categoryPanel.getRoot());
        categoryPanel = new CategoryPanel(logic.getUiTaskList().getTpList(), logic.getUiTaskList().getTpWeekRange(), "Tp");
        categoryPanelPlaceholder.getChildren().add(categoryPanel.getRoot());

        int currentWeekNumber = AppUtil.getCurrentWeekNumber().getWeekValueInt();
        Double a = (double) currentWeekNumber / (double) 13;
        progressBar.setProgress(a);

        weekDisplay = new WeekDisplay(currentWeekNumber);
        weekDisplayPlaceholder.getChildren().add(weekDisplay.getRoot());

        feedbackBox = new FeedbackBox();
        feedbackBoxPlaceholder.getChildren().add(feedbackBox.getRoot());
        CommandBox commandBox = new CommandBox(this::executeCommand); // bottom of Ace CS2103/T
        commandBoxPlaceholder.getChildren().add(commandBox.getRoot());
    }

    /**
     * Sets the default size based on {@code guiSettings}.
     */
    private void setWindowDefaultSize(GuiSettings guiSettings) {
        primaryStage.setHeight(guiSettings.getWindowHeight());
        primaryStage.setWidth(guiSettings.getWindowWidth());
        if (guiSettings.getWindowCoordinates() != null) {
            primaryStage.setX(guiSettings.getWindowCoordinates().getX());
            primaryStage.setY(guiSettings.getWindowCoordinates().getY());
        }
    }

    void show() {
        primaryStage.show();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        GuiSettings guiSettings = new GuiSettings(primaryStage.getWidth(), primaryStage.getHeight(),
                (int) primaryStage.getX(), (int) primaryStage.getY());
        logic.setGuiSettings(guiSettings);
        primaryStage.hide();
    }


    /**
     * Executes the command and returns the result.
     *
     * @see Logic#execute(String)
     */
    private CommandResult executeCommand(String commandText) throws CommandException, ParseException {
        try {
            CommandResult commandResult = logic.execute(commandText);
            logger.info("Result: " + commandResult.getFeedbackToUser());
            feedbackBox.setFeedbackToUser(commandResult.getFeedbackToUser());
            // categoryPanel.setFeedbackToUser(commandResult.getFeedbackToUser());
            if (commandResult.isExit()) {
                handleExit();
            }


            return commandResult;
        } catch (CommandException | ParseException e) {
            logger.info("Invalid command: " + commandText);
            feedbackBox.setFeedbackToUser("Invalid command: " + commandText);
            // categoryPanel.setFeedbackToUser(e.getMessage());
            throw e;
        }
    }
}
