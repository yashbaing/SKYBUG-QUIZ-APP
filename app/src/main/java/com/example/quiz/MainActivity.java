package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Modelclass> list;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list=new ArrayList<>();

        databaseReference= FirebaseDatabase.getInstance().getReference("Question");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                
                for (DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    Modelclass modelclass=dataSnapshot.getValue(Modelclass.class);
                    list.add(modelclass);
                }

                Intent intent= new Intent(MainActivity.this,DashboardActivity.class);
                startActivity(intent);

                
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


 // Question 1
        list.add(new Modelclass("Which of the following cities has the largest population",

                "Pune",
                "Delhi",
                "Mumbai ",
                "Bangalore",
                "Mumbai"));


// Question 2
        list.add(new Modelclass("What is the capital city of Germany?",
                "Berlin",
                "Paris",
                "London",
                "Rome",
                "Berlin"));

// Question 3
        list.add(new Modelclass("Which river is the longest in the world?",

                "Amazon",
                "Yangtze",
                "Mississippi",
                "Nile",
                "Nile"));

// Question 4
        list.add(new Modelclass("Who is the author of 'To Kill a Mockingbird'?",
                "Harper Lee",
                "J.K. Rowling",
                "George Orwell",
                "Ernest Hemingway",
                "Harper Lee"));

// Question 5
        list.add(new Modelclass("Which country is known as the 'Land of the Rising Sun'?",

                "China",
                "South Korea",
                "Japan",
                "Vietnam",
                "Japan"));

// Question 6
        list.add(new Modelclass("What is the largest mammal on land?",

                "Giraffe",
                "Elephant",
                "Hippopotamus",
                "Rhinoceros",
                "Elephant"));

// Question 7
        list.add(new Modelclass("In which year did the World War II end?",
                "1945",
                "1939",
                "1941",
                "1943",
                "1945"));

// Question 8
        list.add(new Modelclass("Which planet is known as the 'Blue Planet'?",

                "Mars",
                "Venus",
                "Jupiter",
                "Earth",
                "Earth"));

// Question 9
        list.add(new Modelclass("Who painted the Mona Lisa?",

                "Vincent van Gogh",
                "Leonardo da Vinci",
                "Pablo Picasso",
                "Claude Monet",
                "Leonardo da Vinci"));

// Question 10
        list.add(new Modelclass("Which country is famous for the Taj Mahal?",
                "India",
                "Egypt",
                "Turkey",
                "China",
                "India"));

// Question 11
        list.add(new Modelclass("What is the primary programming language used in Android development?",
                "Java",
                "Python",
                "Kotlin",
                "C++",
                "Kotlin"));

// Question 12
        list.add(new Modelclass("In Android development, what does 'ADB' stand for?",
                "Android Development Box",
                "Application Development Board",
                "Advanced Development Bundle",
                "Android Debug Bridge",
                "Android Debug Bridge"));

// Question 13
        list.add(new Modelclass("What layout manager is used to arrange elements in a grid in Android XML?",
                "LinearLayout",
                "FrameLayout",
                "GridLayout",
                "RelativeLayout",
                "GridLayout"));

// Question 14
        list.add(new Modelclass("Which file is used to store string resources in Android?",
                "resources.xml",
                "values.xml",
                "strings.xml",
                "text.xml",
                "strings.xml"));

// Question 15
        list.add(new Modelclass("In Android, what is the purpose of the 'AndroidManifest.xml' file?",
                "Define app permissions and components",
                "Store user data",
                "Manage layout files",
                "Define app colors",
                "Define app permissions and components"));

// Question 16
        list.add(new Modelclass("What is the Android component responsible for managing the app's user interface?",
                "ContentProvider",
                "Service",
                "BroadcastReceiver",
                "Activity",
                "Activity"));

// Question 17
        list.add(new Modelclass("Which keyword is used to indicate that a variable can be accessed by the entire application in Kotlin?",
                "private",
                "internal",
                "protected",
                "public",
                "internal"));

// Question 18
        list.add(new Modelclass("What is the purpose of the 'findViewById()' method in Android development?",
                "Start a new activity",
                "Retrieve a view element from the XML layout",
                "Load an image resource",
                "Handle button clicks",
                "Retrieve a view element from the XML layout"));

// Question 19
        list.add(new Modelclass("Which file is used to specify the version and configuration of Gradle in an Android project?",
                        "build.xml",
                        "gradle.properties",
                        "settings.gradle",
                        "build.gradle",
                        "build.gradle"));

// Question 20
        list.add(new Modelclass("In Android, what is the purpose of the 'R.java' file?",
                "Configuration file for Gradle",
                "Executable file for the app",
                "None of Above",
                "Java source code for the app",
                "None of Above"));




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(MainActivity.this,DashboardActivity.class);
                startActivity(intent);

            }
        },1500);
    }
}