//Program to create a real time question generator quiz competition in various topics with timer included
#include <iostream>
#include <cstdlib>
#include <thread>
#include <chrono>
#include <ctime>
#include <vector>
#include <algorithm>
#include <cctype>
#include <string>
#include <future>

using namespace std;
using namespace std::chrono;

// Base class representing contestant data.
class contest {
protected:
    int s;       // Score.
    float t;     // Total answering time (tie-breaker).
    string name;
    char ans[5]; // Answers for 5 questions.
public:
    contest() : s(0), t(0.0) {
        for (int i = 0; i < 5; i++)
            ans[i] = 'z';
    }
    void readco() {
        cout << "Enter the participant's name: ";
        getline(cin, name);
    }
    // Public getter to allow safe access to the name.
    string getName() const {
        return name;
    }
    void displayResults() const {
        cout << "Name: " << name << "\nScore: " << s 
             << "\nTotal Time: " << t << " seconds\n";
    }
};

// Derived class that handles quiz questions and topics.
class question : public contest {
public:
    // Choose the topic based on participant selection.
    void ques(char topic) {
        cout << "\033[2J\033[H"; // Clear screen,only applicable for windows terminal.
        switch(toupper(topic)) {
            case 'A': sci(); break;
            case 'B': rid(); break;
            case 'C': his(); break;
            case 'D': poli(); break;
            case 'E': spo(); break;
            default:
                cout << "Invalid topic selection!\n";
                break;
        }
    }
private:
    // Helper function that reads an answer with a live countdown.
    // Returns the answer (or default 'z' if time expires)
    // and assigns the elapsed time (capped at 15 seconds) into timeTaken.
    char getAnswerWithCountdown(double &timeTaken) {
        // Launch async task to read a character from input.
        future<char> fut = async(launch::async, [](){
            char input;
            cin >> input;
            return input;
        });
        
        int timeLeft = 15;
        auto start = steady_clock::now();
        char answer = 'z';
        bool answered = false;
        // Countdown loop: update every second.
        for(; timeLeft > 0; timeLeft--) {
            cout << "\rTime left: " << timeLeft << " seconds " << flush;
            // Wait 1 second or until input is ready.
            if(fut.wait_for(chrono::seconds(1)) == future_status::ready) {
                answer = fut.get();
                answered = true;
                break;
            }
        }
        if (!answered)
            cout << "\nTime's up! Moving on to the next question.\n";
        auto end = steady_clock::now();
        timeTaken = duration_cast<seconds>(end - start).count();
        if (timeTaken > 15)
            timeTaken = 15;
        cout << "\n";
        return answer;
    }
    
    // Science Topic Function.
    void sci() {
        vector<string> ar = {
            "Why doesn't the Earth fall into the Sun if gravity pulls it?\n"
            "A. The Sun is too far to pull Earth\n"
            "B. Earth is moving sideways fast enough to keep orbiting\n"
            "C. Earth is heavier than the Sun\n"
            "D. The Moon pulls Earth away\n",

            "If you could travel at the speed of light, would time stop for you?\n"
            "A. Yes, time would freeze for you\n"
            "B. No, time would go faster\n"
            "C. You would age twice as fast\n"
            "D. Time would reverse\n",

            "Can plants 'hear' or 'talk' to each other?\n"
            "A. No, they are silent and unaware\n"
            "B. Only through touch\n"
            "C. Yes, through chemical signals\n"
            "D. Only if they are in the same pot\n",

            "Why do we see lightning before we hear thunder?\n"
            "A. Light is brighter than sound\n"
            "B. Lightning happens first\n"
            "C. Sound travels slower than light\n"
            "D. Thunder is farther away\n",

            "What would happen if you dug a hole through the Earth to the other side?\n"
            "A. You'd fall through and shoot out the other side\n"
            "B. You'd float at the center forever\n"
            "C. You'd burn up from the heat and pressure\n"
            "D. All of the above could happen\n",

            "Which planet rotates in the opposite direction to most planets in our solar system?\n"
            "A) Earth\nB) Venus\nC) Mars\nD) Jupiter\n",

            "Who was the first scientist to open the concept of quantum mechanics?\n"
            "A. Schrodinger\nB. Planck\nC. Einstein\nD. Bohr\n",

            "What is the key principle behind quantum computing that allows qubits to represent both 0 and 1 simultaneously?\n"
            "A. Quantum Tunneling\nB. Superposition\nC. Entanglement\nD. Duality\n"
        };
        vector<char> correct = { 'B', 'A', 'C', 'C', 'D', 'B', 'B', 'B' };
        vector<int> indices = {0, 1, 2, 3, 4, 5, 6, 7};
        random_shuffle(indices.begin(), indices.end());
        
        for (int i = 0; i < 5; i++) {
            int qIndex = indices[i];
            cout << "Question " << i + 1 << ". " << ar[qIndex] << "\n";
            cout << "Type your option (A/B/C/D): ";
            double timeTaken = 0;
            ans[i] = getAnswerWithCountdown(timeTaken);
            t += timeTaken;
            int marksAwarded = (i == 4) ? 10 : 5;
            if (toupper(ans[i]) == correct[qIndex])
                s += marksAwarded;
            cout << "\nYou answered: " << ans[i] << " in " << timeTaken 
                 << " seconds.\nPress Enter to continue...";
            cin.ignore();
            cout << "\033[2J\033[H";
        }
    }
    
