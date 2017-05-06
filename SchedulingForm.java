import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SchedulingForm extends Application{
	BorderPane bp = new BorderPane();
	FlowPane flow = new FlowPane();
	VBox vbMain = new VBox();
	Label lbCountDown;
	Label lbMessageBox;
	int hour, minute, second;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ComboBox<String> cbMain = new ComboBox<String>();
		lbCountDown = new Label();
		lbMessageBox = new Label();
		HBox hBoxCountDown = new HBox();
		HBox hbBottom = new HBox();
		
		hBoxCountDown.getChildren().addAll(lbCountDown);
		hBoxCountDown.setStyle("-fx-background-color: BLACK;");
		
		lbCountDown.setStyle("-fx-font-size: 70;");
		lbCountDown.setTextFill(Color.WHITE);
		lbMessageBox.setTextFill(Color.RED);
		lbMessageBox.setPadding(new Insets(0, 0, 0, 150));
		
		Label lbSelection = new Label("Select task to schedule: ");
		cbMain.getItems().addAll("Lights", "TV");
		vbMain.getChildren().addAll(lbSelection, cbMain);
		flow.getChildren().add(vbMain);
		
		cbMain.setMaxWidth(150);
		
		cbMain.setOnAction((e) -> {
			try {
				String choice = cbMain.getValue();
				handleScheduledObject(choice);
			} catch(NullPointerException x) {
				lbMessageBox.setText("CHOOSE A TASK TO SCHEDULE");
				return;
			};
		});
		
		Button btnClose = new Button("Close");

		
		btnClose.setOnAction((e) -> {
			primaryStage.hide();
		});
		
		hbBottom.getChildren().addAll(btnClose, lbMessageBox);
	
		bp.setTop(hBoxCountDown);
		bp.setLeft(flow);
		bp.setBottom(hbBottom);
		Scene scene = new Scene(bp, 450, 350);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Schedule Task");
		primaryStage.show();
		
	}

	private void handleScheduledObject(String choice) {	
		ComboBox<String> cbLights = new ComboBox<String>();
		Label lbEnterTime = new Label("Enter time here:");
		TextField tfHour = new TextField();
		TextField tfMinute = new TextField();
		TextField tfSecond = new TextField();
		Button btnSubmit = new Button("Submit");
		VBox vbTime = new VBox();
		vbTime.getChildren().addAll(lbEnterTime, tfHour, tfMinute, tfSecond, btnSubmit);
		vbTime.setVisible(false);
		flow.getChildren().add(vbTime);
		
		cbLights.setPromptText("Select a light:");
		tfHour.setPromptText("Hour(s)"); 
		tfMinute.setPromptText("Minute(s)");
		tfSecond.setPromptText("Second(s)");
		
		cbLights.setMaxWidth(150);
		tfHour.setMaxWidth(150);
		tfMinute.setMaxWidth(150);
		tfSecond.setMaxWidth(150);
		btnSubmit.setMaxWidth(150);
		
		vbTime.setPadding(new Insets(0, 0, 50, 50));
		
		cbLights.getItems().addAll("Living Room", "Kitchen", "Bedroom", "Bathroom", "Garage", "Front Yard", "Back Yard");
		
		if (choice.equals("Lights")) {
			vbMain.getChildren().add(cbLights);
			cbLights.setVisible(true);	
			vbTime.setVisible(true);
			
			btnSubmit.setOnAction((event) -> {
				lbMessageBox.setText("");
				try{
					
					hour = Integer.parseInt(tfHour.getText());
					minute = Integer.parseInt(tfMinute.getText());
					second = Integer.parseInt(tfSecond.getText());
					
					String lightChoice = cbLights.getValue();
					handleTimedLightControl(lightChoice);

					handleCountDown();

				} catch(NumberFormatException | NullPointerException z) {
					lbMessageBox.setText("INVALID INPUT");
					tfHour.clear();
					tfMinute.clear();
					tfSecond.clear();
					return;
				}

			});
		}
		
		if (choice.equals("TV")) {
			vbTime.setVisible(true);
			
			btnSubmit.setOnAction((event) -> {
				lbMessageBox.setText("");
				try{
					
					hour = Integer.parseInt(tfHour.getText());
					minute = Integer.parseInt(tfMinute.getText());
					second = Integer.parseInt(tfSecond.getText());
					
					Television tv = new Television();
					tv.setVisible(true);
					tv.setSize(400, 200);
					
					handleCountDownOBject(tv);

				} catch(NumberFormatException | NullPointerException z) {
					lbMessageBox.setText("INVALID INPUT");
					tfHour.clear();
					tfMinute.clear();
					tfSecond.clear();
					return;
				}

			});
		}

		tfHour.clear();
		tfMinute.clear();
		tfSecond.clear();
	}

	private void handleCountDownOBject(Television tv) {
Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				
				if (hour > 0 && minute == 0 && second == 0) {
					hour--;
					minute = 59;
					second = 59;
				}
				
				if (hour == 0 && minute > 0 && second == 0) {
					minute--;
					second = 59;
				}
			
				second--;
				
				if (hour == 0 && minute == 0 && second == 0) {
					timer.cancel();
					timer.purge();
				}
				
				Platform.runLater(new Runnable() {

					public void run() {
						
						String timeFormat = String.format("%02dh%02dm%02ds", hour, minute, second);
						lbCountDown.setText(timeFormat);
						
						if(hour == 0 && minute == 0 && second == 0) {
							lbCountDown.setText("Time's Up!");
							tv.setVisible(false);
						}
					}
				});
				
			}		
		}, 0, 1000);
		
	}

	private void handleTimedLightControl(String lightChoice) {
		if (lightChoice.equals("Living Room")) {
			SSHLightControl timeSSHLightControl = new SSHLightControl(hour, minute, second);
		}
		return;
	}

	private void handleCountDown() {
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				
				if (hour > 0 && minute == 0 && second == 0) {
					hour--;
					minute = 59;
					second = 59;
				}
				
				if (hour == 0 && minute > 0 && second == 0) {
					minute--;
					second = 59;
				}
			
				second--;
				
				if (hour == 0 && minute == 0 && second == 0) {
					timer.cancel();
					timer.purge();
				}
				
				Platform.runLater(new Runnable() {

					public void run() {
						
						String timeFormat = String.format("%02dh%02dm%02ds", hour, minute, second);
						lbCountDown.setText(timeFormat);
						
						if(hour == 0 && minute == 0 && second == 0) {
							lbCountDown.setText("Time's Up!");
						}
					}
				});
				
			}		
		}, 0, 1000);		
	}
}