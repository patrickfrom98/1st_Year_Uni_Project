package Zillionaire;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by u1756102 on 14/02/2018.
 */
public class Game {
    private ArrayList<Player> players;
    private ArrayList<Question> currentQuestion;
    private String currentCategory;
    private int currentPlayer;
    private Questions q = new Questions();


    public Game() {
        this.players = new ArrayList <Player>();
        this.currentQuestion = new ArrayList<Question>();
        this.currentCategory = "General";
        this.currentPlayer = 0;

        addGeneralKnowledgeQuestions();
        addSportsQuestions();
        addTelevisionQuestions();
    }


    public void addGeneralKnowledgeQuestions() {
        q.addQuestion("How many days are in a year?", "365", "363", "364", "365", "366", 1, "General");
        q.addQuestion("Approximately how many pounds are in a kilogram?", "2.2", "2.1", "2.2", "2.3", "2.4", 1, "General");
        q.addQuestion("What does a thermometer measure?", "Temperature", "Heart Rate", "Distance", "Speed", "Temperature", 1, "General");

        q.addQuestion("Hitler party which came into power in 1933 is known as", "Nazi Party", "Labour Party", "Nazi Party", "Ku-Klux-Klan", "Democratic Party", 2, "General");
        q.addQuestion("When was the industrial revolution?", "18th Century", "18th Century", "19th Century", "20th Century", "21st Century", 2, "General");
        q.addQuestion("What county is Huddersfield in?", "Yorkshire", "Lancashire", "Leicstershire", "Wiltshire", "Yorkshire", 2, "General");

        q.addQuestion("Epsom (England) is the place associated with", "Horse Racing", "Horse Racing", "Polo", "Shooting", "Snooker", 3, "General");
        q.addQuestion("The first Afghan war took place in?","1839", "1839", "1843", "1833", "1848", 3, "General");
        q.addQuestion("Who is the parent company of Google?", "Alphabet", "BP", "Alphabet", "Apple", "Samsung", 3, "General");

        q.addQuestion("For the Olympics and World Tournaments, the dimensions of basketball court are", "28m x 15m", "26m x 14m", "28m x 15m", "27m x 16m", "28m x 16m", 4, "General");
        q.addQuestion("Each year World Red Cross and Red Crescent Day is celebrated on", "May 8th", "May 8th", "May 18th", "June 8th", "June 18th", 4, "General");
        q.addQuestion("What channel is TV show Drake & Josh on?", "Nickelodeon", "Nickelodeon", "CBBC", "FOX", "Disney", 4, "General");

        q.addQuestion("During World War II, when did Germany attack France?", "1940", "1940","1941","1942","1943",5, "General");
        q.addQuestion("The ozone layer restricts?","Ultraviolet Radiation", "Visible Light","Infrared Radiation","Ultraviolet Radiation", "X-Rays", 5, "General");
        q.addQuestion("Filaria is caused by?", "Mosquitos", "Bacteria", "Virus", "Mosquitos", "Protozoa", 5, "General");

        q.addQuestion("Hamid Karzai was chosen president of Afghanistan in?", "2002", "2000", "2001", "2002", "2003", 6, "General");
        q.addQuestion("The FA Cup is associated with the game of?", "Football", "Football", "Cricket", "Hockey", "Volleyball", 6, "General");
        q.addQuestion("Fathometer is used to measure?", "Ocean Depth", "Rainfall", "Ocean Depth", "Earthquakes", "Sound Intensity", 6, "General");

        q.addQuestion("Hockey was introduced in the Asian Games in", "1958 in Tokyo", "1958 in Tokyo", "1962 in Jakarta", "1966 in Bangkok", "1970 in Bangkok", 7, "General");
        q.addQuestion("Excessive secretion from the pituitary gland in the children results in", "Increased Height", "Retarded Growth", "Increased Height", "Weakened Bones", "None of the above", 7, "General");
        q.addQuestion("Garampani sanctuary is located at?", "Diphu, Assam", "Junagarh, Gujarat", "Kohima, Nagaland", "Diphu, Assam", "Gangtok, Sikkim", 7, "General");

        q.addQuestion("Entomology is the science that studies?", "Insects", "Behaviour of Human Things", "Insects", "The origin of history", "The formation of rocks", 8, "General");
        q.addQuestion("Grand Central Terminal, Park Avenue, New York is the world's?", "Largest railway station", "Largest railway station", "Longest railway station", "Highest Railway Station", "None of the above", 8, "General");
        q.addQuestion("FFC stands for", "Film Finance Corporation", "Foreign Finance Corporation", "Film Finance Corporation", "Federation of Football Council", "None of the above", 8, "General");

        q.addQuestion("Golf player Vijay Singh belongs to which country?", "Fiji", "Fiji", "USA", "India", "UK", 9, "General");
        q.addQuestion("For which of the following disciplines is Nobel Prize awarded?", "All of the above", "Physiology or Medicine", "Physics and Chemistry", "Literature, Peace and Economics", "All of the above", 9, "General");
        q.addQuestion("First China War was fought between?", "China & Britain", "China & France", "China & Egypt", "China & Greece", "China & Britain", 9, "General");
    }