    // Riddles Topic Function.
    void rid() {
        vector<string> ar = {
            "I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. Who am I?\n"
            "A) Echo\nB) Shadow\nC) Sound\nD) Whisper\n",

            "I'm not alive, but I grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I?\n"
            "A) Fire\nB) Plant\nC) Cloud\nD) Rock\n",

            "The more of this there is, the less you see. What is it?\n"
            "A) Fog\nB) Light\nC) Darkness\nD) Smoke\n",

            "What has keys but can't open locks?\n"
            "A) Keyboard\nB) Piano\nC) Map\nD) Code\n",

            "What has a head, a tail, is brown, and has no legs?\n"
            "A) Snake\nB) Coin\nC) Lizard\nD) Dog\n",

            "What comes once in a minute, twice in a moment, but never in a thousand years?\n"
            "A) Letter M\nB) Letter O\nC) Letter N\nD) Hour\n",

            "What building has the most stories?\n"
            "A) Library\nB) Hospital\nC) Bank\nD) Skyscraper\n",

            "What can travel around the world while staying in a corner?\n"
            "A) Stamp\nB) Satellite\nC) Radio\nD) Wind\n"
        };
        vector<char> correct = { 'A', 'A', 'C', 'B', 'B', 'A', 'A', 'A' };
        vector<int> indices = {0, 1, 2, 3, 4, 5, 6, 7};
        random_shuffle(indices.begin(), indices.end());
        
        for (int i = 0; i < 5; i++) {
            int qIndex = indices[i];
            cout << "Question " << i + 1 << ". " << ar[qIndex] << "\n";
            cout << "Type your option (A/B/C/D): ";
            double timeTaken = 0;
            ans[i] = getAnswerWithCountdown(timeTaken);
            t += timeTaken;
            int marksAwarded = (i == 4) ? 10 : 5;
            if (toupper(ans[i]) == correct[qIndex])
                s += marksAwarded;
            cout << "\nYou answered: " << ans[i] << " in " << timeTaken 
                 << " seconds.\nPress Enter to continue...";
            cin.ignore();
            cout << "\033[2J\033[H";
        }
    }
    
