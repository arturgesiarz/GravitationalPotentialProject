package gravitationalPotential.presenter;

import gravitationalPotential.model.GravitationPotentialSolver;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.geometry.Insets;



public class AppPresenter {
    @FXML
    public TextField argumentsField;
    @FXML
    public Label infoLabel;
    @FXML
    public BorderPane borderPane;
    @FXML
    public LineChart<Number, Number> plot;
    private final GravitationPotentialSolver solver = new GravitationPotentialSolver();

    @FXML
    private void onSimulationStartClicked() {
        setDataOnPlot();
        setNewSizeWindow();
        setChartPadding();
        plot.setManaged(true);
        plot.setVisible(true);
    }
    private void setDataOnPlot(){
        int n = Integer.parseInt(argumentsField.getText());
        double[] values = this.solver.solver(n);
        double h = 3.0/n;
        int i = 0;

        this.plot.getData().clear();
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(0.0, 5.0));
        series.getData().add(new XYChart.Data<>(3.0, 4.0));

        while(i < values.length - 1) {
            double x = h * (i + 1);
            double y = 5 - x / 3 + values[i];
            series.getData().add(new XYChart.Data<>(x, y));
            i++;
        }

        this.plot.getData().add(0,series);
    }

    private void setChartPadding() {
        Insets chartPadding = new Insets(100, 50, 50, 50);
        plot.setPadding(chartPadding);
    }

    private void setNewSizeWindow(){
        Stage stage = (Stage) borderPane.getScene().getWindow();

        stage.setWidth(1024);
        stage.setHeight(720);

        centerStageOnScreen(stage);
    }

    private void centerStageOnScreen(Stage stage) {
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();

        double stageX = (screenWidth - stage.getWidth()) / 2;
        double stageY = (screenHeight - stage.getHeight()) / 2;

        stage.setX(stageX);
        stage.setY(stageY);
    }
}