    public void addTelevisionQuestions() {
        q.addQuestion("What character role does Jim Parsons play in the Big Bang Theory?", "Physicist", "Physicist", "Geologist", "Historian", "Chemist", 1, "TV");
        q.addQuestion("What comedy due host the show Saturday Night Takeaway?","Ant & Dec", "Morecambe & Wise", "Ant & Dec", "French & Saunders", "Kevin & Perry", 1, "TV");
        q.addQuestion("What character does Will Smith play in The Fresh Prince of Bel Air?", "Will Smith", "Will Smith", "Carlton Banks", "Jazzy Jeff", "Philip Banks", 1, "TV");

        q.addQuestion("Which TV series did media company Netflix release in March 2017?", "13 Reasons Why", "10 Reasons Why", "11 Reasons Why", "12 Reasons Why", "13 Reasons Why", 2, "TV");
        q.addQuestion("What UK morning TV show do Philip Schofield and Holly Willoughby present?", "This Morning", "Good Morning Britain", "This Morning", "Big Body Sqaud", "Pawn Stars", 2, "TV");
        q.addQuestion("Who currently hosts the TV gameshow The Chase?", "Bradley Walsh", "Richard Osman", "Bradley Walsh", "Jimmy Carr", "Ben Shephard", 2, "TV");

        q.addQuestion("What are the trials called that celebrities take on I’m a Celebrity, Get Me Out of Here?", "Bush Tucker Trials", "Down-under Trials", "Jungle Trials", "Bush Tucker Trials", "Star Grabber Trials", 3, "TV");
        q.addQuestion("Who plays Rick Grimes in horror themed TV show The Walking Dead?", "Andrew Lincoln", "Norman Reedus", "Andrew Lincoln", "Jeffrey Dean Morgan", "Chandler Riggs", 3, "TV");
        q.addQuestion("What’s the title of the Inbetweeners episode where Simon falls off a boat into the sea?", "Field Trip", "Work Experience", "First Day", "Fashion Show", "Field Trip", 3, "TV");

        q.addQuestion("What month does the annual TV show Strictly Come Dancing begin during?", "September", "January", "September", "April", "November", 4, "TV");
        q.addQuestion("How many seasons of The Inbetweeners have ever been made?", "3", "3", "4", "5", "6", 4, "TV");
        q.addQuestion("What music festival based in Mendip, England get annual television coverage by the BBC?", "Glastonbury", "BBC Radio 1's Big Weekend", "Glastonbury", "Reading & Leeds", "T in the Park", 4, "TV");

        q.addQuestion("Who is Walter White’s meth cooking partner in the first season of Breaking Bad", "Jesse Pinkman", "Jesse Pinkman", "Gus Fring", "Hank Schrader", "Saul Goodman", 5, "TV");
        q.addQuestion("What genre is the 2011 TV show Black Mirror?", "Science Fiction", "Science Fiction", "Horror", "Thriller", "Comedy", 5, "TV");
        q.addQuestion("What TV channel was reality TV show Big Brother aired on from 2000-2010?", "Channel 4", "Channel 4", "Channel 5", "E4", "ITV", 5, "TV");

        q.addQuestion("Which female actress has won the most Oscars?", "Katherine Hepburn", "Katherine Hepburn", "Angeline Jolie", "Meryl Streep", "Sandra Bullock", 6, "TV");
        q.addQuestion("In what season of Game of Thrones does the character Ned Stark die?", "Season 1", "Season 1", "Season 2", "Season 3", "Season 4", 6, "TV");
        q.addQuestion("Who played the character the Doctor in Doctor Who from 2005 – 2010?", "David Tennant", "David Tennant", "Matt Smith", "Jodie Whittaker", "Peter Capaldi", 6, "TV");

        q.addQuestion("Which pop singer played 'Alex' in Disney Channel Show Wizards of Waverly Place?", "Selena Gomez", "Miley Cyrus", "Selena Gomez", "Ariana Grande", "Katy Perry", 7, "TV");
        q.addQuestion("Which one of these TV shows is not a Netflix Original?", "Cory in The House", "Marvels's Jessica Jones", "Orange is the New Black", "The Sinner", "Cory in The House", 7, "TV");
        q.addQuestion("Which one of these animated films has a TV series based off of itself?", "How To Train Your Dragon", "Tangled", "How To Train Your Dragon", "Jungle Book", "Inside Out", 7, "TV");

        q.addQuestion("What is the name of the Riverdale High School Newspaper in Netflix show Riverdale?", "Blue & Gold", "Gold & Green", "Red & Black", "Blue & Gold", "Pink & white", 8, "TV");
        q.addQuestion("As of March 2016, how many series of British drama Happy Valley has been released?", "2", "1", "2", "3", "4", 8, "TV");
        q.addQuestion("Who Played Brad Bellick in hit crime series Prison Break?", "Wade Williams", "Wade Williams", "Dominick Purcell", "Peter Stormare", "Mark FeuerStein", 8, "TV");

        q.addQuestion("Who was the director of Netflix original TV show The OA?", "Zal Batmanglij", "Zal Batmanglij", "Steven Spielberg", "Terrence Malick", "Ridley Scott", 9, "TV");
        q.addQuestion("How many episodes of crime TV show Person of Interest have ever been created?", "103", "103", "156", "92", "300",9, "TV");
        q.addQuestion("Who is the voice of Phineas in children animated TV show Phineas & Ferb?", "Vincent Martella", "Thomas Sangster", "Vincent Martella", "Richard O'Brien", "Mitchell Musso", 9, "TV");
    }

