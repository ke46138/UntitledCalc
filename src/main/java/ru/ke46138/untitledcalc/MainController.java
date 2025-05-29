package ru.ke46138.untitledcalc;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.text.DecimalFormat;

public class MainController {

    private String charactersOnDisplay = "0";
    private final int maxSymbols = 10;
    private int currentAction = 0; // 0 - нет действия, 1 - сложение, 2 - вычитание, 3 - деление, 4 - умножение, 5 - вычислить процент, 6 - возвести в степень y
    private double firstNumber = 0;
    private double secondNumber = 0;
    private boolean haveDot = false;
    private final int fadeInDuration = 100;
    private final int fadeOutDuration = 50;
    private final DecimalFormat df = new DecimalFormat("#.#########");
    private boolean readOnly = false;

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
        if (source.getId() != null) {
            switch (source.getId()) {
                case "oneBtn":
                    if (!readOnly) {
                        if (charactersOnDisplay.length() >= maxSymbols) break;
                        if (charactersOnDisplay.equals("0")) charactersOnDisplay = "1";
                        else if (charactersOnDisplay.equals("-0")) charactersOnDisplay = "1";
                        else charactersOnDisplay += "1";
                    }
                    break;
                case "twoBtn":
                    if (!readOnly) {
                        if (charactersOnDisplay.length() >= maxSymbols) break;
                        if (charactersOnDisplay.equals("0")) charactersOnDisplay = "2";
                        else if (charactersOnDisplay.equals("-0")) charactersOnDisplay = "-2";
                        else charactersOnDisplay += "2";
                    }
                    break;
                case "threeBtn":
                    if (!readOnly) {
                        if (charactersOnDisplay.length() >= maxSymbols) break;
                        if (charactersOnDisplay.equals("0")) charactersOnDisplay = "3";
                        else if (charactersOnDisplay.equals("-0")) charactersOnDisplay = "-3";
                        else charactersOnDisplay += "3";
                    }
                    break;
                case "fourBtn":
                    if (!readOnly) {
                        if (charactersOnDisplay.length() >= maxSymbols) break;
                        if (charactersOnDisplay.equals("0")) charactersOnDisplay = "4";
                        else if (charactersOnDisplay.equals("-0")) charactersOnDisplay = "-4";
                        else charactersOnDisplay += "4";
                    }
                    break;
                case "fiveBtn":
                    if (!readOnly) {
                        if (charactersOnDisplay.length() >= maxSymbols) break;
                        if (charactersOnDisplay.equals("0")) charactersOnDisplay = "5";
                        else if (charactersOnDisplay.equals("-0")) charactersOnDisplay = "-5";
                        else charactersOnDisplay += "5";
                    }
                    break;
                case "sixBtn":
                    if (!readOnly) {
                        if (charactersOnDisplay.length() >= maxSymbols) break;
                        if (charactersOnDisplay.equals("0")) charactersOnDisplay = "6";
                        else if (charactersOnDisplay.equals("-0")) charactersOnDisplay = "-6";
                        else charactersOnDisplay += "6";
                    }
                    break;
                case "sevenBtn":
                    if (!readOnly) {
                        if (charactersOnDisplay.length() >= maxSymbols) break;
                        if (charactersOnDisplay.equals("0")) charactersOnDisplay = "7";
                        else if (charactersOnDisplay.equals("-0")) charactersOnDisplay = "-7";
                        else charactersOnDisplay += "7";
                    }
                    break;
                case "eightBtn":
                    if (!readOnly) {
                        if (charactersOnDisplay.length() >= maxSymbols) break;
                        if (charactersOnDisplay.equals("0")) charactersOnDisplay = "8";
                        else if (charactersOnDisplay.equals("-0")) charactersOnDisplay = "-8";
                        else charactersOnDisplay += "8";
                    }
                    break;
                case "nineBtn":
                    if (!readOnly) {
                        if (charactersOnDisplay.length() >= maxSymbols) break;
                        if (charactersOnDisplay.equals("0")) charactersOnDisplay = "9";
                        else if (charactersOnDisplay.equals("-0")) charactersOnDisplay = "-9";
                        else charactersOnDisplay += "9";
                    }
                    break;
                case "zeroBtn":
                    if (!readOnly) {
                        if (charactersOnDisplay.length() >= maxSymbols) break;
                        if (charactersOnDisplay.equals("0")) break;
                        else if (charactersOnDisplay.equals("-0")) break;
                        charactersOnDisplay += "0";
                    }
                    break;
                case "dotBtn":
                    if (!readOnly) {
                        if (charactersOnDisplay.length() >= maxSymbols) break;
                        if (haveDot) break;
                        haveDot = true;
                        charactersOnDisplay += ",";
                    }
                    break;
                case "acBtn":
                    charactersOnDisplay = "0";
                    actionDisplay.setText("");
                    currentAction = 0;
                    haveDot = false;
                    readOnly = false;
                    break;
                case "cBtn":
                    if (!readOnly) {
                        charactersOnDisplay = "0";
                        haveDot = false;
                    }
                case "backspaceBtn":
                    if (!readOnly) {
                        if (charactersOnDisplay.length() > 1) {
                            charactersOnDisplay = charactersOnDisplay.substring(0, charactersOnDisplay.length() - 1);
                        } else if (charactersOnDisplay.length() == 1 && !charactersOnDisplay.equals("0")) {
                            charactersOnDisplay = "0";
                        }
                    }
                    break;
                case "plusBtn":
                    animateTextChange(actionDisplay, "+");
                    currentAction = 1;
                    haveDot = false;
                    readOnly = false;
                    firstNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                    charactersOnDisplay = "0";
                    break;
                case "subtractBtn":
                    animateTextChange(actionDisplay, "-");
                    currentAction = 2;
                    haveDot = false;
                    readOnly = false;
                    firstNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                    charactersOnDisplay = "0";
                    break;
                case "divideBtn":
                    animateTextChange(actionDisplay, "/");
                    currentAction = 3;
                    haveDot = false;
                    readOnly = false;
                    firstNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                    charactersOnDisplay = "0";
                    break;
                case "multiplyBtn":
                    animateTextChange(actionDisplay, "*");
                    currentAction = 4;
                    haveDot = false;
                    readOnly = false;
                    firstNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                    charactersOnDisplay = "0";
                    break;
                case "percentBtn":
                    animateTextChange(actionDisplay, "%");
                    currentAction = 5;
                    haveDot = false;
                    readOnly = false;
                    firstNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                    charactersOnDisplay = "0";
                    break;
                case "sqrtBtn":
                    animateTextChange(actionDisplay, "r");
                    currentAction = 5;
                    readOnly = true;
                    firstNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                    if (firstNumber < 0) {
                        charactersOnDisplay = "UNDEFINED";
                        break;
                    }
                    charactersOnDisplay = df.format(Math.sqrt(firstNumber)).replace(".", ",");
                    break;
                case "xinyBtn":
                    animateTextChange(actionDisplay, "y");
                    currentAction = 6;
                    haveDot = false;
                    readOnly = false;
                    firstNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                    charactersOnDisplay = "0";
                    break;
                case "xinsquareBtn":
                    animateTextChange(actionDisplay, "2");
                    currentAction = 5;
                    readOnly = true;
                    firstNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                    charactersOnDisplay = df.format(Math.pow(firstNumber, 2)).replace(".", ",");
                    break;
                case "revertBtn":
                    if (!readOnly) {
                        charactersOnDisplay = "-" + charactersOnDisplay;
                    }
                    break;
                case "equalBtn":
                    animateTextChange(actionDisplay, "=");
                    switch (currentAction) {
                        case 1:
                            secondNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                            charactersOnDisplay = df.format(firstNumber + secondNumber).replace(".", ",");
                            readOnly = true;
                            break;
                        case 2:
                            secondNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                            charactersOnDisplay = df.format(firstNumber - secondNumber).replace(".", ",");
                            readOnly = true;
                            break;
                        case 3:
                            secondNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                            readOnly = true;
                            if (secondNumber == 0) {
                                charactersOnDisplay = "UNDEFINED";
                                break;
                            }
                            charactersOnDisplay = df.format(firstNumber / secondNumber).replace(".", ",");
                            break;
                        case 4:
                            secondNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                            charactersOnDisplay = df.format(firstNumber * secondNumber).replace(".", ",");
                            readOnly = true;
                            break;
                        case 5:
                            secondNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                            charactersOnDisplay = df.format(firstNumber * secondNumber / 100).replace(".", ",");
                            readOnly = true;
                            break;
                        case 6:
                            secondNumber = Double.parseDouble(charactersOnDisplay.replace(",", "."));
                            charactersOnDisplay = df.format(Math.pow(firstNumber, secondNumber)).replace(".", ",");
                            readOnly = true;
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