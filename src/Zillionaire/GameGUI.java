package Zillionaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

/**
 * Created by u1756102 on 14/02/2018.
 */

public class GameGUI {
    //CONTAINERS
    private JPanel MasterPanel;
    private JPanel StartGUI;
    private JPanel AddPlayerGUI;
    private JPanel CategoryGUI;
    private JPanel GameGUI;
    private JPanel EndGUI;
    private JPanel AskAudienceGUI;

    //StartGUI
    private JPanel startContainer;
    private JLabel gameTitleLabel;
    private JButton startGameButton;

    //AddPlayerGUI
    private JPanel addPlayerContainer;
    private JLabel addPlayerLabel;
    private JTextField playerNameTextField;
    private JButton addPlayerButton;
    private JButton playButton;

    //GameGUI
    private JPanel gameContainer;
    private JPanel questionPanel;
    private JLabel questionLabel;
    private JLabel answerLabel;
    private JButton nextButton;
    private JButton aButton;
    private JButton bButton;
    private JButton cButton;
    private JButton dButton;
    private JLabel aLabel;
    private JLabel bLabel;
    private JLabel cLabel;
    private JLabel dLabel;
    private JPanel playersInfoPanel;
    private JLabel bankLabel;
    private JLabel nameLabel;
    private JButton askThePublicButton;
    private JButton halfAndHalfButton;
    private JButton phoneAFriendButton;
    private JButton helpButton;
    private JPanel answersPanel;

    //CategoryGUI
    private JPanel categoryContainer;
    private JButton category1Button;
    private JButton category2Button;
    private JButton category3Button;

    //AskTheAudienceGUI
    private JPanel askAudienceContainer;
    private JProgressBar progressBarA;
    private JProgressBar progressBarB;
    private JProgressBar progressBarC;
    private JProgressBar progressBarD;
    private JButton okayButton;
    private JLabel progressALabel;
    private JLabel progressBLabel;
    private JLabel progressCLabel;
    private JLabel progressDLabel;

    //EndGUI
    private JPanel endContainer;
    private JLabel farewellLabel;

    private Game game = new Game();