    // History Topic Function.
    void his() {
        vector<string> ar = {
            "1) Why was the Warsaw Pact declared by the USSR?\n"
            "A) To gain strength from Western nations\nB) To protest against NATO\nC) To reduce conflict of world war 2\nD) To join hands with USA\n",

            "2) Which among the following is not run by a communist government?\n"
            "A) China\nB) Cuba\nC) South Korea\nD) Vietnam\n",

            "3) Highest authorised person among the following is ____.\n"
            "A) Mayor\nB) Deputy Mayor\nC) Tahsildar\nD) Sarpanch\n",

            "4) When was RSS Party formed ?\n"
            "A) 1925\nB) 1950\nC) 1963\nD) 1948\n",

            "5) Who among the following ruled France more longer?\n"
            "A) Philip IV\nB) Louis XIV\nC) Napoleon Bonaparte\nD) Charles VII\n",

            "6) Who was the last Indian King of India?\n"
            "A) Bahadurshah Zafar\nB) Louis Mountbatten\nC) Chandragupta Maurya\nD) Maharaj Hari Singh\n"
        };
        // Correct answers as provided.
        vector<char> correct = { 'B', 'C', 'C', 'A', 'B', 'D' };
        // We have 6 questions; shuffle and present 5.
        vector<int> indices = {0, 1, 2, 3, 4, 5};
        random_shuffle(indices.begin(), indices.end());
        
        for (int i = 0; i < 5; i++) {
            int qIndex = indices[i];
            cout << "Question " << i + 1 << ". " << ar[qIndex] << "\n";
            cout << "Type your option (A/B/C/D): ";
            double timeTaken = 0;
            ans[i] = getAnswerWithCountdown(timeTaken);
            t += timeTaken;
            int marksAwarded = (i == 4) ? 10 : 5;
            if (toupper(ans[i]) == correct[qIndex])
                s += marksAwarded;
            cout << "\nYou answered: " << ans[i] << " in " << timeTaken 
                 << " seconds.\nPress Enter to continue...";
            cin.ignore();
            cout << "\033[2J\033[H";
        }
    }
    
    // Politics Topic Function.
    void poli() {
        vector<string> ar = {
            "Who is known as the 'Father of the Nation' in India?\n"
            "A) Jawaharlal Nehru\nB) Mahatma Gandhi\nC) Sardar Patel\nD) Subhas Chandra Bose\n",

            "In which year did India gain independence?\n"
            "A) 1945\nB) 1947\nC) 1950\nD) 1952\n",

            "Who was the first Prime Minister of India?\n"
            "A) Mahatma Gandhi\nB) Indira Gandhi\nC) Jawaharlal Nehru\nD) Rajiv Gandhi\n",

            "Which article of the Indian Constitution guarantees freedom of speech?\n"
            "A) Article 14\nB) Article 19\nC) Article 21\nD) Article 32\n",

            "Which political party was founded in Tamil Nadu and is a major player in regional politics?\n"
            "A) DMK\nB) AIADMK\nC) MDMK\nD) PMK\n",

            "Who was known for the slogan 'Garibi Hatao'?\n"
            "A) Atal Bihari Vajpayee\nB) Lal Bahadur Shastri\nC) Indira Gandhi\nD) Rajiv Gandhi\n",

            "Which international organization did India join as a founding member?\n"
            "A) NATO\nB) United Nations\nC) SAARC\nD) OPEC\n",

            "Who was known as the 'Iron Man of India'?\n"
            "A) Sardar Vallabhbhai Patel\nB) Lal Bahadur Shastri\nC) Atal Bihari Vajpayee\nD) None of these\n"
        };
        vector<char> correct = { 'B', 'B', 'C', 'B', 'B', 'C', 'B', 'A' };
        vector<int> indices = {0, 1, 2, 3, 4, 5, 6, 7};
        random_shuffle(indices.begin(), indices.end());
        
        for (int i = 0; i < 5; i++) {
            int qIndex = indices[i];
            cout << "Question " << i + 1 << ". " << ar[qIndex] << "\n";
            cout << "Type your option (A/B/C/D): ";
            double timeTaken = 0;
            ans[i] = getAnswerWithCountdown(timeTaken);
            t += timeTaken;
            int marksAwarded = (i == 4) ? 10 : 5;
            if (toupper(ans[i]) == correct[qIndex])
                s += marksAwarded;
            cout << "\nYou answered: " << ans[i] << " in " << timeTaken 
                 << " seconds.\nPress Enter to continue...";
            cin.ignore();
            cout << "\033[2J\033[H";
        }
    }
    
