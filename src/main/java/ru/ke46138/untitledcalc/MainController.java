package ru.ke46138.untitledcalc;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class MainController {

    private String charactersOnDisplay = "0";
    private final int maxSymbols = 10;
    private int currentAction = 0; // 0 - нет действия, 1 - сложение, 2 - вычитание, 3 - деление, 4 - умножение
    private double firstNumber = 0;
    private double secondNumber = 0;
    private boolean haveDot = false;
    private final int fadeInDuration = 100;
    private final int fadeOutDuration = 50;

    @FXML
    private Label mainDisplay;

    @FXML
    private Label actionDisplay;

    private void animateTextChange(Label label, String newText) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(fadeOutDuration), label);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(fadeInDuration), label);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        fadeOut.setOnFinished(event -> {
            label.setText(newText);
            fadeIn.play();
        });

        fadeOut.play();
    }

    @FXML
    private void buttonHandler(ActionEvent event) {
        Button source = (Button) event.getSource();
        System.out.println("Нажата кнопка: " + source.getText());
        System.out.println("Длина: " + charactersOnDisplay.length());
        if (source.getId() != null) {
            switch (source.getId()) {
                case "oneBtn":
                    if (charactersOnDisplay.length() >= maxSymbols) break;
                    if (charactersOnDisplay.equals("0")) charactersOnDisplay = "1";
                    else charactersOnDisplay += "1";
                    break;
                case "twoBtn":
                    if (charactersOnDisplay.length() >= maxSymbols) break;
                    if (charactersOnDisplay.equals("0")) charactersOnDisplay = "2";
                    else charactersOnDisplay += "2";
                    break;
                case "threeBtn":
                    if (charactersOnDisplay.length() >= maxSymbols) break;
                    if (charactersOnDisplay.equals("0")) charactersOnDisplay = "3";
                    else charactersOnDisplay += "3";
                    break;
                case "fourBtn":
                    if (charactersOnDisplay.length() >= maxSymbols) break;
                    if (charactersOnDisplay.equals("0")) charactersOnDisplay = "4";
                    else charactersOnDisplay += "4";
                    break;
                case "fiveBtn":
                    if (charactersOnDisplay.length() >= maxSymbols) break;
                    if (charactersOnDisplay.equals("0")) charactersOnDisplay = "5";
                    else charactersOnDisplay += "5";
                    break;
                case "sixBtn":
                    if (charactersOnDisplay.length() >= maxSymbols) break;
                    if (charactersOnDisplay.equals("0")) charactersOnDisplay = "6";
                    else charactersOnDisplay += "6";
                    break;
                case "sevenBtn":
                    if (charactersOnDisplay.length() >= maxSymbols) break;
                    if (charactersOnDisplay.equals("0")) charactersOnDisplay = "7";
                    else charactersOnDisplay += "7";
                    break;
                case "eightBtn":
                    if (charactersOnDisplay.length() >= maxSymbols) break;
                    if (charactersOnDisplay.equals("0")) charactersOnDisplay = "8";
                    else charactersOnDisplay += "8";
                    break;
                case "nineBtn":
                    if (charactersOnDisplay.length() >= maxSymbols) break;
                    if (charactersOnDisplay.equals("0")) charactersOnDisplay = "9";
                    else charactersOnDisplay += "9";
                    break;
                case "zeroBtn":
                    if (charactersOnDisplay.length() >= maxSymbols) break;
                    if (charactersOnDisplay.equals("0")) break;
                    charactersOnDisplay += "0";
                    break;
                case "dotBtn":
                    if (charactersOnDisplay.length() >= maxSymbols) break;
                    if (haveDot) break;
                    haveDot = true;
                    charactersOnDisplay += ",";
                    break;
                case "acBtn":
                    charactersOnDisplay = "0";
                    actionDisplay.setText("");
                    haveDot = false;
                    break;
                case "idkBtn":
                    if (charactersOnDisplay.length() > 1) {
                        charactersOnDisplay = charactersOnDisplay.substring(0, charactersOnDisplay.length() - 1);
                    }
                    else if (charactersOnDisplay.length() == 1 && !charactersOnDisplay.equals("0")) {
                        charactersOnDisplay = "0";
                    }
                    break;
                case "plusBtn":
                    animateTextChange(actionDisplay, "+");
                    currentAction = 1;
                    haveDot = false;
                    firstNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                    charactersOnDisplay = "0";
                    break;
                case "subtractBtn":
                    animateTextChange(actionDisplay, "-");
                    currentAction = 2;
                    haveDot = false;
                    firstNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                    charactersOnDisplay = "0";
                    break;
                case "divideBtn":
                    animateTextChange(actionDisplay, "/");
                    currentAction = 3;
                    haveDot = false;
                    firstNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                    charactersOnDisplay = "0";
                    break;
                case "multiplyBtn":
                    animateTextChange(actionDisplay, "*");
                    currentAction = 4;
                    haveDot = false;
                    firstNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                    charactersOnDisplay = "0";
                    break;
                case "equalBtn":
                    animateTextChange(actionDisplay, "=");
                    switch (currentAction) {
                        case 1:
                            secondNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                            charactersOnDisplay = String.valueOf(firstNumber + secondNumber).replace(".", ",");
                            break;
                        case 2:
                            secondNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                            charactersOnDisplay = String.valueOf(firstNumber - secondNumber).replace(".", ",");
                            break;
                        case 3:
                            secondNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                            charactersOnDisplay = String.valueOf(firstNumber / secondNumber).replace(".", ",");
                            break;
                        case 4:
                            secondNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                            charactersOnDisplay = String.valueOf(firstNumber * secondNumber).replace(".", ",");
                            break;
                        default:
                            break;
                    }
                    currentAction = 0;
                default:
                    break;
            }
            animateTextChange(mainDisplay, charactersOnDisplay);
        }
    }
}