    public GameGUI() {
        hideGUIContent();
        customUIComponents();
        game.playSound("audio/lets_play_final.wav");

        //START GUI - ACTION LISTENERS
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartGUI.setVisible(false);
                AddPlayerGUI.setVisible(true);
                GameGUI.setVisible(false);
                EndGUI.setVisible(false);
                playButtonEnabled(false);
            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "Players choose a category on which to answer questions. Questions\n" +
                        "are of a multiple-choice nature with the answer being one of four\n" +
                        "possibilities.\n\n" +

                        "If the player answers the question correctly an amount of ‘money’ is\n" +
                        "credited to that player.\n\n" +

                        "Questions have a difficulty level according to the amount of money\n" +
                        "players are awarded for answering that question correctly. The\n" +
                        "questions are asked in ascending order of difficulty and, therefore,\n" +
                        "value.\n\n" +

                        "Players take turns to answer questions. If a player cannot answer\n" +
                        "a question, help is available as follows:\n" +
                        "\u2022 Ask the Public\n" +
                        "\u2022 Half and Half\n" +
                        "\u2022 Phone a Friend\n" +

                        "If the player answers the questions incorrectly, they are out of the game.\n\n" +

                        "The first player to £1,000,000 wins. In the event that both players answer\n" +
                        "questions incorrectly, the game will be over and no player will take money\n" +
                        "home as winnings.";

                JOptionPane.showMessageDialog(null, message, "Instructions", JOptionPane.PLAIN_MESSAGE);
            }
        });

        //ADD PLAYER GUI - ACTION LISTENERS
        addPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.getNumberOfPlayers() >= 2) {
                    addPlayerButton.setEnabled(false);
                }

                String playerName = playerNameTextField.getText();

                if (!playerName.equals("")) {
                    if (playerName.length() > 20) {
                        playerNameTextField.setText("");
                        String message = "Player name too long..";
                        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        playerNameTextField.setText("");
                        game.addPlayer(playerName);
                        playButtonEnabled(true);
                    }
                } else {
                    String message = "No player name entered.";
                    JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartGUI.setVisible(false);
                AddPlayerGUI.setVisible(false);
                CategoryGUI.setVisible(true);
                GameGUI.setVisible(false);
                EndGUI.setVisible(false);

                setContestantDetails();
                nextButtonEnabled(false);
            }
        });

        //CATEGORY GUI - ACTION LISTENERS
        category1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.setCurrentCategory("General");
                setQuestionDetails("General");

                StartGUI.setVisible(false);
                AddPlayerGUI.setVisible(false);
                CategoryGUI.setVisible(false);
                GameGUI.setVisible(true);
                EndGUI.setVisible(false);
            }
        });

        category2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.setCurrentCategory("Sport");
                setQuestionDetails("Sport");

                StartGUI.setVisible(false);
                AddPlayerGUI.setVisible(false);
                CategoryGUI.setVisible(false);
                GameGUI.setVisible(true);
                EndGUI.setVisible(false);
            }
        });

        category3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.setCurrentCategory("Television");
                setQuestionDetails("TV");

                StartGUI.setVisible(false);
                AddPlayerGUI.setVisible(false);
                CategoryGUI.setVisible(false);
                GameGUI.setVisible(true);
                EndGUI.setVisible(false);
            }
        });

        //GAME GUI - ACTION LISTENERS
        aButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lifelineButtonsEnabled(false);
                checkAnswer(aLabel);
                nextButtonEnabled(true);
                answerButtonsEnabled(false);
                game.changePlayer();
                answerLabel.setText("Answer: " + game.getCurrentQuestion().getAnswer());
            }
        });

        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lifelineButtonsEnabled(false);
                checkAnswer(bLabel);
                nextButtonEnabled(true);
                answerButtonsEnabled(false);
                game.changePlayer();
                answerLabel.setText("Answer: " + game.getCurrentQuestion().getAnswer());
            }
        });

        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lifelineButtonsEnabled(false);
                checkAnswer(cLabel);
                nextButtonEnabled(true);
                answerButtonsEnabled(false);
                game.changePlayer();
                answerLabel.setText("Answer: " + game.getCurrentQuestion().getAnswer());
            }
        });

        dButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lifelineButtonsEnabled(false);
                checkAnswer(dLabel);
                nextButtonEnabled(true);
                answerButtonsEnabled(false);
                game.changePlayer();
                answerLabel.setText("Answer: " + game.getCurrentQuestion().getAnswer());
            }
        });

        askThePublicButton.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartGUI.setVisible(false);
                AddPlayerGUI.setVisible(false);
                CategoryGUI.setVisible(false);
                AskAudienceGUI.setVisible(true);
                GameGUI.setVisible(false);
                EndGUI.setVisible(false);

                progressALabel.setText(game.getCurrentQuestion().getAnswers().get(0));
                progressBLabel.setText(game.getCurrentQuestion().getAnswers().get(1));
                progressCLabel.setText(game.getCurrentQuestion().getAnswers().get(2));
                progressDLabel.setText(game.getCurrentQuestion().getAnswers().get(3));

                if ((int) (Math.random() * 100) > 80) {
                    progressBarA.setValue(10);
                    progressBarB.setValue(20);
                    progressBarC.setValue(60);
                    progressBarD.setValue(10);
                } else if ((int) (Math.random() * 100) > 60) {
                    progressBarA.setValue(30);
                    progressBarB.setValue(30);
                    progressBarC.setValue(30);
                    progressBarD.setValue(10);
                } else if ((int) (Math.random() * 100) > 40) {
                    progressBarA.setValue(5);
                    progressBarB.setValue(85);
                    progressBarC.setValue(2);
                    progressBarD.setValue(8);
                } else {
                    progressBarA.setValue(20);
                    progressBarB.setValue(25);
                    progressBarC.setValue(30);
                    progressBarD.setValue(25);
                }

                askThePublicButton.setEnabled(false);
                game.getCurrentPlayer().setAskTheAudience(false);
            }
        });

        halfAndHalfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.getCurrentQuestion().getAnswer().equals(aLabel.getText())) {
                    bButton.setEnabled(false);
                    bLabel.setText("");
                    dButton.setEnabled(false);
                    dLabel.setText("");
                } else if (game.getCurrentQuestion().getAnswer().equals(bLabel.getText())) {
                    cButton.setEnabled(false);
                    cLabel.setText("");
                    dButton.setEnabled(false);
                    dLabel.setText("");
                } else if (game.getCurrentQuestion().getAnswer().equals(cLabel.getText())) {
                    aButton.setEnabled(false);
                    aLabel.setText("");
                    dButton.setEnabled(false);
                    dLabel.setText("");
                } else {
                    bButton.setEnabled(false);
                    bLabel.setText("");
                    cButton.setEnabled(false);
                    cLabel.setText("");
                }
                halfAndHalfButton.setEnabled(false);
                game.getCurrentPlayer().setHalfAndHalf(false);
            }
        });

        phoneAFriendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String guess = "";
                if ((int) (Math.random() * 100) > 30) {
                    guess = game.getCurrentQuestion().getAnswer();
                } else {
                    guess = game.getCurrentQuestion().getAnswers().get((int) (Math.random() * 4 - 1));
                }

                String message = "Your friend recommends you go with " + guess;
                JOptionPane.showMessageDialog(null, message, "Guess", JOptionPane.PLAIN_MESSAGE);

                phoneAFriendButton.setEnabled(false);
                game.getCurrentPlayer().setPhoneAFriend(false);
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartGUI.setVisible(false);
                AddPlayerGUI.setVisible(false);
                CategoryGUI.setVisible(true);
                GameGUI.setVisible(false);
                EndGUI.setVisible(false);

                setContestantDetails();
                answerButtonsEnabled(true);
                nextButtonEnabled(false);

                if (game.getCurrentPlayer().getAskTheAudience()) {
                    askThePublicButton.setEnabled(true);
                } else {
                    askThePublicButton.setEnabled(false);
                }

                if (game.getCurrentPlayer().getPhoneAFriend()) {
                    phoneAFriendButton.setEnabled(true);
                } else {
                    phoneAFriendButton.setEnabled(false);
                }

                if (game.getCurrentPlayer().getHalfAndHalf()) {
                    halfAndHalfButton.setEnabled(true);
                } else {
                    halfAndHalfButton.setEnabled(false);
                }




                increasePlayerDifficulty();
            }
        });

        //ASK THE AUDIENCE GUI - ACTION LISTENERS
        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartGUI.setVisible(false);
                AddPlayerGUI.setVisible(false);
                CategoryGUI.setVisible(false);
                AskAudienceGUI.setVisible(false);
                GameGUI.setVisible(true);
                EndGUI.setVisible(false);
            }
        });
    }


    public void customUIComponents() {
        Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
        Border border = BorderFactory.createLineBorder(Color.decode("#3C3F41"));

        //START GUI
        gameTitleLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        gameTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        startGameButton.setBackground(Color.decode("#3C3F41"));
        startGameButton.setForeground(Color.white);
        startGameButton.setBorder(BorderFactory.createEmptyBorder());

        startGameButton.setBackground(Color.decode("#3C3F41"));
        startGameButton.setForeground(Color.white);
        startGameButton.setBorder(BorderFactory.createEmptyBorder());

        helpButton.setBackground(Color.decode("#A8A8A8"));
        helpButton.setForeground(Color.white);
        helpButton.setBorder(BorderFactory.createEmptyBorder());

        //ADD PLAYER GUI
        addPlayerButton.setBackground(Color.decode("#3C3F41"));
        addPlayerButton.setForeground(Color.white);
        addPlayerButton.setBorder(BorderFactory.createEmptyBorder());

        playButton.setBackground(Color.decode("#3C3F41"));
        playButton.setForeground(Color.white);
        playButton.setBorder(BorderFactory.createEmptyBorder());

        playerNameTextField.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));

        addPlayerLabel.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));

        //CATEGORY GUI
        category1Button.setBackground(Color.decode("#3C3F41"));
        category1Button.setForeground(Color.white);
        category1Button.setBorder(BorderFactory.createEmptyBorder());

        category2Button.setBackground(Color.decode("#3C3F41"));
        category2Button.setForeground(Color.white);
        category2Button.setBorder(BorderFactory.createEmptyBorder());

        category3Button.setBackground(Color.decode("#3C3F41"));
        category3Button.setForeground(Color.white);
        category3Button.setBorder(BorderFactory.createEmptyBorder());

        //ASK AUDIENCE GUI
        okayButton.setBackground(Color.decode("#3C3F41"));
        okayButton.setForeground(Color.white);
        okayButton.setBorder(BorderFactory.createEmptyBorder());

        progressALabel.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));
        progressALabel.setHorizontalAlignment(SwingConstants.CENTER);
        progressBLabel.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));
        progressBLabel.setHorizontalAlignment(SwingConstants.CENTER);
        progressCLabel.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));
        progressCLabel.setHorizontalAlignment(SwingConstants.CENTER);
        progressDLabel.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));
        progressDLabel.setHorizontalAlignment(SwingConstants.CENTER);

        progressBarA.setBorder(BorderFactory.createEmptyBorder());
        progressBarB.setBorder(BorderFactory.createEmptyBorder());
        progressBarC.setBorder(BorderFactory.createEmptyBorder());
        progressBarD.setBorder(BorderFactory.createEmptyBorder());

        //GAME GUI
        aButton.setBackground(Color.decode("#3C3F41"));
        aButton.setForeground(Color.white);
        aButton.setBorder(BorderFactory.createEmptyBorder());

        bButton.setBackground(Color.decode("#3C3F41"));
        bButton.setForeground(Color.white);
        bButton.setBorder(BorderFactory.createEmptyBorder());

        cButton.setBackground(Color.decode("#3C3F41"));
        cButton.setForeground(Color.white);
        cButton.setBorder(BorderFactory.createEmptyBorder());

        dButton.setBackground(Color.decode("#3C3F41"));
        dButton.setForeground(Color.white);
        dButton.setBorder(BorderFactory.createEmptyBorder());

        nextButton.setBackground(Color.decode("#3C3F41"));
        nextButton.setForeground(Color.white);
        nextButton.setBorder(BorderFactory.createEmptyBorder());

        halfAndHalfButton.setBackground(Color.decode("#3C3F41"));
        halfAndHalfButton.setForeground(Color.white);
        halfAndHalfButton.setBorder(BorderFactory.createEmptyBorder());

        phoneAFriendButton.setBackground(Color.decode("#3C3F41"));
        phoneAFriendButton.setForeground(Color.white);
        phoneAFriendButton.setBorder(BorderFactory.createEmptyBorder());

        askThePublicButton.setBackground(Color.decode("#3C3F41"));
        askThePublicButton.setForeground(Color.white);
        askThePublicButton.setBorder(BorderFactory.createEmptyBorder());

        aLabel.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));
        bLabel.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));
        cLabel.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));
        dLabel.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));

        //END GUI
        farewellLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        farewellLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void hideGUIContent() {
        StartGUI.setVisible(true);
        AddPlayerGUI.setVisible(false);
        CategoryGUI.setVisible(false);
        AskAudienceGUI.setVisible(false);
        GameGUI.setVisible(false);
        EndGUI.setVisible(false);
    }

    public void setContestantDetails() {
        nameLabel.setText("Player: " + game.getCurrentPlayer().getName());
        bankLabel.setText("Bank Balance: £" + String.valueOf(game.getCurrentPlayer().getCashWon()));
    }

    public void setQuestionDetails(String category) {
        //RESET QUESTION
        game.getQuestion(category);

        questionLabel.setText("Question: " + game.getCurrentQuestion().getTitle());
        answerLabel.setText("Answer: ");

        aLabel.setText(game.getCurrentQuestion().getAnswers().get(0));
        bLabel.setText(game.getCurrentQuestion().getAnswers().get(1));
        cLabel.setText(game.getCurrentQuestion().getAnswers().get(2));
        dLabel.setText(game.getCurrentQuestion().getAnswers().get(3));

        game.setCurrentCategory(game.getCurrentCategory());
    }

    public void checkAnswer(JLabel jl) {
        JLabel answerLabel = jl;
        if (answerLabel.getText().equals(game.getCurrentQuestion().getAnswer())) {
            game.playSound("audio/correct_answer_final.wav");
            game.payPlayer();
            String message = "Correct Answer, you may progress";
            JOptionPane.showMessageDialog(null, message, "Correct Answer", JOptionPane.PLAIN_MESSAGE);
            bankLabel.setText("Bank Balance: £" + String.valueOf(game.getCurrentPlayer().getCashWon()));
            if (checkWinner()) {
                showWinnersMessage();
                game.removePlayer();
            }

            if (game.getNumberOfPlayers() == 0) {
                endGame();
            }
        } else {
            game.playSound("audio/wrong_answer_final.wav");
            showLosersMessage();
            game.removePlayer();
            if (game.getNumberOfPlayers() == 0) {
                endGame();
            }
        }
    }

    public void increasePlayerDifficulty() {
        int complexity = game.getCurrentPlayer().getQuestionComplexity();
        game.getCurrentPlayer().setQuestionComplexity(complexity + 1);
    }

    public boolean checkWinner() {
        if (game.getCurrentPlayer().getCashWon() == 1000000) {
            return true;
        } else
            return false;
    }

    public String getPlayerStats() {
        return "Player Name: " + game.getCurrentPlayer().getName() + "\n" +
                "Cash Won: £" + game.getCurrentPlayer().getCashWon() + "\n\n" +
                "Correct Answer: " + game.getCurrentQuestion().getAnswer();
    }

    public void showLosersMessage() {
        String stats = getPlayerStats();
        String message = "Incorrect answer, you have lost. You are being removed from the game.\n\n" +
                         stats + "\n\n" +
                         "Thanks for playing!";

        JOptionPane.showMessageDialog(null, message, "Sorry, better luck next time", JOptionPane.PLAIN_MESSAGE);
    }

    public void showWinnersMessage() {
        String stats = getPlayerStats();
        String message = "Correct answer, you have won! Congratulations.\n\n" +
                         stats + "\n\n" +
                         "Thanks for playing!";

        JOptionPane.showMessageDialog(null, message, "Congratulations", JOptionPane.PLAIN_MESSAGE);
    }

    public void endGame() {
        StartGUI.setVisible(false);
        AddPlayerGUI.setVisible(false);
        GameGUI.setVisible(false);
        EndGUI.setVisible(true);
    }

    public void answerButtonsEnabled(boolean value) {
        aButton.setEnabled(value);
        bButton.setEnabled(value);
        cButton.setEnabled(value);
        dButton.setEnabled(value);
    }

    public void lifelineButtonsEnabled(boolean value) {
        askThePublicButton.setEnabled(value);
        halfAndHalfButton.setEnabled(value);
        phoneAFriendButton.setEnabled(value);
    }

    public void nextButtonEnabled(boolean value) {
        nextButton.setEnabled(value);
    }

    public void playButtonEnabled(boolean value) {
        playButton.setEnabled(value);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Who Wants To Be A Zillionaire!");
        frame.setContentPane(new GameGUI().MasterPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