    // Sports Topic Function.
    void spo() {
        vector<string> ar = {
            "Which legendary Indian Grandmaster, born in Tamil Nadu, became India's first chess world champion?\n"
            "A) Praggnanandhaa R\nB) Pentala Harikrishna\nC) Viswanathan Anand\nD) Koneru Humpy\n",

            "Who is the first Indian to win an individual Olympic gold medal?\n"
            "A) Rajyavardhan Singh Rathore\nB) Abhinav Bindra\nC) P. V. Sindhu\nD) Neeraj Chopra\n",

            "Jallikattu, a traditional bull-taming sport, is primarily conducted in which Tamil Nadu districts?\n"
            "A) Chennai and Coimbatore\nB) Madurai and Tiruchirappalli\nC) Salem and Erode\nD) Thanjavur and Kanchipuram\n",

            "Which Indian cricketer holds the record for the highest individual score in Test cricket?\n"
            "A) Sachin Tendulkar\nB) Rahul Dravid\nC) Virender Sehwag\nD) Rohit Sharma\n",

            "Who was the first Tamil Nadu cricketer to captain the Indian Test team?\n"
            "A) Dinesh Karthik\nB) Krishnamachari Srikkanth\nC) R. Ashwin\nD) Murali Vijay\n",

            "In professional football, how many substitutions are allowed per team in regular time as per FIFA's latest rules?\n"
            "A) 3\nB) 4\nC) 5\nD) 6\n",

            "In which sport is the 'Green Jacket' awarded to the winner of a prestigious tournament?\n"
            "A) Tennis\nB) Golf\nC) Formula 1\nD) Snooker\n"
        };
        vector<char> correct = { 'C', 'B', 'B', 'C', 'B', 'C', 'B' };
        vector<int> indices = {0, 1, 2, 3, 4, 5, 6};
        random_shuffle(indices.begin(), indices.end());
        
        for (int i = 0; i < 5; i++) {
            int qIndex = indices[i];
            cout << "Question " << i + 1 << ". " << ar[qIndex] << "\n";
            cout << "Type your option (A/B/C/D): ";
            double timeTaken = 0;
            ans[i] = getAnswerWithCountdown(timeTaken);
            t += timeTaken;
            int marksAwarded = (i == 4) ? 10 : 5;
            if (toupper(ans[i]) == correct[qIndex])
                s += marksAwarded;
            cout << "\nYou answered: " << ans[i] << " in " << timeTaken 
                 << " seconds.\nPress Enter to continue...";
            cin.ignore();
            cout << "\033[2J\033[H";
        }
    }
};

// Introductory function
void intro() {
    cout << "Welcome to the Quiz Competition, fellow candidates!\n\n";
    cout << "Rules:\n"
         << "1) There are 5 topics. Select any one. Each topic has a pool of questions, and you'll be given 5 random questions from that topic.\n"
         << "   You have 15 seconds to answer each question. If you answer before time is up, the quiz moves on immediately.\n"
         << "2) Time taken to answer is recorded as a tie-breaker (less time is better).\n"
         << "3) For each correct answer, you earn 5 marks, except the bonus question (5th question) which carries 10 marks.\n"
         << "4) The candidate with the highest marks—and in case of a tie, the lower total answering time—will be declared the winner.\n"
         << "5) No rewards for 2nd or 3rd positions.\n\n";
    this_thread::sleep_for(chrono::seconds(20));
    cout << "\033[2J\033[H";
}

int main() {
    srand(time(0)); // Seed the random number generator.
    intro();
    
    int n;
    char topic;
    cout << "Enter the number of participants: ";
    cin >> n;
    cin.ignore();
    
    vector<question> contestants(n);
    cout << "Register your names:\n";
    for (int i = 0; i < n; i++) {
        cout << "For participant " << i + 1 << ":\n";
        contestants[i].readco();
    }
    
    // Each participant selects a topic and takes the quiz.
    for (int i = 0; i < n; i++) {
    redo:
        cout << "Participant " << i + 1 << " (" << contestants[i].getName() 
             << "), select a topic:\n"
             << "A) SCIENCE\n"
             << "B) RIDDLES\n"
             << "C) HISTORY\n"
             << "D) POLITICS\n"
             << "E) SPORTS\n";
        cin >> topic;
        if (toupper(topic) == 'A' || toupper(topic) == 'B' || toupper(topic) == 'C' ||
            toupper(topic) == 'D' || toupper(topic) == 'E') {
            contestants[i].ques(topic);
        } else {
            cout << "Invalid option, please reselect.\n";
            goto redo;
        }
    }
    
    // Display final results.
    cout << "\nQuiz Completed! Here are the results:\n";
    for (int i = 0; i < n; i++) {
        cout << "\nParticipant " << i + 1 << ":\n";
        contestants[i].displayResults();
    }
    
    return 0;
}