    public void addSportsQuestions() {
        q.addQuestion("How many seconds elapse before a boxer is deemed to be knocked out?", "10", "8", "9", "10", "11", 1, "Sport");
        q.addQuestion("Which swimming event is not part of the Olympics?", "75m", "50m", "75m", "100m", "1000m", 1, "Sport");
        q.addQuestion("What’s the maximum break in a frame of snooker?", "147", "146", "147", "148", "149", 1, "Sport");

        q.addQuestion("What is a golf handicap of zero known as?", "Scratch", "Dormie", "Scratch", "Nil", "Par", 2, "Sport");
        q.addQuestion("What is the game length of a rugby match (since 1972)?", "80 minutes", "70 minutes", "80 minutes", "90 minutes", "100 minutes", 2, "Sport");
        q.addQuestion("What is a boxer with a non-orthodox stance called?", "Southpaw", "Cackhanded", "Leftie","Southpaw", "Ringer", 2, "Sport");

        q.addQuestion("How many players are there in a rugby league side?", "13", "11", "12", "13", "14", 3, "Sport");
        q.addQuestion("Where was the first Olympics held?", "Greece", "England", "Argentina", "France", "Greece", 3, "Sport");
        q.addQuestion("Which Premier League club plays its matches at White Hart Lane?", "Tottenham Hotspur", "Tottenham Hotspur", "Arsenal", "Chelsea", "West Ham", 3, "Sport");

        q.addQuestion("Who was England’s chief coach at the 2006 FIFA World Cup?", "Sven Goran Eriksson", "Gareth Southgate", "Fabio Capello", "Sven Goran Eriksson", "Glenn Hoddle", 4, "Sport");
        q.addQuestion("What event does Tom Daily compete in for Britain?", "Diving", "Diving", "Swimming", "Water Polo", "Surfing", 4, "Sport");
        q.addQuestion("What annual competition do European golfers compete against American golfers?", "Ryder Cup", "Ryder Cup", "PGA Championship", "Masters", "Open", 4, "Sport");

        q.addQuestion("Who did Georges St Pierre fight on his return to the octagon at UFC 217?", "Michael Bisping", "Conor McGregor", "Luke Rockhold", "Yoel Romero", "Michael Bisping", 5, "Sport");
        q.addQuestion("Which country did footballer Kenny Dalglish represent?", "Scotland", "England", "Wales", "Scotland", "Northern Ireland", 5, "Sport");
        q.addQuestion("How many points is a goal in a water polo match worth?", "1 point", "1 point", "4 points", "9 points", "10 points", 5, "Sport");

        q.addQuestion("In which state was Boxer Mohammad Ali born?", "Kentucky", "California", "Florida", "Texas", "Kentucky", 6, "Sport");
        q.addQuestion("Which snooker legend had the nickname 'The Hurricane'?", "Alex Higgins", "Jimmy White", "Kirk Stevens", "Alex Higgins", "Ronnie O'Sullivan", 6, "Sport");
        q.addQuestion("How many World Matchplay titles does Phil Taylor hold?", "16", "14", "15", "16", "17", 6, "Sport");

        q.addQuestion("Who was the overall winner of the UFC’s first event?", "Royce Gracie", "Royce Gracie", "Ken Shamrock", "Gerard Gordeau", "Art Jimmerson", 7, "Sport");
        q.addQuestion("What weight category does Demetrious Johnson fight at?", "Flyweight", "Bantamweight", "Flyweight", "Featherwweight", "Lightweight", 7, "Sport");
        q.addQuestion("What the sum of treble 19, double 18 and 6 in a hand of darts?", "117", "123", "117", "137", "104", 7, "Sport");

        q.addQuestion("What is the Olympic World Record for the Mens 100m race?", "9.58 seconds", "9.58 seconds", "9.64 seconds", "9.21 seconds", "9.93 seconds", 8, "Sport");
        q.addQuestion("How many Olympic silver medals does swimmer Michael Phelps hold (2018)?", "3", "3", "6", "9", "12", 8, "Sport");
        q.addQuestion("Which of these players competed in the 2009 Premier League, but not in the 2010 Prem?", "John Part", "James Wade", "Terry Jenkins", "Raymond Van Barneveld", "John Part", 8, "Sport");

        q.addQuestion("What is the maximum weight of a standard golf ball?", "1.62 ounces", "0.62 ounces", "1.62 ounces", "2.62 ounces", "3.62 ounces", 9, "Sport");
        q.addQuestion("What year was rugby league born?", "1895", "1882", "1893", "1895", "1998", 9, "Sport");
        q.addQuestion("What was the winning score of the 1995 Masters Snooker final?", "9-3", "9-3", "9-7", "9-1", "9-6", 9, "Sport");
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public Player getCurrentPlayer() {
        return this.players.get(currentPlayer);
    }

    public void payPlayer() {
        int depositAmount = 0;
        int amount = getCurrentPlayer().getCashWon();

        switch (amount) {
            case 0: depositAmount = 1;
                break;
            case 1: case 10: case 100: case 1000: case 10000:  depositAmount = amount * 10;
                break;
            case 100000: depositAmount = 250000;
                break;
            case 250000: depositAmount = 500000;
                break;
            default: depositAmount = 1000000;
                break;
        }

        getCurrentPlayer().setCashWon(depositAmount);
    }

    public void changePlayer() {
        /*Increment index in player array
        * unless play is player 3 in which case
        * set current player to 0*/
        if (players.size() > 1) {
            if (currentPlayer + 1 > players.size() - 1) {
                currentPlayer = 0;
            } else {
                currentPlayer += 1;
            }
        } else {
            currentPlayer = 0;
        }
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public void removePlayer() {
        this.players.remove(currentPlayer);
    }

    public void getQuestion(String category) {
        try {
            int complexity = players.get(currentPlayer).getQuestionComplexity();
            this.currentQuestion.add(q.getQuestion(complexity, category));

            if (currentQuestion.size() > 1) {
                currentQuestion.remove(0);
            }
        } catch (Exception e) {
            System.out.println("No questions left");
        }
    }

    public Question getCurrentQuestion() {
        return this.currentQuestion.get(0);
    }

    public void setCurrentCategory(String currentCategory) {
        this.currentCategory = currentCategory;
    }

    public String getCurrentCategory() {
        return currentCategory;
    }

    public void playSound(String fileName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
        }
    }
}
